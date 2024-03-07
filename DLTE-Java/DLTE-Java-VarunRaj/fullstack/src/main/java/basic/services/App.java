package basic.services;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        String[] studentname=new String[20];
        studentname[2]="varun";
        studentname[2]="narmada";
        ArrayList<String> studentnames=new ArrayList<>();
        studentnames.add("arunsagar");
        studentnames.add("250");
        studentnames.add("janata");
        studentnames.add("janata");
        studentnames.add(2,"ramana");
        //System.out.println(studentnames);

        ArrayList<String> name=new ArrayList<>();
       name.add("500");
       name.add("700");
       studentnames.addAll(name);
        System.out.println(studentnames);
        System.out.println(studentnames.get(1));
        System.out.println(studentnames);
        studentnames.remove(1);
        studentnames.remove(String.valueOf("janata"));
        System.out.println(studentnames);
        List<String> names=new ArrayList<>();
       // names.clear();
        studentnames.set(2,"revana");
        System.out.println(studentnames);
        System.out.println(studentnames.contains("700"));

        for (int i = 0; i <studentnames.size() ; i++) {
            System.out.println(studentnames.get(i));
        }
        for (String elem: studentnames) {
            System.out.println(elem);
        }




    }
}
