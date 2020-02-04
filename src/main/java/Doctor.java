import java.util.Map;

public class Doctor extends Employee implements CanDrawBloodAndCare{


    private String specialty;

    public Doctor(int employeeNumber, String employeeName, String specialty) {
        super(employeeNumber, employeeName);
        this.specialty = specialty;
    }

    @Override
    public void paidSalary(Salary s) {

        this.employeeSalary+= s.doctorSalary;
        this.hasBeenPaid=true;
    }


    @Override
    public void drawBlood(Patient p) {
        p.setBloodLevel(p.getBloodLevel()-1);
        System.out.println(getEmployeeName()+ " has performed the blood drawing on \n"+ p.getPatientName()+" with success");

    }

    @Override
    public void careForPatient(Patient p) {
        p.setHealthLevel(p.getHealthLevel()+3);
        System.out.println(getEmployeeName()+ " has treated \n"+ p.getPatientName()+" with success");
    }
    public String getSpecialty() {
        return specialty;
    }

}
