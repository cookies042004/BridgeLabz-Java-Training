package coreprogramming.methods.level3;

public class ZaraBonusCalculator {
    // Method to generate salary and years of service
    public static double[][] generateEmployeeData() {
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            // 5-digit salary (10000–99999)
            data[i][0] = 10000 + (int)(Math.random() * 90000);

            // Years of service (1–10)
            data[i][1] = 1 + (int)(Math.random() * 10);
        }
        return data;
    }

    // Method to calculate new salary and bonus
    public static double[][] calculateBonus(double[][] data) {
        double[][] result = new double[10][3];

        for (int i = 0; i < 10; i++) {
            double salary = data[i][0];
            double years = data[i][1];

            double bonus;
            if (years > 5)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;

            double newSalary = salary + bonus;

            result[i][0] = salary;
            result[i][1] = newSalary;
            result[i][2] = bonus;
        }
        return result;
    }

    // Method to calculate totals and display output
    public static void displaySummary(double[][] result) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("OldSalary\tNewSalary\tBonus");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f%n",
                    result[i][0],
                    result[i][1],
                    result[i][2]);

            totalOldSalary += result[i][0];
            totalNewSalary += result[i][1];
            totalBonus += result[i][2];
        }

        System.out.printf("Total Old Salary : %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary : %.2f%n", totalNewSalary);
        System.out.printf("Total Bonus Paid : %.2f%n", totalBonus);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData();
        double[][] salaryDetails = calculateBonus(employeeData);
        displaySummary(salaryDetails);
    }
}

