package _m_j;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public interface jdh {
    jdh addContextValue(String str, Object obj);

    List<Pair<String, Object>> getContextEntries();

    Set<String> getContextLabels();

    List<Object> getContextValues(String str);

    Object getFirstContextValue(String str);

    String getFormattedExceptionMessage(String str);

    jdh setContextValue(String str, Object obj);
}
