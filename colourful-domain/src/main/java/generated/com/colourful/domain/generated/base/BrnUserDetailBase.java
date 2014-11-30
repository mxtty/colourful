package com.colourful.domain.generated.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.BrnUserDetailMapper;
import com.colourful.domain.generated.record.BrnUserDetail;

/**
 * 用户详细Base类
 * 
 * 
 * @author WangQi
 * 
 */
public class BrnUserDetailBase extends BrnUserDetail {

	/** SerialVersion */
	private static final long serialVersionUID = -5755157354602673563L;

	/** 管理Mapper */
	@Autowired
	private BrnUserDetailMapper mapper;

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
		BrnUserDetail detail = mapper.readByPk(this);
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
