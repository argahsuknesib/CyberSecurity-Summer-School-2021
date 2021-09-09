package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Beta
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors(obj);
    }

    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    public Graph<N> asGraph() {
        return new AbstractGraph<N>() {
            /* class com.google.common.graph.AbstractValueGraph.AnonymousClass1 */

            public Set<N> nodes() {
                return AbstractValueGraph.this.nodes();
            }

            public Set<EndpointPair<N>> edges() {
                return AbstractValueGraph.this.edges();
            }

            public boolean isDirected() {
                return AbstractValueGraph.this.isDirected();
            }

            public boolean allowsSelfLoops() {
                return AbstractValueGraph.this.allowsSelfLoops();
            }

            public ElementOrder<N> nodeOrder() {
                return AbstractValueGraph.this.nodeOrder();
            }

            public Set<N> adjacentNodes(N n) {
                return AbstractValueGraph.this.adjacentNodes(n);
            }

            public Set<N> predecessors(N n) {
                return AbstractValueGraph.this.predecessors((Object) n);
            }

            public Set<N> successors(N n) {
                return AbstractValueGraph.this.successors((Object) n);
            }

            public int degree(N n) {
                return AbstractValueGraph.this.degree(n);
            }

            public int inDegree(N n) {
                return AbstractValueGraph.this.inDegree(n);
            }

            public int outDegree(N n) {
                return AbstractValueGraph.this.outDegree(n);
            }
        };
    }

    public Optional<V> edgeValue(N n, N n2) {
        return Optional.ofNullable(edgeValueOrDefault(n, n2, null));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        return isDirected() == valueGraph.isDirected() && nodes().equals(valueGraph.nodes()) && edgeValueMap(this).equals(edgeValueMap(valueGraph));
    }

    public final int hashCode() {
        return edgeValueMap(this).hashCode();
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeValueMap(this);
    }

    private static <N, V> Map<EndpointPair<N>, V> edgeValueMap(final ValueGraph<N, V> valueGraph) {
        return Maps.asMap(valueGraph.edges(), new Function<EndpointPair<N>, V>() {
            /* class com.google.common.graph.AbstractValueGraph.AnonymousClass2 */

            public final V apply(EndpointPair<N> endpointPair) {
                return valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            }
        });
    }
}
