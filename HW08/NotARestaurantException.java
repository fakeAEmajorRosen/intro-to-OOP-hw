//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a NotARestaurantException exception that help identify whether the input
 * is a restaurant or not.
 * @author Ting-Ying Yu
 * @version 4.0
 */
public class NotARestaurantException extends RuntimeException {
    /**
     * Initialies a NotARestaurantException object.
     *
     * Print out "That is not a restaurant we know!" when this exception occurs.
     */
    public NotARestaurantException() {
        super("That is not a restaurant we know!");
    }
}