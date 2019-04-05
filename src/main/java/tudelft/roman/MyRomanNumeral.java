package tudelft.roman;

import java.util.HashMap;

public class MyRomanNumeral {

    HashMap<Character, Integer> symbols = new HashMap<>(7);

    public MyRomanNumeral() {
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

    }

    public int convert(String romanNumeral) {

        if (romanNumeral == null)
            return 0;
        int arabic = 0;
        int previous = Integer.MAX_VALUE;
        String roman = romanNumeral.toUpperCase();

        // for every letter
        for (char c : roman.toCharArray()) {

            if (!symbols.containsKey(c)) {
                return 0;
            }
            // convert to correspoing arabic (current)
            int current = symbols.get(c);
            // if current is bigger than the previous
            if (current > previous) {
                // subract the previous two times
                arabic -= 2 * previous;
            }
            // add current
            arabic += current;
            // set previous = current
            previous = current;
        }
        return arabic;
    }

}
