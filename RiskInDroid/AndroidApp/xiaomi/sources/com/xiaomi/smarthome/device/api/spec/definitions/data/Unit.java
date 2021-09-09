package com.xiaomi.smarthome.device.api.spec.definitions.data;

@Deprecated
public enum Unit {
    Lux("lux"),
    Undefined("undefined"),
    Arcdegrees("arcdegrees"),
    Percentage("percentage"),
    Celsius("celsius"),
    Kelvin("kelvin"),
    Watt("watt"),
    MeterPerSecond("MeterPerSecond"),
    KmPerHour("KmPerHour"),
    StepPerSecond("StepPerSecond"),
    Meter("Meter"),
    Cal("Cal"),
    Seconds("Seconds"),
    Minutes("Minutes"),
    Hours("Hours"),
    Days("Days"),
    Rgb("rgb"),
    Pascal("Pascal");
    
    private String string;

    private Unit(String str) {
        this.string = str;
    }

    public static Unit from(String str) {
        for (Unit unit : values()) {
            if (unit.toString().equalsIgnoreCase(str)) {
                return unit;
            }
        }
        return Undefined;
    }

    public final String toString() {
        return this.string;
    }
}
