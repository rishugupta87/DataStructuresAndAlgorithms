package HospitalManagementSystem;

/**
 * Created by rg029761 on 9/12/15.
 */
public class Employee {
    private int id;
    private String name;
    private String department;
    private boolean isWorking;

    public Employee(int id, String name, String department, boolean isWorking) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.isWorking = isWorking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
