package basic.services;

import java.util.StringTokenizer;

public class Backlog {
    String email;
    public  void tokenizing() {
        StringTokenizer tokenizer=new StringTokenizer(email, "@.");
        String[] particiulars=new String[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()){
            
        }
    }
}
