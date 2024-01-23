package FunctionTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.util.RulePatternGenerator;

public class RulePatternGenerateTest {
    private String validRulePattern1 = "06(?:.|\\n){4}(C0A83801)(C0A83867)(F3CA)(0016)";
    private String validTestRule1 = "TCP source-ip 192.168.56.1 dest-ip 192.168.56.103 source-port 62410 dest-port 22";
    
    private String zeroPattern = "06(?:.|\\n){4}.{8}(0A00000A).{4}(1F92)";
    private String zeroRule = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082";

    @Test
    public void tcpRulePatternGenerationConsistencyTest()
    {
        Assertions.assertEquals(validRulePattern1, RulePatternGenerator.totalRule(validTestRule1));
    }
      @Test
    public void zeroConsistencyTest()
    {
        Assertions.assertEquals(zeroPattern, RulePatternGenerator.totalRule(zeroRule));
    }
    
}
