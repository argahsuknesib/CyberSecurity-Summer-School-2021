package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
public final class ValueGraphBuilder<N, V> extends AbstractGraphBuilder<N> {
    private <N1 extends N, V1 extends V> ValueGraphBuilder<N1, V1> cast() {
        return this;
    }

    private ValueGraphBuilder(boolean z) {
        super(z);
    }

    public static ValueGraphBuilder<Object, Object> directed() {
        return new ValueGraphBuilder<>(true);
    }

    public static ValueGraphBuilder<Object, Object> undirected() {
        return new ValueGraphBuilder<>(false);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.graph.ValueGraph<N, V>, com.google.common.graph.ValueGraph] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <N, V> ValueGraphBuilder<N, V> from(ValueGraph<N, V> r2) {
        return new ValueGraphBuilder(r2.isDirected()).allowsSelfLoops(r2.allowsSelfLoops()).nodeOrder(r2.nodeOrder());
    }

    public final ValueGraphBuilder<N, V> allowsSelfLoops(boolean z) {
        this.allowsSelfLoops = z;
        return this;
    }

    public final ValueGraphBuilder<N, V> expectedNodeCount(int i) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    public final <N1 extends N> ValueGraphBuilder<N1, V> nodeOrder(ElementOrder<N1> elementOrder) {
        ValueGraphBuilder<N1, V> cast = cast();
        cast.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    public final <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> build() {
        return new ConfigurableMutableValueGraph(this);
    }
}
