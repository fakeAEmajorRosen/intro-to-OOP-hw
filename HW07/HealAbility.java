//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a Heal ability interface that has the blue print of
 * perform heal method and get heal amount method.
 * @author Ting-Ying Yu
 * @version 1.0
 */
public interface HealAbility {
    /**
     * An abstrat method to perform heal on patient.
     * @param p a list of Patient objects that need to be healed
     */
    void performHeal(Patient[] p);
    /**
     * An abstrat getter method for heal amount.
     * @return the heal amout that need to be performed
     */
    int getHealAmount();
    /**
     * PROVIDED METHOD, DO NOT CHANGE
     * Sorts a list of Patients based on their compareTo method.
     * Note: this will not work until you implement compareTo in
     * Patient correctly!
     * @param patientlist a list of Patient objects to sort based on their
     *                    compareTo method
     */
    static void sortPatients(Patient[] patientlist) {
        for (int i = 1; i < patientlist.length; i++) {
            int j = i;
            while (j > 0 && patientlist[j - 1].compareTo(patientlist[j]) > 0) {
                Patient temp = patientlist[j];
                patientlist[j] = patientlist[j - 1];
                patientlist[j - 1] = temp;
                j--;
            }
        }
    }
}