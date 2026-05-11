import java.util.Scanner;

public class MagicSquare
{
    // ----- Method To Input Matrix -----
    public static void inputMatrix(int[][] matrix, int n, Scanner input)
    {
        System.out.println("Enter " + (n * n) + " Numbers:");

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = input.nextInt();
            }
        }
    }

    // ----- Method To Display Matrix -----
    public static void displayMatrix(int[][] matrix, int n)
    {
        System.out.println("\n=================");
        System.out.println("Entered Matrix");
        System.out.println("=================");

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // ----- Method To Check Duplicate Numbers -----
    public static boolean hasUniqueNumbers(int[][] matrix, int n)
    {
        boolean[] used = new boolean[n * n + 1];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int value = matrix[i][j];

                // Number must be between 1 and n²
                if (value < 1 || value > n * n)
                {
                    return false;
                }

                // Duplicate Check
                if (used[value])
                {
                    return false;
                }

                used[value] = true;
            }
        }

        return true;
    }

    // ----- Method To Check Magic Square -----
    public static boolean isMagicSquare(int[][] matrix, int n)
    {
        int targetSum = 0;

        // First Row Sum
        for (int j = 0; j < n; j++)
        {
            targetSum += matrix[0][j];
        }

        // ----- Row Check -----
        for (int i = 0; i < n; i++)
        {
            int rowSum = 0;

            for (int j = 0; j < n; j++)
            {
                rowSum += matrix[i][j];
            }

            if (rowSum != targetSum)
            {
                return false;
            }
        }

        // ----- Column Check -----
        for (int j = 0; j < n; j++)
        {
            int colSum = 0;

            for (int i = 0; i < n; i++)
            {
                colSum += matrix[i][j];
            }

            if (colSum != targetSum)
            {
                return false;
            }
        }

        // ----- Main Diagonal -----
        int diagonal1 = 0;

        for (int i = 0; i < n; i++)
        {
            diagonal1 += matrix[i][i];
        }

        if (diagonal1 != targetSum)
        {
            return false;
        }

        // ----- Secondary Diagonal -----
        int diagonal2 = 0;

        for (int i = 0; i < n; i++)
        {
            diagonal2 += matrix[i][n - 1 - i];
        }

        if (diagonal2 != targetSum)
        {
            return false;
        }

        return true;
    }

    // ----- Main Method -----
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Matrix Size (3 Or 4 Or 5): ");
        int n = input.nextInt();

        while (n < 3 || n > 5)
        {
            System.out.println("Error: Size Must Be 3, 4, Or 5.");
            System.out.print("Please Re-Enter Matrix Size: ");
            n = input.nextInt();
        }

        int[][] matrix = new int[n][n];

        inputMatrix(matrix, n, input);

        displayMatrix(matrix, n);

        System.out.println("\nChecking Magic Square...");

        boolean unique = hasUniqueNumbers(matrix, n);
        boolean magic = isMagicSquare(matrix, n);

        if (unique && magic)
        {
            System.out.println("=====================");
            System.out.println("It Is A Magic Square.");
            System.out.println("=====================");
        }
        else
        {
            System.out.println("=========================");
            System.out.println("It Is NOT A Magic Square.");
            System.out.println("=========================");
        }

        input.close();
    }
}