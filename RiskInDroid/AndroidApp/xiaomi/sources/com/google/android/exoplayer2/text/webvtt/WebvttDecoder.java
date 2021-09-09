package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;

public final class WebvttDecoder extends SimpleSubtitleDecoder {
    private final CssParser cssParser = new CssParser();
    private final ParsableByteArray parsableWebvttData = new ParsableByteArray();

    public WebvttDecoder() {
        super("WebvttDecoder");
    }

    public final Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        WebvttCueInfo parseCue;
        this.parsableWebvttData.reset(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
            do {
            } while (!TextUtils.isEmpty(this.parsableWebvttData.readLine()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int nextEvent = getNextEvent(this.parsableWebvttData);
                if (nextEvent == 0) {
                    return new WebvttSubtitle(arrayList2);
                }
                if (nextEvent == 1) {
                    skipComment(this.parsableWebvttData);
                } else if (nextEvent == 2) {
                    if (arrayList2.isEmpty()) {
                        this.parsableWebvttData.readLine();
                        arrayList.addAll(this.cssParser.parseBlock(this.parsableWebvttData));
                    } else {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                } else if (nextEvent == 3 && (parseCue = WebvttCueParser.parseCue(this.parsableWebvttData, arrayList)) != null) {
                    arrayList2.add(parseCue);
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }

    private static int getNextEvent(ParsableByteArray parsableByteArray) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = parsableByteArray.getPosition();
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                i = 0;
            } else if ("STYLE".equals(readLine)) {
                i = 2;
            } else {
                i = readLine.startsWith("NOTE") ? 1 : 3;
            }
        }
        parsableByteArray.setPosition(i2);
        return i;
    }

    private static void skipComment(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
    }
}
