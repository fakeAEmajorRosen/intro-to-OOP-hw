//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;


public class TipCalculator {
    public static void main(String[] args) {
        double subtotPrice = 0;
        int itemNum = 1;
        int condition = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to Tip Calculator!\n\nEnter the prices of your item.");
        System.out.println(" Enter -1 to enter tip percentage.");
        double itemPrice = 0;

        while (itemPrice != -1) {
            System.out.print("Item " + itemNum + ": $");
            itemPrice = input.nextDouble();
            subtotPrice = subtotPrice + itemPrice;
            itemNum = itemNum + 1;

        }

        subtotPrice = subtotPrice + 1;

        System.out.print("\nEnter the tip percentage:");
        double tip = input.nextDouble();
        tip = subtotPrice * tip;
        double totPrice = tip + subtotPrice;


        System.out.format("\nSubtotal: $%.2f\n", subtotPrice);
        System.out.format("Tip:      $%.2f\n", tip);
        System.out.format("Total:    $%.2f\n", totPrice);

    }
}