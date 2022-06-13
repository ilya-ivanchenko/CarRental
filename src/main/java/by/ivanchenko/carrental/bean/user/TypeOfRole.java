package by.ivanchenko.carrental.bean.user;

public enum TypeOfRole {
    UNKNOWN(1, "unknown"), CUSTOMER(2,"customer"), MANAGER(3,"manager"), ADMIN(4,"admin");

    private int id;
    private String name;

    TypeOfRole(int id, String name) {
        this.id = id;
        this.name = name;

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


}
