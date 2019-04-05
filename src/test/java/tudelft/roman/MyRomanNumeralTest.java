package tudelft.roman;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import tudelft.roman.MyRomanNumeral;

public class MyRomanNumeralTest {

    MyRomanNumeral roman;

    @BeforeEach
    public void initialize() {
        roman = new MyRomanNumeral();
    }

    @Test
    public void testMyRoman() {

        Assertions.assertEquals(1, roman.convert("I"));
        Assertions.assertEquals(5, roman.convert("V"));
        Assertions.assertEquals(10, roman.convert("X"));
        Assertions.assertEquals(50, roman.convert("L"));
        Assertions.assertEquals(100, roman.convert("C"));
        Assertions.assertEquals(500, roman.convert("D"));
        Assertions.assertEquals(1000, roman.convert("M"));

        Assertions.assertEquals(1113, roman.convert("MCXIII"));
        Assertions.assertEquals(2222, roman.convert("MMCCXXII"));
        Assertions.assertEquals(4331, roman.convert("MMMMCCCXXXI"));

        Assertions.assertEquals(1113, roman.convert("MCXIII"));
        Assertions.assertEquals(2222, roman.convert("MMCCXXII"));
        Assertions.assertEquals(4331, roman.convert("MMMMCCCXXXI"));

        Assertions.assertEquals(1482, roman.convert("MCDLXXXII"));
        Assertions.assertEquals(2843, roman.convert("MMDCCCXLIII"));
        Assertions.assertEquals(4874, roman.convert("MMMMDCCCLXXIV"));

        Assertions.assertEquals(1474, roman.convert("MCDLXXIV"));
        Assertions.assertEquals(2747, roman.convert("MMDCCXLVII"));
        Assertions.assertEquals(4659, roman.convert("MMMMDCLIX"));

        // Corner cases

        Assertions.assertEquals(0, roman.convert(""));
        Assertions.assertEquals(0, roman.convert(null));
        Assertions.assertEquals(20, roman.convert("xx"));
        Assertions.assertEquals(0, roman.convert("/2`';[}abc"));

    }


  
   

}
