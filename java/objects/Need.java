package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.MeasureUnit;

public class Need {

    protected String name;
    protected MeasureUnit unit;
    protected double prefix;
    protected Measure measureNow;
    protected LabeledMeasureList measureHistory;

    public Need(String name, MeasureUnit unit) {
        this.name = name;
        this.unit = unit;
        this.prefix = 1;
        measureHistory = new LabeledMeasureList(this.unit, this.prefix);
    }

    public Need(String name, Measure measure) {
        this.name = name;
        this.unit = measure.getUnit();
        this.prefix = measure.getPrefix();
        measureHistory = new LabeledMeasureList(this.unit, this.prefix);
        measureHistory.add(measure, "initial value");
    }

    public String getName() {
        return name;
    }

}
