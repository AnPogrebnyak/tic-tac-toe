package org.forumj.tictactoe;

import org.forumj.tictactoe.strategy.Strategy;

import java.util.Scanner;

public class Game {

    private int[][] position = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private Scanner scanner = new Scanner(System.in);

    private Strategy strategy;

    public Game(Strategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        while (true) {
            draw();
            String userMove = getUserMove();
            if (isMovePossible(userMove)) {
                //TODO Hardcoded
                changePosition(userMove, 1);
                if (whoWon() == 0 && hasMoreMoves()) {
                    String computerMove = getComputerMove();
                    //TODO Hardcoded
                    changePosition(computerMove, -1);
                    if (whoWon() == 0 && hasMoreMoves()) {
                        continue;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                System.out.printf("Your move %s is inpossible%n", userMove);
                continue;
            }
        }
        System.out.println();
        draw();
        switch (whoWon()) {
            case 1:
                System.out.println("You won");
                break;
            case -1:
                System.out.println("You lost");
                break;
            case 0:
                System.out.println("Game over");
                break;
        }
        scanner.close();
    }

    private void draw() {
        for (int rowIndex = 0; rowIndex < position.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < position[rowIndex].length; columnIndex++) {
                switch (position[rowIndex][columnIndex]) {
                    case 0:
                        if (rowIndex != position.length - 1) {
                            System.out.print("_");
                        } else {
                            System.out.print(" ");
                        }
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case -1:
                        System.out.print("O");
                        break;
                }
                if (columnIndex != position[rowIndex].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getUserMove() {
//        return strategy.getMove(position, 1);
        System.out.println("Make your move, please.");
        String move = scanner.nextLine();
        return move;
    }

    private String getComputerMove() {
        return strategy.getMove(position, -1);
    }

    private boolean isMovePossible(String move) {
        try {
            int row = Integer.valueOf(move.substring(0, 1));
            int column = Integer.valueOf(move.substring(1));
            return position[row][column] == 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void changePosition(String move, int symbol) {
        int row = Integer.valueOf(move.substring(0, 1));
        int column = Integer.valueOf(move.substring(1));
        position[row][column] = symbol;
    }

    private int whoWon() {
        int symbol;
        boolean result;
        for (int rowIndex = 0; rowIndex < position.length; rowIndex++) {
            symbol = position[rowIndex][0];
            result = true;
            for (int columnIndex = 1; columnIndex < position[rowIndex].length; columnIndex++) {
                if (!(result = symbol == position[rowIndex][columnIndex])) break;
            }
            if (result) {
                return symbol;
            }

        }
        for (int columnIndex = 0; columnIndex < position[0].length; columnIndex++) {
            symbol = position[0][columnIndex];
            result = true;
            for (int rowIndex = 1; rowIndex < position.length; rowIndex++) {
                if (!(result = symbol == position[rowIndex][columnIndex])) break;
            }
            if (result) {
                return symbol;
            }

        }
        symbol = position[0][0];
        result = true;
        for (int index = 0; index < position.length; index++) {
            if (!(result = symbol == position[index][index])) break;
        }
        if (result) {
            return symbol;
        }
        symbol = position[position.length - 1][0];
        result = true;
        for (int index = 0; index < position.length; index++) {
            if (!(result = symbol == position[position.length - 1 - index][index])) break;
        }
        if (result) {
            return symbol;
        }
        return 0;
    }

    private boolean hasMoreMoves() {
        for (int rowIndex = 0; rowIndex < position.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < position[rowIndex].length; columnIndex++) {
                if (position[rowIndex][columnIndex] == 0) return true;
            }
        }
        return false;
    }
}
