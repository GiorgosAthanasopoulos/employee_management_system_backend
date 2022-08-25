package giorgosathanasopoulos.com.github.employee_management_system.Employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://127.0.0.1:3000/")
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "{id}")
    public Optional<Employee> getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping
    public void postEmployee(@RequestBody Employee employee) {
        employeeService.postEmployee(employee);
    }

    @PutMapping(path = "{id}")
    public void putEmployee(@PathVariable long id, @RequestHeader String name, @RequestHeader String email, @RequestHeader String jobPosition) {
        employeeService.putEmployee(id, name, email, jobPosition);
    }
}
