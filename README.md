import java.util.ArrayList;
import java.util.Scanner;

public class todoList {
    public static void main(String[] args) {

        ArrayList<String> todo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
        System.out.println("\t               SIMPLE TO-DO LIST\n");
        System.out.println("1. ADD TASK");
        System.out.println("2. REMOVE TASK");
        System.out.println("3. VIEW TASK");
        System.out.println("4. EXIT ");
        System.out.print("select and option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1 :
                System.out.println("\t               ADD TASK\n");
                System.out.print("Enter task: ");
                String taskAdd = scanner.nextLine();
                todo.add(taskAdd);
                System.out.println("task added successfully!");
                break;
            case 2 :
                System.out.println("\t               REMOVE TASK\n");
                if (todo.isEmpty()) {
                    System.out.println("To-do is empty");
                }else {
                    for (int i = 0; i < todo.size(); i++) {
                        System.out.println((i + 1) + ". " + todo.get(i));
                    }
                        System.out.print("Enter task to remove: ");
                        int taskRemove = scanner.nextInt();
                        todo.remove(taskRemove);
                        System.out.println("task removed successfully!");
                    }
                break;
            case 3 :
                System.out.println("\t               VIEW TASK\n");
                if (todo.isEmpty()){
                    System.out.println("To-do is empty");
                }else {
                    for(int i = 0; i<todo.size();i++){
                        System.out.println((i+1) + ". " + todo.get(i));
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
