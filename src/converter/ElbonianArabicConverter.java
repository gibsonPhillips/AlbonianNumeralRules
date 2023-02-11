package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import java.util.HashMap;


/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    // hardcode the values of Elbonian numbers
    private static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);
        map.put('N', 5000);
        map.put('v', 4);
        map.put('l', 40);
        map.put('d', 400);
        map.put('n', 4000);
    }


    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     * in the Elbonian number system.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system or any other error in Arabic number input.
	 * Leading and trailing spaces should not throw an error.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        this.number = number;
    }


    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() throws MalformedNumberException {
            int arabic = 0;
            int prev = 0;

            for (int i = this.number.length() - 1; i >= 0; i--) {
                int current = map.get(this.number.charAt(i));

                if (current < prev) {
                    System.out.println("current: " + current + "Prev: " + prev);
                    throw new MalformedNumberException("Bigger Elbonian number after smaller Elbonian number");
                } else {
                    arabic += current;
                }

                prev = current;
            }

            return arabic;

    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        int arabic = this.number;
        if (arabic <= 0 || arabic >= 4000) {
            return "Invalid number";
        }

        String roman = "";

        for (int i : map.keySet()) {
            while (arabic >= i) {
                roman += map.get(i);
                arabic -= i;
            }
        }

        return roman;        return "I";
    }

}
