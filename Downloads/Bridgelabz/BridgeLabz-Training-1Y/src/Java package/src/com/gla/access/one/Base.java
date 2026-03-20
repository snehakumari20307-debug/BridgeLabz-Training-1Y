package com.gla.access.one;

public class Base {


        public void publicMethod() {
            System.out.println("Public Method Accessible Everywhere");
        }

        protected void protectedMethod() {
            System.out.println("Protected Method Accessible in Subclass (even in different package)");
        }

        void defaultMethod() {
            System.out.println("Default Method Accessible Only Within Same Package");
        }

        private void privateMethod() {
            System.out.println("Private Method Accessible Only Within Same Class");
        }

        // Method to test private internally
        public void accessPrivate() {
            privateMethod();
        }
    }

