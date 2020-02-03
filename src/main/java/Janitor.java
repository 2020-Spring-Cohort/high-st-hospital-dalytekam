public class Janitor extends Employee implements ITick{
    private boolean isSweeping = false;

    public Janitor(int employeeNumber, String employeeName, boolean isSweeping) {
        super(employeeNumber, employeeName);
        this.isSweeping = isSweeping;
    }

    public boolean isSweeping() {
        return isSweeping;
    }

    public void setSweeping(boolean sweeping) {
        isSweeping = sweeping;
    }



    public void sweep(Hospital h){

        h.setCleanliness(h.getCleanliness()+2);
    }

    @Override
    public void paidSalary(Salary s) {

        this.employeeSalary+= s.janitorSalary;
    }

    @Override
    public void tick() {

        this.setSweeping(!this.isSweeping());
    }
}
