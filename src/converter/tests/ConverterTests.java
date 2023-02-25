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
    public void baseCaseAtoE() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10");
        assertEquals(converter.toElbonian(), "X");

        converter = new ElbonianArabicConverter("1000");
        assertEquals(converter.toElbonian(), "M");

        converter = new ElbonianArabicConverter("30");
        assertEquals(converter.toElbonian(), "XXX");
    }

    // out of bounds numbers
    @Test (expected = ValueOutOfBoundsException.class)
    public void AtoEbound1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10000");
        assertEquals(converter.toElbonian(), "");
    }
    @Test (expected = ValueOutOfBoundsException.class)
    public void AtoEbound2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("123450000");
        assertEquals(converter.toElbonian(), "");
    }
    @Test (expected = ValueOutOfBoundsException.class)
    public void AtoEbound3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
        assertEquals(converter.toElbonian(), "");
    }
    @Test (expected = ValueOutOfBoundsException.class)
    public void AtoEbound4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-1");
        assertEquals(converter.toElbonian(), "");
    }

    // decmals :]
    @Test (expected = MalformedNumberException.class)
    public void AtoEdecimal1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1.2");
        assertEquals(converter.toElbonian(), "");
    }
    @Test (expected = MalformedNumberException.class)
    public void AtoEdecimal2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter(".2");
        assertEquals(converter.toElbonian(), "");
    }

    @Test
    public void validTriples() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("III");
        assertEquals(converter.toArabic(), 3);

        converter = new ElbonianArabicConverter("XXX");
        assertEquals(converter.toArabic(), 30);

        converter = new ElbonianArabicConverter("CCC");
        assertEquals(converter.toArabic(), 300);

        converter = new ElbonianArabicConverter("MMM");
        assertEquals(converter.toArabic(), 3000);
    }

    // invalid triples
    @Test (expected = MalformedNumberException.class)
    public void invalidTriple1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IIII");
        assertEquals(converter.toArabic(), 4);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidTriple2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XXXX");
        assertEquals(converter.toArabic(), 40);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidTriple3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCC");
        assertEquals(converter.toArabic(), 400);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidTriple4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMM");
        assertEquals(converter.toArabic(), 4000);
    }

// long way invalid combos
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("vI");
        assertEquals(converter.toArabic(), 4);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("nvII");
        assertEquals(converter.toArabic(), 4);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("lX");
        assertEquals(converter.toArabic(), 40);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MlXII");
        assertEquals(converter.toArabic(), 40);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("dC");
        assertEquals(converter.toArabic(), 400);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MdCII");
        assertEquals(converter.toArabic(), 400);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("nM");
        assertEquals(converter.toArabic(), 4000);
    }
    @Test (expected = MalformedNumberException.class)
    public void invalidCombo8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NnMII");
        assertEquals(converter.toArabic(), 4000);

    }
    // TODO Add more test cases
}
