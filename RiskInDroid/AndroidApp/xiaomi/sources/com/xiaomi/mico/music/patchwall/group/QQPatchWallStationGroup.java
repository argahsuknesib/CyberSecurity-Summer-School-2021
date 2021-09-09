package com.xiaomi.mico.music.patchwall.group;

import _m_j.gpc;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.patchwall.adapter.QQStationAdapter;
import com.xiaomi.mico.music.widget.HorizontalScrollStationTabView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class QQPatchWallStationGroup extends PatchWallGroup {
    public QQPatchWallStationGroup(PatchWall.Block block) {
        super(block, 0, 0);
    }

    public int getItemViewType(int i) {
        return isHeader(i) ? 4 : 6;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        if (isHeader(i)) {
            ((QQHeaderViewHolder) viewHolder).bindView(this.block);
        } else if (viewHolder instanceof QQStationViewHolder) {
            ((QQStationViewHolder) viewHolder).bindView(this.block);
        }
    }

    public static class QQStationViewHolder extends ItemClickableAdapter.ViewHolder {
        private List category;
        public int cellWidth;
        private Context context;
        public int halfW;
        LinearLayoutManager linearLayoutManager = ((LinearLayoutManager) this.recyclerView.getLayoutManager());
        private QQStationAdapter qqStationAdapter;
        RecyclerView recyclerView;
        private List<List<PatchWall.Item>> stations;
        HorizontalScrollStationTabView tabView;

        public QQStationViewHolder(View view) {
            super(view, null);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.station_recycler_view);
            this.tabView = (HorizontalScrollStationTabView) view.findViewById(R.id.station_tab);
            this.recyclerView.setHasFixedSize(false);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setNestedScrollingEnabled(false);
            this.halfW = gpc.O00000oO(view.getContext()) / 2;
            this.cellWidth = gpc.O00000o0(view.getContext(), 102.0f);
            this.qqStationAdapter = new QQStationAdapter(view.getContext());
            this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
            this.recyclerView.setAdapter(this.qqStationAdapter);
            this.tabView.setListener(new HorizontalScrollStationTabView.OnTabClickedListener() {
                /* class com.xiaomi.mico.music.patchwall.group.QQPatchWallStationGroup.QQStationViewHolder.AnonymousClass1 */

                public void onTabClicked(int i, int i2) {
                    QQStationViewHolder.this.linearLayoutManager.scrollToPositionWithOffset(i, 0);
                }
            });
            this.recyclerView.setOnScrollListener(new RecyclerView.O00oOooO() {
                /* class com.xiaomi.mico.music.patchwall.group.QQPatchWallStationGroup.QQStationViewHolder.AnonymousClass2 */
                private int distance;

                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                }

                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    if (i != 0) {
                        int findFirstVisibleItemPosition = QQStationViewHolder.this.linearLayoutManager.findFirstVisibleItemPosition();
                        int findLastVisibleItemPosition = QQStationViewHolder.this.linearLayoutManager.findLastVisibleItemPosition();
                        if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                            this.distance = 0;
                            QQStationViewHolder.this.tabView.setSelectedIndex(findFirstVisibleItemPosition);
                        } else {
                            int i3 = findLastVisibleItemPosition - findFirstVisibleItemPosition;
                            if (i3 == 1) {
                                this.distance += i;
                                if (Math.abs(this.distance) <= QQStationViewHolder.this.halfW) {
                                    QQStationViewHolder.this.tabView.setSelectedIndex(findFirstVisibleItemPosition);
                                } else if (this.distance < 0) {
                                    QQStationViewHolder.this.tabView.setSelectedIndex(findFirstVisibleItemPosition);
                                } else {
                                    QQStationViewHolder.this.tabView.setSelectedIndex(findLastVisibleItemPosition);
                                }
                            } else if (i3 == 2) {
                                int i4 = findFirstVisibleItemPosition + 1;
                                int genreCount = QQStationViewHolder.this.tabView.getGenreCount(i4);
                                int i5 = (genreCount / 2) + (genreCount % 2);
                                if (i5 < 3) {
                                    this.distance = ((3 - i5) * QQStationViewHolder.this.cellWidth) + (QQStationViewHolder.this.cellWidth / 2);
                                } else if (i5 == 3) {
                                    if (i < 0) {
                                        this.distance = QQStationViewHolder.this.cellWidth * 3;
                                    } else {
                                        this.distance = i;
                                    }
                                }
                                QQStationViewHolder.this.tabView.setSelectedIndex(i4);
                            } else if (i3 == 3) {
                                this.distance = QQStationViewHolder.this.cellWidth;
                                QQStationViewHolder.this.tabView.setSelectedIndex(findFirstVisibleItemPosition + 1);
                            }
                        }
                    } else {
                        int selectedTabCount = QQStationViewHolder.this.tabView.getSelectedTabCount();
                        int i6 = (selectedTabCount / 2) + (selectedTabCount % 2);
                        if (i6 > 3) {
                            this.distance = QQStationViewHolder.this.halfW * 2;
                        } else {
                            this.distance = (QQStationViewHolder.this.halfW * 2) - (i6 * QQStationViewHolder.this.cellWidth);
                        }
                    }
                    super.onScrolled(recyclerView, i, i2);
                }
            });
            this.category = new ArrayList();
            this.stations = new ArrayList();
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block) {
            this.category.clear();
            this.stations.clear();
            int i = -1;
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < block.items.size(); i2++) {
                PatchWall.Item item = block.items.get(i2);
                if (i != item.groupTypeId) {
                    addOneTab(arrayList);
                    i = item.groupTypeId;
                    arrayList = new ArrayList();
                }
                arrayList.add(item);
                if (i2 == block.items.size() - 1) {
                    addOneTab(arrayList);
                }
            }
            this.tabView.setStations(this.category);
            this.qqStationAdapter.setStations(block, this.stations);
        }

        /* access modifiers changed from: package-private */
        public void addOneTab(List list) {
            if (list != null && !list.isEmpty()) {
                this.stations.add(list);
                this.category.add(new HorizontalScrollStationTabView.StationTab(((PatchWall.Item) list.get(0)).groupName, list.size()));
            }
        }
    }
}
