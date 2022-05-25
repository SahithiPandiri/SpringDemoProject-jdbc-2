package spring.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="payroll")
public class Payroll {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;
    @NotNull(message="is required")
    @Min(value=0, message="must be greater than or equal to zero")
    @Column(name="salary")
    int salary;

    public Payroll() {
    }

    public Payroll(int user_id, int salary) {
        this.user_id = user_id;
        this.salary = salary;

    }

    public Payroll(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

