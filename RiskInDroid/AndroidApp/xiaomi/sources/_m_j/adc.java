package _m_j;

import java.util.HashMap;

public final class adc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HashMap<String, String> f12355O000000o = new HashMap<>();
    private static HashMap<Integer, HashMap<String, String>> O00000Oo = new HashMap<>();
    private static HashMap<String, String> O00000o = new HashMap<>();
    private static HashMap<String, String> O00000o0 = new HashMap<>();
    private static HashMap<String, String> O00000oO = new HashMap<>();

    static {
        O00000Oo.put(4096, O00000o0);
        O00000Oo.put(10, O00000o);
        O00000Oo.put(769, O00000oO);
        O00000Oo.put(1, f12355O000000o);
        O00000o.put("3IVX", "3ivx MPEG-4");
        O00000o.put("3IV1", "3ivx MPEG-4 v1");
        O00000o.put("3IV2", "3ivx MPEG-4 v2");
        O00000o.put("avr ", "AVR-JPEG");
        O00000o.put("base", "Base");
        O00000o.put("WRLE", "BMP");
        O00000o.put("cvid", "Cinepak");
        O00000o.put("clou", "Cloud");
        O00000o.put("cmyk", "CMYK");
        O00000o.put("yuv2", "ComponentVideo");
        O00000o.put("yuvu", "ComponentVideoSigned");
        O00000o.put("yuvs", "ComponentVideoUnsigned");
        O00000o.put("dvc ", "DVC-NTSC");
        O00000o.put("dvcp", "DVC-PAL");
        O00000o.put("dvpn", "DVCPro-NTSC");
        O00000o.put("dvpp", "DVCPro-PAL");
        O00000o.put("fire", "Fire");
        O00000o.put("flic", "FLC");
        O00000o.put("b48r", "48RGB");
        O00000o.put("gif ", "GIF");
        O00000o.put("smc ", "Graphics");
        O00000o.put("h261", "Apple H261");
        O00000o.put("h263", "Apple VC H.263");
        O00000o.put("IV41", "Indeo4");
        O00000o.put("jpeg", "JPEG");
        O00000o.put("PNTG", "MacPaint");
        O00000o.put("msvc", "Microsoft Video1");
        O00000o.put("mjpa", "Apple Motion JPEG-A");
        O00000o.put("mjpb", "Apple Motion JPEG-B");
        O00000o.put("myuv", "MPEG YUV420");
        O00000o.put("dmb1", "OpenDML JPEG");
        O00000o.put("kpcd", "PhotoCD");
        O00000o.put("8BPS", "Planar RGB");
        O00000o.put("png ", "PNG");
        O00000o.put("qdrw", "QuickDraw");
        O00000o.put("qdgx", "QuickDrawGX");
        O00000o.put("raw ", "RAW");
        O00000o.put(".SGI", "SGI");
        O00000o.put("b16g", "16Gray");
        O00000o.put("b64a", "64ARGB");
        O00000o.put("SVQ1", "Sorenson Video 1");
        O00000o.put("SVQ3", "Sorenson Video 3");
        O00000o.put("syv9", "Sorenson YUV9");
        O00000o.put("tga ", "Targa");
        O00000o.put("b32a", "32AlphaGray");
        O00000o.put("tiff", "TIFF");
        O00000o.put("path", "Vector");
        O00000o.put("rpza", "Video (Road Pizza)");
        O00000o.put("ripl", "WaterRipple");
        O00000o.put("WRAW", "Windows RAW");
        O00000o.put("y420", "YUV420");
        O00000o.put("avc1", "H.264");
        O00000o.put("mp4v", "MPEG-4");
        O00000o.put("MP4V", "MPEG-4");
        O00000o.put("dvhp", "DVCPRO HD 720p60");
        O00000o.put("hdv2", "HDV 1080i60");
        O00000o.put("dvc+", "DV/DVCPRO - NTSC");
        O00000o.put("mx5p", "MPEG2 IMX 635/50 50mb/s");
        O00000o.put("mx3n", "MPEG2 IMX 635/50 30mb/s");
        O00000o.put("dv5p", "DVCPRO50");
        O00000o.put("hdv3", "HDV Final Cut Pro");
        O00000o.put("rle ", "Animation");
        O00000o.put("rle ", "Animation");
        O00000o.put("2vuY", "Uncompressed Y'CbCr, 8-bit-per-component 4:2:2");
        O00000o.put("v308", "Uncompressed Y'CbCr, 8-bit-per-component 4:4:4");
        O00000o.put("v408", "Uncompressed Y'CbCr, 8-bit-per-component 4:4:4:4");
        O00000o.put("v216", "Uncompressed Y'CbCr, 10, 12, 14, or 16-bit-per-component 4:2:2");
        O00000o.put("v410", "Uncompressed Y'CbCr, 10-bit-per-component 4:4:4");
        O00000o.put("v210", "Uncompressed Y'CbCr, 10-bit-per-component 4:2:2");
        O00000oO.put("NONE", "");
        O00000oO.put("raw ", "Uncompressed in offset-binary format");
        O00000oO.put("twos", "Uncompressed in two's-complement format");
        O00000oO.put("sowt", "16-bit little-endian, twos-complement");
        O00000oO.put("MAC3", "MACE 3:1");
        O00000oO.put("MAC6", "MACE 6:1");
        O00000oO.put("ima4", "IMA 4:1");
        O00000oO.put("fl32", "32-bit floating point");
        O00000oO.put("fl64", "64-bit floating point");
        O00000oO.put("in24", "24-bit integer");
        O00000oO.put("in32", "32-bit integer");
        O00000oO.put("ulaw", "uLaw 2:1");
        O00000oO.put("alaw", "uLaw 2:1");
        O00000oO.put("ms\u0000\u0002", "Microsoft ADPCM-ACM code 2");
        O00000oO.put("ms\u0000\u0011", "DVI/Intel IMAADPCM-ACM code 17");
        O00000oO.put("dvca", "DV Audio");
        O00000oO.put("QDMC", "QDesign music");
        O00000oO.put("QDM2", "QDesign music version 2");
        O00000oO.put("Qclp", "QUALCOMM PureVoice");
        O00000oO.put("ms\u0000U", "MPEG-1 layer 3, CBR only (pre-QT4.1)");
        O00000oO.put(".mp3", "MPEG-1 layer 3, CBR & VBR (QT4.1 and later)");
        O00000oO.put("mp4a", "MPEG-4, Advanced Audio Coding (AAC)");
        O00000oO.put("ac-3", "Digital Audio Compression Standard (AC-3, Enhanced AC-3)");
        O00000oO.put("aac ", "ISO/IEC 144963-3 AAC");
        O00000oO.put("agsm", "Apple GSM 10:1");
        O00000oO.put("alac", "Apple Lossless Audio Codec");
        O00000oO.put("conv", "Sample Format");
        O00000oO.put("dvi ", "DV 4:1");
        O00000oO.put("eqal", "Frequency Equalizer");
        O00000oO.put("lpc ", "LPC 23:1");
        O00000oO.put("mixb", "8-bit Mixer");
        O00000oO.put("mixw", "16-bit Mixer");
        O00000oO.put("MS\u0000\u0002", "Microsoft ADPCM");
        O00000oO.put("MS\u0000\u0011", "DV IMA");
        O00000oO.put("MS\u0000U", "MPEG3");
        O00000oO.put("ratb", "8-bit Rate");
        O00000oO.put("ratw", "16-bit Rate");
        O00000oO.put("sour", "Sound Source");
        O00000oO.put("str1", "Iomega MPEG layer II");
        O00000oO.put("str2", "Iomega MPEG *layer II");
        O00000oO.put("str3", "Iomega MPEG **layer II");
        O00000oO.put("str4", "Iomega MPEG ***layer II");
        O00000oO.put("lpcm", "Linear Pulse Code Modulation");
        O00000o0.put("3g2a", "3GPP2 Media (.3G2) compliant with 3GPP2 C.S0050-0 V1.0");
        O00000o0.put("3g2b", "3GPP2 Media (.3G2) compliant with 3GPP2 C.S0050-A V1.0.0");
        O00000o0.put("3g2c", "3GPP2 Media (.3G2) compliant with 3GPP2 C.S0050-B v1.0");
        O00000o0.put("3ge6", "3GPP (.3GP) Release 6 MBMS Extended Presentations");
        O00000o0.put("3ge7", "3GPP (.3GP) Release 7 MBMS Extended Presentations");
        O00000o0.put("3gg6", "3GPP Release 6 General Profile");
        O00000o0.put("3gp1", "3GPP Media (.3GP) Release 1 (probably non-existent)");
        O00000o0.put("3gp2", "3GPP Media (.3GP) Release 2 (probably non-existent)");
        O00000o0.put("3gp3", "3GPP Media (.3GP) Release 3 (probably non-existent)");
        O00000o0.put("3gp4", "3GPP Media (.3GP) Release 4");
        O00000o0.put("3gp5", "3GPP Media (.3GP) Release 5");
        O00000o0.put("3gp6", "3GPP Media (.3GP) Release 6 Basic Profile");
        O00000o0.put("3gp6", "3GPP Media (.3GP) Release 6 Progressive Download");
        O00000o0.put("3gp6", "3GPP Media (.3GP) Release 6 Streaming Servers");
        O00000o0.put("3gs7", "3GPP Media (.3GP) Release 7 Streaming Servers");
        O00000o0.put("avc1", "MP4 Base w/ AVC ext [ISO 14496-12:2005]");
        O00000o0.put("CAEP", "Canon Digital Camera");
        O00000o0.put("caqv", "Casio Digital Camera");
        O00000o0.put("CDes", "Convergent Design");
        O00000o0.put("da0a", "DMB MAF w/ MPEG Layer II aud, MOT slides, DLS, JPG/PNG/MNG images");
        O00000o0.put("da0b", "DMB MAF, extending DA0A, with 3GPP timed text, DID, TVA, REL, IPMP");
        O00000o0.put("da1a", "DMB MAF audio with ER-BSAC audio, JPG/PNG/MNG images");
        O00000o0.put("da1b", "DMB MAF, extending da1a, with 3GPP timed text, DID, TVA, REL, IPMP");
        O00000o0.put("da2a", "DMB MAF aud w/ HE-AAC v2 aud, MOT slides, DLS, JPG/PNG/MNG images");
        O00000o0.put("da2b", "DMB MAF, extending da2a, with 3GPP timed text, DID, TVA, REL, IPMP");
        O00000o0.put("da3a", "DMB MAF aud with HE-AAC aud, JPG/PNG/MNG images");
        O00000o0.put("da3b", "DMB MAF, extending da3a w/ BIFS, 3GPP timed text, DID, TVA, REL, IPMP");
        O00000o0.put("dmb1", "DMB MAF supporting all the components defined in the specification");
        O00000o0.put("dmpf", "Digital Media Project");
        O00000o0.put("drc1", "Dirac (wavelet compression), encapsulated in ISO base media (MP4)");
        O00000o0.put("dv1a", "DMB MAF vid w/ AVC vid, ER-BSAC aud, BIFS, JPG/PNG/MNG images, TS");
        O00000o0.put("dv1b", "DMB MAF, extending dv1a, with 3GPP timed text, DID, TVA, REL, IPMP");
        O00000o0.put("dv2a", "DMB MAF vid w/ AVC vid, HE-AAC v2 aud, BIFS, JPG/PNG/MNG images, TS");
        O00000o0.put("dv2b", "DMB MAF, extending dv2a, with 3GPP timed text, DID, TVA, REL, IPMP");
        O00000o0.put("dv3a", "DMB MAF vid w/ AVC vid, HE-AAC aud, BIFS, JPG/PNG/MNG images, TS");
        O00000o0.put("dv3b", "DMB MAF, extending dv3a, with 3GPP timed text, DID, TVA, REL, IPMP");
        O00000o0.put("dvr1", "DVB (.DVB) over RTP");
        O00000o0.put("dvt1", "DVB (.DVB) over MPEG-2 Transport Stream");
        O00000o0.put("F4V ", "Video for Adobe Flash Player 9+ (.F4V)");
        O00000o0.put("F4P ", "Protected Video for Adobe Flash Player 9+ (.F4P)");
        O00000o0.put("F4A ", "Audio for Adobe Flash Player 9+ (.F4A)");
        O00000o0.put("F4B ", "Audio Book for Adobe Flash Player 9+ (.F4B)");
        O00000o0.put("isc2", "ISMACryp 2.0 Encrypted File");
        O00000o0.put("iso2", "MP4 Base Media v2 [ISO 14496-12:2005]");
        O00000o0.put("isom", "MP4?? Base Media v1 [IS0 14496-12:2003]");
        O00000o0.put("JP2 ", "JPEG 2000 Image (.JP2) [ISO 15444-1 ?]");
        O00000o0.put("JP20", "Unknown, from GPAC samples (prob non-existent)");
        O00000o0.put("jpm ", "JPEG 2000 Compound Image (.JPM) [ISO 15444-6]");
        O00000o0.put("jpx ", "JPEG 2000 w/ extensions (.JPX) [ISO 15444-2]");
        O00000o0.put("KDDI", "3GPP2 EZmovie for KDDI 3G cellphones");
        O00000o0.put("M4A ", "Apple iTunes AAC-LC (.M4A) Audio");
        O00000o0.put("M4B ", "Apple iTunes AAC-LC (.M4B) Audio Book");
        O00000o0.put("M4P ", "Apple iTunes AAC-LC (.M4P) AES Protected Audio");
        O00000o0.put("M4V ", "Apple iTunes Video (.M4V) Video");
        O00000o0.put("M4VH", "Apple TV (.M4V)");
        O00000o0.put("M4VP", "Apple iPhone (.M4V)");
        O00000o0.put("mj2s", "Motion JPEG 2000 [ISO 15444-3] Simple Profile");
        O00000o0.put("mjp2", "Motion JPEG 2000 [ISO 15444-3] General Profile");
        O00000o0.put("mmp4", "MPEG-4/3GPP Mobile Profile (.MP4 / .3GP) (for NTT)");
        O00000o0.put("mp21", "MPEG-21 [ISO/IEC 21000-9]");
        O00000o0.put("mp41", "MP4 v1 [ISO 14496-1:ch13]");
        O00000o0.put("mp42", "MP4 v2 [ISO 14496-14]");
        O00000o0.put("mp71", "MP4 w/ MPEG-7 Metadata [per ISO 14496-12]");
        O00000o0.put("MPPI", "Photo Player, MAF [ISO/IEC 23000-3]");
        O00000o0.put("mqt ", "Sony / Mobile QuickTime (.MQV)?? US Patent 7,477,830 (Sony Corp)");
        O00000o0.put("MSNV", "MPEG-4 (.MP4) for SonyPSP");
        O00000o0.put("NDAS", "MP4 v2 [ISO 14496-14] Nero Digital AAC Audio");
        O00000o0.put("NDSC", "MPEG-4 (.MP4) Nero Cinema Profile");
        O00000o0.put("NDSH", "MPEG-4 (.MP4) Nero HDTV Profile");
        O00000o0.put("NDSM", "MPEG-4 (.MP4) Nero Mobile Profile");
        O00000o0.put("NDSP", "MPEG-4 (.MP4) Nero Portable Profile");
        O00000o0.put("NDSS", "MPEG-4 (.MP4) Nero Standard Profile");
        O00000o0.put("NDXC", "H.264/MPEG-4 AVC (.MP4) Nero Cinema Profile");
        O00000o0.put("NDXH", "H.264/MPEG-4 AVC (.MP4) Nero HDTV Profile");
        O00000o0.put("NDXM", "H.264/MPEG-4 AVC (.MP4) Nero Mobile Profile");
        O00000o0.put("NDXP", "H.264/MPEG-4 AVC (.MP4) Nero Portable Profile");
        O00000o0.put("NDXS", "H.264/MPEG-4 AVC (.MP4) Nero Standard Profile");
        O00000o0.put("odcf", "OMA DCF DRM Format 2.0 (OMA-TS-DRM-DCF-V2_0-20060303-A)");
        O00000o0.put("opf2", "OMA PDCF DRM Format 2.1 (OMA-TS-DRM-DCF-V2_1-20070724-C)");
        O00000o0.put("opx2", "OMA PDCF??DRM + XBS extensions (OMA-TS-DRM_XBS-V1_0-20070529-C)");
        O00000o0.put("pana", "Panasonic Digital Camera");
        O00000o0.put("qt  ", "Apple QuickTime (.MOV/QT)");
        O00000o0.put("ROSS", "Ross Video");
        O00000o0.put("sdv ", "SD Memory Card Video");
        O00000o0.put("ssc1", "Samsung stereoscopic, single stream (patent pending, see notes)");
        O00000o0.put("ssc2", "Samsung stereoscopic, dual stream (patent pending, see notes)");
        f12355O000000o.put(" KD ", "Kodak");
        f12355O000000o.put("AR.D", "Parrot AR.Drone");
        f12355O000000o.put("FFMP", "FFmpeg");
        f12355O000000o.put("GIC ", "General Imaging Co.");
        f12355O000000o.put("KMPI", "Konica-Minolta");
        f12355O000000o.put("NIKO", "Nikon");
        f12355O000000o.put("SMI ", "Sorenson Media Inc.");
        f12355O000000o.put("ZORA", "Zoran Corporation");
        f12355O000000o.put("appl", "Apple");
        f12355O000000o.put("fe20", "Olympus (fe20)");
        f12355O000000o.put("kdak", "Kodak");
        f12355O000000o.put("leic", "Leica");
        f12355O000000o.put("mino", "Minolta");
        f12355O000000o.put("niko", "Nikon");
        f12355O000000o.put("olym", "Olympus");
        f12355O000000o.put("pana", "Panasonic");
        f12355O000000o.put("pent", "Pentax");
        f12355O000000o.put("pr01", "Olympus (pr01)");
        f12355O000000o.put("sany", "Sanyo");
    }

    public static String O000000o(int i, String str) {
        return (!O00000Oo.containsKey(Integer.valueOf(i)) || !O00000Oo.get(Integer.valueOf(i)).containsKey(str)) ? "Unknown" : (String) O00000Oo.get(Integer.valueOf(i)).get(str);
    }

    public static void O000000o(int i, String str, xr xrVar) {
        xrVar.O000000o(i, O000000o(i, str));
    }
}
