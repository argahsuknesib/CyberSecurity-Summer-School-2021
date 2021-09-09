package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private final Map<N, V> adjacentNodeValues;

    private UndirectedGraphConnections(Map<N, V> map) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
    }

    static <N, V> UndirectedGraphConnections<N, V> of() {
        return new UndirectedGraphConnections<>(new HashMap(2, 1.0f));
    }

    static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> map) {
        return new UndirectedGraphConnections<>(ImmutableMap.copyOf(map));
    }

    public final Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    public final Set<N> predecessors() {
        return adjacentNodes();
    }

    public final Set<N> successors() {
        return adjacentNodes();
    }

    public final V value(N n) {
        return this.adjacentNodeValues.get(n);
    }

    public final void removePredecessor(N n) {
        removeSuccessor(n);
    }

    public final V removeSuccessor(N n) {
        return this.adjacentNodeValues.remove(n);
    }

    public final void addPredecessor(N n, V v) {
        addSuccessor(n, v);
    }

    public final V addSuccessor(N n, V v) {
        return this.adjacentNodeValues.put(n, v);
    }
}
