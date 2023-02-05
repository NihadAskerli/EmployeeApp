package az.code.studentdbrest.dto;

public enum  RoleDto {
    ADMIN("ADMIN"),
    USER("ADMIN"),
    SUPERVISOR("SUPERVISOR");

    private final String role;

    RoleDto(String role) {
        this.role = role;
    }
}
