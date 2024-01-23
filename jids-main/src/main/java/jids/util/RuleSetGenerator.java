package jids.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import jids.Objects.Rule;

public class RuleSetGenerator {
        public static void main(String[] args) throws IOException{

                FileInputStream fis = new FileInputStream("./jids/rules.conf");
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                Rule[] ruleArray = createRuleSet(br);
                for(Rule x : ruleArray){
                        System.out.println("Eine Regel"+x.toString());
                }
            }
        


        public static Rule createRule(String fullRule){
                String pattern = RulePatternGenerator.totalRule(fullRule);
                String cve = CveExtractor.getCve(fullRule);
                String msg = MessageExtractor.getMessage(fullRule);
                String id = IdExtractor.getId(fullRule);
                Rule rule = new Rule(pattern, msg, cve, id);
                return rule;
        }

        public static Rule[] createRuleSet(BufferedReader br) throws IOException{
        Stack<Rule> rules = new Stack<Rule>();
                while(true){
                if(br.ready()){
                String cur = br.readLine();
                Rule currentRule = createRule(cur);
                System.out.println("Regel"+currentRule.toString());
                rules.push(currentRule);
                }
                else{
                        break;
                }
                }
        int size = rules.size();
        System.out.println("Größe"+size);
        Rule[] ruleArray = new Rule[size];
        rules.copyInto(ruleArray);
        return ruleArray;
        }
}
