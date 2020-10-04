package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.MeasureUnit;

public class LabeledMeasure extends Measure{

    private final String name;

    public LabeledMeasure(double value, MeasureUnit unit) {
        super(value, unit);
        this.name = "";
    }

    public LabeledMeasure(double value, MeasureUnit unit, double prefix) {
        super(value, unit, prefix);
        this.name = "";
    }

    public LabeledMeasure(double value, MeasureUnit unit, String name) {
        super(value, unit);
        this.name = name;
    }

    public LabeledMeasure(double value, MeasureUnit unit, double prefix, String name) {
        super(value, unit, prefix);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
