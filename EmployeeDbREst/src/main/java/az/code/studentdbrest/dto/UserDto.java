package az.code.studentdbrest.dto;

import az.code.studentdbrest.models.Role;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@Builder
@ToString(exclude = "roles")
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private List<RoleDto>roles;

}
