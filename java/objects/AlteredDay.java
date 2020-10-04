package com.hyperrixel.aaion.objects;

import com.hyperrixel.aaion.tools.ConverterFunction;

import java.sql.Timestamp;

public class AlteredDay extends Day {

    private final ConverterFunction converterFunction;

    public AlteredDay() {
        super();
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
        this.to = new Timestamp(Functions.millisToSeconds(this.from.getTime()) + (long) converterFunction.fromValue(Day.DURATION));
    }

    public AlteredDay(Timestamp from) {
        super(from);
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
        this.to = new Timestamp(Functions.millisToSeconds(this.from.getTime()) + (long) converterFunction.fromValue(Day.DURATION));
    }

    public AlteredDay(String timezone) {
        super(timezone);
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
        this.to = new Timestamp(Functions.millisToSeconds(this.from.getTime()) + (long) converterFunction.fromValue(Day.DURATION));
    }

    public AlteredDay(ConverterFunction converterFunction) {
        super();
        this.converterFunction = converterFunction;
        this.to = new Timestamp(Functions.millisToSeconds(this.from.getTime()) + (long) converterFunction.toValue(Day.DURATION));
    }

    public AlteredDay(Timestamp from, ConverterFunction converterFunction) {
        super(from);
        this.converterFunction = converterFunction;
        this.to = new Timestamp(Functions.millisToSeconds(this.from.getTime()) + (long) converterFunction.toValue(Day.DURATION));
    }

    public AlteredDay(String timezone, ConverterFunction converterFunction) {
        super(timezone);
        this.converterFunction = converterFunction;
        this.to = new Timestamp(Functions.millisToSeconds(this.from.getTime()) + (long) converterFunction.toValue(Day.DURATION));
    }

}
