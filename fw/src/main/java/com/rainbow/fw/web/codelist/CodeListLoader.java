package com.rainbow.fw.web.codelist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import lombok.Getter;
import lombok.Setter;

import com.rainbow.fw.web.codelist.bean.CodeDefine;

public class CodeListLoader {
	@Getter
	@Setter
	private CodeListService codeListService;

	private Map<String, List<CodeDefine>> codeListMap = new HashMap<String, List<CodeDefine>>();

	@PostConstruct
	public void initCodeList() {
		List<CodeDefine> codeDefineList = codeListService.getAllCodeList();
		for (CodeDefine codeDefine : codeDefineList) {
			String codeName = codeDefine.getCodeName();
			List<CodeDefine> defineList = codeListMap.get(codeName);
			if (null == defineList) {
				defineList = new ArrayList<CodeDefine>();
				codeListMap.put(codeName, defineList);
			}
			defineList.add(codeDefine);
		}
	}

	public List<CodeDefine> getCodeBeans(String id) {
		// TODO Auto-generated method stub

		List<CodeDefine> codeDefineList = codeListMap.get(id);
		// Map<String, String> cardType = new LinkedHashMap<String, String>();

		// for (CodeDefine codeDefine : codeDefineList) {
		// cardType.put(codeDefine.getCodeKey(), codeDefine.getCodeValue());
		// }
		//
		// // cardType.put("VISA", "Visa");
		// // cardType.put("MASTER", "MasterCard");
		// // cardType.put("AS", "American Express");
		//
		// cardType = Collections.unmodifiableMap(cardType);

		return codeDefineList;
	}

}
