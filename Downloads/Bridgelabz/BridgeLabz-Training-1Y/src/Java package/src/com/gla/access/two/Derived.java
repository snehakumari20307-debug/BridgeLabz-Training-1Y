package com.gla.access.two;


import com.gla.access.one.Base;

public class Derived extends Base {

    public void testAccess() {

        // Accessible
        publicMethod();        // ✅ public
        protectedMethod();     // ✅ protected (via inheritance)



        System.out.println("Accessible methods executed successfully.");
    }

    public static void main(String[] args) {
        Derived d = new Derived();
        d.testAccess();
    }
}

