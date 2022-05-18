package spring.demo.entity;

//import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int user_id;
    @Column(name = "user_name")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    String user_name;
    @Column(name = "password")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    String password;
    @Column(name="enabled")
    int enabled=1;
    @Column(name="role")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    String role;
    @Column(name = "first_name")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String first_name;
    @Column(name = "last_name")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String last_name;

    public users() {
    }

    public users(int user_id, String user_name, String password, int enabled, String role, String first_name, String last_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
