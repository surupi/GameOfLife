# About the repository:

This repository contains an implementation of Conway's Game of Life, a classic cellular automaton. The implementation follows Test-Driven Development (TDD) principles to ensure the reliability and correctness of the code.


## Conway's Game of Life:

Conway's Game of Life is a zero-player game that simulates the evolution of a grid of cells. Each cell can be in one of two states: alive or dead. The game progresses through discrete time steps according to a set of rules that determine the state of each cell based on its neighbors. The rules are as follows:

1. **Underpopulation**: A live cell with fewer than two live neighbors dies.
2. **Survival**: A live cell with two or three live neighbors lives on to the next generation.
3. **Overpopulation**: A live cell with more than three live neighbors dies.
4. **Reproduction**: A dead cell with exactly three live neighbors becomes a live cell.


## Test-Driven Development (TDD):

This project utilizes Test-Driven Development (TDD) to ensure that the implementation is both correct and maintainable. TDD is a software development process where tests are written before the code that needs to be implemented. The process follows these steps:

1. **Write a Test**: Define a test that specifies a small piece of functionality.
2. **Run the Test**: Execute the test to see it fail (since the functionality isn't implemented yet).
3. **Write the Code**: Implement the functionality to make the test pass.
4. **Refactor**: Clean up the code while keeping all tests green (passing).
5. **Repeat**: Continue with the next piece of functionality.

In this repository, tests are used to validate the behavior of the Game of Life's rules and ensure the correctness of the states. The grid evolves with each iteration based on these rules, creating complex patterns and behaviors.
