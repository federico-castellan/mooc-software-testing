package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 public class MyRomanProvidedNumeralTest {

    @Test
    public void singleNumber() {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }
}
