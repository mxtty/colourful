package org.mybatis.jpetstore.domain.base;

import org.mybatis.jpetstore.domain.record.Account;
import org.mybatis.jpetstore.persistence.AccountMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class AccountBase extends Account {

	@Autowired
	private AccountMapper accountMapper;

	public void getEntityByPk() {
		BeanUtils.copyProperties(accountMapper.getAccountByUsername(username), this);
	}

}
