package com.colourful.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.entity.BrnOrderEntity;
import com.colourful.domain.generated.record.BrnOrder;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.OrderService;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.form.CartEntryForm;
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

	@Autowired
	private OrderService orderService;

	@ModelAttribute("cartForm")
	public CartForm initCartForm(Model model) {
		return new CartForm();
	}

	@ModelAttribute("orderEntryForm")
	public OrderEntryForm initOrderEntryForm(Model model) {
		return new OrderEntryForm();
	}

	@RequestMapping(value = "add")
	public String addToCart(HttpSession session, @CookieValue(value = "cartId", defaultValue = "") String cartId,
			HttpServletResponse response, @Valid @ModelAttribute CartEntryForm cartEntryForm, BindingResult result,
			Model model) {
		// System.out.println("PID:" + orderEntryForm.getProductId() + "QAN:" +
		// orderEntryForm.getQuantity());
		if (StringUtils.isEmpty(cartId)) {
			Cookie cookie = new Cookie("cartId", session.getId());
			// 有效期限180天
			cookie.setMaxAge(60 * 60 * 24 * 180);
			// cookie.setSecure(true);
			cartId = session.getId();
			response.addCookie(cookie);
		}
		// System.out.println("CARTID IN ADD" + cartId);
		cartService.updateCart(cartEntryForm.getProductId(), cartEntryForm.getQuantity(), cartId);

		// cartService.addItem(itemId);

		// model.addAttribute("cart", cartService.getCartEntity());
		return "forward:/cart/showCart";
	}

	@RequestMapping(value = "showCart")
	public String showCart(@CookieValue(value = "cartId", defaultValue = "") String cartId,
			@ModelAttribute CartForm cartForm, ModelMap model) {
		cartForm.setCartId(cartId);
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
	public String checkOut(@ModelAttribute CartForm cartForm, ModelMap model) {

		for (ProductDetail pd : cartForm.getProductDetailList()) {
			cartService.updateCart(pd.getProductId(), pd.getQuantity(), cartForm.getCartId());
		}

		return "cart/Checkout";
	}

	@RequestMapping(value = "orderFinish")
	public String submit(@Valid @ModelAttribute OrderEntryForm orderEntryForm, @ModelAttribute CartForm cartForm,
			ModelMap model) {

		// 生成订单
		BrnOrderEntity orderEntity = EntityFactory.newEntity(BrnOrderEntity.class);
		orderEntity.fromObject(orderEntryForm);
		orderEntity.setCartId(cartForm.getCartId());
		orderEntity.newOrder();

		orderEntryForm.setOrderId(orderEntity.getOrderId());

		orderService.newOrder(orderEntity.getOrderId(), cartForm.getCartId(), cartForm.getProductDetailList());
		return "order/OrderFinish";

	}

	@RequestMapping(value = "viewOrder/{orderId}")
	public String viewOrder(@ModelAttribute CartForm cartForm, @PathVariable long orderId, ModelMap model,
			BindingResult result) {

		BrnOrderEntity orderEntity = EntityFactory.newEntity(BrnOrderEntity.class);
		orderEntity.setOrderId(orderId);
		orderEntity.getEntityByPk();

		if (!orderEntity.getCartId().equals(cartForm.getCartId())) {
			//model.addAttribute("productDetailList", new ArrayList<ProductDetail>());
			return "order/ViewOrder";
		}

		BrnOrder brnOrder = new BrnOrder();

		orderEntity.toObject(brnOrder);

		// OrderHistory orderHistory = new OrderHistory();
		// orderHistory.setBrnOrder(brnOrder);

		// orderService.newOrder(orderId, orderEntity.getCartId(),
		// productDetailList);

		// cartService.addItem(itemId);
		List<ProductDetail> productDetailList = orderEntity.getOrderedProductDetailList();
		// orderHistory.setProductDetailList(productDetailList);
		model.addAttribute("brnOrder", brnOrder);
		model.addAttribute("productDetailList", productDetailList);
		return "order/ViewOrder";
	}
}
