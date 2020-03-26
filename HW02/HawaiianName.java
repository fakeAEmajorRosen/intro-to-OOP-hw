//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;

public class HawaiianName {
    public static void main(String[] args) {
        System.out.println("Welcome to Hawaii! Let's check if your name is Hawaiian enough.");
        String newName = " ";
        String answer;
        do {
            System.out.print("\nEnter your name: ");
            Scanner input = new Scanner(System.in);
            newName = " ";
            String name = input.nextLine();
            String lowName = name.toLowerCase();
            for (int i = 0; i <= (name.length() - 1); i++) {

                //     newName = newName + lowName.charAt(i);
                // };

                switch (lowName.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'k':
                case 'l':
                case 'h':
                case 'm':
                case 'n':
                    newName = newName + lowName.charAt(i);
                }
            }
            newName = newName.trim();
            boolean condition = lowName.equals(newName);
            if (!condition) {
                System.out.println("Sorry " + name + ", you aren't Hawaiian enough to come!");
                System.out.println("Let's make your name... " + newName + "!");
            }
            newName = newName.substring(0, 1).toUpperCase() + newName.substring(1);
            System.out.println("Aloha, " + newName);
            System.out.print("Would you like to try again? (y/n): ");
            answer = input.next();
        } while(answer.equals("y"));
    }
}