package jids.util;

import jids.enums.Patterns;

public class RulePatternGenerator {
    
 
    public static String totalRule(String rule){
    String mode = RulePatternGenerator.mode(rule);
 
     String modePattern = RulePatternGenerator.modePattern(mode);

     String srcIp = RulePatternGenerator.sourceIpPattern(rule);    
     String dstIp = RulePatternGenerator.destIpPattern(rule); 

     String srcPort = RulePatternGenerator.sourcePortPattern(rule);
     String dstPort = RulePatternGenerator.destPortPattern(rule);
     String totalrule = "";

    if(mode.equals("TCP")){

    totalrule = modePattern+srcIp+dstIp+srcPort+dstPort;
    return totalrule;

    }

    else if(mode.equals("HTTP")){    

     totalrule = "06(?:.|\\n){4}"+srcIp+dstIp+srcPort+dstPort+modePattern;
     return totalrule;

    }
    
    else{
        totalrule= srcIp+dstIp+srcPort+dstPort;
        return totalrule;
    }
   
    }

    public static String modePattern(String mode){
     
        if(mode.equals("TCP")){
           return "06(?:.|\\n){4}";
        }
        if(mode.equals("HTTP")){
            return "(?:.|\\n)*485454502F312E31";
        }
        return "";
    }

    public static String mode(String input){
        String match = RegexSearch.match(input,Patterns.MODE.getText());
        if(match == "TCP"){
           return "TCP";
        }
        if(match == "HTTP"){
            return "HTTP";
        }
        return match;
    }

    public static String sourcePortPattern(String input){
        String match = RegexSearch.match(input,Patterns.SRCPORT.getText());

        if(match.equals("")){
        return ".{4}";
        }        

        match = Converter.convertPortToHexRule(match); 

        while(match.length()<4){
            match = "0"+match;
        }
        
        String frstHalf= match.substring(0,2);
        String secHalf = match.substring(2);
        match = frstHalf+secHalf;
    
        return "("+match+")";
    }

    public static String destPortPattern(String input){
        String match = RegexSearch.match(input,Patterns.DSTPORT.getText());

        if(match.equals("")){
        return ".{4}";
        }        

        match = Converter.convertPortToHexRule(match); 

        while(match.length()<4){
            match = "0"+match;
        }

        String frstHalf= match.substring(0,2);
        String secHalf = match.substring(2);
      
        match = frstHalf+secHalf;
    
        return "("+match+")";
    }

    public static String sourceIpPattern(String input){   

    String match = RegexSearch.match(input,Patterns.SRCIP.getText());
  
    if(match.equals("")){
        return ".{8}";
    }
    match = Converter.convertIpToHexRule(match); 
    
     return "("+match+")";
    }

    public static String destIpPattern(String input){   
     String match = RegexSearch.match(input,Patterns.DSTIP.getText());
     
     if(match.equals("")){
        return ".{8}";
    }
     match = Converter.convertIpToHexRule(match); 


     return "("+match+")";
    }


}
