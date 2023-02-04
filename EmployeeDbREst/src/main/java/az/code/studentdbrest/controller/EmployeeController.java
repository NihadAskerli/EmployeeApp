package az.code.studentdbrest.controller;

import az.code.studentdbrest.dto.EmployeeDto;
import az.code.studentdbrest.dto.TaskDto;
import az.code.studentdbrest.dto.UserDto;
import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.models.Task;
import az.code.studentdbrest.models.User;
import az.code.studentdbrest.service.inter.EmployeeAndTaskServiceInter;
import az.code.studentdbrest.service.inter.UserServiceInter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final ObjectMapper objectMapper;
 private final EmployeeAndTaskServiceInter employeeAndTaskServiceInter;
    private final UserServiceInter userServiceInter;


    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeAndTaskServiceInter.save(objectMapper.convertValue(employeeDto, Employee.class))
                        , EmployeeDto.class));

    }

    @GetMapping("/")
    @Secured("USER")
    public ResponseEntity<List> getAllEmpployee() {
        return ResponseEntity.ok(employeeAndTaskServiceInter.getAllEmployee());
    }

    @DeleteMapping("/remove/{id}")
    @Secured("SUPERVISOR")
    public void deleteById(@PathVariable("id") Long id) {
        employeeAndTaskServiceInter.remove(id);
    }

    @GetMapping("/{id}")
    @Secured("USER")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(objectMapper.convertValue(employeeAndTaskServiceInter.getById(id), EmployeeDto.class));
    }
    @PutMapping
    @Secured("SUPERVISOR")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeAndTaskServiceInter
                        .save(objectMapper.convertValue(employeeDTO, Employee.class)),EmployeeDto.class));
    }
    @PostMapping("/tasks")
    @Secured("SUPERVISOR")
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeAndTaskServiceInter.saveTask(objectMapper.convertValue(taskDto, Task.class))
                        , TaskDto.class));

    }
    @GetMapping("/tasks")
    @Secured("USER")
    public ResponseEntity<List> getAllTask() {
        return ResponseEntity.ok(employeeAndTaskServiceInter.getAllTask());
    }
    @DeleteMapping("/remove/tasks/{id}")
    @Secured("ADMIN")
    public void deleteByIdTask(@PathVariable("id") Long id) {
        employeeAndTaskServiceInter.removeTask(id);
    }

    @GetMapping("/task/{id}")
    @Secured("USER")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) {
        return ResponseEntity.ok(objectMapper.convertValue(employeeAndTaskServiceInter.getByIdTask(id), TaskDto.class));
    }
    @PutMapping("/task")
    @Secured("ADMIN")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeAndTaskServiceInter
                        .saveTask(objectMapper.convertValue(taskDto, Task.class)),TaskDto.class));
    }
    @PostMapping("/users")
//    @Secured("USER")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(objectMapper
                .convertValue(userServiceInter.addUser(objectMapper.convertValue(userDto, User.class))
                        , UserDto.class));

    }
    @GetMapping("/users")
//    @Secured("SUPERVISOR")
    public ResponseEntity<List> getUser() {
        return ResponseEntity.ok(userServiceInter.getAllUsers());

    }
    @GetMapping("/users/{id}")
    @Secured("USER")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(objectMapper.convertValue(userServiceInter.getById(id), UserDto.class));
    }

}

