package _m_j;

import com.xiaomi.smarthome.framework.statistic.BindStep;

public interface hvc {
    void clearBindStep(String str);

    void endBindStep(String str, BindStep bindStep);

    void endBindStep(String str, BindStep bindStep, int i, String str2);

    void endBindStep(String str, BindStep bindStep, String str2);

    void initBindStep(String str, int i);

    void startBindStep(String str, BindStep bindStep);

    void uploadBindStep(String str);
}
