package no.nordicsemi.android.dfu;

public interface DfuController {
    void abort();

    void pause();

    void resume();
}
