import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private Double age;
    private String phone;
    private LocalDate dateOfBirthday;
    private Double salary;

    public User() {
    }

    public User(int id, String name, Double age, String phone, LocalDate dateOfBirthday, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", salary=" + salary +
                '}';
    }
}
