package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.view.LayoutInflaterCompatBase;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

@TargetApi(11)
@RequiresApi(11)
class LayoutInflaterCompatHC {
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    LayoutInflaterCompatHC() {
    }

    static class FactoryWrapperHC extends LayoutInflaterCompatBase.FactoryWrapper implements LayoutInflater.Factory2 {
        FactoryWrapperHC(LayoutInflaterFactory layoutInflaterFactory) {
            super(layoutInflaterFactory);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
        }
    }

    static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        FactoryWrapperHC factoryWrapperHC = layoutInflaterFactory != null ? new FactoryWrapperHC(layoutInflaterFactory) : null;
        layoutInflater.setFactory2(factoryWrapperHC);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            forceSetFactory2(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            forceSetFactory2(layoutInflater, factoryWrapperHC);
        }
    }

    static void forceSetFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!sCheckedField) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            sCheckedField = true;
        }
        Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
