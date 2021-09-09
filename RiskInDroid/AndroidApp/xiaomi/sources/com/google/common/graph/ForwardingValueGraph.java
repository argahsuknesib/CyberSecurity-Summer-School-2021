package com.google.common.graph;

import java.util.Optional;
import java.util.Set;

abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    /* access modifiers changed from: protected */
    public abstract ValueGraph<N, V> delegate();

    ForwardingValueGraph() {
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public Set<N> adjacentNodes(N n) {
        return delegate().adjacentNodes(n);
    }

    public Set<N> predecessors(N n) {
        return delegate().predecessors((Object) n);
    }

    public Set<N> successors(N n) {
        return delegate().successors((Object) n);
    }

    public int degree(N n) {
        return delegate().degree(n);
    }

    public int inDegree(N n) {
        return delegate().inDegree(n);
    }

    public int outDegree(N n) {
        return delegate().outDegree(n);
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        return delegate().hasEdgeConnecting(n, n2);
    }

    public Optional<V> edgeValue(N n, N n2) {
        return delegate().edgeValue(n, n2);
    }

    public V edgeValueOrDefault(N n, N n2, V v) {
        return delegate().edgeValueOrDefault(n, n2, v);
    }
}
