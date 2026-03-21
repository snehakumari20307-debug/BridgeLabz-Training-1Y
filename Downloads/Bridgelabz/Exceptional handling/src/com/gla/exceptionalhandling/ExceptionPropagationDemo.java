package com.gla.exceptionalhandling;

public class ExceptionPropagationDemo {


        // method1 throws an ArithmeticException
        public static void method1() {
            System.out.println("Inside method1");
            int result = 10 / 0; // will throw ArithmeticException
            System.out.println("Result: " + result); // won't execute
        }

        // method2 calls method1
        public static void method2() {
            System.out.println("Inside method2");
            method1(); // exception propagates to method2 caller
        }

        public static void main(String[] args) {
            System.out.println("Inside main");
            try {
                method2(); // exception propagates to main
            } catch (ArithmeticException e) {
                System.out.println("Handled exception in main");
            }
            System.out.println("Program continues after exception handling");
        }
    }

