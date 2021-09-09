package _m_j;

import android.os.Bundle;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class fr {

    public interface O000000o<D> {
        Loader<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(Loader<D> loader, D d);

        void onLoaderReset(Loader<D> loader);
    }

    public abstract <D> Loader<D> O000000o(O000000o o000000o);

    public abstract void O000000o();

    @Deprecated
    public abstract void O000000o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends fa & fq> fr O000000o(fa faVar) {
        return new fs(faVar, ((fq) faVar).getViewModelStore());
    }
}
