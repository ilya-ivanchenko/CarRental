package by.ivanchenko.carrental.bean.user;

public class Role {

    private TypeOfRole typeOfRole;

    public Role(TypeOfRole typeOfRole){
        this.typeOfRole = typeOfRole;

    }

    public Role(){
        this.typeOfRole = TypeOfRole.UNKNOWN;
    }

// еще конструкторы?

    public TypeOfRole getTypeOfRole() {
        return typeOfRole;
    }

    public void setTypeOfRole(TypeOfRole typeOfRole) {
        this.typeOfRole = typeOfRole;
    }


}
