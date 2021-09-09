package com.tiqiaa.icontrol.util;

import _m_j.bdf;
import com.imi.fastjson.serializer.SerializerFeature;

public class TQJSON {
    public static String toJSONString(Object obj) {
        if (!TiqiaaService.isTestModeEnable()) {
            return "";
        }
        return bdf.O000000o(obj, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
    }
}
