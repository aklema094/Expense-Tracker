import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker{
    static class Expense{
        String category;
        String date;
        String description;
        double amount;
    
        Expense(String c,String d, String des, double a){
            this.category = c;
            this.date = d;
            this.description = des;
            this.amount = a;
        }
        @Override
    public String toString() {
        return String.format("%-12s | %-10s | %-8.2f | %s", date, category, amount, description);
    }

    }
    static ArrayList<Expense> list = new ArrayList<>();
    static double budget = 0.0;
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

     while (true) {
        choiceList();
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addExpense(sc);
                break;
            case 2: 
                 viewExpenses();
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

    private static void choiceList(){
        System.out.println("====================================");
        
        System.out.println("          Expense Tracker           ");
        
        System.out.println("====================================");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Generate Report");
        System.out.println("4. Set Buget");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");
        System.out.print("Enter your choice : ");

    }
    /**
     * @param sc
     */
    private static void addExpense(Scanner sc) {
        System.out.println("---------- Add Expense ----------\n");
        System.out.println("Enter expense details:");
        
        // Input for category
        System.out.print("Category (e.g., Food, Rent, Utilities): ");
        String category = sc.next(); 
        
        // Input for amount
        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume the leftover newline
        
        // Input for date
        System.out.print("Date (DD/MM/YYYY): ");
        String date = sc.nextLine();
        
        // Input for description
        System.out.print("Description: ");
        String description = sc.nextLine();
        
        list.add(new Expense(category, date, description, amount));
        // Success message
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
        for (Expense expense : list) {
            System.out.println(expense);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Total Expenses");
    }
    private static void setBudget(Scanner scanner) {
        System.out.println("=================================================");
        System.out.println("               SET BUDGET");
        System.out.println("=================================================");
        System.out.print("Enter your monthly budget: ");
        budget = scanner.nextDouble();
        System.out.println("-------------------------------------------------");
        System.out.println("Budget updated successfully!");
        System.out.println("-------------------------------------------------");
    }
    
    
}
