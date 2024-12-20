import java.util.Scanner;

public class ExpenseTracker{
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

     while (true) {
        choiceList();
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addExpense(sc);
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
        
        // Success message
        System.out.println("-------------------------------------------------");
        System.out.println("Expense added successfully!");

    }
    
    
}
