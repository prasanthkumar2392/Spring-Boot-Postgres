package Spring.Logic;

import java.util.ArrayList;
import java.util.List;

import Spring.Bill.Billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private Billing billing;

    @PostMapping("/saveemployee")
    public Employee greeting(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping("/getemployee")
    @ResponseStatus(HttpStatus.OK)
    public void getEmployee() {

        billing.setName("karthi");
        billing.setMetrics("peeasasds");
        billingRepository.save(billing);
        System.out.println("****************** sdaved" );
    }

    @GetMapping("/getallname")
    public List<Employee> getAllByName(@RequestParam String name) {
        List<Employee> emp = new ArrayList<>();
        emp = employeeRepository.findAllByName(name);
        return emp;

    }


    @PutMapping("/updateemp/{name}")
    public void updateName(@PathVariable String name) {
        int id = 3;
         employeeRepository.updateByName(name, id);
    }

    @DeleteMapping("/deleteemployee")
    public String deleteEmployee(@RequestParam String name) {

        employeeRepository.deleteByName(name);
        return "The given record is deleted  " + name;
    }

}