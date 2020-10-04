package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.MeasureUnit;

public class Duration {

    public final static int SECOND = 1;
    public final static int MINUTE = 60;
    public final static int HOUR = 3600;
    public final static int DAY = 86400;

    private final double duration;
    private final int unit;

    public Duration(double duration) {
        this.unit = Duration.SECOND;
        this.duration = duration * this.unit;
    }

    public Duration(double duration, int unit) {
        this.unit = unit;
        this.duration = duration * this.unit;
    }

    public double getDuration() {
        return duration;
    }

    public int getUnit() {
        return unit;
    }

    public Measure toMeasure() {
        return new Measure(duration, MeasureUnit.SECOND);
    }
}
