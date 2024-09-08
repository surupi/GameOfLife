package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {

    @DisplayName("should initialize a new cell")
    @Test
    public void testInitializedCell() {
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    @DisplayName("UNDERPOPULATION: A live cell with fewer than two neighbours should die")
    @Test
    public void testLiveCellWithFewerThanTwoLiveNeighboursShouldDie() {
        Cell cell = new Cell(true);
        cell.update(1);
        assertFalse(cell.isAlive());
    }

    @DisplayName("SURVIVAL: A live cell with two or three live neighbors survives")
    @ParameterizedTest(name = "A live cell with {0} live neighbours should survive")
    @ValueSource(ints = {2, 3})
    public void testLiveCellWithTwoOrThreeLiveNeighboursShouldSurvive(int liveNeighbour) {
        Cell cell = new Cell(true);
        cell.update(liveNeighbour);
        assertTrue(cell.isAlive());
    }

    @DisplayName("OVERCROWDING: A live cell with more than three live neighbors dies")
    @Test
    public void testLiveCellWithMoreThanThreeLiveNeighboursShouldDie() {
        Cell cell = new Cell(true);
        cell.update(5);
        assertFalse(cell.isAlive());
    }

    @DisplayName("REPRODUCTION: A dead cell with three live neighbors should become a live cell")
    @Test
    public void testDeadCellWithThreeLiveNeighboursShouldBecomeAlive() {
        Cell cell = new Cell(false);
        cell.update(3);
        assertTrue(cell.isAlive());
    }

    @DisplayName("STASIS: A dead cell with fewer or more than three live neighbors stays dead")
    @ParameterizedTest(name = "A dead cell with {0} live neighbours should stay dead")
    @ValueSource(ints = {2, 4})
    public void testDeadCellWithNotExactlyThreeLiveNeighboursShouldStayDead(int liveNeighbour) {
        Cell cell = new Cell(false);
        cell.update(liveNeighbour);
        assertFalse(cell.isAlive());
    }

    @Test
    @DisplayName("Apply rules to a single cell and update its state based on live neighbors")
    public void testSingleCellStateUpdate() {
        // Testing live cell with fewer than 2 live neighbors (underpopulation)
        Cell cell = new Cell(true);
        cell.update(1);
        assertFalse(cell.isAlive());

        // Testing live cell with 2 or 3 live neighbors (survival)
        cell = new Cell(true);
        cell.update(2);
        assertTrue(cell.isAlive());

        cell.update(3);
        assertTrue(cell.isAlive());

        // Testing live cell with more than 3 live neighbors (overpopulation)
        cell.update(4);
        assertFalse(cell.isAlive());

        // Testing dead cell with exactly 3 live neighbors (reproduction)
        cell = new Cell(false);
        cell.update(3);
        assertTrue(cell.isAlive());
    }
}
