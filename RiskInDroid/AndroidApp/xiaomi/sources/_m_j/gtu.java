package _m_j;

import com.xiaomi.smarthome.library.log.LogType;

public interface gtu extends gze {
    void writeLogOnAll(LogType logType, String str, String str2);

    void writeLogOnGrey(LogType logType, String str, String str2);
}
