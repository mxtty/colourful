package com.colourful.domain.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.repository.ItemRepository;

@Component
@Scope("prototype")
public class ItemEntity extends ItemRepository implements Serializable {

}
