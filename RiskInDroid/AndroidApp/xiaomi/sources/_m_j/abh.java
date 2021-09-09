package _m_j;

public final class abh extends xx<abi> {
    public abh(abi abi) {
        super(abi);
    }

    public final String O000000o(int i) {
        if (i == 513) {
            Integer O00000o0 = ((abi) this.f2602O000000o).O00000o0(513);
            if (O00000o0 == null) {
                return null;
            }
            int intValue = O00000o0.intValue();
            switch (intValue) {
                case 0:
                    return "Normal/Very Low";
                case 1:
                    return "Normal/Low";
                case 2:
                    return "Normal/Medium Low";
                case 3:
                    return "Normal/Medium";
                case 4:
                    return "Normal/Medium High";
                case 5:
                    return "Normal/High";
                case 6:
                    return "Normal/Very High";
                case 7:
                    return "Normal/Super High";
                default:
                    switch (intValue) {
                        case 256:
                            return "Fine/Very Low";
                        case 257:
                            return "Fine/Low";
                        case 258:
                            return "Fine/Medium Low";
                        case 259:
                            return "Fine/Medium";
                        case 260:
                            return "Fine/Medium High";
                        case 261:
                            return "Fine/High";
                        case 262:
                            return "Fine/Very High";
                        case 263:
                            return "Fine/Super High";
                        default:
                            switch (intValue) {
                                case 512:
                                    return "Super Fine/Very Low";
                                case 513:
                                    return "Super Fine/Low";
                                case 514:
                                    return "Super Fine/Medium Low";
                                case 515:
                                    return "Super Fine/Medium";
                                case 516:
                                    return "Super Fine/Medium High";
                                case 517:
                                    return "Super Fine/High";
                                case 518:
                                    return "Super Fine/Very High";
                                case 519:
                                    return "Super Fine/Super High";
                                default:
                                    return "Unknown (" + O00000o0 + ")";
                            }
                    }
            }
        } else if (i == 514) {
            return O000000o(514, "Normal", "Macro", "View", "Manual");
        } else {
            if (i == 516) {
                return O000000o();
            }
            if (i == 539) {
                return O000000o(539, "Off", "On");
            }
            if (i == 531) {
                return O000000o(531, "Off", "On");
            }
            if (i == 532) {
                return O000000o(532, "Off", "On");
            }
            if (i == 548) {
                return O000000o(548, "5 frames/sec", "10 frames/sec", "15 frames/sec", "20 frames/sec");
            }
            if (i == 549) {
                return O000000o(549, "Auto", "Force", "Disabled", "Red eye");
            }
            switch (i) {
                case 526:
                    return O000000o(526, "None", "Standard", "Best", "Adjust Exposure");
                case 527:
                    return O000000o(527, "Off", "On");
                case 528:
                    return O000000o(528, "Off", "On");
                default:
                    switch (i) {
                        case 534:
                            return O000000o(534, "Off", "On");
                        case 535:
                            return O000000o(535, "Record while down", "Press start, press stop");
                        case 536:
                            return O000000o(536, "Off", "On");
                        case 537:
                            return O000000o(537, "Off", "On");
                        default:
                            switch (i) {
                                case 541:
                                    return O000000o(541, "Off", "On");
                                case 542:
                                    return O000000o(542, "No", "Yes");
                                case 543:
                                    return O000000o(543, "Off", "Sport", "TV", "Night", "User 1", "User 2", "Lamp");
                                default:
                                    return super.O000000o(i);
                            }
                    }
            }
        }
    }
}
