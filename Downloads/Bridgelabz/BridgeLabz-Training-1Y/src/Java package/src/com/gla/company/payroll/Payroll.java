package com.gla.company.payroll;

import com.gla.company.hr.employee.Employee;

public class Payroll {

        public void calculateBonus(Employee e) {
            double bonus = e.getSalary() * 0.10;
            e.setSalary(e.getSalary() + bonus);
        }
    }

