package CodeTestCoverJava;

public class Soundex {

   public static String generateSoundex(String name) {
    if (isInvalidName(name)) {
        return "";
    }

    StringBuilder soundex = new StringBuilder();
    soundex.append(Character.toUpperCase(name.charAt(0)));

    char prevCode = getSoundexCode(name.charAt(0));

    processRemainingCharacters(name, soundex, prevCode);

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
            prevCode = code;
        }
    }
}

// Helper function to check if the code should be appended
private static boolean shouldAppendCode(char code, char prevCode) {
    return code != '0' && code != prevCode;
}

// Helper function to pad the Soundex with zeros if necessary
private static void padWithZeros(StringBuilder soundex) {
    while (soundex.length() < 4) {
        soundex.append('0');
    }
}


   private static char getSoundexCode(char c) {
    c = Character.toUpperCase(c);
    String soundexMap = "01230120022455012623010202"; 
    if (c >= 'A' && c <= 'Z') {
        return soundexMap.charAt(c - 'A');
    }
    return '0'; 
}

}
