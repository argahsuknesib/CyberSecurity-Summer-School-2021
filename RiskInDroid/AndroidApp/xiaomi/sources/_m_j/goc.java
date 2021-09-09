package _m_j;

import _m_j.gob;
import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class goc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final char[] f18080O000000o = {21621, 21710, 23433, 32942, 20985, 20843, 25344, 25203, 37030, 21253, 21329, 22868, 20283, 23620, 36793, 26631, 24971, 37024, 27103, 30326, 23788, 22163, 23111, 39137, 20179, 25805, 20874, 23934, 22092, 21449, 38039, 36799, 20261, 25220, 36710, 25275, 26621, 21507, 20805, 25277, 20986, 27451, 25571, 24029, 30126, 21561, 26486, 36916, 30133, 21254, 20945, 31895, 27718, 23828, 37032, 25619, 21649, 22823, 30136, 24403, 20992, 28098, 24471, 25189, 28783, 27664, 22002, 30008, 20993, 29241, 20163, 19999, 19996, 21783, 22047, 20595, 22534, 37907, 22810, 23104, 35830, 22848, 38821, 32780, 21457, 24070, 26041, 39134, 20998, 20016, 35205, 20175, 32017, 20245, 26094, 35813, 29976, 20872, 30347, 25096, 32102, 26681, 24218, 24037, 21246, 20272, 29916, 32619, 20851, 20809, 24402, 34926, 21593, 21704, 21683, 39032, 33472, 33983, 35779, 40658, 25323, 20136, 22135, 21565, 40769, 21282, 33457, 24576, 29375, 24031, 28784, 26127, 21529, 19980, 21152, 25099, 27743, 33405, 38454, 24062, 21156, 20866, 21244, 21258, 23071, 22104, 20891, 21652, 24320, 21002, 38390, 23611, 21308, 21067, 32943, 38444, 31354, 25248, 21043, 22840, 33967, 23485, 21281, 20111, 22372, 25193, 22403, 26469, 20848, 21879, 25438, 20162, 21202, 22596, 21013, 20486, 22849, 33391, 25769, 21015, 25294, 12295, 28316, 40857, 30620, 22108, 23048, 30055, 25249, 32599, 21603, 22920, 38718, 23258, 37017, 29483, 40636, 27794, 38376, 30015, 21674, 30496, 21941, 21673, 27665, 21517, 35884, 25720, 21726, 27626, 25295, 23419, 22241, 22218, 23404, 35767, 39297, 24641, 33021, 22958, 25288, 23330, 40479, 25423, 24744, 23425, 22942, 20892, 32698, 22900, 22907, 34384, 25386, 21908, 35764, 36276, 25293, 30469, 20051, 25243, 21624, 21943, 21257, 19989, 20559, 21117, 27669, 23000, 20050, 38027, 21078, 20166, 19971, 25488, 21315, 21595, 24708, 30335, 20405, 38737, 37019, 19992, 26354, 24366, 32570, 22795, 21605, 31331, 23046, 24825, 20154, 25172, 26085, 33592, 21433, 22914, 22567, 26741, 38384, 33509, 20200, 27618, 19977, 26706, 25531, 33394, 26862, 20711, 26432, 31579, 23665, 20260, 24368, 22882, 30003, 21319, 23608, 21454, 20070, 21047, 25684, 38377, 21452, 35841, 21550, 22913, 21430, 24554, 25436, 33487, 29435, 22794, 23385, 21766, 20182, 33492, 22349, 38132, 22834, 24529, 29093, 21076, 22825, 20347, 24086, 21381, 22258, 20599, 37568, 28237, 25512, 21534, 25176, 25366, 27498, 24367, 23594, 21361, 22637, 32705, 25373, 20800, 22805, 34430, 20186, 20065, 28785, 20123, 24515, 26143, 20982, 20241, 26100, 36713, 30134, 21195, 20011, 24697, 22830, 24186, 32822, 19968, 27437, 24212, 21727, 20323, 20248, 25180, 40482, 26352, 26197, 21277, 28797, 31948, 29250, 20654, 21017, 36156, 24590, 22679, 21522, 25434, 27838, 24352, 38026, 34567, 36126, 20105, 20043, 20013, 24030, 26417, 25235, 36329, 19987, 22918, 38585, 23442, 21331, 23388, 23447, 37049, 31199, 38075, 21404, 23562, 26152};
    public static final byte[][] O00000Oo = {new byte[]{65, 0, 0, 0, 0, 0}, new byte[]{65, 73, 0, 0, 0, 0}, new byte[]{65, 78, 0, 0, 0, 0}, new byte[]{65, 78, 71, 0, 0, 0}, new byte[]{65, 79, 0, 0, 0, 0}, new byte[]{66, 65, 0, 0, 0, 0}, new byte[]{66, 65, 73, 0, 0, 0}, new byte[]{66, 65, 78, 0, 0, 0}, new byte[]{66, 65, 78, 71, 0, 0}, new byte[]{66, 65, 79, 0, 0, 0}, new byte[]{66, 69, 73, 0, 0, 0}, new byte[]{66, 69, 78, 0, 0, 0}, new byte[]{66, 69, 78, 71, 0, 0}, new byte[]{66, 73, 0, 0, 0, 0}, new byte[]{66, 73, 65, 78, 0, 0}, new byte[]{66, 73, 65, 79, 0, 0}, new byte[]{66, 73, 69, 0, 0, 0}, new byte[]{66, 73, 78, 0, 0, 0}, new byte[]{66, 73, 78, 71, 0, 0}, new byte[]{66, 79, 0, 0, 0, 0}, new byte[]{66, 85, 0, 0, 0, 0}, new byte[]{67, 65, 0, 0, 0, 0}, new byte[]{67, 65, 73, 0, 0, 0}, new byte[]{67, 65, 78, 0, 0, 0}, new byte[]{67, 65, 78, 71, 0, 0}, new byte[]{67, 65, 79, 0, 0, 0}, new byte[]{67, 69, 0, 0, 0, 0}, new byte[]{67, 69, 78, 0, 0, 0}, new byte[]{67, 69, 78, 71, 0, 0}, new byte[]{67, 72, 65, 0, 0, 0}, new byte[]{67, 72, 65, 73, 0, 0}, new byte[]{67, 72, 65, 78, 0, 0}, new byte[]{67, 72, 65, 78, 71, 0}, new byte[]{67, 72, 65, 79, 0, 0}, new byte[]{67, 72, 69, 0, 0, 0}, new byte[]{67, 72, 69, 78, 0, 0}, new byte[]{67, 72, 69, 78, 71, 0}, new byte[]{67, 72, 73, 0, 0, 0}, new byte[]{67, 72, 79, 78, 71, 0}, new byte[]{67, 72, 79, 85, 0, 0}, new byte[]{67, 72, 85, 0, 0, 0}, new byte[]{67, 72, 85, 65, 0, 0}, new byte[]{67, 72, 85, 65, 73, 0}, new byte[]{67, 72, 85, 65, 78, 0}, new byte[]{67, 72, 85, 65, 78, 71}, new byte[]{67, 72, 85, 73, 0, 0}, new byte[]{67, 72, 85, 78, 0, 0}, new byte[]{67, 72, 85, 79, 0, 0}, new byte[]{67, 73, 0, 0, 0, 0}, new byte[]{67, 79, 78, 71, 0, 0}, new byte[]{67, 79, 85, 0, 0, 0}, new byte[]{67, 85, 0, 0, 0, 0}, new byte[]{67, 85, 65, 78, 0, 0}, new byte[]{67, 85, 73, 0, 0, 0}, new byte[]{67, 85, 78, 0, 0, 0}, new byte[]{67, 85, 79, 0, 0, 0}, new byte[]{68, 65, 0, 0, 0, 0}, new byte[]{68, 65, 73, 0, 0, 0}, new byte[]{68, 65, 78, 0, 0, 0}, new byte[]{68, 65, 78, 71, 0, 0}, new byte[]{68, 65, 79, 0, 0, 0}, new byte[]{68, 69, 0, 0, 0, 0}, new byte[]{68, 69, 73, 0, 0, 0}, new byte[]{68, 69, 78, 0, 0, 0}, new byte[]{68, 69, 78, 71, 0, 0}, new byte[]{68, 73, 0, 0, 0, 0}, new byte[]{68, 73, 65, 0, 0, 0}, new byte[]{68, 73, 65, 78, 0, 0}, new byte[]{68, 73, 65, 79, 0, 0}, new byte[]{68, 73, 69, 0, 0, 0}, new byte[]{68, 73, 78, 71, 0, 0}, new byte[]{68, 73, 85, 0, 0, 0}, new byte[]{68, 79, 78, 71, 0, 0}, new byte[]{68, 79, 85, 0, 0, 0}, new byte[]{68, 85, 0, 0, 0, 0}, new byte[]{68, 85, 65, 78, 0, 0}, new byte[]{68, 85, 73, 0, 0, 0}, new byte[]{68, 85, 78, 0, 0, 0}, new byte[]{68, 85, 79, 0, 0, 0}, new byte[]{69, 0, 0, 0, 0, 0}, new byte[]{69, 73, 0, 0, 0, 0}, new byte[]{69, 78, 0, 0, 0, 0}, new byte[]{69, 78, 71, 0, 0, 0}, new byte[]{69, 82, 0, 0, 0, 0}, new byte[]{70, 65, 0, 0, 0, 0}, new byte[]{70, 65, 78, 0, 0, 0}, new byte[]{70, 65, 78, 71, 0, 0}, new byte[]{70, 69, 73, 0, 0, 0}, new byte[]{70, 69, 78, 0, 0, 0}, new byte[]{70, 69, 78, 71, 0, 0}, new byte[]{70, 73, 65, 79, 0, 0}, new byte[]{70, 79, 0, 0, 0, 0}, new byte[]{70, 79, 85, 0, 0, 0}, new byte[]{70, 85, 0, 0, 0, 0}, new byte[]{71, 65, 0, 0, 0, 0}, new byte[]{71, 65, 73, 0, 0, 0}, new byte[]{71, 65, 78, 0, 0, 0}, new byte[]{71, 65, 78, 71, 0, 0}, new byte[]{71, 65, 79, 0, 0, 0}, new byte[]{71, 69, 0, 0, 0, 0}, new byte[]{71, 69, 73, 0, 0, 0}, new byte[]{71, 69, 78, 0, 0, 0}, new byte[]{71, 69, 78, 71, 0, 0}, new byte[]{71, 79, 78, 71, 0, 0}, new byte[]{71, 79, 85, 0, 0, 0}, new byte[]{71, 85, 0, 0, 0, 0}, new byte[]{71, 85, 65, 0, 0, 0}, new byte[]{71, 85, 65, 73, 0, 0}, new byte[]{71, 85, 65, 78, 0, 0}, new byte[]{71, 85, 65, 78, 71, 0}, new byte[]{71, 85, 73, 0, 0, 0}, new byte[]{71, 85, 78, 0, 0, 0}, new byte[]{71, 85, 79, 0, 0, 0}, new byte[]{72, 65, 0, 0, 0, 0}, new byte[]{72, 65, 73, 0, 0, 0}, new byte[]{72, 65, 78, 0, 0, 0}, new byte[]{72, 65, 78, 71, 0, 0}, new byte[]{72, 65, 79, 0, 0, 0}, new byte[]{72, 69, 0, 0, 0, 0}, new byte[]{72, 69, 73, 0, 0, 0}, new byte[]{72, 69, 78, 0, 0, 0}, new byte[]{72, 69, 78, 71, 0, 0}, new byte[]{72, 77, 0, 0, 0, 0}, new byte[]{72, 79, 78, 71, 0, 0}, new byte[]{72, 79, 85, 0, 0, 0}, new byte[]{72, 85, 0, 0, 0, 0}, new byte[]{72, 85, 65, 0, 0, 0}, new byte[]{72, 85, 65, 73, 0, 0}, new byte[]{72, 85, 65, 78, 0, 0}, new byte[]{72, 85, 65, 78, 71, 0}, new byte[]{72, 85, 73, 0, 0, 0}, new byte[]{72, 85, 78, 0, 0, 0}, new byte[]{72, 85, 79, 0, 0, 0}, new byte[]{74, 73, 0, 0, 0, 0}, new byte[]{74, 73, 65, 0, 0, 0}, new byte[]{74, 73, 65, 78, 0, 0}, new byte[]{74, 73, 65, 78, 71, 0}, new byte[]{74, 73, 65, 79, 0, 0}, new byte[]{74, 73, 69, 0, 0, 0}, new byte[]{74, 73, 78, 0, 0, 0}, new byte[]{74, 73, 78, 71, 0, 0}, new byte[]{74, 73, 79, 78, 71, 0}, new byte[]{74, 73, 85, 0, 0, 0}, new byte[]{74, 85, 0, 0, 0, 0}, new byte[]{74, 85, 65, 78, 0, 0}, new byte[]{74, 85, 69, 0, 0, 0}, new byte[]{74, 85, 78, 0, 0, 0}, new byte[]{75, 65, 0, 0, 0, 0}, new byte[]{75, 65, 73, 0, 0, 0}, new byte[]{75, 65, 78, 0, 0, 0}, new byte[]{75, 65, 78, 71, 0, 0}, new byte[]{75, 65, 79, 0, 0, 0}, new byte[]{75, 69, 0, 0, 0, 0}, new byte[]{75, 69, 73, 0, 0, 0}, new byte[]{75, 69, 78, 0, 0, 0}, new byte[]{75, 69, 78, 71, 0, 0}, new byte[]{75, 79, 78, 71, 0, 0}, new byte[]{75, 79, 85, 0, 0, 0}, new byte[]{75, 85, 0, 0, 0, 0}, new byte[]{75, 85, 65, 0, 0, 0}, new byte[]{75, 85, 65, 73, 0, 0}, new byte[]{75, 85, 65, 78, 0, 0}, new byte[]{75, 85, 65, 78, 71, 0}, new byte[]{75, 85, 73, 0, 0, 0}, new byte[]{75, 85, 78, 0, 0, 0}, new byte[]{75, 85, 79, 0, 0, 0}, new byte[]{76, 65, 0, 0, 0, 0}, new byte[]{76, 65, 73, 0, 0, 0}, new byte[]{76, 65, 78, 0, 0, 0}, new byte[]{76, 65, 78, 71, 0, 0}, new byte[]{76, 65, 79, 0, 0, 0}, new byte[]{76, 69, 0, 0, 0, 0}, new byte[]{76, 69, 73, 0, 0, 0}, new byte[]{76, 69, 78, 71, 0, 0}, new byte[]{76, 73, 0, 0, 0, 0}, new byte[]{76, 73, 65, 0, 0, 0}, new byte[]{76, 73, 65, 78, 0, 0}, new byte[]{76, 73, 65, 78, 71, 0}, new byte[]{76, 73, 65, 79, 0, 0}, new byte[]{76, 73, 69, 0, 0, 0}, new byte[]{76, 73, 78, 0, 0, 0}, new byte[]{76, 73, 78, 71, 0, 0}, new byte[]{76, 73, 85, 0, 0, 0}, new byte[]{76, 79, 78, 71, 0, 0}, new byte[]{76, 79, 85, 0, 0, 0}, new byte[]{76, 85, 0, 0, 0, 0}, new byte[]{76, 85, 65, 78, 0, 0}, new byte[]{76, 85, 69, 0, 0, 0}, new byte[]{76, 85, 78, 0, 0, 0}, new byte[]{76, 85, 79, 0, 0, 0}, new byte[]{77, 0, 0, 0, 0, 0}, new byte[]{77, 65, 0, 0, 0, 0}, new byte[]{77, 65, 73, 0, 0, 0}, new byte[]{77, 65, 78, 0, 0, 0}, new byte[]{77, 65, 78, 71, 0, 0}, new byte[]{77, 65, 79, 0, 0, 0}, new byte[]{77, 69, 0, 0, 0, 0}, new byte[]{77, 69, 73, 0, 0, 0}, new byte[]{77, 69, 78, 0, 0, 0}, new byte[]{77, 69, 78, 71, 0, 0}, new byte[]{77, 73, 0, 0, 0, 0}, new byte[]{77, 73, 65, 78, 0, 0}, new byte[]{77, 73, 65, 79, 0, 0}, new byte[]{77, 73, 69, 0, 0, 0}, new byte[]{77, 73, 78, 0, 0, 0}, new byte[]{77, 73, 78, 71, 0, 0}, new byte[]{77, 73, 85, 0, 0, 0}, new byte[]{77, 79, 0, 0, 0, 0}, new byte[]{77, 79, 85, 0, 0, 0}, new byte[]{77, 85, 0, 0, 0, 0}, new byte[]{78, 65, 0, 0, 0, 0}, new byte[]{78, 65, 73, 0, 0, 0}, new byte[]{78, 65, 78, 0, 0, 0}, new byte[]{78, 65, 78, 71, 0, 0}, new byte[]{78, 65, 79, 0, 0, 0}, new byte[]{78, 69, 0, 0, 0, 0}, new byte[]{78, 69, 73, 0, 0, 0}, new byte[]{78, 69, 78, 0, 0, 0}, new byte[]{78, 69, 78, 71, 0, 0}, new byte[]{78, 73, 0, 0, 0, 0}, new byte[]{78, 73, 65, 78, 0, 0}, new byte[]{78, 73, 65, 78, 71, 0}, new byte[]{78, 73, 65, 79, 0, 0}, new byte[]{78, 73, 69, 0, 0, 0}, new byte[]{78, 73, 78, 0, 0, 0}, new byte[]{78, 73, 78, 71, 0, 0}, new byte[]{78, 73, 85, 0, 0, 0}, new byte[]{78, 79, 78, 71, 0, 0}, new byte[]{78, 79, 85, 0, 0, 0}, new byte[]{78, 85, 0, 0, 0, 0}, new byte[]{78, 85, 65, 78, 0, 0}, new byte[]{78, 85, 69, 0, 0, 0}, new byte[]{78, 85, 79, 0, 0, 0}, new byte[]{79, 0, 0, 0, 0, 0}, new byte[]{79, 85, 0, 0, 0, 0}, new byte[]{80, 65, 0, 0, 0, 0}, new byte[]{80, 65, 73, 0, 0, 0}, new byte[]{80, 65, 78, 0, 0, 0}, new byte[]{80, 65, 78, 71, 0, 0}, new byte[]{80, 65, 79, 0, 0, 0}, new byte[]{80, 69, 73, 0, 0, 0}, new byte[]{80, 69, 78, 0, 0, 0}, new byte[]{80, 69, 78, 71, 0, 0}, new byte[]{80, 73, 0, 0, 0, 0}, new byte[]{80, 73, 65, 78, 0, 0}, new byte[]{80, 73, 65, 79, 0, 0}, new byte[]{80, 73, 69, 0, 0, 0}, new byte[]{80, 73, 78, 0, 0, 0}, new byte[]{80, 73, 78, 71, 0, 0}, new byte[]{80, 79, 0, 0, 0, 0}, new byte[]{80, 79, 85, 0, 0, 0}, new byte[]{80, 85, 0, 0, 0, 0}, new byte[]{81, 73, 0, 0, 0, 0}, new byte[]{81, 73, 65, 0, 0, 0}, new byte[]{81, 73, 65, 78, 0, 0}, new byte[]{81, 73, 65, 78, 71, 0}, new byte[]{81, 73, 65, 79, 0, 0}, new byte[]{81, 73, 69, 0, 0, 0}, new byte[]{81, 73, 78, 0, 0, 0}, new byte[]{81, 73, 78, 71, 0, 0}, new byte[]{81, 73, 79, 78, 71, 0}, new byte[]{81, 73, 85, 0, 0, 0}, new byte[]{81, 85, 0, 0, 0, 0}, new byte[]{81, 85, 65, 78, 0, 0}, new byte[]{81, 85, 69, 0, 0, 0}, new byte[]{81, 85, 78, 0, 0, 0}, new byte[]{82, 65, 78, 0, 0, 0}, new byte[]{82, 65, 78, 71, 0, 0}, new byte[]{82, 65, 79, 0, 0, 0}, new byte[]{82, 69, 0, 0, 0, 0}, new byte[]{82, 69, 78, 0, 0, 0}, new byte[]{82, 69, 78, 71, 0, 0}, new byte[]{82, 73, 0, 0, 0, 0}, new byte[]{82, 79, 78, 71, 0, 0}, new byte[]{82, 79, 85, 0, 0, 0}, new byte[]{82, 85, 0, 0, 0, 0}, new byte[]{82, 85, 65, 78, 0, 0}, new byte[]{82, 85, 73, 0, 0, 0}, new byte[]{82, 85, 78, 0, 0, 0}, new byte[]{82, 85, 79, 0, 0, 0}, new byte[]{83, 65, 0, 0, 0, 0}, new byte[]{83, 65, 73, 0, 0, 0}, new byte[]{83, 65, 78, 0, 0, 0}, new byte[]{83, 65, 78, 71, 0, 0}, new byte[]{83, 65, 79, 0, 0, 0}, new byte[]{83, 69, 0, 0, 0, 0}, new byte[]{83, 69, 78, 0, 0, 0}, new byte[]{83, 69, 78, 71, 0, 0}, new byte[]{83, 72, 65, 0, 0, 0}, new byte[]{83, 72, 65, 73, 0, 0}, new byte[]{83, 72, 65, 78, 0, 0}, new byte[]{83, 72, 65, 78, 71, 0}, new byte[]{83, 72, 65, 79, 0, 0}, new byte[]{83, 72, 69, 0, 0, 0}, new byte[]{83, 72, 69, 78, 0, 0}, new byte[]{83, 72, 69, 78, 71, 0}, new byte[]{83, 72, 73, 0, 0, 0}, new byte[]{83, 72, 79, 85, 0, 0}, new byte[]{83, 72, 85, 0, 0, 0}, new byte[]{83, 72, 85, 65, 0, 0}, new byte[]{83, 72, 85, 65, 73, 0}, new byte[]{83, 72, 85, 65, 78, 0}, new byte[]{83, 72, 85, 65, 78, 71}, new byte[]{83, 72, 85, 73, 0, 0}, new byte[]{83, 72, 85, 78, 0, 0}, new byte[]{83, 72, 85, 79, 0, 0}, new byte[]{83, 73, 0, 0, 0, 0}, new byte[]{83, 79, 78, 71, 0, 0}, new byte[]{83, 79, 85, 0, 0, 0}, new byte[]{83, 85, 0, 0, 0, 0}, new byte[]{83, 85, 65, 78, 0, 0}, new byte[]{83, 85, 73, 0, 0, 0}, new byte[]{83, 85, 78, 0, 0, 0}, new byte[]{83, 85, 79, 0, 0, 0}, new byte[]{84, 65, 0, 0, 0, 0}, new byte[]{84, 65, 73, 0, 0, 0}, new byte[]{84, 65, 78, 0, 0, 0}, new byte[]{84, 65, 78, 71, 0, 0}, new byte[]{84, 65, 79, 0, 0, 0}, new byte[]{84, 69, 0, 0, 0, 0}, new byte[]{84, 69, 78, 71, 0, 0}, new byte[]{84, 73, 0, 0, 0, 0}, new byte[]{84, 73, 65, 78, 0, 0}, new byte[]{84, 73, 65, 79, 0, 0}, new byte[]{84, 73, 69, 0, 0, 0}, new byte[]{84, 73, 78, 71, 0, 0}, new byte[]{84, 79, 78, 71, 0, 0}, new byte[]{84, 79, 85, 0, 0, 0}, new byte[]{84, 85, 0, 0, 0, 0}, new byte[]{84, 85, 65, 78, 0, 0}, new byte[]{84, 85, 73, 0, 0, 0}, new byte[]{84, 85, 78, 0, 0, 0}, new byte[]{84, 85, 79, 0, 0, 0}, new byte[]{87, 65, 0, 0, 0, 0}, new byte[]{87, 65, 73, 0, 0, 0}, new byte[]{87, 65, 78, 0, 0, 0}, new byte[]{87, 65, 78, 71, 0, 0}, new byte[]{87, 69, 73, 0, 0, 0}, new byte[]{87, 69, 78, 0, 0, 0}, new byte[]{87, 69, 78, 71, 0, 0}, new byte[]{87, 79, 0, 0, 0, 0}, new byte[]{87, 85, 0, 0, 0, 0}, new byte[]{88, 73, 0, 0, 0, 0}, new byte[]{88, 73, 65, 0, 0, 0}, new byte[]{88, 73, 65, 78, 0, 0}, new byte[]{88, 73, 65, 78, 71, 0}, new byte[]{88, 73, 65, 79, 0, 0}, new byte[]{88, 73, 69, 0, 0, 0}, new byte[]{88, 73, 78, 0, 0, 0}, new byte[]{88, 73, 78, 71, 0, 0}, new byte[]{88, 73, 79, 78, 71, 0}, new byte[]{88, 73, 85, 0, 0, 0}, new byte[]{88, 85, 0, 0, 0, 0}, new byte[]{88, 85, 65, 78, 0, 0}, new byte[]{88, 85, 69, 0, 0, 0}, new byte[]{88, 85, 78, 0, 0, 0}, new byte[]{89, 65, 0, 0, 0, 0}, new byte[]{89, 65, 78, 0, 0, 0}, new byte[]{89, 65, 78, 71, 0, 0}, new byte[]{89, 65, 79, 0, 0, 0}, new byte[]{89, 69, 0, 0, 0, 0}, new byte[]{89, 73, 0, 0, 0, 0}, new byte[]{89, 73, 78, 0, 0, 0}, new byte[]{89, 73, 78, 71, 0, 0}, new byte[]{89, 79, 0, 0, 0, 0}, new byte[]{89, 79, 78, 71, 0, 0}, new byte[]{89, 79, 85, 0, 0, 0}, new byte[]{89, 85, 0, 0, 0, 0}, new byte[]{89, 85, 65, 78, 0, 0}, new byte[]{89, 85, 69, 0, 0, 0}, new byte[]{89, 85, 78, 0, 0, 0}, new byte[]{90, 65, 0, 0, 0, 0}, new byte[]{90, 65, 73, 0, 0, 0}, new byte[]{90, 65, 78, 0, 0, 0}, new byte[]{90, 65, 78, 71, 0, 0}, new byte[]{90, 65, 79, 0, 0, 0}, new byte[]{90, 69, 0, 0, 0, 0}, new byte[]{90, 69, 73, 0, 0, 0}, new byte[]{90, 69, 78, 0, 0, 0}, new byte[]{90, 69, 78, 71, 0, 0}, new byte[]{90, 72, 65, 0, 0, 0}, new byte[]{90, 72, 65, 73, 0, 0}, new byte[]{90, 72, 65, 78, 0, 0}, new byte[]{90, 72, 65, 78, 71, 0}, new byte[]{90, 72, 65, 79, 0, 0}, new byte[]{90, 72, 69, 0, 0, 0}, new byte[]{90, 72, 69, 78, 0, 0}, new byte[]{90, 72, 69, 78, 71, 0}, new byte[]{90, 72, 73, 0, 0, 0}, new byte[]{90, 72, 79, 78, 71, 0}, new byte[]{90, 72, 79, 85, 0, 0}, new byte[]{90, 72, 85, 0, 0, 0}, new byte[]{90, 72, 85, 65, 0, 0}, new byte[]{90, 72, 85, 65, 73, 0}, new byte[]{90, 72, 85, 65, 78, 0}, new byte[]{90, 72, 85, 65, 78, 71}, new byte[]{90, 72, 85, 73, 0, 0}, new byte[]{90, 72, 85, 78, 0, 0}, new byte[]{90, 72, 85, 79, 0, 0}, new byte[]{90, 73, 0, 0, 0, 0}, new byte[]{90, 79, 78, 71, 0, 0}, new byte[]{90, 79, 85, 0, 0, 0}, new byte[]{90, 85, 0, 0, 0, 0}, new byte[]{90, 85, 65, 78, 0, 0}, new byte[]{90, 85, 73, 0, 0, 0}, new byte[]{90, 85, 78, 0, 0, 0}, new byte[]{90, 85, 79, 0, 0, 0}};
    private static HashMap<String, String[]> O00000o = new HashMap<>();
    private static HashMap<Character, String[]> O00000o0 = new HashMap<>();
    private static HashMap<Character, String> O00000oO = new HashMap<>();
    private static final Collator O00000oo = Collator.getInstance(Locale.CHINA);
    private static goc O0000O0o;
    private static final char[] O0000Oo0 = {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};
    private final boolean O0000OOo = true;

    static {
        O00000o0.put(38463, new String[]{"A", "E"});
        O00000o0.put(33100, new String[]{"YAN", "A"});
        O00000o0.put(25303, new String[]{"AO", "O", "NIU"});
        O00000o0.put(25170, new String[]{"PA", "BA"});
        O00000o0.put(34444, new String[]{"BANG", "BENG"});
        O00000o0.put(34180, new String[]{"BAO", "BO"});
        O00000o0.put(22561, new String[]{"BAO", "BU", "PU"});
        O00000o0.put(26292, new String[]{"BAO", "PU"});
        O00000o0.put(36146, new String[]{"BEN", "FEI", "BI"});
        O00000o0.put(36153, new String[]{"FEI", "BI"});
        O00000o0.put(33218, new String[]{"BI", "BEI"});
        O00000o0.put(36767, new String[]{"PI", "BI"});
        O00000o0.put(33536, new String[]{"FU", "BI"});
        O00000o0.put(25153, new String[]{"BIAN", "PIAN"});
        O00000o0.put(20415, new String[]{"BIAN", "PIAN"});
        O00000o0.put(33152, new String[]{"PANG", "BANG"});
        O00000o0.put(30917, new String[]{"PANG", "BANG"});
        O00000o0.put(39584, new String[]{"BIAO", "PIAO"});
        O00000o0.put(30058, new String[]{"FAN", "PAN", "BO"});
        O00000o0.put(23387, new String[]{"BEI", "BO"});
        O00000o0.put(24223, new String[]{"FEI", "BO"});
        O00000o0.put(21093, new String[]{"BO", "BAO", "XUE"});
        O00000o0.put(27850, new String[]{"BO", "PO", "BAN"});
        O00000o0.put(20271, new String[]{"BO", "BAI"});
        O00000o0.put(21340, new String[]{"BO", "BU"});
        O00000o0.put(20263, new String[]{"CANG", "CHEN"});
        O00000o0.put(34255, new String[]{"CANG", "ZANG"});
        O00000o0.put(21442, new String[]{"CAN", "SHEN", "CEN"});
        O00000o0.put(26366, new String[]{"CENG", "ZENG"});
        O00000o0.put(22092, new String[]{"CENG", "CHENG"});
        O00000o0.put(24046, new String[]{"CHA", "CHAI"});
        O00000o0.put(26597, new String[]{"CHA", "ZHA"});
        O00000o0.put(31109, new String[]{"CHAN", "SHAN"});
        O00000o0.put(39076, new String[]{"CHAN", "ZHAN"});
        O00000o0.put(23409, new String[]{"CHAN", "CAN"});
        O00000o0.put(35059, new String[]{"SHANG", "CHANG"});
        O00000o0.put(22330, new String[]{"CHANG", "CHANG"});
        O00000o0.put(26216, new String[]{"CHEN", "CHANG", "ZE"});
        O00000o0.put(38271, new String[]{"CHANG", "ZHANG"});
        O00000o0.put(21378, new String[]{"CHANG", "AN", "HAN"});
        O00000o0.put(22066, new String[]{"CHAO", "ZHAO", "ZHA"});
        O00000o0.put(36710, new String[]{"CHE", "JU"});
        O00000o0.put(31216, new String[]{"CHENG", "CHEN"});
        O00000o0.put(28548, new String[]{"CHENG", "DENG"});
        O00000o0.put(38107, new String[]{"DANG", "CHENG"});
        O00000o0.put(20056, new String[]{"CHENG", "SHENG"});
        O00000o0.put(26397, new String[]{"CHAO", "ZHAO"});
        O00000o0.put(38241, new String[]{"XIN", "CHAN", "TAN"});
        O00000o0.put(21273, new String[]{"SHI", "CHI"});
        O00000o0.put(37079, new String[]{"XI", "CHI"});
        O00000o0.put(27835, new String[]{"ZHI", "CHI"});
        O00000o0.put(30259, new String[]{"CHOU", "LU"});
        O00000o0.put(19985, new String[]{"CHOU", "NIU"});
        O00000o0.put(33261, new String[]{"CHOU", "XIU"});
        O00000o0.put(37325, new String[]{"ZHONG", "CHONG"});
        O00000o0.put(31181, new String[]{"ZHONG", "CHONG"});
        O00000o0.put(30044, new String[]{"CHU", "XU"});
        O00000o0.put(38500, new String[]{"CHU", "XU"});
        O00000o0.put(20256, new String[]{"CHUAN", "ZHUAN"});
        O00000o0.put(21852, new String[]{"CHUO", "CHUAI"});
        O00000o0.put(32496, new String[]{"CHUO", "CHAO"});
        O00000o0.put(35098, new String[]{"ZHU", "CHU", "ZHE"});
        O00000o0.put(26894, new String[]{"ZHUI", "CHUI"});
        O00000o0.put(27425, new String[]{"CI", "CHI", "QI"});
        O00000o0.put(20282, new String[]{"CI", "SI"});
        O00000o0.put(20857, new String[]{"ZI", "CI"});
        O00000o0.put(26526, new String[]{"CONG", "ZONG"});
        O00000o0.put(25874, new String[]{"CUAN", "ZAN"});
        O00000o0.put(21330, new String[]{"ZU", "CU"});
        O00000o0.put(34928, new String[]{"SHUAI", "CUI"});
        O00000o0.put(25774, new String[]{"CUO", "ZUO"});
        O00000o0.put(22823, new String[]{"DA", "DAI"});
        O00000o0.put(27795, new String[]{"TA", "DA"});
        O00000o0.put(21333, new String[]{"DAN", "CHAN", "SHAN"});
        O00000o0.put(21480, new String[]{"DAO", "TAO"});
        O00000o0.put(25552, new String[]{"TI", "DI"});
        O00000o0.put(36934, new String[]{"DI", "TI"});
        O00000o0.put(32735, new String[]{"DI", "ZHAI"});
        O00000o0.put(24471, new String[]{"DE", "DEI"});
        O00000o0.put(38079, new String[]{"DIAN", "TIAN"});
        O00000o0.put(20291, new String[]{"DIAN", "TIAN"});
        O00000o0.put(20992, new String[]{"DAO", "DIAO"});
        O00000o0.put(35843, new String[]{"DIAO", "TIAO"});
        O00000o0.put(37117, new String[]{"DOU", "DU"});
        O00000o0.put(24230, new String[]{"DU", "DUO"});
        O00000o0.put(22244, new String[]{"TUN", "DUN"});
        O00000o0.put(21542, new String[]{"FOU", "PI"});
        O00000o0.put(33071, new String[]{"PU", "FU"});
        O00000o0.put(36711, new String[]{"YA", "ZHA", "GA"});
        O00000o0.put(25179, new String[]{"KANG", "GANG"});
        O00000o0.put(30422, new String[]{"GAI", "GE"});
        O00000o0.put(21679, new String[]{"GE", "KA", "LO"});
        O00000o0.put(38761, new String[]{"GE", "JI"});
        O00000o0.put(21512, new String[]{"HE", "GE"});
        O00000o0.put(32473, new String[]{"GEI", "JI"});
        O00000o0.put(39048, new String[]{"JING", "GENG"});
        O00000o0.put(32418, new String[]{"HONG", "GONG"});
        O00000o0.put(26552, new String[]{"GOU", "JU"});
        O00000o0.put(21617, new String[]{"GUA", "GU"});
        O00000o0.put(35895, new String[]{"GU", "YU"});
        O00000o0.put(34411, new String[]{"CHONG", "GU"});
        O00000o0.put(40516, new String[]{"HU", "GU"});
        O00000o0.put(25324, new String[]{"KUO", "GUA"});
        O00000o0.put(33694, new String[]{"GUAN", "WAN"});
        O00000o0.put(32438, new String[]{"LUN", "GUAN"});
        O00000o0.put(28805, new String[]{"JIONG", "GUI"});
        O00000o0.put(26727, new String[]{"GUI", "HUI"});
        O00000o0.put(28820, new String[]{"QUE", "GUI"});
        O00000o0.put(26123, new String[]{"GUI", "JIONG"});
        O00000o0.put(20250, new String[]{"HUI", "KUAI", "GUI"});
        O00000o0.put(33445, new String[]{"JIE", "GAI"});
        O00000o0.put(34430, new String[]{"XIA", "HA"});
        O00000o0.put(36713, new String[]{"XUAN", "HAN"});
        O00000o0.put(25750, new String[]{"KAN", "HAN"});
        O00000o0.put(21683, new String[]{"KE", "HAI"});
        O00000o0.put(24055, new String[]{"XIANG", "HANG"});
        O00000o0.put(21549, new String[]{"KENG", "HANG"});
        O00000o0.put(40664, new String[]{"MO", "HE", "MEI"});
        O00000o0.put(21644, new String[]{"HE", "HU", "HUO"});
        O00000o0.put(35977, new String[]{"HE", "HAO"});
        O00000o0.put(40657, new String[]{"HEI", "HE"});
        O00000o0.put(34425, new String[]{"HONG", "JIANG"});
        O00000o0.put(37063, new String[]{"XUN", "HUAN"});
        O00000o0.put(23536, new String[]{"HUAN", "XIAN"});
        O00000o0.put(22855, new String[]{"QI", "JI"});
        O00000o0.put(32521, new String[]{"JI", "QI"});
        O00000o0.put(20552, new String[]{"JIE", "JI"});
        O00000o0.put(31995, new String[]{"XI", "JI"});
        O00000o0.put(31293, new String[]{"JI", "QI"});
        O00000o0.put(20127, new String[]{"JI", "QI"});
        O00000o0.put(35800, new String[]{"JIE", "JI"});
        O00000o0.put(35760, new String[]{"JI", "JIE"});
        O00000o0.put(21095, new String[]{"JU", "JI"});
        O00000o0.put(31085, new String[]{"JI", "ZHA", "ZHAI"});
        O00000o0.put(33540, new String[]{"QIE", "JIA"});
        O00000o0.put(22204, new String[]{"JIAO", "JUE"});
        O00000o0.put(20389, new String[]{"JIAO", "YAO"});
        O00000o0.put(35282, new String[]{"JIAO", "JUE"});
        O00000o0.put(33050, new String[]{"JIAO", "JUE"});
        O00000o0.put(21119, new String[]{"JIAO", "CHAO"});
        O00000o0.put(26657, new String[]{"XIAO", "JIAO"});
        O00000o0.put(32564, new String[]{"JIAO", "ZHUO"});
        O00000o0.put(35265, new String[]{"JIAN", "XIAN"});
        O00000o0.put(38477, new String[]{"XIANG", "LONG", "JIANG"});
        O00000o0.put(35299, new String[]{"JIE", "XIE"});
        O00000o0.put(34249, new String[]{"JIE", "JI"});
        O00000o0.put(30684, new String[]{"JIN", "QIN"});
        O00000o0.put(21170, new String[]{"JIN", "JING"});
        O00000o0.put(40863, new String[]{"GUI", "QIU", "CI", "JUN"});
        O00000o0.put(21632, new String[]{"JU", "ZUI"});
        O00000o0.put(29722, new String[]{"JU", "QU"});
        O00000o0.put(33740, new String[]{"JUN", "XUN"});
        O00000o0.put(38589, new String[]{"JUN", "JUAN"});
        O00000o0.put(21345, new String[]{"KA", "QIA"});
        O00000o0.put(30475, new String[]{"KAN", "KAN"});
        O00000o0.put(25000, new String[]{"HAN", "KAN"});
        O00000o0.put(22391, new String[]{"KE", "KE"});
        O00000o0.put(22771, new String[]{"KE", "QIA"});
        O00000o0.put(20811, new String[]{"KE", "KEI"});
        O00000o0.put(38752, new String[]{"KAO", "KU"});
        O00000o0.put(38551, new String[]{"WEI", "KUI"});
        O00000o0.put(39740, new String[]{"GUI", "WEI", "KUI"});
        O00000o0.put(33554, new String[]{"KUANG", "GUAN", "YUAN"});
        O00000o0.put(21895, new String[]{"LA", "YAO"});
        O00000o0.put(34013, new String[]{"LAN", "PIE"});
        O00000o0.put(28889, new String[]{"LAO", "LUO", "PAO"});
        O00000o0.put(38610, new String[]{"LUO", "LAO"});
        O00000o0.put(32907, new String[]{"LE", "LEI"});
        O00000o0.put(20048, new String[]{"LE", "YUE"});
        O00000o0.put(20102, new String[]{"LE", "LIAO"});
        O00000o0.put(20457, new String[]{"LIANG", "LIA"});
        O00000o0.put(28518, new String[]{"LIAO", "LAO"});
        O00000o0.put(30860, new String[]{"LU", "ZHOU", "LIU"});
        O00000o0.put(20603, new String[]{"LOU", "LU"});
        O00000o0.put(38706, new String[]{"LU", "LOU"});
        O00000o0.put(25419, new String[]{"LU", "LUO"});
        O00000o0.put(32511, new String[]{"LV", "LU"});
        O00000o0.put(20845, new String[]{"LIU", "LU"});
        O00000o0.put(32476, new String[]{"LUO", "LAO"});
        O00000o0.put(33853, new String[]{"LUO", "LAO", "LA"});
        O00000o0.put(25273, new String[]{"MA", "MO"});
        O00000o0.put(33033, new String[]{"MAI", "MO"});
        O00000o0.put(22475, new String[]{"MAI", "MAN"});
        O00000o0.put(34067, new String[]{"MAN", "WAN"});
        O00000o0.put(27667, new String[]{"MANG", "MENG"});
        O00000o0.put(27809, new String[]{"MEI", "MO"});
        O00000o0.put(31192, new String[]{"MI", "BI"});
        O00000o0.put(27852, new String[]{"MI", "BI"});
        O00000o0.put(20340, new String[]{"MI", "NAI", "NI"});
        O00000o0.put(35884, new String[]{"MIAO", "MIU"});
        O00000o0.put(27169, new String[]{"MO", "MU"});
        O00000o0.put(25705, new String[]{"MO", "MA", "SA"});
        O00000o0.put(27597, new String[]{"MU", "WU"});
        O00000o0.put(32554, new String[]{"MIU", "MIAO", "MOU"});
        O00000o0.put(24324, new String[]{"NONG", "LONG"});
        O00000o0.put(38590, new String[]{"NAN", "NING"});
        O00000o0.put(30111, new String[]{"NUE", "YAO"});
        O00000o0.put(20060, new String[]{"MIE", "NIE"});
        O00000o0.put(23068, new String[]{"NA", "NUO"});
        O00000o0.put(21306, new String[]{"QU", "OU"});
        O00000o0.put(32321, new String[]{"FAN", "PO"});
        O00000o0.put(36843, new String[]{"PO", "PAI"});
        O00000o0.put(32982, new String[]{"PANG", "PAN"});
        O00000o0.put(21032, new String[]{"PAO", "BAO"});
        O00000o0.put(28846, new String[]{"PAO", "BAO"});
        O00000o0.put(36898, new String[]{"FENG", "PANG"});
        O00000o0.put(34028, new String[]{"PENG", "PANG"});
        O00000o0.put(26420, new String[]{"PU", "PO", "PIAO"});
        O00000o0.put(28689, new String[]{"PU", "BAO"});
        O00000o0.put(26333, new String[]{"BAO", "PU"});
        O00000o0.put(26646, new String[]{"XI", "QI"});
        O00000o0.put(36426, new String[]{"XI", "QI"});
        O00000o0.put(31293, new String[]{"JI", "QI"});
        O00000o0.put(33640, new String[]{"XUN", "QIAN"});
        O00000o0.put(31140, new String[]{"QIAN", "XUAN"});
        O00000o0.put(24378, new String[]{"QIANG", "JIANG"});
        O00000o0.put(36228, new String[]{"QIE", "JU"});
        O00000o0.put(20146, new String[]{"QIN", "QING"});
        O00000o0.put(38592, new String[]{"QUE", "QIAO"});
        O00000o0.put(20167, new String[]{"CHOU", "QIU"});
        O00000o0.put(22280, new String[]{"QUAN", "JUAN"});
        O00000o0.put(33394, new String[]{"SE", "SHAI"});
        O00000o0.put(22622, new String[]{"SAI", "SE"});
        O00000o0.put(21414, new String[]{"XIA", "SHA"});
        O00000o0.put(21484, new String[]{"ZHAO", "SHAO"});
        O00000o0.put(26441, new String[]{"SHAN", "SHA"});
        O00000o0.put(27748, new String[]{"TANG", "SHANG"});
        O00000o0.put(25342, new String[]{"SHI", "SHE"});
        O00000o0.put(25240, new String[]{"ZHE", "SHE"});
        O00000o0.put(20160, new String[]{"SHEN", "SHI"});
        O00000o0.put(33882, new String[]{"SHEN", "REN"});
        O00000o0.put(35782, new String[]{"SHI", "ZHI"});
        O00000o0.put(20284, new String[]{"SI", "SHI"});
        O00000o0.put(23646, new String[]{"SHU", "ZHU"});
        O00000o0.put(29087, new String[]{"SHU", "SHOU"});
        O00000o0.put(35828, new String[]{"SHUO", "SHUI"});
        O00000o0.put(25968, new String[]{"SHU", "SHUO"});
        O00000o0.put(24554, new String[]{"SONG", "ZHONG"});
        O00000o0.put(23487, new String[]{"SU", "XIU"});
        O00000o0.put(30509, new String[]{"GUI", "XU", "SUI"});
        O00000o0.put(28601, new String[]{"DAN", "TAN"});
        O00000o0.put(27795, new String[]{"TA", "DA"});
        O00000o0.put(35203, new String[]{"TAN", "QIN"});
        O00000o0.put(35843, new String[]{"DIAO", "TIAO"});
        O00000o0.put(35114, new String[]{"TUI", "TUN"});
        O00000o0.put(25299, new String[]{"TUO", "TA"});
        O00000o0.put(22313, new String[]{"WEI", "XU"});
        O00000o0.put(22996, new String[]{"WEI", "QU"});
        O00000o0.put(23614, new String[]{"WEI", "YI"});
        O00000o0.put(23561, new String[]{"WEI", "YU"});
        O00000o0.put(36951, new String[]{"YI", "WEI"});
        O00000o0.put(20044, new String[]{"WU", "LA"});
        O00000o0.put(21523, new String[]{"XIA", "HE"});
        O00000o0.put(32420, new String[]{"XIAN", "QIAN"});
        O00000o0.put(34892, new String[]{"XING", "HANG", "HENG"});
        O00000o0.put(30465, new String[]{"SHENG", "XING"});
        O00000o0.put(21066, new String[]{"XIAO", "XUE"});
        O00000o0.put(34880, new String[]{"XUE", "XIE"});
        O00000o0.put(27575, new String[]{"YIN", "YAN"});
        O00000o0.put(21693, new String[]{"YAN", "YE"});
        O00000o0.put(32422, new String[]{"YUE", "YAO"});
        O00000o0.put(38053, new String[]{"YAO", "YUE"});
        O00000o0.put(21494, new String[]{"YE", "XIE"});
        O00000o0.put(33406, new String[]{"AI", "YI"});
        O00000o0.put(29096, new String[]{"YUN", "YU"});
        O00000o0.put(21505, new String[]{"YU", "XU"});
        O00000o0.put(21592, new String[]{"YUAN", "YUN"});
        O00000o0.put(36128, new String[]{"YUAN", "YUN"});
        O00000o0.put(21643, new String[]{"ZA", "ZE", "ZHA"});
        O00000o0.put(25321, new String[]{"ZE", "ZHAI"});
        O00000o0.put(25166, new String[]{"ZHA", "ZA"});
        O00000o0.put(36711, new String[]{"YA", "ZHA"});
        O00000o0.put(31896, new String[]{"NIAN", "ZHAN"});
        O00000o0.put(29226, new String[]{"ZHUA", "ZHAO"});
        O00000o0.put(30528, new String[]{"ZHAO", "ZHUO"});
        O00000o0.put(27542, new String[]{"ZHI", "SHI"});
        O00000o0.put(33879, new String[]{"ZHU", "ZHE", "ZHUO"});
        O00000o0.put(24162, new String[]{"ZHUANG", "CHUANG"});
        O00000o0.put(32508, new String[]{"ZONG", "ZENG"});
        O00000o0.put(26590, new String[]{"ZUO", "ZHA"});
        O00000o0.put(20180, new String[]{"ZI", "ZAI"});
        O00000o0.put(20869, new String[]{"NEI"});
        O00000o0.put(30655, new String[]{"QU"});
        O00000o0.put(26469, new String[]{"LAI"});
        O00000o0.put(21449, new String[]{"CHA"});
        O00000o0.put(22905, new String[]{"TA"});
        O00000o0.put(20799, new String[]{"ER"});
        O00000o0.put(27784, new String[]{"SHEN"});
        O00000o0.put(36158, new String[]{"JIA"});
        O00000o.put("单于", new String[]{"CHAN", "YU"});
        O00000o.put("长孙", new String[]{"ZHANG", "SUN"});
        O00000o.put("子车", new String[]{"ZI", "JU"});
        O00000o.put("万俟", new String[]{"MO", "QI"});
        O00000o.put("澹台", new String[]{"TAN", "TAI"});
        O00000o.put("尉迟", new String[]{"YU", "CHI"});
        O00000oO.put(36158, "JIA");
        O00000oO.put(27784, "SHEN");
        O00000oO.put(21340, "BU");
        Object obj = "BO";
        O00000oO.put(34180, obj);
        O00000oO.put(23387, obj);
        O00000oO.put(36146, "BEN");
        O00000oO.put(36153, "FEI");
        O00000oO.put(27850, "BAN");
        O00000oO.put(33536, "BI");
        O00000oO.put(24223, obj);
        O00000oO.put(30058, obj);
        O00000oO.put(35098, "CHU");
        O00000oO.put(37325, "CHONG");
        O00000oO.put(21378, "HAN");
        O00000oO.put(20256, "CHUAN");
        O00000oO.put(21442, "CAN");
        O00000oO.put(31181, "CHONG");
        O00000oO.put(37079, "CHI");
        O00000oO.put(38241, "CHAN");
        O00000oO.put(26397, "CHAO");
        O00000oO.put(27835, "CHI");
        O00000oO.put(21852, "CHUAI");
        O00000oO.put(34928, "CUI");
        Object obj2 = "CHANG";
        O00000oO.put(26216, obj2);
        O00000oO.put(19985, "CHOU");
        O00000oO.put(30259, "CHOU");
        O00000oO.put(38271, obj2);
        O00000oO.put(27425, "QI");
        O00000oO.put(36710, "CHE");
        O00000oO.put(32735, "ZHAI");
        O00000oO.put(20291, "DIAN");
        O00000oO.put(20992, "DIAO");
        O00000oO.put(35843, "DIAO");
        O00000oO.put(36934, "DI");
        O00000oO.put(30422, "GE");
        O00000oO.put(28805, "GUI");
        O00000oO.put(34411, "GU");
        O00000oO.put(28820, "GUI");
        O00000oO.put(26123, "GUI");
        O00000oO.put(20250, "GUI");
        O00000oO.put(33445, "GAI");
        O00000oO.put(33554, "KUANG");
        O00000oO.put(37063, "HUAN");
        O00000oO.put(24055, "XIANG");
        O00000oO.put(40657, "HE");
        O00000oO.put(36713, "HAN");
        O00000oO.put(25750, "HAN");
        O00000oO.put(40664, "HE");
        O00000oO.put(35265, "JIAN");
        O00000oO.put(38477, "JIANG");
        Object obj3 = "JIAO";
        O00000oO.put(35282, obj3);
        O00000oO.put(32564, obj3);
        O00000oO.put(35760, "JI");
        O00000oO.put(29722, "JU");
        O00000oO.put(21095, "JI");
        O00000oO.put(38589, "JUAN");
        O00000oO.put(38551, "KUI");
        O00000oO.put(39740, "KUI");
        O00000oO.put(25000, "KAN");
        O00000oO.put(38752, "KU");
        O00000oO.put(20048, "YUE");
        O00000oO.put(20845, "LU");
        O00000oO.put(21895, "LA");
        O00000oO.put(38610, "LUO");
        O00000oO.put(20102, "LIAO");
        O00000oO.put(32554, "MIAO");
        O00000oO.put(20340, "MI");
        O00000oO.put(35884, "MIAO");
        O00000oO.put(20060, "NIE");
        O00000oO.put(38590, "NING");
        O00000oO.put(21306, "OU");
        O00000oO.put(36898, "PANG");
        O00000oO.put(34028, "PENG");
        O00000oO.put(26420, "PIAO");
        O00000oO.put(32321, "PO");
        O00000oO.put(20415, "PIAN");
        O00000oO.put(20167, "QIU");
        O00000oO.put(21345, "QIA");
        O00000oO.put(35203, "TAN");
        O00000oO.put(31140, "QIAN");
        O00000oO.put(21484, "SHAO");
        O00000oO.put(20160, "SHI");
        O00000oO.put(25240, "SHE");
        O00000oO.put(30509, "SUI");
        O00000oO.put(35299, "XIE");
        O00000oO.put(31995, "XI");
        O00000oO.put(24055, "XIANG");
        O00000oO.put(38500, "XU");
        O00000oO.put(23536, "XIAN");
        O00000oO.put(21592, "YUAN");
        O00000oO.put(36128, "YUAN");
        O00000oO.put(26366, "ZENG");
        O00000oO.put(26597, "ZHA");
        O00000oO.put(20256, "CHUAN");
        O00000oO.put(21484, "SHAO");
        O00000oO.put(31085, "ZHAI");
    }

    private goc() {
    }

    public static goc O000000o() {
        synchronized (goc.class) {
            if (O0000O0o != null) {
                goc goc = O0000O0o;
                return goc;
            }
            goc goc2 = new goc();
            O0000O0o = goc2;
            return goc2;
        }
    }

    private static gob.O000000o O000000o(char c) {
        int i;
        int i2;
        gob.O000000o o000000o = new gob.O000000o();
        String ch = Character.toString(c);
        o000000o.O00000Oo = ch;
        if (c < 256) {
            o000000o.f18079O000000o = 1;
            o000000o.O00000o0 = ch;
            return o000000o;
        } else if (c < 13312) {
            o000000o.f18079O000000o = 3;
            o000000o.O00000o0 = ch;
            return o000000o;
        } else {
            String[] strArr = O00000o0.get(Character.valueOf(c));
            int i3 = 0;
            if (strArr != null) {
                o000000o.f18079O000000o = 2;
                o000000o.O00000o = strArr;
                o000000o.O00000o0 = o000000o.O00000o[0];
                return o000000o;
            }
            int compare = O00000oo.compare(ch, "阿");
            if (compare < 0) {
                o000000o.f18079O000000o = 3;
                o000000o.O00000o0 = ch;
                return o000000o;
            }
            if (compare == 0) {
                o000000o.f18079O000000o = 2;
                i = 0;
            } else {
                compare = O00000oo.compare(ch, "蓙");
                if (compare > 0) {
                    o000000o.f18079O000000o = 3;
                    o000000o.O00000o0 = ch;
                    return o000000o;
                } else if (compare == 0) {
                    o000000o.f18079O000000o = 2;
                    i = f18080O000000o.length - 1;
                } else {
                    i = -1;
                }
            }
            o000000o.f18079O000000o = 2;
            if (i < 0) {
                int length = f18080O000000o.length - 1;
                i2 = compare;
                int i4 = 0;
                while (i4 <= length) {
                    i = (i4 + length) / 2;
                    i2 = O00000oo.compare(ch, Character.toString(f18080O000000o[i]));
                    if (i2 == 0) {
                        break;
                    } else if (i2 > 0) {
                        i4 = i + 1;
                    } else {
                        length = i - 1;
                    }
                }
            } else {
                i2 = compare;
            }
            if (i2 < 0) {
                i--;
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                byte[][] bArr = O00000Oo;
                if (i3 >= bArr[i].length || bArr[i][i3] == 0) {
                    o000000o.O00000o0 = sb.toString();
                } else {
                    sb.append((char) bArr[i][i3]);
                    i3++;
                }
            }
            o000000o.O00000o0 = sb.toString();
            return o000000o;
        }
    }

    private static void O000000o(StringBuilder sb, ArrayList<gob.O000000o> arrayList, int i) {
        String sb2 = sb.toString();
        arrayList.add(new gob.O000000o(i, sb2, sb2));
        sb.setLength(0);
    }

    public final ArrayList<gob.O000000o> O000000o(String str) {
        ArrayList<gob.O000000o> arrayList = new ArrayList<>();
        if (this.O0000OOo && !TextUtils.isEmpty(str)) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt != ' ') {
                    if (charAt < 256) {
                        if (i != 1 && sb.length() > 0) {
                            O000000o(sb, arrayList, i);
                        }
                        sb.append(charAt);
                        i = 1;
                    } else if (charAt < 13312) {
                        if (i != 3 && sb.length() > 0) {
                            O000000o(sb, arrayList, i);
                        }
                        sb.append(charAt);
                    } else {
                        gob.O000000o O000000o2 = O000000o(charAt);
                        if (O000000o2.f18079O000000o == 2) {
                            if (sb.length() > 0) {
                                O000000o(sb, arrayList, i);
                            }
                            arrayList.add(O000000o2);
                            i = 2;
                        } else {
                            if (i != O000000o2.f18079O000000o && sb.length() > 0) {
                                O000000o(sb, arrayList, i);
                            }
                            i = O000000o2.f18079O000000o;
                            sb.append(charAt);
                        }
                    }
                } else if (sb.length() > 0) {
                    O000000o(sb, arrayList, i);
                }
                i = 3;
            }
            if (sb.length() > 0) {
                O000000o(sb, arrayList, i);
            }
        }
        return arrayList;
    }
}
