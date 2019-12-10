package com.mygdx.game;

public class Wall {
    private int x1, y1, x2, y2;
    Wall(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void render(){
        Window.sr.line(x1, y1, x2, y2);
    }

}
