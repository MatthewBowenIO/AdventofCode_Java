package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[][] lightGrid = new int[1000][1000];
        ArrayList<LightCommand> commands = new ArrayList<>();

	    for(String s : args) {
            Boolean onOffToggle;
            LightCommand.Point start;
            LightCommand.Point end;
            if(s.contains("turn on")) {
                onOffToggle = true;
                s = s.replace("turn on", "");
            } else if (s.contains("turn off")) {
                onOffToggle = false;
                s = s.replace("turn off", "");
            } else {
                onOffToggle = null;
                s = s.replace("toggle", "");
            }

            s = s.replace(" through ", "-");

            s = s.trim();

            start = new LightCommand.Point(Integer.parseInt(s.split("-")[0].split(",")[0]), Integer.parseInt(s.split("-")[0].split(",")[1]));
            end = new LightCommand.Point(Integer.parseInt(s.split("-")[1].split(",")[0]), Integer.parseInt(s.split("-")[1].split(",")[1]));

            commands.add(new LightCommand(onOffToggle, start, end));
        }

        for(LightCommand command : commands) {
            for(int i = command.start.x; i <= command.end.x; i++) {
                for(int j = command.start.y; j <= command.end.y; j++) {
                    if (command.onOffToggle == null)
                        lightGrid[i][j] += 2;
                    else if(command.onOffToggle)
                        lightGrid[i][j] += 1;
                    else if (!command.onOffToggle)
                        if(lightGrid[i][j] > 0)
                            lightGrid[i][j] -= 1;
                }
            }
        }

        int lightsOn = 0;
        for(int i = 0; i < lightGrid.length; i++) {
            for(int j = 0; j < lightGrid[i].length; j++) {
                lightsOn += lightGrid[i][j];
            }
        }

        System.out.println("Total power of lights: " + lightsOn);
    }
}

class LightCommand {
    Boolean onOffToggle = null; // null == toggle
    Point start = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
    Point end = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public LightCommand(Boolean onOffToggle, Point start, Point end) {
        this.onOffToggle = onOffToggle;
        this.start = start;
        this.end = end;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
