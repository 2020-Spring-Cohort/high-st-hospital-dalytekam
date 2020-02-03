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
    }


    @Override
    public void drawBlood(Patient p) {
        p.setBloodLevel(p.getBloodLevel()-1);

    }

    @Override
    public void careForPatient(Patient p) {
        p.setHealthLevel(p.getHealthLevel()+3);

    }
    public String getSpecialty() {
        return specialty;
    }

}
