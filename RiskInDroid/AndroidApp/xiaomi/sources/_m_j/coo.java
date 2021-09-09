package _m_j;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

public interface coo {
    void onLoadingCancelled(String str, View view);

    void onLoadingComplete(String str, View view, Bitmap bitmap);

    void onLoadingFailed(String str, View view, FailReason failReason);

    void onLoadingStarted(String str, View view);
}
