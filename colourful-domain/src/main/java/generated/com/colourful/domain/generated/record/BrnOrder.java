package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.math.BigDecimal;import java.util.Date;
@Data
public class BrnOrder implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** 订单ID */
	protected long orderId;
	/** 订单状态 */
	protected int status;
	/** 总价 */
	protected BigDecimal totalPrice;
	/** 收件人 */
	protected String shipName;
	/** 邮编 */
	protected String shipZip;
	/** 收件国家 */
	protected String shipCountry;
	/** 收件城市 */
	protected String shipCity;
	/** 收件地址 */
	protected String shipAddress;
	/** 固定电话 */
	protected String phone;
	/** 移动电话 */
	protected String cellPhone;
	/** 邮件地址 */
	protected String email;
	/** 信用卡号 */
	protected String crtcardNo;
	/** 信用卡持有人 */
	protected String crtcardHolder;
	/** 有效期限 */
	protected String exprdate;
	/** 信用卡种类 */
	protected String cardtype;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}