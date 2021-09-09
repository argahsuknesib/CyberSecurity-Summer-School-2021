package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

@Immutable(containerOf = {"N", "E"})
@Beta
public final class ImmutableNetwork<N, E> extends ConfigurableNetwork<N, E> {
    public final /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public final /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    public final /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    public final /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    public final /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    public final /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    public final /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    public final /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
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

    public final /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    public final /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public final /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.from(network), getNodeConnections(network), getEdgeToReferenceNode(network));
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        return network instanceof ImmutableNetwork ? (ImmutableNetwork) network : new ImmutableNetwork<>(network);
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }

    public final ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : network.nodes()) {
            builder.put(next, connectionsOf(network, next));
        }
        return builder.build();
    }

    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (E next : network.edges()) {
            builder.put(next, network.incidentNodes(next).nodeU());
        }
        return builder.build();
    }

    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> network, N n) {
        if (network.isDirected()) {
            Map<K, V> asMap = Maps.asMap(network.inEdges(n), sourceNodeFn(network));
            Map<K, V> asMap2 = Maps.asMap(network.outEdges(n), targetNodeFn(network));
            int size = network.edgesConnecting(n, n).size();
            if (network.allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.ofImmutable(asMap, asMap2, size);
            }
            return DirectedNetworkConnections.ofImmutable(asMap, asMap2, size);
        }
        Map<K, V> asMap3 = Maps.asMap(network.incidentEdges(n), adjacentNodeFn(network, n));
        if (network.allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.ofImmutable(asMap3);
        }
        return UndirectedNetworkConnections.ofImmutable(asMap3);
    }

    private static <N, E> Function<E, N> sourceNodeFn(final Network<N, E> network) {
        return new Function<E, N>() {
            /* class com.google.common.graph.ImmutableNetwork.AnonymousClass1 */

            public final N apply(E e) {
                return network.incidentNodes(e).source();
            }
        };
    }

    private static <N, E> Function<E, N> targetNodeFn(final Network<N, E> network) {
        return new Function<E, N>() {
            /* class com.google.common.graph.ImmutableNetwork.AnonymousClass2 */

            public final N apply(E e) {
                return network.incidentNodes(e).target();
            }
        };
    }

    private static <N, E> Function<E, N> adjacentNodeFn(final Network<N, E> network, final N n) {
        return new Function<E, N>() {
            /* class com.google.common.graph.ImmutableNetwork.AnonymousClass3 */

            public final N apply(E e) {
                return network.incidentNodes(e).adjacentNode(n);
            }
        };
    }
}
