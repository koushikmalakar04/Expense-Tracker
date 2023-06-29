import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        List<Expense> expenses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    Expense expense = new Expense(description, amount);
                    expenses.add(expense);

                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        System.out.println("Expenses:");
                        double totalAmount = 0.0;
                        for (int i = 0; i < expenses.size(); i++) {
                            Expense currentExpense = expenses.get(i);
                            System.out.println((i + 1) + ". " + currentExpense.getDescription()
                                    + " - $" + currentExpense.getAmount());
                            totalAmount += currentExpense.getAmount();
                        }
                        System.out.println("Total expenses: $" + totalAmount);
                    }
                    break;
                case 3:
                    System.out.println("Exiting Expense Tracker...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
