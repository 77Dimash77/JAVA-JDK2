package DZ4;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private int employeeId;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int employeeId, String phoneNumber, String name, int experience) {
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}

class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    public String findPhoneNumberByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee.getPhoneNumber();
            }
        }
        return "Номер телефона не найден";
    }

    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}

public class TelBook {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        Employee employee1 = new Employee(1, "123-456-7890", "John Doe", 5);
        Employee employee2 = new Employee(2, "987-654-3210", "Jane Smith", 3);

        directory.addEmployee(employee1);
        directory.addEmployee(employee2);

        // Пример использования методов
        List<Employee> experiencedEmployees = directory.findEmployeesByExperience(5);
        for (Employee employee : experiencedEmployees) {
            System.out.println("Employee ID: " + employee.getEmployeeId() +
                    ", Name: " + employee.getName() +
                    ", Phone Number: " + employee.getPhoneNumber() +
                    ", Experience: " + employee.getExperience());
        }

        String phoneNumber = directory.findPhoneNumberByName("Jane Smith");
        System.out.println("Phone Number for Jane Smith: " + phoneNumber);

        Employee foundEmployee = directory.findEmployeeByEmployeeId(2);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee.getName());
        } else {
            System.out.println("Employee not found");
        }
    }
}
