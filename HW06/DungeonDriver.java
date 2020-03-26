//I worked on the homework assignment alone, using only course materials.
/**
 * A driver class for dungeon.
 * @author Ting-Ying Yu (tyu304)
 * @version 4.0
 */
public class DungeonDriver {
    /**
     * Main method for the driver.
     * @param args main method arguments
     */
    public static void main(String[] args) {
        Knight k1 = new Knight("Galahad", 7, 6, true);
        Knight k2 = new Knight("Lancelot", 30, 5, false);
        Archer a1 = new Archer("Archie", 10, 2);
        a1.attack(k2);
        System.out.println(a1);
        System.out.println(k2);

        k1.attack(a1);
        System.out.println(k1);
        System.out.println(a1);

        a1.attack(k1);
        System.out.println(a1);
        System.out.println(k1);

        k2.attack(k1);
        System.out.println(k1);
        System.out.println(k2);

        k2.challenge(k1);
        System.out.println(k2);
        System.out.println(k1);

        k1.drink();
        System.out.println(k1);
    }
}