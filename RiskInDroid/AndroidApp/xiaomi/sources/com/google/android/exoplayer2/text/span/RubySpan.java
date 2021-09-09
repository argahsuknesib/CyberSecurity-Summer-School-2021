package com.google.android.exoplayer2.text.span;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RubySpan {
    public final int position;
    public final String rubyText;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    public RubySpan(String str, int i) {
        this.rubyText = str;
        this.position = i;
    }
}
