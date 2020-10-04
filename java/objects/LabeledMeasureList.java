package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.MeasureUnit;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

public class LabeledMeasureList {

    private final MeasureUnit unit;
    private final double prefix;
    private ArrayList<LabeledMeasureListElement> values;

    public LabeledMeasureList(MeasureUnit unit) {
        this.unit = unit;
        this.prefix = 1;
        values = new ArrayList<LabeledMeasureListElement>();
    }

    public LabeledMeasureList(MeasureUnit unit, double prefix) {
        this.unit = unit;
        this.prefix = prefix;
        values = new ArrayList<LabeledMeasureListElement>();
    }

    public MeasureUnit getUnit() {
        return unit;
    }

    public double getPrefix() {
        return prefix;
    }

    public ArrayList<LabeledMeasureListElement> getValues() {
        return values;
    }

    public boolean add(LabeledMeasureListElement value) {
        return values.add(value);
    }

    public boolean add(MeasureListElement value, String name) {
        return values.add(new LabeledMeasureListElement(value, name));
    }

    public boolean add(Measure value, String name) {
        if (value.getUnit() == unit && value.getPrefix() == prefix) {
            return values.add(new LabeledMeasureListElement(new Timestamp(System.currentTimeMillis()),
                    value.getValue(), name));
        } else {
            return false;
        }
    }


    public boolean add(Timestamp timestamp, Measure value, String name) {
        if (value.getUnit() == unit && value.getPrefix() == prefix) {
            return values.add(new LabeledMeasureListElement(timestamp, value.getValue(), name));
        } else {
            return false;
        }

    }

    public boolean add(double value, String name) {
        return values.add(new LabeledMeasureListElement(new Timestamp(System.currentTimeMillis()),
                value, name));
    }

    public boolean add(Timestamp timestamp, double value, String name) {
        return values.add(new LabeledMeasureListElement(timestamp, value, name));
    }

    public boolean addInPrefix(double value, String name) {
        return values.add(new LabeledMeasureListElement(new Timestamp(System.currentTimeMillis()),
                value * prefix, name));
    }

    public boolean addInPrefix(Timestamp timestamp, double value, String name) {
        return values.add(new LabeledMeasureListElement(timestamp, value * prefix, name));
    }

    public void clear() {
        values.clear();
    }

    public void ensureCapacity(int minCapacity) {
        values.ensureCapacity(minCapacity);
    }

    public LabeledMeasureListElement get(int index) {
        return values.get(index);
    }

    public Measure getMeasure(int index) {
        return new Measure(values.get(index).getValue() / prefix, unit, prefix);
    }

    public String getName(int index) {
        return values.get(index).getName();
    }

    public double getValue(int index) {
        return values.get(index).getValue();
    }

    public double getValueInPrefix(int index) {
        return values.get(index).getValue() / prefix;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public Iterator<LabeledMeasureListElement> iterator() {
        return values.iterator();
    }

    public LabeledMeasureListElement remove(int index) {
        return values.remove(index);
    }

    public int size() {
        return values.size();
    }

    public LabeledMeasureListElement[] toArray() {
        return (LabeledMeasureListElement[]) values.toArray();
    }

    public void trimToSize() {
        values.trimToSize();
    }

}
