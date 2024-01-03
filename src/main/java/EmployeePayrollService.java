import java.util.Scanner;

public class EmployeePayrollService {
    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        System.out.println("Enter your id: ");
        int id = scannerObject.nextInt();

        System.out.println("Enter your name: ");
        String name = scannerObject.next();

        System.out.println("Enter your salary: ");
        float salary = scannerObject.nextFloat();

        EmployeePayroll employeePayroll = new EmployeePayroll(id, name, salary);

        System.out.println("Employee id: " + employeePayroll.getId() + ", Employee name: " + employeePayroll.getName() + ", Employee Salary: " + employeePayroll.getSalary());
    }
}