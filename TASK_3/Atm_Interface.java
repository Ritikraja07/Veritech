import java.util.Scanner;

public class Atm_Interface {

    private static int totalBalance = 100000;
    private static final int PIN_LENGTH = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("!!------- Welcome to SBI ATM -------!!");
        System.out.println("Please insert your debit card...");
        System.out.println("\n");
        System.out.print("Please enter a random number: ");

        // Simulate card insertion
        sc.nextLine();
        
        // Input 4 digit pin

        System.out.println("Please enter your 4-digit PIN:");
        int pin = getValidPin(sc);

        while (true) {
            int choice = displayMenuAndGetChoice(sc);
            switch (choice) {
                case 1:
                    withdrawCash(sc, pin);
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    depositMoney(sc, pin);
                    break;
                case 4:
                    exitATM();
                    return;
                default:
                    // if user enter invalid pin
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private static int getValidPin(Scanner sc) {
        while (true) {
            String input = sc.nextLine();
            if (input.length() == PIN_LENGTH && input.matches("\\d+")) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid PIN. Please enter a 4-digit PIN:");
            }
        }
    }

    private static int displayMenuAndGetChoice(Scanner sc) {
        // Select Transaction type
        System.out.println("\nSelect Transaction: ");
        System.out.println("Press 1 - Cash Withdraw");
        System.out.println("Press 2 - Check Balance");
        System.out.println("Press 3 - Deposit");
        System.out.println("Press 4 - Exit");
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    private static void withdrawCash(Scanner sc, int pin) {
        System.out.print("Enter the amount to withdraw: ");
        int amount = sc.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (amount > totalBalance) {
            System.out.println("Insufficient balance.");
        } else {
            totalBalance -= amount;
            System.out.println("\n");
            System.out.println("Please wait while your transaction is being processed...");
            System.out.println("Please collect your cash.");
            System.out.println("Your transaction has been successful.");
            System.out.println("\n");
        }
    }

    private static void checkBalance() {
        System.out.println("Your available balance is: " + totalBalance);
    }

    private static void depositMoney(Scanner sc, int pin) {
        System.out.print("Enter the amount to deposit: ");
        int amount = sc.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            totalBalance += amount;
            System.out.println("Please wait while your transaction is being processed...");
            System.out.println("Your amount of " + amount + " has been successfully deposited.");
        }
    }

    private static void exitATM() {
        System.out.println("\n");
        System.out.println("Please remove your debit card.");
        System.out.println("Thank you for using SBI ATM!");
    }
}