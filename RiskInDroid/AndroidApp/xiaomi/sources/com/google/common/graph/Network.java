package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Optional;
import java.util.Set;

@Beta
public interface Network<N, E> extends PredecessorsFunction<N>, SuccessorsFunction<N> {

    /* renamed from: com.google.common.graph.Network$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Set<E> adjacentEdges(E e);

    Set<N> adjacentNodes(N n);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n);

    Optional<E> edgeConnecting(N n, N n2);

    E edgeConnectingOrNull(N n, N n2);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(N n, N n2);

    boolean equals(Object obj);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    Set<E> inEdges(N n);

    Set<E> incidentEdges(N n);

    EndpointPair<N> incidentNodes(E e);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<E> outEdges(N n);

    Set<N> predecessors(Object obj);

    Set<N> successors(Object obj);
}
