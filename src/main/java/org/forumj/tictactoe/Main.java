package org.forumj.tictactoe;

import org.forumj.tictactoe.strategy.HardcodedStrategy;
import org.forumj.tictactoe.strategy.Strategy;

public class Main {

    public static void main(String[] args) {
        Strategy strategy = new HardcodedStrategy();
        Game game = new Game(strategy);
        game.run();
    }
}
