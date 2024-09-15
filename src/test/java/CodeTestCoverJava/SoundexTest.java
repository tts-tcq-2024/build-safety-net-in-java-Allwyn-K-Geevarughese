package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
        assertEquals(Soundex.generateSoundex(""), "");
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(Soundex.generateSoundex("J"), "J000");
    }

    @Test
    public void testStringWithSpace() {
        assertEquals(Soundex.generateSoundex("D WW"), "D000");
    }

    @Test
    public void testStringWithVowelsOnly() {
        assertEquals(Soundex.generateSoundex("AEIOU"), "A000");
    }

    @Test
    public void testStringForSoundJ() {
        assertEquals(Soundex.generateSoundex("Jenkins"), "J525");
    }

    @Test
    public void testStringForSoundH() {
        assertEquals(Soundex.generateSoundex("Hamilton"), "H543");
    }

    
}
