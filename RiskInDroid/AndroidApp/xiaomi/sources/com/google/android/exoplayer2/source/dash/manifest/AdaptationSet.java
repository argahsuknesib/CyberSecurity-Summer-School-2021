package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class AdaptationSet {
    public final List<Descriptor> accessibilityDescriptors;
    public final List<Descriptor> essentialProperties;
    public final int id;
    public final List<Representation> representations;
    public final List<Descriptor> supplementalProperties;
    public final int type;

    public AdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        this.id = i;
        this.type = i2;
        this.representations = Collections.unmodifiableList(list);
        this.accessibilityDescriptors = Collections.unmodifiableList(list2);
        this.essentialProperties = Collections.unmodifiableList(list3);
        this.supplementalProperties = Collections.unmodifiableList(list4);
    }
}
