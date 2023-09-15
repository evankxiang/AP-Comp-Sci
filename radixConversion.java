import java.util.Scanner;
public class radixConversion {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What mode would you like to be in?[Binary, Octal, Hexadecimal, Decimal] ");
        String radix = scanner.nextLine();
		if(radix.equalsIgnoreCase("Binary")||radix.equalsIgnoreCase("Octal")||radix.equalsIgnoreCase("Hexadecimal")||radix.equalsIgnoreCase("Decimal")) {
			System.out.println("You selected mode: " + radix);
		} else {
			System.out.println("That is an invalid mode, please restart the program");
			System.exit(0);
		}
		System.out.println("What number would you like to convert to Decimal? ");
		int number = Integer.parseInt(scanner.nextLine());
		System.out.println("You are converting the number: " + number);
		
		if(radix.equalsIgnoreCase("Binary")) {
			String numToConvert = Integer.toString(number);
	        int output = 0;
	        int base = 1;
			for (int i = numToConvert.length() - 1; i >= 0; i--) {
	            int digitnumber = numToConvert.charAt(i) - '0';
	            if(digitnumber != 1 && digitnumber != 0) {
	            	System.out.println("That is not a valid Binary Number");
	            	System.exit(0);
	            } else {
		            output += digitnumber * base;
		            base *= 2;
	            }
			}
			System.out.println(output);
		} else if(radix.equalsIgnoreCase("Octal")) {
			String numToConvert = Integer.toString(number);
	        int decimal = 0;
	        int power = 1;
			for (int i = numToConvert.length() - 1; i >= 0; i--) {
	            int digit = numToConvert.charAt(i) - '0';
	            decimal += digit * power;
	            power *= 8;
			}
			System.out.println(decimal);
		} else if(radix.equalsIgnoreCase("Decimal")) {
			
		} else if(radix.equalsIgnoreCase("Hexadecimal")) {
			
		}
	}	
}
