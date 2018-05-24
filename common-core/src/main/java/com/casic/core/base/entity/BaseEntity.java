package com.casic.core.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseEntity implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人
     */
    private String createUserId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 修改人
     */
    private String modifyUserId;
    /**
     * 删除状态
     */
    private String deleteState;
}
