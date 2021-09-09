package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

@Beta
public abstract class Traverser<N> {

    enum Order {
        PREORDER,
        POSTORDER
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n);

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new GraphTraverser(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new TreeTraverser(successorsFunction);
    }

    private Traverser() {
    }

    static final class GraphTraverser<N> extends Traverser<N> {
        public final SuccessorsFunction<N> graph;

        GraphTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        public final Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable) ImmutableSet.of(n));
        }

        public final Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                /* class com.google.common.graph.Traverser.GraphTraverser.AnonymousClass1 */

                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        public final Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n));
        }

        public final Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                /* class com.google.common.graph.Traverser.GraphTraverser.AnonymousClass2 */

                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.PREORDER);
                }
            };
        }

        public final Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n));
        }

        public final Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                /* class com.google.common.graph.Traverser.GraphTraverser.AnonymousClass3 */

                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.POSTORDER);
                }
            };
        }

        private void checkThatNodeIsInGraph(N n) {
            this.graph.successors(n);
        }

        final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (Object next : iterable) {
                    if (this.visited.add(next)) {
                        this.queue.add(next);
                    }
                }
            }

            public final boolean hasNext() {
                return !this.queue.isEmpty();
            }

            public final N next() {
                N remove = this.queue.remove();
                for (Object next : GraphTraverser.this.graph.successors(remove)) {
                    if (this.visited.add(next)) {
                        this.queue.add(next);
                    }
                }
                return remove;
            }
        }

        final class DepthFirstIterator extends AbstractIterator<N> {
            private final Order order;
            private final Deque<GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> stack = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            DepthFirstIterator(Iterable<? extends N> iterable, Order order2) {
                this.stack.push(new NodeAndSuccessors(null, iterable));
                this.order = order2;
            }

            public final N computeNext() {
                while (!this.stack.isEmpty()) {
                    NodeAndSuccessors first = this.stack.getFirst();
                    boolean add = this.visited.add(first.node);
                    boolean z = true;
                    boolean z2 = !first.successorIterator.hasNext();
                    if ((!add || this.order != Order.PREORDER) && (!z2 || this.order != Order.POSTORDER)) {
                        z = false;
                    }
                    if (z2) {
                        this.stack.pop();
                    } else {
                        Object next = first.successorIterator.next();
                        if (!this.visited.contains(next)) {
                            this.stack.push(withSuccessors(next));
                        }
                    }
                    if (z && first.node != null) {
                        return first.node;
                    }
                }
                return endOfData();
            }

            /* access modifiers changed from: package-private */
            public final GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors withSuccessors(N n) {
                return new NodeAndSuccessors(n, GraphTraverser.this.graph.successors(n));
            }

            final class NodeAndSuccessors {
                final N node;
                final Iterator<? extends N> successorIterator;

                NodeAndSuccessors(N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.successorIterator = iterable.iterator();
                }
            }
        }
    }

    static final class TreeTraverser<N> extends Traverser<N> {
        public final SuccessorsFunction<N> tree;

        TreeTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        public final Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable) ImmutableSet.of(n));
        }

        public final Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                /* class com.google.common.graph.Traverser.TreeTraverser.AnonymousClass1 */

                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        public final Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n));
        }

        public final Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                /* class com.google.common.graph.Traverser.TreeTraverser.AnonymousClass2 */

                public Iterator<N> iterator() {
                    return new DepthFirstPreOrderIterator(iterable);
                }
            };
        }

        public final Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n));
        }

        public final Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                /* class com.google.common.graph.Traverser.TreeTraverser.AnonymousClass3 */

                public Iterator<N> iterator() {
                    return new DepthFirstPostOrderIterator(iterable);
                }
            };
        }

        private void checkThatNodeIsInTree(N n) {
            this.tree.successors(n);
        }

        final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (Object add : iterable) {
                    this.queue.add(add);
                }
            }

            public final boolean hasNext() {
                return !this.queue.isEmpty();
            }

            public final N next() {
                N remove = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.this.tree.successors(remove));
                return remove;
            }
        }

        final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            private final Deque<Iterator<? extends N>> stack = new ArrayDeque();

            DepthFirstPreOrderIterator(Iterable<? extends N> iterable) {
                this.stack.addLast(iterable.iterator());
            }

            public final boolean hasNext() {
                return !this.stack.isEmpty();
            }

            public final N next() {
                Iterator last = this.stack.getLast();
                N checkNotNull = Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.stack.removeLast();
                }
                Iterator<? extends N> it = TreeTraverser.this.tree.successors(checkNotNull).iterator();
                if (it.hasNext()) {
                    this.stack.addLast(it);
                }
                return checkNotNull;
            }
        }

        final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            private final ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> stack = new ArrayDeque<>();

            DepthFirstPostOrderIterator(Iterable<? extends N> iterable) {
                this.stack.addLast(new NodeAndChildren(null, iterable));
            }

            public final N computeNext() {
                while (!this.stack.isEmpty()) {
                    NodeAndChildren last = this.stack.getLast();
                    if (last.childIterator.hasNext()) {
                        this.stack.addLast(withChildren(last.childIterator.next()));
                    } else {
                        this.stack.removeLast();
                        if (last.node != null) {
                            return last.node;
                        }
                    }
                }
                return endOfData();
            }

            /* access modifiers changed from: package-private */
            public final TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren withChildren(N n) {
                return new NodeAndChildren(n, TreeTraverser.this.tree.successors(n));
            }

            final class NodeAndChildren {
                final Iterator<? extends N> childIterator;
                final N node;

                NodeAndChildren(N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.childIterator = iterable.iterator();
                }
            }
        }
    }
}
