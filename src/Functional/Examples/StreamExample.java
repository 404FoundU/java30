package Functional.Examples;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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

        Map<Integer, List<Employee>> depMap = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.toList()));

        depMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            v.forEach(System.out::println);
                }
        );


        depMap.entrySet()
                .forEach(entry -> {
                    System.out.println("Department ID: " + entry.getKey());
                    entry.getValue().forEach(System.out::println);
                });

        // print employee count in each dept
        Map<Integer, Long> deptCount = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.counting()));
        deptCount.forEach((k, v) -> {
                    System.out.println("k = " + k);
            System.out.println("v = " + v);
                }
        )
        ;

        // active and inactive employees in the collection
        Map<String, List<Employee>> activeMap = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getStatus(), Collectors.toList()));
        activeMap.entrySet()
                .forEach(
                        (entry) -> {
                            System.out.println("entry.getKey() = " + entry.getKey());
                            entry.getValue().forEach(System.out::println);
                        }
                );

        // count of active and inactive
        long activeCount = empList.stream()
                .filter(e -> "active".equals(e.getStatus()))
                .count();

        // max min employee salary

        Optional<Employee> maxSalary = empList.stream()
                .max((a, b) -> Integer.compare(a.getSalary(), b.getSalary()));

        maxSalary.ifPresent(s -> System.out.println("salary = " + s));

        empList.stream()
                .min(Comparator.comparing(e -> e.getSalary()))
                .ifPresent(s -> System.out.println("salary = " + s.getSalary()));

        empList.stream()
                .min((a, b) -> {
                    if (a.getSalary() == b.getSalary()) {
                        return 0;
                    }
                    if (a.getSalary() < b.getSalary()) {
                        return 1;
                    }
                    return -1;
                })
                .ifPresent(s -> System.out.println("salary = " + s.getSalary()));

        empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst()
                .ifPresent(System.out::println);
        //max salary of an employee for each dept

        // employee details with max salary
        empList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(e -> e.getSalary())))
                .ifPresent(System.out::println);

        Map<Integer, Optional<Employee>> salaryMap = empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(),
                        Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));

        salaryMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            v.ifPresent(e -> System.out.println("salary = " + e.getSalary()));
        });

        Map<Integer, String> empIdToNameMap = empList.stream()
                .collect(Collectors.toMap(
                        Employee::getEmpId,
                        Employee::getName
                ));
        //Map of Department ID to List of Employee Names
        Map<Integer, List<String>> deptToEmpNames = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        // Reverse map empName to ID
        Map<String, Integer> nameToIdMap = empList.stream()
                .collect(Collectors.toMap(
                        Employee::getName,  // Key: Employee Name
                        Employee::getDeptId     // Value: Employee ID
                ));
        String employeeNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Employee Names: " + employeeNames);

        // employee names to set
        Set<String> employeeNameset = empList.stream()
                .collect(Collectors.mapping(Employee::getName, Collectors.toSet()));

// Print name of all dept in org
        empList.stream()
                .map(e -> e.getDeptId())
                .distinct()
                .forEach(System.out::println);

// avg salary per dept
        empList.stream()
                .collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.averagingInt(e -> e.getSalary())));

        // Group employee names by department
        Map<Integer, List<String>> namesByDept = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId, // Grouping key: Department ID
                        Collectors.mapping(Employee::getName, Collectors.toList()) // Extract names into a List
                ));

        double totalSalary = empList.stream()
                .mapToDouble(Employee::getSalary)
                .sum(); // Calculate the sum of all salaries


        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        // Flatten the nested list into a single list
        List<Integer> flatList = nestedList.stream()
                .flatMap(List::stream) // Flatten each list into a single stream
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("cat", "dog", "bird");

        // Transform each word into a list of its characters
        List<List<String>> listOfCharLists = words.stream()
                .map(word -> Arrays.stream(word.split("")) // Split word into characters
                        .collect(Collectors.toList())) // Collect characters into a List
                .collect(Collectors.toList()); // Collect all lists into a List<List<String>>


        // Partition employees by their active status
        Map<Boolean, List<Employee>> partitioned = empList.stream()
                .collect(Collectors.partitioningBy(e -> "active".equals(e.getStatus())));

        System.out.println("Active Employees: " + partitioned.get(true));
        System.out.println("Inactive Employees: " + partitioned.get(false));

        List<List<String>> nested = List.of(List.of("a", "b"), List.of("c"));
        List<String> flat = nested.stream().flatMap(strings -> strings.stream()).collect(Collectors.toList());


        Optional<Object> optional = Optional.ofNullable(null);
        optional.ifPresent(System.out::println);

    }

    List<String> words = Arrays.asList("apple", "banana", "cherry");
    // Group words by their length using a LinkedHashMap
    Map<Integer, List<String>> groupedWords = words.stream()
            .collect(Collectors.groupingBy(
                    String::length, // Key: Word length
                    LinkedHashMap::new, // Custom Map Supplier
                    Collectors.toList() // Downstream collector
            ));

    String result = words.stream()
            .reduce("", (a, b) -> a + b);

    // no identity
    // Find the maximum value
    List<Integer> numbers = Arrays.asList(10, 20, 30, 5, 15);
    Optional<Integer> max = numbers.stream()
            .reduce((a, b) -> a > b ? a : b); // Accumulator finds the max


    // Parallel stream reduction
    int sum = numbers.parallelStream()
            .reduce(0,
                    (partialSum, element) -> partialSum + element, // Accumulator
                    (sum1, sum2) -> sum1 + sum2); // Combiner


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
