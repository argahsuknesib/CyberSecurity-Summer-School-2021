package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
    boolean allowsParallelEdges = false;
    ElementOrder<? super E> edgeOrder = ElementOrder.insertion();
    Optional<Integer> expectedEdgeCount = Optional.absent();

    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
        return this;
    }

    private NetworkBuilder(boolean z) {
        super(z);
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.graph.Network<N, E>, com.google.common.graph.Network] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> r2) {
        return new NetworkBuilder(r2.isDirected()).allowsParallelEdges(r2.allowsParallelEdges()).allowsSelfLoops(r2.allowsSelfLoops()).nodeOrder(r2.nodeOrder()).edgeOrder(r2.edgeOrder());
    }

    public final NetworkBuilder<N, E> allowsParallelEdges(boolean z) {
        this.allowsParallelEdges = z;
        return this;
    }

    public final NetworkBuilder<N, E> allowsSelfLoops(boolean z) {
        this.allowsSelfLoops = z;
        return this;
    }

    public final NetworkBuilder<N, E> expectedNodeCount(int i) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    public final NetworkBuilder<N, E> expectedEdgeCount(int i) {
        this.expectedEdgeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    public final <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> elementOrder) {
        NetworkBuilder<N1, E> cast = cast();
        cast.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    public final <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> elementOrder) {
        NetworkBuilder<N, E1> cast = cast();
        cast.edgeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    public final <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new ConfigurableMutableNetwork(this);
    }
}
