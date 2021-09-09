package com.facebook.rebound;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpringChain implements SpringListener {
    private static int id = 0;
    private static final SpringConfigRegistry registry = SpringConfigRegistry.getInstance();
    private final SpringConfig mAttachmentSpringConfig;
    private int mControlSpringIndex;
    private final CopyOnWriteArrayList<SpringListener> mListeners;
    private final SpringConfig mMainSpringConfig;
    private final SpringSystem mSpringSystem;
    private final CopyOnWriteArrayList<Spring> mSprings;

    public static SpringChain create() {
        return new SpringChain();
    }

    public static SpringChain create(int i, int i2, int i3, int i4) {
        return new SpringChain(i, i2, i3, i4);
    }

    private SpringChain() {
        this(40, 6, 70, 10);
    }

    private SpringChain(int i, int i2, int i3, int i4) {
        this.mSpringSystem = SpringSystem.create();
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mSprings = new CopyOnWriteArrayList<>();
        this.mControlSpringIndex = -1;
        this.mMainSpringConfig = SpringConfig.fromOrigamiTensionAndFriction((double) i, (double) i2);
        this.mAttachmentSpringConfig = SpringConfig.fromOrigamiTensionAndFriction((double) i3, (double) i4);
        SpringConfigRegistry springConfigRegistry = registry;
        SpringConfig springConfig = this.mMainSpringConfig;
        StringBuilder sb = new StringBuilder("main spring ");
        int i5 = id;
        id = i5 + 1;
        sb.append(i5);
        springConfigRegistry.addSpringConfig(springConfig, sb.toString());
        SpringConfigRegistry springConfigRegistry2 = registry;
        SpringConfig springConfig2 = this.mAttachmentSpringConfig;
        StringBuilder sb2 = new StringBuilder("attachment spring ");
        int i6 = id;
        id = i6 + 1;
        sb2.append(i6);
        springConfigRegistry2.addSpringConfig(springConfig2, sb2.toString());
    }

    public SpringConfig getMainSpringConfig() {
        return this.mMainSpringConfig;
    }

    public SpringConfig getAttachmentSpringConfig() {
        return this.mAttachmentSpringConfig;
    }

    public SpringChain addSpring(SpringListener springListener) {
        this.mSprings.add(this.mSpringSystem.createSpring().addListener(this).setSpringConfig(this.mAttachmentSpringConfig));
        this.mListeners.add(springListener);
        return this;
    }

    public SpringChain setControlSpringIndex(int i) {
        this.mControlSpringIndex = i;
        if (this.mSprings.get(this.mControlSpringIndex) == null) {
            return null;
        }
        for (Spring springConfig : this.mSpringSystem.getAllSprings()) {
            springConfig.setSpringConfig(this.mAttachmentSpringConfig);
        }
        getControlSpring().setSpringConfig(this.mMainSpringConfig);
        return this;
    }

    public Spring getControlSpring() {
        return this.mSprings.get(this.mControlSpringIndex);
    }

    public List<Spring> getAllSprings() {
        return this.mSprings;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 > r2) goto L_0x0015;
     */
    public void onSpringUpdate(Spring spring) {
        int i;
        int indexOf = this.mSprings.indexOf(spring);
        SpringListener springListener = this.mListeners.get(indexOf);
        int i2 = this.mControlSpringIndex;
        int i3 = -1;
        if (indexOf == i2) {
            i3 = indexOf - 1;
        } else {
            if (indexOf < i2) {
                i3 = indexOf - 1;
            }
            i = -1;
            if (i >= 0 && i < this.mSprings.size()) {
                this.mSprings.get(i).setEndValue(spring.getCurrentValue());
            }
            if (i3 >= 0 && i3 < this.mSprings.size()) {
                this.mSprings.get(i3).setEndValue(spring.getCurrentValue());
            }
            springListener.onSpringUpdate(spring);
        }
        i = indexOf + 1;
        this.mSprings.get(i).setEndValue(spring.getCurrentValue());
        this.mSprings.get(i3).setEndValue(spring.getCurrentValue());
        springListener.onSpringUpdate(spring);
    }

    public void onSpringAtRest(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringAtRest(spring);
    }

    public void onSpringActivate(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringActivate(spring);
    }

    public void onSpringEndStateChange(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringEndStateChange(spring);
    }
}
