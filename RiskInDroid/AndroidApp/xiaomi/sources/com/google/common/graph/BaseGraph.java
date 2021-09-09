package com.google.common.graph;

import java.util.Set;

interface BaseGraph<N> extends PredecessorsFunction<N>, SuccessorsFunction<N> {

    /* renamed from: com.google.common.graph.BaseGraph$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    int degree(N n);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(N n, N n2);

    int inDegree(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<N> predecessors(Object obj);

    Set<N> successors(Object obj);
}
