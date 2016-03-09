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
                    System.out.println("The lowest positive number that produces a hash containing 6 leading 0 is: " + md5Num);
                    break;
                }
                md5Num++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        public class controller {



                public static void main(String[] args){

                        String[] dimS = new String[3];
                        int[] dim = new int[3];
                        int total = 0;

                        for(String s: args){
                                dimS= s.split("x");
                                dim[0] = Integer.parseInt(dimS[0]);
                                dim[1] = Integer.parseInt(dimS[1]);
                                dim[2] = Integer.parseInt(dimS[2]);

                                total += (2*dim[0]*dim[1] + 2*dim[0]*dim[2] + 2*dim[1]*dim[2]
                                            + calcSlack(dim));
                            }

                        System.out.println(total);

                    }

                public static int calcSlack(int[] dim){

                        int slack = 1;
                        int max = dim[0];
                        for(int i=1; i<dim.length; i++){
                                if(dim[i] > max)
                                    max = dim[i];
                            }

                        for(int i: dim){
                                if(i != max)
                                    slack *= i;
                            }

                        return slack;

                    }

        }


    }
}
