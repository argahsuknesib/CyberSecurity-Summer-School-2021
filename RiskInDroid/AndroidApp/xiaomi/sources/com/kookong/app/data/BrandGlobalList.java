package com.kookong.app.data;

import com.kookong.app.data.BrandList;
import java.util.ArrayList;
import java.util.List;

public class BrandGlobalList implements SerializableEx {
    public List<BrandList.Brand> otherBrandList = new ArrayList();
    public List<BrandList.Brand> recommendBrandList = new ArrayList();
}
