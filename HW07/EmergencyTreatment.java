//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a Emergency treatmen object that perfrom
 * emergency treatment on patients.
 * @author Ting-Ying Yu
 * @version 1.0
 */
public class EmergencyTreatment extends Treatment {
    /**
     * This is a constructor take in heal.
     * @param h a list of patients that need to be treated
     */
    public EmergencyTreatment(int h) {
        super(h);
    }

    @Override
    public void performHeal(Patient[] p) {

        if (p.length == 0) {
            return;
        }
        int index = 0;
        int min = p[0].getHealth();
        for (int i = 1; i < p.length; i++) {
            if (p[i].getHealth() <= min) {
                min = p[i].getHealth();
                index = i;
            }
        }
        p[index].increaseHealth(this);
    }
}