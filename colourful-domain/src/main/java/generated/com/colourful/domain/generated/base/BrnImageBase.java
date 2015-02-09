package com.colourful.domain.generated.base;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.exception.ExceptionId;
import com.colourful.domain.generated.mapper.BrnImageMapper;
import com.colourful.domain.generated.record.BrnImage;

/**
 * 图片Base类
 * 
 * 
 * @author WangQi
 * 
 */
@SuppressWarnings("serial")
public class BrnImageBase extends BrnImage {

	/** 管理Mapper */
	@Autowired
	private BrnImageMapper mapper;

	public void fromObject(Object from) {
		BeanUtils.copyProperties(from, this);
	}

	public void toObject(Object to) {
		BeanUtils.copyProperties(this, to);

	}

	public void checkPkNotNull() {
		if (0 == this.imageId) {
			ExceptionId.PK_NULL.rejectApp("BRN_IMAGE", "IMAGE_ID");
		}
	}

	public List<BrnImage> getRecords() {
		return mapper.getBrnImages(this);
	}

	/**
	 * 以PK获取Entity
	 * 
	 * @return 获取到的Entity
	 */
	public boolean getEntityByPk() {
		BrnImage detail = mapper.readByPk(this);
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
