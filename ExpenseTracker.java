import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    static class Expense {
        String category;
        String date;
        String description;
        double amount;

        Expense(String c, String d, String des, double a) {
            this.category = c;
            this.date = d;
            this.description = des;
            this.amount = a;
        }

        public String getCategory() {
            return category;
        }

        public double getAmount() {
            return amount;
        }

        public String getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return String.format("%-12s | %-10s | %-8.2f | %s", date, category, amount, description);
        }
    }

    static ArrayList<Expense> list = new ArrayList<>();
    static double budget = 0.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    setBudget(sc);
                    break;
                case 5:
                    System.out.println("Thank you for using Expense Tracker. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("====================================");
        System.out.println("          Expense Tracker           ");
        System.out.println("====================================");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Generate Report");
        System.out.println("4. Set Budget");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");
        System.out.print("Enter your choice: ");
    }

    private static void addExpense(Scanner sc) {
        System.out.println("---------- Add Expense ----------");
        System.out.print("Category (e.g., Food, Rent, Utilities): ");
        String category = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume leftover newline

        System.out.print("Date (DD/MM/YYYY): ");
        String date = sc.nextLine();

        System.out.print("Description: ");
        String description = sc.nextLine();

        list.add(new Expense(category, date, description, amount));
        System.out.println("-------------------------------------------------");
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (list.isEmpty()) {
            System.out.println("No expenses recorded yet!");
            return;
        }

        System.out.println("=================================================");
        System.out.println("              VIEW EXPENSES");
        System.out.println("=================================================");
        System.out.println("Date         | Category   | Amount   | Description");
        System.out.println("-------------------------------------------------");
        double totalExpenses = 0.0;
        for (Expense expense : list) {
            System.out.println(expense);
            totalExpenses += expense.getAmount();
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Total Expenses: %.2f%n", totalExpenses);
    }

    private static void generateReport() {
        if (list.isEmpty()) {
            System.out.println("No expenses recorded yet! Add some expenses first.");
            return;
        }

        System.out.println("=================================================");
        System.out.println("               EXPENSE REPORT");
        System.out.println("=================================================");
        System.out.printf("%-12s | %-10s%n", "Category", "Total Amount");
        System.out.println("-------------------------------------------------");

        double totalExpenses = 0.0;
        String[] categories = {"Food", "Rent", "Utilities", "Other"};

        for (String category : categories) {
            double categoryTotal = list.stream()
                    .filter(e -> e.getCategory().equalsIgnoreCase(category))
                    .mapToDouble(Expense::getAmount)
                    .sum();

            if (categoryTotal > 0) {
                System.out.printf("%-12s | %-10.2f%n", category, categoryTotal);
            }
            totalExpenses += categoryTotal;
        }

        System.out.println("-------------------------------------------------");
        System.out.printf("Total Expenses: %.2f%n", totalExpenses);

        if (budget > 0) {
            System.out.printf("Budget: %.2f%n", budget);
            System.out.printf("Remaining: %.2f%n", budget - totalExpenses);
            System.out.println("-------------------------------------------------");
            System.out.println(budget >= totalExpenses ? "✅ Within Budget" : "❌ Over Budget");
        } else {
            System.out.println("⚠️ Budget is not set or invalid.");
        }

        System.out.println("-------------------------------------------------");
    }

    private static void setBudget(Scanner sc) {
        System.out.println("=================================================");
        System.out.println("               SET BUDGET");
        System.out.println("=================================================");
        System.out.print("Enter your monthly budget: ");
        budget = sc.nextDouble();
        System.out.println("-------------------------------------------------");
        System.out.println("Budget updated successfully!");
        System.out.println("-------------------------------------------------");
    }
}
