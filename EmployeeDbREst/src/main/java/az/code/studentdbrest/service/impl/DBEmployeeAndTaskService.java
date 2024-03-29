package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.models.Task;
import az.code.studentdbrest.repo.EmployeeDataRepo;
import az.code.studentdbrest.repo.TaskDataRepo;
import az.code.studentdbrest.service.inter.EmployeeAndTaskServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DBEmployeeAndTaskService implements EmployeeAndTaskServiceInter {
    private final EmployeeDataRepo employeeDataRepo;
    private final TaskDataRepo taskDataRepo;

    @Override
    public Employee save(Employee employee) {
        return employeeDataRepo.save(employee);
    }
    @Override
    public List<Employee> getAllEmployee() {
        return employeeDataRepo.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeDataRepo.findById(id).get();
    }

    @Override
    public Employee remove(Long id) {
        employeeDataRepo.delete(getById(id));
        return getById(id);
    }
    @Override
    public List<Employee> search(String name, Integer page, Integer size) {
        return employeeDataRepo.findByName(name, PageRequest.of(page, size, Sort.by(name).ascending()));

    }

    @Override
    public List<Task> getAllTask() {
        return taskDataRepo.findAll();
    }

    @Override
    public Task getByIdTask(Long id) {
        return taskDataRepo.findById(id).get();
    }

    @Override
    public Task removeTask(Long id) {
        taskDataRepo.delete(getByIdTask(id));
        return getByIdTask(id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskDataRepo.save(task);
    }

}
