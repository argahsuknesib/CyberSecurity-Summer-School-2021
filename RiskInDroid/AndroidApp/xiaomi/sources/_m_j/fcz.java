package _m_j;

import android.os.MemoryFile;
import java.io.FileDescriptor;
import java.lang.reflect.Method;

public final class fcz {
    public static MemoryFile O000000o(FileDescriptor fileDescriptor, int i, int i2) {
        MemoryFile memoryFile;
        try {
            memoryFile = new MemoryFile("tem", 1);
            try {
                memoryFile.close();
                Method[] declaredMethods = MemoryFile.class.getDeclaredMethods();
                Method method = null;
                int i3 = 0;
                while (declaredMethods != null && i3 < declaredMethods.length) {
                    if (declaredMethods[i3].getName().equals("native_mmap")) {
                        method = declaredMethods[i3];
                    }
                    i3++;
                }
                fdb.O000000o("android.os.MemoryFile", memoryFile, "mFD", fileDescriptor);
                fdb.O000000o("android.os.MemoryFile", memoryFile, "mLength", Integer.valueOf(i));
                fdb.O000000o("android.os.MemoryFile", memoryFile, "mAddress", fdb.O000000o(method, fileDescriptor, Integer.valueOf(i), 1));
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return memoryFile;
            }
        } catch (Exception e2) {
            e = e2;
            memoryFile = null;
            e.printStackTrace();
            return memoryFile;
        }
        return memoryFile;
    }
}
