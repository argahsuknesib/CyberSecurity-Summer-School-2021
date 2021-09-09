package com.xiaomi.smarthome.framework.plugin.rn.fixbug.image;

import _m_j.fwz;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.image.ReactImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FixReactImageManager extends ReactImageManager {
    public ReactImageView createViewInstance(ThemedReactContext themedReactContext) {
        return new FixReactImageView(themedReactContext, getDraweeControllerBuilder(), null, getCallerContext());
    }

    public void setResizeMode(ReactImageView reactImageView, String str) {
        if ((reactImageView instanceof FixReactImageView) && "stretch".equalsIgnoreCase(str)) {
            ((FixReactImageView) reactImageView).mFiltered = true;
        }
        super.setResizeMode(reactImageView, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007a  */
    public void setSource(ReactImageView reactImageView, ReadableArray readableArray) {
        HashMap<String, Object> hashMap;
        if (readableArray != null && readableArray.size() > 0 && readableArray.getType(0) == ReadableType.Map) {
            ReadableMap map = readableArray.getMap(0);
            HashMap<String, Object> hashMap2 = null;
            if (map.hasKey("uri")) {
                String string = map.getString("uri");
                if (string != null && string.startsWith("/")) {
                    hashMap = map.toHashMap();
                    hashMap.put("uri", "file://".concat(String.valueOf(string)));
                }
                if (hashMap2 != null) {
                    ArrayList<Object> arrayList = readableArray.toArrayList();
                    arrayList.remove(0);
                    arrayList.add(0, hashMap2);
                    readableArray = Arguments.makeNativeArray((List) arrayList);
                }
            } else {
                if (map.hasKey("local")) {
                    String string2 = map.getString("local");
                    hashMap = map.toHashMap();
                    hashMap.remove("local");
                    hashMap.put("uri", "file://" + new File(fwz.O000000o().O00000Oo().O000O0o.O000000o(), string2).getAbsolutePath());
                }
                if (hashMap2 != null) {
                }
            }
            hashMap2 = hashMap;
            if (hashMap2 != null) {
            }
        }
        reactImageView.setSource(readableArray);
    }
}
