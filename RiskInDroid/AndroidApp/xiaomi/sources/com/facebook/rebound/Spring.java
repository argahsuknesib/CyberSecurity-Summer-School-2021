package com.facebook.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Spring {
    private static int ID;
    private final PhysicsState mCurrentState = new PhysicsState();
    private double mDisplacementFromRestThreshold = 0.005d;
    private double mEndValue;
    private final String mId;
    private CopyOnWriteArraySet<SpringListener> mListeners = new CopyOnWriteArraySet<>();
    private boolean mOvershootClampingEnabled;
    private final PhysicsState mPreviousState = new PhysicsState();
    private double mRestSpeedThreshold = 0.005d;
    private SpringConfig mSpringConfig;
    private final BaseSpringSystem mSpringSystem;
    private double mStartValue;
    private final PhysicsState mTempState = new PhysicsState();
    private double mTimeAccumulator = 0.0d;
    private boolean mWasAtRest = true;

    static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }
    }

    Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem != null) {
            this.mSpringSystem = baseSpringSystem;
            StringBuilder sb = new StringBuilder("spring:");
            int i = ID;
            ID = i + 1;
            sb.append(i);
            this.mId = sb.toString();
            setSpringConfig(SpringConfig.defaultConfig);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    public void destroy() {
        this.mListeners.clear();
        this.mSpringSystem.deregisterSpring(this);
    }

    public String getId() {
        return this.mId;
    }

    public Spring setSpringConfig(SpringConfig springConfig) {
        if (springConfig != null) {
            this.mSpringConfig = springConfig;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public SpringConfig getSpringConfig() {
        return this.mSpringConfig;
    }

    public Spring setCurrentValue(double d) {
        return setCurrentValue(d, true);
    }

    public Spring setCurrentValue(double d, boolean z) {
        this.mStartValue = d;
        this.mCurrentState.position = d;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z) {
            setAtRest();
        }
        return this;
    }

    public double getStartValue() {
        return this.mStartValue;
    }

    public double getCurrentValue() {
        return this.mCurrentState.position;
    }

    public double getCurrentDisplacementDistance() {
        return getDisplacementDistanceForState(this.mCurrentState);
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    public Spring setEndValue(double d) {
        if (this.mEndValue == d && isAtRest()) {
            return this;
        }
        this.mStartValue = getCurrentValue();
        this.mEndValue = d;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringEndStateChange(this);
        }
        return this;
    }

    public double getEndValue() {
        return this.mEndValue;
    }

    public Spring setVelocity(double d) {
        if (d == this.mCurrentState.velocity) {
            return this;
        }
        this.mCurrentState.velocity = d;
        this.mSpringSystem.activateSpring(getId());
        return this;
    }

    public double getVelocity() {
        return this.mCurrentState.velocity;
    }

    public Spring setRestSpeedThreshold(double d) {
        this.mRestSpeedThreshold = d;
        return this;
    }

    public double getRestSpeedThreshold() {
        return this.mRestSpeedThreshold;
    }

    public Spring setRestDisplacementThreshold(double d) {
        this.mDisplacementFromRestThreshold = d;
        return this;
    }

    public double getRestDisplacementThreshold() {
        return this.mDisplacementFromRestThreshold;
    }

    public Spring setOvershootClampingEnabled(boolean z) {
        this.mOvershootClampingEnabled = z;
        return this;
    }

    public boolean isOvershootClampingEnabled() {
        return this.mOvershootClampingEnabled;
    }

    public boolean isOvershooting() {
        if (this.mSpringConfig.tension <= 0.0d) {
            return false;
        }
        if (this.mStartValue >= this.mEndValue || getCurrentValue() <= this.mEndValue) {
            return this.mStartValue > this.mEndValue && getCurrentValue() < this.mEndValue;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void advance(double d) {
        double d2;
        boolean z;
        boolean isAtRest = isAtRest();
        if (!isAtRest || !this.mWasAtRest) {
            double d3 = 0.064d;
            if (d <= 0.064d) {
                d3 = d;
            }
            this.mTimeAccumulator += d3;
            double d4 = this.mSpringConfig.tension;
            double d5 = this.mSpringConfig.friction;
            double d6 = this.mCurrentState.position;
            double d7 = this.mCurrentState.velocity;
            double d8 = this.mTempState.position;
            double d9 = this.mTempState.velocity;
            while (true) {
                d2 = this.mTimeAccumulator;
                if (d2 < 0.001d) {
                    break;
                }
                this.mTimeAccumulator = d2 - 0.001d;
                if (this.mTimeAccumulator < 0.001d) {
                    PhysicsState physicsState = this.mPreviousState;
                    physicsState.position = d6;
                    physicsState.velocity = d7;
                }
                double d10 = this.mEndValue;
                double d11 = ((d10 - d8) * d4) - (d5 * d7);
                double d12 = d7 + (d11 * 0.001d * 0.5d);
                double d13 = ((d10 - (((d7 * 0.001d) * 0.5d) + d6)) * d4) - (d5 * d12);
                double d14 = d7 + (d13 * 0.001d * 0.5d);
                double d15 = ((d10 - (d6 + ((d12 * 0.001d) * 0.5d))) * d4) - (d5 * d14);
                double d16 = d6 + (d14 * 0.001d);
                double d17 = d7 + (d15 * 0.001d);
                d6 += (d7 + ((d12 + d14) * 2.0d) + d17) * 0.16666666666666666d * 0.001d;
                d7 += (d11 + ((d13 + d15) * 2.0d) + (((d10 - d16) * d4) - (d5 * d17))) * 0.16666666666666666d * 0.001d;
                d8 = d16;
                d9 = d17;
            }
            PhysicsState physicsState2 = this.mTempState;
            physicsState2.position = d8;
            physicsState2.velocity = d9;
            PhysicsState physicsState3 = this.mCurrentState;
            physicsState3.position = d6;
            physicsState3.velocity = d7;
            if (d2 > 0.0d) {
                interpolate(d2 / 0.001d);
            }
            if (isAtRest() || (this.mOvershootClampingEnabled && isOvershooting())) {
                if (d4 > 0.0d) {
                    double d18 = this.mEndValue;
                    this.mStartValue = d18;
                    this.mCurrentState.position = d18;
                } else {
                    this.mEndValue = this.mCurrentState.position;
                    this.mStartValue = this.mEndValue;
                }
                setVelocity(0.0d);
                isAtRest = true;
            }
            boolean z2 = false;
            if (this.mWasAtRest) {
                this.mWasAtRest = false;
                z = true;
            } else {
                z = false;
            }
            if (isAtRest) {
                this.mWasAtRest = true;
                z2 = true;
            }
            Iterator<SpringListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                SpringListener next = it.next();
                if (z) {
                    next.onSpringActivate(this);
                }
                next.onSpringUpdate(this);
                if (z2) {
                    next.onSpringAtRest(this);
                }
            }
        }
    }

    public boolean systemShouldAdvance() {
        return !isAtRest() || !wasAtRest();
    }

    public boolean wasAtRest() {
        return this.mWasAtRest;
    }

    public boolean isAtRest() {
        if (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) {
            return getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mSpringConfig.tension == 0.0d;
        }
        return false;
    }

    public Spring setAtRest() {
        this.mEndValue = this.mCurrentState.position;
        this.mTempState.position = this.mCurrentState.position;
        this.mCurrentState.velocity = 0.0d;
        return this;
    }

    private void interpolate(double d) {
        PhysicsState physicsState = this.mCurrentState;
        double d2 = 1.0d - d;
        physicsState.position = (physicsState.position * d) + (this.mPreviousState.position * d2);
        PhysicsState physicsState2 = this.mCurrentState;
        physicsState2.velocity = (physicsState2.velocity * d) + (this.mPreviousState.velocity * d2);
    }

    public Spring addListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.add(springListener);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    public Spring removeListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.remove(springListener);
            return this;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }

    public Spring removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public boolean currentValueIsApproximately(double d) {
        return Math.abs(getCurrentValue() - d) <= getRestDisplacementThreshold();
    }
}
