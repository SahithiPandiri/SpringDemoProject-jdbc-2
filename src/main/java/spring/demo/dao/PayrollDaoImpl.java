package spring.demo.dao;
import spring.demo.entity.Payroll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class PayrollDaoImpl implements PayrollDao {
private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public PayrollDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Payroll> getAccounts() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Payroll> query= currentSession.createQuery("from Payroll order by salary",Payroll.class);
        List<Payroll> accounts=query.getResultList();
        return accounts;
    }

    @Override
    public Payroll getEmployee(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Payroll.class,id);
    }

    @Override
    public String saveAccount(Payroll payroll) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(payroll);
        return "Successfull";
    }

}
