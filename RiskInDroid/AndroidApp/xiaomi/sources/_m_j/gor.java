package _m_j;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

@SuppressLint({"NewApi"})
public abstract class gor {
    public static <Params, Progress, Result> void O000000o(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(goq.O00000Oo(), paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
    }
}
