package org.mybatis.jpetstore.domain.entity;

import java.io.Serializable;

import org.mybatis.jpetstore.domain.repository.ItemRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ItemEntity extends ItemRepository implements Serializable {

}
