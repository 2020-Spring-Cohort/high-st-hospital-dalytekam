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
        System.out.println("All Employees have been successfully paid");
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
        if(getBillAmount()>=amountToPay){
        setBillAmount(getBillAmount()-amountToPay);
            System.out.println("The Bills has been successfully paid");
        }else{
            System.out.println("The Bills amount is only "+getBillAmount()+"\nYou have to paid that amount or less, It is up to you");
        }

    }
    public void admitAPatient(Patient patientToAdmit){
        getPatientsList().put(patientToAdmit.getPatientName(),patientToAdmit);
        System.out.println(patientToAdmit.getPatientName()+" has been successfully admitted");

    }
    public void displayAllEmployees(){
        System.out.println("                                                LIST OF EMPLOYEES");
        System.out.println(" ");
        String headerAlignFormat = "| %-4s | %-10s | %-23s | %-10s | %-10s | %-15s | %-10s | %-10s | %-12s|%n";
        System.out.printf(headerAlignFormat,"ID ","NAME","PROFESSION","SALARY","SPECIALTY ","HAS BEEN PAID","SWEEPING","PATIENTS","IS ON CALL");
        System.out.println("___________________________________________________________________________________________________________________________________");
        String doctorFormat= "| %-4d | %-10s | %-23s | %-10.2f | %-10s | %-15b | %-10s | %-10s |%-12s |%n";
        String nurseFormat = "| %-4d | %-10s | %-23s | %-10.2f | %-10s | %-15b | %-10s | %-10d |%-12s |%n";
        String janitorFormat= "| %-4d | %-10s | %-23s | %-10.2f | %-10s | %-15b | %-10b | %-10s |%-12s |%n";
        String receptionistFormat ="| %-4d | %-10s | %-23s | %-10.2f | %-10s | %-15b | %-10s | %-10s |%-12b |%n";
        for(Map.Entry<String, Employee> emp : getEmployeesList().entrySet()){
if(emp.getValue() instanceof Doctor){
    System.out.printf(doctorFormat,emp.getValue().getEmployeeNumber(),emp.getValue().getEmployeeName(),emp.getValue().getClass().getSimpleName(),emp.getValue().getEmployeeSalary(),((Doctor) emp.getValue()).getSpecialty(),emp.getValue().isHasBeenPaid(),"N/A","N/A","N/A");
}else if(emp.getValue() instanceof Nurse){
    System.out.printf(nurseFormat,emp.getValue().getEmployeeNumber(),emp.getValue().getEmployeeName(),emp.getValue().getClass().getSimpleName(),emp.getValue().getEmployeeSalary(),"N/A",emp.getValue().isHasBeenPaid(),"N/A",((Nurse) emp.getValue()).getNumberOfPatients(),"N/A");

}else if(emp.getValue() instanceof Janitor){
    System.out.printf(janitorFormat,emp.getValue().getEmployeeNumber(),emp.getValue().getEmployeeName(),emp.getValue().getClass().getSimpleName(),emp.getValue().getEmployeeSalary(),"N/A",emp.getValue().isHasBeenPaid(),((Janitor) emp.getValue()).isSweeping(),"N/A","N/A");

}else if(emp.getValue() instanceof Receptionist){
    System.out.printf(receptionistFormat,emp.getValue().getEmployeeNumber(),emp.getValue().getEmployeeName(),emp.getValue().getClass().getSimpleName(),emp.getValue().getEmployeeSalary(),"N/A",emp.getValue().isHasBeenPaid(),"N/A","N/A",((Receptionist) emp.getValue()).isOnCall());

}
            System.out.println("___________________________________________________________________________________________________________________________________");


        }

    }
    public void displayAllPatients(){
        System.out.println("                           LIST OF PATIENTS");
        System.out.println(" ");
        String headerAlignFormat = "| %-12s | %-10s | %-15s | %-15s |%n";
        System.out.printf(headerAlignFormat,"PATIENT ID ","NAME","BLOOD LEVEL","HEALTH LEVEL");
        System.out.println("_________________________________________________________________");
        String patientFormat= "| %-12d | %-10s | %-15d | %-15d |%n";
        for(Map.Entry<String, Patient> patient : getPatientsList().entrySet()){
            System.out.printf(patientFormat,patient.getValue().getPatientID(),patient.getValue().getPatientName(),patient.getValue().getBloodLevel(),patient.getValue().getHealthLevel());

            System.out.println("_________________________________________________________________");
        }

    }
    public void displayHospitalStatus(){
        System.out.println("                           HOSPITAL STATUS");
        System.out.println(" ");
        String headerAlignFormat = "| %-20s | %-20s | %-20s |%n";
        System.out.printf(headerAlignFormat,"CLEANLINESS ","BILL AMOUNT","NUMBER OF GUESTS");
        System.out.println("______________________________________________________________________");
        String hospitalFormat= "| %-20d | %-20.2f | %-20d |%n";

            System.out.printf(hospitalFormat,getCleanliness(),getBillAmount(),getNumberOfGuests());

            System.out.println("______________________________________________________________________");


    }

}
