package com.hyperrixel.aaion.objects;

import java.sql.Timestamp;

public class LabeledMeasureListElement extends MeasureListElement {

    private final String name;

    public LabeledMeasureListElement(Timestamp timestamp, double value) {
        super(timestamp, value);
        this.name = "";
    }

    public LabeledMeasureListElement(Timestamp timestamp, double value, String name) {
        super(timestamp, value);
        this.name = name;
    }

    public LabeledMeasureListElement(MeasureListElement value, String name) {
        super(value.getTimestamp(), value.getValue());
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
