package FunctionTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.util.Converter;

public class DecToHexTest {
    
   @Test
    public void singleDigitTest(){
        Assertions.assertEquals("01",Converter.decToHex("1"));
        Assertions.assertEquals("07",Converter.decToHex("7"));
    }
    @Test
    public void doubleDigitTest(){
        Assertions.assertEquals("0A",Converter.decToHex("10"));
        Assertions.assertEquals("15",Converter.decToHex("21"));
    }
    @Test
    public void zeroTest(){
        Assertions.assertEquals("00",Converter.decToHex("0"));
    }

}
