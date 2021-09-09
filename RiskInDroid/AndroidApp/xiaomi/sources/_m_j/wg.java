package _m_j;

import com.drew.imaging.FileType;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;

public class wg {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f2573O000000o = (!wg.class.desiredAssertionStatus());
    private static final xd<FileType> O00000Oo;
    private static final HashMap<String, FileType> O00000o0;

    static {
        xd<FileType> xdVar = new xd<>();
        O00000Oo = xdVar;
        xdVar.f2588O000000o.O000000o(FileType.Unknown);
        O00000Oo.O000000o(FileType.Jpeg, new byte[]{-1, -40});
        O00000Oo.O000000o(FileType.Tiff, "II".getBytes(), new byte[]{42, 0});
        O00000Oo.O000000o(FileType.Tiff, "MM".getBytes(), new byte[]{0, 42});
        O00000Oo.O000000o(FileType.Psd, "8BPS".getBytes());
        O00000Oo.O000000o(FileType.Png, new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82});
        O00000Oo.O000000o(FileType.Bmp, "BM".getBytes());
        O00000Oo.O000000o(FileType.Bmp, "BA".getBytes());
        O00000Oo.O000000o(FileType.Bmp, "CI".getBytes());
        O00000Oo.O000000o(FileType.Bmp, "CP".getBytes());
        O00000Oo.O000000o(FileType.Bmp, "IC".getBytes());
        O00000Oo.O000000o(FileType.Bmp, "PT".getBytes());
        O00000Oo.O000000o(FileType.Gif, "GIF87a".getBytes());
        O00000Oo.O000000o(FileType.Gif, "GIF89a".getBytes());
        O00000Oo.O000000o(FileType.Ico, new byte[]{0, 0, 1, 0});
        O00000Oo.O000000o(FileType.Pcx, new byte[]{10, 0, 1});
        O00000Oo.O000000o(FileType.Pcx, new byte[]{10, 2, 1});
        O00000Oo.O000000o(FileType.Pcx, new byte[]{10, 3, 1});
        O00000Oo.O000000o(FileType.Pcx, new byte[]{10, 5, 1});
        O00000Oo.O000000o(FileType.Riff, "RIFF".getBytes());
        O00000Oo.O000000o(FileType.Arw, "II".getBytes(), new byte[]{42, 0, 8, 0});
        O00000Oo.O000000o(FileType.Crw, "II".getBytes(), new byte[]{26, 0, 0, 0}, "HEAPCCDR".getBytes());
        O00000Oo.O000000o(FileType.Cr2, "II".getBytes(), new byte[]{42, 0, 16, 0, 0, 0, 67, 82});
        O00000Oo.O000000o(FileType.Orf, "IIRO".getBytes(), new byte[]{8, 0});
        O00000Oo.O000000o(FileType.Orf, "MMOR".getBytes(), new byte[]{0, 0});
        O00000Oo.O000000o(FileType.Orf, "IIRS".getBytes(), new byte[]{8, 0});
        O00000Oo.O000000o(FileType.Raf, "FUJIFILMCCD-RAW".getBytes());
        O00000Oo.O000000o(FileType.Rw2, "II".getBytes(), new byte[]{85, 0});
        O00000Oo.O000000o(FileType.Eps, "%!PS".getBytes());
        O00000Oo.O000000o(FileType.Eps, new byte[]{-59, -48, -45, -58});
        HashMap<String, FileType> hashMap = new HashMap<>();
        O00000o0 = hashMap;
        hashMap.put("ftypmoov", FileType.Mov);
        O00000o0.put("ftypwide", FileType.Mov);
        O00000o0.put("ftypmdat", FileType.Mov);
        O00000o0.put("ftypfree", FileType.Mov);
        O00000o0.put("ftypqt  ", FileType.Mov);
        O00000o0.put("ftypavc1", FileType.Mp4);
        O00000o0.put("ftypiso2", FileType.Mp4);
        O00000o0.put("ftypisom", FileType.Mp4);
        O00000o0.put("ftypM4A ", FileType.Mp4);
        O00000o0.put("ftypM4B ", FileType.Mp4);
        O00000o0.put("ftypM4P ", FileType.Mp4);
        O00000o0.put("ftypM4V ", FileType.Mp4);
        O00000o0.put("ftypM4VH", FileType.Mp4);
        O00000o0.put("ftypM4VP", FileType.Mp4);
        O00000o0.put("ftypmmp4", FileType.Mp4);
        O00000o0.put("ftypmp41", FileType.Mp4);
        O00000o0.put("ftypmp42", FileType.Mp4);
        O00000o0.put("ftypmp71", FileType.Mp4);
        O00000o0.put("ftypMSNV", FileType.Mp4);
        O00000o0.put("ftypNDAS", FileType.Mp4);
        O00000o0.put("ftypNDSC", FileType.Mp4);
        O00000o0.put("ftypNDSH", FileType.Mp4);
        O00000o0.put("ftypNDSM", FileType.Mp4);
        O00000o0.put("ftypNDSP", FileType.Mp4);
        O00000o0.put("ftypNDSS", FileType.Mp4);
        O00000o0.put("ftypNDXC", FileType.Mp4);
        O00000o0.put("ftypNDXH", FileType.Mp4);
        O00000o0.put("ftypNDXM", FileType.Mp4);
        O00000o0.put("ftypNDXP", FileType.Mp4);
        O00000o0.put("ftypNDXS", FileType.Mp4);
        O00000o0.put("ftypmif1", FileType.Heif);
        O00000o0.put("ftypmsf1", FileType.Heif);
        O00000o0.put("ftypheic", FileType.Heif);
        O00000o0.put("ftypheix", FileType.Heif);
        O00000o0.put("ftyphevc", FileType.Heif);
        O00000o0.put("ftyphevx", FileType.Heif);
        O00000Oo.O000000o(FileType.Aac, new byte[]{-1, -15});
        O00000Oo.O000000o(FileType.Aac, new byte[]{-1, -7});
        O00000Oo.O000000o(FileType.Asf, new byte[]{48, 38, -78, 117, -114, 102, -49, 17, -90, -39, 0, -86, 0, 98, -50, 108});
        O00000Oo.O000000o(FileType.Cfbf, new byte[]{-48, -49, 17, -32, -95, -79, 26, -31, 0});
        O00000Oo.O000000o(FileType.Flv, new byte[]{70, 76, 86});
        O00000Oo.O000000o(FileType.Indd, new byte[]{6, 6, -19, -11, -40, 29, 70, -27, -67, 49, -17, -25, -2, 116, -73, 29});
        O00000Oo.O000000o(FileType.Mxf, new byte[]{6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 2});
        O00000Oo.O000000o(FileType.Qxp, new byte[]{0, 0, 73, 73, 88, 80, 82, 51});
        O00000Oo.O000000o(FileType.Qxp, new byte[]{0, 0, 77, 77, 88, 80, 82, 51});
        O00000Oo.O000000o(FileType.Ram, new byte[]{114, 116, 115, 112, 58, 47, 47});
        O00000Oo.O000000o(FileType.Rtf, new byte[]{123, 92, 114, 116, 102, 49});
        O00000Oo.O000000o(FileType.Sit, new byte[]{83, 73, 84, 33, 0});
        O00000Oo.O000000o(FileType.Sit, new byte[]{83, 116, 117, 102, 102, 73, 116, 32, 40, 99, 41, 49, 57, 57, 55, 45});
        O00000Oo.O000000o(FileType.Sitx, new byte[]{83, 116, 117, 102, 102, 73, 116, 33});
        O00000Oo.O000000o(FileType.Swf, "CWS".getBytes());
        O00000Oo.O000000o(FileType.Swf, "FWS".getBytes());
        O00000Oo.O000000o(FileType.Swf, "ZWS".getBytes());
        O00000Oo.O000000o(FileType.Vob, new byte[]{0, 0, 1, -70});
        O00000Oo.O000000o(FileType.Zip, "PK".getBytes());
    }

    private wg() throws Exception {
        throw new Exception("Not intended for instantiation");
    }

    public static FileType O000000o(BufferedInputStream bufferedInputStream) throws IOException {
        if (bufferedInputStream.markSupported()) {
            int max = Math.max(16, O00000Oo.O00000Oo);
            bufferedInputStream.mark(max);
            byte[] bArr = new byte[max];
            if (bufferedInputStream.read(bArr) != -1) {
                bufferedInputStream.reset();
                FileType O000000o2 = O00000Oo.O000000o(bArr);
                if (!f2573O000000o && O000000o2 == null) {
                    throw new AssertionError();
                } else if (O000000o2 == FileType.Unknown) {
                    FileType fileType = O00000o0.get(new String(bArr, 4, 8));
                    if (fileType != null) {
                        return fileType;
                    }
                    return O000000o2;
                } else if (O000000o2 != FileType.Riff) {
                    return O000000o2;
                } else {
                    String str = new String(bArr, 8, 4);
                    if (str.equals("WAVE")) {
                        return FileType.Wav;
                    }
                    if (str.equals("AVI ")) {
                        return FileType.Avi;
                    }
                    if (str.equals("WEBP")) {
                        return FileType.WebP;
                    }
                    return O000000o2;
                }
            } else {
                throw new IOException("Stream ended before file's magic number could be determined.");
            }
        } else {
            throw new IOException("Stream must support mark/reset");
        }
    }
}
