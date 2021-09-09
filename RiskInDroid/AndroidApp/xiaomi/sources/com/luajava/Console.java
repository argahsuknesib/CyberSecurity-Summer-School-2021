package com.luajava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
    public static void main(String[] strArr) {
        try {
            LuaState newLuaState = LuaStateFactory.newLuaState();
            newLuaState.openLibs();
            if (strArr.length > 0) {
                int i = 0;
                while (i < strArr.length) {
                    int LloadFile = newLuaState.LloadFile(strArr[i]);
                    if (LloadFile == 0) {
                        LloadFile = newLuaState.pcall(0, 0, 0);
                    }
                    if (LloadFile == 0) {
                        i++;
                    } else {
                        throw new LuaException("Error on file: " + strArr[i] + ". " + newLuaState.toString(-1));
                    }
                }
                return;
            }
            System.out.println("API Lua Java - console mode.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("> ");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals("exit")) {
                    newLuaState.close();
                } else {
                    int LloadBuffer = newLuaState.LloadBuffer(readLine.getBytes(), "from console");
                    if (LloadBuffer == 0) {
                        LloadBuffer = newLuaState.pcall(0, 0, 0);
                    }
                    if (LloadBuffer != 0) {
                        System.err.println("Error on line: ".concat(String.valueOf(readLine)));
                        System.err.println(newLuaState.toString(-1));
                    }
                    System.out.print("> ");
                }
            }
            newLuaState.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
