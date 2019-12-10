package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import sun.plugin2.message.GetAuthenticationMessage;

import java.util.Random;

public class Maze {
    Wall[][] horisontal = new Wall[80][80];
    Wall[][] vertical = new Wall[80][80];
    boolean[][] checked = new boolean[80][80];
    int[] genPos = {0,0};

    Maze(){
        for (int x = 0; x < horisontal.length; x++){
            for (int y = 0; y < horisontal[x].length; y++){
                horisontal[x][y] = new Wall(x*10,y*10,x*10, y*10 + 10);
            }
        }
        for (int x = 0; x < vertical.length; x++){
            for (int y = 0; y < vertical[x].length; y++){
                vertical[x][y] = new Wall(x*10,y*10,x*10 + 10, y*10);
            }
        }
        checked[0][0] = true;
    }
    public void generate(){
        int nrOfT = 0;
        for (int x = 0; x < vertical.length; x++){
            for (int y = 0; y < vertical[x].length; y++){
                if (checked[x][y] == false) {
                    if (x < 79) {
                        if (checked[x + 1][y] == true) {
                            nrOfT += 1;
                        }
                    }
                    if (x > 0) {
                        if (checked[x - 1][y] == true) {
                            nrOfT += 1;
                        }
                    }
                    if (y < 79) {
                        if (checked[x][y + 1] == true) {
                            nrOfT += 1;
                        }
                    }
                    if (y > 0) {
                        if (checked[x][y - 1] == true) {
                            nrOfT += 1;
                        }
                    }
                }
            }
        }
        if (nrOfT > 0) {
            int[][] positions = new int[nrOfT][2];
            int p = 0;
            for (int x = 0; x < vertical.length; x++) {
                for (int y = 0; y < vertical[x].length; y++) {
                    if (checked[x][y] == false) {
                        if (x < 79) {
                            if (checked[x + 1][y] == true) {
                                positions[p][0] = x;
                                positions[p][1] = y;
                                p += 1;
                            }
                        }
                        if (x > 0) {
                            if (checked[x - 1][y] == true) {
                                positions[p][0] = x;
                                positions[p][1] = y;
                                p += 1;
                            }
                        }
                        if (y < 79) {
                            if (checked[x][y + 1] == true) {
                                positions[p][0] = x;
                                positions[p][1] = y;
                                p += 1;
                            }
                        }
                        if (y > 0) {
                            if (checked[x][y - 1] == true) {
                                positions[p][0] = x;
                                positions[p][1] = y;
                                p += 1;
                            }
                        }
                    }
                }
            }

            Random rand = new Random();
            int r = rand.nextInt(nrOfT);
            int x = positions[r][0];
            int y = positions[r][1];
            int b = rand.nextInt(4);
            if (checked[x][y] == false && b == 0) {
                if (x < 79) {
                    if (checked[x + 1][y] == true) {
                        horisontal[x + 1][y] = new Wall(0, 0, 0, 0);
                        checked[x][y] = true;
                    }
                }
            }
            if (checked[x][y] == false && b == 1) {
                if (x > 0) {
                    if (checked[x - 1][y] == true) {
                        horisontal[x][y] = new Wall(0, 0, 0, 0);
                        checked[x][y] = true;
                    }
                }
            }
            if (checked[x][y] == false && b == 2) {
                if (y < 79) {
                    if (checked[x][y + 1] == true) {
                        vertical[x][y + 1] = new Wall(0, 0, 0, 0);
                        checked[x][y] = true;
                    }
                }
            }
            if (checked[x][y] == false && b == 3) {
                if (y > 0) {
                    if (checked[x][y - 1] == true) {
                        vertical[x][y] = new Wall(0, 0, 0, 0);
                        checked[x][y] = true;
                    }
                }
            }

        }
    }

    public void render(){
        for (int x = 0; x < horisontal.length; x++){
            for (int y = 0; y < horisontal[x].length; y++){
                horisontal[x][y].render();
                vertical[x][y].render();
            }
        }
    }
}
