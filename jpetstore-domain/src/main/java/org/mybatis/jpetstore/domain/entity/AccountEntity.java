package org.mybatis.jpetstore.domain.entity;

import java.io.Serializable;

import org.mybatis.jpetstore.domain.base.AccountBase;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@SuppressWarnings("serial")
public class AccountEntity extends AccountBase implements Serializable {

}
