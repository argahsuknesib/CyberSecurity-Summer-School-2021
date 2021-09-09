package com.xiaomi.mico.common.recyclerview.adapter;

import android.view.ViewGroup;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class SingleAdapter<VH extends ItemClickableAdapter.ViewHolder, T> extends ItemClickableAdapter<VH> {
    protected List<T> dataList;
    protected int dataType;

    public int getDataIndex(int i) {
        return i;
    }

    public boolean isHeader(int i) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract VH onCreateItemViewHolder(ViewGroup viewGroup, int i);

    public int getDataType() {
        return this.dataType;
    }

    public boolean isNullDataList() {
        return this.dataList == null;
    }

    public void updateDataList(List<T> list, int i) {
        this.dataType = i;
        updateDataList(list);
    }

    public void updateDataList(List<T> list) {
        List<T> list2 = this.dataList;
        if (list2 == null) {
            this.dataList = new ArrayList();
        } else {
            list2.clear();
        }
        if (list != null) {
            this.dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addDataList(List<T> list) {
        if (this.dataList == null) {
            this.dataList = new ArrayList();
        }
        if (list != null) {
            this.dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void clearAllData(boolean z) {
        List<T> list = this.dataList;
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            this.dataList.clear();
            this.dataList = null;
            if (z) {
                notifyDataSetChanged();
                return;
            }
            return;
        }
        this.dataList = null;
    }

    public final int getDataSize() {
        List<T> list = this.dataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public final T getData(int i) {
        List<T> list = this.dataList;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.dataList.get(getDataIndex(i));
    }

    public final boolean isHeaderByPosition(int i) {
        return isHeader(getItemViewType(i));
    }

    public int getItemCount() {
        return getDataSize();
    }

    public final VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (isHeader(i)) {
            return onCreateHeaderViewHolder(viewGroup, i);
        }
        return onCreateItemViewHolder(viewGroup, i);
    }

    public final void onBindViewHolder(VH vh, int i) {
        if (isHeaderByPosition(i)) {
            onBindHeaderViewHolder(vh, i);
        } else {
            onBindItemViewHolder(vh, i);
        }
    }

    /* access modifiers changed from: protected */
    public VH onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
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
    protected void onBindHeaderViewHolder(VH r1, int r2) {
        /*
            r0 = this;
            r1.bindView(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter.onBindHeaderViewHolder(com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter$ViewHolder, int):void");
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
    protected void onBindItemViewHolder(VH r1, int r2) {
        /*
            r0 = this;
            r1.bindView(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter.onBindItemViewHolder(com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter$ViewHolder, int):void");
    }
}
