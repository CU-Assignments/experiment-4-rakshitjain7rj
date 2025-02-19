import java.util.ArrayList;
import java.util.Scanner;

// Employee class to store employee details
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

// Main class for managing employees using ArrayList
public class EmployeeManagement {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Method to add an employee
    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(id, name, salary);
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    // Method to update employee details
    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new salary: ");
            double newSalary = scanner.nextDouble();
            emp.setName(newName);
            emp.setSalary(newSalary);
            System.out.println("Employee details updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Method to remove an employee
    public void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employees.remove(emp);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Method to search employee by ID
    public void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Helper method to find employee by ID
    private Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Main menu
    public void menu() {
        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        management.menu();
    }
}
