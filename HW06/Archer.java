//I worked on the homework assignment alone, using only course materials.
/**
 * A class for Knight.
 * @author Ting-Ying Yu (tyu304)
 * @version 4.0
 */
public class Archer extends Adventurer {
    private int arrow = 10;
    /**
     * A constructor that take in name, attack, health for Archer.
     * @param n name of the archer
     * @param h health number of the archer
     * @param a attack number of the archer
     */
    public Archer(String n, int h, int a) {
        super(n, h, a);
    }
    /**
     * A constructor that only take in the name for Archer.
     * @param n name of the archer
     */
    public Archer(String n) {
        this(n, 75, 40);
    }
    @Override
    public void attack(Adventurer player) {
        int damage = this.attack;
        if (player == null) {
            return;
        }
        if (this.arrow < 1 | this.health <= 0) {
            return;
        }
        player.health = player.health - damage;
        if (player.health < 0) {
            player.health = 0;
        }
        this.arrow = this.arrow - 1;
    }
    @Override
    public boolean equals(Object newo) {
        if (this == newo) {
            return true;
        }
        if (newo == null) {
            return false;
        }
        if (!(newo instanceof Archer)) {
            return false;
        }
        Archer a = (Archer) newo;
        return super.equals(a);
    }
    @Override
    public String toString() {
        return super.toString() + ", Arrows: " + this.arrow;
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 17;
        result = super.hashCode();
        return result;
    }
}