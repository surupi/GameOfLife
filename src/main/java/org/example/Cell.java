package org.example;

public class Cell {
    private boolean alive;

    public Cell(boolean alive){
        this.alive = alive;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void update(int liveNeighbour) {
        if (alive){
            if (liveNeighbour==2 || liveNeighbour==3){
                alive = true;
            }
            else{
                alive = false;
            }
        }

    }
}
