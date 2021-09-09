package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

final class SubscriberRegistry {
    private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableSet<Class<?>>>() {
        /* class com.google.common.eventbus.SubscriberRegistry.AnonymousClass2 */

        public final /* bridge */ /* synthetic */ Object load(Object obj) throws Exception {
            return load((Class<?>) ((Class) obj));
        }

        public final ImmutableSet<Class<?>> load(Class<?> cls) {
            return ImmutableSet.copyOf((Collection) TypeToken.of((Class) cls).getTypes().rawTypes());
        }
    });
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableList<Method>>() {
        /* class com.google.common.eventbus.SubscriberRegistry.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object load(Object obj) throws Exception {
            return load((Class<?>) ((Class) obj));
        }

        public final ImmutableList<Method> load(Class<?> cls) throws Exception {
            return SubscriberRegistry.getAnnotatedMethodsNotCached(cls);
        }
    });
    @Weak
    private final EventBus bus;
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers = Maps.newConcurrentMap();

    SubscriberRegistry(EventBus eventBus) {
        this.bus = (EventBus) Preconditions.checkNotNull(eventBus);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.concurrent.CopyOnWriteArraySet} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void register(Object obj) {
        for (Map.Entry next : findAllSubscribers(obj).asMap().entrySet()) {
            Class cls = (Class) next.getKey();
            Collection collection = (Collection) next.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = this.subscribers.get(cls);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
                copyOnWriteArraySet = MoreObjects.firstNonNull(this.subscribers.putIfAbsent(cls, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(collection);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0016  */
    public final void unregister(Object obj) {
        for (Map.Entry next : findAllSubscribers(obj).asMap().entrySet()) {
            Collection collection = (Collection) next.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = this.subscribers.get((Class) next.getKey());
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(collection)) {
                throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + obj + " registered?");
            }
            while (r0.hasNext()) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Set<Subscriber> getSubscribersForTesting(Class<?> cls) {
        return (Set) MoreObjects.firstNonNull(this.subscribers.get(cls), ImmutableSet.of());
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Subscriber> getSubscribers(Object obj) {
        ImmutableSet<Class<?>> flattenHierarchy = flattenHierarchy(obj.getClass());
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(flattenHierarchy.size());
        UnmodifiableIterator<Class<?>> it = flattenHierarchy.iterator();
        while (it.hasNext()) {
            CopyOnWriteArraySet copyOnWriteArraySet = this.subscribers.get(it.next());
            if (copyOnWriteArraySet != null) {
                newArrayListWithCapacity.add(copyOnWriteArraySet.iterator());
            }
        }
        return Iterators.concat(newArrayListWithCapacity.iterator());
    }

    private Multimap<Class<?>, Subscriber> findAllSubscribers(Object obj) {
        HashMultimap create = HashMultimap.create();
        UnmodifiableIterator<Method> it = getAnnotatedMethods(obj.getClass()).iterator();
        while (it.hasNext()) {
            Method next = it.next();
            create.put(next.getParameterTypes()[0], Subscriber.create(this.bus, obj, next));
        }
        return create;
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> cls) {
        return subscriberMethodsCache.getUnchecked(cls);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, int):void
     arg types: [boolean, java.lang.String, java.lang.reflect.Method, int]
     candidates:
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, int):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, int):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, int):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, int):void */
    public static ImmutableList<Method> getAnnotatedMethodsNotCached(Class<?> cls) {
        Set<Class> rawTypes = TypeToken.of((Class) cls).getTypes().rawTypes();
        HashMap newHashMap = Maps.newHashMap();
        for (Class declaredMethods : rawTypes) {
            for (Method method : declaredMethods.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    boolean z = true;
                    if (parameterTypes.length != 1) {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", (Object) method, parameterTypes.length);
                    MethodIdentifier methodIdentifier = new MethodIdentifier(method);
                    if (!newHashMap.containsKey(methodIdentifier)) {
                        newHashMap.put(methodIdentifier, method);
                    }
                }
            }
        }
        return ImmutableList.copyOf(newHashMap.values());
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> flattenHierarchy(Class<?> cls) {
        try {
            return flattenHierarchyCache.getUnchecked(cls);
        } catch (UncheckedExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    static final class MethodIdentifier {
        private final String name;
        private final List<Class<?>> parameterTypes;

        MethodIdentifier(Method method) {
            this.name = method.getName();
            this.parameterTypes = Arrays.asList(method.getParameterTypes());
        }

        public final int hashCode() {
            return Objects.hashCode(this.name, this.parameterTypes);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof MethodIdentifier) {
                MethodIdentifier methodIdentifier = (MethodIdentifier) obj;
                if (!this.name.equals(methodIdentifier.name) || !this.parameterTypes.equals(methodIdentifier.parameterTypes)) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
