package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.entity.mapper.UserDetailEntityMapper;
import com.colourful.domain.generated.base.BrnUserDetailBase;
import com.colourful.domain.generated.record.BrnUserDetail;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnUserDetailEntity extends BrnUserDetailBase {

	@Autowired
	private UserDetailEntityMapper userDetailEntityMapper;

	public List<BrnUserDetail> getBrnUserDetailListByUserId(String userId) {
		this.userId = userId;
		return userDetailEntityMapper.getRecords(this);

	}
}
