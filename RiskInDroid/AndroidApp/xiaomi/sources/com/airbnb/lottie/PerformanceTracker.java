package com.airbnb.lottie;

import _m_j.be;
import _m_j.o0O0OOOo;
import android.util.Log;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {
    private boolean enabled = false;
    private final Comparator<be<String, Float>> floatComparator = new Comparator<be<String, Float>>() {
        /* class com.airbnb.lottie.PerformanceTracker.AnonymousClass1 */

        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return compare((be<String, Float>) ((be) obj), (be<String, Float>) ((be) obj2));
        }

        public int compare(be<String, Float> beVar, be<String, Float> beVar2) {
            float floatValue = ((Float) beVar.O00000Oo).floatValue();
            float floatValue2 = ((Float) beVar2.O00000Oo).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };
    private final Set<FrameListener> frameListeners = new o0O0OOOo();
    private final Map<String, MeanCalculator> layerRenderTimes = new HashMap();

    public interface FrameListener {
        void onFrameRendered(float f);
    }

    /* access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void recordRenderTime(String str, float f) {
        if (this.enabled) {
            MeanCalculator meanCalculator = this.layerRenderTimes.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                this.layerRenderTimes.put(str, meanCalculator);
            }
            meanCalculator.add(f);
            if (str.equals("__container")) {
                for (FrameListener onFrameRendered : this.frameListeners) {
                    onFrameRendered.onFrameRendered(f);
                }
            }
        }
    }

    public void addFrameListener(FrameListener frameListener) {
        this.frameListeners.add(frameListener);
    }

    public void removeFrameListener(FrameListener frameListener) {
        this.frameListeners.add(frameListener);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public void logRenderTimes() {
        if (this.enabled) {
            List<be<String, Float>> sortedRenderTimes = getSortedRenderTimes();
            Log.d("LOTTIE", "Render times:");
            for (int i = 0; i < sortedRenderTimes.size(); i++) {
                be beVar = sortedRenderTimes.get(i);
                Log.d("LOTTIE", String.format("\t\t%30s:%.2f", beVar.f12896O000000o, beVar.O00000Oo));
            }
        }
    }

    public List<be<String, Float>> getSortedRenderTimes() {
        if (!this.enabled) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.layerRenderTimes.size());
        for (Map.Entry next : this.layerRenderTimes.entrySet()) {
            arrayList.add(new be(next.getKey(), Float.valueOf(((MeanCalculator) next.getValue()).getMean())));
        }
        Collections.sort(arrayList, this.floatComparator);
        return arrayList;
    }
}
