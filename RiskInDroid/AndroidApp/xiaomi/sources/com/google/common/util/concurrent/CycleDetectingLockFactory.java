package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@CanIgnoreReturnValue
@Beta
public class CycleDetectingLockFactory {
    private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks = new ThreadLocal<ArrayList<LockGraphNode>>() {
        /* class com.google.common.util.concurrent.CycleDetectingLockFactory.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final ArrayList<LockGraphNode> initialValue() {
            return Lists.newArrayListWithCapacity(3);
        }
    };
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
    public static final Logger logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    final Policy policy;

    interface CycleDetectingLock {
        LockGraphNode getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    @Beta
    public enum Policies implements Policy {
        THROW {
            public final void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN {
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
             arg types: [java.util.logging.Level, java.lang.String, com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException]
             candidates:
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
            public final void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.logger.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED {
            public final void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        }
    }

    @Beta
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    public static CycleDetectingLockFactory newInstance(Policy policy2) {
        return new CycleDetectingLockFactory(policy2);
    }

    public ReentrantLock newReentrantLock(String str) {
        return newReentrantLock(str, false);
    }

    public ReentrantLock newReentrantLock(String str, boolean z) {
        return this.policy == Policies.DISABLED ? new ReentrantLock(z) : new CycleDetectingReentrantLock(new LockGraphNode(str), z);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str) {
        return newReentrantReadWriteLock(str, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str, boolean z) {
        return this.policy == Policies.DISABLED ? new ReentrantReadWriteLock(z) : new CycleDetectingReentrantReadWriteLock(new LockGraphNode(str), z);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> cls, Policy policy2) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(policy2);
        return new WithExplicitOrdering<>(policy2, getOrCreateNodes(cls));
    }

    private static Map<? extends Enum, LockGraphNode> getOrCreateNodes(Class<? extends Enum> cls) {
        Map<? extends Enum, LockGraphNode> map = lockGraphNodesPerType.get(cls);
        if (map != null) {
            return map;
        }
        Map createNodes = createNodes(cls);
        return (Map) MoreObjects.firstNonNull(lockGraphNodesPerType.putIfAbsent(cls, createNodes), createNodes);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Class, java.lang.Class<E>] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    /* JADX WARNING: Unknown variable types count: 1 */
    @VisibleForTesting
    static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> r9) {
        EnumMap newEnumMap = Maps.newEnumMap((Class) r9);
        Enum[] enumArr = (Enum[]) r9.getEnumConstants();
        int length = enumArr.length;
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(length);
        int i = 0;
        for (Enum enumR : enumArr) {
            LockGraphNode lockGraphNode = new LockGraphNode(getLockName(enumR));
            newArrayListWithCapacity.add(lockGraphNode);
            newEnumMap.put((MMKVRecoverStrategic) enumR, (Integer) lockGraphNode);
        }
        for (int i2 = 1; i2 < length; i2++) {
            ((LockGraphNode) newArrayListWithCapacity.get(i2)).checkAcquiredLocks(Policies.THROW, newArrayListWithCapacity.subList(0, i2));
        }
        while (i < length - 1) {
            i++;
            ((LockGraphNode) newArrayListWithCapacity.get(i)).checkAcquiredLocks(Policies.DISABLED, newArrayListWithCapacity.subList(i, length));
        }
        return Collections.unmodifiableMap(newEnumMap);
    }

    private static String getLockName(Enum<?> enumR) {
        return enumR.getDeclaringClass().getSimpleName() + "." + enumR.name();
    }

    @Beta
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
        private final Map<E, LockGraphNode> lockGraphNodes;

        @VisibleForTesting
        WithExplicitOrdering(Policy policy, Map<E, LockGraphNode> map) {
            super(policy);
            this.lockGraphNodes = map;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering.newReentrantLock(java.lang.Enum, boolean):java.util.concurrent.locks.ReentrantLock
         arg types: [E, int]
         candidates:
          com.google.common.util.concurrent.CycleDetectingLockFactory.newReentrantLock(java.lang.String, boolean):java.util.concurrent.locks.ReentrantLock
          com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering.newReentrantLock(java.lang.Enum, boolean):java.util.concurrent.locks.ReentrantLock */
        public final ReentrantLock newReentrantLock(E e) {
            return newReentrantLock((Enum) e, false);
        }

        public final ReentrantLock newReentrantLock(E e, boolean z) {
            if (this.policy == Policies.DISABLED) {
                return new ReentrantLock(z);
            }
            return new CycleDetectingReentrantLock(this.lockGraphNodes.get(e), z);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering.newReentrantReadWriteLock(java.lang.Enum, boolean):java.util.concurrent.locks.ReentrantReadWriteLock
         arg types: [E, int]
         candidates:
          com.google.common.util.concurrent.CycleDetectingLockFactory.newReentrantReadWriteLock(java.lang.String, boolean):java.util.concurrent.locks.ReentrantReadWriteLock
          com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering.newReentrantReadWriteLock(java.lang.Enum, boolean):java.util.concurrent.locks.ReentrantReadWriteLock */
        public final ReentrantReadWriteLock newReentrantReadWriteLock(E e) {
            return newReentrantReadWriteLock((Enum) e, false);
        }

        public final ReentrantReadWriteLock newReentrantReadWriteLock(E e, boolean z) {
            if (this.policy == Policies.DISABLED) {
                return new ReentrantReadWriteLock(z);
            }
            return new CycleDetectingReentrantReadWriteLock(this.lockGraphNodes.get(e), z);
        }
    }

    private CycleDetectingLockFactory(Policy policy2) {
        this.policy = (Policy) Preconditions.checkNotNull(policy2);
    }

    static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());

        ExampleStackTrace(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2) {
            super(lockGraphNode.getLockName() + " -> " + lockGraphNode2.getLockName());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (i < length) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                    setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                    return;
                } else {
                    i++;
                }
            }
        }
    }

    @Beta
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        private PotentialDeadlockException(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2, ExampleStackTrace exampleStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }

        public final ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        public final String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }

    static class LockGraphNode {
        final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks = new MapMaker().weakKeys().makeMap();
        final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
        final String lockName;

        LockGraphNode(String str) {
            this.lockName = (String) Preconditions.checkNotNull(str);
        }

        /* access modifiers changed from: package-private */
        public String getLockName() {
            return this.lockName;
        }

        /* access modifiers changed from: package-private */
        public void checkAcquiredLocks(Policy policy, List<LockGraphNode> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                checkAcquiredLock(policy, list.get(i));
            }
        }

        /* access modifiers changed from: package-private */
        public void checkAcquiredLock(Policy policy, LockGraphNode lockGraphNode) {
            Preconditions.checkState(this != lockGraphNode, "Attempted to acquire multiple locks with the same rank %s", lockGraphNode.getLockName());
            if (!this.allowedPriorLocks.containsKey(lockGraphNode)) {
                PotentialDeadlockException potentialDeadlockException = this.disallowedPriorLocks.get(lockGraphNode);
                if (potentialDeadlockException != null) {
                    policy.handlePotentialDeadlock(new PotentialDeadlockException(lockGraphNode, this, potentialDeadlockException.getConflictingStackTrace()));
                    return;
                }
                ExampleStackTrace findPathTo = lockGraphNode.findPathTo(this, Sets.newIdentityHashSet());
                if (findPathTo == null) {
                    this.allowedPriorLocks.put(lockGraphNode, new ExampleStackTrace(lockGraphNode, this));
                    return;
                }
                PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(lockGraphNode, this, findPathTo);
                this.disallowedPriorLocks.put(lockGraphNode, potentialDeadlockException2);
                policy.handlePotentialDeadlock(potentialDeadlockException2);
            }
        }

        private ExampleStackTrace findPathTo(LockGraphNode lockGraphNode, Set<LockGraphNode> set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = this.allowedPriorLocks.get(lockGraphNode);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry next : this.allowedPriorLocks.entrySet()) {
                LockGraphNode lockGraphNode2 = (LockGraphNode) next.getKey();
                ExampleStackTrace findPathTo = lockGraphNode2.findPathTo(lockGraphNode, set);
                if (findPathTo != null) {
                    ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(lockGraphNode2, this);
                    exampleStackTrace2.setStackTrace(((ExampleStackTrace) next.getValue()).getStackTrace());
                    exampleStackTrace2.initCause(findPathTo);
                    return exampleStackTrace2;
                }
            }
            return null;
        }
    }

    public void aboutToAcquire(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            ArrayList arrayList = acquiredLocks.get();
            LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            lockGraphNode.checkAcquiredLocks(this.policy, arrayList);
            arrayList.add(lockGraphNode);
        }
    }

    public static void lockStateChanged(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            ArrayList arrayList = acquiredLocks.get();
            LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == lockGraphNode) {
                    arrayList.remove(size);
                    return;
                }
            }
        }
    }

    final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;

        private CycleDetectingReentrantLock(LockGraphNode lockGraphNode2, boolean z) {
            super(z);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(lockGraphNode2);
        }

        public final LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        public final boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        public final void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        public final void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        public final boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        public final boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        public final void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }
    }

    final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        private CycleDetectingReentrantReadWriteLock(LockGraphNode lockGraphNode2, boolean z) {
            super(z);
            this.readLock = new CycleDetectingReentrantReadLock(this);
            this.writeLock = new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(lockGraphNode2);
        }

        public final ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        public final ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }

        public final LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        public final boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }
    }

    class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }
    }

    class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }
    }
}
