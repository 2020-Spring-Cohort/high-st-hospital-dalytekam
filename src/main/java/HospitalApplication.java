import java.util.Map;
import java.util.Scanner;

public class HospitalApplication {
    public static String quitApp = "0";
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" Welcome to High Street Hospital, You are the Manager and \n" +
                " you are responsible to have people make different Jobs done");
        // initializing the App( Create and hire Doctors, Nurses, Janitor, Patient, ect ...)

        Doctor doc1 = new Doctor(100,"Dan","Cardio");

        Nurse nur1 = new Nurse(200,"Anna",20);

        Janitor jan = new Janitor(300,"Bryan");
        Receptionist rec = new Receptionist(400,"Mike");
        Patient pat1 = new Patient(500,"Nash");
        Patient pat2 = new Patient(501,"Jolene");
        Hospital hospital = new Hospital(20,20,36000.00);
        EmergencyDispatcher ed = new EmergencyDispatcher(600,"Tina");

        Salary salary = new Salary();

        System.out.println(" ");
        hospital.hireEmployee(doc1);

        hospital.hireEmployee(nur1);

        hospital.hireEmployee(jan);
        hospital.hireEmployee(rec);
        hospital.hireEmployee(ed);
        hospital.admitAPatient(pat1);
        hospital.admitAPatient(pat2);

        while(quitApp.equals("0")){

            menu();
            manageHospital(hospital,salary);
        }

    }
    public static void menu(){
        System.out.println("                                 MENU");
        System.out.print("[1] Hire a new Doctor");
        System.out.println("                         [2] Hire a new Nurse");
        System.out.print("[3] Hire a new Janitor");
        System.out.println("                        [4] Hire a new Receptionist");
        System.out.print("[5] Hire a new Emergency Dispatcher");
        System.out.println("           [6] Admit a new Patient");
        System.out.print("[7] Fire an Employee");
        System.out.println("                          [8] Clean the Hospital");
        System.out.print("[9] Have someone perform blood drawing");
        System.out.println("        [10] Have someone care for a Patient");
        System.out.print("[11] Provide information to guests");
        System.out.println("            [12] Display All Patients");
        System.out.print("[13] Display All Employees");
        System.out.println("                    [14] Display Hospital Status");
        System.out.print("[15] Pay the Hospital Bills");
        System.out.println("                   [16] Pay All the Employees");
        System.out.println("[17] Search for an Employee");
        System.out.println("[18] Quit the Application");
        System.out.println(" ");

    }
    public static void manageHospital(Hospital hospital, Salary salary){
        try{
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
          switch (choice){

              case "1":
                  System.out.println("Assign a Number Id to the Doctor You want to hire");
                  int iDOfDoctorToHire = input.nextInt();
                  input.nextLine();
                  System.out.println("Enter the Name of the Doctor You want to hire");
                  String nameOfDoctorToHire = input.nextLine();
                  System.out.println("What is the Specialty of the Doctor?");
                  String specialtyOfDoctorToHire = input.nextLine();
                  hospital.hireEmployee(new Doctor(iDOfDoctorToHire,nameOfDoctorToHire,specialtyOfDoctorToHire));
                  break;
              case "2":
                  System.out.println("Assign a Number Id to the Nurse You want to hire");
                  int iDOfNurseToHire = input.nextInt();
                  input.nextLine();
                  System.out.println("Enter the Name of the Nurse You want to hire");
                  String nameOfNurseToHire = input.nextLine();
                  System.out.println("How many Patients will be assign to Her/Him");
                  int numberOfPatientsToAssign = input.nextInt();
                  input.nextLine();
                  hospital.hireEmployee(new Nurse(iDOfNurseToHire,nameOfNurseToHire,numberOfPatientsToAssign));
                  break;
              case "3":
                  System.out.println("Assign a Number Id to the Janitor You want to hire");
                  int iDOfJanitorToHire = input.nextInt();
                  input.nextLine();
                  System.out.println("Enter the Name of the Janitor You want to hire");
                  String nameOfJanitorToHire = input.nextLine();
                  hospital.hireEmployee(new Janitor(iDOfJanitorToHire,nameOfJanitorToHire));
                  break;
              case "4":
                  System.out.println("Assign a Number Id to the Receptionist You want to hire");
                  int iDOfReceptionistToHire = input.nextInt();
                  input.nextLine();
                  System.out.println("Enter the Name of the Receptionist You want to hire");
                  String nameOfReceptionistToHire = input.nextLine();
                  hospital.hireEmployee(new Receptionist(iDOfReceptionistToHire,nameOfReceptionistToHire));
                  break;
              case "5":
                  System.out.println("Assign a Number Id to the Emergency Dispatcher You want to hire");
                  int iDOfEmergencyDToHire = input.nextInt();
                  input.nextLine();
                  System.out.println("Enter the Name of the Receptionist You want to hire");
                  String nameOfEmergencyDToHire = input.nextLine();
                  hospital.hireEmployee(new EmergencyDispatcher(iDOfEmergencyDToHire,nameOfEmergencyDToHire));
                  break;
              case "6":
                  System.out.println("Assign an Number Id to the new Patient");
                  int iDOfNewPatient = input.nextInt();
                  input.nextLine();
                  System.out.println("Enter the Name of the new Patient");
                  String nameOfNewPatient = input.nextLine();
                  hospital.admitAPatient(new Patient(iDOfNewPatient,nameOfNewPatient));
                  break;
              case "7":
                  System.out.println("Enter the Name of the Employee you want to fire");
                  String nameOfEmployeeToFire = input.nextLine();
                  hospital.fireEmployee(nameOfEmployeeToFire);
                  break;
              case "8":
                  System.out.println("Please Give the Name of the Janitor \n and have him/her clean the hospital");
                  String janitorNme = input.nextLine();
                  if(hospital.getEmployeesList().containsKey(janitorNme)&&hospital.getEmployeesList().get(janitorNme) instanceof Janitor){
                      ((Janitor) hospital.getEmployeesList().get(janitorNme)).sweep(hospital);
                  }else if(hospital.getEmployeesList().containsKey(janitorNme)&& !(hospital.getEmployeesList().get(janitorNme) instanceof Janitor)){
                      System.out.println(janitorNme+ " is not a Janitor");
                  }else{
                      System.out.println(janitorNme +" is not a member of the Staff");
                  }
                  break;

              case "9":
                  System.out.println("Please enter the name of the Doctor,Nurse, \n or Emergency Dispatcher who will perform the blood drawing");
                  String nameOfBloodDrawer = input.nextLine();
                  System.out.println("Please enter the name of the Patient, \n who will undergo the blood Draw");
                  String nameOfPatientToDraw = input.nextLine();
                  if(hospital.getEmployeesList().get(nameOfBloodDrawer) instanceof CanDrawBloodAndCare && hospital.getPatientsList().get(nameOfPatientToDraw) != null){
                      ((CanDrawBloodAndCare) hospital.getEmployeesList().get(nameOfBloodDrawer)).drawBlood(hospital.getPatientsList().get(nameOfPatientToDraw));
                  }else {
                      System.out.println(" Check if you did assign the task \n to the right person or to a reel Patient of Hospital ");
                  }
                  break;
              case "10":
                  System.out.println("Please enter the name of the Doctor,Nurse, \n or Emergency Dispatcher who will care for the Patient");
                  String nameOfCareTaker = input.nextLine();
                  System.out.println("Please enter the name of the Patient, \n who will be treated");
                  String nameOfPatientToTreat = input.nextLine();
                  if(hospital.getEmployeesList().get(nameOfCareTaker) instanceof CanDrawBloodAndCare && hospital.getPatientsList().get(nameOfPatientToTreat) != null){
                      ((CanDrawBloodAndCare) hospital.getEmployeesList().get(nameOfCareTaker)).careForPatient(hospital.getPatientsList().get(nameOfPatientToTreat));
                  }else {
                      System.out.println(" Check if you did assign the task \n to the right staff member or if you gave them the correct name of  Patient");
                  }

                  break;
              case "11":
                  System.out.println("Please Give the Name of the Receptionist \n and let him/her know that there is some Guests");
                  String recep = input.nextLine();
                  if(hospital.getEmployeesList().containsKey(recep)&&hospital.getEmployeesList().get(recep) instanceof Receptionist){
                      ((Receptionist) hospital.getEmployeesList().get(recep)).provideInformationToGuests(hospital);
                  }else if(hospital.getEmployeesList().containsKey(recep)&& !(hospital.getEmployeesList().get(recep) instanceof Receptionist)){
                      System.out.println(recep+ " is not a Receptionist");
                  }else{
                      System.out.println(recep +" is not a member of the Staff");
                  }
                  break;
              case "12":
                  hospital.displayAllPatients();
                  break;
              case "13":
                  hospital.displayAllEmployees();
                  break;
              case "14":
                  hospital.displayHospitalStatus();
                  break;
              case "15":
                  System.out.println("Enter the amount you want to pay");
                  double amount = input.nextDouble();
                  hospital.payBills(amount);
                  break;
              case "16":
                  hospital.payAllEmployees(salary);
                  break;
              case "17":
                  System.out.println("Enter the name of the Employee you want to search");
                  String nameOfEmployeeToSearch= input.nextLine();
                  hospital.searchForAnEmployee(nameOfEmployeeToSearch);
                  break;
              case "18":
                  quitApp = "finish";
                  System.out.println("Thank you For helping Us to manage the Hospital today");
                  System.exit(0);

                  break;


              default:
                  System.out.println("This is an invalid Option");
                  break;

          }

        }catch(Exception e){
            System.out.println("An Unexpected Error occurred!");
        }


    }

}
