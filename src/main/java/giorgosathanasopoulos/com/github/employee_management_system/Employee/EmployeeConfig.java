package giorgosathanasopoulos.com.github.employee_management_system.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
          Employee employee1 = new Employee("George Athans", "george.athans@gmail.com", "Senior Software Engineer");
          Employee employee2 = new Employee("Steve Tzeve", "steve.tzeve@gmail.com", "UI/UX Designer");

          List<Employee> employeeList = List.of(employee1, employee2);

          employeeRepository.saveAll(employeeList);
        };
    }
}
