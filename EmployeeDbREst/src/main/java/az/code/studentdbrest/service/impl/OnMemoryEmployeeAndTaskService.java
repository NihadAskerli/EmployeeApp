package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.models.Task;
import az.code.studentdbrest.service.inter.EmployeeAndTaskServiceInter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Profile("Memory")
public class OnMemoryEmployeeAndTaskService implements EmployeeAndTaskServiceInter {
    private List<Task>taskList=new ArrayList<>();
    private List<Employee> employeeList = new ArrayList<>();
    private AtomicLong atomicLong = new AtomicLong(0);
    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee getById(Long id) {
        return employeeList.stream().filter(item->item.getId()==id).findAny().get();
    }

    @Override
    public Employee remove(Long id) {
        employeeList.remove(getById(id));
        return getById(id);
    }

    @Override
    public Employee save(Employee employee) {
        employee.setId(atomicLong.incrementAndGet());
        employee.getTaskEntities().forEach(item -> item.setId(atomicLong.incrementAndGet()));
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> search(String name, Integer page, Integer size) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employeeList
        ) {
            if (employee.getName().equals(name)) {
                list.add(employee);

            }
        }
        List<Employee> employees = list.stream()
                .sorted(Comparator.comparing(Employee::getSurname))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public List<Task> getAllTask() {
        return taskList;
    }

    @Override
    public Task getByIdTask(Long id) {
        return taskList.stream().filter(item->item.getId()==id).findAny().get();

    }

    @Override
    public Task removeTask(Long id) {
        employeeList.remove(getById(id));
        return getByIdTask(id);
    }

    @Override
    public Task saveTask(Task task) {
        taskList.add(task);
        return task;
    }
}
