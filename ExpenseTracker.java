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
            case 4:
                setBudget(sc);
                break;
             
            default:
            System.out.println("Invalid Choice, Try again!!! ");
                break;
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
