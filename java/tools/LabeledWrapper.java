package com.hyperrixel.aaion.tools;

public class LabeledWrapper {

    private final String name;
    private final Object object;

    public LabeledWrapper(String name, Object object) {
        this.name = name;
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public Object getObject() {
        return object;
    }

}
