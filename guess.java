import java.util.Random;
import java.util.Scanner;

public class guess {
    public static void main(String[] args) {
        System.out.println("\t           GUESS GAME");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(1, 101);
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();
        if (guess==number){
            System.out.println("Hoooray! You guess right. ");
        } else if (guess<number) {
            System.out.println("Ooops, your guess is too low");
        }else {
            System.out.println("Ooops, your guess is too high");
        }
        System.out.println("The number is " + number + ".");
    }
}
