/*
    Name: Evan Xiang
    Due Date: October 31st, 2023
    Description: AP Computer Science Project #2 - Encryption/Decryption - Mr. Haytock
    Tasks done(Methods in Parantheses):
    - String Returning Function(additiveCipher/bruteForceAdditiveCipher/caesarSquare)
    - Additive Cipher(additiveCipher)
    - Decryption(bruteForceAdditiveCipher)
    - Caesar Square(caesarSquare)
*/
package encryption;
import java.util.Scanner;
import cs1.Keyboard;
public class Encryption 
{
    static Scanner input;
    static String encrypt = "";
    static int cipher;
    public static void main(String[] args) 
    {
        input = new Scanner(System.in);
        while(true){
            System.out.println("What's your plaintext or ciphertext? ");
            encrypt = Keyboard.readString();
            System.out.println("Enter command: 1 = Additive Cipher; 2 = Additive Decryption; 3 = Caesar Square Cipher; 4 = Caesar Sqare Decrypt; -1 = Quit");
            cipher = input.nextInt();
            if(cipher == 1){
                System.out.println(additiveCipher());
            }else if(cipher == 2){
                System.out.println(bruteForceAdditiveCipher());
            } else if(cipher == 3){
                caesarSquare();
            } else if(cipher == 4){
                caesarSquareDecryption();
            }
            else if(cipher == -1){
                break;
            }
            System.out.println("Would you like to exit? 1 = No; 0 = Yes");
            int leave = input.nextInt();
            if(leave == 0){
                System.out.println("Goodbye!");
                break;
            } else{}
        }

    }
    //method for encoding additive ciphers with desired user input shift
    static public String additiveCipher()
    {
        System.out.println("What is your desired shift?");
        int shift = input.nextInt();
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < encrypt.length(); i++) {
            char c = encrypt.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (base + (c - base + shift) % 26);
            }
            encryptedMessage.append(c);
        }
        return encryptedMessage.toString();
    }

    //method for decoding additive ciphers brute forcely(outputs all shift possibilities)
    static public String bruteForceAdditiveCipher() {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int shift = 1; shift <= 25; shift++) { 
            StringBuilder currentAttempt = new StringBuilder();
            for (int i = 0; i < encrypt.length(); i++) {
                char c = encrypt.charAt(i);
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int shiftedValue = (c - base - shift + 26) % 26; 
                    c = (char) (base + shiftedValue);
                }
                currentAttempt.append(c);
            }
            decryptedMessage.append("Shift " + shift + ": " + currentAttempt.toString() + "\n");
        }
    
        return decryptedMessage.toString();
    }

    static public String caesarSquare()
    {
        return encrypt;
    }
    
    static public void caesarSquareDecryption()
    {
        // Enter string
        // enter initial key
        // display result
        // option: display result to file
        // option: decrypt
        // trim out spaces
    }
    

}
