public class Nurse extends Employee implements ITick, CanDrawBloodAndCare{


    private int numberOfPatients;

    public Nurse(int employeeNumber, String employeeName, int numberOfPatients) {
        super(employeeNumber, employeeName);
        this.numberOfPatients = numberOfPatients;
    }

    @Override
    public void paidSalary(Salary s) {
        this.employeeSalary+= s.nurseSalary;
    }

    @Override
    public void tick() {

        this.numberOfPatients-=3;
    }
    public int getNumberOfPatients() {

        return numberOfPatients;
    }

    @Override
    public void drawBlood(Patient p) {
p.setBloodLevel(p.getBloodLevel()-2);
    }

    @Override
    public void careForPatient(Patient p) {
p.setHealthLevel(p.getHealthLevel()+2);
    }
}
