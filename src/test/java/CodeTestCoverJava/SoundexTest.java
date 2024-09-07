package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;

import org.junit.Test;

public class SoundexTest {
    Soundex soundexMock = Mockito.mock(Soundex.class);

    @Test
    public void testEmptyString() {
        assertEquals(Soundex.generateSoundex(""), "");
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(Soundex.generateSoundex("A"), "A000");
    }

    @Test
    public void testStringWithEmptySpace() {
        assertEquals(Soundex.generateSoundex("Van Gogh"), "V522");
    }

    @Test
    public void testStringWithVowel() {
        assertEquals(Soundex.generateSoundex("AEIOU"), "A000");
    }

    @Test
    public void testStringSoundJ() {
        assertEquals(Soundex.generateSoundex("Jackson"), "J250");
    }

    @Test
    public void testStringSoundH() {
        assertEquals(Soundex.generateSoundex("Hilbert"), "H416");
    }
}
