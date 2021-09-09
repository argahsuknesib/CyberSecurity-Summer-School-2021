package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;

final class ConfigurableMutableNetwork<N, E> extends ConfigurableNetwork<N, E> implements MutableNetwork<N, E> {
    ConfigurableMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
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
    private NetworkConnections<N, E> addNodeInternal(N n) {
        NetworkConnections<N, E> newConnections = newConnections();
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean addEdge(N r6, N r7, E r8) {
        /*
            r5 = this;
            java.lang.String r0 = "nodeU"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            java.lang.String r0 = "nodeV"
            com.google.common.base.Preconditions.checkNotNull(r7, r0)
            java.lang.String r0 = "edge"
            com.google.common.base.Preconditions.checkNotNull(r8, r0)
            boolean r0 = r5.containsEdge(r8)
            r1 = 0
            if (r0 == 0) goto L_0x0028
            com.google.common.graph.EndpointPair r0 = r5.incidentNodes(r8)
            com.google.common.graph.EndpointPair r6 = com.google.common.graph.EndpointPair.of(r5, r6, r7)
            boolean r7 = r0.equals(r6)
            java.lang.String r2 = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s."
            com.google.common.base.Preconditions.checkArgument(r7, r2, r8, r0, r6)
            return r1
        L_0x0028:
            com.google.common.graph.MapIteratorCache r0 = r5.nodeConnections
            java.lang.Object r0 = r0.get(r6)
            com.google.common.graph.NetworkConnections r0 = (com.google.common.graph.NetworkConnections) r0
            boolean r2 = r5.allowsParallelEdges()
            r3 = 1
            if (r2 != 0) goto L_0x0049
            if (r0 == 0) goto L_0x0043
            java.util.Set r2 = r0.successors()
            boolean r2 = r2.contains(r7)
            if (r2 != 0) goto L_0x0044
        L_0x0043:
            r1 = 1
        L_0x0044:
            java.lang.String r2 = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder."
            com.google.common.base.Preconditions.checkArgument(r1, r2, r6, r7)
        L_0x0049:
            boolean r1 = r6.equals(r7)
            boolean r2 = r5.allowsSelfLoops()
            if (r2 != 0) goto L_0x005a
            r2 = r1 ^ 1
            java.lang.String r4 = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder."
            com.google.common.base.Preconditions.checkArgument(r2, r4, r6)
        L_0x005a:
            if (r0 != 0) goto L_0x0060
            com.google.common.graph.NetworkConnections r0 = r5.addNodeInternal(r6)
        L_0x0060:
            r0.addOutEdge(r8, r7)
            com.google.common.graph.MapIteratorCache r0 = r5.nodeConnections
            java.lang.Object r0 = r0.get(r7)
            com.google.common.graph.NetworkConnections r0 = (com.google.common.graph.NetworkConnections) r0
            if (r0 != 0) goto L_0x0071
            com.google.common.graph.NetworkConnections r0 = r5.addNodeInternal(r7)
        L_0x0071:
            r0.addInEdge(r8, r6, r1)
            com.google.common.graph.MapIteratorCache r7 = r5.edgeToReferenceNode
            r7.put(r8, r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.ConfigurableMutableNetwork.addEdge(java.lang.Object, java.lang.Object, java.lang.Object):boolean");
    }

    @CanIgnoreReturnValue
    public final boolean removeNode(N n) {
        Preconditions.checkNotNull(n, "node");
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(n);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator it = ImmutableList.copyOf((Collection) networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(n);
        return true;
    }

    @CanIgnoreReturnValue
    public final boolean removeEdge(E e) {
        Preconditions.checkNotNull(e, "edge");
        Object obj = this.edgeToReferenceNode.get(e);
        boolean z = false;
        if (obj == null) {
            return false;
        }
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(obj);
        Object adjacentNode = networkConnections.adjacentNode(e);
        NetworkConnections networkConnections2 = (NetworkConnections) this.nodeConnections.get(adjacentNode);
        networkConnections.removeOutEdge(e);
        if (allowsSelfLoops() && obj.equals(adjacentNode)) {
            z = true;
        }
        networkConnections2.removeInEdge(e, z);
        this.edgeToReferenceNode.remove(e);
        return true;
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.of();
            }
            return DirectedNetworkConnections.of();
        } else if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.of();
        } else {
            return UndirectedNetworkConnections.of();
        }
    }
}
