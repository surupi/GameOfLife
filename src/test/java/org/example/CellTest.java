package org.example;

import org.example.Cell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    @DisplayName("should initialize a new cell")
    public void testInitializedCell(int liveNeighbour){
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    @DisplayName("A live cell with fewer than two neighbours should die")
    @Test
    public void testLiveCellWithFewerThanTwoLiveNeighboursShouldDie(){
        int liveNeighbour =1;
        Cell cell = new Cell(true);
        cell.update(liveNeighbour);
        assertFalse(cell.isAlive());
    }

    @DisplayName("A live cell with two or three live neighbors survives (survival)")
    @Test
    public void testLiveCellWithTwoOrThreeLiveNeighboursShouldSurvive(){
        int liveNeighbour =2;
        Cell cell = new Cell(true);
        cell.update(liveNeighbour);
        assertTrue(cell.isAlive());

        liveNeighbour =3;
        cell.update(liveNeighbour);
        assertTrue(cell.isAlive());
    }

    @DisplayName("A live cell with two or three live neighbors survives (survival)")
    @ParameterizedTest(name = "A live cell with {0} live neighbours should survive")
    @ValueSource(ints = {2,3})
    public void testLiveCellWithTwoOrThreeLiveNeighboursShouldSurvive2(int liveNeighbour){
        Cell cell = new Cell(true);
        cell.update(liveNeighbour);
        assertTrue(cell.isAlive());
    }

    @DisplayName("A live cell with more than three live neighbors dies")
    @Test
    public void testLiveCellWithMoreThanThreeLiveNeighboursShouldDie(){
        int liveNeighbour =5;
        Cell cell = new Cell(true);
        cell.update(liveNeighbour);
        assertFalse(cell.isAlive());
    }

    @DisplayName("A dead cell with three live neighbors should become a live cell")
    @Test
    public void testDeadCellWithThreeLiveNeighboursShouldLive(){
        int liveNeighbour =3;
        Cell cell = new Cell(true);
        cell.update(liveNeighbour);
        assertTrue(cell.isAlive());

        liveNeighbour =7;
        cell.update(liveNeighbour);
        assertFalse(cell.isAlive());
    }

}
