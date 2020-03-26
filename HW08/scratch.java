import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
class Scratch {
        public static void main(String[] args) {
            File f = new File("database_restaurants");
            File[] list = f.listFiles();
            ArrayList<Restaurant> arr = new ArrayList<Restaurant>();
            ArrayList<Restaurant> aLs= loadHelper(f,arr);
            for (Restaurant r:aLs) {
                System.out.println(r.getName());
                System.out.println(r.getNumReviews());
            }
            String str = readReview(f, aLs,"Mcdonalds", "Eric");
            System.out.println(str);



            // if (f.isDirectory()) {
            //        System.out.println( "Directory of ");
            // }
        }

        public static ArrayList<Restaurant> loadHelper(File f, ArrayList<Restaurant>arr) {
            String name = f.getName();
            if (f.isDirectory() && !name.startsWith("restaurant")) {
                File[] list = f.listFiles();
                for (File fh:list) {
                    loadHelper(fh,arr);
                }
            }

            if (f.isDirectory() && name.startsWith("restaurant")) {
                String rName = f.getName().substring(10,name.length());
                File[] reviewlist = f.listFiles();
                Restaurant r = new Restaurant(rName,reviewlist.length);
                arr.add(r);
            }

            return arr;
        }

        public static String readReview(File f, ArrayList<Restaurant> arr, String resName, String reviewer) {
            String reviewStr = "";
            String n = f.getName();
            try{
                Boolean isRes = false;
                for (Restaurant r:arr) {
                    if (r.getName() == resName) {
                        isRes = true;
                    }
                }
                if (isRes) {
                    String name = f.getName();
                    if (f.isDirectory() && !(n == "restaurant" + resName)) {
                        File[] list = f.listFiles();
                        for (File fh:list) {
                            readReview(fh,arr, resName, reviewer);
                        }

                    }

                    if (f.isDirectory() && (n == "restaurant" + resName)) {
                        File[] reviewlist = f.listFiles();
                        Boolean isRev = false;
                        for (File rev:reviewlist) {
                            if (rev.getName() == "review" + reviewer) {
                                isRev = true;
                            }
                        }
                        if (isRev) {
                            Scanner sc = new Scanner(new File("review" + reviewer + ".txt"));
                            while (sc.hasNextLine()) {
                                String line = sc.nextLine();
                                if (line.startsWith("Rating")){
                                    reviewStr = line.substring(8,line.length());
                                }
                            }
                        } else {
                            throw new ReviewNotFoundException("ha");
                        }

                    }
                } else {
                    throw new NotARestaurantException();
                }

            } catch (FileNotFoundException e) {

            } catch (NotARestaurantException e) {
                System.out.println(e.getMessage());
            } catch (ReviewNotFoundException e) {
                System.out.println(e.getMessage());
            }

            return reviewStr;
        }


    }
