//I worked on the homework assignment alone, using only course materials.
/**
 * Finding how cheese can be traded by Connoisseur.
 *
 * @author tyu304
 * @version 4.0
 */
public class CheeseConnoisseur {
    private String name;
    private Cheese owned;
    private double money;
    /**
     * Creates a CheeseConnoisseur with its name, money and cheese.
     *
     * @param name the name of Connoisseur
     * @param money the money that Connoisseur has
     * @param owned the cheese owned by Connoisseur
     */
    public CheeseConnoisseur(String name, double money, Cheese owned) {
        this.name = name;
        this.money = money;
        this.owned = owned;

    }
    /**
     * Creates a CheeseConnoisseur with its name and money.
     *
     * @param name the name of Connoisseur
     * @param money the money that Connoisseur has
     */
    public CheeseConnoisseur(String name, double money) {
        this(name, money, null); //Is this the right way to chain object?
    }
    /**
     * Creates a CheeseConnoisseur with its name.
     *
     * @param name the name of Connoisseur
     */
    public CheeseConnoisseur(String name) {
        this(name, 0.0);
    }
    /**
     * Creates a CheeseConnoisseur taking in nothing.
     *
     */
    public CheeseConnoisseur() {
        this("Louis Pasteur", 20.00, null);
    }
    /**
     * Create a trade by taking in what cheese the Connoisseur get.
     *
     * @param cheeseObject the cheese that you get
     */
    public void makeTrade(Cheese cheeseObject) {

        Cheese original = this.owned;
        this.owned = cheeseObject;
        if (original == null && cheeseObject == null) {
            return;
        }

        if (original == null) {
            cheeseObject.whenCheeseIsTraded(original);
        } else {
            original.whenCheeseIsTraded(cheeseObject);
        }

    }
    /**
     * Create a trade by taking in who (which Connoisseur) are you trading with.
     *
     * @param con The Connoisseur you are trading with
     */
    public void makeTrade(CheeseConnoisseur con) {
        double d = Math.abs(con.owned.getPrice() - this.owned.getPrice());
        if ((this.owned != null) && (con.owned != null)) {
            if (!this.owned.equals(con.owned)) {
                if (con.owned.getPrice() < this.owned.getPrice()) {
                    if (con.money > d) {
                        con.money = con.money - d;
                        this.money = this.money + d;
                        Cheese originalCheese = this.owned;
                        this.owned = con.owned;
                        con.owned = originalCheese;
                        this.owned.whenCheeseIsTraded(con.owned);
                    }

                } else if (con.owned.getPrice() > this.owned.getPrice()) {
                    if (this.money > d) {
                        this.money = this.money - d;
                        con.money = con.money + d;
                        Cheese originalCheese = this.owned;
                        this.owned = con.owned;
                        con.owned = originalCheese;
                        this.owned.whenCheeseIsTraded(con.owned);
                    }

                }

            }
        }

    }
}