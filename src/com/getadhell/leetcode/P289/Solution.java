package com.getadhell.leetcode.P289;

/**
 * https://leetcode.com/problems/game-of-life/description/
 */
public class Solution {
    private static final int DEAD = 0;
    private static final int ALIVE = 1;
    private static final int TO_DIE = 2;
    private static final int TO_BORN = 3;

    private static boolean isNeighbour(int cell) {
        return cell == ALIVE
                || cell == TO_DIE;
    }

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int neighbors = 0;
                if (i > 0 && j > 0 && isNeighbour(board[i - 1][j - 1])) {
                    neighbors++;
                }
                if (i > 0 && isNeighbour(board[i - 1][j])) {
                    neighbors++;
                }
                if (i > 0 && j + 1 < board[i].length && isNeighbour(board[i - 1][j + 1])) {
                    neighbors++;
                }
                if (j > 0 && isNeighbour(board[i][j - 1])) {
                    neighbors++;
                }
                if (j + 1 < board[i].length && isNeighbour(board[i][j + 1])) {
                    neighbors++;
                }
                if (i + 1 < board.length && j > 0 && isNeighbour(board[i + 1][j - 1])) {
                    neighbors++;
                }
                if (i + 1 < board.length && isNeighbour(board[i + 1][j])) {
                    neighbors++;
                }
                if (i + 1 < board.length && j + 1 < board[i + 1].length && isNeighbour(board[i + 1][j + 1])) {
                    neighbors++;
                }
                if (board[i][j] == DEAD) {
                    if (neighbors == 3) {
                        // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                        board[i][j] = TO_BORN;
                    }
                } else if (board[i][j] == ALIVE) {
                    if (neighbors < 2) {
                        // Any live cell with fewer than two live neighbors dies, as if caused by under-population.
                        board[i][j] = TO_DIE;
                    } else if (neighbors == 2 || neighbors == 3) {
                        // Any live cell with two or three live neighbors lives on to the next generation.
                        board[i][j] = ALIVE;
                    } else {
                        // Any live cell with more than three live neighbors dies, as if by over-population.
                        board[i][j] = TO_DIE;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == TO_DIE) {
                    board[i][j] = DEAD;
                } else if (board[i][j] == TO_BORN) {
                    board[i][j] = ALIVE;
                }
            }
        }
    }
}
