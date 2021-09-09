package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] PRIMITIVE_TYPES = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public final JsonPrimitive deepCopy() {
        return this;
    }

    public JsonPrimitive(Boolean bool) {
        setValue(bool);
    }

    public JsonPrimitive(Number number) {
        setValue(number);
    }

    public JsonPrimitive(String str) {
        setValue(str);
    }

    public JsonPrimitive(Character ch) {
        setValue(ch);
    }

    JsonPrimitive(Object obj) {
        setValue(obj);
    }

    /* access modifiers changed from: package-private */
    public final void setValue(Object obj) {
        if (obj instanceof Character) {
            this.value = String.valueOf(((Character) obj).charValue());
            return;
        }
        C$Gson$Preconditions.checkArgument((obj instanceof Number) || isPrimitiveOrString(obj));
        this.value = obj;
    }

    public final boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    /* access modifiers changed from: package-private */
    public final Boolean getAsBooleanWrapper() {
        return (Boolean) this.value;
    }

    public final boolean getAsBoolean() {
        if (isBoolean()) {
            return getAsBooleanWrapper().booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public final boolean isNumber() {
        return this.value instanceof Number;
    }

    public final Number getAsNumber() {
        Object obj = this.value;
        return obj instanceof String ? new LazilyParsedNumber((String) obj) : (Number) obj;
    }

    public final boolean isString() {
        return this.value instanceof String;
    }

    public final String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return getAsBooleanWrapper().toString();
        }
        return (String) this.value;
    }

    public final double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public final BigDecimal getAsBigDecimal() {
        Object obj = this.value;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(obj.toString());
    }

    public final BigInteger getAsBigInteger() {
        Object obj = this.value;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        return new BigInteger(obj.toString());
    }

    public final float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    public final long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public final short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    public final int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    public final byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    public final char getAsCharacter() {
        return getAsString().charAt(0);
    }

    private static boolean isPrimitiveOrString(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> isAssignableFrom : PRIMITIVE_TYPES) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.value;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.value == null) {
            return jsonPrimitive.value == null;
        }
        if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
        }
        if (!(this.value instanceof Number) || !(jsonPrimitive.value instanceof Number)) {
            return this.value.equals(jsonPrimitive.value);
        }
        double doubleValue = getAsNumber().doubleValue();
        double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
        return doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2));
    }

    private static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.value;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
