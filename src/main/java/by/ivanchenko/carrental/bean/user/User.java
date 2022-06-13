package by.ivanchenko.carrental.bean.user;

public class User {

    private String name;
    private String surname;
    private String phone;
    private String login;
    private String password;      // пароль не хранить больше чем для авторизации
    private String email;
    private Role role;
    private int id;


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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//конструкторы, какие?
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        //this.role = new Role();

    }

    public User(String name, String surname, String phone, String login, String password, String email, Role role) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}

