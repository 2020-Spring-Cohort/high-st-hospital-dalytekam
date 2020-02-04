public class EmergencyDispatcher extends Receptionist implements CanDrawBloodAndCare{
    public EmergencyDispatcher(int employeeNumber, String employeeName) {
        super(employeeNumber, employeeName);
    }

    @Override
    public void drawBlood(Patient p) {
        p.setBloodLevel(p.getBloodLevel()-3);
        System.out.println(getEmployeeName()+ " has performed the blood drawing on \n"+ p.getPatientName()+" with success");


    }

    @Override
    public void careForPatient(Patient p) {
    p.setHealthLevel(p.getHealthLevel()+1);
        System.out.println(getEmployeeName()+ " has treated \n"+ p.getPatientName()+" with success");

    }
}
