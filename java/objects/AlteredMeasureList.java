package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.ConverterFunction;
import com.hyperrixel.aaion.tools.MeasureUnit;

import java.sql.Timestamp;
import java.util.ArrayList;

public class AlteredMeasureList extends MeasureList {

    private final ConverterFunction converterFunction;

    public AlteredMeasureList(MeasureUnit unit) {
        super(unit);
        this.converterFunction = new ConverterFunction() {
            @Override
            public double fromValue(double value) {
                return value;
            }

            @Override
            public double toValue(double value) {
                return value;
            }
        };
    }

    public AlteredMeasureList(MeasureUnit unit, double prefix) {
        super(unit, prefix);
        this.converterFunction = new ConverterFunction() {
            @Override
            public double fromValue(double value) {
                return value;
            }

            @Override
            public double toValue(double value) {
                return value;
            }
        };
    }

    public AlteredMeasureList(MeasureUnit unit, ConverterFunction converterFunction) {
        super(unit, converterFunction.toValue(1));
        this.converterFunction = converterFunction;
    }

    public AlteredMeasureList(MeasureUnit unit, double prefix, ConverterFunction converterFunction) {
        super(unit, converterFunction.toValue(prefix));
        this.converterFunction = converterFunction;
    }

    @Override
    public boolean add(MeasureListElement value) {
        return super.add(new MeasureListElement(value.getTimestamp(),
                converterFunction.toValue(value.getValue())));
    }

    public boolean add(AlteredMeasure value) {
        if (value.getUnit() == super.getUnit() && value.getPrefix() == super.getPrefix()) {
            return super.add((Measure) value);
        } else {
            return false;
        }
    }

    public boolean add(Timestamp timestamp, AlteredMeasure value) {
        if (value.getUnit() == super.getUnit() && value.getPrefix() == super.getPrefix()) {
            return super.add(timestamp, (Measure) value);
        } else {
            return false;
        }
    }

    @Override
    public boolean add(double value) {
        return super.add(converterFunction.toValue(value));
    }

    @Override
    public boolean add(Timestamp timestamp, double value) {
        return super.add(timestamp, converterFunction.toValue(value));
    }

    public ArrayList<MeasureListElement> getValuesInAltered() {
        ArrayList<MeasureListElement> tempvar = new ArrayList<MeasureListElement>();
        for (MeasureListElement element: super.getValues()) {
            tempvar.add(new MeasureListElement(element.getTimestamp(),
                    converterFunction.fromValue(element.getValue())));
        }
        return tempvar;
    }

    public MeasureListElement getInAltered(int index) {
        return new MeasureListElement(super.get(index).getTimestamp(),
                converterFunction.fromValue(super.get(index).getValue()));
    }

}
