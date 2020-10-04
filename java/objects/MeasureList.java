package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.MeasureUnit;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

public class MeasureList {

    private final MeasureUnit unit;
    private final double prefix;
    private ArrayList<MeasureListElement> values;

    public MeasureList(MeasureUnit unit) {
        this.unit = unit;
        this.prefix = 1;
        values = new ArrayList<MeasureListElement>();
    }

    public MeasureList(MeasureUnit unit, double prefix) {
        this.unit = unit;
        this.prefix = prefix;
        values = new ArrayList<MeasureListElement>();
    }

    public MeasureUnit getUnit() {
        return unit;
    }

    public double getPrefix() {
        return prefix;
    }

    public ArrayList<MeasureListElement> getValues() {
        return values;
    }

    public boolean add(MeasureListElement value) {
        return values.add(value);
    }

    public boolean add(Measure value) {
        if (value.getUnit() == unit && value.getPrefix() == prefix) {
            return values.add(new MeasureListElement(new Timestamp(System.currentTimeMillis()),
                    value.getValue()));
        } else {
            return false;
        }
    }


    public boolean add(Timestamp timestamp, Measure value) {
        if (value.getUnit() == unit && value.getPrefix() == prefix) {
            return values.add(new MeasureListElement(timestamp, value.getValue()));
        } else {
            return false;
        }

    }

    public boolean add(double value) {
        return values.add(new MeasureListElement(new Timestamp(System.currentTimeMillis()), value));
    }

    public boolean add(Timestamp timestamp, double value) {
        return values.add(new MeasureListElement(timestamp, value));
    }

    public boolean addInPrefix(double value) {
        return values.add(new MeasureListElement(new Timestamp(System.currentTimeMillis()), value * prefix));
    }

    public boolean addInPrefix(Timestamp timestamp, double value) {
        return values.add(new MeasureListElement(timestamp, value * prefix));
    }

    public void clear() {
        values.clear();
    }

    public void ensureCapacity(int minCapacity) {
        values.ensureCapacity(minCapacity);
    }

    public MeasureListElement get(int index) {
        return values.get(index);
    }

    public Measure getMeasure(int index) {
        return new Measure(values.get(index).getValue() / prefix, unit, prefix);
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

    public Iterator<MeasureListElement> iterator() {
        return values.iterator();
    }

    public MeasureListElement remove(int index) {
        return values.remove(index);
    }

    public int size() {
        return values.size();
    }

    public MeasureListElement[] toArray() {
        return (MeasureListElement[]) values.toArray();
    }

    public void trimToSize() {
        values.trimToSize();
    }

}
