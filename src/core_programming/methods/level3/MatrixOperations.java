package core_programming.methods.level3;

import java.util.Random;

public class MatrixOperations {
    // Create random matrix
    public static double[][] createRandomMatrix(int rows, int cols) {
        Random r = new Random();
        double[][] m = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                m[i][j] = r.nextInt(9) + 1;
        return m;
    }

    // Display matrix
    public static void displayMatrix(double[][] m) {
        for (double[] row : m) {
            for (double val : row)
                System.out.printf("%6.2f ", val);
            System.out.println();
        }
        System.out.println();
    }

    // Matrix addition
    public static double[][] add(double[][] a, double[][] b) {
        int r = a.length, c = a[0].length;
        double[][] res = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                res[i][j] = a[i][j] + b[i][j];
        return res;
    }

    // Matrix subtraction
    public static double[][] subtract(double[][] a, double[][] b) {
        int r = a.length, c = a[0].length;
        double[][] res = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                res[i][j] = a[i][j] - b[i][j];
        return res;
    }

    // Matrix multiplication
    public static double[][] multiply(double[][] a, double[][] b) {
        int r1 = a.length, c1 = a[0].length, c2 = b[0].length;
        double[][] res = new double[r1][c2];

        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    res[i][j] += a[i][k] * b[k][j];
        return res;
    }

    // Transpose
    public static double[][] transpose(double[][] m) {
        int r = m.length, c = m[0].length;
        double[][] t = new double[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                t[j][i] = m[i][j];
        return t;
    }

    // Determinant of 2x2
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // Determinant of 3x3
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Inverse of 2x2
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        return new double[][]{
                {m[1][1] / det, -m[0][1] / det},
                {-m[1][0] / det, m[0][0] / det}
        };
    }

    // Inverse of 3x3
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] = (m[1][1] * m[2][2] - m[1][2] * m[2][1]) / det;
        inv[0][1] = -(m[0][1] * m[2][2] - m[0][2] * m[2][1]) / det;
        inv[0][2] = (m[0][1] * m[1][2] - m[0][2] * m[1][1]) / det;

        inv[1][0] = -(m[1][0] * m[2][2] - m[1][2] * m[2][0]) / det;
        inv[1][1] = (m[0][0] * m[2][2] - m[0][2] * m[2][0]) / det;
        inv[1][2] = -(m[0][0] * m[1][2] - m[0][2] * m[1][0]) / det;

        inv[2][0] = (m[1][0] * m[2][1] - m[1][1] * m[2][0]) / det;
        inv[2][1] = -(m[0][0] * m[2][1] - m[0][1] * m[2][0]) / det;
        inv[2][2] = (m[0][0] * m[1][1] - m[0][1] * m[1][0]) / det;

        return inv;
    }

    public static void main(String[] args) {

        double[][] A = createRandomMatrix(3, 3);
        double[][] B = createRandomMatrix(3, 3);

        System.out.println("Matrix A:");
        displayMatrix(A);

        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("Addition:");
        displayMatrix(add(A, B));

        System.out.println("Subtraction:");
        displayMatrix(subtract(A, B));

        System.out.println("Multiplication:");
        displayMatrix(multiply(A, B));

        System.out.println("Transpose of A:");
        displayMatrix(transpose(A));

        System.out.println("Determinant of A:");
        System.out.println(determinant3x3(A));

        System.out.println("Inverse of A:");
        double[][] inv = inverse3x3(A);
        if (inv != null)
            displayMatrix(inv);
        else
            System.out.println("Inverse not possible (Determinant = 0)");
    }
}
