package _m_j;

import java.io.PrintWriter;

public interface jda {
    Throwable getCause();

    String getMessage(int i);

    void printPartialStackTrace(PrintWriter printWriter);
}
