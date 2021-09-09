package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.app.NotificationCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DvbParser {
    private static final byte[] defaultMap2To4 = {0, 7, 8, 15};
    private static final byte[] defaultMap2To8 = {0, 119, -120, -1};
    private static final byte[] defaultMap4To8 = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas canvas;
    private final ClutDefinition defaultClutDefinition;
    private final DisplayDefinition defaultDisplayDefinition;
    private final Paint defaultPaint = new Paint();
    private final Paint fillRegionPaint;
    private final SubtitleService subtitleService;

    private static int getColor(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public DvbParser(int i, int i2) {
        this.defaultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.defaultPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.defaultPaint.setPathEffect(null);
        this.fillRegionPaint = new Paint();
        this.fillRegionPaint.setStyle(Paint.Style.FILL);
        this.fillRegionPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.fillRegionPaint.setPathEffect(null);
        this.canvas = new Canvas();
        this.defaultDisplayDefinition = new DisplayDefinition(719, 575, 0, 719, 0, 575);
        this.defaultClutDefinition = new ClutDefinition(0, generateDefault2BitClutEntries(), generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
        this.subtitleService = new SubtitleService(i, i2);
    }

    public final void reset() {
        this.subtitleService.reset();
    }

    public final List<Cue> decode(byte[] bArr, int i) {
        int i2;
        int i3;
        SparseArray<RegionObject> sparseArray;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            parseSubtitlingSegment(parsableBitArray, this.subtitleService);
        }
        PageComposition pageComposition = this.subtitleService.pageComposition;
        if (pageComposition == null) {
            return Collections.emptyList();
        }
        DisplayDefinition displayDefinition = this.subtitleService.displayDefinition != null ? this.subtitleService.displayDefinition : this.defaultDisplayDefinition;
        if (!(this.bitmap != null && displayDefinition.width + 1 == this.bitmap.getWidth() && displayDefinition.height + 1 == this.bitmap.getHeight())) {
            this.bitmap = Bitmap.createBitmap(displayDefinition.width + 1, displayDefinition.height + 1, Bitmap.Config.ARGB_8888);
            this.canvas.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray2 = pageComposition.regions;
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            this.canvas.save();
            PageRegion valueAt = sparseArray2.valueAt(i4);
            RegionComposition regionComposition = this.subtitleService.regions.get(sparseArray2.keyAt(i4));
            int i5 = valueAt.horizontalAddress + displayDefinition.horizontalPositionMinimum;
            int i6 = valueAt.verticalAddress + displayDefinition.verticalPositionMinimum;
            this.canvas.clipRect(i5, i6, Math.min(regionComposition.width + i5, displayDefinition.horizontalPositionMaximum), Math.min(regionComposition.height + i6, displayDefinition.verticalPositionMaximum));
            ClutDefinition clutDefinition = this.subtitleService.cluts.get(regionComposition.clutId);
            if (clutDefinition == null && (clutDefinition = this.subtitleService.ancillaryCluts.get(regionComposition.clutId)) == null) {
                clutDefinition = this.defaultClutDefinition;
            }
            SparseArray<RegionObject> sparseArray3 = regionComposition.regionObjects;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i7);
                RegionObject valueAt2 = sparseArray3.valueAt(i7);
                ObjectData objectData = this.subtitleService.objects.get(keyAt);
                ObjectData objectData2 = objectData == null ? this.subtitleService.ancillaryObjects.get(keyAt) : objectData;
                if (objectData2 != null) {
                    i3 = i7;
                    sparseArray = sparseArray3;
                    paintPixelDataSubBlocks(objectData2, clutDefinition, regionComposition.depth, valueAt2.horizontalPosition + i5, i6 + valueAt2.verticalPosition, objectData2.nonModifyingColorFlag ? null : this.defaultPaint, this.canvas);
                } else {
                    i3 = i7;
                    sparseArray = sparseArray3;
                }
                i7 = i3 + 1;
                sparseArray3 = sparseArray;
            }
            if (regionComposition.fillFlag) {
                if (regionComposition.depth == 3) {
                    i2 = clutDefinition.clutEntries8Bit[regionComposition.pixelCode8Bit];
                } else if (regionComposition.depth == 2) {
                    i2 = clutDefinition.clutEntries4Bit[regionComposition.pixelCode4Bit];
                } else {
                    i2 = clutDefinition.clutEntries2Bit[regionComposition.pixelCode2Bit];
                }
                this.fillRegionPaint.setColor(i2);
                this.canvas.drawRect((float) i5, (float) i6, (float) (regionComposition.width + i5), (float) (regionComposition.height + i6), this.fillRegionPaint);
            }
            arrayList.add(new Cue.Builder().setBitmap(Bitmap.createBitmap(this.bitmap, i5, i6, regionComposition.width, regionComposition.height)).setPosition(((float) i5) / ((float) displayDefinition.width)).setPositionAnchor(0).setLine(((float) i6) / ((float) displayDefinition.height), 0).setLineAnchor(0).setSize(((float) regionComposition.width) / ((float) displayDefinition.width)).setBitmapHeight(((float) regionComposition.height) / ((float) displayDefinition.height)).build());
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.canvas.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray, SubtitleService subtitleService2) {
        RegionComposition regionComposition;
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int bytePosition = parsableBitArray.getBytePosition() + readBits3;
        if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    PageComposition pageComposition = subtitleService2.pageComposition;
                    PageComposition parsePageComposition = parsePageComposition(parsableBitArray, readBits3);
                    if (parsePageComposition.state == 0) {
                        if (!(pageComposition == null || pageComposition.version == parsePageComposition.version)) {
                            subtitleService2.pageComposition = parsePageComposition;
                            break;
                        }
                    } else {
                        subtitleService2.pageComposition = parsePageComposition;
                        subtitleService2.regions.clear();
                        subtitleService2.cluts.clear();
                        subtitleService2.objects.clear();
                        break;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService2.pageComposition;
                if (readBits2 == subtitleService2.subtitlePageId && pageComposition2 != null) {
                    RegionComposition parseRegionComposition = parseRegionComposition(parsableBitArray, readBits3);
                    if (pageComposition2.state == 0 && (regionComposition = subtitleService2.regions.get(parseRegionComposition.id)) != null) {
                        parseRegionComposition.mergeFrom(regionComposition);
                    }
                    subtitleService2.regions.put(parseRegionComposition.id, parseRegionComposition);
                    break;
                }
            case 18:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ClutDefinition parseClutDefinition = parseClutDefinition(parsableBitArray, readBits3);
                        subtitleService2.ancillaryCluts.put(parseClutDefinition.id, parseClutDefinition);
                        break;
                    }
                } else {
                    ClutDefinition parseClutDefinition2 = parseClutDefinition(parsableBitArray, readBits3);
                    subtitleService2.cluts.put(parseClutDefinition2.id, parseClutDefinition2);
                    break;
                }
                break;
            case 19:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ObjectData parseObjectData = parseObjectData(parsableBitArray);
                        subtitleService2.ancillaryObjects.put(parseObjectData.id, parseObjectData);
                        break;
                    }
                } else {
                    ObjectData parseObjectData2 = parseObjectData(parsableBitArray);
                    subtitleService2.objects.put(parseObjectData2.id, parseObjectData2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    subtitleService2.displayDefinition = parseDisplayDefinition(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
    }

    private static DisplayDefinition parseDisplayDefinition(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int i3;
        int i4;
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits = parsableBitArray.readBits(16);
        int readBits2 = parsableBitArray.readBits(16);
        if (readBit) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            int readBits5 = parsableBitArray.readBits(16);
            i = parsableBitArray.readBits(16);
            i3 = readBits4;
            i2 = readBits5;
            i4 = readBits3;
        } else {
            i3 = readBits;
            i = readBits2;
            i4 = 0;
            i2 = 0;
        }
        return new DisplayDefinition(readBits, readBits2, i4, i3, i2, i);
    }

    private static PageComposition parsePageComposition(ParsableBitArray parsableBitArray, int i) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(4);
        int readBits3 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits4 = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(8);
            i2 -= 6;
            sparseArray.put(readBits4, new PageRegion(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
        }
        return new PageComposition(readBits, readBits2, readBits3, sparseArray);
    }

    private static RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray, int i) {
        int i2;
        int i3;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int readBits = parsableBitArray2.readBits(8);
        parsableBitArray2.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray2.skipBits(3);
        int i4 = 16;
        int readBits2 = parsableBitArray2.readBits(16);
        int readBits3 = parsableBitArray2.readBits(16);
        int readBits4 = parsableBitArray2.readBits(3);
        int readBits5 = parsableBitArray2.readBits(3);
        int i5 = 2;
        parsableBitArray2.skipBits(2);
        int readBits6 = parsableBitArray2.readBits(8);
        int readBits7 = parsableBitArray2.readBits(8);
        int readBits8 = parsableBitArray2.readBits(4);
        int readBits9 = parsableBitArray2.readBits(2);
        parsableBitArray2.skipBits(2);
        int i6 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i6 > 0) {
            int readBits10 = parsableBitArray2.readBits(i4);
            int readBits11 = parsableBitArray2.readBits(i5);
            int readBits12 = parsableBitArray2.readBits(i5);
            int readBits13 = parsableBitArray2.readBits(12);
            int i7 = readBits9;
            parsableBitArray2.skipBits(4);
            int readBits14 = parsableBitArray2.readBits(12);
            i6 -= 6;
            if (readBits11 == 1 || readBits11 == 2) {
                i6 -= 2;
                i3 = parsableBitArray2.readBits(8);
                i2 = parsableBitArray2.readBits(8);
            } else {
                i3 = 0;
                i2 = 0;
            }
            sparseArray.put(readBits10, new RegionObject(readBits11, readBits12, readBits13, readBits14, i3, i2));
            readBits9 = i7;
            i5 = 2;
            i4 = 16;
        }
        return new RegionComposition(readBits, readBit, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
    }

    private static ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int i7 = 8;
        int readBits = parsableBitArray2.readBits(8);
        parsableBitArray2.skipBits(8);
        int i8 = 2;
        int i9 = i - 2;
        int[] generateDefault2BitClutEntries = generateDefault2BitClutEntries();
        int[] generateDefault4BitClutEntries = generateDefault4BitClutEntries();
        int[] generateDefault8BitClutEntries = generateDefault8BitClutEntries();
        while (i9 > 0) {
            int readBits2 = parsableBitArray2.readBits(i7);
            int readBits3 = parsableBitArray2.readBits(i7);
            int i10 = i9 - 2;
            int[] iArr = (readBits3 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 ? generateDefault2BitClutEntries : (readBits3 & 64) != 0 ? generateDefault4BitClutEntries : generateDefault8BitClutEntries;
            if ((readBits3 & 1) != 0) {
                i5 = parsableBitArray2.readBits(i7);
                i4 = parsableBitArray2.readBits(i7);
                i3 = parsableBitArray2.readBits(i7);
                i2 = parsableBitArray2.readBits(i7);
                i6 = i10 - 4;
            } else {
                i3 = parsableBitArray2.readBits(4) << 4;
                i6 = i10 - 2;
                int readBits4 = parsableBitArray2.readBits(4) << 4;
                i2 = parsableBitArray2.readBits(i8) << 6;
                i5 = parsableBitArray2.readBits(6) << i8;
                i4 = readBits4;
            }
            if (i5 == 0) {
                i4 = 0;
                i3 = 0;
                i2 = 255;
            }
            double d = (double) i5;
            double d2 = (double) (i4 - 128);
            Double.isNaN(d2);
            Double.isNaN(d);
            double d3 = (double) (i3 - 128);
            Double.isNaN(d3);
            Double.isNaN(d);
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d);
            iArr[readBits2] = getColor((byte) (255 - (i2 & 255)), Util.constrainValue((int) (d + (1.402d * d2)), 0, 255), Util.constrainValue((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255), Util.constrainValue((int) (d + (d3 * 1.772d)), 0, 255));
            i9 = i6;
            readBits = readBits;
            i7 = 8;
            i8 = 2;
        }
        return new ClutDefinition(readBits, generateDefault2BitClutEntries, generateDefault4BitClutEntries, generateDefault8BitClutEntries);
    }

    private static ObjectData parseObjectData(ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr = new byte[readBits3];
                parsableBitArray.readBytes(bArr, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr2 = new byte[readBits4];
                parsableBitArray.readBytes(bArr2, 0, readBits4);
            } else {
                bArr2 = bArr;
            }
        }
        return new ObjectData(readBits, readBit, bArr, bArr2);
    }

    private static int[] generateDefault2BitClutEntries() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] generateDefault4BitClutEntries() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = getColor(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = 127;
                int i3 = (i & 1) != 0 ? 127 : 0;
                int i4 = (i & 2) != 0 ? 127 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = getColor(255, i3, i4, i2);
            }
        }
        return iArr;
    }

    private static int[] generateDefault8BitClutEntries() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            int i2 = 255;
            if (i < 8) {
                int i3 = (i & 1) != 0 ? 255 : 0;
                int i4 = (i & 2) != 0 ? 255 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = getColor(63, i3, i4, i2);
            } else {
                int i5 = i & 136;
                int i6 = 170;
                int i7 = 85;
                if (i5 == 0) {
                    int i8 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    int i9 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i7 = 0;
                    }
                    if ((i & 64) == 0) {
                        i6 = 0;
                    }
                    iArr[i] = getColor(255, i8, i9, i7 + i6);
                } else if (i5 != 8) {
                    int i10 = 43;
                    if (i5 == 128) {
                        int i11 = ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0);
                        int i12 = ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i10 = 0;
                        }
                        int i13 = i10 + 127;
                        if ((i & 64) == 0) {
                            i7 = 0;
                        }
                        iArr[i] = getColor(255, i11, i12, i13 + i7);
                    } else if (i5 == 136) {
                        int i14 = ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0);
                        int i15 = ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i10 = 0;
                        }
                        if ((i & 64) == 0) {
                            i7 = 0;
                        }
                        iArr[i] = getColor(255, i14, i15, i10 + i7);
                    }
                } else {
                    int i16 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    int i17 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i7 = 0;
                    }
                    if ((i & 64) == 0) {
                        i6 = 0;
                    }
                    iArr[i] = getColor(127, i16, i17, i7 + i6);
                }
            }
        }
        return iArr;
    }

    private static void paintPixelDataSubBlocks(ObjectData objectData, ClutDefinition clutDefinition, int i, int i2, int i3, Paint paint, Canvas canvas2) {
        int[] iArr;
        if (i == 3) {
            iArr = clutDefinition.clutEntries8Bit;
        } else if (i == 2) {
            iArr = clutDefinition.clutEntries4Bit;
        } else {
            iArr = clutDefinition.clutEntries2Bit;
        }
        int[] iArr2 = iArr;
        int i4 = i;
        int i5 = i2;
        Paint paint2 = paint;
        Canvas canvas3 = canvas2;
        paintPixelDataSubBlock(objectData.topFieldData, iArr2, i4, i5, i3, paint2, canvas3);
        paintPixelDataSubBlock(objectData.bottomFieldData, iArr2, i4, i5, i3 + 1, paint2, canvas3);
    }

    private static void paintPixelDataSubBlock(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas2) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int i4 = i;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i5 = i2;
        int i6 = i3;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 240) {
                switch (readBits) {
                    case 16:
                        if (i4 == 3) {
                            bArr3 = bArr5 == null ? defaultMap2To8 : bArr5;
                        } else if (i4 == 2) {
                            bArr3 = bArr7 == null ? defaultMap2To4 : bArr7;
                        } else {
                            bArr2 = null;
                            i5 = paint2BitPixelCodeString(parsableBitArray, iArr, bArr2, i5, i6, paint, canvas2);
                            parsableBitArray.byteAlign();
                            continue;
                        }
                        bArr2 = bArr3;
                        i5 = paint2BitPixelCodeString(parsableBitArray, iArr, bArr2, i5, i6, paint, canvas2);
                        parsableBitArray.byteAlign();
                        continue;
                    case 17:
                        if (i4 == 3) {
                            bArr4 = bArr6 == null ? defaultMap4To8 : bArr6;
                        } else {
                            bArr4 = null;
                        }
                        i5 = paint4BitPixelCodeString(parsableBitArray, iArr, bArr4, i5, i6, paint, canvas2);
                        parsableBitArray.byteAlign();
                        continue;
                    case 18:
                        i5 = paint8BitPixelCodeString(parsableBitArray, iArr, null, i5, i6, paint, canvas2);
                        continue;
                    default:
                        switch (readBits) {
                            case 32:
                                bArr7 = buildClutMapTable(4, 4, parsableBitArray);
                                continue;
                            case 33:
                                bArr5 = buildClutMapTable(4, 8, parsableBitArray);
                                continue;
                            case 34:
                                bArr6 = buildClutMapTable(16, 8, parsableBitArray);
                                continue;
                            default:
                                continue;
                        }
                }
            } else {
                i6 += 2;
                i5 = i2;
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083 A[LOOP:0: B:1:0x0009->B:30:0x0083, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[SYNTHETIC] */
    private static int paint2BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas2) {
        boolean z;
        int i3;
        int i4;
        int readBits;
        int readBits2;
        int i5 = i2;
        Paint paint2 = paint;
        int i6 = i;
        boolean z2 = false;
        while (true) {
            int readBits3 = parsableBitArray.readBits(2);
            if (readBits3 != 0) {
                z = z2;
                i4 = readBits3;
            } else {
                if (parsableBitArray.readBit()) {
                    readBits = parsableBitArray.readBits(3) + 3;
                    readBits2 = parsableBitArray.readBits(2);
                } else if (parsableBitArray.readBit()) {
                    z = z2;
                    i4 = 0;
                } else {
                    int readBits4 = parsableBitArray.readBits(2);
                    if (readBits4 == 0) {
                        i4 = 0;
                        i3 = 0;
                        z = true;
                    } else if (readBits4 == 1) {
                        z = z2;
                        i4 = 0;
                        i3 = 2;
                    } else if (readBits4 == 2) {
                        readBits = parsableBitArray.readBits(4) + 12;
                        readBits2 = parsableBitArray.readBits(2);
                    } else if (readBits4 != 3) {
                        z = z2;
                        i4 = 0;
                        i3 = 0;
                    } else {
                        readBits = parsableBitArray.readBits(8) + 29;
                        readBits2 = parsableBitArray.readBits(2);
                    }
                    if (!(i3 == 0 || paint2 == null)) {
                        if (bArr != null) {
                            i4 = bArr[i4];
                        }
                        paint2.setColor(iArr[i4]);
                        Canvas canvas3 = canvas2;
                        canvas3.drawRect((float) i6, (float) i5, (float) (i6 + i3), (float) (i5 + 1), paint);
                    }
                    i6 += i3;
                    if (z) {
                        return i6;
                    }
                    z2 = z;
                }
                z = z2;
                i3 = readBits;
                if (bArr != null) {
                }
                paint2.setColor(iArr[i4]);
                Canvas canvas32 = canvas2;
                canvas32.drawRect((float) i6, (float) i5, (float) (i6 + i3), (float) (i5 + 1), paint);
                i6 += i3;
                if (z) {
                }
            }
            i3 = 1;
            if (bArr != null) {
            }
            paint2.setColor(iArr[i4]);
            Canvas canvas322 = canvas2;
            canvas322.drawRect((float) i6, (float) i5, (float) (i6 + i3), (float) (i5 + 1), paint);
            i6 += i3;
            if (z) {
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f A[LOOP:0: B:1:0x0009->B:33:0x008f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[SYNTHETIC] */
    private static int paint4BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int readBits;
        int i6 = i2;
        Paint paint2 = paint;
        int i7 = i;
        boolean z2 = false;
        while (true) {
            int readBits2 = parsableBitArray.readBits(4);
            if (readBits2 != 0) {
                z = z2;
                i5 = readBits2;
            } else {
                if (!parsableBitArray.readBit()) {
                    int readBits3 = parsableBitArray.readBits(3);
                    if (readBits3 != 0) {
                        z = z2;
                        i3 = readBits3 + 2;
                        i4 = 0;
                    } else {
                        i4 = 0;
                        i3 = 0;
                        z = true;
                    }
                } else {
                    if (!parsableBitArray.readBit()) {
                        readBits = parsableBitArray.readBits(2) + 4;
                        i4 = parsableBitArray.readBits(4);
                    } else {
                        int readBits4 = parsableBitArray.readBits(2);
                        if (readBits4 == 0) {
                            z = z2;
                            i5 = 0;
                        } else if (readBits4 == 1) {
                            z = z2;
                            i4 = 0;
                            i3 = 2;
                        } else if (readBits4 == 2) {
                            readBits = parsableBitArray.readBits(4) + 9;
                            i4 = parsableBitArray.readBits(4);
                        } else if (readBits4 != 3) {
                            z = z2;
                            i4 = 0;
                            i3 = 0;
                        } else {
                            readBits = parsableBitArray.readBits(8) + 25;
                            i4 = parsableBitArray.readBits(4);
                        }
                    }
                    z = z2;
                    i3 = readBits;
                }
                if (!(i3 == 0 || paint2 == null)) {
                    if (bArr != null) {
                        i4 = bArr[i4];
                    }
                    paint2.setColor(iArr[i4]);
                    Canvas canvas3 = canvas2;
                    canvas3.drawRect((float) i7, (float) i6, (float) (i7 + i3), (float) (i6 + 1), paint);
                }
                i7 += i3;
                if (!z) {
                    return i7;
                }
                z2 = z;
            }
            i3 = 1;
            if (bArr != null) {
            }
            paint2.setColor(iArr[i4]);
            Canvas canvas32 = canvas2;
            canvas32.drawRect((float) i7, (float) i6, (float) (i7 + i3), (float) (i6 + 1), paint);
            i7 += i3;
            if (!z) {
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    private static int paint8BitPixelCodeString(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas2) {
        boolean z;
        int i3;
        int i4;
        int i5 = i2;
        Paint paint2 = paint;
        int i6 = i;
        boolean z2 = false;
        while (true) {
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 0) {
                z = z2;
                i4 = readBits;
                i3 = 1;
            } else if (!parsableBitArray.readBit()) {
                int readBits2 = parsableBitArray.readBits(7);
                if (readBits2 != 0) {
                    z = z2;
                    i3 = readBits2;
                    i4 = 0;
                } else {
                    i4 = 0;
                    i3 = 0;
                    z = true;
                }
            } else {
                int readBits3 = parsableBitArray.readBits(7);
                i4 = parsableBitArray.readBits(8);
                z = z2;
                i3 = readBits3;
            }
            if (!(i3 == 0 || paint2 == null)) {
                if (bArr != null) {
                    i4 = bArr[i4];
                }
                paint2.setColor(iArr[i4]);
                Canvas canvas3 = canvas2;
                canvas3.drawRect((float) i6, (float) i5, (float) (i6 + i3), (float) (i5 + 1), paint);
            }
            i6 += i3;
            if (z) {
                return i6;
            }
            z2 = z;
        }
    }

    private static byte[] buildClutMapTable(int i, int i2, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) parsableBitArray.readBits(i2);
        }
        return bArr;
    }

    static final class SubtitleService {
        public final SparseArray<ClutDefinition> ancillaryCluts = new SparseArray<>();
        public final SparseArray<ObjectData> ancillaryObjects = new SparseArray<>();
        public final int ancillaryPageId;
        public final SparseArray<ClutDefinition> cluts = new SparseArray<>();
        public DisplayDefinition displayDefinition;
        public final SparseArray<ObjectData> objects = new SparseArray<>();
        public PageComposition pageComposition;
        public final SparseArray<RegionComposition> regions = new SparseArray<>();
        public final int subtitlePageId;

        public SubtitleService(int i, int i2) {
            this.subtitlePageId = i;
            this.ancillaryPageId = i2;
        }

        public final void reset() {
            this.regions.clear();
            this.cluts.clear();
            this.objects.clear();
            this.ancillaryCluts.clear();
            this.ancillaryObjects.clear();
            this.displayDefinition = null;
            this.pageComposition = null;
        }
    }

    static final class DisplayDefinition {
        public final int height;
        public final int horizontalPositionMaximum;
        public final int horizontalPositionMinimum;
        public final int verticalPositionMaximum;
        public final int verticalPositionMinimum;
        public final int width;

        public DisplayDefinition(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.horizontalPositionMinimum = i3;
            this.horizontalPositionMaximum = i4;
            this.verticalPositionMinimum = i5;
            this.verticalPositionMaximum = i6;
        }
    }

    static final class PageComposition {
        public final SparseArray<PageRegion> regions;
        public final int state;
        public final int timeOutSecs;
        public final int version;

        public PageComposition(int i, int i2, int i3, SparseArray<PageRegion> sparseArray) {
            this.timeOutSecs = i;
            this.version = i2;
            this.state = i3;
            this.regions = sparseArray;
        }
    }

    static final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int i, int i2) {
            this.horizontalAddress = i;
            this.verticalAddress = i2;
        }
    }

    static final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;
        public final int id;
        public final int levelOfCompatibility;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray<RegionObject> regionObjects;
        public final int width;

        public RegionComposition(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<RegionObject> sparseArray) {
            this.id = i;
            this.fillFlag = z;
            this.width = i2;
            this.height = i3;
            this.levelOfCompatibility = i4;
            this.depth = i5;
            this.clutId = i6;
            this.pixelCode8Bit = i7;
            this.pixelCode4Bit = i8;
            this.pixelCode2Bit = i9;
            this.regionObjects = sparseArray;
        }

        public final void mergeFrom(RegionComposition regionComposition) {
            SparseArray<RegionObject> sparseArray = regionComposition.regionObjects;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.regionObjects.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    static final class RegionObject {
        public final int backgroundPixelCode;
        public final int foregroundPixelCode;
        public final int horizontalPosition;
        public final int provider;
        public final int type;
        public final int verticalPosition;

        public RegionObject(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.provider = i2;
            this.horizontalPosition = i3;
            this.verticalPosition = i4;
            this.foregroundPixelCode = i5;
            this.backgroundPixelCode = i6;
        }
    }

    static final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;
        public final int id;

        public ClutDefinition(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.clutEntries2Bit = iArr;
            this.clutEntries4Bit = iArr2;
            this.clutEntries8Bit = iArr3;
        }
    }

    static final class ObjectData {
        public final byte[] bottomFieldData;
        public final int id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.nonModifyingColorFlag = z;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }
}
