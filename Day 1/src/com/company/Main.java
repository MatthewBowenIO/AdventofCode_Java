package com.company;

public class Main {
    public static void main(String[] args) {
	    int floor = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int count = 0;
        for(String c : args[0].split("|")) {
            count++;
            if(c.equalsIgnoreCase("(")) {
                floor++;
                positiveCount++;
            } else if (c.equalsIgnoreCase(")")) {
                floor--;
                negativeCount++;
            }

            if (negativeCount > positiveCount) {
                System.out.println("Santa enters the basement at move: " + count);
                break;
            }
        }

        System.out.println("Santa needs to be on floor: " + floor);
    }
}
