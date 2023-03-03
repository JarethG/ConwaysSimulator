package com.example.sim.modal;

import android.graphics.Point;
import android.util.Pair;

import com.example.sim.ConwaysBoard;

public class Rules {
    public final int ALIVE = 1;
    public final int DEAD = 0;

    public final Rule[] ConwaysRules = {
            // The underpopulation rule
            (Pair<Point, ConwaysBoard> p) -> neighbours(p) < 2 ? DEAD : null,
            // The reproduction rule
            (Pair<Point, ConwaysBoard> p) -> neighbours(p) == 3 ? ALIVE : null,
            // The overpopulation rule
            (Pair<Point, ConwaysBoard> p) -> neighbours(p) > 3 ? DEAD : null,
    };

    public int neighbours(Pair<Point, ConwaysBoard> pair) {
        Point p = pair.first;
        ConwaysBoard board = pair.second;
        int count = 0;

        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                if (dx != 0 || dy != 0) {
                    count += getNumAlive(p.x + dx, p.y + dy, board);
                }
            }
        }

        return count;
    }

    private int getNumAlive(int x, int y, ConwaysBoard board) {
        if(!board.isValidCord(x,y)) return 0;
        return board.getCellState(x, y) == DEAD? 0:1;
    }
}
