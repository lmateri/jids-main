package FunctionTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.util.MessageExtractor;

public class MessageExtractionTest {
    String ruleOne = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'Das Gras ist grün')";
    String ruleTwo = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'Das Gras wächst schnell')";
    String ruleThree = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'Das Gras ist größer als vorher')";

    @Test
    public void specialCharacterTest(){
        Assertions.assertEquals("Das Gras ist grün",MessageExtractor.getMessage(ruleOne));
        Assertions.assertEquals("Das Gras wächst schnell",MessageExtractor.getMessage(ruleTwo));
        Assertions.assertEquals("Das Gras ist größer als vorher",MessageExtractor.getMessage(ruleThree));
    }

    @Test
    public void readMsgOutOfFile() throws IOException{
        FileInputStream fis = new FileInputStream("./src/test/java/FunctionTest/test.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String lineOne = br.readLine();
        Assertions.assertEquals("grün", MessageExtractor.getMessage(lineOne));
        String lineTwo = br.readLine();
        Assertions.assertEquals("msg2", MessageExtractor.getMessage(lineTwo));
    }

}
