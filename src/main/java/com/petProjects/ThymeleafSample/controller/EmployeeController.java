package com.petProjects.ThymeleafSample.controller;

import com.petProjects.ThymeleafSample.Service.EmployeeService;
import com.petProjects.ThymeleafSample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // create a mapping for "/hello"

    @GetMapping("/hello")
    public String sayHello(Model theModel) {

        theModel.addAttribute("theDate", new java.util.Date());

        return "helloworld";
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

    @PostMapping("/save")
    public String SaveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        //Save Employee
        employeeService.save(theEmployee);

        //use a redirect to prevent a resubmission in the UI
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel) {
        //Create a model attribute to bind Data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "EmployeeForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "EmployeeForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/employees/list";

    }
}
