package com.airbnb.lottie.model.content;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;

public class MergePaths implements ContentModel {
    private final MergePathsMode mode;
    private final String name;

    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return Merge;
            }
            if (i == 2) {
                return Add;
            }
            if (i == 3) {
                return Subtract;
            }
            if (i == 4) {
                return Intersect;
            }
            if (i != 5) {
                return Merge;
            }
            return ExcludeIntersections;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.name = str;
        this.mode = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode getMode() {
        return this.mode;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (lottieDrawable.enableMergePathsForKitKatAndAbove()) {
            return new MergePathsContent(this);
        }
        L.warn("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.mode + '}';
    }
}
