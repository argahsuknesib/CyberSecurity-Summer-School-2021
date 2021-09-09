package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
public final class GraphBuilder<N> extends AbstractGraphBuilder<N> {
    private <N1 extends N> GraphBuilder<N1> cast() {
        return this;
    }

    private GraphBuilder(boolean z) {
        super(z);
    }

    public static GraphBuilder<Object> directed() {
        return new GraphBuilder<>(true);
    }

    public static GraphBuilder<Object> undirected() {
        return new GraphBuilder<>(false);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.graph.Graph<N>, com.google.common.graph.Graph] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <N> GraphBuilder<N> from(Graph<N> r2) {
        return new GraphBuilder(r2.isDirected()).allowsSelfLoops(r2.allowsSelfLoops()).nodeOrder(r2.nodeOrder());
    }

    public final GraphBuilder<N> allowsSelfLoops(boolean z) {
        this.allowsSelfLoops = z;
        return this;
    }

    public final GraphBuilder<N> expectedNodeCount(int i) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    public final <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> elementOrder) {
        GraphBuilder<N1> cast = cast();
        cast.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    public final <N1 extends N> MutableGraph<N1> build() {
        return new ConfigurableMutableGraph(this);
    }
}
