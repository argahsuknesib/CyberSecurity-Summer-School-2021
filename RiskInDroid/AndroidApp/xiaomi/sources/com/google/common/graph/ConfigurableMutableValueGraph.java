package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

final class ConfigurableMutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> implements MutableValueGraph<N, V> {
    ConfigurableMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
    }

    @CanIgnoreReturnValue
    public final boolean addNode(N n) {
        Preconditions.checkNotNull(n, "node");
        if (containsNode(n)) {
            return false;
        }
        addNodeInternal(n);
        return true;
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> addNodeInternal(N n) {
        GraphConnections<N, V> newConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n, newConnections) == null);
        return newConnections;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: N
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final V putEdgeValue(N r4, N r5, V r6) {
        /*
            r3 = this;
            java.lang.String r0 = "nodeU"
            com.google.common.base.Preconditions.checkNotNull(r4, r0)
            java.lang.String r0 = "nodeV"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            java.lang.String r0 = "value"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            boolean r0 = r3.allowsSelfLoops()
            if (r0 != 0) goto L_0x0020
            boolean r0 = r4.equals(r5)
            r0 = r0 ^ 1
            java.lang.String r1 = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder."
            com.google.common.base.Preconditions.checkArgument(r0, r1, r4)
        L_0x0020:
            com.google.common.graph.MapIteratorCache r0 = r3.nodeConnections
            java.lang.Object r0 = r0.get(r4)
            com.google.common.graph.GraphConnections r0 = (com.google.common.graph.GraphConnections) r0
            if (r0 != 0) goto L_0x002e
            com.google.common.graph.GraphConnections r0 = r3.addNodeInternal(r4)
        L_0x002e:
            java.lang.Object r0 = r0.addSuccessor(r5, r6)
            com.google.common.graph.MapIteratorCache r1 = r3.nodeConnections
            java.lang.Object r1 = r1.get(r5)
            com.google.common.graph.GraphConnections r1 = (com.google.common.graph.GraphConnections) r1
            if (r1 != 0) goto L_0x0040
            com.google.common.graph.GraphConnections r1 = r3.addNodeInternal(r5)
        L_0x0040:
            r1.addPredecessor(r4, r6)
            if (r0 != 0) goto L_0x004f
            long r4 = r3.edgeCount
            r1 = 1
            long r4 = r4 + r1
            r3.edgeCount = r4
            com.google.common.graph.Graphs.checkPositive(r4)
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.ConfigurableMutableValueGraph.putEdgeValue(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @CanIgnoreReturnValue
    public final boolean removeNode(N n) {
        Preconditions.checkNotNull(n, "node");
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(n);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n) != null) {
            graphConnections.removePredecessor(n);
            this.edgeCount--;
        }
        for (Object withoutCaching : graphConnections.successors()) {
            ((GraphConnections) this.nodeConnections.getWithoutCaching(withoutCaching)).removePredecessor(n);
            this.edgeCount--;
        }
        if (isDirected()) {
            for (Object withoutCaching2 : graphConnections.predecessors()) {
                Preconditions.checkState(((GraphConnections) this.nodeConnections.getWithoutCaching(withoutCaching2)).removeSuccessor(n) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @CanIgnoreReturnValue
    public final V removeEdge(N n, N n2) {
        Preconditions.checkNotNull(n, "nodeU");
        Preconditions.checkNotNull(n2, "nodeV");
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(n);
        GraphConnections graphConnections2 = (GraphConnections) this.nodeConnections.get(n2);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V removeSuccessor = graphConnections.removeSuccessor(n2);
        if (removeSuccessor != null) {
            graphConnections2.removePredecessor(n);
            long j = this.edgeCount - 1;
            this.edgeCount = j;
            Graphs.checkNonNegative(j);
        }
        return removeSuccessor;
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected()) {
            return DirectedGraphConnections.of();
        }
        return UndirectedGraphConnections.of();
    }
}
