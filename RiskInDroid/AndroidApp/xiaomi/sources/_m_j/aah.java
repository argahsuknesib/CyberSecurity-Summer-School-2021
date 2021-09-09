package _m_j;

import java.text.DecimalFormat;
import java.util.HashMap;

public final class aah extends xx<aai> {
    private static final HashMap<String, String> O00000o = new HashMap<>();
    private static final HashMap<String, String> O00000o0 = new HashMap<>();

    public aah(aai aai) {
        super(aai);
    }

    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 4);
        }
        if (i == 256) {
            String O0000o0 = ((aai) this.f2602O000000o).O0000o0(256);
            if (O0000o0 == null) {
                return null;
            }
            return aao.O0000OOo.containsKey(O0000o0) ? aao.O0000OOo.get(O0000o0) : O0000o0;
        } else if (i == 513) {
            return O00000oo();
        } else {
            if (i == 769) {
                return O0000O0o();
            }
            if (i == 259) {
                return ((aai) this.f2602O000000o).O0000o0(259) + " mm";
            } else if (i == 260) {
                Integer O00000o02 = ((aai) this.f2602O000000o).O00000o0(260);
                if (O00000o02 == null) {
                    return null;
                }
                String format = String.format("%04X", O00000o02);
                return String.format("%s.%s", format.substring(0, format.length() - 3), format.substring(format.length() - 3));
            } else if (i == 522) {
                Integer O00000o03 = ((aai) this.f2602O000000o).O00000o0(522);
                if (O00000o03 == null) {
                    return null;
                }
                return new DecimalFormat("0.#").format(O00000oo(O00000o03.intValue()));
            } else if (i == 523) {
                Integer O00000o04 = ((aai) this.f2602O000000o).O00000o0(523);
                if (O00000o04 == null) {
                    return null;
                }
                return String.format("0x%04X", O00000o04);
            } else if (i == 4096) {
                return O000000o(4096, "None", null, "Simple E-System", "E-System");
            } else {
                if (i == 4097) {
                    return O000000o(4097, "None", "FL-20", "FL-50", "RF-11", "TF-22", "FL-36", "FL-50R", "FL-36R");
                }
                switch (i) {
                    case 516:
                        Integer O00000o05 = ((aai) this.f2602O000000o).O00000o0(516);
                        if (O00000o05 == null) {
                            return null;
                        }
                        String format2 = String.format("%04X", O00000o05);
                        return String.format("%s.%s", format2.substring(0, format2.length() - 3), format2.substring(format2.length() - 3));
                    case 517:
                        Integer O00000o06 = ((aai) this.f2602O000000o).O00000o0(517);
                        if (O00000o06 == null) {
                            return null;
                        }
                        return new DecimalFormat("0.#").format(O00000oo(O00000o06.intValue()));
                    case 518:
                        Integer O00000o07 = ((aai) this.f2602O000000o).O00000o0(518);
                        if (O00000o07 == null) {
                            return null;
                        }
                        return new DecimalFormat("0.#").format(O00000oo(O00000o07.intValue()));
                    default:
                        return super.O000000o(i);
                }
            }
        }
    }

    private String O00000oo() {
        String O0000o0 = ((aai) this.f2602O000000o).O0000o0(513);
        if (O0000o0 == null) {
            return null;
        }
        String[] split = O0000o0.split(" ");
        if (split.length < 6) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[2]);
            int parseInt3 = Integer.parseInt(split[3]);
            return O00000o0.get(String.format("%X %02X %02X", Integer.valueOf(parseInt), Integer.valueOf(parseInt2), Integer.valueOf(parseInt3)));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static double O00000oo(int i) {
        double sqrt = Math.sqrt(2.0d);
        double d = (double) i;
        Double.isNaN(d);
        return Math.pow(sqrt, d / 256.0d);
    }

    private String O0000O0o() {
        String O0000o0 = ((aai) this.f2602O000000o).O0000o0(769);
        if (O0000o0 == null) {
            return null;
        }
        String[] split = O0000o0.split(" ");
        if (split.length < 6) {
            return null;
        }
        try {
            return O00000o.get(String.format("%X %02X", Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[2]))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static {
        O00000o0.put("0 00 00", "None");
        O00000o0.put("0 01 00", "Olympus Zuiko Digital ED 50mm F2.0 Macro");
        O00000o0.put("0 01 01", "Olympus Zuiko Digital 40-150mm F3.5-4.5");
        O00000o0.put("0 01 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6");
        O00000o0.put("0 02 00", "Olympus Zuiko Digital ED 150mm F2.0");
        O00000o0.put("0 02 10", "Olympus M.Zuiko Digital 17mm F2.8 Pancake");
        O00000o0.put("0 03 00", "Olympus Zuiko Digital ED 300mm F2.8");
        O00000o0.put("0 03 10", "Olympus M.Zuiko Digital ED 14-150mm F4.0-5.6 [II]");
        O00000o0.put("0 04 10", "Olympus M.Zuiko Digital ED 9-18mm F4.0-5.6");
        O00000o0.put("0 05 00", "Olympus Zuiko Digital 14-54mm F2.8-3.5");
        O00000o0.put("0 05 01", "Olympus Zuiko Digital Pro ED 90-250mm F2.8");
        O00000o0.put("0 05 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6 L");
        O00000o0.put("0 06 00", "Olympus Zuiko Digital ED 50-200mm F2.8-3.5");
        O00000o0.put("0 06 01", "Olympus Zuiko Digital ED 8mm F3.5 Fisheye");
        O00000o0.put("0 06 10", "Olympus M.Zuiko Digital ED 40-150mm F4.0-5.6");
        O00000o0.put("0 07 00", "Olympus Zuiko Digital 11-22mm F2.8-3.5");
        O00000o0.put("0 07 01", "Olympus Zuiko Digital 18-180mm F3.5-6.3");
        O00000o0.put("0 07 10", "Olympus M.Zuiko Digital ED 12mm F2.0");
        O00000o0.put("0 08 01", "Olympus Zuiko Digital 70-300mm F4.0-5.6");
        O00000o0.put("0 08 10", "Olympus M.Zuiko Digital ED 75-300mm F4.8-6.7");
        O00000o0.put("0 09 10", "Olympus M.Zuiko Digital 14-42mm F3.5-5.6 II");
        O00000o0.put("0 10 01", "Kenko Tokina Reflex 300mm F6.3 MF Macro");
        O00000o0.put("0 10 10", "Olympus M.Zuiko Digital ED 12-50mm F3.5-6.3 EZ");
        O00000o0.put("0 11 10", "Olympus M.Zuiko Digital 45mm F1.8");
        O00000o0.put("0 12 10", "Olympus M.Zuiko Digital ED 60mm F2.8 Macro");
        O00000o0.put("0 13 10", "Olympus M.Zuiko Digital 14-42mm F3.5-5.6 II R");
        O00000o0.put("0 14 10", "Olympus M.Zuiko Digital ED 40-150mm F4.0-5.6 R");
        O00000o0.put("0 15 00", "Olympus Zuiko Digital ED 7-14mm F4.0");
        O00000o0.put("0 15 10", "Olympus M.Zuiko Digital ED 75mm F1.8");
        O00000o0.put("0 16 10", "Olympus M.Zuiko Digital 17mm F1.8");
        O00000o0.put("0 17 00", "Olympus Zuiko Digital Pro ED 35-100mm F2.0");
        O00000o0.put("0 18 00", "Olympus Zuiko Digital 14-45mm F3.5-5.6");
        O00000o0.put("0 18 10", "Olympus M.Zuiko Digital ED 75-300mm F4.8-6.7 II");
        O00000o0.put("0 19 10", "Olympus M.Zuiko Digital ED 12-40mm F2.8 Pro");
        O00000o0.put("0 20 00", "Olympus Zuiko Digital 35mm F3.5 Macro");
        O00000o0.put("0 20 10", "Olympus M.Zuiko Digital ED 40-150mm F2.8 Pro");
        O00000o0.put("0 21 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6 EZ");
        O00000o0.put("0 22 00", "Olympus Zuiko Digital 17.5-45mm F3.5-5.6");
        O00000o0.put("0 22 10", "Olympus M.Zuiko Digital 25mm F1.8");
        O00000o0.put("0 23 00", "Olympus Zuiko Digital ED 14-42mm F3.5-5.6");
        O00000o0.put("0 23 10", "Olympus M.Zuiko Digital ED 7-14mm F2.8 Pro");
        O00000o0.put("0 24 00", "Olympus Zuiko Digital ED 40-150mm F4.0-5.6");
        O00000o0.put("0 24 10", "Olympus M.Zuiko Digital ED 300mm F4.0 IS Pro");
        O00000o0.put("0 25 10", "Olympus M.Zuiko Digital ED 8mm F1.8 Fisheye Pro");
        O00000o0.put("0 30 00", "Olympus Zuiko Digital ED 50-200mm F2.8-3.5 SWD");
        O00000o0.put("0 31 00", "Olympus Zuiko Digital ED 12-60mm F2.8-4.0 SWD");
        O00000o0.put("0 32 00", "Olympus Zuiko Digital ED 14-35mm F2.0 SWD");
        O00000o0.put("0 33 00", "Olympus Zuiko Digital 25mm F2.8");
        O00000o0.put("0 34 00", "Olympus Zuiko Digital ED 9-18mm F4.0-5.6");
        O00000o0.put("0 35 00", "Olympus Zuiko Digital 14-54mm F2.8-3.5 II");
        O00000o0.put("1 01 00", "Sigma 18-50mm F3.5-5.6 DC");
        O00000o0.put("1 01 10", "Sigma 30mm F2.8 EX DN");
        O00000o0.put("1 02 00", "Sigma 55-200mm F4.0-5.6 DC");
        O00000o0.put("1 02 10", "Sigma 19mm F2.8 EX DN");
        O00000o0.put("1 03 00", "Sigma 18-125mm F3.5-5.6 DC");
        O00000o0.put("1 03 10", "Sigma 30mm F2.8 DN | A");
        O00000o0.put("1 04 00", "Sigma 18-125mm F3.5-5.6 DC");
        O00000o0.put("1 04 10", "Sigma 19mm F2.8 DN | A");
        O00000o0.put("1 05 00", "Sigma 30mm F1.4 EX DC HSM");
        O00000o0.put("1 05 10", "Sigma 60mm F2.8 DN | A");
        O00000o0.put("1 06 00", "Sigma APO 50-500mm F4.0-6.3 EX DG HSM");
        O00000o0.put("1 07 00", "Sigma Macro 105mm F2.8 EX DG");
        O00000o0.put("1 08 00", "Sigma APO Macro 150mm F2.8 EX DG HSM");
        O00000o0.put("1 09 00", "Sigma 18-50mm F2.8 EX DC Macro");
        O00000o0.put("1 10 00", "Sigma 24mm F1.8 EX DG Aspherical Macro");
        O00000o0.put("1 11 00", "Sigma APO 135-400mm F4.5-5.6 DG");
        O00000o0.put("1 12 00", "Sigma APO 300-800mm F5.6 EX DG HSM");
        O00000o0.put("1 13 00", "Sigma 30mm F1.4 EX DC HSM");
        O00000o0.put("1 14 00", "Sigma APO 50-500mm F4.0-6.3 EX DG HSM");
        O00000o0.put("1 15 00", "Sigma 10-20mm F4.0-5.6 EX DC HSM");
        O00000o0.put("1 16 00", "Sigma APO 70-200mm F2.8 II EX DG Macro HSM");
        O00000o0.put("1 17 00", "Sigma 50mm F1.4 EX DG HSM");
        O00000o0.put("2 01 00", "Leica D Vario Elmarit 14-50mm F2.8-3.5 Asph.");
        O00000o0.put("2 01 10", "Lumix G Vario 14-45mm F3.5-5.6 Asph. Mega OIS");
        O00000o0.put("2 02 00", "Leica D Summilux 25mm F1.4 Asph.");
        O00000o0.put("2 02 10", "Lumix G Vario 45-200mm F4.0-5.6 Mega OIS");
        O00000o0.put("2 03 00", "Leica D Vario Elmar 14-50mm F3.8-5.6 Asph. Mega OIS");
        O00000o0.put("2 03 01", "Leica D Vario Elmar 14-50mm F3.8-5.6 Asph.");
        O00000o0.put("2 03 10", "Lumix G Vario HD 14-140mm F4.0-5.8 Asph. Mega OIS");
        O00000o0.put("2 04 00", "Leica D Vario Elmar 14-150mm F3.5-5.6");
        O00000o0.put("2 04 10", "Lumix G Vario 7-14mm F4.0 Asph.");
        O00000o0.put("2 05 10", "Lumix G 20mm F1.7 Asph.");
        O00000o0.put("2 06 10", "Leica DG Macro-Elmarit 45mm F2.8 Asph. Mega OIS");
        O00000o0.put("2 07 10", "Lumix G Vario 14-42mm F3.5-5.6 Asph. Mega OIS");
        O00000o0.put("2 08 10", "Lumix G Fisheye 8mm F3.5");
        O00000o0.put("2 09 10", "Lumix G Vario 100-300mm F4.0-5.6 Mega OIS");
        O00000o0.put("2 10 10", "Lumix G 14mm F2.5 Asph.");
        O00000o0.put("2 11 10", "Lumix G 12.5mm F12 3D");
        O00000o0.put("2 12 10", "Leica DG Summilux 25mm F1.4 Asph.");
        O00000o0.put("2 13 10", "Lumix G X Vario PZ 45-175mm F4.0-5.6 Asph. Power OIS");
        O00000o0.put("2 14 10", "Lumix G X Vario PZ 14-42mm F3.5-5.6 Asph. Power OIS");
        O00000o0.put("2 15 10", "Lumix G X Vario 12-35mm F2.8 Asph. Power OIS");
        O00000o0.put("2 16 10", "Lumix G Vario 45-150mm F4.0-5.6 Asph. Mega OIS");
        O00000o0.put("2 17 10", "Lumix G X Vario 35-100mm F2.8 Power OIS");
        O00000o0.put("2 18 10", "Lumix G Vario 14-42mm F3.5-5.6 II Asph. Mega OIS");
        O00000o0.put("2 19 10", "Lumix G Vario 14-140mm F3.5-5.6 Asph. Power OIS");
        O00000o0.put("2 20 10", "Lumix G Vario 12-32mm F3.5-5.6 Asph. Mega OIS");
        O00000o0.put("2 21 10", "Leica DG Nocticron 42.5mm F1.2 Asph. Power OIS");
        O00000o0.put("2 22 10", "Leica DG Summilux 15mm F1.7 Asph.");
        O00000o0.put("2 24 10", "Lumix G Macro 30mm F2.8 Asph. Mega OIS");
        O00000o0.put("2 25 10", "Lumix G 42.5mm F1.7 Asph. Power OIS");
        O00000o0.put("3 01 00", "Leica D Vario Elmarit 14-50mm F2.8-3.5 Asph.");
        O00000o0.put("3 02 00", "Leica D Summilux 25mm F1.4 Asph.");
        O00000o0.put("5 01 10", "Tamron 14-150mm F3.5-5.8 Di III");
        O00000o.put("0 00", "None");
        O00000o.put("0 04", "Olympus Zuiko Digital EC-14 1.4x Teleconverter");
        O00000o.put("0 08", "Olympus EX-25 Extension Tube");
        O00000o.put("0 10", "Olympus Zuiko Digital EC-20 2.0x Teleconverter");
    }
}
