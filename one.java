/* * Name: Muhammad Hanzala
 * Roll no: 34
 * CS_Section A
 * Lab Assignment: Decimal to Binary Conversion
 */

import java.util.Scanner;
import java.util.Arrays;

public class one {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        
        
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            return;
        }

        int num = sc.nextInt();

        
        System.out.println("Part (a) - Using Reverse: " + convertToBinary(num));

        
        int[] bits = convertToBinaryArray(num);
        System.out.println("Part (b) - Array format: " + Arrays.toString(bits));

        
        String binaryStr = convertToBinaryString(num);
        System.out.println("Part (c) - Using Insert: " + binaryStr);

        sc.close();
    }

    // Part (a): Standard way using % 2 and reversing the string at the end
    public static String convertToBinary(int n) {
        if (n == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int remainder = n % 2;
            result.append(remainder);
            n = n / 2; 
        }
        
        return result.reverse().toString();
    }

    // Part (b): Storing the bits in an array
    public static int[] convertToBinaryArray(int n) {
        if (n == 0) return new int[]{0};

        
        int size = (int) (Math.log(n) / Math.log(2)) + 1;
        int[] binaryArray = new int[size];
        
        
        for (int i = size - 1; i >= 0; i--) {
            binaryArray[i] = n % 2; 
            n = n / 2;
        }
        return binaryArray;
    }

    // Part (c): Building the string without using the reverse() method
    public static String convertToBinaryString(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            
            sb.insert(0, n % 2);
            n = n / 2;
        }
        return sb.toString();
    }
}