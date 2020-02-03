import java.util.HashMap;

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
        System.out.println(employeeToHire.getEmployeeName()+" has been hired");

    }
    public void fireEmployee(String employeeNameToFire){
        if(getEmployeesList().containsKey(employeeNameToFire)){
            getEmployeesList().remove(employeeNameToFire);
            System.out.println(employeeNameToFire+" has been fired");
        }else{
            System.out.println(employeeNameToFire+" has never worked here");
        }

    }
    public void payAllEmployees(Salary sal){
        for(Map.Entry<String, Employee> emp : getEmployeesList().entrySet()){
            emp.getValue().paidSalary(sal);
        }

    }
    public void searchForAnEmployee(String employeeNameToSearch){
        if(getEmployeesList().containsKey(employeeNameToSearch)){
            System.out.println(employeeNameToSearch+ " is an employee here");
        }
            else{
                System.out.println(employeeNameToSearch+ " is not part of our Staff");
            }
    }

    public void payBills(double amountToPay){
        setBillAmount(getBillAmount()-amountToPay);

    }
    public void admitAPatient(Patient patientToAdmit){
        getPatientsList().put(patientToAdmit.getPatientName(),patientToAdmit);

    }
    public void displayAllEmployees(){
        for(Map.Entry<String, Employee> emp : getEmployeesList().entrySet()){
            System.out.println("-------------------");
            System.out.println("Employee ID: " +emp.getValue().getEmployeeNumber());
            System.out.println("Employee Name: " +emp.getValue().getEmployeeName());
            System.out.println("Profession :"+emp.getValue().getClass().getSimpleName());
            System.out.println("Salary: "+emp.getValue().getEmployeeSalary());
            if(emp.getValue().getClass().getSimpleName().equalsIgnoreCase("Doctor")) {
            System.out.println("Specialty :"+((Doctor) emp.getValue()).getSpecialty());
}

            if(emp.getValue().getClass().getSimpleName().equalsIgnoreCase("Nurse")) {
                System.out.println("Number of Patients :"+((Nurse) emp.getValue()).getNumberOfPatients());
            }
        }

    }
    public void displayAllPatients(){
        for(Map.Entry<String, Patient> patient : getPatientsList().entrySet()){
            System.out.println("-------------------");
            System.out.println("Patient ID: " +patient.getValue().getPatientID());
            System.out.println("Patient Name: " +patient.getValue().getPatientName());
            System.out.println("Blood Level :"+patient.getValue().getBloodLevel());
            System.out.println("Health Level: "+patient.getValue().getHealthLevel());
        }

    }

}
