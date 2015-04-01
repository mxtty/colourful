package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.colourful.domain.generated.base.BrnUserBase;
import com.colourful.domain.generated.record.BrnUserDetail;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.domain.stereotype.Entity;
import com.rainbow.fw.web.context.WebApplicationContext;

@Entity
@SuppressWarnings("serial")
public class BrnUserEntity extends BrnUserBase {

	@Autowired
	private WebApplicationContext appContext;

	public boolean isUserExists() {
		return getEntityByPk();
	}

	public boolean insertNewUser() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.passwd = passwordEncoder.encode(this.passwd);
		return insert();
	}

	public BrnUserDetailEntity getBrnUserDetailEntity() {
		BrnUserDetailEntity userDetailEntity = EntityFactory.newBrnUserDetailEntity(addressId);
		userDetailEntity.getEntityByPk();

		return userDetailEntity;

	}

	public List<BrnUserDetail> getBrnUserDetailListByUserId() {
		BrnUserDetailEntity userDetailEntity = EntityFactory.newEntity(BrnUserDetailEntity.class);
		return userDetailEntity.getBrnUserDetailListByUserId(userId);

	}

	public BrnCartEntity getBrnCartEntity() {
		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity();
		return cartEntity.getBrnCartEntityByUserId(userId);

	}

	public String getCartId() {
		BrnCartEntity cartEntity = getBrnCartEntity();
		if (null != cartEntity)
			return cartEntity.getCartId();

		return newCartEntity().getCartId();

	}

	public BrnCartEntity newCartEntity() {
		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(appContext.getSessionId());
		cartEntity.setUserId(userId);
		cartEntity.insert();
		return cartEntity;
	}
}
