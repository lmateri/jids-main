package FunctionTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.util.IdExtractor;


public class IdExtractionTest {
    String ruleOne = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (cve:'CVE-2023-2232'; id:'1')";
   
    @Test
    public void cveTest(){
        Assertions.assertEquals("1",IdExtractor.getId(ruleOne));
    }

    @Test
    public void readIdOutOfFile() throws IOException{

        FileInputStream fis = new FileInputStream("./src/test/java/FunctionTest/test.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String lineOne = br.readLine();
        Assertions.assertEquals("1", IdExtractor.getId(lineOne));
        String lineTwo = br.readLine();
        Assertions.assertEquals("2", IdExtractor.getId(lineTwo));
    
    }


}
