package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface EbmlProcessor {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException;

    void endMasterElement(int i) throws ParserException;

    void floatElement(int i, double d) throws ParserException;

    int getElementType(int i);

    void integerElement(int i, long j) throws ParserException;

    boolean isLevel1Element(int i);

    void startMasterElement(int i, long j, long j2) throws ParserException;

    void stringElement(int i, String str) throws ParserException;
}
