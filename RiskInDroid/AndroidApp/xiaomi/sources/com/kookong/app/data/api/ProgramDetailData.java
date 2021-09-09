package com.kookong.app.data.api;

import com.kookong.app.data.SerializableEx;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class ProgramDetailData implements SerializableEx {
    private static final long serialVersionUID = -2105076275779533457L;
    public List<String> actor = new ArrayList();
    public String desc;
    public List<String> director = new ArrayList();
    public List<String> guest = new ArrayList();
    public List<String> host = new ArrayList();
    public String name;
    public String pic;
    public String vpic;
}
