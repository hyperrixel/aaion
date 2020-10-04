package com.hyperrixel.aaion.objects;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Day extends TimeWindow {

    public final static int DURATION = 86400;

    public Day() {
        Calendar today = new GregorianCalendar();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        long longToday = Functions.millisToSeconds(today.getTimeInMillis());
        this.from = new Timestamp(longToday);
        this.to = new Timestamp(longToday + Day.DURATION);
    }

    public Day(Timestamp from) {
        this.from = from;
        this.to = new Timestamp((Functions.millisToSeconds(this.from.getTime())) + Day.DURATION);
    }

    public Day(String timezone) {
        Calendar day = new GregorianCalendar(TimeZone.getTimeZone(timezone));
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        long longDay = Functions.millisToSeconds(day.getTimeInMillis());
        this.from = new Timestamp(longDay);
        this.to = new Timestamp(longDay + Day.DURATION);
    }

    public static Day fromNow() {
        return new Day(new Timestamp(Functions.millisToSeconds(System.currentTimeMillis())));
    }

    public static Day midnightUT() {
        return new Day("UTC");
    }

}
