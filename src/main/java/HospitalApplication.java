import java.util.Map;

public class HospitalApplication {
    public static void main(String[] args) {

        // initializing the App( Create and hire Doctors, Nurses, Janitor, Patient, ect ...)

        Doctor doc1 = new Doctor(100,"Dan","Cardiolog");
        Doctor doc2 = new Doctor(101,"John","Surgeon");
        Nurse nur1 = new Nurse(200,"Anna",20);
        Nurse nur2 = new Nurse(201,"Sonia",15);
        Janitor jan = new Janitor(300,"Bryan",false);
        Receptionist rec = new Receptionist(400,"Mike",false);
        Patient pat1 = new Patient(500,"Nash");
        Patient pat2 = new Patient(501,"Jolene");
        Hospital hospital = new Hospital(20,20,36000.00);
        EmergencyDispatcher ed = new EmergencyDispatcher(600,"Tina",false);

        Salary salary = new Salary();


        hospital.hireEmployee(doc1);
        hospital.hireEmployee(doc2);
        hospital.hireEmployee(nur1);
        hospital.hireEmployee(nur2);
        hospital.hireEmployee(jan);
        hospital.hireEmployee(rec);
        hospital.hireEmployee(ed);
        hospital.admitAPatient(pat1);
        hospital.admitAPatient(pat2);

        // Pay salary
        hospital.payAllEmployees(salary);
        System.out.println("All Employees has been paid");
        System.out.println("this is the detail");
        System.out.println("");

        for(Map.Entry<String,Employee> emp: hospital.getEmployeesList().entrySet()){
            System.out.println("Name: "+ emp.getKey()+", Profession: "+ emp.getValue().getClass().getSimpleName()+", Salary: "+ emp.getValue().getEmployeeSalary());
        }
       // The Janitor sweep the hospital
        System.out.println("");
        System.out.println("Hospital cleanliness is "+ hospital.getCleanliness()+" before cleaning");
        jan.sweep(hospital);

        System.out.println("Hospital cleanliness is "+ hospital.getCleanliness() + " after the Janitor cleaned it");
       // doc1 draw blood from pat1
        System.out.println(pat1.getPatientName()+ " " + " Blood level is  "+ pat1.getBloodLevel()+ " before blood drawing");

        doc1.drawBlood(pat1);

        System.out.println(pat1.getPatientName()+ " " + " Blood level is  "+ pat1.getBloodLevel()+ " after Doctor blood drawing");
        System.out.println("");
        // nur1 care for pat2
        System.out.println(pat2.getPatientName()+ " " + " health level is  "+ pat2.getHealthLevel()+ " before care");
        nur1.careForPatient(pat2);

        System.out.println(pat2.getPatientName()+ " " + " health level is  "+ pat2.getHealthLevel()+" after nurse care");
        System.out.println("");
        //doc2 care for pat2
        System.out.println(pat2.getPatientName()+ " " + " health level is  "+ pat2.getHealthLevel()+ " before the Doctor takes care"  );
        doc1.careForPatient(pat2);

        System.out.println(pat2.getPatientName()+ " " + " health level is  "+ pat2.getHealthLevel()+" after the Doctor have taken care" );
        System.out.println("");
        // receptionist provide information to Guests
        System.out.println("hospital number of guests is "+ hospital.getNumberOfGuests()+ " before the receptionist provide information to Guest");
        rec.provideInformationToGuests(hospital);
        System.out.println("");
        System.out.println("hospital number of guests is "+ hospital.getNumberOfGuests()+" after the receptionist has provided information to Guests");
        System.out.println("");
        // Search for Dan
        hospital.searchForAnEmployee("Dan");
// Search for liu which is not a part of the staff
        hospital.searchForAnEmployee("Liu");
        System.out.println("");
        // Display all Employees
        hospital.displayAllEmployees();
        System.out.println("");
        // Fire Doctor dan

        hospital.fireEmployee("Dan");

        // Fire someone who doesn't exist
        hospital.fireEmployee("Ryu");
        // Pay bills
        System.out.println("Bill amount before payement: "+ hospital.getBillAmount());
        hospital.payBills(25000);
        System.out.println("");
        System.out.println("Bill amount after payement of 25 000: "+hospital.getBillAmount() );

   // Display all employees
        hospital.displayAllEmployees();

        System.out.println("");

        //Display all Patients

        hospital.displayAllPatients();

        System.out.println("");

        // Receptionist has a Call

        rec.haveACall();
        System.out.println(" ");
        System.out.println("The receptionist "+ rec.getEmployeeName()+ " has a Call");
        System.out.println(rec.getEmployeeName()+" call status :"+rec.isOnCall());

        // Emergency dispatcher draw blood
        System.out.println(pat1.getPatientName()+" blood level is "+pat1.getBloodLevel()+" before blood drawing");
        System.out.println(" ");
        ed.drawBlood(pat1);
        System.out.println(pat1.getPatientName()+" blood level is "+pat1.getBloodLevel()+" after blood drawing by the  Emergency Dispatcher");
        System.out.println(" ");
        System.out.println(pat1.getPatientName()+ " Health Level is "+ pat1.getHealthLevel()+" before the Emergency dispatcher care" );
        ed.careForPatient(pat1);
        System.out.println(" ");
        System.out.println(pat1.getPatientName()+ " Health Level is "+ pat1.getHealthLevel()+" after the Emergency dispatcher care" );

    }
}
