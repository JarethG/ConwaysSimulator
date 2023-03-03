package com.example.sim.modal;

import android.graphics.Point;

import com.example.sim.ConwaysBoard;
import android.util.Pair;


public class Simulation {
	private ConwaysBoard board;
	private Rule[] rules;

	public Simulation(ConwaysBoard board) {
		this.board = board;
		this.rules = new Rules().ConwaysRules;
	}
	public void step() {
		int width = board.getWidth();
		int height = board.getHeight();
		int[] step = new int[width * height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				step[(y*width)+x] = board.getCellState(x, y);
				for (Rule r : rules) {
					Integer result = r.apply(new Pair<>(new Point(x,y), board));
					if (result != null) {
						step[(y * width) + x] = result;
						break;
					}
				}
			}
		}

		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				board.setCellState(x, y, step[(y * width) + x]);
			}
		}
	}
}
