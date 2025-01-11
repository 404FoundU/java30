package Functional.Examples;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(101, "siva", 101, "active", 2000));
        empList.add(new Employee(102, "reddy", 101, "active", 5000));
        empList.add(new Employee(103, "raju", 102, "inactive", 6000));
        empList.add(new Employee(104, "shivam", 102, "inactive", 4000));
        empList.add(new Employee(105, "bob", 103, "active", 3500));
        empList.add(new Employee(106, "alice", 103, "inactive", 3500));
        empList.add(new Employee(107, "srinu", 104, "active", 3500));
        //print emp details based on dept

        empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(), ))

    }


}

// Assuming the Employee class looks something like this:
class Employee {
    private int empId;
    private String name;
    private int deptId;
    private String status;
    private int salary;

    public Employee(int empId, String name, int deptId, String status, int salary) {
        this.empId = empId;
        this.name = name;
        this.deptId = deptId;
        this.status = status;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Getters and setters can be added here for access
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", deptId=" + deptId + ", status=" + status + ", salary=" + salary + "]";
    }
}
