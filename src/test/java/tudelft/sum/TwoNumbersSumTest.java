package tudelft.sum;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TwoNumbersSumTest {

    private static TwoNumbersSum o;
    private static ArrayList<Integer> n1;
    private static ArrayList<Integer> n2;

    @BeforeEach
    public void init() {
        o = new TwoNumbersSum();
        n1 = new ArrayList<>();
        n2 = new ArrayList<>();
    }

    @AfterAll
    public static void destroy() {
        o = null;
        n1 = null;
        n2 = null;
    }

    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, () -> getNumber(o.addTwoNumbers(null, null)));
    }

    @Test
    public void someEmpty() {
        // All are Empty
        assertEquals(0, getNumber(o.addTwoNumbers(n1, n2)));
        n1.add(0);
        n2.add(0);
        assertEquals(0, getNumber(o.addTwoNumbers(n1, n2)));

        // Only First is Empty
        n2.add(1);
        n2.add(0);
        assertEquals(10, getNumber(o.addTwoNumbers(n1, n2)));
        // Only Second is Empty
        n2.clear();
        n1.add(3);
        n1.add(2);
        assertEquals(32, getNumber(o.addTwoNumbers(n1, n2)));
    }

    @Test
    public void noneEmpty() {

        // Only Second is Empty
        n1.add(3);
        n1.add(2);
        n2.add(5);
        n2.add(5);
        assertEquals(55 + 32, getNumber(o.addTwoNumbers(n1, n2)));
    }

    @Test
    public void testDigits() {

        // Only Second is Empty
        n1.add(3);
        n1.add(0);
        n2.add(5);
        n2.add(0);
        assertEquals(30 + 50, getNumber(o.addTwoNumbers(n1, n2)));

        // Test overflow in unit sum
        n1.add(3);
        n1.add(7);
        n2.add(5);
        n2.add(9);
        assertEquals(3037 + 5059, getNumber(o.addTwoNumbers(n1, n2)));
    }

    @Test
    public void testDigits2() {

        // Only Second is Empty
        n1.add(36);
        n1.add(2);
        n2.add(26);
        n2.add(9);
        Assertions.assertThrows(IllegalArgumentException.class, () -> getNumber(o.addTwoNumbers(n1, n2)));

    }

    @Test
    public void test() {
        // Case
        n1.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        n2.addAll(Arrays.asList(6, 7, 5, 4, 9, 1, 3, 6, 4));
        assertEquals(123456 + 675491364, getNumber(o.addTwoNumbers(n1, n2)));

        n1.clear();
        n2.clear();
        // Case
        n1.addAll(Arrays.asList(1, 0, 0, 6));
        n2.addAll(Arrays.asList(6, 0, 0, 0, 9));
        assertEquals(1006 + 60009, getNumber(o.addTwoNumbers(n1, n2)));

    }

    public static long getNumber(ArrayList<Integer> list) {

        long result = 0;
        long power = list.size() - 1;
        for (int n : list) {
            result += n * Math.pow(10, power);
            power--;
        }
        return result;
    }

}
