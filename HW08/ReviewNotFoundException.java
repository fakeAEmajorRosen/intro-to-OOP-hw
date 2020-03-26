//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a ReviewNotFoundException exception that help identify whether the input
 * reviewer has made a review or not.
 * @author Ting-Ying Yu
 * @version 4.0
 */

public class ReviewNotFoundException extends Exception {
    /**
     * Initialies a ReviewNotFoundException object.
     *
     * Take in the word that will be printed when this exception occurs.
     *
     * @param word the message that will print out when this exceptino occurs.
     */
    public ReviewNotFoundException(String word) {
        super(word);
    }
}