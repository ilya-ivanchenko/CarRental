package by.ivanchenko.carrental.bean.user;

import java.util.Objects;

public class User {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private String password;      // пароль не хранить больше чем для авторизации
    private String email;
    private int role;



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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getRole() {    //   public Role getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User() {
    }

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public User(String email, String password, int role) {
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public User( String name, String surname, String phone, String password, String email, int role) {
       setName(name);
       setSurname(surname);
       setPhone(phone);
       setPassword(password);
       setEmail(email);
       setRole(role);
    }

    public User(int id, String name, String surname, String phone, String password, String email, int role) {
        setId(id);
        setName(name);
        setSurname(surname);
        setPhone(phone);
        setPassword(password);
        setEmail(email);
        setRole(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname)
                && Objects.equals(phone, user.phone) && Objects.equals(password, user.password)
                && Objects.equals(email, user.email) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone, password, email, role, id);
    }
}

