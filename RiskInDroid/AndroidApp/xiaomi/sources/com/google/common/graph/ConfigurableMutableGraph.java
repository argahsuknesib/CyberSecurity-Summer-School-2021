package com.google.common.graph;

import com.google.common.graph.GraphConstants;

final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    ConfigurableMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new ConfigurableMutableValueGraph(abstractGraphBuilder);
    }

    /* access modifiers changed from: protected */
    public final BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    public final boolean addNode(N n) {
        return this.backingValueGraph.addNode(n);
    }

    public final boolean putEdge(N n, N n2) {
        return this.backingValueGraph.putEdgeValue(n, n2, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    public final boolean removeNode(N n) {
        return this.backingValueGraph.removeNode(n);
    }

    public final boolean removeEdge(N n, N n2) {
        return this.backingValueGraph.removeEdge(n, n2) != null;
    }
}
