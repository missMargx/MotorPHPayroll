package payroll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Initial commit for reading csv file
 * Reader class
 */
public class PayrollCSVReader {
    
    private final String employeeFile = "resources/MotorPH_Employee Data - Employee Details.csv";
    
    public String[][] getEmployees() {

        String[][] employees = new String[100][4];

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(employeeFile));

            String line;

            br.readLine();

            int row = 0;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                // Check if row has enough columns
                if (data.length > 2) {

                    employees[row][0] = data[0]; // Employee ID
                    employees[row][0] = data[1].trim(); // Last Name
                    employees[row][1] = data[2].trim(); // First Name
                    employees[row][3] = data[13]; // Basic Salary
                   
                    row++;
                }
            }

            br.close();

        } catch (IOException e) {
            
            System.out.println("Error reading CSV file.");
            e.printStackTrace();
        }

        return employees;
    }
}