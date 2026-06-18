package payroll;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class PayrollCSVReader {

    private final String employeeFile =
            "resources/MotorPH_Employee Data - Employee Details.csv";

    public String[][] getEmployees() {

        String[][] employees = new String[100][4];

        try {

            Reader reader = new FileReader(employeeFile);

         CSVParser csvParser = new CSVParser(
            reader,
            CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build()
            );

            int row = 0;

            for (CSVRecord record : csvParser) {

                employees[row][0] = record.get(0).trim();   // Employee ID
                employees[row][1] = record.get(1).trim();   // Last Name
                employees[row][2] = record.get(2).trim();   // First Name
                employees[row][3] = record.get(13).trim();  // Basic Salary

                row++;
            }

            csvParser.close();

        } catch (IOException e) {

            System.out.println("Error reading CSV file.");
            e.printStackTrace();
        }

        return employees;
    }
}