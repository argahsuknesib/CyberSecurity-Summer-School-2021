package com.xiaomi.mico.api.model;

import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.infrared.bean.SkillEntity;
import java.util.ArrayList;
import java.util.List;

public class AiSkill {

    public static class AiError {
        public long code;
        public String debug;
        public String msg;
    }

    public static class CreateResponse {
        public int audit_num;
        public String skill_id;
    }

    public static class EditResponse {
        public int audit_num;
        public boolean update_status;
    }

    public static class ErrorResult {
        public AiError error;
    }

    public static class SkillListResponse extends BaseResponse {
        public SkillResult result;

        public static class SkillItem extends SkillEntity {
            public String appid;
            public String avatar;
            public long createTime;
            public boolean curUserLiked;
            public String did;
            public String hitCount;
            public String likedCount;
            public long modifyTime;
            public String nick_name;
            public int status;
            public String strategy;
            public long userId;
            public String usid;
        }

        public static class SkillResult {
            public int count;
            public List<SkillItem> skills;
        }
    }

    public static class MijiaSkillList extends BaseResponse {
        public MijiaSkillResult result;

        class MijiaSkillResult {
            public int count;
            List<MijiaSkill> skills;

            public MijiaSkillResult(SkillListResponse.SkillResult skillResult) {
                if (skillResult != null) {
                    this.count = skillResult.count;
                    this.skills = new ArrayList();
                    if (!ContainerUtil.isEmpty(skillResult.skills)) {
                        for (SkillListResponse.SkillItem mijiaSkill : skillResult.skills) {
                            this.skills.add(new MijiaSkill(mijiaSkill));
                        }
                    }
                }
            }
        }

        public MijiaSkillList(SkillListResponse skillListResponse) {
            if (skillListResponse != null) {
                this.code = skillListResponse.code;
                this.message = skillListResponse.message;
                this.result = new MijiaSkillResult(skillListResponse.result);
            }
        }
    }

    public static class MijiaSkill {
        public String execValue;
        public long keyId;
        public String keyName;
        public String skillId;
        public List<String> triggers;

        public MijiaSkill(SkillListResponse.SkillItem skillItem) {
            this.skillId = skillItem.id;
            this.triggers = skillItem.getTriggerList();
            SkillEntity.Extra extra = skillItem.getExtra();
            if (extra != null) {
                this.keyId = extra.keyId;
                this.keyName = extra.keyName;
            }
            this.execValue = skillItem.getIrLocalExecValue();
        }
    }
}
