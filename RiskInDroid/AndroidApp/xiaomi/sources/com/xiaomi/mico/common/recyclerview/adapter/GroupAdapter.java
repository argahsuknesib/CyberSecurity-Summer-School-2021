package com.xiaomi.mico.common.recyclerview.adapter;

import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder;
import com.xiaomi.mico.common.util.CommonUtils;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public abstract class GroupAdapter<VH extends ItemClickableAdapter.ViewHolder> extends ItemClickableAdapter<VH> {
    private List<Group> mGroupList = new ArrayList();

    public final void setFirstGroup(Group group) {
        Group group2 = this.mGroupList.get(0);
        if (group2 == null || !group2.equals(group)) {
            this.mGroupList.add(0, group);
        } else {
            this.mGroupList.set(0, group);
        }
    }

    public final void addGroup(Group group) {
        int indexOf = this.mGroupList.indexOf(group);
        if (indexOf != -1) {
            this.mGroupList.set(indexOf, group);
        } else {
            this.mGroupList.add(group);
        }
    }

    public final void addGroup(int i, Group group) {
        if (i != -1) {
            if (this.mGroupList.size() == 0 && i == 0) {
                this.mGroupList.add(group);
            }
            this.mGroupList.set(i, group);
            return;
        }
        addGroup(group);
    }

    public final void removeGroup(Class<?> cls) {
        try {
            Iterator<Group> it = this.mGroupList.iterator();
            while (it.hasNext()) {
                if (cls.isInstance(it.next())) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }

    public final void clearGroup() {
        this.mGroupList.clear();
    }

    public final Group getGroupByID(String str) {
        for (Group next : this.mGroupList) {
            if (CommonUtils.equals(next.getID(), str)) {
                return next;
            }
        }
        return null;
    }

    public final Group getGroup(int i) {
        for (Group next : this.mGroupList) {
            if (i < next.getTotalCount()) {
                return next;
            }
            i -= next.getTotalCount();
        }
        throw new IllegalStateException("Must not arrive here.");
    }

    public final Object getItem(int i) {
        for (Group next : this.mGroupList) {
            if (i < next.getTotalCount()) {
                return next.getItem(i - next.getHeaderCount());
            }
            i -= next.getTotalCount();
        }
        throw new IllegalStateException("Must not arrive here.");
    }

    public final int getItemInnerPosition(int i) {
        for (Group next : this.mGroupList) {
            if (i < next.getTotalCount()) {
                return i - next.getHeaderCount();
            }
            i -= next.getTotalCount();
        }
        throw new IllegalStateException("Must not arrive here.");
    }

    public final boolean isHeader(int i) {
        for (Group next : this.mGroupList) {
            if (i < next.getTotalCount()) {
                return next.isHeader(i);
            }
            i -= next.getTotalCount();
        }
        throw new IllegalStateException("Must not arrive here.");
    }

    public final int getItemCount() {
        int i = 0;
        for (Group totalCount : this.mGroupList) {
            i += totalCount.getTotalCount();
        }
        return i;
    }

    public final int getItemViewType(int i) {
        for (Group next : this.mGroupList) {
            if (i < next.getTotalCount()) {
                return next.getItemViewType(i);
            }
            i -= next.getTotalCount();
        }
        throw new IllegalStateException("Must not arrive here.");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: VH
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
    public void onBindViewHolder(VH r4, int r5) {
        /*
            r3 = this;
            r4.bindView(r5)
            java.util.List<com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter$Group> r0 = r3.mGroupList
            java.util.Iterator r0 = r0.iterator()
        L_0x0009:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0025
            java.lang.Object r1 = r0.next()
            com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter$Group r1 = (com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter.Group) r1
            int r2 = r1.getTotalCount()
            if (r5 >= r2) goto L_0x001f
            r1.onBindViewHolder(r4, r5)
            return
        L_0x001f:
            int r1 = r1.getTotalCount()
            int r5 = r5 - r1
            goto L_0x0009
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter.onBindViewHolder(com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter$ViewHolder, int):void");
    }

    public static abstract class Group<VH extends ItemClickableAdapter.ViewHolder> {
        public int getHeaderCount() {
            return 1;
        }

        public abstract String getID();

        public Object getItem(int i) {
            return null;
        }

        public int getItemCount() {
            return 0;
        }

        public abstract int getItemViewType(int i);

        public abstract void onBindViewHolder(VH vh, int i);

        /* access modifiers changed from: protected */
        public final int getTotalCount() {
            return getHeaderCount() + getItemCount();
        }

        /* access modifiers changed from: protected */
        public final boolean isHeader(int i) {
            return i < getHeaderCount();
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Group) && CommonUtils.equals(getID(), ((Group) obj).getID());
            }
            return true;
        }
    }
}
