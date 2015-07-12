package com.colourful.domain.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.CollectionUtils;

import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.generated.record.BrnUserDetail;
import com.colourful.domain.service.base.EntityFactory;
import com.rainbow.fw.core.auth.WebUser;

@Data
@EqualsAndHashCode(callSuper = false)
public class RainbowUserDetails extends User implements WebUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8931332811911613584L;

	private String realName;

	private String shipName;

	private String phone;

	private Date shipDate;

	private String shipAddress;

	private String cartId;

	private String newCartId;

	private List<BrnUserDetail> addressList;

	public boolean hasMultiAddress() {
		return !CollectionUtils.isEmpty(addressList) && addressList.size() > 1;
	}


	public String getUserId() {
		return getUsername();
	}

	public String getCartId() {

		if (null != this.cartId)
			return this.cartId;

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity();

		BrnCartEntity curCartEntity = cartEntity.getBrnCartEntityByUserId(getUserId());

		if (null == curCartEntity) {
			this.cartId = newCartId;
			cartEntity.setCartId(this.cartId);
			cartEntity.setUserId(getUserId());
			cartEntity.insert();
		}

		return this.cartId;

	}

	public RainbowUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public RainbowUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	public boolean isAnonymousUser() {

		return false;
	}

}
