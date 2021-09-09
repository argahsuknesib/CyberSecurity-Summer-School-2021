package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;

@Immutable(containerOf = {"N", "V"})
@Beta
public final class ImmutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> {
    public final /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public final /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    public final /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    public final /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    public final /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    public final /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    public final /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public final /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    private ImmutableValueGraph(ValueGraph<N, V> valueGraph) {
        super(ValueGraphBuilder.from(valueGraph), getNodeConnections(valueGraph), (long) valueGraph.edges().size());
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof ImmutableValueGraph ? (ImmutableValueGraph) valueGraph : new ImmutableValueGraph<>(valueGraph);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(immutableValueGraph);
    }

    public final ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> valueGraph) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : valueGraph.nodes()) {
            builder.put(next, connectionsOf(valueGraph, next));
        }
        return builder.build();
    }

    private static <N, V> GraphConnections<N, V> connectionsOf(final ValueGraph<N, V> valueGraph, final N n) {
        AnonymousClass1 r0 = new Function<N, V>() {
            /* class com.google.common.graph.ImmutableValueGraph.AnonymousClass1 */

            public final V apply(N n) {
                return valueGraph.edgeValueOrDefault(n, n, null);
            }
        };
        if (valueGraph.isDirected()) {
            return DirectedGraphConnections.ofImmutable(valueGraph.predecessors((Object) n), Maps.asMap(valueGraph.successors((Object) n), r0));
        }
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(valueGraph.adjacentNodes(n), r0));
    }
}
