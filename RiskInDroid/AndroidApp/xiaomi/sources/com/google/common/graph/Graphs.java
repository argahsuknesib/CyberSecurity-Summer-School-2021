package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Beta
public final class Graphs {

    enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    private Graphs() {
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        for (N subgraphHasCycle : graph.nodes()) {
            if (subgraphHasCycle(graph, newHashMapWithExpectedSize, subgraphHasCycle, null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    private static <N> boolean subgraphHasCycle(Graph<N> graph, Map<Object, NodeVisitState> map, N n, N n2) {
        NodeVisitState nodeVisitState = map.get(n);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        if (nodeVisitState == NodeVisitState.PENDING) {
            return true;
        }
        map.put(n, NodeVisitState.PENDING);
        for (N next : graph.successors((Object) n)) {
            if (canTraverseWithoutReusingEdge(graph, next, n2) && subgraphHasCycle(graph, map, next, n)) {
                return true;
            }
        }
        map.put(n, NodeVisitState.COMPLETE);
        return false;
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> graph, Object obj, Object obj2) {
        return graph.isDirected() || !Objects.equal(obj2, obj);
    }

    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        MutableGraph<N1> build = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N next : graph.nodes()) {
                for (N putEdge : reachableNodes(graph, next)) {
                    build.putEdge(next, putEdge);
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N next2 : graph.nodes()) {
                if (!hashSet.contains(next2)) {
                    Set<N> reachableNodes = reachableNodes(graph, next2);
                    hashSet.addAll(reachableNodes);
                    int i = 1;
                    for (N next3 : reachableNodes) {
                        int i2 = i + 1;
                        for (T putEdge2 : Iterables.limit(reachableNodes, i)) {
                            build.putEdge(next3, putEdge2);
                        }
                        i = i2;
                    }
                }
            }
        }
        return build;
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N n) {
        Preconditions.checkArgument(graph.nodes().contains(n), "Node %s is not an element of this graph.", n);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque();
        linkedHashSet.add(n);
        arrayDeque.add(n);
        while (!arrayDeque.isEmpty()) {
            for (N next : graph.successors(arrayDeque.remove())) {
                if (linkedHashSet.add(next)) {
                    arrayDeque.add(next);
                }
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        if (!graph.isDirected()) {
            return graph;
        }
        if (graph instanceof TransposedGraph) {
            return ((TransposedGraph) graph).graph;
        }
        return new TransposedGraph(graph);
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.isDirected()) {
            return valueGraph;
        }
        if (valueGraph instanceof TransposedValueGraph) {
            return ((TransposedValueGraph) valueGraph).graph;
        }
        return new TransposedValueGraph(valueGraph);
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof TransposedNetwork) {
            return ((TransposedNetwork) network).network;
        }
        return new TransposedNetwork(network);
    }

    static class TransposedGraph<N> extends ForwardingGraph<N> {
        public final Graph<N> graph;

        TransposedGraph(Graph<N> graph2) {
            this.graph = graph2;
        }

        /* access modifiers changed from: protected */
        public Graph<N> delegate() {
            return this.graph;
        }

        public Set<N> predecessors(N n) {
            return delegate().successors((Object) n);
        }

        public Set<N> successors(N n) {
            return delegate().predecessors((Object) n);
        }

        public int inDegree(N n) {
            return delegate().outDegree(n);
        }

        public int outDegree(N n) {
            return delegate().inDegree(n);
        }

        public boolean hasEdgeConnecting(N n, N n2) {
            return delegate().hasEdgeConnecting(n2, n);
        }
    }

    static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        public final ValueGraph<N, V> graph;

        TransposedValueGraph(ValueGraph<N, V> valueGraph) {
            this.graph = valueGraph;
        }

        /* access modifiers changed from: protected */
        public ValueGraph<N, V> delegate() {
            return this.graph;
        }

        public Set<N> predecessors(N n) {
            return delegate().successors((Object) n);
        }

        public Set<N> successors(N n) {
            return delegate().predecessors((Object) n);
        }

        public int inDegree(N n) {
            return delegate().outDegree(n);
        }

        public int outDegree(N n) {
            return delegate().inDegree(n);
        }

        public boolean hasEdgeConnecting(N n, N n2) {
            return delegate().hasEdgeConnecting(n2, n);
        }

        public Optional<V> edgeValue(N n, N n2) {
            return delegate().edgeValue(n2, n);
        }

        public V edgeValueOrDefault(N n, N n2, V v) {
            return delegate().edgeValueOrDefault(n2, n, v);
        }
    }

    static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        public final Network<N, E> network;

        TransposedNetwork(Network<N, E> network2) {
            this.network = network2;
        }

        /* access modifiers changed from: protected */
        public Network<N, E> delegate() {
            return this.network;
        }

        public Set<N> predecessors(N n) {
            return delegate().successors((Object) n);
        }

        public Set<N> successors(N n) {
            return delegate().predecessors((Object) n);
        }

        public int inDegree(N n) {
            return delegate().outDegree(n);
        }

        public int outDegree(N n) {
            return delegate().inDegree(n);
        }

        public Set<E> inEdges(N n) {
            return delegate().outEdges(n);
        }

        public Set<E> outEdges(N n) {
            return delegate().inEdges(n);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.graph.EndpointPair.of(com.google.common.graph.Network<?, ?>, java.lang.Object, java.lang.Object):com.google.common.graph.EndpointPair<N>
         arg types: [com.google.common.graph.Network<N, E>, java.lang.Object, java.lang.Object]
         candidates:
          com.google.common.graph.EndpointPair.of(com.google.common.graph.Graph<?>, java.lang.Object, java.lang.Object):com.google.common.graph.EndpointPair<N>
          com.google.common.graph.EndpointPair.of(com.google.common.graph.Network<?, ?>, java.lang.Object, java.lang.Object):com.google.common.graph.EndpointPair<N> */
        public EndpointPair<N> incidentNodes(E e) {
            EndpointPair incidentNodes = delegate().incidentNodes(e);
            return EndpointPair.of((Network<?, ?>) this.network, incidentNodes.nodeV(), incidentNodes.nodeU());
        }

        public Set<E> edgesConnecting(N n, N n2) {
            return delegate().edgesConnecting(n2, n);
        }

        public Optional<E> edgeConnecting(N n, N n2) {
            return delegate().edgeConnecting(n2, n);
        }

        public E edgeConnectingOrNull(N n, N n2) {
            return delegate().edgeConnectingOrNull(n2, n);
        }

        public boolean hasEdgeConnecting(N n, N n2) {
            return delegate().hasEdgeConnecting(n2, n);
        }
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.common.graph.Graph<N>, com.google.common.graph.Graph] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <N> com.google.common.graph.MutableGraph<N> inducedSubgraph(com.google.common.graph.Graph<N> r5, java.lang.Iterable<? extends N> r6) {
        /*
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0018
            com.google.common.graph.GraphBuilder r0 = com.google.common.graph.GraphBuilder.from(r5)
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            com.google.common.graph.GraphBuilder r0 = r0.expectedNodeCount(r1)
            com.google.common.graph.MutableGraph r0 = r0.build()
            goto L_0x0020
        L_0x0018:
            com.google.common.graph.GraphBuilder r0 = com.google.common.graph.GraphBuilder.from(r5)
            com.google.common.graph.MutableGraph r0 = r0.build()
        L_0x0020:
            java.util.Iterator r6 = r6.iterator()
        L_0x0024:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r6.next()
            r0.addNode(r1)
            goto L_0x0024
        L_0x0032:
            java.util.Set r6 = r0.nodes()
            java.util.Iterator r6 = r6.iterator()
        L_0x003a:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r6.next()
            java.util.Set r2 = r5.successors(r1)
            java.util.Iterator r2 = r2.iterator()
        L_0x004c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r2.next()
            java.util.Set r4 = r0.nodes()
            boolean r4 = r4.contains(r3)
            if (r4 == 0) goto L_0x004c
            r0.putEdge(r1, r3)
            goto L_0x004c
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.Graphs.inducedSubgraph(com.google.common.graph.Graph, java.lang.Iterable):com.google.common.graph.MutableGraph");
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.common.graph.ValueGraph<N, V>, com.google.common.graph.ValueGraph] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <N, V> com.google.common.graph.MutableValueGraph<N, V> inducedSubgraph(com.google.common.graph.ValueGraph<N, V> r5, java.lang.Iterable<? extends N> r6) {
        /*
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0018
            com.google.common.graph.ValueGraphBuilder r0 = com.google.common.graph.ValueGraphBuilder.from(r5)
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            com.google.common.graph.ValueGraphBuilder r0 = r0.expectedNodeCount(r1)
            com.google.common.graph.MutableValueGraph r0 = r0.build()
            goto L_0x0020
        L_0x0018:
            com.google.common.graph.ValueGraphBuilder r0 = com.google.common.graph.ValueGraphBuilder.from(r5)
            com.google.common.graph.MutableValueGraph r0 = r0.build()
        L_0x0020:
            java.util.Iterator r6 = r6.iterator()
        L_0x0024:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r6.next()
            r0.addNode(r1)
            goto L_0x0024
        L_0x0032:
            java.util.Set r6 = r0.nodes()
            java.util.Iterator r6 = r6.iterator()
        L_0x003a:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0069
            java.lang.Object r1 = r6.next()
            java.util.Set r2 = r5.successors(r1)
            java.util.Iterator r2 = r2.iterator()
        L_0x004c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r2.next()
            java.util.Set r4 = r0.nodes()
            boolean r4 = r4.contains(r3)
            if (r4 == 0) goto L_0x004c
            r4 = 0
            java.lang.Object r4 = r5.edgeValueOrDefault(r1, r3, r4)
            r0.putEdgeValue(r1, r3, r4)
            goto L_0x004c
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.Graphs.inducedSubgraph(com.google.common.graph.ValueGraph, java.lang.Iterable):com.google.common.graph.MutableValueGraph");
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.common.graph.Network<N, E>, com.google.common.graph.Network] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <N, E> com.google.common.graph.MutableNetwork<N, E> inducedSubgraph(com.google.common.graph.Network<N, E> r6, java.lang.Iterable<? extends N> r7) {
        /*
            boolean r0 = r7 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0018
            com.google.common.graph.NetworkBuilder r0 = com.google.common.graph.NetworkBuilder.from(r6)
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            com.google.common.graph.NetworkBuilder r0 = r0.expectedNodeCount(r1)
            com.google.common.graph.MutableNetwork r0 = r0.build()
            goto L_0x0020
        L_0x0018:
            com.google.common.graph.NetworkBuilder r0 = com.google.common.graph.NetworkBuilder.from(r6)
            com.google.common.graph.MutableNetwork r0 = r0.build()
        L_0x0020:
            java.util.Iterator r7 = r7.iterator()
        L_0x0024:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r7.next()
            r0.addNode(r1)
            goto L_0x0024
        L_0x0032:
            java.util.Set r7 = r0.nodes()
            java.util.Iterator r7 = r7.iterator()
        L_0x003a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r7.next()
            java.util.Set r2 = r6.outEdges(r1)
            java.util.Iterator r2 = r2.iterator()
        L_0x004c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r2.next()
            com.google.common.graph.EndpointPair r4 = r6.incidentNodes(r3)
            java.lang.Object r4 = r4.adjacentNode(r1)
            java.util.Set r5 = r0.nodes()
            boolean r5 = r5.contains(r4)
            if (r5 == 0) goto L_0x004c
            r0.addEdge(r1, r4, r3)
            goto L_0x004c
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.Graphs.inducedSubgraph(com.google.common.graph.Network, java.lang.Iterable):com.google.common.graph.MutableNetwork");
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.graph.Graph<N>, com.google.common.graph.Graph] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <N> MutableGraph<N> copyOf(Graph<N> r3) {
        MutableGraph<N> build = GraphBuilder.from(r3).expectedNodeCount(r3.nodes().size()).build();
        for (Object addNode : r3.nodes()) {
            build.addNode(addNode);
        }
        for (EndpointPair endpointPair : r3.edges()) {
            build.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return build;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.common.graph.ValueGraph<N, V>, com.google.common.graph.ValueGraph] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <N, V> com.google.common.graph.MutableValueGraph<N, V> copyOf(com.google.common.graph.ValueGraph<N, V> r7) {
        /*
            com.google.common.graph.ValueGraphBuilder r0 = com.google.common.graph.ValueGraphBuilder.from(r7)
            java.util.Set r1 = r7.nodes()
            int r1 = r1.size()
            com.google.common.graph.ValueGraphBuilder r0 = r0.expectedNodeCount(r1)
            com.google.common.graph.MutableValueGraph r0 = r0.build()
            java.util.Set r1 = r7.nodes()
            java.util.Iterator r1 = r1.iterator()
        L_0x001c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r1.next()
            r0.addNode(r2)
            goto L_0x001c
        L_0x002a:
            java.util.Set r1 = r7.edges()
            java.util.Iterator r1 = r1.iterator()
        L_0x0032:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r1.next()
            com.google.common.graph.EndpointPair r2 = (com.google.common.graph.EndpointPair) r2
            java.lang.Object r3 = r2.nodeU()
            java.lang.Object r4 = r2.nodeV()
            java.lang.Object r5 = r2.nodeU()
            java.lang.Object r2 = r2.nodeV()
            r6 = 0
            java.lang.Object r2 = r7.edgeValueOrDefault(r5, r2, r6)
            r0.putEdgeValue(r3, r4, r2)
            goto L_0x0032
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.Graphs.copyOf(com.google.common.graph.ValueGraph):com.google.common.graph.MutableValueGraph");
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.common.graph.Network<N, E>, com.google.common.graph.Network] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <N, E> com.google.common.graph.MutableNetwork<N, E> copyOf(com.google.common.graph.Network<N, E> r5) {
        /*
            com.google.common.graph.NetworkBuilder r0 = com.google.common.graph.NetworkBuilder.from(r5)
            java.util.Set r1 = r5.nodes()
            int r1 = r1.size()
            com.google.common.graph.NetworkBuilder r0 = r0.expectedNodeCount(r1)
            java.util.Set r1 = r5.edges()
            int r1 = r1.size()
            com.google.common.graph.NetworkBuilder r0 = r0.expectedEdgeCount(r1)
            com.google.common.graph.MutableNetwork r0 = r0.build()
            java.util.Set r1 = r5.nodes()
            java.util.Iterator r1 = r1.iterator()
        L_0x0028:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r1.next()
            r0.addNode(r2)
            goto L_0x0028
        L_0x0036:
            java.util.Set r1 = r5.edges()
            java.util.Iterator r1 = r1.iterator()
        L_0x003e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r1.next()
            com.google.common.graph.EndpointPair r3 = r5.incidentNodes(r2)
            java.lang.Object r4 = r3.nodeU()
            java.lang.Object r3 = r3.nodeV()
            r0.addEdge(r4, r3, r2)
            goto L_0x003e
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.Graphs.copyOf(com.google.common.graph.Network):com.google.common.graph.MutableNetwork");
    }

    @CanIgnoreReturnValue
    static int checkNonNegative(int i) {
        Preconditions.checkArgument(i >= 0, "Not true that %s is non-negative.", i);
        return i;
    }

    @CanIgnoreReturnValue
    static long checkNonNegative(long j) {
        Preconditions.checkArgument(j >= 0, "Not true that %s is non-negative.", j);
        return j;
    }

    @CanIgnoreReturnValue
    static int checkPositive(int i) {
        Preconditions.checkArgument(i > 0, "Not true that %s is positive.", i);
        return i;
    }

    @CanIgnoreReturnValue
    static long checkPositive(long j) {
        Preconditions.checkArgument(j > 0, "Not true that %s is positive.", j);
        return j;
    }
}
