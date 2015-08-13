package com.colourful.domain.entity.param;

import lombok.Data;

@Data
public class ChangeCartIdParam {
	private String fromCartId;
	private String toCartId;
}
