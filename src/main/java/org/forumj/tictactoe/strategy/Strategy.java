package org.forumj.tictactoe.strategy;

public interface Strategy {

    int[][] EMPTY_POSITION = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
    int[][] X_CENTER_POSITION = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
    int[][] X_NOT_CENTER_POSITION_1 = new int[][]{{1,0,0},{0,0,0},{0,0,0}};
    int[][] X_NOT_CENTER_POSITION_2 = new int[][]{{0,1,0},{0,0,0},{0,0,0}};
    int[][] X_NOT_CENTER_POSITION_3 = new int[][]{{0,0,1},{0,0,0},{0,0,0}};
    int[][] X_NOT_CENTER_POSITION_4 = new int[][]{{0,0,0},{1,0,0},{0,0,0}};
    int[][] X_NOT_CENTER_POSITION_5 = new int[][]{{0,0,0},{0,0,1},{0,0,0}};
    int[][] X_NOT_CENTER_POSITION_6 = new int[][]{{0,0,0},{0,0,0},{1,0,0}};
    int[][] X_NOT_CENTER_POSITION_7 = new int[][]{{0,0,0},{0,0,0},{0,1,0}};
    int[][] X_NOT_CENTER_POSITION_8 = new int[][]{{0,0,0},{0,0,0},{0,0,1}};


    String getMove(int[][] position, int symbol);

}
