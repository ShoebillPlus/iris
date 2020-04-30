package com.hc.upms.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UpdateRelatedFieldsMetaHandler implements MetaObjectHandler {
    /**
     * 新增操作
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充编号
        //this.strictInsertFill(metaObject, "id", String.class, HcUtil.getUUID(true));

        // 自动填充状态和有效（1：只有1是正常或有效）
        this.strictInsertFill(metaObject, "isValid", Integer.class, 1);
        this.strictInsertFill(metaObject, "state", Integer.class, 1);

        // 自动填充创建信息
        this.strictInsertFill(metaObject, "createUserId", String.class, getCurrentUserId());
        this.strictInsertFill(metaObject, "createTime", String.class, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        this.strictInsertFill(metaObject, "updateUserId", String.class, getCurrentUserId());
        this.strictInsertFill(metaObject, "updateTime", String.class, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        this.strictInsertFill(metaObject, "remark", String.class, "");
    }

    /**
     * 更新操作
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        // 自动填充更新信息
        this.strictUpdateFill(metaObject, "updateUserId", String.class, getCurrentUserId());
        this.strictUpdateFill(metaObject, "updateTime", String.class, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取当前登录用户ID
     *
     * @return
     */
    private String getCurrentUserId() {
        return "";
    }

}
