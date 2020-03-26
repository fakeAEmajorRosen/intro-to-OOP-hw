//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * The YelpDB class help read the reviews of the specific restaurant and count the number of restaurants.
 * It also helps reading the rate in the review.
 * @author Ting-Ying Yu
 * @version 4.0
 */
public class YelpDB {
    /**
     * Main method that check every other method works.
     * @param args the arguments in the command prompt.
     */
    public static void main(String[] args) {
        File dir = new File("database_restaurants");
        File[] reviewList = readReviewHelper(dir, "Satto");
        for (File r:reviewList) {
            System.out.println(r.getName());
        }
        ArrayList<Restaurant> list = YelpDB.load(dir);
        // int numRes = YelpDB.countNumReviews(list);
        // System.out.println(numRes);
        for (Restaurant r:list) {
            System.out.println(r.getName());
        }
        try {
            System.out.print(YelpDB.readReview(dir, list, args[0], args[1]));
        } catch (NotARestaurantException e) {
            System.out.println(e.getMessage());
        } catch (ReviewNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // int num = YelpDB.countNumReviews(list);

    }
    /**
     * The method that return the arraylist that contains every restaurant name.
     * @param f the directory that you are finding.
     * @return an arraylist with all the valid restaurants in the database.
     */
    public static ArrayList<Restaurant> load(File f) {
        ArrayList<Restaurant> arr = new ArrayList<Restaurant>();
        return loadHelper(f, arr);
    }
    /**
     * The method that help the load method.
     * @param f the directory that you are finding.
     * @param arr an empty array list.
     * @return an arraylist with all the valid restaurants in the database.
     */
    public static ArrayList<Restaurant> loadHelper(File f, ArrayList<Restaurant> arr) {
        String name = f.getName();
        if (f.isDirectory() && !name.startsWith("restaurant")) {
            File[] list = f.listFiles();
            for (File fh : list) {
                loadHelper(fh, arr);
            }
        }

        if (f.isDirectory() && name.startsWith("restaurant")) {
            String rName = f.getName().substring(10, name.length());
            File[] reviewlist = f.listFiles();
            Restaurant r = new Restaurant(rName, reviewlist.length);
            arr.add(r);
        }

        return arr;
    }
    /**
     * The method that count how many review are there.
     * @param arr the list that probably contains all the restaurant name.
     * @return the numbers of the resturant.
     */
    public static int countNumReviews(ArrayList<Restaurant> arr) {
        int tot = 0;
        for (Restaurant r : arr) {
            int x = r.getNumReviews();
            tot = tot + x;
        }
        return tot;
    }

    /**
     * The method that read out the review of a certain restaurant for a certain reviewer.
     * @param f a file name or a directory that you are going to find.
     * @param arr the list that probably contains all the restaurant name.
     * @param resName the name of the restaurant.
     * @param reviewer the name of the reviewer.
     * @throws NotARestaurantException In case the passed-in restaurant is not valid.
     * @throws ReviewNotFoundException In case the passed-in review is not valid.
     * @return the numbers of the rating.
     */
    public static double readReview(File f, ArrayList<Restaurant> arr, String resName, String reviewer)
        throws ReviewNotFoundException, NotARestaurantException {
        String reviewStr = "";
        String n = f.getName();
        double rate = 0;
        Boolean isRev = false;
        Boolean isRes = false;

        for (Restaurant r:arr) {
            if (r.getName().equals(resName)) {
                isRes = true;
            }
        }

        if (!isRes) {
            throw new NotARestaurantException();
        }

        File[] reviewList = readReviewHelper(f, resName);
        for (File rev:reviewList) {
            if (rev.getName().equals("review" + reviewer + ".txt")) {
                f = rev;
                isRev = true;
            }
        }
        // System.out.println("\n" + f.getName());
        if (!isRev) {
            throw new ReviewNotFoundException("That is not a review!");
        }

        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.startsWith("Rating:")) {
                    reviewStr = line.substring(8);
                    rate = Double.parseDouble(reviewStr);
                }
            }
        } catch (FileNotFoundException e) {
            throw new ReviewNotFoundException("That is not a review!");
        }

        return rate;

    }

    /**
     * The helper method for readReview.
     * @param f a file name or a directory that you are going to find.
     * @param resName the name of the restaurant.
     * @return the list of reviews for this restaurant.
     */
    public static File[] readReviewHelper(File f, String resName) {
        String name = f.getName();
        String restaurantFullName = "restaurant" + resName;
        File[] reviewlist = new File[0];

        if (!name.equals(restaurantFullName)) {
            File[] list = f.listFiles();
            if (!list[0].isFile()) {
                for (File fh : list) {
                    File[] posRevList = YelpDB.readReviewHelper(fh, resName);

                    if (posRevList.length != 0) {
                        reviewlist = posRevList;
                    }
                }
            }

        } else {
            reviewlist = f.listFiles();
        }

        return reviewlist;
    }

}