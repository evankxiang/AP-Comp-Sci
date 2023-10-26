/*
    Name: Evan Xiang
    Due Date: October 31st, 2023
    Description: AP Computer Science Project #2 - Encryption/Decryption - Mr. Haytock
    Tasks done(Methods in Parantheses):
    - String Returning Function(additiveCipher/bruteForceAdditiveCipher/caesarSquare)
    - Additive Cipher(additiveCipher)
    - Decryption(bruteForceAdditiveCipher), brute forces using a scoring system with 1000 common English words
    - Caesar Square(caesarSquare)
*/
package encryption;
import java.util.Arrays;
import java.util.Scanner;
import cs1.Keyboard;
public class Encryption 
{
    static Scanner input;
    static String encrypt = "";
    static int cipher;
    static String[] morseCodeArray = {
            ".-",   // A
            "-...",  // B
            "-.-.",  // C
            "-..",   // D
            ".",     // E
            "..-.",  // F
            "--.",   // G
            "....",  // H
            "..",    // I
            ".---",  // J
            "-.-",   // K
            ".-..",  // L
            "--",    // M
            "-.",    // N
            "---",   // O
            ".--.",  // P
            "--.-",  // Q
            ".-.",   // R
            "...",   // S
            "-",     // T
            "..-",   // U
            "...-",  // V
            ".--",   // W
            "-..-",  // X
            "-.--",  // Y
            "--..",  // Z
            "/",     // Space
        };
    public static void main(String[] args) 
    {
        input = new Scanner(System.in);
        while(true){
            System.out.println("What's your plaintext or ciphertext? ");
            encrypt = Keyboard.readString();
            System.out.println("Enter command: 1 = Additive Cipher; 2 = Additive Decryption; 3 = Morse Code Encryptor; 4 = Morse Decryptor; -1 = Quit");
            cipher = input.nextInt();
            if(cipher == 1){
                System.out.println(additiveCipher());
            }else if(cipher == 2){
                System.out.println(bruteForceAdditiveCipher());
            } else if(cipher == 3){
                System.out.println(morseCode());
            } else if(cipher == 4){
                System.out.println(decodeMorse());
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
    //Most common 1000 english words in dictionary EXCEPT "a" and "i" because they are single letter
    String[] dictionary = {
        "the", "of", "to", "and", "in", "is", "it", "you", "that",
        "he", "was", "for", "on", "are", "with", "as", "his", "they",
        "be", "at", "one", "have", "this", "from", "or", "had", "by", "word",
        "but", "what", "some", "we", "can", "out", "other", "were", "all", "there",
        "when", "up", "use", "your", "how", "said", "an", "each", "she", "which",
        "do", "their", "time", "if", "will", "way", "about", "many", "then",
        "them", "write", "would", "like", "so", "these", "her", "long", "make",
        "thing", "see", "him", "two", "has", "look", "more", "day", "could",
        "go", "come", "did", "number", "sound", "no", "most", "people", "my",
        "over", "know", "water", "than", "call", "first", "who", "may", "down",
        "side", "been", "now", "find", "any", "new", "work", "part", "take",
        "get", "place", "made", "live", "where", "after", "back", "little", "only",
        "round", "man", "year", "came", "show", "every", "good", "me", "give",
        "our", "under", "name", "very", "through", "just", "form", "sentence",
        "great", "think", "say", "help", "low", "line", "differ", "turn", "cause",
        "much", "mean", "before", "move", "right", "boy", "old", "too", "same",
        "tell", "does", "set", "three", "want", "air", "well", "also", "play",
        "small", "end", "put", "home", "read", "hand", "port", "large", "spell",
        "add", "even", "land", "here", "must", "big", "high", "such", "follow",
        "act", "why", "ask", "men", "change", "went", "light", "kind", "off",
        "need", "house", "picture", "try", "us", "again", "animal", "point",
        "mother", "world", "near", "build", "self", "earth", "father", "head",
        "stand", "own", "page", "should", "country", "found", "answer", "school",
        "grow", "study", "still", "learn", "plant", "cover", "food", "sun",
        "four", "between", "state", "keep", "eye", "never", "last", "let", "thought",
        "city", "tree", "cross", "farm", "hard", "start", "might", "story", "saw",
        "far", "sea", "draw", "left", "late", "run", "don't", "while", "press",
        "close", "night", "real", "life", "few", "north", "open", "seem", "together",
        "next", "white", "children", "begin", "got", "walk", "example", "ease",
        "paper", "group", "always", "music", "those", "both", "mark", "often", "letter",
        "until", "mile", "river", "car", "feet", "care", "second", "book", "carry",
        "took", "science", "eat", "room", "friend", "began", "idea", "fish", "mountain",
        "stop", "once", "base", "hear", "horse", "cut", "sure", "watch", "color",
        "face", "wood", "main", "enough", "plain", "girl", "usual", "young", "ready",
        "above", "ever", "red", "list", "though", "feel", "talk", "bird", "soon",
        "body", "dog", "family", "direct", "pose", "leave", "song", "measure", "door",
        "product", "black", "short", "numeral", "class", "wind", "question", "happen",
        "complete", "ship", "area", "half", "rock", "order", "fire", "south", "problem",
        "piece", "told", "knew", "pass", "since", "top", "whole", "king", "space",
        "heard", "best", "hour", "better", "true", "during", "hundred", "five", "remember",
        "step", "early", "hold", "west", "ground", "interest", "reach", "fast", "verb",
        "sing", "listen", "six", "table", "travel", "less", "morning", "ten", "simple",
        "several", "vowel", "toward", "war", "lay", "against", "pattern", "slow", "center",
        "love", "person", "money", "serve", "appear", "road", "map", "rain", "rule",
        "govern", "pull", "cold", "notice", "voice", "unit", "power", "town", "fine",
        "certain", "fly", "fall", "lead", "cry", "dark", "machine", "note", "wait",
        "plan", "figure", "star", "box", "noun", "field", "rest", "correct", "able",
        "pound", "done", "beauty", "drive", "stood", "contain", "front", "teach", "week",
        "final", "gave", "green", "oh", "quick", "develop", "ocean", "warm", "free",
        "minute", "strong", "special", "mind", "behind", "clear", "tail", "produce", "fact",
        "street", "inch", "multiply", "nothing", "course", "stay", "wheel", "full", "force",
        "blue", "object", "decide", "surface", "deep", "moon", "island", "foot", "system",
        "busy", "test", "record", "boat", "common", "gold", "possible", "plane", "stead",
    };    
    StringBuilder bestDecryption = new StringBuilder();
    int bestScore = 0;
    
    for (int shift = 1; shift <= 25; shift++) {
        StringBuilder currentAttempt = new StringBuilder();
        int currentScore = 0;
        
        for (int i = 0; i < encrypt.length(); i++) {
            char c = encrypt.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shiftedValue = (c - base - shift + 26) % 26;
                c = (char) (base + shiftedValue);
            }
            currentAttempt.append(c);
        }
        // Score the current attempt based on the number of English words found
        String[] words = currentAttempt.toString().split("\\s+");
        for (String word : words) {
            if (Arrays.asList(dictionary).contains(word.toLowerCase())) {
                currentScore++;
            }
        }
        // Compare the different scores in order to determine the best option
        if (currentScore > bestScore) {
            bestScore = currentScore;
            bestDecryption.setLength(0);
            bestDecryption.append("Your message had a shift of " + shift + ": " + currentAttempt.toString() + "\n");
        }
    }
    return bestDecryption.toString();
    }

    static public String morseCode() {
        String inputText = encrypt.toUpperCase();
        StringBuilder morseCode = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if (c == ' ') {
                morseCode.append("/"); //adds a backslash in between words
            } else if (c >= 'A' && c <= 'Z') {
                int index = c - 'A'; 
                morseCode.append(morseCodeArray[index]);
                morseCode.append(" "); //add more spacing between words
            }
        }
        return morseCode.toString().trim();
    }
    public static String decodeMorse(){  
        String[] words = encrypt.split("\\s+/\\s+"); // Split words by spaces with slashes
        StringBuilder decodedText = new StringBuilder();
    
        for (String word : words) {
            String[] letters = word.split("\\s+"); // Split letters by spaces
            for (String letter : letters) {
                for (int i = 0; i < morseCodeArray.length; i++) {
                    if (morseCodeArray[i].equals(letter)) {
                        decodedText.append((char) ('A' + i));
                        break;
                    }
                }
            }
            decodedText.append(" "); // Add spaces between words
        }
        return decodedText.toString().trim();
    }
}


