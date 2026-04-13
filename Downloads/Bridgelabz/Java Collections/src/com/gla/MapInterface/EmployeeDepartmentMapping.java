package com.gla.MapInterface;
import java.util.*;

public class EmployeeDepartmentMapping {

    // EmployeeID -> Department
    private HashMap<Integer, String> employeeMap = new HashMap<>();

    // 1. Add employee
    public void addEmployee(int empId, String department) {
        employeeMap.put(empId, department);
        System.out.println("Added: " + empId + " -> " + department);
    }

    // 2. Change department
    public void changeDepartment(int empId, String newDept) {
        if (!employeeMap.containsKey(empId)) {
            System.out.println("Employee not found: " + empId);
            return;
        }

        employeeMap.put(empId, newDept);
        System.out.println("Updated: " + empId + " -> " + newDept);
    }

    // 3. Find employees by department (reverse lookup)
    public void findEmployeesByDepartment(String department) {
        System.out.println("\nEmployees in " + department + ":");

        boolean found = false;

        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(department)) {
                System.out.println("Employee ID: " + entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in this department.");
        }
    }

    // 4. Count employees per department
    public void printDepartmentCounts() {

        HashMap<String, Integer> deptCount = new HashMap<>();

        for (String dept : employeeMap.values()) {
            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
        }

        System.out.println("\n--- Employee Count per Department ---");

        for (Map.Entry<String, Integer> entry : deptCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        EmployeeDepartmentMapping company = new EmployeeDepartmentMapping();

        // 1. Add employees
        company.addEmployee(101, "IT");
        company.addEmployee(102, "HR");
        company.addEmployee(103, "Finance");
        company.addEmployee(104, "IT");
        company.addEmployee(105, "HR");
        company.addEmployee(106, "Marketing");

        // 2. Change department
        company.changeDepartment(103, "IT");
        company.changeDepartment(999, "Sales"); // invalid case

        // 3. Reverse lookup
        company.findEmployeesByDepartment("IT");
        company.findEmployeesByDepartment("Sales");

        // 4. Department-wise count
        company.printDepartmentCounts();
    }
}

