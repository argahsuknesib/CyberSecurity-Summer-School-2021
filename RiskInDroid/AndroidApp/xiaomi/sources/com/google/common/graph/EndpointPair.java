package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;

@Immutable(containerOf = {"N"})
@Beta
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public abstract N source();

    public abstract N target();

    private EndpointPair(N n, N n2) {
        this.nodeU = Preconditions.checkNotNull(n);
        this.nodeV = Preconditions.checkNotNull(n2);
    }

    public static <N> EndpointPair<N> ordered(N n, N n2) {
        return new Ordered(n, n2);
    }

    public static <N> EndpointPair<N> unordered(N n, N n2) {
        return new Unordered(n2, n);
    }

    static <N> EndpointPair<N> of(Graph<?> graph, Object obj, Object obj2) {
        return graph.isDirected() ? ordered(obj, obj2) : unordered(obj, obj2);
    }

    static <N> EndpointPair<N> of(Network<?, ?> network, Object obj, Object obj2) {
        return network.isDirected() ? ordered(obj, obj2) : unordered(obj, obj2);
    }

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public final N adjacentNode(Object obj) {
        if (obj.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (obj.equals(this.nodeV)) {
            return this.nodeU;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + obj);
    }

    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    static final class Ordered<N> extends EndpointPair<N> {
        public final boolean isOrdered() {
            return true;
        }

        public final /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        private Ordered(N n, N n2) {
            super(n, n2);
        }

        public final N source() {
            return nodeU();
        }

        public final N target() {
            return nodeV();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            return isOrdered() == endpointPair.isOrdered() && source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        public final int hashCode() {
            return Objects.hashCode(source(), target());
        }

        public final String toString() {
            return "<" + source() + " -> " + target() + ">";
        }
    }

    static final class Unordered<N> extends EndpointPair<N> {
        public final boolean isOrdered() {
            return false;
        }

        public final /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        private Unordered(N n, N n2) {
            super(n, n2);
        }

        public final N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public final N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            return nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        public final int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        public final String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }
    }
}
