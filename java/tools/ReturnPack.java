package com.hyperrixel.aaion.tools;

public class ReturnPack {

    public static final int REAL = 0;
    public static final int NORM = 1;
    public static final int ADD_AS_REAL = 2;
    public static final int ADD_AS_NORM = 3;
    public static final int SUBTRACT_AS_REAL = 4;
    public static final int SUBTRACT_AS_NORM = 5;
    public static final int MULTIPLY_AS_REAL = 8;
    public static final int MULTIPLY_AS_NORM = 9;
    public static final int DIVIDE_AS_REAL = 16;
    public static final int DIVIDE_AS_NORM = 17;

    private final Object content;
    private final int handleType;

    ReturnPack(Object content, int handleType) {
        this.content = content;
        this.handleType = handleType;
    }

    public Object getContent() {
        return content;
    }

    public int getHandleType() {
        return handleType;
    }

}
