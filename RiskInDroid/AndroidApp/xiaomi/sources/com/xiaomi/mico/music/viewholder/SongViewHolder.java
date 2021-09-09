package com.xiaomi.mico.music.viewholder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.itemdecoration.Ignore;
import com.xiaomi.mico.common.recyclerview.itemdecoration.ItemDecorationHelper;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.patchwall.BlockDetailActivityV2;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.mico.music.viewholder.ItemViewHolder;
import com.xiaomi.mico.music.viewholder.SongViewHolder;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongViewHolder {

    public static class StationCategoryViewHolder extends ItemViewHolder.Lovable {
        private CategoryItemAdapter adapter;
        private Music.CategoryItemParent cateItemParent;
        TextView categoryName = ((TextView) this.itemView.findViewById(R.id.category_parent_name));
        ImageView categoryParentBg = ((ImageView) this.itemView.findViewById(R.id.category_parent_bg));
        public Context context;
        RecyclerView grid = ((RecyclerView) this.itemView.findViewById(R.id.category_item_grid));

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public StationCategoryViewHolder(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.radio_category_parent_item, viewGroup, false), onItemClickListener, lovable);
            this.context = viewGroup.getContext();
            this.adapter = new CategoryItemAdapter();
            this.grid.setLayoutManager(new GridLayoutManager(this.context, 3));
            this.grid.addItemDecoration(ItemDecorationHelper.listDivider(this.context, 0, 0, new Ignore() {
                /* class com.xiaomi.mico.music.viewholder.$$Lambda$SongViewHolder$StationCategoryViewHolder$5ZGUbBFIQrlBQMaY6LizMp9X9g */

                public final boolean needIgnore(int i, int i2) {
                    return SongViewHolder.StationCategoryViewHolder.this.lambda$new$0$SongViewHolder$StationCategoryViewHolder(i, i2);
                }
            }));
            this.grid.addItemDecoration(ItemDecorationHelper.listDividerVertical(this.context, 0, 0, new Ignore() {
                /* class com.xiaomi.mico.music.viewholder.$$Lambda$SongViewHolder$StationCategoryViewHolder$aDcQ5irn1PoODey3HetPUoVbQw */

                public final boolean needIgnore(int i, int i2) {
                    return SongViewHolder.StationCategoryViewHolder.this.lambda$new$1$SongViewHolder$StationCategoryViewHolder(i, i2);
                }
            }));
            this.grid.setAdapter(this.adapter);
        }

        public /* synthetic */ boolean lambda$new$0$SongViewHolder$StationCategoryViewHolder(int i, int i2) {
            return this.adapter.getItemViewType(i) == 2;
        }

        public /* synthetic */ boolean lambda$new$1$SongViewHolder$StationCategoryViewHolder(int i, int i2) {
            return this.adapter.getItemViewType(i) == 2;
        }

        public void bindView(Serializable serializable) {
            if (serializable instanceof Music.CategoryItemParent) {
                this.cateItemParent = (Music.CategoryItemParent) serializable;
                MusicHelper.loadPatchWallCropSquareCover(this.cateItemParent.imgUrl, this.categoryParentBg, R.drawable.radio_category_recreation, MusicHelper.getDefaultCornerRadius(this.context));
                this.categoryName.setText(this.cateItemParent.name);
                this.adapter.updateData(this.cateItemParent.items);
            }
        }

        class CategoryItemAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
            private List<Music.CategoryItem> data;

            public long getItemId(int i) {
                return (long) i;
            }

            CategoryItemAdapter() {
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new CategoryItemViewHolder(LayoutInflater.from(StationCategoryViewHolder.this.context).inflate((int) R.layout.radio_category_item, viewGroup, false));
            }

            public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ((CategoryItemViewHolder) o000OOo0).bindView(this.data.get(i));
            }

            public int getItemCount() {
                List<Music.CategoryItem> list = this.data;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            public int getItemViewType(int i) {
                if (i < 3) {
                    return 1;
                }
                List<Music.CategoryItem> list = this.data;
                return (list == null || i < list.size() - 3) ? 0 : 2;
            }

            /* access modifiers changed from: package-private */
            public void updateData(List<Music.CategoryItem> list) {
                this.data = list;
                notifyDataSetChanged();
            }
        }

        class CategoryItemViewHolder extends RecyclerView.O000OOo0 {
            Music.CategoryItem item;
            TextView title;

            CategoryItemViewHolder(View view) {
                super(view);
                this.title = (TextView) view.findViewById(R.id.category_name);
                view.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                      (r2v0 'view' android.view.View)
                      (wrap: com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0 : 0x0012: CONSTRUCTOR  (r1v4 com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0) = 
                      (r0v0 'this' com.xiaomi.mico.music.viewholder.SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder A[THIS])
                      (r2v0 'view' android.view.View)
                     call: com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0.<init>(com.xiaomi.mico.music.viewholder.SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder, android.view.View):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.mico.music.viewholder.SongViewHolder.StationCategoryViewHolder.CategoryItemViewHolder.<init>(com.xiaomi.mico.music.viewholder.SongViewHolder$StationCategoryViewHolder, android.view.View):void, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r1v4 com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0) = 
                      (r0v0 'this' com.xiaomi.mico.music.viewholder.SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder A[THIS])
                      (r2v0 'view' android.view.View)
                     call: com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0.<init>(com.xiaomi.mico.music.viewholder.SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder, android.view.View):void type: CONSTRUCTOR in method: com.xiaomi.mico.music.viewholder.SongViewHolder.StationCategoryViewHolder.CategoryItemViewHolder.<init>(com.xiaomi.mico.music.viewholder.SongViewHolder$StationCategoryViewHolder, android.view.View):void, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    com.xiaomi.mico.music.viewholder.SongViewHolder.StationCategoryViewHolder.this = r1
                    r0.<init>(r2)
                    r1 = 2132149036(0x7f16032c, float:1.9940067E38)
                    android.view.View r1 = r2.findViewById(r1)
                    android.widget.TextView r1 = (android.widget.TextView) r1
                    r0.title = r1
                    com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0 r1 = new com.xiaomi.mico.music.viewholder.-$$Lambda$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder$6JwA-6kVPanep5JrdxP50Yv_vY0
                    r1.<init>(r0, r2)
                    r2.setOnClickListener(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.music.viewholder.SongViewHolder.StationCategoryViewHolder.CategoryItemViewHolder.<init>(com.xiaomi.mico.music.viewholder.SongViewHolder$StationCategoryViewHolder, android.view.View):void");
            }

            public /* synthetic */ void lambda$new$0$SongViewHolder$StationCategoryViewHolder$CategoryItemViewHolder(View view, View view2) {
                Intent intent = new Intent(view.getContext(), BlockDetailActivityV2.class);
                intent.putExtra("block_title", this.item.name);
                intent.putExtra("block_category_type", this.item.stationCategoryType);
                intent.putStringArrayListExtra("block_cp_list", (ArrayList) this.item.cpList);
                intent.putExtra("block_type", "block_type_audio_boox");
                view.getContext().startActivity(intent);
            }

            /* access modifiers changed from: package-private */
            public void bindView(Music.CategoryItem categoryItem) {
                this.item = categoryItem;
                this.title.setText(categoryItem.name.length() > 4 ? categoryItem.name.substring(0, 4) : categoryItem.name);
            }
        }
    }

    public static class LovableStation extends ItemViewHolder.Lovable implements PlayerStatusTrack.onTrackListener {
        TextView author = ((TextView) this.itemView.findViewById(R.id.patchwall_item_author));
        private boolean canPlayHistory;
        TextView category = ((TextView) this.itemView.findViewById(R.id.item_category));
        private Context context;
        TextView desc = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        TextView episodes = ((TextView) this.itemView.findViewById(R.id.episodes));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        ImageView play = ((ImageView) this.itemView.findViewById(R.id.patchwall_item_play));
        private String playingMusicID;
        private Music.Station station;
        ImageView tagRich = ((ImageView) this.itemView.findViewById(R.id.tag_rich));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));
        TextView updateTime = ((TextView) this.itemView.findViewById(R.id.update_time));

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public LovableStation(ViewGroup viewGroup, boolean z, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_player_item_song_v2, viewGroup, false), onItemClickListener, lovable);
            this.context = viewGroup.getContext();
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.viewholder.$$Lambda$SongViewHolder$LovableStation$Myf5nSbFOT2OttlkeInJFd0hOrA */

                public final void onClick(View view) {
                    SongViewHolder.LovableStation.this.lambda$new$0$SongViewHolder$LovableStation(view);
                }
            });
            if (z) {
                this.itemView.setBackgroundResource(R.drawable.bg_transparent_list_selector);
                this.title.setTextColor(viewGroup.getResources().getColorStateList(R.color.white_80_to_highlight_color));
                this.desc.setTextColor(viewGroup.getResources().getColorStateList(R.color.white_50_to_highlight_color));
            }
        }

        public /* synthetic */ void lambda$new$0$SongViewHolder$LovableStation(View view) {
            MusicHelper.processMusic(this.context, this.station);
        }

        public void bindView(Serializable serializable, String str, boolean z) {
            if (serializable instanceof Music.Station) {
                this.canPlayHistory = z;
                this.station = (Music.Station) serializable;
                this.playingMusicID = str;
                MusicHelper.loadPatchWallCropSquareCover(this.station.cover, this.image, R.drawable.img_cover_default_rectangle, MusicHelper.getDefaultCornerRadius(this.context));
                this.title.setText(this.station.title);
                this.author.setText(this.station.cpNameOrBoradcaster());
                int i = 0;
                this.category.setText(this.context.getString(R.string.music_category, this.station.category));
                if (TextUtils.isEmpty(this.station.albumAbstract)) {
                    this.desc.setText(this.context.getString(R.string.music_desc_nothing));
                } else {
                    this.desc.setText(this.context.getString(R.string.music_desc, this.station.albumAbstract));
                }
                this.updateTime.setText(this.context.getString(R.string.music_update_time, SongViewHolder.updateTimeString(this.station.updateTime)));
                this.episodes.setText(this.context.getString(R.string.music_episodes, String.valueOf(this.station.episodes)));
                ImageView imageView = this.tagRich;
                if (this.station.saleType <= 0) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
        }

        public void onTrack(Remote.Response.PlayerStatus playerStatus) {
            this.playingMusicID = MusicHelper.getPlayingMusicID(playerStatus);
        }
    }

    public static class CollectStation extends ItemViewHolder.Lovable implements PlayerStatusTrack.onTrackListener {
        TextView author = ((TextView) this.itemView.findViewById(R.id.patchwall_item_author));
        TextView category = ((TextView) this.itemView.findViewById(R.id.item_category));
        private Context context;
        TextView desc = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        TextView episodes = ((TextView) this.itemView.findViewById(R.id.episodes));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        private String playingMusicID;
        private Music.Station station;
        ImageView tagRich = ((ImageView) this.itemView.findViewById(R.id.tag_rich));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));
        TextView updateTime = ((TextView) this.itemView.findViewById(R.id.update_time));

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public CollectStation(ViewGroup viewGroup, boolean z, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_player_item_song_v2, viewGroup, false), onItemClickListener, lovable);
            this.context = viewGroup.getContext();
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.viewholder.$$Lambda$SongViewHolder$CollectStation$xgGBpnXmGqKv4neUhZ5FtW9Y_I */

                public final void onClick(View view) {
                    SongViewHolder.CollectStation.this.lambda$new$0$SongViewHolder$CollectStation(view);
                }
            });
            if (z) {
                this.itemView.setBackgroundResource(R.drawable.bg_transparent_list_selector);
                this.title.setTextColor(viewGroup.getResources().getColorStateList(R.color.white_80_to_highlight_color));
                this.desc.setTextColor(viewGroup.getResources().getColorStateList(R.color.white_50_to_highlight_color));
            }
        }

        public /* synthetic */ void lambda$new$0$SongViewHolder$CollectStation(View view) {
            MusicHelper.processMusic(this.context, this.station);
        }

        public void bindView(Serializable serializable, String str) {
            if (serializable instanceof Music.Station) {
                this.station = (Music.Station) serializable;
                this.playingMusicID = str;
                MusicHelper.loadPatchWallCropSquareCover(this.station.cover, this.image, R.drawable.img_cover_default_rectangle, MusicHelper.getDefaultCornerRadius(this.context));
                this.title.setText(this.station.title);
                this.author.setText(this.station.cpNameOrBoradcaster());
                int i = 0;
                this.category.setText(this.context.getString(R.string.music_category, this.station.category));
                this.desc.setText(this.station.albumAbstract);
                this.updateTime.setText(this.context.getString(R.string.music_update_time, SongViewHolder.updateTimeString(this.station.updateTime)));
                this.episodes.setText(this.context.getString(R.string.music_episodes, String.valueOf(this.station.episodes)));
                ImageView imageView = this.tagRich;
                if (this.station.saleType <= 0) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
        }

        public void onTrack(Remote.Response.PlayerStatus playerStatus) {
            this.playingMusicID = MusicHelper.getPlayingMusicID(playerStatus);
        }
    }

    public static class Lovable extends ItemViewHolder.Lovable {
        TextView description;
        TextView itemId;
        ImageView note;
        TextView title;

        public Lovable(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            this(viewGroup, false, onItemClickListener, lovable);
        }

        public Lovable(ViewGroup viewGroup, boolean z, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(SongViewHolder.getItemView(viewGroup), onItemClickListener, lovable);
            this.note = (ImageView) this.itemView.findViewById(R.id.music_item_note);
            this.title = (TextView) this.itemView.findViewById(R.id.music_item_title);
            this.description = (TextView) this.itemView.findViewById(R.id.music_item_description);
            this.itemId = (TextView) this.itemView.findViewById(R.id.item_id);
            if (z) {
                this.itemView.setBackgroundResource(R.drawable.bg_transparent_list_selector);
                this.title.setTextColor(viewGroup.getResources().getColorStateList(R.color.white_80_to_highlight_color));
                this.description.setTextColor(viewGroup.getResources().getColorStateList(R.color.white_50_to_highlight_color));
            }
        }

        public void bindView(Serializable serializable, String str, int i) {
            boolean equals = CommonUtils.equals(MusicHelper.getID(serializable), str);
            SongViewHolder.bindView(serializable, equals, MusicHelper.isLegal(serializable), this.note, this.title, this.description);
            this.itemId.setText(String.valueOf(i + 1));
            this.itemId.setVisibility(equals ? 8 : 0);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.viewholder.SongViewHolder.bindView(com.xiaomi.mico.api.model.Remote$Response$Directive, boolean, boolean, android.widget.ImageView, android.widget.TextView, android.widget.TextView):void
         arg types: [com.xiaomi.mico.api.model.Remote$Response$Directive, boolean, int, android.widget.ImageView, android.widget.TextView, android.widget.TextView]
         candidates:
          com.xiaomi.mico.music.viewholder.SongViewHolder.bindView(java.io.Serializable, boolean, boolean, android.widget.ImageView, android.widget.TextView, android.widget.TextView):void
          com.xiaomi.mico.music.viewholder.SongViewHolder.bindView(com.xiaomi.mico.api.model.Remote$Response$Directive, boolean, boolean, android.widget.ImageView, android.widget.TextView, android.widget.TextView):void */
        public void bindView(Remote.Response.Directive directive, Remote.Response.Directive directive2, int i) {
            boolean equals = CommonUtils.equals(directive, directive2);
            SongViewHolder.bindView(directive, equals, true, this.note, this.title, this.description);
            this.itemId.setText(String.valueOf(i + 1));
            this.itemId.setVisibility(equals ? 8 : 0);
        }
    }

    public static class EditableStation extends ItemViewHolder.Editable {
        TextView author = ((TextView) this.itemView.findViewById(R.id.patchwall_item_author));
        TextView category = ((TextView) this.itemView.findViewById(R.id.item_category));
        public Context context;
        TextView desc = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        TextView episodes = ((TextView) this.itemView.findViewById(R.id.episodes));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        private String playingMusicID;
        public Music.Station station;
        ImageView tagRich = ((ImageView) this.itemView.findViewById(R.id.tag_rich));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));
        TextView updateTime = ((TextView) this.itemView.findViewById(R.id.update_time));

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public EditableStation(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_player_item_song_v2, viewGroup, false), onItemClickListener, lovable);
            this.context = viewGroup.getContext();
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.viewholder.SongViewHolder.EditableStation.AnonymousClass1 */

                public void onClick(View view) {
                    MusicHelper.processMusic(EditableStation.this.context, EditableStation.this.station);
                }
            });
        }

        public void bindView(Serializable serializable, String str, int i) {
            if (serializable instanceof Music.Station) {
                this.station = (Music.Station) serializable;
                this.playingMusicID = str;
                MusicHelper.loadPatchWallCropSquareCover(this.station.cover, this.image, R.drawable.img_cover_default_rectangle, MusicHelper.getDefaultCornerRadius(this.context));
                this.title.setText(this.station.title);
                this.author.setText(this.station.cpNameOrBoradcaster());
                int i2 = 0;
                this.category.setText(this.context.getString(R.string.music_category, this.station.category));
                this.desc.setText(this.station.albumAbstract);
                this.updateTime.setText(this.context.getString(R.string.music_update_time, SongViewHolder.updateTimeString(this.station.updateTime)));
                this.episodes.setText(this.context.getString(R.string.music_episodes, String.valueOf(this.station.episodes)));
                ImageView imageView = this.tagRich;
                if (this.station.saleType <= 0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public static class Editable extends ItemViewHolder.Editable {
        TextView description = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        TextView itemId = ((TextView) this.itemView.findViewById(R.id.item_id));
        ImageView note = ((ImageView) this.itemView.findViewById(R.id.music_item_note));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));

        public Editable(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(SongViewHolder.getItemView(viewGroup), onItemClickListener, lovable);
        }

        public void bindView(Serializable serializable, String str, int i) {
            boolean equals = CommonUtils.equals(MusicHelper.getID(serializable), str);
            boolean isLegal = MusicHelper.isLegal(serializable);
            int i2 = 0;
            super.bindView(serializable, equals || isLegal);
            SongViewHolder.bindView(serializable, equals, isLegal, this.note, this.title, this.description);
            this.itemId.setText(String.valueOf(i + 1));
            TextView textView = this.itemId;
            if (equals) {
                i2 = 8;
            }
            textView.setVisibility(i2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static View getItemView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_item_song, viewGroup, false);
    }

    public static void bindView(Serializable serializable, boolean z, boolean z2, ImageView imageView, TextView textView, TextView textView2) {
        updatePlayingStatus(z, z2, imageView, textView, textView2);
        MusicHelper.fillItem(serializable, textView, textView2);
    }

    public static void bindView(Remote.Response.Directive directive, boolean z, boolean z2, ImageView imageView, TextView textView, TextView textView2) {
        updatePlayingStatus(z, z2, imageView, textView, textView2);
        MusicHelper.fillItem(directive.title, null, directive.cover, textView, textView2, null, false);
    }

    private static void updatePlayingStatus(boolean z, boolean z2, ImageView imageView, TextView textView, TextView textView2) {
        imageView.setVisibility(z ? 0 : 8);
        textView.setSelected(z);
        textView2.setSelected(z);
        boolean z3 = true;
        textView.setEnabled(z || z2);
        if (!z && !z2) {
            z3 = false;
        }
        textView2.setEnabled(z3);
    }

    public static class PlayerListViewHolder extends ItemClickableAdapter.ViewHolder {
        private final Context context;
        TextView description = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        View listItem = this.itemView.findViewById(R.id.player_list_item);
        ImageView note = ((ImageView) this.itemView.findViewById(R.id.music_item_note));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));

        public PlayerListViewHolder(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(view, onItemClickListener);
            this.context = view.getContext();
        }

        public void bindView(Serializable serializable, String str, int i) {
            boolean equals = CommonUtils.equals(MusicHelper.getID(serializable), str);
            boolean isLegal = MusicHelper.isLegal(serializable);
            boolean isVipSong = MusicHelper.isVipSong(serializable);
            updatePlayingStatus(equals, isLegal);
            fillItem(MusicHelper.getTitle(serializable), MusicHelper.getSinger(serializable), isVipSong);
        }

        public void bindView(Remote.Response.Directive directive, Remote.Response.Directive directive2, int i) {
            updatePlayingStatus(CommonUtils.equals(directive, directive2), true);
            fillItem(directive.title, null, false);
        }

        private void updatePlayingStatus(boolean z, boolean z2) {
            boolean z3 = false;
            this.note.setVisibility(z ? 0 : 8);
            this.title.setSelected(z);
            this.description.setSelected(z);
            this.title.setEnabled(z || z2);
            TextView textView = this.description;
            if (z || z2) {
                z3 = true;
            }
            textView.setEnabled(z3);
        }

        @SuppressLint({"SetTextI18n"})
        private void fillItem(CharSequence charSequence, CharSequence charSequence2, boolean z) {
            Drawable drawable;
            if (this.title != null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.title.setText(charSequence);
                } else {
                    this.title.setText((int) R.string.mico_music_directive_default_title);
                }
            }
            if (this.description != null) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    this.description.setVisibility(0);
                    this.description.setText(" - ".concat(String.valueOf(charSequence2)));
                } else {
                    this.description.setVisibility(8);
                }
                if (z) {
                    drawable = this.context.getResources().getDrawable(R.drawable.mico_icon_vip);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                } else {
                    drawable = null;
                }
                this.description.setCompoundDrawables(null, null, drawable, null);
            }
        }
    }

    public static String updateTimeString(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }
}
