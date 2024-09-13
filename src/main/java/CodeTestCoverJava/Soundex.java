package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

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
        return StringUtils.isBlank(inputString);
    }

    private static void processSoundexCharacters(String name, StringBuilder soundex) {
        char previousCode = '0'; 
        char previousChar = Character.toUpperCase(name.charAt(0)); 

        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char currentChar = Character.toUpperCase(name.charAt(i));
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
        return isSkippedCharacter(currentChar) && !isVowelCharacter(previousChar);
    }

    private static boolean isSkippedCharacter(char currentChar) {
        return currentChar == 'H' || currentChar == 'W';
    }

    private static boolean isVowelCharacter(char c) {
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
