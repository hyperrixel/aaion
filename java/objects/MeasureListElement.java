package com.hyperrixel.aaion.objects;

import java.sql.Timestamp;

public class MeasureListElement {

    private final Timestamp timestamp;
    private final double value;

    public MeasureListElement(Timestamp timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

}
