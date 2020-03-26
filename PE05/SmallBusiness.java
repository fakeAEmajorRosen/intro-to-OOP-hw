//I worked on the homework assignment alone, using only course materials.
/**
 * A class for small business.
 * @author Ting-Ying Yu (tyu304)
 * @version 4.0
 */
public class SmallBusiness extends Company {
    /**
     * A constructor that takes in number of employee, name of company and building.
     * @param numE number of employee
     * @param n name of the company
     * @param b building of the company
     */
    public SmallBusiness(int numE, String n, Building b) {
        super(0, n, b);
        this.setNumEmployees(numE);
    }
    @Override
    public void setNumEmployees(int n) {
        if (n > 25) {
            n = 25;
        }
        super.setNumEmployees(n);
    }
}