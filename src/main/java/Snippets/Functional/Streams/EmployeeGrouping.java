package Snippets.Functional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String country;
    private String state;
    private String city;

    // Constructor
    public Employee(String country, String state, String city) {
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    // Getters
    public String findAddress(String attribute) {
        switch (attribute.toUpperCase()) {
            case "COUNTRY":
                return country;
            case "STATE":
                return state;
            case "CITY":
                return city;
            default:
                throw new IllegalArgumentException("Invalid groupBy attribute: " + attribute);
        }
    }

    @Override
    public String toString() {
        return "Employee{" + "country='" + country + '\'' + ", state='" + state + '\'' + ", city='" + city + '\'' + '}';
    }
}

public class EmployeeGrouping {


    /**
     * This method should group the employees based on the addreesGroupBy list.
     *
     * @param employees
     * @param addreesGroupBy [COUNTRY, STATE, CITY] or any order
     * @return Map<String, List < Employee>> where the key is the addreesGroupBy value and
     * the value is the list of employees, i.e., keys like "usa-ca-la", value [emp1, emp2],
     * "usa-ca-sf", [emp3, emp4]
     */

    public static Map<String, List<Employee>> getGroupings(List<Employee> employees, List<String> addreesGroupBy) {
        Map<String, List<Employee>> empListByCity = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity(), Collectors.toList()));
        Map<String, List<Employee>> empListWithStateCityCountry = employees.stream()
                .collect(Collectors.groupingBy(emp -> createAddressGroupKey(emp, addreesGroupBy)));
        return empListWithStateCityCountry;
    }

    private static String createAddressGroupKey(Employee emp, List<String> addressGroupBy) {
        return addressGroupBy.stream()
                .map(addressField -> emp.findAddress(addressField))
                .collect(Collectors.joining("-"));
    }


    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("USA", "CA", "LA"),
                new Employee("USA", "CA", "SF"),
                new Employee("USA", "TX", "Dallas"),
                new Employee("USA", "CA", "LA"),
                new Employee("India", "MH", "Mumbai")
        );

        List<String> groupBy = Arrays.asList("COUNTRY", "STATE", "CITY");

        Map<String, List<Employee>> groupedEmployees = getGroupings(employees, groupBy);

        groupedEmployees.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}

