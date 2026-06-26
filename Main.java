import java.util.*;

class Employee {

    private int id;
    private String name;
    private String department;
    private String designation;
    private double salary;

    public Employee(int id, String name, String department, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String display() {
        return "ID: " + id + " | Name: " + name + " | Dept: " + department +
               " | Designation: " + designation + " | Salary: " + salary;
    }
}

class Company {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee Added Successfully");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e.display());
        }
    }

    public Employee searchEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void updateSalary(int id, double newSalary) {
        Employee e = searchEmployee(id);
        if (e != null) {
            e.setSalary(newSalary);
            System.out.println("Salary Updated Successfully");
        } else {
            System.out.println("Employee Not Found");
        }
    }

    public void updateDesignation(int id, String newDesignation) {
        Employee e = searchEmployee(id);
        if (e != null) {
            e.setDesignation(newDesignation);
            System.out.println("Designation Updated Successfully");
        } else {
            System.out.println("Employee Not Found");
        }
    }

    public void deleteEmployee(int id) {
        Employee e = searchEmployee(id);
        if (e != null) {
            employees.remove(e);
            System.out.println("Employee Deleted Successfully");
        } else {
            System.out.println("Employee Not Found");
        }
    }

    public void highestSalaryEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found");
            return;
        }
        Employee top = employees.get(0);
        for (Employee e : employees) {
            if (e.getSalary() > top.getSalary()) {
                top = e;
            }
        }
        System.out.println("Highest Salary Employee:");
        System.out.println(top.display());
    }

    public void countEmployees() {
        System.out.println("Total Employees: " + employees.size());
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Company company = new Company();

        while (true) {

            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Salary");
            System.out.println("5. Update Designation");
            System.out.println("6. Delete Employee");
            System.out.println("7. Highest Salary Employee");
            System.out.println("8. Total Employees");
            System.out.println("9. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    company.addEmployee(new Employee(id, name, dept, desig, salary));
                    break;
                }

                case 2:
                    company.viewEmployees();
                    break;

                case 3: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    Employee e = company.searchEmployee(id);
                    if (e != null)
                        System.out.println(e.display());
                    else
                        System.out.println("Employee Not Found");
                    break;
                }

                case 4: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double salary = sc.nextDouble();
                    company.updateSalary(id, salary);
                    break;
                }

                case 5: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Designation: ");
                    String desig = sc.nextLine();
                    company.updateDesignation(id, desig);
                    break;
                }

                case 6: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    company.deleteEmployee(id);
                    break;
                }

                case 7:
                    company.highestSalaryEmployee();
                    break;

                case 8:
                    company.countEmployees();
                    break;

                case 9:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid Choice. Try Again.");
            }
        }
    }
}