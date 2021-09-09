package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {
    private List<TtmlNode> children;
    public final long endTimeUs;
    public final String imageId;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final TtmlNode parent;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    public static TtmlNode buildTextNode(String str) {
        return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static TtmlNode buildNode(String str, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str2, String str3, TtmlNode ttmlNode) {
        return new TtmlNode(str, null, j, j2, ttmlStyle, strArr, str2, str3, ttmlNode);
    }

    private TtmlNode(String str, String str2, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str3, String str4, TtmlNode ttmlNode) {
        this.tag = str;
        this.text = str2;
        this.imageId = str4;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        this.isTextNode = str2 != null;
        this.startTimeUs = j;
        this.endTimeUs = j2;
        this.regionId = (String) Assertions.checkNotNull(str3);
        this.parent = ttmlNode;
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    public final boolean isActive(long j) {
        if (this.startTimeUs == -9223372036854775807L && this.endTimeUs == -9223372036854775807L) {
            return true;
        }
        if (this.startTimeUs <= j && this.endTimeUs == -9223372036854775807L) {
            return true;
        }
        if (this.startTimeUs != -9223372036854775807L || j >= this.endTimeUs) {
            return this.startTimeUs <= j && j < this.endTimeUs;
        }
        return true;
    }

    public final void addChild(TtmlNode ttmlNode) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public final TtmlNode getChild(int i) {
        List<TtmlNode> list = this.children;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int getChildCount() {
        List<TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final long[] getEventTimesUs() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    private void getEventTimes(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.tag);
        boolean equals2 = "div".equals(this.tag);
        if (z || equals || (equals2 && this.imageId != null)) {
            long j = this.startTimeUs;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.children != null) {
            for (int i = 0; i < this.children.size(); i++) {
                this.children.get(i).getEventTimes(treeSet, z || equals);
            }
        }
    }

    public final String[] getStyleIds() {
        return this.styleIds;
    }

    public final List<Cue> getCues(long j, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        traverseForImage(j, this.regionId, arrayList);
        TreeMap treeMap = new TreeMap();
        traverseForText(j, false, this.regionId, treeMap);
        traverseForStyle(j, map, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) Assertions.checkNotNull(map2.get(pair.first));
                arrayList2.add(new Cue.Builder().setBitmap(decodeByteArray).setPosition(ttmlRegion.position).setPositionAnchor(0).setLine(ttmlRegion.line, 0).setLineAnchor(ttmlRegion.lineAnchor).setSize(ttmlRegion.width).setBitmapHeight(ttmlRegion.height).build());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) Assertions.checkNotNull(map2.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            cleanUpText((SpannableStringBuilder) Assertions.checkNotNull(builder.getText()));
            builder.setLine(ttmlRegion2.line, ttmlRegion2.lineType);
            builder.setLineAnchor(ttmlRegion2.lineAnchor);
            builder.setPosition(ttmlRegion2.position);
            builder.setSize(ttmlRegion2.width);
            builder.setTextSize(ttmlRegion2.textSize, ttmlRegion2.textSizeType);
            arrayList2.add(builder.build());
        }
        return arrayList2;
    }

    private void traverseForImage(long j, String str, List<Pair<String, String>> list) {
        String str2;
        if (!"".equals(this.regionId)) {
            str = this.regionId;
        }
        if (!isActive(j) || !"div".equals(this.tag) || (str2 = this.imageId) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                getChild(i).traverseForImage(j, str, list);
            }
            return;
        }
        list.add(new Pair(str, str2));
    }

    private void traverseForText(long j, boolean z, String str, Map<String, Cue.Builder> map) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if (!"metadata".equals(this.tag)) {
            if (!"".equals(this.regionId)) {
                str = this.regionId;
            }
            if (this.isTextNode && z) {
                getRegionOutputText(str, map).append((CharSequence) Assertions.checkNotNull(this.text));
            } else if ("br".equals(this.tag) && z) {
                getRegionOutputText(str, map).append(10);
            } else if (isActive(j)) {
                for (Map.Entry next : map.entrySet()) {
                    this.nodeStartsByRegion.put(next.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(((Cue.Builder) next.getValue()).getText())).length()));
                }
                boolean equals = "p".equals(this.tag);
                for (int i = 0; i < getChildCount(); i++) {
                    getChild(i).traverseForText(j, z || equals, str, map);
                }
                if (equals) {
                    TtmlRenderUtil.endParagraph(getRegionOutputText(str, map));
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.nodeEndsByRegion.put(next2.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(((Cue.Builder) next2.getValue()).getText())).length()));
                }
            }
        }
    }

    private static SpannableStringBuilder getRegionOutputText(String str, Map<String, Cue.Builder> map) {
        if (!map.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.setText(new SpannableStringBuilder());
            map.put(str, builder);
        }
        return (SpannableStringBuilder) Assertions.checkNotNull(map.get(str).getText());
    }

    private void traverseForStyle(long j, Map<String, TtmlStyle> map, Map<String, Cue.Builder> map2) {
        int i;
        if (isActive(j)) {
            Iterator<Map.Entry<String, Integer>> it = this.nodeEndsByRegion.entrySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                if (this.nodeStartsByRegion.containsKey(str)) {
                    i = this.nodeStartsByRegion.get(str).intValue();
                }
                int intValue = ((Integer) next.getValue()).intValue();
                if (i != intValue) {
                    applyStyleToOutput(map, (Cue.Builder) Assertions.checkNotNull(map2.get(str)), i, intValue);
                }
            }
            while (i < getChildCount()) {
                getChild(i).traverseForStyle(j, map, map2);
                i++;
            }
        }
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> map, Cue.Builder builder, int i, int i2) {
        TtmlStyle resolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.getText();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            builder.setText(spannableStringBuilder);
        }
        if (resolveStyle != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, i, i2, resolveStyle, this.parent);
            builder.setVerticalType(resolveStyle.getVerticalType());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.text.SpannableStringBuilder.replace(int, int, java.lang.CharSequence):android.text.SpannableStringBuilder}
     arg types: [int, int, java.lang.String]
     candidates:
      ClspMth{android.text.SpannableStringBuilder.replace(int, int, java.lang.CharSequence):android.text.Editable}
      ClspMth{android.text.SpannableStringBuilder.replace(int, int, java.lang.CharSequence):android.text.SpannableStringBuilder} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.text.SpannableStringBuilder.delete(int, int):android.text.SpannableStringBuilder}
     arg types: [int, int]
     candidates:
      ClspMth{android.text.SpannableStringBuilder.delete(int, int):android.text.Editable}
      ClspMth{android.text.SpannableStringBuilder.delete(int, int):android.text.SpannableStringBuilder} */
    private static void cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), (CharSequence) "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == 10) {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == 10) {
                    spannableStringBuilder.delete(i7, i8);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }
}
