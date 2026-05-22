package payroll;

/**
 * Test class to check if reader is working
 */
public class TestCSVReader {
     public static void main(String[] args) {

        PayrollCSVReader reader = new PayrollCSVReader();

        String[][] employees = reader.getEmployees();

        System.out.println("\nEMPLOYEE LIST\n");

        for (int i = 0; i < employees.length; i++) {

            if (employees[i][0] != null) {

                System.out.println(
                        employees[i][0] + ", " +
                        employees[i][1]);
            }
        }
    }
}
