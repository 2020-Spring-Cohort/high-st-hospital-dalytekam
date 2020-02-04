public class Receptionist extends Employee implements ITick  {
    private boolean isOnCall= false;

    public boolean isOnCall() {
        return isOnCall;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }

    public Receptionist(int employeeNumber, String employeeName) {
        super(employeeNumber, employeeName);

    }

    public void haveACall(){
this.setOnCall(true);
    }
    public void provideInformationToGuests(Hospital h){

        h.setNumberOfGuests(h.getNumberOfGuests()-2);
        System.out.println("The Receptionist "+getEmployeeName()+" has oriented the Guests");
    }

    @Override
    public void paidSalary(Salary s) {
        this.employeeSalary+= s.receptionistSalary;
        this.hasBeenPaid=true;
    }

    @Override
    public void tick() {

        setOnCall(! isOnCall());
    }
}
