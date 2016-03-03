package com.company;

public class Main {
    public static void main(String[] args) {
        int paperToOrder = 0;
        int ribbonToOrder = 0;
        for(String s : args) {
            String[] dimens = s.split("x");
            Present p = new Present(Integer.parseInt(dimens[1]), Integer.parseInt(dimens[2]), Integer.parseInt(dimens[0]));
            paperToOrder += p.calculateSurfaceArea();
            ribbonToOrder += p.caluclateRibbonLength();
        }

        System.out.println("Total square feet of paper to order: " + paperToOrder);
        System.out.println("Total feet of ribbon to order: " + ribbonToOrder);
    }
}

class Present {
    private int width;
    private int height;
    private int length;

    public Present(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int calculateSurfaceArea() {
        int[] sides = {(2 * length * width), (2 * width * height), (2 * height * length) };
        int smallestSide = 100000;
        for(int i : sides) {
            if(smallestSide > i) {
                smallestSide = i;
            }
        }

        return smallestSide / 2 + (sides[0] + sides[1] + sides[2]);
    }

    public int caluclateRibbonLength() {
        int sa = Integer.MAX_VALUE;
        int sb = Integer.MAX_VALUE;

        int[] dimens = new int[] { width, height, length };
        for(int value : dimens) {
            if(value < sa) {
                sb = sa;
                sa = value;
            } else if (value < sb) {
                sb = value;
            }
        }
        return (sa * 2 + sb * 2) + (width * height * length);
    }
}
