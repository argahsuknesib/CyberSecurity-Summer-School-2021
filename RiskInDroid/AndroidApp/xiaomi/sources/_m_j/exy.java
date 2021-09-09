package _m_j;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.LinkedList;
import java.util.List;

public final class exy implements MemoryTrimmableRegistry {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<MemoryTrimmable> f15940O000000o = new LinkedList();

    public final synchronized void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
        this.f15940O000000o.add(memoryTrimmable);
    }

    public final synchronized void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
        this.f15940O000000o.remove(memoryTrimmable);
    }

    public final synchronized void O000000o(MemoryTrimType memoryTrimType) {
        for (MemoryTrimmable trim : this.f15940O000000o) {
            trim.trim(memoryTrimType);
        }
    }
}
