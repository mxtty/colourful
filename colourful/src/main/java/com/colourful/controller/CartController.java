package com.colourful.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.OrderService;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.form.CartEntryForm;
import com.colourful.form.CartForm;
import com.colourful.form.OrderEntryForm;
import com.rainbow.fw.web.context.WebApplicationContext;

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

	@Autowired
	private WebApplicationContext appContext;

	@ModelAttribute("cartForm")
	public CartForm initCartForm(Model model) {
		return new CartForm();
	}

	@ModelAttribute("orderEntryForm")
	public OrderEntryForm initOrderEntryForm(Model model) {
		return new OrderEntryForm();
	}

	@RequestMapping(value = "add")
	public String addToCart(@Valid @ModelAttribute CartEntryForm cartEntryForm, BindingResult result, Model model) {
		// System.out.println("PID:" + orderEntryForm.getProductId() + "QAN:" +
		// orderEntryForm.getQuantity());
		String cartId = cartService.getCartId();

		System.out.println("CARTID IN ADD" + cartId);
		cartService.updateCart(cartEntryForm.getProductId(), cartEntryForm.getQuantity(), cartId);

		return "forward:/cart/Cart";
	}

	@RequestMapping(value = "Cart")
	public String showCart(@ModelAttribute CartForm cartForm, Model model) {

		String cartId = cartService.getCartId();

		cartForm.setCartId(cartId);

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
		List<ProductDetail> productDetailList = cartEntity.getSelectedProductDetailList();

		BigDecimal total = BigDecimal.ZERO;
		for (ProductDetail pd : productDetailList) {
			total = total.add(pd.getSubTotal());
		}

		cartForm.setTotal(total);
		cartForm.setShipping(BigDecimal.valueOf(5));
		cartForm.setProductDetailList(productDetailList);

		return "cart/Cart";

	}
	//
	// @RequestMapping(value = "Checkout", method = RequestMethod.POST)
	// @ExceptionHandlerAdvice(errorPath = "order/MakeOrder")
	// public String checkOut(Principal principal, @ModelAttribute CartForm
	// cartForm, Model model) {
	//
	// String cartId = cartService.getCartId();
	//
	// for (ProductDetail pd : cartForm.getProductDetailList()) {
	// cartService.updateCart(pd.getProductId(), pd.getQuantity(), cartId);
	// }
	//
	// return "forward:/cart/MakeOrder";
	// }
	//
	// @RequestMapping(value = "MakeOrder")
	// public String makeOrder(@ModelAttribute OrderEntryForm orderEntryForm,
	// Model model) {
	// if (appContext.isAuthenticated()) {
	//
	// RainbowUserDetails userDetails =
	// appContext.getUserDetails(RainbowUserDetails.class);
	// orderEntryForm.setShipName(userDetails.getRealName());
	// orderEntryForm.setPhone(userDetails.getPhone());
	// orderEntryForm.setShipAddress(userDetails.getShipAddress());
	//
	// }
	// return "cart/Checkout";
	//
	// }
	//
	// @RequestMapping(value = "OrderFinish", method = RequestMethod.POST)
	// @ExceptionHandlerAdvice(errorPath = "order/MakeOrder")
	// public String submit(@Valid @ModelAttribute OrderEntryForm
	// orderEntryForm, @ModelAttribute CartForm cartForm,
	// BindingResult result, Model model, SessionStatus status) {
	// // public String submit(@Valid @ModelAttribute OrderEntryForm
	// // orderEntryForm, BindingResult result, Model model) {
	//
	// String cartId = cartService.getCartId();
	// // 生成订单
	// BrnOrderEntity orderEntity =
	// EntityFactory.newEntity(BrnOrderEntity.class);
	// orderEntity.fromObject(orderEntryForm);
	// orderEntity.setCartId(cartId);
	// orderEntity.newOrder();
	//
	// orderEntryForm.setOrderId(orderEntity.getOrderId());
	//
	// orderService.newOrder(orderEntity.getOrderId(), cartId,
	// cartForm.getProductDetailList());
	//
	// BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
	// cartEntity.getEntityByPk();
	//
	// if (null == cartEntity.getUserId() && appContext.isAuthenticated()) {
	// RainbowUserDetails userDetails = (RainbowUserDetails)
	// appContext.getUserDetails(RainbowUserDetails.class);
	// cartEntity.setUserId(userDetails.getUserId());
	// cartEntity.update();
	// }
	//
	// status.setComplete();
	// return "cart/OrderFinish";
	//
	// }
	//
	// @RequestMapping(value = "ViewOrder/{orderId}")
	// public String viewOrder(@PathVariable long orderId, Model model) {
	// String cartId = cartService.getCartId();
	// BrnOrderEntity orderEntity =
	// EntityFactory.newEntity(BrnOrderEntity.class);
	// orderEntity.setOrderId(orderId);
	// orderEntity.getEntityByPk();
	//
	// if (!appContext.isAuthenticated()) {
	// if (StringUtils.isEmpty(cartId) ||
	// !cartId.equals(orderEntity.getCartId())) {
	// return "cart/ViewOrder";
	// }
	// } else {
	//
	// RainbowUserDetails userDetails =
	// appContext.getUserDetails(RainbowUserDetails.class);
	//
	// BrnCartEntity cartEntity = orderEntity.getBrnCartEntity();
	// if (!userDetails.getUserId().equals(cartEntity.getUserId())) {
	// return "cart/ViewOrder";
	// }
	// }
	//
	// BrnOrder brnOrder = new BrnOrder();
	//
	// orderEntity.toObject(brnOrder);
	//
	// // OrderHistory orderHistory = new OrderHistory();
	// // orderHistory.setBrnOrder(brnOrder);
	//
	// // orderService.newOrder(orderId, orderEntity.getCartId(),
	// // productDetailList);
	//
	// // cartService.addItem(itemId);
	// List<ProductDetail> orderDetailList =
	// orderEntity.getOrderedProductDetailList();
	// // orderHistory.setProductDetailList(productDetailList);
	// model.addAttribute("brnOrder", brnOrder);
	// model.addAttribute("productDetailList", orderDetailList);
	// return "cart/ViewOrder";
	// }

}
