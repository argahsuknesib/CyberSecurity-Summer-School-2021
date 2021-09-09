package com.xiaomi.mico.music.patchwall.adapter;

import _m_j.aya;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hxk;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaomi.mico.api.model.IntelligentModel;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.patchwall.group.IntelligentBaseViewHolder;
import com.xiaomi.mico.music.patchwall.group.IntelligentViewHolderFactory;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntelligentFlowAdapter extends aya<IntelligentBaseViewHolder, IntelligentBaseViewHolder> implements RatioBanner.OnStateChange {
    private static final String TAG = "IntelligentFlowAdapter";
    private List<IntelligentModel.ListBean> groups = new ArrayList();
    private boolean mIsActivate;

    public int getGroupItemViewType(int i) {
        return 0;
    }

    public boolean onCheckCanExpandOrCollapseGroup(IntelligentBaseViewHolder intelligentBaseViewHolder, int i, int i2, int i3, boolean z) {
        return false;
    }

    public IntelligentFlowAdapter() {
        setHasStableIds(true);
    }

    public List<IntelligentModel.ListBean> getGroups() {
        return this.groups;
    }

    public void setGroups(IntelligentModel intelligentModel) {
        Iterator<IntelligentModel.ListBean> it = intelligentModel.getList().iterator();
        while (it.hasNext()) {
            IntelligentModel.ListBean next = it.next();
            int displayType = next.getDisplayType();
            if (IntelligentViewHolderFactory.sViewHolder.get(displayType) == 0) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "Mico-Api", "displayType" + displayType + "not support type == " + next.getType());
                it.remove();
            }
        }
        this.groups.clear();
        this.groups.addAll(intelligentModel.getList());
    }

    public void appendGroupsChild(List<IntelligentModel.ListBean.CardsBean> list) {
        try {
            for (int size = this.groups.size() - 1; size >= 0; size--) {
                IntelligentModel.ListBean listBean = this.groups.get(size);
                if (TextUtils.equals(listBean.getType(), "STRATEGY")) {
                    listBean.getCards().addAll(list);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void appendGroup(IntelligentModel.ListBean listBean) {
        try {
            int displayType = listBean.getDisplayType();
            if (IntelligentViewHolderFactory.sViewHolder.get(displayType) == 0) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "Mico-Api", " appendGroup displayType" + displayType + "not support type == " + listBean.getType());
                return;
            }
            this.groups.add(listBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getGroupCount() {
        return this.groups.size();
    }

    public int getChildCount(int i) {
        IntelligentModel.ListBean listBean = this.groups.get(i);
        if (!(listBean == null || listBean.getCards() == null)) {
            if (TextUtils.equals("STRATEGY", listBean.getType())) {
                return listBean.getCards().size();
            }
            if (listBean.getCards().size() > 0) {
                return 1;
            }
        }
        return 0;
    }

    public long getGroupId(int i) {
        if (i >= this.groups.size()) {
            return 0;
        }
        return (long) this.groups.get(i).getTypeId();
    }

    public long getChildId(int i, int i2) {
        IntelligentModel.ListBean.CardsBean cardsBean = this.groups.get(i).getCards().get(i2);
        if (cardsBean.getDisplayType() == 6) {
            return Long.parseLong(cardsBean.getInfoStreamId());
        }
        return cardsBean.getId();
    }

    public int getChildItemViewType(int i, int i2) {
        int i3;
        IntelligentModel.ListBean listBean = this.groups.get(i);
        if (TextUtils.equals("STRATEGY", listBean.getType())) {
            i3 = listBean.getCards().get(i2).getDisplayType();
        } else {
            i3 = listBean.getDisplayType();
        }
        gsy.O00000Oo(TAG, "getChildItemViewType: ".concat(String.valueOf(i3)));
        return i3;
    }

    public IntelligentBaseViewHolder onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
        return IntelligentViewHolderFactory.createGroupViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    public IntelligentBaseViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        return IntelligentViewHolderFactory.createChildViewHolder(i, LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    public void onBindGroupViewHolder(IntelligentBaseViewHolder intelligentBaseViewHolder, int i, int i2) {
        final IntelligentModel.ListBean listBean = this.groups.get(i);
        if (intelligentBaseViewHolder instanceof IntelligentViewHolderFactory.IntelligentHeaderViewHolder) {
            ((IntelligentViewHolderFactory.IntelligentHeaderViewHolder) intelligentBaseViewHolder).bindView(listBean);
            intelligentBaseViewHolder.setOnItemClickListener(new IntelligentBaseViewHolder.onItemClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.IntelligentFlowAdapter.AnonymousClass1 */

                public void onItemClicked(int i) {
                    String type = listBean.getType();
                    if (((type.hashCode() == 2576 && type.equals("QA")) ? (char) 0 : 65535) == 0) {
                        hxi.O00000o.O00000Oo(0, listBean.getType(), listBean.getName());
                    }
                }
            });
        }
    }

    public void onBindChildViewHolder(IntelligentBaseViewHolder intelligentBaseViewHolder, int i, final int i2, int i3) {
        List arrayList = new ArrayList();
        final IntelligentModel.ListBean listBean = this.groups.get(i);
        if (TextUtils.equals("STRATEGY", listBean.getType())) {
            arrayList.add(listBean.getCards().get(i2));
        } else {
            arrayList = this.groups.get(i).getCards();
        }
        final String mainTitle = ((IntelligentModel.ListBean.CardsBean) arrayList.get(0)).getMainTitle();
        intelligentBaseViewHolder.setOnItemClickListener(new IntelligentBaseViewHolder.onItemClickListener() {
            /* class com.xiaomi.mico.music.patchwall.adapter.IntelligentFlowAdapter.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x009b  */
            public void onItemClicked(int i) {
                char c;
                String type = listBean.getType();
                int hashCode = type.hashCode();
                if (hashCode != -1905598528) {
                    if (hashCode != 2576) {
                        if (hashCode == 1951158380 && type.equals("WELFARE")) {
                            c = 0;
                            if (c != 0) {
                                hxk hxk = hxi.O00000o;
                                String type2 = listBean.getType();
                                String str = mainTitle;
                                hxk.f952O000000o.O000000o("content_intelligence_welfare", "type", type2, "name", str);
                            } else if (c == 1) {
                                hxk hxk2 = hxi.O00000o;
                                String type3 = listBean.getType();
                                String str2 = mainTitle;
                                hxk2.f952O000000o.O000000o("content_intelligence_discuss", "type", type3, "name", str2);
                            } else if (c == 2) {
                                hxi.O00000o.O00000Oo(1, listBean.getType(), mainTitle);
                            }
                            if (TextUtils.equals(listBean.getType(), "STRATEGY")) {
                                i = i2;
                            }
                            hxk hxk3 = hxi.O00000o;
                            String type4 = listBean.getType();
                            String name = listBean.getName();
                            hxk3.f952O000000o.O000000o("content_intelligence_new", "type", type4, "position", Integer.valueOf(i), "name", name);
                        }
                    } else if (type.equals("QA")) {
                        c = 2;
                        if (c != 0) {
                        }
                        if (TextUtils.equals(listBean.getType(), "STRATEGY")) {
                        }
                        hxk hxk32 = hxi.O00000o;
                        String type42 = listBean.getType();
                        String name2 = listBean.getName();
                        hxk32.f952O000000o.O000000o("content_intelligence_new", "type", type42, "position", Integer.valueOf(i), "name", name2);
                    }
                } else if (type.equals("DISCUSS")) {
                    c = 1;
                    if (c != 0) {
                    }
                    if (TextUtils.equals(listBean.getType(), "STRATEGY")) {
                    }
                    hxk hxk322 = hxi.O00000o;
                    String type422 = listBean.getType();
                    String name22 = listBean.getName();
                    hxk322.f952O000000o.O000000o("content_intelligence_new", "type", type422, "position", Integer.valueOf(i), "name", name22);
                }
                c = 65535;
                if (c != 0) {
                }
                if (TextUtils.equals(listBean.getType(), "STRATEGY")) {
                }
                hxk hxk3222 = hxi.O00000o;
                String type4222 = listBean.getType();
                String name222 = listBean.getName();
                hxk3222.f952O000000o.O000000o("content_intelligence_new", "type", type4222, "position", Integer.valueOf(i), "name", name222);
            }
        });
        intelligentBaseViewHolder.bindView(arrayList, this);
    }

    public void onActivate() {
        this.mIsActivate = true;
        notifyDataSetChanged();
    }

    public void onDeactivate() {
        this.mIsActivate = false;
        notifyDataSetChanged();
    }

    public boolean isActivate() {
        return this.mIsActivate;
    }
}
