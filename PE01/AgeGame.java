//I worked on the homework assignment alone, using only course materials.
public class AgeGame{
    public static void main(String[] args) {
        int birthYear = 1998;
        int imputNumber = 9;
        int ageCalculation = imputNumber;
        ageCalculation *= 2;
        ageCalculation += 5; 
        ageCalculation *= 100;
        ageCalculation += 3538;
        ageCalculation /= 2;
        ageCalculation -= birthYear;
        int age = ageCalculation % 100;
        System.out.println("Age: "+ age);
    }
}