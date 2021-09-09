package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@GwtIncompatible
final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    JdkPattern(Pattern pattern2) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern2);
    }

    public final CommonMatcher matcher(CharSequence charSequence) {
        return new JdkMatcher(this.pattern.matcher(charSequence));
    }

    public final String pattern() {
        return this.pattern.pattern();
    }

    public final int flags() {
        return this.pattern.flags();
    }

    public final String toString() {
        return this.pattern.toString();
    }

    static final class JdkMatcher extends CommonMatcher {
        final Matcher matcher;

        JdkMatcher(Matcher matcher2) {
            this.matcher = (Matcher) Preconditions.checkNotNull(matcher2);
        }

        public final boolean matches() {
            return this.matcher.matches();
        }

        public final boolean find() {
            return this.matcher.find();
        }

        public final boolean find(int i) {
            return this.matcher.find(i);
        }

        public final String replaceAll(String str) {
            return this.matcher.replaceAll(str);
        }

        public final int end() {
            return this.matcher.end();
        }

        public final int start() {
            return this.matcher.start();
        }
    }
}
