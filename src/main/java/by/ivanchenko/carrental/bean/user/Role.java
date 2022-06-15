package by.ivanchenko.carrental.bean.user;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {
    // private static final long serialVersionUID = 42L;

    private TypeOfRole typeOfRole;

    public Role(){
        this.typeOfRole = TypeOfRole.UNKNOWN;
        typeOfRole.setId(1);
    }
    public Role(TypeOfRole typeOfRole){
        this.typeOfRole = typeOfRole;
        typeOfRole.setId(typeOfRole.getId());

    }

    public Role(String role, int id) {

///

        for (TypeOfRole type: typeOfRole.name()) {
            if (type.getName().equals(role)){
                this.typeOfRole = type;
            } else {
                this.typeOfRole = typeOfRole.UNKNOWN;
            }
        }
        typeOfRole.setId(id);
    }

    public TypeOfRole getTypeOfRole() {
        return typeOfRole;
    }

    public void setTypeOfRole(TypeOfRole typeOfRole) {
        this.typeOfRole = typeOfRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "typeOfRole=" + typeOfRole.toString() +
                "id_role=" + typeOfRole.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
            return typeOfRole == role.typeOfRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfRole);
    }
}
