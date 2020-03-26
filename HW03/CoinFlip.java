//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.util.Random;
public class CoinFlip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer = "y";

        while (answer.equals("y")) {
            System.out.print("\nReady to run a coin flip simulation. ");
            System.out.print("Enter the number of sequences: ");
            double numberOfSequences = input.nextDouble();
            if ((numberOfSequences != (int) numberOfSequences) || (numberOfSequences <= 0)) {
                System.out.print("Would you like to run another simulation? (y/n): ");
                answer = input.next();
                while (!answer.equals("n") && !answer.equals("y")) {
                    System.out.print("Would you like to run another simulation? (y/n): ");
                    answer = input.next();
                }
                continue;
            }

            System.out.print("How many heads should each sequence have? ");
            int headsNum = input.nextInt();
            if ((headsNum != (int) headsNum) || (headsNum < 0)) {
                System.out.print("Would you like to run another simulation? (y/n): ");
                while (!answer.equals("n") && !answer.equals("y")) {
                    System.out.print("Would you like to run another simulation? (y/n): ");
                    answer = input.next();
                }
                continue;
            }

            System.out.print("How many tails should each sequence have? ");
            int tailsNum = input.nextInt();
            if ((tailsNum != (int) tailsNum) || (tailsNum < 0)) {
                System.out.print("Would you like to run another simulation? (y/n): ");
                answer = input.next();
                while (!answer.equals("n") && !answer.equals("y")) {
                    System.out.print("Would you like to run another simulation? (y/n): ");
                    answer = input.next();
                }
                continue;
            }

            System.out.println("Simulating Sequences");




            int i = 1;
            double totalLetter = 0;
            int max = 0;
            double average = 0;
            int flippedT = 0;
            int flippedH = 0;
            while (i <= numberOfSequences) {
                System.out.printf("\n%d-", i);
                flippedT = 0;
                flippedH = 0;
                while (flippedT < tailsNum || flippedH < headsNum) {
                    Random random = new Random();
                    int randomFlip = random.nextInt(2);

                    if (randomFlip == 0) {
                        System.out.print("T");
                        flippedT = flippedT + 1;
                        totalLetter = totalLetter + 1;
                    } else {
                        System.out.print("H");
                        flippedH = flippedH + 1;
                        totalLetter = totalLetter + 1;
                    }


                    if (flippedH + flippedT > max) {
                        max = flippedH + flippedT;
                    }
                }

                i = i + 1;
            }


            average = average + (totalLetter / numberOfSequences);
            System.out.printf("\nThe average number of flips was %.2f and maximum was %d", average, max);
            System.out.printf("\nWould you like to run another simulation? (y/n): ");
            answer = input.next();

            while (!answer.equals("n") && !answer.equals("y")) {
                System.out.print("Would you like to run another simulation? (y/n):");
                answer = input.next();
                continue;
            }


        }
    }

}