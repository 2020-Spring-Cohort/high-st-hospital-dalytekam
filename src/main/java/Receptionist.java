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
if(h.getNumberOfGuests()>0){
    h.setNumberOfGuests(h.getNumberOfGuests()-2);
    if(h.getNumberOfGuests()<0){
        h.setNumberOfGuests(0);
    }
    System.out.println("The Receptionist "+getEmployeeName()+" has oriented the Guests");
}else if(h.getNumberOfGuests()==0){

    System.out.println("There is no more Guests in the Hospital, \n That is why "+ getEmployeeName()+" is chilling");
}



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
