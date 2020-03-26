import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Testing {
    public static void main(String[] args) {
        File f = new File("database_restaurants");
        File[] list = f.listFiles();
        ArrayList<Restaurant> arr = new ArrayList<Restaurant>();
        ArrayList<Restaurant> aLs= loadHelper(f,arr); 
        for (Restaurant r:aLs) {
            System.out.println(r.getName());
        }
        readReview(f, aLs,"Mcdonalds", "Eric");



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

    


}