package _m_j;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;

public interface gte {
    void onAppDestroy(Application application);

    void onCreate(FragmentActivity fragmentActivity);

    void onDestroy(FragmentActivity fragmentActivity);
}
