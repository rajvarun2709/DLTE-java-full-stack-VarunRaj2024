package basic.services;

import java.util.Scanner;

public class Insurance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        String lic[] = {"health", "life"};
        String sbi[] = {"personal", "car", "health"};
        String star[] = {"bike", "car"};
        System.out.println("The insurance providing the given features are");
        for (String s : args) {

            for (String i : lic) {
                if (i.equalsIgnoreCase(s)) {
                    System.out.println("lic");
                    break;
                }
            }
            for (String i : sbi) {
                if (i.equalsIgnoreCase(s)) {
                    System.out.println("sbi");
                    break;
                }
            }
            for (String i : star) {
                if (i.equalsIgnoreCase(s)) {
                    System.out.println("star");
                    break;
                }
            }
        }
    }
}