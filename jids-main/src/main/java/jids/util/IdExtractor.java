package jids.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdExtractor {
    static String basicCve = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'Das Gras ist grün'; cve:'CVE-2022-1235'; id:'2')";
      
        public static String getId(String rule){
                String message = "";
                String messagePattern ="id:'([^']*)'";
                Pattern pattern = Pattern.compile(messagePattern);
                Matcher matcher = pattern.matcher(rule);
                if(matcher.find()){
                        message = matcher.group(1);}
                        else{
                                return message;
                        }
                        return message;
        }
}
