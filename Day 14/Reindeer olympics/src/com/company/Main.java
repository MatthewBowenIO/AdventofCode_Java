package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ReinDeer> reinDeers = new ArrayList<>();

        for(String s : args) {
            String[] sa = s.split("-");
            reinDeers.add(new ReinDeer(sa[0], Integer.parseInt(sa[1]), Integer.parseInt(sa[2]),
                    Integer.parseInt(sa[3]), Integer.parseInt(sa[4])));
        }

        for(int i = 0; i <= 2503; i++) {
            ReinDeer temp = new ReinDeer("", 0, 0, 0, 0);
            for (ReinDeer r : reinDeers) {
                r.travelShort(r.travelInformation);

                if(r.travelInformation.distanceTraveled > temp.travelInformation.distanceTraveled) {
                    temp = r;
                }
            }

            reinDeers.get(reinDeers.indexOf(temp)).points++;
        }

        ReinDeer winner = new ReinDeer("", 0, 0 ,0 ,0);
        for(ReinDeer reinDeer : reinDeers) {
            if(reinDeer.points > winner.points)
                winner = reinDeer;
        }

        System.out.println(winner.getName() + " won the race with: " + winner.points + " many points");
    }
}

class ReinDeer {
    private String name;
    private int speed;
    private int travelDuration;
    private int restDuration;
    private int tripDuration;

    public int points;

    public TravelInformation travelInformation = new TravelInformation(0, 0, 0, false);

    public ReinDeer(String name, int speed, int travelDuration, int restDuration, int tripDuration) {
        this.name = name;
        this.speed = speed;
        this.travelDuration = travelDuration;
        this.restDuration = restDuration;
        this.tripDuration = tripDuration;

        this.points = 0;
    }

    public int travel() {
        for(int i = 0; i <= tripDuration; i++) {
            travelShort(travelInformation);
        }

        return travelInformation.distanceTraveled;
    }

    public void travelShort(TravelInformation ti) {
        if(ti.travelCount == travelDuration) {
            ti.resting = true;
            ti.travelCount = 0;
        }

        if(ti.restingCount == restDuration) {
            ti.resting = false;
            ti.restingCount = 0;
        }

        if(!ti.resting) {
            ti.distanceTraveled += speed;
            ti.travelCount++;
        } else {
            ti.restingCount++;
        }
    }

    public String getName() {
        return this.name;
    }

    class TravelInformation {
        int distanceTraveled;
        int travelCount;
        int restingCount;
        boolean resting;

        public TravelInformation(int dt, int tc, int rc, boolean r) {
            distanceTraveled = dt;
            travelCount = tc;
            restingCount = rc;
            resting = r;
        }
    }
}

/*
           System.out.print(sa[0] + " would travel: " + new ReinDeer(Integer.parseInt(sa[1]), Integer.parseInt(sa[2]),
                                                         Integer.parseInt(sa[3]), Integer.parseInt(sa[4])).travel() +
                                                         "km in " + sa[4] + " seconds!\n");

        System.out.print("Comet would travel: " + new ReinDeer(3, 37, 76, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Dasher would travel: " + new ReinDeer(10, 4, 37, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Vixen would travel: " + new ReinDeer(8, 8, 53, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Rudolph would travel: " + new ReinDeer(20, 7, 132, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Cupid would travel: " + new ReinDeer(12, 4, 43, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Donner would travel: " + new ReinDeer(9, 5, 38, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Prancer would travel: " + new ReinDeer(9, 12, 97, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Dancer would travel: " + new ReinDeer(37, 1, 36, 2503).travel() + "km in 2503 seconds!\n");
        System.out.print("Blitzen would travel: " + new ReinDeer(13, 4, 49, 2503).travel() + "km in 2503 seconds!\n");

        Comet would travel: 2496km in 2503 seconds!
        Dasher would travel: 2470km in 2503 seconds!
        Vixen would travel: 2648km in 2503 seconds!
        Rudolph would travel: 2560km in 2503 seconds!
        Cupid would travel: 2592km in 2503 seconds!
        Donner would travel: 2655km in 2503 seconds!
        Prancer would travel: 2484km in 2503 seconds!
        Dancer would travel: 2516km in 2503 seconds!
        Blitzen would travel: 2496km in 2503 seconds!
 */