package az.code.studentdbrest.models;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ADMIN("ADMIN"),
    USER("ADMIN"),
    SUPERVISOR("SUPERVISOR");

    private final String role;

    Role(String role) {
        this.role = role;
    }


}
