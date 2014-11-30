package com.colourful.domain.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.base.AccountBase;

@Component
@Scope("prototype")
@SuppressWarnings("serial")
public class AccountEntity extends AccountBase implements Serializable {

}
