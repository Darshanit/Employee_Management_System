import java.util.*;

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