package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> characterCodeMap = new HashMap<>();
	    static {
	        String[] charGroups = { "BFPV", "CGJKQSXZ", "DT", "L", "MN", "R" };
	        char[] codes = { '1', '2', '3', '4', '5', '6' };
	        mapCharacterCode(charGroups, codes);
	    }
    
	private static void mapCharacterCode(String[] charGroups, char[] codes) {
			for (int charGroup = 0; charGroup < charGroups.length; charGroup++) {
	            for (char c : charGroups[charGroup].toCharArray()) {
	                characterCodeMap.put(c, codes[charGroup]);
	            }
	        }
		}

    public static String generateSoundex(String inputString) {
        if (isInputInvalid(inputString)) {
            return "";
        }
        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(inputString.charAt(0)));
        processSoundexCharacters(inputString, soundex);
        return finalizeSoundexCode(soundex);
    }

    private static boolean isInputInvalid(String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    private static void processSoundexCharacters(String inputString, StringBuilder soundex) {
        char previousCode = '0'; 
        char previousChar = Character.toUpperCase(inputString.charAt(0)); 
        for (int index = 1; index < inputString.length() && soundex.length() < 4; index++) {
            char currentChar = Character.toUpperCase(inputString.charAt(index));
            processCharacterForSoundex(soundex, currentChar, previousChar, previousCode);
            previousCode = fetchSoundexCode(currentChar);
            previousChar = currentChar; 
        }
    }

    private static void processCharacterForSoundex(StringBuilder soundex, char currentChar, char previousChar, char previousCode) {
        if (shouldCharacterBeSkipped(currentChar, previousChar)) {
            return;
        }
        char code = fetchSoundexCode(currentChar);
        appendValidSoundexCode(soundex, code, previousCode);
    }

    private static boolean shouldCharacterBeSkipped(char currentChar, char previousChar) {
        return isSkippedCharacter(currentChar) && !isVowelCharacterOrCharY(previousChar);
    }

    private static boolean isSkippedCharacter(char currentChar) {
        return currentChar == 'H' || currentChar == 'W';
    }

    private static boolean isVowelCharacterOrCharY(char c) {
        return "AEIOUY".indexOf(c) >= 0;
    }

    private static void appendValidSoundexCode(StringBuilder soundex, char code, char previousCode) {
        if (isCodeValid(code, previousCode) && soundex.length() < 4) {
            soundex.append(code);
        }
    }

    private static boolean isCodeValid(char code, char previousCode) {
        return code != '0' && code != previousCode;
    }

    private static char fetchSoundexCode(char c) {
        return characterCodeMap.getOrDefault(c, '0');
    }

    private static String finalizeSoundexCode(StringBuilder soundex) {
        while (soundex.length() < 4) {
            soundex.append('0');
        }
        return soundex.toString();
    }
}
