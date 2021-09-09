package com.mobikwik.sdk.lib;

import com.mobikwik.sdk.lib.utils.Utils;
import java.io.Serializable;

public class User implements Serializable {
    private String authToken;
    private String cell;
    private String email;

    public User(String str, String str2) {
        this.email = str;
        this.cell = str2;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public String getCell() {
        return this.cell;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isCellValid() {
        return Utils.isValidMobile(this.cell);
    }

    public boolean isEmailValid() {
        return Utils.isValidEmail(this.email);
    }

    public boolean isValid() {
        return isEmailValid() && isCellValid();
    }

    public void setAuthToken(String str) {
        this.authToken = str;
    }

    public void setCell(String str) {
        this.cell = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }
}
