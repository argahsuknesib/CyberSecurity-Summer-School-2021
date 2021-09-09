package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;

@Beta
public interface Graph<N> extends BaseGraph<N> {

    /* renamed from: com.google.common.graph.Graph$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    int degree(N n);

    Set<EndpointPair<N>> edges();

    boolean equals(Object obj);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<N> predecessors(Object obj);

    Set<N> successors(Object obj);
}
