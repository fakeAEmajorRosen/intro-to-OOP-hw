//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a Restaurant object that represent a unique restaurant that
 * has a name and some reviews.
 * @author Ting-Ying Yu
 * @version 4.0
 */
public class Restaurant {
    private String name;
    private int numReviews;
    /**
     * Initialies a Restaurant object by taking in
     * its name and the numbers of reviews.
     *
     * @param name the name of the restaurant.
     * @param numReviews the number of total reviews of the restaurant.
     */
    public Restaurant(String name, int numReviews) {
        this.name = name;
        this.numReviews = numReviews;
    }
    /**
     * Get the name of the restaurant outside of the class.
     *
     * @return the name of the restaurant.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Get the numbers of reviews of the restaurant outside of the class.
     *
     * @return the numbers of reviews.
     */
    public int getNumReviews() {
        return this.numReviews;
    }
}