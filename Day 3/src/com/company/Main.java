package com.company;

public class Main {
    public static void main(String[] args) {
        int[][] houseGrid = new int[1000][1000];
        Point santaStart = new Point(500, 500);
        Point roboSantaStart = new Point(500, 500);
        boolean santasStart = true;
        for(String s : args[0].split("|")) {
            if(santasStart)
                movePoint(santaStart, s, houseGrid);
            else
                movePoint(roboSantaStart, s, houseGrid);

            santasStart = !santasStart;
        }

        int housesWithGifts = 0;
        for(int i = 0; i < houseGrid.length; i++) {
            for (int j = 0; j < houseGrid[i].length; j++) {
                if(houseGrid[i][j] > 0)
                   housesWithGifts++;
            }
        }

        System.out.println(housesWithGifts + " houses have received presents!");
    }

    private static void movePoint(Point p, String direction, int[][] grid) {
        if (direction.equalsIgnoreCase("^"))
            p.y++;
        else if (direction.equalsIgnoreCase("v"))
            p.y--;
        else if (direction.equalsIgnoreCase(">"))
            p.x++;
        else if (direction.equalsIgnoreCase("<"))
            p.x--;

        grid[p.x][p.y]++;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
