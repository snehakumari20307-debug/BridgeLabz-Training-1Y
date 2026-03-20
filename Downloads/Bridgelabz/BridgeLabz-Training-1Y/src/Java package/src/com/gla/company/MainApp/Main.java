package com.gla.company.MainApp;



import com.gla.company.hr.employee.Employee;
import com.gla.company.payroll.Payroll; // Single-type import

    public class Main{
        public static void main(String[] args) {

            Employee emp = new Employee(101, "Rahul", "IT", 50000);

            System.out.println("Before Bonus:");
            emp.display();

            Payroll payroll = new Payroll();
            payroll.calculateBonus(emp);

            System.out.println("\nAfter Bonus:");
            emp.display();
        }
    }
