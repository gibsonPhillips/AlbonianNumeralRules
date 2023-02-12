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
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }


    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }


    @Test
    public void possibility1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCXX");
        assertEquals(converter.toArabic(), 2120);
    }

    @Test
    public void possibility2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCXII");
        assertEquals(converter.toArabic(), 312);
    }

    @Test
    public void N() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("N");
        assertEquals(converter.toArabic(), 5000);
    }

    @Test
    public void D() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("D");
        assertEquals(converter.toArabic(), 500);
    }

    @Test
    public void L() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("L");
        assertEquals(converter.toArabic(), 50);
    }

    @Test
    public void V() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("V");
        assertEquals(converter.toArabic(), 5);
    }

    @Test
    public void M() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);
    }

    @Test
    public void C() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("C");
        assertEquals(converter.toArabic(), 100);
    }

    @Test
    public void X() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("X");
        assertEquals(converter.toArabic(), 10);
    }

    @Test
    public void I() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test
    public void n() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("n");
        assertEquals(converter.toArabic(), 4000);
    }

    @Test
    public void d() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("d");
        assertEquals(converter.toArabic(), 400);
    }

    @Test
    public void l() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("l");
        assertEquals(converter.toArabic(), 40);
    }

    @Test
    public void v() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("v");
        assertEquals(converter.toArabic(), 4);
    }

    @Test
    public void whitespaceBefore() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("     MMCXX");
        assertEquals(converter.toArabic(), 2120);
    }

    @Test
    public void whitespaceAfter() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCXX     ");
        assertEquals(converter.toArabic(), 2120);
    }

    @Test
    public void whitespaceBeforeAndAfter() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("       MMCXX     ");
        assertEquals(converter.toArabic(), 2120);
    }

    @Test(expected = MalformedNumberException.class)
    public void whitespaceInTheMiddle() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CC CXII");
    }

    @Test
    public void ArabicToElbonianSampleTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2120");
        assertEquals(converter.toElbonian(), "MMCXX");
    }

    @Test
    public void ArabicToElbonianSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("312");
        assertEquals(converter.toElbonian(), "CCCXII");
    }

    @Test(expected = MalformedNumberException.class)
    public void ElbonianToArabicmorethanthreeMs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMMI");
    }

    @Test(expected = MalformedNumberException.class)
    public void ElbonianToArabicmorethanthreeCs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCCI");
    }

    @Test(expected = MalformedNumberException.class)
    public void ElbonianToArabicmorethanthreeXXXs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XXXXI");
    }

    @Test(expected = MalformedNumberException.class)
    public void ElbonianToArabicmorethanthreeIs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IIIII");
    }

    @Test(expected = MalformedNumberException.class)
    public void EtoAManyNs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NN");
    }

    @Test(expected = MalformedNumberException.class)
    public void EtoAManyns() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("nn");
    }

    @Test(expected = MalformedNumberException.class)
    public void EtoAManyDs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DD");
    }

@Test(expected = MalformedNumberException.class)
    public void EtoAManyds() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("dd");
    }

    @Test(expected = MalformedNumberException.class)
    public void EtoAManyLs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LL");
    }

    @Test(expected = MalformedNumberException.class)
    public void EtoAManyls() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("ll");
    }

    @Test(expected = MalformedNumberException.class)
    public void EtoAManyVs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VV");
    }

    @Test(expected = MalformedNumberException.class)
    public void EtoAManyvs() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("vv");
        converter.toArabic();
    }
    // TODO Add more test cases
}
