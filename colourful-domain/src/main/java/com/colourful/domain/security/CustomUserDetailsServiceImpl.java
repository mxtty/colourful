package com.colourful.domain.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.colourful.domain.data.RainbowUserDetails;
import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.generated.record.BrnUserDetail;
import com.colourful.domain.service.base.EntityFactory;
import com.rainbow.fw.web.context.WebApplicationContext;

/**
 * A custom service for retrieving users from a custom datasource, such as a
 * database.
 * <p>
 * This custom service must implement Spring's {@link UserDetailsService}
 */
@Transactional(readOnly = true)
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private static Logger syslog = Logger.getLogger("SysLogger");

	private static Logger applog = Logger.getLogger("AppLogger");

	@Autowired
	private WebApplicationContext appContext;

	/**
	 * Retrieves a user record containing the user's credentials and access.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		// Search database for a user that matches the specified username
		// You can provide a custom DAO to access your persistence layer
		// Or use JDBC to access your database
		// DbUser is our custom domain user. This is not the same as
		// Spring's User
		// DbUser dbUser = userDAO.searchDatabase(username);

		// Populate the Spring User object with details from the dbUser
		// Here we just pass the username, password, and access level
		// getAuthorities() will translate the access level to the correct
		// role type

		BrnUserEntity userEntity = EntityFactory.newBrnUserEntity(username);
		userEntity.getEntityByPk();
		if (!userEntity.isUserExists()) {
			applog.error("无法获取用户信息");
			throw new UsernameNotFoundException("无法获取用户信息");

		}

		RainbowUserDetails user = new RainbowUserDetails(userEntity.getUserId(), userEntity.getPasswd(), true, true,
				true, true, getAuthorities());
		user.setRealName(userEntity.getRealName());

		List<BrnUserDetail> brnUserDetailList = userEntity.getBrnUserDetailListByUserId();

		user.setAddressList(brnUserDetailList);

		if (0 < brnUserDetailList.size()) {
			BrnUserDetail brnUserDetail = brnUserDetailList.get(0);
			String phone = (!"".equals(brnUserDetail.getCellPhone()) ? brnUserDetail.getCellPhone() : brnUserDetail
					.getPhone());
			user.setPhone(phone);
			user.setShipAddress(brnUserDetail.getAddress());
		}

		// Return user to Spring for processing.
		// Take note we're not the one evaluating whether this user is
		// authenticated or valid
		// We just merely retrieve a user that matches the specified username
		return user;
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param access
	 *            an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities() {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// All users are granted with ROLE_USER access
		// Therefore this user gets a ROLE_USER by default
		applog.debug("Grant ROLE_USER to this user");
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// Check if this user has admin access
		// We interpret Integer(1) as an admin user
		// if (access.compareTo(1) == 0) {
		// // User has admin access
		// logger.debug("Grant ROLE_ADMIN to this user");
		// authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		// }

		// Return list of granted authorities
		return authList;
	}
}
