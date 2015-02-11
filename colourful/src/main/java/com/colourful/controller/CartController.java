package com.colourful.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.form.CartForm;
import com.colourful.form.OrderEntryForm;

/**
 * 
 */
@Controller
@RequestMapping("/cart")
@SessionAttributes("cartForm")
public class CartController {

	@Autowired
	private CartService cartService;

	@ModelAttribute("cartForm")
	public CartForm initForm(Model model) {
		return new CartForm();
	}

	@RequestMapping(value = "add")
	public String addToCart(HttpSession session, @CookieValue(value = "cartId", defaultValue = "") String cartId,
			HttpServletResponse response, @Valid @ModelAttribute OrderEntryForm orderEntryForm, BindingResult result,
			Model model) {
		//System.out.println("PID:" + orderEntryForm.getProductId() + "QAN:" + orderEntryForm.getQuantity());
		if (StringUtils.isEmpty(cartId)) {
			Cookie cookie = new Cookie("cartId", session.getId());
			// 有效期限180天
			cookie.setMaxAge(60 * 60 * 24 * 180);
			// cookie.setSecure(true);
			cartId = session.getId();
			response.addCookie(cookie);
		}
		//System.out.println("CARTID IN ADD" + cartId);
		cartService.addToCart(orderEntryForm.getProductId(), orderEntryForm.getQuantity(), cartId);

		// cartService.addItem(itemId);

		// model.addAttribute("cart", cartService.getCartEntity());
		return "forward:/cart/showCart";
	}

	@RequestMapping(value = "showCart")
	public String showCart(@CookieValue(value = "cartId", defaultValue = "") String cartId,
			@ModelAttribute CartForm cartForm, ModelMap model) {
		System.out.println("CARTID IN SHOW" + cartId);
		// ProductDetail pd1 = new ProductDetail();
		// pd1.setImgFileMain("c1001_10001_img3.jpg");
		// pd1.setUnit("份");
		// pd1.setUnitPrice(BigDecimal.valueOf(11.8));
		// pd1.setProductId(10001);
		// pd1.setDescription("美味可口，回味无穷");
		// pd1.setProductName("猪肉水饺");
		//
		// List<ProductDetail> productDetailList = new
		// ArrayList<ProductDetail>();
		// productDetailList.add(pd1);
		// productDetailList.add(pd1);

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
		List<ProductDetail> productDetailList = cartEntity.getSelectedProductDetailList();

		BigDecimal total = BigDecimal.ZERO;
		for (ProductDetail pd : productDetailList) {
			total = total.add(pd.getSubTotal());
		}

		cartForm.setTotal(total);
		cartForm.setShipping(BigDecimal.valueOf(5));
		cartForm.setProductDetailList(productDetailList);
		// model.addAttribute("total", total);
		// model.addAttribute("shipping", "5");
		// model.addAttribute("productDetailList", productDetailList);

		return "cart/Cart";

	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkOut(@CookieValue(value = "cartId", defaultValue = "") String cartId,
			@ModelAttribute CartForm cartForm, ModelMap model) {

		for (ProductDetail pd : cartForm.getProductDetailList()) {
			cartService.addToCart(pd.getProductId(), pd.getQuantity(), cartId);
		}
		
		return "cart/Checkout";
	}
}
