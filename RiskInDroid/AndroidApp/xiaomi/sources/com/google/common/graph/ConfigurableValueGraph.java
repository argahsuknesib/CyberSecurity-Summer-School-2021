package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    protected long edgeCount;
    private final boolean isDirected;
    protected final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or((Object) 10).intValue()), 0);
    }

    ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j) {
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = abstractGraphBuilder.nodeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeCount = Graphs.checkNonNegative(j);
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public Set<N> adjacentNodes(N n) {
        return checkedConnections(n).adjacentNodes();
    }

    public Set<N> predecessors(N n) {
        return checkedConnections(n).predecessors();
    }

    public Set<N> successors(N n) {
        return checkedConnections(n).successors();
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        GraphConnections graphConnections = this.nodeConnections.get(n);
        return graphConnections != null && graphConnections.successors().contains(n2);
    }

    public V edgeValueOrDefault(N n, N n2, V v) {
        V v2;
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        GraphConnections graphConnections = this.nodeConnections.get(n);
        if (graphConnections == null) {
            v2 = null;
        } else {
            v2 = graphConnections.value(n2);
        }
        return v2 == null ? v : v2;
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        return this.edgeCount;
    }

    /* access modifiers changed from: protected */
    public final GraphConnections<N, V> checkedConnections(N n) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n);
        throw new IllegalArgumentException("Node " + ((Object) n) + " is not an element of this graph.");
    }

    /* access modifiers changed from: protected */
    public final boolean containsNode(N n) {
        return this.nodeConnections.containsKey(n);
    }
}
