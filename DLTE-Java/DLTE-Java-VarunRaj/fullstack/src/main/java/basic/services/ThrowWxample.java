package basic.services;

//public class ThrowWxample {
//    public static void validate(int age) {
//        if(age<18) {
//            throw new ArithmeticException("Person is not eligible to vote");
//        }
//        else {
//            System.out.println("Person is eligible to vote!!");
//        }
//    }
//    public static void main(String args[]){
//        validate(13);
//        System.out.println("Finished");
//    }
//}

class ThrowWxample {

    static void fun() throws IllegalAccessException
    {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[])
    {
        try {
            fun();
        }
        catch (IllegalAccessException e) {
            System.out.println("caught in main.");
        }
    }
}

