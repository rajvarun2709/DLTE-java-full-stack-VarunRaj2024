package basic.services;

class FinalReference {

    public static void main(String[] args)
    {
        final StringBuilder sb = new StringBuilder("Hello");

        System.out.println(sb);

        sb.append("Hello world");

        System.out.println(sb);
    }
}

//class FinalReference{
//
//    final int Capacity = 4;
//
//    public static void main(String args[])
//    {
//
//        //Capacity = 5;
//    }
//}