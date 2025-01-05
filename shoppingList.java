import java.util.ArrayList;
import java.util.Scanner;

public class shoppingList {
    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>();
        ArrayList<Boolean> addItemStatus = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\t           SHOPPING LIST\n");
            System.out.println("\t  MENU\n");
            System.out.println("1. Add Item");
            System.out.println("2. View Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Mark Item as Bought");
            System.out.println("5. Exit ");
        System.out.print("enter option : ");
        int option = scanner.nextInt();
        switch (option){
            case 1 :
                System.out.println("\t           ADD ITEM\n");
                System.out.print("Enter item: ");
                String addItem = scanner.next();
                shoppingList.add(addItem);
                addItemStatus.add(false);
                System.out.println("Item addded sucessfully");
                break;
            case 2 :
                System.out.println("\t           VIEW ITEM(s)\n");
                if (shoppingList.isEmpty()){
                    System.out.println("SHOPPING-LIST is empty!");
                }else {
                    int i;
                    for (i = 0; i < shoppingList.size(); i++) {
                        String status = addItemStatus.get(i) ? "[\u2713]" :  "[\u2717]";
                        System.out.println((i + 1) + ". " + shoppingList.get(i) + status);
                    }
                }
                break;
            case 3 :
                System.out.println("\t           REMOVE ITEM\n");
                if (shoppingList.isEmpty()){
                    System.out.println("SHOPPING-LIST is empty!");
                }else {
                    int i;
                    for (i = 0; i < shoppingList.size(); i++) {
                        String status = addItemStatus.get(i) ? "[\u2713]" :  "[\u2717]";
                        System.out.println((i + 1) + ". " + shoppingList.get(i) + status);
                    }
                        System.out.print("Enter item's number to remove or 0 to go back to Menu: ");
                        int removeItem = scanner.nextInt();
                        if (removeItem==0){
                            System.out.println("Exiting to Menu...");
                        } else if (removeItem>shoppingList.size() || removeItem<0) {
                            while (removeItem>shoppingList.size() || removeItem<0){
                                System.out.println("Item's number entered is not in the Shopping-List, please enter the right item's number");
                                System.out.print("Enter item's number to remove or 0 to go back to Menu: ");
                                removeItem = scanner.nextInt();
                            }
                            shoppingList.remove(removeItem-1);
                            System.out.println("Item number " + removeItem +  " successfully removed!");
                        }else {
                            shoppingList.remove(removeItem-1);
                            System.out.println("Item number " + removeItem +  " successfully removed!");
                        }
                }
                break;
            case 4 :
                System.out.println("\t           MARK ITEM\n");
                if (shoppingList.isEmpty()){
                    System.out.println("No SHOPPING-LIST to mark!");
                }else {
                    int i;
                    for (i = 0; i < shoppingList.size(); i++) {
                        String status = addItemStatus.get(i) ? "\u2713" :  "\u2717";
                        System.out.println((i + 1) + ". " + shoppingList.get(i) + " " + status);
                    }
                    System.out.print("Enter item's number bought or 0 to go back to Menu: ");
                    int markNumber = scanner.nextInt();
                    if (markNumber==0){
                        System.out.println("Exiting to Menu... ");
                    } else if (markNumber<0 || markNumber > shoppingList.size()) {
                        while (markNumber<0 || markNumber > shoppingList.size()){
                            System.out.println("The item's number entered is not on the list, please enter the right item's number");
                            System.out.print("Enter item's number bought or 0 to go back to Menu: ");
                            markNumber = scanner.nextInt();
                        }
                        addItemStatus.set(markNumber-1,true);
                        System.out.println("Item marked as bought!");
                    }else {
                        addItemStatus.set(markNumber-1,true);
                        System.out.println("Item marked as bought!");
                    }
                }
                break;

            case 5 :
                System.out.println("Exiting Shopping-Lst...");
                scanner.close();
                return;
            default:
                System.out.println("Option selected is incorrect, please enter the right option");

        }
        }
    }
}
