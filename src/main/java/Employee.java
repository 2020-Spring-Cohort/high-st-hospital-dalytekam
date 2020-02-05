public abstract class Employee {
 private int employeeNumber;
 private String employeeName;
 protected double employeeSalary;
 protected boolean hasBeenPaid;

  public Employee(int employeeNumber, String employeeName) {
    this.employeeNumber = employeeNumber;
    this.employeeName = employeeName.toUpperCase();
  }


  public abstract void paidSalary(Salary s);




  public int getEmployeeNumber() {
    return employeeNumber;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public double getEmployeeSalary() {
    return employeeSalary;
  }

  public boolean isHasBeenPaid() {
    return hasBeenPaid;
  }


}
