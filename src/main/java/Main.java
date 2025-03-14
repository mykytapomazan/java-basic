import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці (не більше 20): ");
        int width = getValidSize(scanner);

        System.out.print("Введіть висоту матриці (не більше 20): ");
        int height = getValidSize(scanner);

        System.out.print("Оберіть спосіб заповнення (1 - вручну, 2 - випадково): ");
        int choice = scanner.nextInt();

        int[][] matrix;
        if (choice == 1) {
            matrix = createMatrixManually(scanner, width, height);
        } else {
            matrix = createMatrixRandomly(width, height);
        }

        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateArithmeticMean(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricMean);
    }

    private static int getValidSize(Scanner scanner) {
        int size;
        while (true) {
            size = scanner.nextInt();
            if (size > 0 && size <= MAX_SIZE) {
                return size;
            }
            System.out.print("Помилка! Введіть число від 1 до " + MAX_SIZE + ": ");
        }
    }

    private static int[][] createMatrixManually(Scanner scanner, int width, int height) {
        int[][] matrix = new int[height][width];
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] createMatrixRandomly(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    private static double calculateArithmeticMean(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                product *= Math.abs(value) + 1;
                count++;
            }
        }
        return Math.pow(product, 1.0 / count) - 1;
    }
}
