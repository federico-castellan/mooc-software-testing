package tudelft.sum;

import java.util.ArrayList;
import java.util.Collections;

// Source: https://leetcode.com/problems/add-two-numbers/description/
class TwoNumbersSum {

    public ArrayList<Integer> addTwoNumbers(ArrayList<Integer> firstF, ArrayList<Integer> secondF) {

        ArrayList<Integer> first = new ArrayList<>(firstF);
        ArrayList<Integer> second = new ArrayList<>(secondF);

        Collections.reverse(first);
        Collections.reverse(second);

        int complement = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
            int firstVal = i < first.size() ? first.get(i) : 0;
            int secondVal = i < second.size() ? second.get(i) : 0;
            if (firstVal >= 10 || firstVal < 0 || secondVal >= 10 || secondVal < 0) {
                throw new IllegalArgumentException("Lists don't contain correct digits");
            }
            int total = firstVal + secondVal + complement;
            complement = 0;
            if (total >= 10) {
                complement = 1;
                total -= 10;
            }
            result.add(i, total);
        }

        Collections.reverse(result);
        return result;
    }
}
