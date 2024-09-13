package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }

    @Test
    public void testNullString() {
        assertEquals("", Soundex.generateSoundex(null));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(Soundex.generateSoundex("A"), "A000");
    }

    @Test
    public void testVowels() {
        assertEquals("A000", Soundex.generateSoundex("AEIOU"));
    }

    @Test
    public void testConsonants() {
        assertEquals("S530", Soundex.generateSoundex("Smith")); // S530
        assertEquals("R163", Soundex.generateSoundex("Robert")); // R163
    }

    @Test
    public void testRepeatedConsonants() {
        assertEquals("T315", Soundex.generateSoundex("Ttfn")); // T315
    }

    @Test
    public void testPadding() {
        assertEquals("W623", Soundex.generateSoundex("Wright")); // W623
        assertEquals("P620", Soundex.generateSoundex("Park"));   // Updated to P620
    }

    @Test
    public void testMixedCase() {
        assertEquals("R163", Soundex.generateSoundex("RoBeRt")); // R163
    }

    @Test
    public void testHAndWHandling() {
        assertEquals("R000", Soundex.generateSoundex("RWH")); // R000
    }
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
