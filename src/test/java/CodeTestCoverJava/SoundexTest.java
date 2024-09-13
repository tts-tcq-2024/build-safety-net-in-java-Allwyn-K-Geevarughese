package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
        assertEquals(Soundex.computeSoundexCode(""), "");
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(Soundex.computeSoundexCode("B"), "B000");
    }

    @Test
    public void testStringWithSpace() {
        assertEquals(Soundex.computeSoundexCode("Doe John"), "D500");
    }

    @Test
    public void testStringWithVowelsOnly() {
        assertEquals(Soundex.computeSoundexCode("AEIOU"), "A000");
    }

    @Test
    public void testStringForSoundJ() {
        assertEquals(Soundex.computeSoundexCode("Jenkins"), "J525");
    }

    @Test
    public void testStringForSoundH() {
        assertEquals(Soundex.computeSoundexCode("Hamilton"), "H543");
    }
}
