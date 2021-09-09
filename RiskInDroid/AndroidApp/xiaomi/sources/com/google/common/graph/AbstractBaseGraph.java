package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;

abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors(obj);
    }

    AbstractBaseGraph() {
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        long j = 0;
        for (Object degree : nodes()) {
            j += (long) degree(degree);
        }
        Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() {
            /* class com.google.common.graph.AbstractBaseGraph.AnonymousClass1 */

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }

            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (AbstractBaseGraph.this.isDirected() != endpointPair.isOrdered() || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }
        };
    }

    public Set<EndpointPair<N>> incidentEdges(N n) {
        Preconditions.checkNotNull(n);
        Preconditions.checkArgument(nodes().contains(n), "Node %s is not an element of this graph.", n);
        return IncidentEdgeSet.of(this, n);
    }

    public int degree(N n) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((Object) n).size(), successors((Object) n).size());
        }
        Set adjacentNodes = adjacentNodes(n);
        return IntMath.saturatedAdd(adjacentNodes.size(), (!allowsSelfLoops() || !adjacentNodes.contains(n)) ? 0 : 1);
    }

    public int inDegree(N n) {
        return isDirected() ? predecessors((Object) n).size() : degree(n);
    }

    public int outDegree(N n) {
        return isDirected() ? successors((Object) n).size() : degree(n);
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        return nodes().contains(n) && successors(n).contains(n2);
    }

    static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        protected final BaseGraph<N> graph;
        protected final N node;

        public static <N> IncidentEdgeSet<N> of(BaseGraph<N> baseGraph, N n) {
            return baseGraph.isDirected() ? new Directed(baseGraph, n) : new Undirected(baseGraph, n);
        }

        private IncidentEdgeSet(BaseGraph<N> baseGraph, N n) {
            this.graph = baseGraph;
            this.node = n;
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        static final class Directed<N> extends IncidentEdgeSet<N> {
            private Directed(BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n);
            }

            public final UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors(this.node).iterator(), new Function<N, EndpointPair<N>>() {
                    /* class com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.AnonymousClass1 */

                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.ordered(n, Directed.this.node);
                    }
                }), Iterators.transform(Sets.difference(this.graph.successors(this.node), ImmutableSet.of(this.node)).iterator(), new Function<N, EndpointPair<N>>() {
                    /* class com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.AnonymousClass2 */

                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.ordered(Directed.this.node, n);
                    }
                })));
            }

            public final int size() {
                return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors(this.node).contains(this.node) ? 1 : 0);
            }

            public final boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                Object source = endpointPair.source();
                Object target = endpointPair.target();
                if (this.node.equals(source) && this.graph.successors(this.node).contains(target)) {
                    return true;
                }
                if (!this.node.equals(target) || !this.graph.predecessors(this.node).contains(source)) {
                    return false;
                }
                return true;
            }
        }

        static final class Undirected<N> extends IncidentEdgeSet<N> {
            private Undirected(BaseGraph<N> baseGraph, N n) {
                super(baseGraph, n);
            }

            public final UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function<N, EndpointPair<N>>() {
                    /* class com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.AnonymousClass1 */

                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.unordered(Undirected.this.node, n);
                    }
                }));
            }

            public final int size() {
                return this.graph.adjacentNodes(this.node).size();
            }

            public final boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                Set adjacentNodes = this.graph.adjacentNodes(this.node);
                Object nodeU = endpointPair.nodeU();
                Object nodeV = endpointPair.nodeV();
                if (this.node.equals(nodeV) && adjacentNodes.contains(nodeU)) {
                    return true;
                }
                if (!this.node.equals(nodeU) || !adjacentNodes.contains(nodeV)) {
                    return false;
                }
                return true;
            }
        }
    }
}
