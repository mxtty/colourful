package com.rainbow.fw.web.taglib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rainbow.fw.web.codelist.CodeListLoader;
import com.rainbow.fw.web.codelist.bean.CodeDefine;
import com.rainbow.fw.web.context.ContextProvider;

public class CodeListTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7550280327858449058L;

	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(CodeListTag.class);

	private static List<CodeDefine> EMPTYLIST = new ArrayList<CodeDefine>();

	private List<CodeDefine> codeDefineList;

	public List<CodeDefine> getCodeDefineList() {
		return codeDefineList;
	}

	public void setCodeDefineList(List<CodeDefine> codeDefineList) {
		this.codeDefineList = (null != codeDefineList ? codeDefineList : EMPTYLIST);
	}

	public void setCodeDefineList(String codeDefineList) {
		this.codeDefineList = EMPTYLIST;
	}

	/**
	 * TAG开始时调用方法
	 * 
	 * 
	 * @return EVAL_BODY_INCLUDE
	 * @throws JspException
	 *             JSP 例外
	 */
	@Override
	public int doStartTag() throws JspException {
		if (log.isDebugEnabled()) {
			log.debug("doStartTag() called.");
		}

		if ("".equals(id)) {
			// id未设定
			log.error("id is required.");
			throw new JspTagException("id is required.");
		}

		CodeListLoader loader = null;

		if (null == codeDefineList) {
			try {
				loader = ContextProvider.getBean(CodeListLoader.class);

			} catch (ClassCastException e) {
				// 无法加载CodeListLoader时
				String errorMessage = "bean id:" + id + " is not instance of CodeListLoader.";
				log.error(errorMessage);
				throw new JspTagException(errorMessage, e);
			}
			codeDefineList = loader.getCodeBeans(id);
		}

		Map<String, String> cardType = new LinkedHashMap<String, String>();
		for (CodeDefine codeDefine : codeDefineList) {
			System.out.println("CodeValue:" + codeDefine.getCodeValue() + " CodeKey:" + codeDefine.getCodeKey());

			cardType.put(codeDefine.getCodeValue(), codeDefine.getCodeKey());
		}

		cardType = Collections.unmodifiableMap(cardType);

		if (cardType == null) {
			// codeBeanList为空时，设置空的ArrayList
			if (log.isWarnEnabled()) {
				log.warn("Codebean is null. CodeListLoader(bean id:" + id + ")");
			}
			pageContext.setAttribute(id, new ArrayList<String>(), PageContext.PAGE_SCOPE);
		} else {
			// Page Scope里注册属性
			pageContext.setAttribute(id, cardType, PageContext.PAGE_SCOPE);
		}

		return EVAL_BODY_INCLUDE;
	}

	/**
	 * TAG结束时调用方法
	 * 
	 * @return EVAL_PAGE
	 * @throws JspException
	 *             JSP 例外
	 */
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * TAG释放时调用方法
	 */
	@Override
	public void release() {
		super.release();
	}

}
