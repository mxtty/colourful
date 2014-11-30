package com.colourful.domain.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.AccountMapper;
import com.colourful.domain.record.Account;

@SuppressWarnings("serial")
public class AccountBase extends Account {

	@Autowired
	private AccountMapper accountMapper;

	public void getEntityByPk() {
		BeanUtils.copyProperties(accountMapper.getAccountByUsername(username),
				this);
	}

}
