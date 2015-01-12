package com.colourful.domain.generated.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.BrnProductMapper;
import com.colourful.domain.generated.record.BrnProduct;

/**
 * 产品Base类
 * 
 * 
 * @author WangQi
 * 
 */
public class BrnProductBase extends BrnProduct {

	/** SerialVersion */
	private static final long serialVersionUID = -3231209655098436368L;

	/** 管理Mapper */
	@Autowired
	private BrnProductMapper mapper;

	public void fromObject(Object from) {
		BeanUtils.copyProperties(from, this);
	}

	public void toObject(Object to) {
		BeanUtils.copyProperties(this, to);

	}

	/**
	 * 以PK获取Entity
	 * 
	 * @return 获取到的Entity
	 */
	public boolean getEntityByPk() {
		BrnProduct detail = mapper.readByPk(this);
		if (null == detail) {
			return false;
		}

		BeanUtils.copyProperties(detail, this);
		return true;
	}

	/**
	 * 插入记录
	 * 
	 * @return 插入结果
	 */
	public boolean insert() {
		return 0 < mapper.insert(this) ? true : false;
	}

	/**
	 * 更新
	 * 
	 * @return 更新结果
	 */
	public boolean update() {
		return 0 < mapper.update(this) ? true : false;
	}

	/**
	 * 删除
	 * 
	 * @return 删除结果
	 */
	public boolean delete() {
		return 0 < mapper.delete(this) ? true : false;
	}

}
