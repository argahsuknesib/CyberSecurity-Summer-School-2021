package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.Map;

public class MapFieldSchemaFull implements MapFieldSchema {
    MapFieldSchemaFull() {
    }

    public Map<?, ?> forMutableMapData(Object obj) {
        return ((MapField) obj).getMutableMap();
    }

    public Map<?, ?> forMapData(Object obj) {
        return ((MapField) obj).getMap();
    }

    public boolean isImmutable(Object obj) {
        return !((MapField) obj).isMutable();
    }

    public Object toImmutable(Object obj) {
        ((MapField) obj).makeImmutable();
        return obj;
    }

    public Object newMapField(Object obj) {
        return MapField.newMapField((MapEntry) obj);
    }

    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object obj) {
        return ((MapEntry) obj).getMetadata();
    }

    public Object mergeFrom(Object obj, Object obj2) {
        return mergeFromFull(obj, obj2);
    }

    private static <K, V> Object mergeFromFull(Object obj, Object obj2) {
        MapField mapField = (MapField) obj;
        MapField mapField2 = (MapField) obj2;
        if (!mapField.isMutable()) {
            mapField.copy();
        }
        mapField.mergeFrom(mapField2);
        return mapField;
    }

    public int getSerializedSize(int i, Object obj, Object obj2) {
        return getSerializedSizeFull(i, obj, obj2);
    }

    private static <K, V> int getSerializedSizeFull(int i, Object obj, Object obj2) {
        int i2 = 0;
        if (obj == null) {
            return 0;
        }
        Map map = ((MapField) obj).getMap();
        MapEntry mapEntry = (MapEntry) obj2;
        if (map.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : map.entrySet()) {
            i2 += CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(mapEntry.getMetadata(), entry.getKey(), entry.getValue()));
        }
        return i2;
    }
}
