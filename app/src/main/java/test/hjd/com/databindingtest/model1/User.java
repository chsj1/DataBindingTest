package test.hjd.com.databindingtest.model1;

/**
 * Created by allen on 2019-09-04.
 */
public class User {
    public String name;
    public String age;
    public float salary;

    public User(String name, String age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
