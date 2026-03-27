package com.gla.thread;
class BankAccount implements Runnable {

    private String accountHolderName;
    private String accountType;

    public BankAccount(String name, String type) {
        this.accountHolderName = name;
        this.accountType = type;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        for (int i = 1; i <= 3; i++) {
            System.out.println(
                    accountType + " User: " + accountHolderName +
                            " | Checking balance (Attempt " + i + ")" +
                            " | Thread: " + t.getName() +
                            " | Priority: " + t.getPriority()
            );

            try {
                Thread.sleep(2000); // simulate 2 seconds delay
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {

        // Creating users
        BankAccount premiumUser = new BankAccount("Alice", "Premium");
        BankAccount regularUser = new BankAccount("Bob", "Regular");
        BankAccount basicUser = new BankAccount("Charlie", "Basic");

        // Creating threads
        Thread t1 = new Thread(premiumUser, "Premium-Thread");
        Thread t2 = new Thread(regularUser, "Regular-Thread");
        Thread t3 = new Thread(basicUser, "Basic-Thread");

        // Setting priorities
        t1.setPriority(Thread.MAX_PRIORITY);   // 10
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MIN_PRIORITY);   // 1

        // Starting threads
        t1.start();
        t2.start();
        t3.start();
    }
}

