package com.example.sim;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.sim.modal.Simulation;


public class GameView extends View {


    public int steps=0;
    public int counter=0;
    private Handler handler;
    private Runnable runnable;
    private ConwaysBoard board;
    private Simulation sim;
    Paint paint = new Paint();


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        handler = new Handler();
        board = new ConwaysBoard();
        sim = new Simulation(board);
        runnable = () -> invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int a = event.getActionMasked();
        switch(a) {
            case MotionEvent.ACTION_DOWN: {
                board.boardPressed(event);
            }
        }
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        board.draw(canvas,paint);
        handler.postDelayed(runnable, 100);

        if(steps>0) {
            counter ++;
            if (counter == 2) {
                counter = 0;
                sim.step();
                steps--;
                System.out.println("step taken");
            }
        }
    }

    public void setSteps(int i){
        steps = i;
    }
}
