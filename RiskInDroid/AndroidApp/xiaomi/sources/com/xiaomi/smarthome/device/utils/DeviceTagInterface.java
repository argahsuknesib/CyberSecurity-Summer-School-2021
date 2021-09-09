package com.xiaomi.smarthome.device.utils;

import com.xiaomi.smarthome.device.Device;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DeviceTagInterface<T> {

    public static class Category implements Serializable {
        public String id;
        public String name;
        public String parentId;
        public int rank;
    }

    List<String> O000000o(int i, String str);

    List<String> O000000o(Device device);

    Map<String, Set<String>> O000000o(int i);

    Set<String> O000000o(String str, String str2);

    void O000000o(String str);

    void O000000o(List<Device> list);

    void O000000o(Map<String, Device> map);

    boolean O000000o();

    String O00000Oo(String str);

    String O00000Oo(String str, String str2);

    List<String> O00000Oo();

    void O00000Oo(List<T> list);

    Category O00000o(String str);

    void O00000o();

    Category O00000o0(String str);

    void O00000o0();

    List<Category> O00000oO(String str);

    void O00000oO();

    String O00000oo(String str);

    void O00000oo();

    Set<Integer> O0000O0o();

    Set<String> O0000O0o(String str);

    Category O0000OOo(String str);

    Map<String, Set<String>> O0000OOo();

    String O0000Oo();

    Map<String, List<String>> O0000Oo(String str);

    Category O0000Oo0(String str);

    void O0000Oo0();

    String O0000OoO(String str);
}
