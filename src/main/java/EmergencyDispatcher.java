public class EmergencyDispatcher extends Receptionist implements CanDrawBloodAndCare{
    public EmergencyDispatcher(int employeeNumber, String employeeName, boolean isOnCall) {
        super(employeeNumber, employeeName, isOnCall);
    }

    @Override
    public void drawBlood(Patient p) {
        p.setBloodLevel(p.getBloodLevel()-3);

    }

    @Override
    public void careForPatient(Patient p) {
    p.setHealthLevel(p.getHealthLevel()+1);
    }
}
