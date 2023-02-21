package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void baseCaseValidCombinationsToArabic() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCXX");
        assertEquals(converter.toArabic(), 2120);

        converter = new ElbonianArabicConverter("CCCXII");
        assertEquals(converter.toArabic(), 312);


        // single letters
        converter = new ElbonianArabicConverter("N");
        assertEquals(converter.toArabic(), 5000);

        converter = new ElbonianArabicConverter("D");
        assertEquals(converter.toArabic(), 500);

        converter = new ElbonianArabicConverter("L");
        assertEquals(converter.toArabic(), 50);

        converter = new ElbonianArabicConverter("V");
        assertEquals(converter.toArabic(), 5);

        converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);

        converter = new ElbonianArabicConverter("C");
        assertEquals(converter.toArabic(), 100);

        converter = new ElbonianArabicConverter("X");
        assertEquals(converter.toArabic(), 10);

        converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);

        converter = new ElbonianArabicConverter("n");
        assertEquals(converter.toArabic(), 4000);

        converter = new ElbonianArabicConverter("d");
        assertEquals(converter.toArabic(), 400);

        converter = new ElbonianArabicConverter("l");
        assertEquals(converter.toArabic(), 40);

        converter = new ElbonianArabicConverter("v");
        assertEquals(converter.toArabic(), 4);
    }



    @Test
    public void trimWhitespace() throws MalformedNumberException, ValueOutOfBoundsException {
        // before
        ElbonianArabicConverter converter = new ElbonianArabicConverter("     MMCXX");
        assertEquals(converter.toArabic(), 2120);

        // after
        converter = new ElbonianArabicConverter("MMCXX     ");
        assertEquals(converter.toArabic(), 2120);

        // before and after
        converter = new ElbonianArabicConverter("       MMCXX     ");
        assertEquals(converter.toArabic(), 2120);
    }



    @Test(expected = MalformedNumberException.class)
    public void whitespaceInTheMiddle() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CC CXII");
    }

    @Test
    public void ArabicToElbonianSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("312");
        assertEquals(converter.toElbonian(), "CCCXII");
    }

    @Test
    public void AtoEtest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10");
        assertEquals(converter.toElbonian(), "X");
    }

    @Test
    public void AtoETests() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1000");
        assertEquals(converter.toElbonian(), "M");

        converter = new ElbonianArabicConverter("30");
        assertEquals(converter.toElbonian(), "XXX");
    }


    @Test
    public void isValidTriples() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("III");
        assertEquals(converter.toArabic(), 3);

        converter = new ElbonianArabicConverter("XXX");
        assertEquals(converter.toArabic(), 30);

        converter = new ElbonianArabicConverter("CCC");
        assertEquals(converter.toArabic(), 300);

        converter = new ElbonianArabicConverter("MMM");
        assertEquals(converter.toArabic(), 3000);
    }
    @Test (expected = MalformedNumberException.class)
    public void isInvalidTriples() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IIII");
        assertEquals(converter.toArabic(), 4);

        converter = new ElbonianArabicConverter("XXXX");
        assertEquals(converter.toArabic(), 40);

        converter = new ElbonianArabicConverter("CCCC");
        assertEquals(converter.toArabic(), 400);

        converter = new ElbonianArabicConverter("MMMM");
        assertEquals(converter.toArabic(), 4000);
    }
    // TODO Add more test cases
}
