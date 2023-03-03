package com.example.sim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import java.util.Arrays;

public class ConwaysBoard {

    public static int size = Constants.SCREEN_WIDTH / 20 * Constants.SCREEN_WIDTH / 1080;
    private int[] cells;
    private final int width= 20;
    private final int height= 20;


    public ConwaysBoard() {
        this.cells = new int[width * height];
        Arrays.fill(cells, 0);
    }

    public void boardPressed(MotionEvent e) {
        int x = (int) e.getX() / size;
        int y = (int) e.getY() / size;
        if (isValidCord(x, y)) {
            int state = getCellState(x, y);
            state = (state + 1) % 2;
            setCellState(x, y, state);
        }
    }

    public int getCellState(int x, int y) {
        return cells[(y * width) + x];
    }

    public void setCellState(int x, int y, int state) {
      if (state !=0 && state!=1) {
            throw new IllegalArgumentException("invalid cell state: " + state);
      }
        cells[(y * width) + x] = state;
    }

    public void setCells(int[]cells){
        this.cells = cells;
    }

    public boolean isValidCord(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (getCellState(x, y) != 0) {
                    paint.setStyle(Paint.Style.STROKE);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                }
                canvas.drawRect(x * size, y * size, x * size + size, y * size + size, paint);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
