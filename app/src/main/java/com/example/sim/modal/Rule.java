package com.example.sim.modal;

import android.graphics.Point;
import com.example.sim.ConwaysBoard;
import android.util.Pair;

import java.util.function.Function;
public interface Rule extends Function<Pair<Point, ConwaysBoard>,Integer> {
	//functionality is provided by the java.util.Function interface.
}
