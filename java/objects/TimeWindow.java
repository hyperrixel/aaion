package com.hyperrixel.aaion.objects;

import java.sql.Timestamp;

public abstract class TimeWindow {

    protected Timestamp from;
    protected Timestamp to;

    public Timestamp getFrom() {
        return from;
    }

    public Timestamp getTo() {
        return to;
    }

    public long getDuration() {
        return Functions.millisToSeconds(to.getTime()) - Functions.millisToSeconds(from.getTime());
    }

    public boolean isAt(Timestamp timestamp) {
        return timestamp.getTime() > from.getTime() && timestamp.getTime() < to.getTime();
    }

    public boolean isNow() {
        long now = System.currentTimeMillis();
        return now > from.getTime() && now < to.getTime();
    }

}
