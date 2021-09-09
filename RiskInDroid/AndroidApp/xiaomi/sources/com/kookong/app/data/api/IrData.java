package com.kookong.app.data.api;

import com.kookong.app.data.SerializableEx;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public class IrData implements SerializableEx {
    private static final long serialVersionUID = 5244091589017648716L;
    public HashMap<Integer, String> exts;
    public int fre;
    public ArrayList<IrKey> keys;
    public int rid;
    public short type;

    public static class IrKey implements SerializableEx {
        private static final long serialVersionUID = -1748063511403053081L;
        public HashMap<Integer, String> exts;
        public int fid;
        public String fkey;
        public String fname;
        public String pulse;
    }
}
