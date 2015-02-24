package com.colourful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.service.ProductService;
import com.colourful.form.CartEntryForm;

/**
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@ModelAttribute("cartEntryForm")
	public CartEntryForm initForm(Model model) {
		return new CartEntryForm();
	}

	@RequestMapping(value = "showProduct/{productId}", method = RequestMethod.GET)
	public String displayProducts(@PathVariable long productId, ModelMap model) {
		// ProductDetail productDetail = new ProductDetail();
		// productDetail.setImgFileMain("c1001_10001_img2.jpg");
		// productDetail.setProductId(productId);
		// productDetail.setProductName("猪肉水饺");
		// productDetail.setUnit("盘");
		// productDetail.setUnitPrice(BigDecimal.valueOf(11.8));
		// productDetail.addImgFileSub("c1001_10001_img3.jpg");
		// productDetail.addImgFileSub("c1001_10001_img3.jpg");
		// productDetail.addImgFileSub("c1001_10001_img3.jpg");
		// productDetail.addImgFileSub("c1001_10001_img3.jpg");
		// productDetail.setDescription("酱香牛肉是本店一道招牌菜，味道好，价格适中。居家旅游之必备凉菜。欢迎选购，数量有限，欲购者从速。");
		//
		//
		ProductDetail productDetail = productService.getProductDetail(productId);

		model.addAttribute(productDetail);

		return "product/showProduct";

	}
}
