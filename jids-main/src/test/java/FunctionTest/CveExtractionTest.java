package FunctionTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.util.CveExtractor;


public class CveExtractionTest {
    String ruleOne = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (cve:'CVE-2023-2232')";
   
    @Test
    public void cveTest(){
        assertEquals("CVE-2023-2232",CveExtractor.getCve(ruleOne));
    }

    @Test
    public void readCveOutOfFile() throws IOException{

        FileInputStream fis = new FileInputStream("./src/test/java/FunctionTest/test.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String lineOne = br.readLine();
        Assertions.assertEquals("CVE-2023-1237", CveExtractor.getCve(lineOne));
        String lineTwo = br.readLine();
        Assertions.assertEquals("CVE-2022-1235", CveExtractor.getCve(lineTwo));
    
    }


}
