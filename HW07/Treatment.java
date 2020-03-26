//I worked on the homework assignment alone, using only course materials.
/**
 * Represent a Treatment Onject that has the heal ability interface
 * implement. Has a toString and getter method for heal field.
 * @author Ting-Ying Yu
 * @version 1.0
 */
public abstract class Treatment implements HealAbility {
    protected int heal;
    /**
     * A constructor that take in a heal number.
     * @param h a number for heal field
     */
    public Treatment(int h) {
        this.heal = h;
    }

    @Override
    public String toString() {
        return "Treatment with " + this.heal + " heal";
    }

    @Override
    public int getHealAmount() {
        return this.heal;
    }

}