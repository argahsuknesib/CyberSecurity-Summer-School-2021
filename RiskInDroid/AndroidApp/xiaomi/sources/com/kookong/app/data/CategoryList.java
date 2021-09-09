package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class CategoryList implements SerializableEx {
    public List<Category> list = new ArrayList();

    public static class Category implements SerializableEx {
        public short id;
        public String name = "";
    }
}
