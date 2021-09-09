package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public class MergePathsContent implements GreedyContent, PathContent {
    private final Path firstPath = new Path();
    private final MergePaths mergePaths;
    private final String name;
    private final Path path = new Path();
    private final List<PathContent> pathContents = new ArrayList();
    private final Path remainderPath = new Path();

    public MergePathsContent(MergePaths mergePaths2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.name = mergePaths2.getName();
            this.mergePaths = mergePaths2;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    public void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof PathContent) {
                this.pathContents.add((PathContent) previous);
                listIterator.remove();
            }
        }
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.pathContents.get(i).setContents(list, list2);
        }
    }

    public Path getPath() {
        this.path.reset();
        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[this.mergePaths.getMode().ordinal()];
        if (i == 1) {
            addPaths();
        } else if (i == 2) {
            opFirstPathWithRest(Path.Op.UNION);
        } else if (i == 3) {
            opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            opFirstPathWithRest(Path.Op.INTERSECT);
        } else if (i == 5) {
            opFirstPathWithRest(Path.Op.XOR);
        }
        return this.path;
    }

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode = new int[MergePaths.MergePathsMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
        }
    }

    public String getName() {
        return this.name;
    }

    private void addPaths() {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.path.addPath(this.pathContents.get(i).getPath());
        }
    }

    @TargetApi(19)
    private void opFirstPathWithRest(Path.Op op) {
        this.remainderPath.reset();
        this.firstPath.reset();
        for (int size = this.pathContents.size() - 1; size > 0; size--) {
            PathContent pathContent = this.pathContents.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> pathList = contentGroup.getPathList();
                for (int size2 = pathList.size() - 1; size2 >= 0; size2--) {
                    Path path2 = pathList.get(size2).getPath();
                    path2.transform(contentGroup.getTransformationMatrix());
                    this.remainderPath.addPath(path2);
                }
            } else {
                this.remainderPath.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.pathContents.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> pathList2 = contentGroup2.getPathList();
            for (int i = 0; i < pathList2.size(); i++) {
                Path path3 = pathList2.get(i).getPath();
                path3.transform(contentGroup2.getTransformationMatrix());
                this.firstPath.addPath(path3);
            }
        } else {
            this.firstPath.set(pathContent2.getPath());
        }
        this.path.op(this.firstPath, this.remainderPath, op);
    }
}
