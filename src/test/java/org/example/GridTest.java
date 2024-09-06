package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    @DisplayName("Initialize a grid with all dead cells and confirm its dimensions and state ")
    public void initializeGridTest() {
        Grid grid = new Grid(5, 5);

        assertEquals(5, grid.getRows());
        assertEquals(5, grid.getCols());

        for(int row=0; row<grid.getRows(); row++){
            for(int col=0;col<grid.getCols();col++){
                assertFalse(grid.getCellSate(row, col));
            }
        }
    }

    @Test
    @DisplayName("Should set and retrieve the state of a specific cell in a grid")
    public void testSetGridStatus() {
        Grid grid = new Grid(5,5);
        grid.setCellState(3,4, true);
        assertTrue(grid.getCellSate(3, 4));
    }

    @DisplayName("Should set and retrieve the state of a specific cell in the grid")
    @ParameterizedTest(name="Should set and retrieve the state of a specific cell in the grid")
    @CsvSource(
            {
                    "5, 5",
                    "0, 0",
            }
    )
    public void testSetGridCellState(int row, int col){
        Grid grid = new Grid(5,5);
        grid.setCellState(3,4, true);
        assertTrue(grid.getCellSate(3, 4));
    }

}
