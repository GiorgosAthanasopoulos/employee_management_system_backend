package giorgosathanasopoulos.com.github.employee_management_system.Employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> filterEmployees(String filter) {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().filter(employee -> employee.getName().toLowerCase().contains(filter)).toList();
    }

    public void postEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        if(employeeOptional.isPresent()) {
            throw new IllegalStateException("Employee with id: " + employee.getId() + " already exists!");
        }

        employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());

        if(employeeOptional.isPresent()) {
            throw new IllegalStateException("Employee with email: " + employee.getEmail() + " already exists!");
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isEmpty()) {
            throw new IllegalStateException("Employee with id: " + id + " does not exist!");
        }

        employeeRepository.deleteById(id);
    }

    @Transactional
    public void putEmployee(long id, String name, String email, String jobPosition, String imgurl) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isEmpty()) {
            throw new IllegalStateException("Employee with id: " + id + " does not exist!");
        }

        Employee employee = employeeOptional.get();

        if(name != null && name.length() > 0 && !Objects.equals(name, employee.getName())) {
            employee.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(email, employee.getEmail())) {
            employee.setEmail(email);
        }

        if(jobPosition != null && jobPosition.length() > 0 && !Objects.equals(jobPosition, employee.getJobPosition())) {
            employee.setJobPosition(jobPosition);
        }

        if(imgurl != null && imgurl.length() > 0 && !Objects.equals(imgurl, employee.getImgurl())) {
            employee.setImgurl(imgurl);
        }
    }
}
