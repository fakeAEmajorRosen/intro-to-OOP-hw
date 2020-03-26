//I worked on the homework assignment alone, using only course materials.
/**
 * Finding how cheese is traded.
 *
 * @author tyu304
 * @version 4.0
 */
public class Cheese {
    private String type;
    private double price;
    private boolean sentient;
    private int countSpecific;
    private static int countAll;
    /**
     * Creates a Cheese with its price, type, and how many time it has been traded.
     *
     * @param price the price of the cheese
     * @param type the type of the cheese
     * @param countSpecific how many time this specific cheese has been traded
     */
    public Cheese(double price, String type, int countSpecific) {
        this.price = price;
        this.type = type;
        this.countSpecific = countSpecific;

        if (this.countSpecific >= 3) {
            this.sentient = true;
        } else {
            this.sentient = false; //is it false from the beginning?
        }
    }
    /**
     * Creates a Cheese with its price and type.
     *
     * @param price the price of the cheese
     * @param type the type of the cheese
     */
    public Cheese(double price, String type) {
        this(price, type, 0);
        this.sentient = false;
        //this.countSpecific = 0;
    }
    /**
     * A toString method that print out the data of the cheese.
     *
     * @return a description of the cheese
     */
    public String toString() {
        if (this.sentient) {
            return "I am a slice of " + this.type + "cheese that has been traded "
                + this.countSpecific + " times";
        } else {
            return "This is a slice of " + this.type + "cheese that has bee traded "
                + this.countSpecific + " times";
        }

    }
    /**
     * A equals method that check whether two cheeses are the same.
     *
     * @param object the cheese that you are checking
     * @return whether two cheeses are the same
     */
    public boolean equals(Cheese object) {
        if (object == null) {
            return false;
        } else {
            return object.type == this.type && object.price == this.price
                && object.sentient == this.sentient;
        }
    }
    /**
     * Process what will happen during the trade:
     * the increment of the times of trade and
     * the change of sentient valule.
     *
     * @param anotherCheese the cheese that you are trading
     */
    public void whenCheeseIsTraded(Cheese anotherCheese) {
        // Count for the trade for your cheese and the overall class
        this.countSpecific = this.countSpecific + 1;
        Cheese.countAll = Cheese.countAll + 1;
        //Since you don't want to print I'm alive twice, you check your sentient condition first
        if (!this.sentient) {
            // Check if this is sentient after this trade first
            if (this.countSpecific >= 3) {
                this.sentient = true;
            } else {
                this.sentient = false;
            }
            // then you double the price and print line
            if (this.sentient) {
                this.price = this.price * 2;
                System.out.println("I'm ALIIIIIVE!");
            }
        }
        //check null pointer for the param
        if (anotherCheese != null) {
            anotherCheese.countSpecific = anotherCheese.countSpecific + 1;
            if (!anotherCheese.sentient) {
                //same thing as the privous
                if (anotherCheese.countSpecific >= 3) {
                    anotherCheese.sentient = true;
                } else {
                    anotherCheese.sentient = false;
                }

                if (anotherCheese.sentient) {
                    anotherCheese.price = anotherCheese.price * 2;
                    System.out.println("I'm ALIIIIIVE!");
                }
            }
        }

    }

    //getters and setters???
    /**
     * Get the data of how many time does has the cheese been traded.
     * @return how many time this specific cheese has been traded
     */
    public int getCountSpecific() {
        return this.countSpecific;
    }
    /**
     * Set how many time does has the cheese been traded.
     * @param num a number for trade count
     */
    public void setCountSpecific(int num) {
        this.countSpecific = num;
    }
    /**
     * Get the data of whether the cheese is sentient or not.
     * @return whether it is sentient or not
     */
    public boolean getSentient() {
        return this.sentient;
    }
    /**
     * Set the cheese's sentient condition.
     * @param b a boolean for sentient condition
     */
    public void setSentient(boolean b) {
        this.sentient = b;
    }
    /**
     * Get the data of the cheese's price.
     * @return the cheese's price
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * Set the data of the cheese's price.
     * @param d the cheese's price
     */
    public void setPrice(double d) {
        this.price = d;
    }
    /**
     * Get the number of how many trade has been made through out the whole thing.
     * @return how many trade has been made through out the whole thing
     */
    public int getCountAll() {
        return countAll;
    }
    /**
     * Set the number of how many trade has been made through out the whole thing.
     * @param num how many trade has been made through out the whole thing
     */
    public void setCountAll(int num) {
        Cheese.countAll = num;
    }
}