import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Title: " + title + "\n Author: " + author + "\nGenre: " + genre;
    }
}

public class libraryManagement {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";

    static void display(ArrayList<String> library, ArrayList<Boolean> markLibrary) {
        for (int i = 0; i < library.size(); i++) {
            String status = markLibrary.get(i) ?  GREEN+"AVAILABLE"+RESET : RED+"BORROWED"+RESET;
            System.out.println((i + 1) + ". " + library.get(i));
            System.out.println("\t            " + status);
            System.out.println("___________________________________________________________________________________________________");
        }
    }



    public static void main(String[] args) {
        ArrayList<String> library = new ArrayList<>();
        ArrayList<Boolean> markLibrary = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(BLUE+"\t             MOSHOOD ABIODUN LIBRARY\n"+RESET);
            System.out.println(YELLOW+"\t  MENU"+RESET);
            System.out.println("1. Add Book");
            System.out.println("2. View Book(s)");
            System.out.println("3. Remove Book");
            System.out.println("4. Search Book");
            System.out.println("5. Mark Book(Available/Borrowed)");
            System.out.println("6. Exit");
            System.out.print("enter option: ");
            int option;
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter the valid option");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println(YELLOW+"\t             ADD BOOK TO LIBRARY\n"+RESET);
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    Book book = new Book(title, author, genre);
                    library.add(book.toString());
                    markLibrary.add(true);
                    System.out.println("Book added successfully\n");
                    Collections.sort(library);
                    break;

                case 2:
                    System.out.println(YELLOW+"\t             VIEW BOOK(s) IN LIBRARY\n"+RESET);
                    if (library.isEmpty()) {
                        System.out.println("Library is Empty!");
                    } else {
                        display(library, markLibrary);
                    }
                    break;

                case 3:
                    System.out.println(YELLOW+"\t             REMOVE BOOK IN LIBRARY\n"+RESET);
                    if (library.isEmpty()) {
                        System.out.println("Library is Empty!");
                    } else {
                        display(library, markLibrary);
                        System.out.println("Enter book author or title to remove from Library or 'Esc' to go back to Menu: ");
                        String removeBook = scanner.nextLine();
                        if (removeBook.equalsIgnoreCase("Esc")) {
                            System.out.println("Exiting to Menu...");
                        } else {
                            boolean found = false;
                            for (int i = 0; i < library.size(); i++) {
                                if (library.get(i).toLowerCase().contains(removeBook.toLowerCase())) {
                                    library.remove(i);
                                    markLibrary.remove(i);
                                    found = true;
                                    System.out.println("Book removed successfully!");
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Book not found in library.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println(YELLOW+"\t             SEARCH BOOK IN LIBRARY\n"+RESET);
                    if (library.isEmpty()) {
                        System.out.println("Library is Empty!");
                    } else {
                        System.out.print("Enter book title, author or genre to search: ");
                        String searchQuery = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i<library.size();i++) {
                            String bookEntry = library.get(i);
                            if (bookEntry.toLowerCase().contains(searchQuery.toLowerCase())) {
                                String status = markLibrary.get(i) ?  GREEN+"AVAILABLE"+RESET : RED+"BORROWED"+RESET;
                                System.out.println((i + 1) + ". " + bookEntry);
                                System.out.println("\t            " + status);
                                System.out.println("___________________________________________________________________________________________________");
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("No matching book found in library.");
                        }
                    }
                    break;

                case 5:
                    System.out.println(YELLOW+"\t             MARK BOOK IN LIBRARY(AVAILABLE OR BORROWED) \n"+RESET);
                    if (library.isEmpty()) {
                        System.out.println("Library is Empty!");
                    } else {
                        display(library, markLibrary);
                        System.out.print("Enter book number to change status: ");
                            try {
                                int bookNumber = scanner.nextInt();
                                scanner.nextLine();
                                if (bookNumber >= 0 && bookNumber <= markLibrary.size()) {
                                    markLibrary.set(bookNumber - 1, !markLibrary.get(bookNumber - 1));
                                    System.out.println("Book status updated successfully!");
                                } else {
                                    System.out.println("Invalid book number.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input, please enter a valid number");
                                scanner.nextLine();
                            }
                        }
                    break;

                case 6:
                    System.out.println("Exiting Library Management System...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        }
    }
}

// Monkey King, Curer Elis, Fiction
//
//
//Ninety Eight hours, Agatha Christie, Romance
//
//Murder on the Orient, Mary Westcott, Mystery
//
//
//Death on the Nile, Mary Westcott, Mystery
//
//Jane Eyre, Curer Elis, Fiction
//
//
//The Tenant of Wild fell Hall, Curer Elis, Mystery
//
//
//Wuthering Heights, Acton Bell, Romance
