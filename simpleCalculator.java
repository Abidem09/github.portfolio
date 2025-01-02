import java.util.Scanner;

public class simpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of operation: ");
        int size = scanner.nextInt();
        System.out.print("Enter the first number: ");
        double result = scanner.nextDouble();
        for (int i = 0; i<size-1; i++){
            System.out.print("Enter the operator(+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            System.out.print("Enter the next number: ");
           double nextNumber = scanner.nextDouble();
           switch (operator){
               case '+' -> result += nextNumber;
               case '-' -> result -= nextNumber;
               case '*' -> result *= nextNumber;
               case '/' -> {
                   if (nextNumber!=0){
                       result /= nextNumber;
                   }else {
                       System.out.println("Operation is invalid!, please enter another number");
                   }
               }
           }
        }
        System.out.println("Total = " + result);
    }
}
