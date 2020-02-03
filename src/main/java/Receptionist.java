public class Receptionist extends Employee implements ITick  {
    private boolean isOnCall= false;

    public boolean isOnCall() {
        return isOnCall;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }

    public Receptionist(int employeeNumber, String employeeName, boolean isOnCall) {
        super(employeeNumber, employeeName);
        this.isOnCall = isOnCall;
    }

    public void haveACall(){
this.setOnCall(true);
    }
    public void provideInformationToGuests(Hospital h){

        h.setNumberOfGuests(h.getNumberOfGuests()-2);
    }

    @Override
    public void paidSalary(Salary s) {
        this.employeeSalary+= s.receptionistSalary;
    }

    @Override
    public void tick() {
        setOnCall(! isOnCall());
    }
}
