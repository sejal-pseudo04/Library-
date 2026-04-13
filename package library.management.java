package library.management.system;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Library libSystem = new Library();
        int userChoice;

        libSystem.initialData();

        do {
            //  Display Menu
            System.out.println("\n--- LIBRARY MANAGEMENT SYSTEM ---");
            System.out.println("1. Add book");
            System.out.println("2. Display books");
            System.out.println("3. Remove book");
            System.out.println("4. Issue book");
            System.out.println("5. Return book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            userChoice = input.nextInt();

            
            switch (userChoice) {
                case 1:
                    
                    libSystem.addNew();
                    break;

                case 2:
                    
                    libSystem.displayRecords();
                    break;

                case 3:
                   
                    libSystem.removeRecord();
                    break;

                case 4:
                    
                    libSystem.issueBook();
                    break;

                case 5:
                   
                    libSystem.returnBook();
                    break;

                case 6:
                   
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;

                default:
                   
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (userChoice != 6);
        
        input.close();
    }
}

class Library {
    
    ArrayList<String> bookTitles = new ArrayList<>();
    ArrayList<String> authorsList = new ArrayList<>();
    ArrayList<Integer> bookIds = new ArrayList<>();
    ArrayList<Integer> issueStatus = new ArrayList<>(); // 0 for available, 1 for issued

    Scanner input = new Scanner(System.in);

    // Initial data setup
    void initialData() {
        bookTitles.add("The Alchemist");
        authorsList.add("Paulo Coelho");
        bookIds.add(101);
        issueStatus.add(0);

        bookTitles.add("The Palace of Illusions");
        authorsList.add("Chitra Banerjee");
        bookIds.add(102);
        issueStatus.add(0);
    }

    // i. Call ob.addnew()
    void addNew() {
        // ii. accept name, Id and author of book
        System.out.print("Enter Book Title: ");
        input.nextLine(); // clear buffer
        String title = input.nextLine();

        System.out.print("Enter Author Name: ");
        String author = input.nextLine();

        System.out.print("Enter unique Book ID: ");
        int id = input.nextInt();

        // iii. update respective ArrayLists
        bookTitles.add(title);
        authorsList.add(author);
        bookIds.add(id);
        issueStatus.add(0);

        // iv. display success message
        System.out.println("Book record updated successfully!");
    }

    
    void displayRecords() {
        
        System.out.println("\n--- Current Inventory ---");
        System.out.printf("%-5s %-25s %-20s %-10s\n", "ID", "Title", "Author", "Status");
        for (int i = 0; i < bookTitles.size(); i++) {
            String status = (issueStatus.get(i) == 1) ? "Issued" : "Available";
            System.out.printf("%-5d %-25s %-20s %-10s\n", 
                bookIds.get(i), bookTitles.get(i), authorsList.get(i), status);
        }
    }

   
    void removeRecord() {
        
        System.out.print("Enter the Title of the book to remove: ");
        input.nextLine();
        String targetTitle = input.nextLine();

        
        int index = -1;
        for (int i = 0; i < bookTitles.size(); i++) {
            if (bookTitles.get(i).equalsIgnoreCase(targetTitle)) {
                index = i;
                break;
            }
        }

        
        if (index != -1) {
            bookTitles.remove(index);
            authorsList.remove(index);
            bookIds.remove(index);
            issueStatus.remove(index);
            System.out.println("Record deleted successfully.");
        } else {
           
            System.out.println("Error: Book not found.");
        }
    }

    
    void issueBook() {
        
        System.out.println("\nBooks currently available for issue:");
        for(int i=0; i<bookTitles.size(); i++) {
            if(issueStatus.get(i) == 0) System.out.println("- " + bookTitles.get(i) + " (ID: " + bookIds.get(i) + ")");
        }

        
        System.out.print("Find book by: 1. Name 2. ID: ");
        int choice = input.nextInt();
        int foundIdx = -1;

        
        if (choice == 1) {
            System.out.print("Enter Name: ");
            input.nextLine();
            String name = input.nextLine();
            foundIdx = bookTitles.indexOf(name);
        } else {
            System.out.print("Enter ID: ");
            int id = input.nextInt();
            foundIdx = bookIds.indexOf(id);
        }

        
        if (foundIdx != -1) {
            if (issueStatus.get(foundIdx) == 1) {
                System.out.println("This book is already issued to someone else.");
            } else {
                issueStatus.set(foundIdx, 1);
                System.out.println("Book issued successfully!");
            }
        } else {
           
            System.out.println("Book not found!");
        }
    }

    
    void returnBook() {
        
        System.out.println("\nBooks currently out on issue:");
        for(int i=0; i<bookTitles.size(); i++) {
            if(issueStatus.get(i) == 1) System.out.println("- " + bookTitles.get(i) + " (ID: " + bookIds.get(i) + ")");
        }

        
        System.out.print("Find book by: 1. Name 2. ID: ");
        int choice = input.nextInt();
        int foundIdx = -1;

       
        if (choice == 1) {
            System.out.print("Enter Name: ");
            input.nextLine();
            String name = input.nextLine();
            foundIdx = bookTitles.indexOf(name);
        } else {
            System.out.print("Enter ID: ");
            int id = input.nextInt();
            foundIdx = bookIds.indexOf(id);
        }

        
        if (foundIdx != -1) {
            issueStatus.set(foundIdx, 0);
            System.out.println("Book returned successfully!");
        } else {
            
            System.out.println("Book not found!");
        }
    }
}