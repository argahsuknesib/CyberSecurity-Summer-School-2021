package com.google.android.exoplayer2.metadata.id3;

import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public final class Id3Decoder implements MetadataDecoder {
    public static final FramePredicate NO_FRAMES_PREDICATE = $$Lambda$Id3Decoder$7M0gBIGKaTbyTVXWCb62bIHyc.INSTANCE;
    private final FramePredicate framePredicate;

    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    private static int delimiterLength(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static String getCharsetName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    static /* synthetic */ boolean lambda$static$0(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(FramePredicate framePredicate2) {
        this.framePredicate = framePredicate2;
    }

    public final Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(metadataInputBuffer.data);
        Assertions.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata decode(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i2 = decodeHeader.majorVersion == 2 ? 6 : 10;
        int i3 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            i3 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + i3);
        boolean z = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i2, false)) {
            if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i2, true)) {
                Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
            z = true;
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z, i2, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata(arrayList);
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        boolean z = false;
        if (readUnsignedInt24 != 4801587) {
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(readUnsignedInt24)));
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                readSynchSafeInt -= 10;
            }
        } else {
            Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=".concat(String.valueOf(readUnsignedByte)));
            return null;
        }
        if (readUnsignedByte < 4 && (readUnsignedByte2 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            z = true;
        }
        return new Id3Header(readUnsignedByte, z, readSynchSafeInt);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        if ((r10 & android.support.v4.app.NotificationCompat.FLAG_HIGH_PRIORITY) != 0) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b A[SYNTHETIC, Splitter:B:49:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0097 A[SYNTHETIC] */
    private static boolean validateFrames(ParsableByteArray parsableByteArray, int i, int i2, boolean z) {
        int i3;
        long j;
        int i4;
        boolean z2;
        boolean z3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i5 = i;
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                int i6 = 1;
                if (parsableByteArray.bytesLeft() >= i2) {
                    if (i5 >= 3) {
                        i4 = parsableByteArray.readInt();
                        j = parsableByteArray.readUnsignedInt();
                        i3 = parsableByteArray.readUnsignedShort();
                    } else {
                        i4 = parsableByteArray.readUnsignedInt24();
                        j = (long) parsableByteArray.readUnsignedInt24();
                        i3 = 0;
                    }
                    if (i4 == 0 && j == 0 && i3 == 0) {
                        parsableByteArray2.setPosition(position);
                        return true;
                    }
                    if (i5 == 4 && !z) {
                        if ((8421504 & j) != 0) {
                            parsableByteArray2.setPosition(position);
                            return false;
                        }
                        j = (((j >> 24) & 255) << 21) | (j & 255) | (((j >> 8) & 255) << 7) | (((j >> 16) & 255) << 14);
                    }
                    if (i5 == 4) {
                        z3 = (i3 & 64) != 0;
                    } else {
                        if (i5 == 3) {
                            z3 = (i3 & 32) != 0;
                        } else {
                            z3 = false;
                        }
                        z2 = false;
                        if (!z3) {
                            i6 = 0;
                        }
                        if (z2) {
                            i6 += 4;
                        }
                        if (j >= ((long) i6)) {
                            parsableByteArray2.setPosition(position);
                            return false;
                        } else if (((long) parsableByteArray.bytesLeft()) < j) {
                            return false;
                        } else {
                            parsableByteArray2.skipBytes((int) j);
                        }
                    }
                    z2 = true;
                    if (!z3) {
                    }
                    if (z2) {
                    }
                    if (j >= ((long) i6)) {
                    }
                } else {
                    parsableByteArray2.setPosition(position);
                    return true;
                }
            } finally {
                parsableByteArray2.setPosition(position);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0195, code lost:
        if (r13 == 67) goto L_0x0197;
     */
    private static Id3Frame decodeFrame(int i, ParsableByteArray parsableByteArray, boolean z, int i2, FramePredicate framePredicate2) {
        int readUnsignedIntToInt;
        int i3;
        int i4;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Id3Frame id3Frame;
        boolean z7;
        boolean z8;
        int i5 = i;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte4 = i5 >= 3 ? parsableByteArray.readUnsignedByte() : 0;
        if (i5 == 4) {
            readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (!z) {
                readUnsignedIntToInt = (((readUnsignedIntToInt >> 24) & 255) << 21) | (readUnsignedIntToInt & 255) | (((readUnsignedIntToInt >> 8) & 255) << 7) | (((readUnsignedIntToInt >> 16) & 255) << 14);
            }
        } else {
            readUnsignedIntToInt = i5 == 3 ? parsableByteArray.readUnsignedIntToInt() : parsableByteArray.readUnsignedInt24();
        }
        int i6 = readUnsignedIntToInt;
        int readUnsignedShort = i5 >= 3 ? parsableByteArray.readUnsignedShort() : 0;
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && i6 == 0 && readUnsignedShort == 0) {
            parsableByteArray2.setPosition(parsableByteArray.limit());
            return null;
        }
        int position = parsableByteArray.getPosition() + i6;
        if (position > parsableByteArray.limit()) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray2.setPosition(parsableByteArray.limit());
            return null;
        }
        if (framePredicate2 != null) {
            str = "Id3Decoder";
            i4 = position;
            i3 = readUnsignedShort;
            if (!framePredicate2.evaluate(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
                parsableByteArray2.setPosition(i4);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i4 = position;
            i3 = readUnsignedShort;
        }
        if (i5 == 3) {
            int i7 = i3;
            z7 = (i7 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
            z4 = (i7 & 64) != 0;
            z3 = false;
            z5 = (i7 & 32) != 0;
            z8 = z7;
        } else {
            int i8 = i3;
            if (i5 == 4) {
                z5 = (i8 & 64) != 0;
                z8 = (i8 & 8) != 0;
                z4 = (i8 & 4) != 0;
                z3 = (i8 & 2) != 0;
                z7 = (i8 & 1) != 0;
            } else {
                z6 = false;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                if (!z2 || z4) {
                    Log.w(str, "Skipping unsupported compressed or encrypted frame");
                    parsableByteArray2.setPosition(i4);
                    return null;
                }
                if (z5) {
                    i6--;
                    parsableByteArray2.skipBytes(1);
                }
                if (z6) {
                    i6 -= 4;
                    parsableByteArray2.skipBytes(4);
                }
                if (z3) {
                    i6 = removeUnsynchronization(parsableByteArray2, i6);
                }
                if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i5 == 2 || readUnsignedByte4 == 88)) {
                    try {
                        id3Frame = decodeTxxxFrame(parsableByteArray2, i6);
                    } catch (UnsupportedEncodingException unused) {
                        Log.w(str, "Unsupported character encoding");
                        parsableByteArray2.setPosition(i4);
                        return null;
                    } catch (Throwable th) {
                        parsableByteArray2.setPosition(i4);
                        throw th;
                    }
                } else if (readUnsignedByte == 84) {
                    id3Frame = decodeTextInformationFrame(parsableByteArray2, i6, getFrameId(i5, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i5 == 2 || readUnsignedByte4 == 88)) {
                    id3Frame = decodeWxxxFrame(parsableByteArray2, i6);
                } else if (readUnsignedByte == 87) {
                    id3Frame = decodeUrlLinkFrame(parsableByteArray2, i6, getFrameId(i5, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                    id3Frame = decodePrivFrame(parsableByteArray2, i6);
                } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i5 == 2)) {
                    id3Frame = decodeGeobFrame(parsableByteArray2, i6);
                } else {
                    if (i5 == 2) {
                        if (readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) {
                        }
                        if (readUnsignedByte != 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i5 == 2)) {
                            id3Frame = decodeCommentFrame(parsableByteArray2, i6);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                            id3Frame = decodeChapterFrame(parsableByteArray, i6, i, z, i2, framePredicate2);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                            id3Frame = decodeChapterTOCFrame(parsableByteArray, i6, i, z, i2, framePredicate2);
                        } else if (readUnsignedByte != 77 && readUnsignedByte2 == 76 && readUnsignedByte3 == 76 && readUnsignedByte4 == 84) {
                            id3Frame = decodeMlltFrame(parsableByteArray2, i6);
                        } else {
                            id3Frame = decodeBinaryFrame(parsableByteArray2, i6, getFrameId(i5, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                        }
                    } else {
                        if (readUnsignedByte == 65) {
                            if (readUnsignedByte2 == 80) {
                                if (readUnsignedByte3 == 73) {
                                }
                            }
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 77) {
                        }
                        id3Frame = decodeBinaryFrame(parsableByteArray2, i6, getFrameId(i5, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                    }
                    id3Frame = decodeApicFrame(parsableByteArray2, i6, i5);
                }
                if (id3Frame == null) {
                    Log.w(str, "Failed to decode frame: id=" + getFrameId(i5, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4) + ", frameSize=" + i6);
                }
                parsableByteArray2.setPosition(i4);
                return id3Frame;
            }
        }
        z6 = z7;
        z2 = z8;
        if (!z2) {
        }
        Log.w(str, "Skipping unsupported compressed or encrypted frame");
        parsableByteArray2.setPosition(i4);
        return null;
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i <= 0) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new TextInformationFrame("TXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte), charsetName));
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        if (i <= 0) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i <= 0) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength), "ISO-8859-1"));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i));
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i3 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i3, readUnsignedByte);
        String decodeStringIfValid = decodeStringIfValid(bArr, i3, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, decodeStringIfValid, decodeStringIfValid(bArr, delimiterLength, indexOfEos2, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), bArr.length));
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i, int i2) throws UnsupportedEncodingException {
        int i3;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i4 = i - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.readBytes(bArr, 0, i4);
        if (i2 == 2) {
            str = "image/" + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i3 = 2;
        } else {
            i3 = indexOfZeroByte(bArr, 0);
            String lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, i3, "ISO-8859-1"));
            str = lowerInvariant.indexOf(47) == -1 ? "image/".concat(String.valueOf(lowerInvariant)) : lowerInvariant;
        }
        int i5 = i3 + 2;
        int indexOfEos = indexOfEos(bArr, i5, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i5, indexOfEos - i5, charsetName), bArr[i3 + 1] & 255, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), bArr.length));
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte), charsetName));
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate2) throws UnsupportedEncodingException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray2.data, position);
        String str = new String(parsableByteArray2.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt == 4294967295L ? -1 : readUnsignedInt;
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        long j2 = readUnsignedInt2 == 4294967295L ? -1 : readUnsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, j, j2, id3FrameArr);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate2) throws UnsupportedEncodingException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray2.data, position);
        String str = new String(parsableByteArray2.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray2.data, position2);
            strArr[i4] = new String(parsableByteArray2.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static MlltFrame decodeMlltFrame(ParsableByteArray parsableByteArray, int i) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        int readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i2 = ((i - 10) * 8) / (readUnsignedByte + readUnsignedByte2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int readBits = parsableBitArray.readBits(readUnsignedByte);
            int readBits2 = parsableBitArray.readBits(readUnsignedByte2);
            iArr[i3] = readBits;
            iArr2[i3] = readBits2;
        }
        return new MlltFrame(readUnsignedShort, readUnsignedInt24, readUnsignedInt242, iArr, iArr2);
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        int i2 = i;
        int i3 = position;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= position + i2) {
                return i2;
            }
            if ((bArr[i3] & 255) == 255 && bArr[i4] == 0) {
                System.arraycopy(bArr, i3 + 2, bArr, i4, (i2 - (i3 - position)) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    private static String getFrameId(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int indexOfEos(byte[] bArr, int i, int i2) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return indexOfZeroByte;
        }
        while (indexOfZeroByte < bArr.length - 1) {
            if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                return indexOfZeroByte;
            }
            indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return Util.EMPTY_BYTE_ARRAY;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    private static String decodeStringIfValid(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    static final class Id3Header {
        public final int framesSize;
        public final boolean isUnsynchronized;
        public final int majorVersion;

        public Id3Header(int i, boolean z, int i2) {
            this.majorVersion = i;
            this.isUnsynchronized = z;
            this.framesSize = i2;
        }
    }
}
