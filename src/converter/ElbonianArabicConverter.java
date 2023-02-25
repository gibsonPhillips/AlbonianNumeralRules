package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;


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
    private static final HashMap<Character, Integer> ElbowMap = new HashMap<>();

    static {
        ElbowMap.put('I', 1);
        ElbowMap.put('X', 10);
        ElbowMap.put('C', 100);
        ElbowMap.put('M', 1000);
        ElbowMap.put('V', 5);
        ElbowMap.put('L', 50);
        ElbowMap.put('D', 500);
        ElbowMap.put('N', 5000);
        ElbowMap.put('v', 4);
        ElbowMap.put('l', 40);
        ElbowMap.put('d', 400);
        ElbowMap.put('n', 4000);
    }


    private static final LinkedHashMap<Integer, String> ArabMap = new LinkedHashMap<>();

    static {
        ArabMap.put(5000, "N");
        ArabMap.put(4000, "n");
        ArabMap.put(1000, "M");
        ArabMap.put(500, "D");
        ArabMap.put(400, "d");
        ArabMap.put(100, "C");
        ArabMap.put(50, "L");
        ArabMap.put(40, "l");
        ArabMap.put(10, "X");
        ArabMap.put(5, "V");
        ArabMap.put(4, "v");
        ArabMap.put(1, "I");
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
     *                                   in the Elbonian number system.
     * @throws MalformedNumberException  Thrown if the value is an Elbonian number that does not conform
     *                                   to the rules of the Elbonian number system or any other error in Arabic number input.
     *                                   Leading and trailing spaces should not throw an error.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        this.number = number.trim();


        String whitespace = "\\s";
        Pattern correctFormRegex = Pattern.compile(whitespace);
        if (correctFormRegex.matcher(this.number).find()) {
            throw new MalformedNumberException("whitespace in middle");
        }

        try {
            int intNumber = Integer.parseInt(this.number);
            if (intNumber < 1 || intNumber > 9999) {
                throw new ValueOutOfBoundsException("Number is out of bounds");
            }

        } catch (Exception e) {

        }
    }


    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() throws MalformedNumberException, ValueOutOfBoundsException {

        // gets the regex into a string. Only has basic form of the letters in order and the acceptable amounts
        String correctForm = "^N{0,2}n?M{0,3}D?d?C{0,3}L?l?X{0,3}V?v?I{0,3}$";

        // another regex to establish the correct form (ie don't do 4+1 when you can just do 5)
        String longWay = "(nM)|(dC)|(lX)|(vI)";
        // makes a Pattern objects that have regex loaded into
        Pattern correctFormRegex = Pattern.compile(correctForm);
        Pattern longWayRegex = Pattern.compile(longWay);
        // each if statement is working off of the Pattern regex stuff.
        if (!correctFormRegex.matcher(this.number).find()) {
            throw new MalformedNumberException("Bad configuration my guy, try again. ");
        } else if (longWayRegex.matcher(this.number).find()) {
            throw new MalformedNumberException("wrong combo. don't add them up, just use bigger number");
        }
        int arabic = 0;
        int prev = 0;

        for (int i = this.number.length() - 1; i >= 0; i--) {
            int current = ElbowMap.get(this.number.charAt(i));

            if (current < prev) {
                System.out.println("current: " + current + "Prev: " + prev);
                throw new MalformedNumberException("Bigger Elbonian number after smaller Elbonian number");
            } else {
                arabic += current;
                if (arabic >= 10000) {
                    throw new ValueOutOfBoundsException("Number has become too high");
                }
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
    public String toElbonian() throws MalformedNumberException, ValueOutOfBoundsException {
        int arabic = Integer.parseInt(this.number);

        if (arabic <= 0 || arabic >= 10000) {
            throw new ValueOutOfBoundsException("The arabic number (" + arabic + ") isn't in the acceptable range of 1 to 9999");
        }

        String Elbow = "";

        for (int i : ArabMap.keySet()) {
            while (arabic >= i) {
                System.out.println(arabic + " - " + ArabMap.get(i) + " - " + i);
                Elbow += ArabMap.get(i);
                arabic -= i;
            }
        }

        return Elbow;
    }

}
