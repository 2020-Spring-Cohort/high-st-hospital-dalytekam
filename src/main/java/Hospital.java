import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private Map<String, Employee> employeesList = new HashMap<String,Employee>();
    private Map<String, Patient> patientsList = new HashMap<String,Patient>();
    public Salary sal;
    private int cleanliness;
    private int numberOfGuests;
    private double billAmount;

    public Hospital(int cleanliness, int numberOfGuests, double billAmount) {
        this.cleanliness = cleanliness;
        this.numberOfGuests = numberOfGuests;
        this.billAmount = billAmount;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }




    public Map<String, Employee> getEmployeesList() {
        return employeesList;
    }

    public Map<String, Patient> getPatientsList() {
        return patientsList;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public int getNumberOfGuests() {

        return numberOfGuests;
    }

    public double getBillAmount() {

        return billAmount;
    }

    public void hireEmployee(Employee employeeToHire){
        getEmployeesList().put(employeeToHire.getEmployeeName(),employeeToHire);

    }
    public void fireEmployee(String employeeNameToFire){
        for(Map.Entry<String,Employee> emp: getEmployeesList().entrySet()){
            if(emp.getKey().equalsIgnoreCase(employeeNameToFire)){
                getEmployeesList().remove(emp);
            } else{
                System.out.println(employeeNameToFire+ "is not part of our Staff");
            }

        }

    }
    public void payAllEmployees(Salary sal){
        for(Map.Entry<String, Employee> emp : getEmployeesList().entrySet()){
            emp.getValue().paidSalary(sal);
        }

    }
    public void searchForAnEmployee(String employeeNameToSearch){
        for(Map.Entry<String,Employee> emp: getEmployeesList().entrySet()){
            if(emp.getKey().equalsIgnoreCase(employeeNameToSearch)){
                System.out.println(employeeNameToSearch+ "is an employee here");
            } else{
                System.out.println(employeeNameToSearch+ "is not part of our Staff");
            }

        }

    }
    public void payBills(double amountToPay){
        setBillAmount(getBillAmount()-amountToPay);

    }
    public void admitAPatient(Patient patientToAdmit){
        getPatientsList().put(patientToAdmit.getPatientName(),patientToAdmit);

    }
}
