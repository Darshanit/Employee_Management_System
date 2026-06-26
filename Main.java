import java.util.*;

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