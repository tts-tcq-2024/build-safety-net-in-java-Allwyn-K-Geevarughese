package CodeTestCoverJava;

public class Soundex {

    public static String generateSoundex(String name) {
        if (isInvalidName(name)) {
            return "";
        }

        // Initialize Soundex with the first letter, converting to uppercase
        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));

        // Track the Soundex code of the previous character
        char prevCode = getSoundexCode(name.charAt(0));

        // Process remaining characters starting from the second one
        processRemainingCharacters(name, soundex, prevCode);

        // Pad with zeros to make the Soundex code 4 characters long
        padWithZeros(soundex);

        return soundex.toString();
    }

    // Helper function to check for invalid name
    private static boolean isInvalidName(String name) {
        return name == null || name.isEmpty();
    }

    // Helper function to process remaining characters in the name
    private static void processRemainingCharacters(String name, StringBuilder soundex, char prevCode) {
        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char code = getSoundexCode(name.charAt(i));
            if (shouldAppendCode(code, prevCode)) {
                soundex.append(code);
   
