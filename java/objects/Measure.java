package com.hyperrixel.aaion.objects;

import androidx.annotation.Nullable;

import com.hyperrixel.aaion.tools.MeasureUnit;

public class Measure {

    private double value;
    private final MeasureUnit unit;
    private final double prefix;

    public Measure(double value, MeasureUnit unit) {
        this.value = value;
        this.unit = unit;
        this.prefix = 1;
    }

    public Measure(double value, MeasureUnit unit, double prefix) {
        this.value = value * prefix;
        this.unit = unit;
        this.prefix = prefix;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValueInPrefix() {
        return value / prefix;
    }

    public void setValueInPrefix(double value) {
        this.value = value * prefix;
    }

    public MeasureUnit getUnit() {
        return unit;
    }

    public double getPrefix() {
        return prefix;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Measure) {
            return (((Measure) obj).getUnit() == this.unit)
                    && (((Measure) obj).getValue() == this.value);
        } else {
            return false;
        }
    }
}
