/*
 * Evan Xiang
 * AP Comp Sci A - Mr.Haytock
 * Radix Conversion Project
 * September 15th 2023
 */
import java.util.Scanner;
public class radixConversion {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What mode would you like to be in? [Binary, Octal, Hexadecimal, Decimal] ");
        String radix = scanner.nextLine();
        if (radix.equalsIgnoreCase("Binary") || radix.equalsIgnoreCase("Octal") || radix.equalsIgnoreCase("Hexadecimal") || radix.equalsIgnoreCase("Decimal")) {
            System.out.println("You selected mode: " + radix);
        } else {
            System.out.println("That is an invalid mode, please restart the program");
            System.exit(0);
        }
        System.out.println("What number would you like to convert to Decimal? ");
        String numToConvert = scanner.nextLine();

        if (radix.equalsIgnoreCase("Binary")) {
            int output = convertBinaryToDecimal(numToConvert);
            System.out.println("Decimal: " + output);
        } else if (radix.equalsIgnoreCase("Octal")) {
            int output = convertOctalToDecimal(numToConvert);
            System.out.println("Decimal: " + output);
        } else if (radix.equalsIgnoreCase("Decimal")) {
            int decimalInput = Integer.parseInt(numToConvert);
            String output = convertDecimalToBinary(decimalInput);
            System.out.println("Binary: " + output);
        } else if (radix.equalsIgnoreCase("Hexadecimal")) {
            int output = convertHexadecimalToDecimal(numToConvert);
            System.out.println("Decimal: " + output);
        }
    }
    // Helper method to convert binary to decimal
    private static int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        int base = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int digit = binary.charAt(i) - '0';
            if (digit != 0 && digit != 1) {
                System.out.println("That is not a valid Binary Number");
                System.exit(0);
            }
            decimal += digit * base;
            base *= 2;
        }
        return decimal;
    }
    // Helper method to convert octal to decimal
    private static int convertOctalToDecimal(String octal) {
        int decimal = 0;
        int power = 1;
        for (int i = octal.length() - 1; i >= 0; i--) {
            int digit = octal.charAt(i) - '0';
            if (digit < 0 || digit > 7) {
                System.out.println("That is not a valid Octal Number");
                System.exit(0);
            }
            decimal += digit * power;
            power *= 8;
        }
        return decimal;
    }
    // Helper method to convert hexadecimal to decimal
    private static int convertHexadecimalToDecimal(String hex) {
        int decimal = 0;
        int power = 1;
        for (int i = hex.length() - 1; i >= 0; i--) {
            char digit = hex.charAt(i);
            if (!Character.isDigit(digit) && (digit < 'A' || digit > 'F')) {
                System.out.println("That is not a valid Hexadecimal Number");
                System.exit(0);
            }
            int digitValue = Character.isDigit(digit) ? (digit - '0') : (digit - 'A' + 10);
            decimal += digitValue * power;
            power *= 16;
        }
        return decimal;
    }
    private static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2; 
        }
        return binary.toString();
    }
}
