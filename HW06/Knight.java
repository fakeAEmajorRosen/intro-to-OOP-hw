//I worked on the homework assignment alone, using only course materials.
/**
 * A class for Knight.
 * @author Ting-Ying Yu (tyu304)
 * @version 4.0
 */
public class Knight extends Adventurer {
    private boolean squire;
    /**
     * A constructor that take in name, attack, health and squire for Knight.
     * @param n name of the knight
     * @param h health number of the knight
     * @param a attack number of the knight
     * @param hasSquire whether the knight has squire or not
     */
    public Knight(String n, int h, int a, boolean hasSquire) {
        super(n, h, a);
        this.squire = hasSquire;
    }
    /**
     * A constructor that take in only aname for Knight.
     * @param n name of the knight
     */
    public Knight(String n) {
        super(n, 100, 15);
        this.squire = true;
    }
    @Override
    public void attack(Adventurer player) {
        int damage = 0;
        if (player == null) {
            return;
        }
        if (this.health <= 0) { //works???
            return;
        }
        if (this.squire) {
            damage = damage + this.attack * 2;
        } else {
            damage = damage + this.attack;
        }

        player.health = player.health - damage;
        if (player.health < 0) {
            player.health = 0;
        }
    }
    /**
     * A mehod for a knight to challenge the other knight.
     * @param k an object knight
     */
    public void challenge(Knight k) {
        if (k == null) {
            return;
        }
        if (this.health > 0 && (!this.squire) && k.squire) {
            this.attack(k); //no need to cast
            if (k.health == 0) {
                k.squire = false;
                this.squire = true;
            } else {
                k.attack(this);
            }
        }

    }
    @Override
    public boolean equals(Object newo) {
        if (this == newo) {
            return true;
        }
        if (newo == null) {
            return false;
        }
        if (!(newo instanceof Knight)) {
            return false;
        }
        Knight k = (Knight) newo;
        return super.equals(k) && this.squire == k.squire;
    }
    @Override
    public String toString() {
        return super.toString() + ", Squire: " + this.squire;
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 17;
        result = super.hashCode() + ((squire) ? 1 : 0);
        return result;
    }
}