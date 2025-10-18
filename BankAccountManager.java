import java.util.*;

public class BankAccountManager {
    private static Scanner sc = new Scanner(System.in);
    private static BankAccount account;

    public static void main(String[] args) {
        createAccount();
        showMenu();
    }

    private static void createAccount() {
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        double balance = -1;
        while (balance < 0) {
            System.out.print("Enter Initial Balance: ");
            if (sc.hasNextDouble()) {
                balance = sc.nextDouble();
                if (balance < 0) System.out.println("Balance cannot be negative!");
            } else {
                System.out.println("Invalid input. Enter a number.");
                sc.next(); // clear invalid input
            }
        }
        sc.nextLine(); // clear buffer
        account = new BankAccount(name, balance);
        System.out.println("Account created successfully!\n");
    }

    private static void showMenu() {
        int choice;
        do {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
                handleChoice(choice);
            } else {
                System.out.println("Invalid choice! Enter a number 1-4.");
                sc.next(); // clear invalid input
                choice = 0;
            }
        } while (choice != 4);
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                account.displayDetails();
                break;
            case 4:
                System.out.println("Thank you for banking with us!");
                break;
            default:
                System.out.println("Invalid choice! Please select 1-4.");
        }
    }
}
