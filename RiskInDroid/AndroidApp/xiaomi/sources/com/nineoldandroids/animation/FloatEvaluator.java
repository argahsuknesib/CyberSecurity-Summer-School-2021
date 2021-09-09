package com.nineoldandroids.animation;

public class FloatEvaluator implements TypeEvaluator<Number> {
    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f * (number2.floatValue() - floatValue)));
    }
}
