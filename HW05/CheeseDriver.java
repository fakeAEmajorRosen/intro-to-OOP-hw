//I worked on the homework assignment alone, using only course materials.
/**
 * Trading cheese!
 *
 * @author tyu304
 * @version 4.0
 */
public class CheeseDriver {
    /**
     * Drive main method.
     *
     * @param args command window arguments
     */
    public static void main(String[] args) {
        Cheese cheese1 = new Cheese(50, "A");
        Cheese cheese2 = new Cheese(60, "B");
        Cheese cheese3 = new Cheese(40, "C");
        Cheese cheese4 = new Cheese(90, "D");


        CheeseConnoisseur con1 = new CheeseConnoisseur("Name", 1000);
        CheeseConnoisseur con2 = new CheeseConnoisseur("Other", 1000, cheese3);

        con1.makeTrade(cheese1);
        System.out.println("1: " + cheese1.getCountSpecific());
        System.out.println("3: " + cheese3.getCountSpecific());
        con1.makeTrade(con2);
        System.out.println("1: " + cheese1.getCountSpecific());
        System.out.println("3: " + cheese3.getCountSpecific());
        con1.makeTrade(con2);
        System.out.println("1: " + cheese1.getCountSpecific());
        System.out.println("3: " + cheese3.getCountSpecific());
        con1.makeTrade(con2);
        System.out.println("1: " + cheese1.getSentient());
        System.out.println("1: " + cheese1.getCountSpecific());
        System.out.println("3: " + cheese3.getSentient());
        System.out.println("3: " + cheese3.getCountSpecific());

        con1.makeTrade(cheese2);
        System.out.println("2: " + cheese2.getCountSpecific());
        con1.makeTrade(con2);
        System.out.println("2: " + cheese2.getCountSpecific());
        con1.makeTrade(con2);
        System.out.println("2: " + cheese2.getCountSpecific());
        con1.makeTrade(con2);
        System.out.println("2: " + cheese2.getSentient());
        System.out.println("2: " + cheese2.getCountSpecific());

        System.out.println(cheese2.toString());


    }
}