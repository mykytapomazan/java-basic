import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int MIN_RANDOM = -100;
    private static final int MAX_RANDOM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту матриці (макс 20): ");
        int height = scanner.nextInt();
        System.out.print("Введіть ширину матриці (макс 20): ");
        int width = scanner.nextInt();

        if (height > 20 || width > 20 || height <= 0 || width <= 0) {
            System.out.println("Висота та ширина повинні бути від 1 до 20.");
            return;
        }

        System.out.print("Оберіть метод створення матриці (1 - вручну, 2 - випадкові числа): ");
        int choice = scanner.nextInt();

        int[][] matrix = new int[height][width];

        if (choice == 1) {
            inputMatrixManual(matrix, scanner);
        } else if (choice == 2) {
            inputMatrixRandom(matrix);
        } else {
            System.out.println("Невірний вибір.");
            return;
        }

        System.out.println("\nМатриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("\nМінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }

    public static void inputMatrixManual(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Введіть елемент матриці [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void inputMatrixRandom(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;
            }
        }
        return (double) sum / count;
    }
}
