//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;

public class CoinChanger{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Pennies: ");
        int penny = input.nextInt();
        System.out.print("Nickels: ");
        int nickel = input.nextInt();

        System.out.print("Dimes: ");
        int dime = input.nextInt();

        System.out.print("Quarters: ");
        int quarter = input.nextInt();

        int totalMoney = penny + nickel * 5 + dime * 10 + quarter * 25;

        int cents = totalMoney % 100;

        int dollars = (totalMoney - cents)/100;

        System.out.println("Total is "+ dollars +" dollars and "+ cents +" cents");
    }
}