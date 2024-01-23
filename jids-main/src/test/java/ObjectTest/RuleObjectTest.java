package ObjectTest;

import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.Objects.Rule;

public class RuleObjectTest {
   
   static Rule spyRule = spy(new Rule(null,null,null,null));

 

    @Test
    public void ruleToStringTest(){

        spyRule.setCve("cve");
        spyRule.setId("1");
        spyRule.setMsg("msg");
        spyRule.setPattern("pattern");
        
        Assertions.assertEquals("pattern | msg | cve | 1",spyRule.toString());
    }
    
}
