package com.chad.library.adapter.base.entity;

import java.io.Serializable;

public abstract class SectionEntity<T> implements Serializable {
    public String header;
    public boolean isHeader;
    public T t = null;

    public SectionEntity(boolean z, String str) {
        this.isHeader = z;
        this.header = str;
    }
}
