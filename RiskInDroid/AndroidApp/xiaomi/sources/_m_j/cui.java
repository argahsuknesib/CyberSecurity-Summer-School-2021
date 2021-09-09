package _m_j;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.util.HashMap;

public final class cui extends cuh {
    public cui(Fragment fragment, String str, HashMap<String, Object> hashMap) {
        super(fragment.getContext(), str, hashMap);
        O000000o("com.sankuai.waimai.router.activity.start_activity_action", new O000000o(fragment));
    }

    class O000000o implements cuf {
        private Fragment O00000Oo;

        public O000000o(Fragment fragment) {
            this.O00000Oo = fragment;
        }

        public final boolean O000000o(cvg cvg, Intent intent) throws ActivityNotFoundException, SecurityException {
            try {
                Bundle bundle = (Bundle) cvg.O000000o(Bundle.class, "com.sankuai.waimai.router.activity.options", null);
                Integer num = (Integer) cvg.O000000o(Integer.class, "com.sankuai.waimai.router.activity.request_code", null);
                if (num != null) {
                    this.O00000Oo.startActivityForResult(intent, num.intValue(), bundle);
                    return true;
                }
                this.O00000Oo.startActivity(intent, bundle);
                return true;
            } catch (ActivityNotFoundException unused) {
                cvb.O00000oO();
                return false;
            } catch (SecurityException unused2) {
                cvb.O00000oO();
                return false;
            }
        }
    }
}
