package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    @LazyInit
    private transient Reference<Multiset<N>> adjacentNodesReference;

    private UndirectedMultiNetworkConnections(Map<E, N> map) {
        super(map);
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> of() {
        return new UndirectedMultiNetworkConnections<>(new HashMap(2, 1.0f));
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> map) {
        return new UndirectedMultiNetworkConnections<>(ImmutableMap.copyOf(map));
    }

    public final Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
    }

    public final Multiset<N> adjacentNodesMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset create = HashMultiset.create(this.incidentEdgeMap.values());
        this.adjacentNodesReference = new SoftReference(create);
        return create;
    }

    public final Set<E> edgesConnecting(final N n) {
        return new MultiEdgesConnecting<E>(this.incidentEdgeMap, n) {
            /* class com.google.common.graph.UndirectedMultiNetworkConnections.AnonymousClass1 */

            public int size() {
                return UndirectedMultiNetworkConnections.this.adjacentNodesMultiset().count(n);
            }
        };
    }

    public final N removeInEdge(E e, boolean z) {
        if (!z) {
            return removeOutEdge(e);
        }
        return null;
    }

    public final N removeOutEdge(E e) {
        N removeOutEdge = super.removeOutEdge(e);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeOutEdge));
        }
        return removeOutEdge;
    }

    public final void addInEdge(E e, N n, boolean z) {
        if (!z) {
            addOutEdge(e, n);
        }
    }

    public final void addOutEdge(E e, N n) {
        super.addOutEdge(e, n);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n));
        }
    }

    private static <T> T getReference(Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }
}
