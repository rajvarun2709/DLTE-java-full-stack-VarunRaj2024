package basic.services;

import java.util.*;

class MapsExample {

    public static void main(String[] args)
    {

        Map<String, Integer> map = new HashMap<>();

        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);
        for (Map.Entry<String, Integer> e : map.entrySet())
            System.out.println(e.getKey() + " "
                    + e.getValue());

    }
}



//
//class MapsExample {
//
//    public static void main(String[] args)
//    {
//
//        Map<String, Integer> map = new LinkedHashMap<>();
//
//        map.put("vishal", 10);
//        map.put("sachin", 30);
//        map.put("vaibhav", 20);
//
//        for (Map.Entry<String, Integer> e : map.entrySet())
//
//            System.out.println(e.getKey() + " "
//                    + e.getValue());
//    }
//}




//public class MapsExample {
//
//    public static void main(String[] args)
//    {
//
//        Map<String, Integer> map = new TreeMap<>();
//
//        map.put("vishal", 10);
//        map.put("sachin", 30);
//        map.put("vaibhav", 20);
//
//
//        for (Map.Entry<String, Integer> e : map.entrySet())
//
//            System.out.println(e.getKey() + " "
//                    + e.getValue());
//    }
//}

//class MapsExample {
//    public static void main(String args[])
//    {
//
//        Map<Integer, String> hm1 = new HashMap<Integer, String>();
//
//        hm1.put(new Integer(1), "Geeks");
//        hm1.put(new Integer(2), "Geeks");
//        hm1.put(new Integer(3), "Geeks");
//
//        System.out.println("Initial Map " + hm1);
//
//        hm1.put(new Integer(2), "For");
//        hm1.remove(new Integer(4));
//
//        System.out.println("Updated Map " + hm1);
//    }
//}