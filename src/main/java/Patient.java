public class Patient implements ITick{
   private int patientID;
   private String patientName;
    private int bloodLevel = 20;
   private int healthLevel = 10;


    public Patient(int patientID, String patientName) {
        this.patientID = patientID;
        this.patientName = patientName.toUpperCase();

    }

    public int getPatientID() {

        return patientID;
    }

    public String getPatientName() {

        return patientName;
    }

    public int getBloodLevel() {

        return bloodLevel;
    }

    public int getHealthLevel() {

        return healthLevel;
    }
    public void setBloodLevel(int bloodLevel) {
        this.bloodLevel = bloodLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    @Override
    public void tick() {
        setHealthLevel(this.getHealthLevel()-1);

    }
}
