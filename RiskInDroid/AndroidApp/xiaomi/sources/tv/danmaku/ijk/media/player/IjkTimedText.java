package tv.danmaku.ijk.media.player;

import android.graphics.Rect;

public final class IjkTimedText {
    private Rect mTextBounds = null;
    private String mTextChars = null;

    public IjkTimedText(Rect rect, String str) {
        this.mTextBounds = rect;
        this.mTextChars = str;
    }

    public final Rect getBounds() {
        return this.mTextBounds;
    }

    public final String getText() {
        return this.mTextChars;
    }
}
