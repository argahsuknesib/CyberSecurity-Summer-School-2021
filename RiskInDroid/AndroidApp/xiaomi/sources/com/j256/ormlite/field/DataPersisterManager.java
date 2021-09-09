package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPersisterManager {
    private static final DataPersister DEFAULT_ENUM_PERSISTER = EnumStringType.getSingleton();
    private static final Map<String, DataPersister> builtInMap = new HashMap();
    private static List<DataPersister> registeredPersisters = null;

    static {
        for (DataType dataPersister : DataType.values()) {
            DataPersister dataPersister2 = dataPersister.getDataPersister();
            if (dataPersister2 != null) {
                for (Class<?> name : dataPersister2.getAssociatedClasses()) {
                    builtInMap.put(name.getName(), dataPersister2);
                }
                if (dataPersister2.getAssociatedClassNames() != null) {
                    for (String put : dataPersister2.getAssociatedClassNames()) {
                        builtInMap.put(put, dataPersister2);
                    }
                }
            }
        }
    }

    private DataPersisterManager() {
    }

    public static void registerDataPersisters(DataPersister... dataPersisterArr) {
        ArrayList arrayList = new ArrayList();
        List<DataPersister> list = registeredPersisters;
        if (list != null) {
            arrayList.addAll(list);
        }
        for (DataPersister add : dataPersisterArr) {
            arrayList.add(add);
        }
        registeredPersisters = arrayList;
    }

    public static void clear() {
        registeredPersisters = null;
    }

    public static DataPersister lookupForField(Field field) {
        List<DataPersister> list = registeredPersisters;
        if (list != null) {
            for (DataPersister next : list) {
                if (next.isValidForField(field)) {
                    return next;
                }
                Class<?>[] associatedClasses = next.getAssociatedClasses();
                int length = associatedClasses.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (field.getType() == associatedClasses[i]) {
                            return next;
                        }
                        i++;
                    }
                }
            }
        }
        DataPersister dataPersister = builtInMap.get(field.getType().getName());
        if (dataPersister != null) {
            return dataPersister;
        }
        if (field.getType().isEnum()) {
            return DEFAULT_ENUM_PERSISTER;
        }
        return null;
    }
}
