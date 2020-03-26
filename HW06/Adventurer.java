//I worked on the homework assignment alone, using only course materials.
/**
 * A class for Adventurer.
 * @author Ting-Ying Yu (tyu304)
 * @version 4.0
 */
public abstract class Adventurer {
    private String name;
    protected final int attack;
    protected int health;
    /**
     * A constructor that take in name, attack and health for Adventurer.
     * @param n name of the adventurer
     * @param h health number of the adventurer
     * @param a attack number of the adventurer
     */
    public Adventurer(String n, int h, int a) {
        this.name = n;
        this.attack = a;
        this.health = h;
    }
    /**
     * A abstract method for Adventurer to attack.
     * @param player the adventurer that you are attacking
     */
    public abstract void attack(Adventurer player);
    /**
     * A method for the adventurer to drink potion.
     */
    public void drink() {
        this.health = this.health + 15;
    }

    @Override
    public boolean equals(Object newo) {
        if (this == newo) {
            return true;
        }
        if (newo == null) {
            return false;
        }
        if (!(newo instanceof Adventurer)) {
            return false;
        }
        Adventurer a = (Adventurer) newo;
        return this.attack == a.attack && this.health == a.health
            && this.name.equals(a.name);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Health: " + this.health
            + ", Attack: " + this.attack;
    }
    /**
     * A getter to get the adventurer's attack number.
     * @return attack number
     */
    public int getAttack() {
        return this.attack;
    }
    /**
     * A getter to get the adventurer's health number.
     * @return health number
     */
    public int getHealth() {
        return this.health;
    }
    /**
     * A setter to set the adventurer's health number.
     * @param h health number that we want to set
     */
    public void setHealth(int h) {
        this.health = h;
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 17;
        result = prime * result + attack;
        result = prime * result + name.hashCode();
        result = prime * result + health;
        return result;
    }
}