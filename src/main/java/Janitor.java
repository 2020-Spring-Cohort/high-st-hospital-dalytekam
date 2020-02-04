public class Janitor extends Employee implements ITick{
    private boolean isSweeping = false;

    public Janitor(int employeeNumber, String employeeName) {
        super(employeeNumber, employeeName);

    }

    public boolean isSweeping() {
        return isSweeping;
    }

    public void setSweeping(boolean sweeping) {

        isSweeping = sweeping;
    }



    public void sweep(Hospital h){

        h.setCleanliness(h.getCleanliness()+2);
        System.out.println(getEmployeeName()+" has sweep the hospital");
        setSweeping(true);
    }

    @Override
    public void paidSalary(Salary s) {

        this.employeeSalary+= s.janitorSalary;
        this.hasBeenPaid=true;
    }

    @Override
    public void tick() {

        this.setSweeping(!this.isSweeping());
    }
}
