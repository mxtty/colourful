package com.colourful.domain.codelist;

import java.util.List;

import lombok.Data;

import com.colourful.domain.generated.mapper.CodeListMapper;
import com.rainbow.fw.web.codelist.CodeListService;
import com.rainbow.fw.web.codelist.bean.CodeDefine;

@Data
public class CodeListServiceImpl implements CodeListService {

	private CodeListMapper codeListMapper;

	public List<CodeDefine> getAllCodeList() {
		// TODO Auto-generated method stub
		return codeListMapper.getAllCodeList();
	}

}
