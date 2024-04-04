import java.util.*;
import java.io.*;
// Add a comment

public class Foodcenter { //create food class
    private static int burger_Stock = 40;

    public static void main(String[] args) {


        // create the arrays
        String[] cashier1 = {"X", "X"};  //create the arrays
        String[] cashier2 = {"X", "X", "X"};
        String[] cashier3 = {"X", "X", "X", "X", "X"};
        String[] queue_1_names = new String[2];
        String[] queue_2_names = new String[3];
        String[] queue_3_names = new String[5];


        Scanner input = new Scanner(System.in);




        while (true) {
            Menu();
            System.out.print("Enter your option from the above menu: ");
            String choice = input.nextLine();
            System.out.println();


            switch (choice) {
                case "100":
                case "VFQ":
                    System.out.println("*****************");//print the cashier
                    System.out.println("*    Cashiers   *");
                    System.out.println("*****************");
                    printthecashiers(cashier1, cashier2, cashier3);
                    break;
                case "101":
                case "VEQ":
                    viewallemptyques(cashier1, cashier2, cashier3);

                    break;
                case "102":
                case "ACQ":
                    AddCustomertoQueue(cashier1, queue_1_names, cashier2, queue_2_names, cashier3, queue_3_names);
                    break;
                case "103":
                case "RCQ":

                    removetheCustomerfromthequeue(cashier1, cashier2, cashier3, queue_1_names, queue_2_names, queue_3_names);
                    break;

                case "104":
                case "PCQ":
                    Removeaservedcustomer(cashier1, cashier2, cashier3, queue_1_names, queue_2_names, queue_3_names);

                    break;
                case "105":
                case "VCS":
                    String[] combinedArray = combineArrays(queue_1_names, queue_2_names, queue_3_names);
                    sortNames(combinedArray);
                    for (String Name: combinedArray) {
                        System.out.println(Name);
                    }

                    break;
                case "106":
                case "SPD":
                    StoreTextFile(cashier1, cashier2, cashier3, queue_1_names, queue_2_names, queue_3_names);
                    break;
                case "107":
                case "LPD":
                    LoadTextFile();
                case "108":
                case "STK":
                    ViewRemainingburgerStock(burger_Stock);

                    break;
                case "109":
                case "AFS":
                    AddburgerstoStock(input);
                    break;
                case "999":
                case "EXT":
                    break;


            }
        }
    }


    public static String[] combineArrays(String[] array1, String[] array2, String[] array3) {
        int length1 = array1.length;// combine the arrays
        int length2 = array2.length;
        int length3 = array3.length;

        String[] combinedArray = new String[length1 + length2 + length3];

        // Copy elements from array1
        System.arraycopy(array1, 0, combinedArray, 0, length1);

        // Copy elements from array2
        System.arraycopy(array2, 0, combinedArray, length1, length2);

        // Copy elements from array3
        System.arraycopy(array3, 0, combinedArray, length1 + length2, length3);

        return combinedArray;
    }

    private static void printthecashiers(String[] cashier1, String[] cashier2, String[] cashier3) { //print the cashiers vertically
        int maxLength = Math.max(cashier1.length, Math.max(cashier2.length, cashier3.length));


        for (int i = 0; i < maxLength; i++) {
            if (i < cashier1.length) {
                System.out.print(cashier1[i] + "\t");
            } else {
                System.out.print("\t");
            }

            if (i < cashier2.length) {
                System.out.print(cashier2[i] + "\t");
            } else {
                System.out.print("\t");
            }

            if (i < cashier3.length) {
                System.out.print(cashier3[i]);
            }

            System.out.println();
        }
    }

    private static void Menu(){
        System.out.println("************ Main Menu ************");// print the Main Menu
        System.out.println("100 or VFQ: View all Full Queues");
        System.out.println("101 or VEQ: View all Empty Queues");
        System.out.println("102 or ACQ: Add customer to a Queue");
        System.out.println("103 or RCQ: Remove a customer from a Queue");
        System.out.println("104 or PCQ: Remove a served customer");
        System.out.println("105 or VCS: View Customers Sorted in alphabetical order");
        System.out.println("106 or SPD: Store Program Data into file");
        System.out.println("107 or LPD: Load Program Data from file");
        System.out.println("108 or STK: View Remaining burger Stock");
        System.out.println("109 or AFS: Add burgers to Stock");
        System.out.println("999 or EXT: Exit the Program");
    }

    private static void viewallemptyques(String[] cashier1, String[] cashier2, String[] cashier3) { //View all Empty Queue
        boolean available = false;
        for(String empty: cashier1) {
            if (empty.equals("X")) {
                available = true;
            }
        }
        if(available) {
            System.out.println("Empty queues available for cashier1");

        }

        available = false;
        for(String empty: cashier2) {
            if (empty.equals("X")) {
                available = true;
            }
        }
        if(available) {
            System.out.println("Empty queues available for cashier2");


        }
        available = false;
        for(String empty: cashier3) {
            if (empty.equals("X")) {
                available = true;
            }
        }
        if(available) {
            System.out.println("Empty queues available for cashier3");


        }



    }


    private static void LoadTextFile (){
        try {FileReader filereader = new FileReader("Output_File.txt");
        Scanner userInput = new Scanner(filereader); // Specify the path to your file
            while (userInput.hasNext()){
                String Line = userInput.nextLine();
                System.out.println(Line);
            }
            userInput.close();
           // System.out.println("Program data has been loaded");


        } catch (IOException e) {
            System.out.println(e);
        }
    }
//Store Text File
    private static void StoreTextFile(String[] cashier1, String[] cashier2, String[] cashier3, String[] queue_1_names, String[] queue_2_names, String[] queue_3_names){
        try{
            FileWriter txt = new FileWriter("Output_File.txt");
            txt.write("Cashier 1" + "\n");
            txt.write(String.join(" ", cashier1)+ "\n");
            txt.write("Cashier 2" + "\n");
            txt.write(String.join(" ", cashier2)+ "\n");
            txt.write("Cashier 3" + "\n");
            txt.write(String.join(" ", cashier3)+ "\n" + "\n");

            txt.write("Cashier 1 names" + "\n");
            txt.write(String.join("\n", queue_1_names)+ "\n" + "\n");
            txt.write("Cashier 2 names" + "\n");
            txt.write(String.join("\n", queue_2_names)+ "\n" + "\n");
            txt.write("Cashier 3 names" + "\n");
            txt.write(String.join("\n", queue_3_names)+ "\n" + "\n");


            txt.close();
            System.out.println("File Stored Success");
        }catch (IOException e){
            System.out.println(e);
        }
    }
    private static void AddCustomertoQueue(String[] cashier1, String[] queue_1_names, String[] cashier2, String[] queue_2_names, String[] cashier3, String[] queue_3_names) {
        Scanner input = new Scanner(System.in); //Add customer Queue

        System.out.print("Customer Name: ");
        String name_customer = input.nextLine();

        System.out.print("Cashier Number: ");
        int users_cashiers = input.nextInt();

        boolean full = false;

        if (users_cashiers == 1) {
            for (int x = 0; x < cashier1.length; x++) {
                if (cashier1[x].equals("X")) {
                    full = true;
                    cashier1[x] = "O";
                    queue_1_names[x] = name_customer;
                    return;
                }
            }
        } else if (users_cashiers == 2) {
            for (int x = 0; x < cashier2.length; x++) {
                if (cashier2[x].equals("X")) {
                    full = true;
                    cashier2[x] = "O";
                    queue_2_names[x] = name_customer;
                    return;
                }
            }
        } else if (users_cashiers == 3) {
            for (int x = 0; x < cashier3.length; x++) {
                if (cashier3[x].equals("X")) {
                    full = true;
                    cashier3[x] = "O";
                    queue_3_names[x] = name_customer;
                    return;
                }
            }
        }

        if (!full) {
            System.out.println("Cashier is full now.");
        } else {
            System.out.println("Added successfully.");
        }
    }

    private static void removetheCustomerfromthequeue(String[] cashier1, String[] cashier2, String[] cashier3, String[] queue1_names, String[] queue2_names, String[] queue3_names) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the queue number (1, 2, or 3): ");//Remove Customer
        int number_of_the_cashier = input.nextInt();

        if (number_of_the_cashier == 1) {
            System.out.print("Enter the position: ");
            int position = input.nextInt();

            if (position >= 1 && position <= cashier1.length) {
                cashier1[position - 1] = "X";

                for (int y = position; y < cashier1.length; y++) {
                    if (!cashier1[y].equals("X")) {
                        cashier1[y - 1] = cashier1[y];
                        cashier1[y] = "X";
                    }

                    if (queue1_names[y] != null) {
                        queue1_names[y - 1] = queue1_names[y];
                        queue1_names[y] = null;
                    }
                }

                System.out.println("Successfully deleted the customer.");
            }
        } else if (number_of_the_cashier == 2) {
            System.out.print("Enter the position: ");
            int position = input.nextInt();

            if (position >= 1 && position <= cashier2.length) {
                cashier2[position - 1] = "X";

                for (int y = position; y < cashier2.length; y++) {
                    if (!cashier2[y].equals("X")) {
                        cashier2[y - 1] = cashier2[y];
                        cashier2[y] = "X";
                    }

                    if (queue2_names[y] != null) {
                        queue2_names[y - 1] = queue1_names[y];
                        queue2_names[y] = null;
                    }
                }

                System.out.println("Successfully deleted the customer.");
            }

        } else if (number_of_the_cashier == 3) {
            System.out.print("Enter the position: ");
            int position = input.nextInt();

            if (position >= 1 && position <= cashier3.length) {
                cashier2[position - 1] = "X";

                for (int y = position; y < cashier3.length; y++) {
                    if (!cashier2[y].equals("X")) {
                        cashier3[y - 1] = cashier3[y];
                        cashier3[y] = "X";
                    }

                    if (queue3_names[y] != null) {
                        queue3_names[y - 1] = queue3_names[y];
                        queue3_names[y] = null;
                    }
                }

                System.out.println("Successfully deleted the customer.");
            }

        }

    }
    private static void Removeaservedcustomer(String[] cashier1, String[] cashier2, String[] cashier3, String[] queue1_names, String[] queue2_names, String[] queue3_names ) {
        System.out.print("Enter the cashier number"); //Remove Serves Customer
        Scanner input = new Scanner(System.in);
        int cashier_number = input.nextInt();
        if (cashier_number == 1){
            if(cashier1[0].equals("O")){
                cashier1[0] = "X";
                String name = queue1_names[0];
                for (int y = 1; y < cashier1.length; y++) {
                    if (!cashier1[y].equals("X")) {
                        cashier1[y - 1] = cashier1[y];
                        cashier1[y] = "X";
                    }

                    if (queue1_names[y] != null) {
                        queue2_names[y - 1] = queue1_names[y];
                        queue1_names[y] = null;
                    }
                }
                System.out.println(name+" Removed from cashier1");
            }
        } else if(cashier_number == 2){
            if(cashier1[0].equals("O")){
                cashier1[0] = "X";
                String name = queue2_names[0];
                for (int y = 1; y < cashier1.length; y++) {
                    if (!cashier2[y].equals("X")) {
                        cashier2[y - 1] = cashier2[y];
                        cashier2[y] = "X";
                    }

                    if (queue2_names[y] != null) {
                        queue2_names[y - 1] = queue2_names[y];
                        queue2_names[y] = null;
                    }
                }
                System.out.println(name+" Removed from cashier2");
            }
        } else if(cashier_number == 3){
            if(cashier3[0].equals("O")) {
                cashier3[0] = "X";
                String name = queue3_names[0];
                for (int y = 1; y < cashier3.length; y++) {
                    if (!cashier3[y].equals("X")) {
                        cashier3[y - 1] = cashier3[y];
                        cashier3[y] = "X";
                    }

                    if (queue3_names[y] != null) {
                        queue3_names[y - 1] = queue3_names[y];
                        queue3_names[y] = null;
                    }
                }
                System.out.println(name + " Removed from cashier3");
            }
        }

        }
        private static void ViewRemainingburgerStock(int burger_Stock){

        System.out.print("Burger Stock is "+ burger_Stock);
        System.out.println();

        }
        private static void AddburgerstoStock(Scanner scanner) {
            System.out.println("Howmany Burgers do you want to add");
            Scanner input = new Scanner(System.in);
            int burger_count = input.nextInt();
            if(burger_Stock != 50){
                if(burger_Stock + burger_count <= 50){
                    burger_Stock += burger_count;
                    System.out.println("Added Sucssesfully");
                }
                else{
                    System.out.println("Unable to add because amount exceeds 50");
                }

            }else{
                System.out.println("stock is already full cock sucker buy new stock");
            }
        }


    public static int compareNames(String name1, String name2) {if (name1 == null && name2 == null) {
        return 0; // Both names are null and considered equal
    } else if (name1 == null) {
        return -1; // Null is considered smaller than any non-null name
    } else if (name2 == null) {
        return 1; // Null is considered smaller than any non-null name
    } else {
        int minLength = Math.min(name1.length(), name2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = name1.charAt(i);
            char c2 = name2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return name1.length() - name2.length();
    }
    }

    public static void sortNames(String[] names) {
        if (names == null) {
            return; // Handle null array
        }
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareNames(names[j], names[j + 1]) > 0) {
                    // Swap names[j] and names[j + 1]
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
    }



}

