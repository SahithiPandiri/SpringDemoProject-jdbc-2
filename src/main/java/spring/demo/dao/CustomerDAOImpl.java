package spring.demo.dao;

import spring.demo.entity.Payroll;
import spring.demo.entity.users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public CustomerDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<users> getCustomers() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<users> query= currentSession.createQuery("from users order by last_name", users.class);
        List<users> users =query.getResultList();
        return users;
    }

    @Override

    public void saveCustomer1(users theUsers, String pass) {
        Session currentSession = entityManager.unwrap(Session.class);
       currentSession.saveOrUpdate(theUsers);
       int id=theUsers.getUser_id();
       System.out.println(pass);
        Query<users> query=currentSession.createQuery("update users set password=:pass" + " where user_id= :id " );
        query.setParameter("pass",pass);
        query.setParameter("id",id);
        query.executeUpdate();

    }

    @Override
    public users getCustomer(String username) {
        Session currentSession =entityManager.unwrap(Session.class);
        Query<users> query=currentSession.createQuery("from users where user_name=:username",users.class);
        query.setParameter("username",username);
        return query.uniqueResult();

    }

    @Override
    public void saveCustomer3(users theUsers, String uname, String fname, String lname) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theUsers);
        int id=theUsers.getUser_id();
        System.out.println(uname);
        Query<users> query=currentSession.createQuery("update users set user_name=:uname" + " where user_id= :id " );
        query.setParameter("uname",uname);
        query.setParameter("id",id);
        query.executeUpdate();
        currentSession = entityManager.unwrap(Session.class);
        query=currentSession.createQuery("update users set first_name=:fname" + " where user_id= :id " );
        query.setParameter("fname",fname);
        query.setParameter("id",id);
        query.executeUpdate();
        currentSession = entityManager.unwrap(Session.class);
        query=currentSession.createQuery("update users set last_name=:lname" + " where user_id= :id " );
        query.setParameter("lname",lname);
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public users getCustomer(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(users.class,id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Payroll payroll=currentSession.get(Payroll.class,id);
      users theUsers =currentSession.get(users.class,id);
        currentSession.delete(theUsers);
        currentSession.delete(payroll);
    }
    @Override

    public void saveCustomer(users theUsers) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theUsers);

    }

}
