package com.colourful.domain.generated.record;

import java.util.Date;

import lombok.Data;

@Data
public class BrnUser {
    /** 用户ID */
    protected String userId;
    /** 真实名 */
    protected String realName;
    /** 密码 */
    protected String passwd;
    /** 用户状态 */
    protected int status;
    /** 创建时间 */
    protected Date createDate;
    /** 更新时间 */
    protected Date updateDate;
    /** 删除标记 */
    protected int delFlg;
}