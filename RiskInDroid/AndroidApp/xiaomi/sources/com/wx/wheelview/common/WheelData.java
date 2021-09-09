package com.wx.wheelview.common;

import java.io.Serializable;

public class WheelData implements Serializable {
    private static final long serialVersionUID = 1;
    public int id;
    public String name;

    public String toString() {
        return "WheelData{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}
