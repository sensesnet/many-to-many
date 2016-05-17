package pojos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by KIRILL on 08.05.2016.
 */
@Entity                   //  annotation describe DB table how javaclass
@Table(name = "User")       //  table name

public class User {

    @Id
    @Column(name = "userId")      //autoincrement identify explicitly column
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // value autogenerate
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secongName")
    private String secongName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Meal> meals = new HashSet<Meal>(0);

    public Set<Meal> getMeals() {return meals;}
    public void setMeals(Set<Meal> meals) {this.meals = meals;}




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecongName() {
        return secongName;
    }

    public void setSecongName(String secongName) {
        this.secongName = secongName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secongName='" + secongName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
