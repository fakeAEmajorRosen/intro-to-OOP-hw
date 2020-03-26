//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a Scheduled treatmen object that perfrom
 * emergency treatment on patients.
 * @author Ting-Ying Yu
 * @version 1.0
 */
public class ScheduledTreatment extends Treatment {
    private int treatPatientID;
    /**
     * A constructor that take in a heal number and patient ID.
     * @param h a number for heal field
     * @param id the id for number
     */
    public ScheduledTreatment(int h, int id) {
        super(h);
        this.treatPatientID = id;
    }

    @Override
    public void performHeal(Patient[] p) {
        HealAbility.sortPatients(p);
        int low = 0;
        int high = p.length;
        int index = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (p[mid].getPatientID() < treatPatientID) {
                low = mid + 1;
            } else if (p[mid].getPatientID() > treatPatientID) {
                high = mid - 1;
            } else if (p[mid].getPatientID() == treatPatientID) {
                index = mid;
                break;
            }
        }
        p[index].increaseHealth(this);
    }
}