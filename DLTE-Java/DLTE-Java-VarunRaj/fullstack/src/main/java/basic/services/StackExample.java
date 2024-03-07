package basic.services;

import java.util.Iterator;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {


        Stack<String> name = new Stack<>();
        name.push("varun");
        name.push("500");
       Iterator itr=name.iterator();
       while(itr.hasNext()){
           System.out.println(itr.next());
       }
        System.out.println(name.peek());



    }
}
