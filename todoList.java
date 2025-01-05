import java.util.ArrayList;
import java.util.Scanner;

public class todoList {
    public static void main(String[] args) {

        ArrayList<String> todo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\t               SIMPLE TO-DO LIST\n");
            System.out.println("\t  MENU\n");
            System.out.println("1. ADD TASK");
            System.out.println("2. REMOVE TASK");
            System.out.println("3. VIEW TASK");
            System.out.println("4. EXIT ");
            System.out.print("select and option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("\t               ADD TASK\n");
                    System.out.print("Enter task: ");
                    String taskAdd = scanner.nextLine();
                    todo.add(taskAdd);
                    System.out.println("task added successfully!");
                    break;
                case 2:
                    System.out.println("\t               REMOVE TASK\n");
                    if (todo.isEmpty()) {
                        System.out.println("To-do is empty");
                    } else {
                        for (int i = 0; i < todo.size(); i++) {
                            System.out.println((i + 1) + ". " + todo.get(i));
                        }
                        System.out.print("Enter task's number to remove or 0 to go back to Menu: ");
                        int taskRemove = scanner.nextInt();
                        if (taskRemove==0) {
                            System.out.println("Returning to Menu...");
                        } else if (taskRemove>todo.size() || taskRemove < 0) {
                            while (taskRemove>todo.size() || taskRemove < 0) {
                                System.out.println("Task's number entered is not in the list, please enter the right task's number");
                                System.out.print("Enter task's number to remove or 0 to go back to Menu: ");
                                taskRemove = scanner.nextInt();
                            }
                            todo.remove(taskRemove - 1);
                            System.out.println("task " + taskRemove + " removed successfully!");
                        }else{
                        todo.remove(taskRemove - 1);
                            System.out.println("task " + taskRemove + " removed successfully!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\t               VIEW TASK\n");
                    if (todo.isEmpty()) {
                        System.out.println("To-do is empty");
                    } else {
                        for (int i = 0; i < todo.size(); i++) {
                            System.out.println((i + 1) + ". " + todo.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting..");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option selected, please enter the right option ");
            }
        }
    }
}
