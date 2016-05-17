package pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by KIRILL on 08.05.2016.
 */
@Entity                   //  annotation describe DB table how javaclass
@Table(name = "Meal")       //  table name
public class Meal {

    @Id
    @Column(name = "mealId")      //autoincrement identify explicitly column
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // value autogenerate
    private int id;

    @Column(name = "mealName")
    private String mealName;

    @Column(name = "mealPrice")
    private int mealPrice;

    @Column(name = "mealTime")
    private int mealTime;

    @Column(name = "mealConsist")
    private String mealConsist;

    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Meal_Order",
            joinColumns = {
                    @JoinColumn(name = "mealId", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "userId", nullable = false, updatable = false)
            })
    private Set<User> users = new HashSet<User>(0);

    public Set<User> getUsers() {return users;}
    public void setUsers(Set<User> users) {this.users = users;}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(int mealPrice) {
        this.mealPrice = mealPrice;
    }

    public int getMealTime() {
        return mealTime;
    }

    public void setMealTime(int mealTime) {
        this.mealTime = mealTime;
    }

    public String getMealConsist() {
        return mealConsist;
    }

    public void setMealConsist(String mealConsist) {
        this.mealConsist = mealConsist;
    }



}
