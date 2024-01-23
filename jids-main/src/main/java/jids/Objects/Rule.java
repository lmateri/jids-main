package jids.Objects;

import jids.util.RulePatternGenerator;

public class Rule {

    private String pattern;
    private String msg;
    private String cve;
    private String id;

    public Rule(String pattern,String msg, String cve, String id){

        this.pattern = pattern;
        this.msg = msg;
        this.cve = cve;
        this.id = id;

    }

    public String getPattern(){
        return this.pattern;
    }

    public void setPattern(String pattern){
        this.pattern = pattern;
    }

    public String getMsg(){
        return this.msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }


    
    public String getCve(){
        return this.cve;
    }
     
    public void setCve(String cve){
        this.cve = cve;
    }


    public String getId(){
        return this.id;
    }
     public void setId(String id){
        this.id = id;
    }

    public Rule patternGenerate(String rule){
        this.pattern = RulePatternGenerator.totalRule(rule);
        
        return this;
    }

    public String toString(){ 
        return pattern+" | "+msg+" | "+cve+" | "+id;  
       }  
}
