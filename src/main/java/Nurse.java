public class Nurse extends Employee implements ITick, CanDrawBloodAndCare{


    private int numberOfPatients;

    public Nurse(int employeeNumber, String employeeName, int numberOfPatients) {
        super(employeeNumber, employeeName);
        this.numberOfPatients = numberOfPatients;
    }

    @Override
    public void paidSalary(Salary s) {
        this.employeeSalary+= s.nurseSalary;
        this.hasBeenPaid=true;
    }

    @Override
    public void tick() {

        this.numberOfPatients-=1;
    }
    public int getNumberOfPatients() {

        return numberOfPatients;
    }

    @Override
    public void drawBlood(Patient p) {

        p.setBloodLevel(p.getBloodLevel()-2);
        System.out.println(getEmployeeName()+ " has performed the blood drawing on \n"+ p.getPatientName()+" with success");

    }

    @Override
    public void careForPatient(Patient p) {
p.setHealthLevel(p.getHealthLevel()+2);
        System.out.println(getEmployeeName()+ " has treated \n"+ p.getPatientName()+" with success");

    }
}
