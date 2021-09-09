package com.squareup.okhttp.internal.framed;

import _m_j.jay;
import _m_j.jaz;
import com.squareup.okhttp.Protocol;

public interface Variant {
    Protocol getProtocol();

    FrameReader newReader(jaz jaz, boolean z);

    FrameWriter newWriter(jay jay, boolean z);
}
