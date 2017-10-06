package org.forumj.tictactoe.strategy;

import java.util.Arrays;
import java.util.Random;

public class HardcodedStrategy implements Strategy {

    Random random = new Random(System.currentTimeMillis());

    @Override
    public String getMove(int[][] position, int symbol) {
        int x, y;
        //Winner move
        String move = getFinalMove(position, -symbol);
        if (move != null){
            return move;
        }
        //Prevent lost
        move = getFinalMove(position, symbol);
        if (move != null){
            return move;
        }
        if (symbol == -1){ // for O
            if (Arrays.deepEquals(position, EMPTY_POSITION)) {
                throw new RuntimeException("X moves first");
            }else if (Arrays.deepEquals(position, X_CENTER_POSITION)){
                switch (random.nextInt(4)){
                    case 0:
                        return "00";
                    case 1:
                        return "02";
                    case 2:
                        return "20";
                    default:
                        return "22";
                }
            }else if (position[1][1] == 1){ // X in center
                if (position[0][0] == 0 || position[0][2] == 0 || position[2][0] == 0 || position[2][2] == 0){
                    do{
                        switch (random.nextInt(4)){
                            case 0:
                                x = 0;
                                y = 0;
                                break;
                            case 1:
                                x = 2;
                                y = 0;
                                break;
                            case 2:
                                x = 0;
                                y = 2;
                                break;
                            default:
                                x = 2;
                                y = 2;
                                break;
                        }
                    }while(position[y][x] != 0);
                    return "" + y + x;
                }else{
                    return getRandomMove(position);
                }
            }else if (
                    Arrays.deepEquals(position, X_NOT_CENTER_POSITION_1)
                    || Arrays.deepEquals(position, X_NOT_CENTER_POSITION_2)
                    || Arrays.deepEquals(position, X_NOT_CENTER_POSITION_3)
                    || Arrays.deepEquals(position, X_NOT_CENTER_POSITION_4)
                    || Arrays.deepEquals(position, X_NOT_CENTER_POSITION_5)
                    || Arrays.deepEquals(position, X_NOT_CENTER_POSITION_6)
                    || Arrays.deepEquals(position, X_NOT_CENTER_POSITION_7)
                    || Arrays.deepEquals(position, X_NOT_CENTER_POSITION_8)
                    ){
                return "11";
            }else if (position[1][1] == -1){ // O in center
                if (whichMove(position) == 2){
                    if (position[0][0] == 1 && position[2][2] == 0) {
                        return "22";
                    }else if (position[0][2] == 1 && position[2][0] == 0){
                        return "20";
                    }else if (position[2][2] == 1 && position[0][0] == 0){
                        return "00";
                    }else if (position[2][0] == 1 && position[0][2] == 0){
                        return "02";
                    }else if (position[1][0] == 1 && position[0][1] == 1){
                        return "00";
                    }else if (position[1][2] == 1 && position[0][1] == 1){
                        return "02";
                    }else if (position[1][2] == 1 && position[2][1] == 1){
                        return "22";
                    }else if (position[1][0] == 1 && position[2][1] == 1){
                        return "20";
                    }else if (position[1][0] == 1 && position[1][2] == 1
                            || position[0][1] == 1 && position[2][1] == 1
                            ){
                        do{
                            switch (random.nextInt(4)){
                                case 0:
                                    y = 0;
                                    x = 0;
                                    break;
                                case 1:
                                    y = 0;
                                    x = 2;
                                    break;
                                case 2:
                                    y = 2;
                                    x = 0;
                                    break;
                                default:
                                    y = 2;
                                    x = 2;
                                    break;
                            }
                        }while(position[y][x] != 0);
                        return "" + y + x;
                    }else{
                        do{
                            switch (random.nextInt(4)){
                                case 0:
                                    y = 0;
                                    x = 1;
                                    break;
                                case 1:
                                    y = 1;
                                    x = 0;
                                    break;
                                case 2:
                                    y = 1;
                                    x = 2;
                                    break;
                                default:
                                    y = 2;
                                    x = 1;
                                    break;
                            }
                        }while(position[y][x] != 0);
                        return "" + y + x;
                    }
                }
                return getRandomMove(position);
            } else {
                return getRandomMove(position);
            }
        }else{ // for X
            if (Arrays.deepEquals(position, EMPTY_POSITION)) {
                return "11";
            }else if (whichMove(position) == 1){
                if (position[0][1] == -1) {
                    switch (random.nextInt(2)) {
                        case 0:
                            return "20";
                        default:
                            return "22";
                    }
                }else if (position[1][2] == -1) {
                    switch (random.nextInt(2)) {
                        case 0:
                            return "00";
                        default:
                            return "20";
                    }
                }else if (position[2][1] == -1) {
                    switch (random.nextInt(2)) {
                        case 0:
                            return "00";
                        default:
                            return "02";
                    }
                }else if (position[1][0] == -1) {
                    switch (random.nextInt(2)) {
                        case 0:
                            return "02";
                        default:
                            return "22";
                    }
                }else if (position[0][0] == -1) {
                    return "22";
                }else if (position[0][2] == -1) {
                    return "20";
                }else if (position[2][2] == -1) {
                    return "00";
                }else if (position[2][0] == -1) {
                    return "02";
                }
                return getRandomMove(position);
            }else if (whichMove(position) == 2){
                if (position[0][1] == -1 && position[2][0] == -1 && position[2][2] == 0) {
                    return "22";
                }else if(position[1][2] == -1 && position[0][0] == -1 && position[2][0] == 0){
                    return "20";
                }else if(position[2][1] == -1 && position[0][2] == -1 && position[0][0] == 0){
                    return "00";
                }else if(position[1][0] == -1 && position[2][2] == -1 && position[0][2] == 0){
                    return "02";
                }
                return getRandomMove(position);
            }else{
                return getRandomMove(position);
            }

        }
    }

    private String getRandomMove(int[][] position) {
        int x, y;
        do {
            //TODO Hardcoded
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (position[y][x] != 0);
        System.out.println("Random move generated.");
        return "" + y + x;
    }

    private String getFinalMove(int[][] position, int symbol){
        symbol = -symbol;
        for (int rotation = 0; rotation < 4; rotation++){
            if (position[0][0] == symbol){
                if (position[0][1] == symbol && position[0][2] == 0){
                    switch (rotation){
                        case 0:
                            return "02";
                        case 1:
                            return "00";
                        case 2:
                            return "20";
                        case 3:
                            return "22";
                    }
                }else if (position[0][2] == symbol && position[0][1] == 0){
                    switch (rotation){
                        case 0:
                            return "01";
                        case 1:
                            return "10";
                        case 2:
                            return "21";
                        case 3:
                            return "12";
                    }
                }else if (position[1][1] == symbol && position[2][2] == 0){
                    switch (rotation){
                        case 0:
                            return "22";
                        case 1:
                            return "02";
                        case 2:
                            return "00";
                        case 3:
                            return "20";
                    }
                }else if (position[1][0] == symbol && position[2][0] == 0){
                    switch (rotation){
                        case 0:
                            return "20";
                        case 1:
                            return "22";
                        case 2:
                            return "02";
                        case 3:
                            return "00";
                    }
                }else if (position[2][0] == symbol && position[1][0] == 0){
                    switch (rotation){
                        case 0:
                            return "10";
                        case 1:
                            return "21";
                        case 2:
                            return "12";
                        case 3:
                            return "01";
                    }
                }
            }
            if (position[0][1] == symbol){
                if (position[0][2] == symbol && position[0][0] == 0){
                    switch (rotation){
                        case 0:
                            return "00";
                        case 1:
                            return "20";
                        case 2:
                            return "22";
                        case 3:
                            return "02";
                    }
                }else if (position[1][1] == symbol && position[2][1] == 0){
                    switch (rotation){
                        case 0:
                            return "21";
                        case 1:
                            return "12";
                        case 2:
                            return "01";
                        case 3:
                            return "10";
                    }
                }
            }
            position = rotateClockwise(position);
        }
        return null;
    }

    int whichMove(int[][] position){
        int result = 0;
        for (int rowIndex = 0; rowIndex < position.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < position[rowIndex].length; columnIndex++) {
                if (position[rowIndex][columnIndex] > 0){
                    result++;
                }
            }
        }
        return result;
    }

    int[][] rotateClockwise(int[][] position){
        //TODO Hardcoded
        int[][] result = new int[3][3];
        for (int rowIndex = 0; rowIndex < result.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < result[rowIndex].length; columnIndex++) {
                //TODO Hardcoded
                result[rowIndex][columnIndex] = position[2 - columnIndex][rowIndex];
            }
        }
        return result;
    }

}
