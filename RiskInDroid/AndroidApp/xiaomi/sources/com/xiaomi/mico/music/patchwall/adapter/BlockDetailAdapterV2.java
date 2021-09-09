package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.ListDetailActivity;
import com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2;
import com.xiaomi.mico.music.patchwall.decor.SpacingItemDecoration;
import com.xiaomi.mico.music.patchwall.group.EmptyGroup;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class BlockDetailAdapterV2 extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private List<Music.Station> allStations;
    private String blockTitle;
    private int categoryType;
    private Context context;
    private List<String> cpList;
    private List<Music.Station> mustListenStations;

    public int getItemCount() {
        return 5;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 5 : 4;
        }
        return 3;
    }

    public BlockDetailAdapterV2(Context context2, String str, int i, List<String> list) {
        this.context = context2;
        this.blockTitle = str;
        this.categoryType = i;
        this.cpList = list;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_detail_must_header, viewGroup, false), this.blockTitle, this.categoryType, this.cpList);
        }
        if (i == 3) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_header, viewGroup, false), this.blockTitle, this.categoryType, this.cpList);
        }
        if (i == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block, viewGroup, false);
            inflate.setFocusableInTouchMode(false);
            return new BlockViewHolder(this.context, inflate, false);
        } else if (i == 4) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block, viewGroup, false);
            inflate2.setFocusableInTouchMode(false);
            return new BlockViewHolder(this.context, inflate2, true);
        } else if (i == 5) {
            return new EmptyGroup.EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_channel_empty, viewGroup, false));
        } else {
            return null;
        }
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            ((HeaderViewHolder) o000OOo0).bindView("mustListen", this.context.getString(R.string.music_must_listen, this.blockTitle));
        } else if (itemViewType == 2) {
            ((BlockViewHolder) o000OOo0).bindView(this.mustListenStations);
        } else if (itemViewType == 3) {
            ((HeaderViewHolder) o000OOo0).bindView("all", this.context.getString(R.string.music_all_items, this.blockTitle));
        } else if (itemViewType == 4) {
            ((BlockViewHolder) o000OOo0).bindView(this.allStations);
        }
    }

    public void updateUiTypeAndDataList(String str, List<Music.Station> list) {
        if (str.equals("mustListen")) {
            this.mustListenStations = list;
        } else if (str.equals("all")) {
            this.allStations = list;
        }
        notifyDataSetChanged();
    }

    static class HeaderViewHolder extends RecyclerView.O000OOo0 {
        private String blockTitle;
        private int categoryType;
        private List<String> cpList;
        ImageView more;
        TextView title;

        public HeaderViewHolder(View view, String str, int i, List<String> list) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.patchwall_header_title);
            this.more = (ImageView) view.findViewById(R.id.patchwall_header_more);
            this.more.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$BlockDetailAdapterV2$HeaderViewHolder$sroQTi_o1HBptczn5ha8_47RVLY */

                public final void onClick(View view) {
                    BlockDetailAdapterV2.HeaderViewHolder.this.lambda$new$0$BlockDetailAdapterV2$HeaderViewHolder(view);
                }
            });
            this.blockTitle = str;
            this.categoryType = i;
            this.cpList = list;
        }

        public /* synthetic */ void lambda$new$0$BlockDetailAdapterV2$HeaderViewHolder(View view) {
            onClick();
        }

        /* access modifiers changed from: package-private */
        public void onClick() {
            if (this.more.getVisibility() == 0) {
                Intent intent = new Intent(this.itemView.getContext(), ListDetailActivity.class);
                intent.putExtra("block_title", this.blockTitle);
                intent.putExtra("block_category_type", this.categoryType);
                intent.putStringArrayListExtra("block_cp_list", (ArrayList) this.cpList);
                intent.putExtra("block_type", "type");
                this.itemView.getContext().startActivity(intent);
            }
        }

        public void bindView(String str, String str2) {
            this.title.setText(str2);
            this.more.setVisibility(str.equals("mustListen") ? 0 : 8);
        }
    }

    static class BlockViewHolder extends RecyclerView.O000OOo0 {
        private static int imageWidth;
        private BlockAdapter blockAdapter;
        RecyclerView recyclerView;
        List<Music.Station> stations;

        public BlockViewHolder(Context context, View view, boolean z) {
            super(view);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
            this.recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
            this.recyclerView.addItemDecoration(new SpacingItemDecoration(3, view.getContext().getResources().getDimensionPixelSize(R.dimen.mico_common_space_decoration), false, DisplayUtils.dip2px(context, 10.0f)));
            this.recyclerView.setHasFixedSize(false);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setNestedScrollingEnabled(false);
            imageWidth = ((DisplayUtils.getScreenWidthPixels(context) - (DisplayUtils.dip2px(context, 6.0f) * 2)) - DisplayUtils.dip2px(context, 30.0f)) / 3;
        }

        public void bindView(List<Music.Station> list) {
            this.stations = list;
            BlockAdapter blockAdapter2 = this.blockAdapter;
            if (blockAdapter2 == null) {
                this.blockAdapter = new BlockAdapter(list);
                this.recyclerView.setAdapter(this.blockAdapter);
                return;
            }
            blockAdapter2.updateData(list);
        }

        static class BlockAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
            List<Music.Station> stations;

            public BlockAdapter(List<Music.Station> list) {
                this.stations = list;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new BlockItemViewHolder(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_classify_block_item, viewGroup, false));
            }

            public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ((BlockItemViewHolder) o000OOo0).bindView(this.stations.get(i));
            }

            public int getItemCount() {
                List<Music.Station> list = this.stations;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            /* access modifiers changed from: package-private */
            public void updateData(List<Music.Station> list) {
                List<Music.Station> list2 = this.stations;
                if (list2 == null) {
                    this.stations = new ArrayList();
                } else {
                    list2.clear();
                }
                if (list != null) {
                    this.stations.addAll(list);
                }
                notifyDataSetChanged();
            }

            static class BlockItemViewHolder extends RecyclerView.O000OOo0 {
                private Context context;
                ImageView image;
                View imageContain;
                Music.Station station;
                ImageView tagRich;
                TextView text;

                public BlockItemViewHolder(Context context2, View view) {
                    super(view);
                    this.image = (ImageView) view.findViewById(R.id.mico_classif_block_patchwall_item_image);
                    this.text = (TextView) view.findViewById(R.id.mico_classif_block_patchwall_item_text);
                    this.tagRich = (ImageView) view.findViewById(R.id.mico_classif_block_tag_rich);
                    this.imageContain = view.findViewById(R.id.mico_classif_block_patchwall_item);
                    this.context = context2;
                    ButterKnife.bind(this, view);
                    view.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0037: INVOKE  
                          (r3v0 'view' android.view.View)
                          (wrap: com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k : 0x0034: CONSTRUCTOR  (r2v1 com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k) = 
                          (r1v0 'this' com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder A[THIS])
                          (r3v0 'view' android.view.View)
                         call: com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k.<init>(com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder, android.view.View):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2.BlockViewHolder.BlockAdapter.BlockItemViewHolder.<init>(android.content.Context, android.view.View):void, dex: classes4.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: CONSTRUCTOR  (r2v1 com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k) = 
                          (r1v0 'this' com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder A[THIS])
                          (r3v0 'view' android.view.View)
                         call: com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k.<init>(com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder, android.view.View):void type: CONSTRUCTOR in method: com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2.BlockViewHolder.BlockAdapter.BlockItemViewHolder.<init>(android.content.Context, android.view.View):void, dex: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 79 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 85 more
                        */
                    /*
                        this = this;
                        r1.<init>(r3)
                        r0 = 2132151460(0x7f160ca4, float:1.9944983E38)
                        android.view.View r0 = r3.findViewById(r0)
                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                        r1.image = r0
                        r0 = 2132151461(0x7f160ca5, float:1.9944985E38)
                        android.view.View r0 = r3.findViewById(r0)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        r1.text = r0
                        r0 = 2132151462(0x7f160ca6, float:1.9944987E38)
                        android.view.View r0 = r3.findViewById(r0)
                        android.widget.ImageView r0 = (android.widget.ImageView) r0
                        r1.tagRich = r0
                        r0 = 2132151459(0x7f160ca3, float:1.9944981E38)
                        android.view.View r0 = r3.findViewById(r0)
                        r1.imageContain = r0
                        r1.context = r2
                        butterknife.ButterKnife.bind(r1, r3)
                        com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k r2 = new com.xiaomi.mico.music.patchwall.adapter.-$$Lambda$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder$4hZYLd9ZXMl8CIOd41bFMxuSk2k
                        r2.<init>(r1, r3)
                        r3.setOnClickListener(r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapterV2.BlockViewHolder.BlockAdapter.BlockItemViewHolder.<init>(android.content.Context, android.view.View):void");
                }

                public /* synthetic */ void lambda$new$0$BlockDetailAdapterV2$BlockViewHolder$BlockAdapter$BlockItemViewHolder(View view, View view2) {
                    MusicHelper.processMusic(view.getContext(), this.station);
                }

                /* access modifiers changed from: package-private */
                public void bindView(Music.Station station2) {
                    this.station = station2;
                    MusicHelper.loadPatchWallCropSquareCover(station2.cover, this.image, (int) R.drawable.mico_cover_patchwall_default_small_rectangle, (int) R.drawable.mico_cover_patchwall_default_small_rectangle, MusicHelper.getDefaultCornerRadius(this.context));
                    this.tagRich.setVisibility(station2.saleType > 0 ? 0 : 8);
                    this.text.setVisibility(0);
                    this.text.setText(station2.title);
                }
            }
        }
    }
}
