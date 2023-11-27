package tech.getarrays.employeemanagerapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tech.getarrays.employeemanagerapp.exeption.UserNotFoundException;
import tech.getarrays.employeemanagerapp.model.Employee;
import tech.getarrays.employeemanagerapp.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee emplooyee){
        emplooyee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(emplooyee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    
    public Employee updatEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)    
        .orElseThrow(() -> new UserNotFoundException("User by id" + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}

