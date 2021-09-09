package com.xiaomi.mico.api.model;

import java.util.List;

public class IRDevice {

    public static class AbilityList extends BaseResponse {
        public AbilityListResult result;

        public static class Ability {
            public List<AbilityItem> items;
            public String title;
        }

        public static class AbilityItem {
            public String name;
        }

        public static class AbilityListResult {
            public List<Ability> list;
        }
    }

    public static class AreaList extends BaseResponse {
        public AreaListResult result;

        public static class Area {
            public long id;
            public String name;
        }

        public static class AreaListResult {
            public List<Area> areas;
        }
    }

    public static class BrandList extends BaseResponse {
        public BrandListResult result;

        public static class Brand {
            public String en_name;
            public long id;
            public String name;
            public String pinyin;
        }

        public static class BrandListResult {
            public List<Brand> brand_with_rank;
            public List<Brand> brands;
        }
    }

    public static class CityId extends BaseResponse {
        public CityIdResult result;

        public static class CityIdResult {
            public long city_id;
        }
    }

    public static class CityList {
        public CityListResult result;

        public static class City {
            public long id;
            public String name;
        }

        public static class CityListResult {
            public List<City> cities;
        }
    }

    public static class Controller extends BaseResponse {
        public ControllerResult result;

        public static class ControllerResult {
            public String did;
        }
    }

    public static class ControllerCodeList {
        public List<String> controllers;
    }

    public static class ControllerInfo extends BaseResponse {
        public ControllerInfoResult result;

        public static class ACState {
            public int direct;
            public int mode;
            public int power_off;
            public int speed;
            public int temperature;
        }

        public static class ControllerInfoResult {
            public ACState ac_state;
            public int brand_id;
            public int controller_id;
        }
    }

    public static class ControllerKeyList extends BaseResponse {
        public ControllerKeyListResult result;

        public static class ControllerKeyListResult {
            public List<Key> keys;
        }
    }

    public static class ControllerList extends BaseResponse {
        public ControllerListResult result;

        public static class Controller {
            public int category;
            public String did;
            public String model;
            public String name;
        }

        public static class ControllerListResult {
            public List<Controller> controllers;
        }
    }

    public static class Key {
        public String display_name;
        public long id;
        public String name;
    }

    public static class KeyCode {
        public KeyCodeResult result;

        public static class KeyCodeResult {
            public String code;
        }
    }

    public static class KeyList extends BaseResponse {
        public List<MinaKey> keys;
    }

    public static class LineupList extends BaseResponse {
        public LineupListResult result;

        public static class Lineup {
            public String Id;
            public String Name;
            public long SpId;
            public int SpType;
        }

        public static class LineupListResult {
            public List<Lineup> lineups;
        }
    }

    public static class MatchNodeList {
        public BrandList.Brand brand;
        public CategoryList.Category category;
        public List<Key> keys;
        public List<Node> nodes;
        public String version;

        public static class Key {
            public String ac_key;
            public String display_name;
            public int id;
            public boolean must_match;
            public String name;
            public String target_key;
        }

        public static class Node {
            public long controller_id;
            public int count;
            public int cursor;
            public int id;
            public Key key;
            public int matched;
            public int mismatched;
            public int total;
        }
    }

    public static class MinaCategory {
        public String description;
        public String deviceImageUrl;
        public long id;
        public String imageUrl;
        public String model;
        public String name;
    }

    public static class MinaKey {
        public String failedOperation;
        public String keyDescription;
        public String keyDisplayName;
        public String keyIconUrl;
        public String keyId;
        public String keyImageUrl;
        public String keyName;
        public String keyTitle;
        public String successOperation;
        public String tipsAfterOperate;
        public String tipsBeforeOperate;
    }

    public static class ProvinceList {
        public ProvinceListResult result;

        public static class Province {
            public long id;
            public String name;
        }

        public static class ProvinceListResult {
            public List<Province> provinces;
        }
    }

    public static class RPCIRRead extends BaseResponse {
        public RPCIRReadResult result;

        public static class RPCIRReadResult {
            public String code;
            public String key;
        }
    }

    public static class SpsList extends BaseResponse {
        public SpsListResult result;

        public static class Sps {
            public long id;
            public String name;
        }

        public static class SpsListResult {
            public List<Sps> service_providers;
        }
    }

    public static class CategoryList extends BaseResponse {
        public CategoryListResult result;

        public static class Category {
            public long id;
            public String name;
        }

        public class CategoryListResult {
            public List<Category> categories;

            public CategoryListResult() {
            }
        }
    }

    public static class ControllerCodeDetails {
        public List<Code> controllers;

        class Code {
            public long id;
            public int type;

            Code() {
            }
        }
    }

    public static class InputKey {
        public String code;
        public long keyId;
        public String name;

        public InputKey(long j, String str, String str2) {
            this.keyId = j;
            this.code = str;
            this.name = str2;
        }
    }

    public static class AirConditionFunction {
        public List<Model> models;
        public Swing swing;

        class Model {
            public int mode;
            public List<Integer> speeds;
            public List<Integer> temps;

            Model() {
            }
        }

        class Swing {
            public List<Integer> directs;
            public int type;

            Swing() {
            }
        }
    }
}
