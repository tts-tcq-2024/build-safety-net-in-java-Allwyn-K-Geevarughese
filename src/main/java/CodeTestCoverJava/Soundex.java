package CodeTestCoverJava;

public class Soundex {
    static StringBuilder soundex = new StringBuilder();

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));
        char prevCode = getSoundexCode(name.charAt(0));
        checkLength(soundex, name);
        return appendZeroEnd(soundex).toString();
    }

    private static StringBuilder appendZeroEnd(StringBuilder soundex) {
        while (soundex.length() < 4) {
            soundex.append('0');
        }
        return soundex;
    }

    private static void checkLength(StringBuilder soundex, String name) {
        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char curChar = name.charAt(i);
            char preChar = name.charAt(i - 1);

            char code = getSoundexCode(curChar);
            char prevCode = getSoundexCode(preChar);

            appendCode(code, prevCode, soundex);
        }
    }

    private static void appendCode(char currentCode, char prevCode, StringBuilder soundex) {
        if (currentCode != '0' && currentCode != prevCode) {
            soundex.append(currentCode);
        }
    }

    private static final char[] MAP = {
        /** Keeping the data primitive 
            A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z */
        '0',
        '1',
        '2',
        '3',
        '0',
        '1',
        '2',
        '0',
        '0',
        '2',
        '2',
        '4',
        '5',
        '5',
        '0',
        '1',
        '2',
        '6',
        '2',
        '3',
        '0',
        '1',
        '0',
        '2',
        '0',
        '2'
    };

    private static char getSoundexCode(char c) {
        c = Character.toUpperCase(c);
        if (c >= 'A' && c <= 'Z') {
            return MAP[c - 'A'];
        }
        return '0';
    }
}
