package com.mi.blockcanary.ui;

import _m_j.byj;
import java.util.Locale;

public class BlockInfoCorruptException extends Exception {
    public BlockInfoCorruptException(byj byj) {
        this(String.format(Locale.US, "BlockInfo (%s) is corrupt.", byj.O0000oOO.getName()));
    }

    public BlockInfoCorruptException(String str) {
        super(str);
    }
}
