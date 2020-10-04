package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.ConverterFunction;
import com.hyperrixel.aaion.tools.MeasureUnit;

public class AlteredMeasure extends Measure {

    private final ConverterFunction converterFunction;

    public AlteredMeasure(double value, MeasureUnit unit) {
        super(value, unit);
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

    public AlteredMeasure(double value, MeasureUnit unit, double prefix) {
        super(value, unit, prefix);
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

    public AlteredMeasure(double value, MeasureUnit unit, ConverterFunction converterFunction) {
        super(converterFunction.toValue(value), unit, converterFunction.toValue(1));
        this.converterFunction = converterFunction;
    }

    public AlteredMeasure(double value, MeasureUnit unit, double prefix,
                          ConverterFunction converterFunction) {
        super(converterFunction.toValue(value), unit, converterFunction.toValue(prefix));
        this.converterFunction = converterFunction;
    }

    public void setValueInAltered(double value) {
        super.setValue(converterFunction.toValue(value));
    }

    public void setValueInPrefixInAltered(double value) {
        super.setValue(converterFunction.toValue(value) * super.getPrefix());
    }

    public double getValueInAltered() {
        return converterFunction.fromValue(super.getValue());
    }

    public double getValueInPrefixInAltered() {
        return converterFunction.fromValue(super.getValueInPrefix());
    }

    public double getPrefixInAltered() {
        return converterFunction.fromValue(super.getPrefix());
    }

}
