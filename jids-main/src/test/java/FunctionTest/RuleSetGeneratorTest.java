package FunctionTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.Objects.Rule;
import jids.util.RuleSetGenerator;

public class RuleSetGeneratorTest {

    public static void main(String[] args) throws IOException{
            FileInputStream fis = new FileInputStream("./jids/src/test/java/FunctionTest/test.conf");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
                Rule[] ruleArray = RuleSetGenerator.createRuleSet(br);
                for(Rule x : ruleArray){
                        System.out.println("Eine Regel"+x.toString());
                }
    }

    @Test
    public void ruleArrayGeneratorTest() throws IOException{
            
                FileInputStream fis = new FileInputStream("./src/test/java/FunctionTest/test.conf");
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                Rule[] ruleArray = RuleSetGenerator.createRuleSet(br);
                for(Rule x : ruleArray){
                        System.out.println("Eine Regel"+x.toString());
                }
            
                Assertions.assertEquals("1",ruleArray[0].getId(),"Die ID der ersten Regel");
                Assertions.assertEquals("grün",ruleArray[0].getMsg(),"Die Nachricht der ersten Regel ");
                Assertions.assertEquals("CVE-2023-1237",ruleArray[0].getCve(),"Die CVE der ersten Regel ");
                Assertions.assertEquals("06(?:.|\\n){4}.{8}(0A00000A).{4}(1F92)",ruleArray[0].getPattern(),"Pattern der ersten Regel ");
                
                Assertions.assertEquals("2",ruleArray[1].getId(),"Die ID der zweiten Regel ");
                Assertions.assertEquals("msg2",ruleArray[1].getMsg(),"Die Nachricht der zweiten Regel ");
                Assertions.assertEquals("CVE-2022-1235",ruleArray[1].getCve(),"Die CVE der zweiten Regel ");
                Assertions.assertEquals("06(?:.|\\n){4}.{8}(0A00000A)(D13A)(1F90)",ruleArray[1].getPattern(),"Pattern der zweiten Regel ");
    }


}
