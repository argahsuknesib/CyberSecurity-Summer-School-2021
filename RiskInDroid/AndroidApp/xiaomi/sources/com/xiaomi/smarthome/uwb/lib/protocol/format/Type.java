package com.xiaomi.smarthome.uwb.lib.protocol.format;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public enum Type {
    CH9329Cmd(0),
    Keyboard(1),
    KeyboardReport(2),
    Multimedia(3),
    SwitchPath(4),
    EndSession(5),
    Register_P1_1(16),
    Register_D1(17),
    Register_P1_2(18),
    Register_D3(19),
    Register_P3(20),
    Register_D4_1(21),
    Register_P4(22),
    Register_D4_2(23),
    Login_P1(32),
    Login_D1(33),
    Login_P2(34),
    Login_D2(35),
    DataStreamChunk(48),
    JSON(74),
    customize(255);
    
    private int value = 0;

    public static Type fromInteger(int i) {
        if (i == 0) {
            return CH9329Cmd;
        }
        if (i == 1) {
            return Keyboard;
        }
        if (i == 2) {
            return KeyboardReport;
        }
        if (i == 3) {
            return Multimedia;
        }
        if (i == 4) {
            return SwitchPath;
        }
        if (i == 5) {
            return EndSession;
        }
        if (i == 48) {
            return DataStreamChunk;
        }
        if (i == 74) {
            return JSON;
        }
        if (i == 255) {
            return customize;
        }
        switch (i) {
            case 16:
                return Register_P1_1;
            case 17:
                return Register_D1;
            case 18:
                return Register_P1_2;
            case 19:
                return Register_D3;
            case 20:
                return Register_P3;
            case 21:
                return Register_D4_1;
            case 22:
                return Register_P4;
            case 23:
                return Register_D4_2;
            default:
                switch (i) {
                    case 32:
                        return Login_P1;
                    case 33:
                        return Login_D1;
                    case 34:
                        return Login_P2;
                    case 35:
                        return Login_D2;
                    default:
                        return null;
                }
        }
    }

    public final void toByte(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        byteArrayOutputStream.write(getValue());
    }

    private Type(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
