package com.colourful.domain.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.generated.base.BrnProductBase;

@Component
@Scope("prototype")
@SuppressWarnings("serial")
public class BrnProductEntity extends BrnProductBase implements Serializable {

	
 
}
