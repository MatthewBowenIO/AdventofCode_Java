package com.company;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) {
        try {
            String val = args[0];
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            int md5Num = 0;
            while(true) {
                String hex = (new HexBinaryAdapter()).marshal(md5.digest((val + md5Num).getBytes()));
                if(hex.substring(0, 6).equalsIgnoreCase("000000")) {
                    System.out.println("The lowest positive number that produces a hash containing 5 leading 0 is: " + md5Num);
                    break;
                }
                md5Num++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
