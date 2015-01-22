package com.colourful.domain.generated.record;

import java.util.Date;

import lombok.Data;

@Data
public class BrnUserDetail {
    /** 住址ID */
    protected long addressId;
    /** 用户ID */
    protected String userId;
    /** 默认住址 */
    protected int defaultFlg;
    /** 邮编 */
    protected String zip;
    /** 收件国家 */
    protected String country;
    /** 收件城市 */
    protected String city;
    /** 收件地址 */
    protected String address;
    /** 固定电话 */
    protected String phone;
    /** 移动电话 */
    protected String cellPhone;
    /** 邮件地址 */
    protected String email;
    /** 创建时间 */
    protected Date createDate;
    /** 更新时间 */
    protected Date updateDate;
    /** 删除标记 */
    protected int delFlg;
}