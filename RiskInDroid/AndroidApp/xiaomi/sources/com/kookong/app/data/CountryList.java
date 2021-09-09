package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class CountryList implements SerializableEx {
    private static final long serialVersionUID = 6260801607149807621L;
    public List<Country> countryList = new ArrayList();

    public static class Country implements SerializableEx {
        private static final long serialVersionUID = 4571153074561468234L;
        public String countryCode = "";
        public String countryName = "";
    }
}
