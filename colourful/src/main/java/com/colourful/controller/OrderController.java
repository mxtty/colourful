package com.colourful.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.data.RainbowUserDetails;
import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.entity.BrnOrderEntity;
import com.colourful.domain.generated.record.BrnOrder;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.OrderService;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.form.CartForm;
import com.colourful.form.OrderEntryForm;
import com.rainbow.fw.core.exception.handler.ExceptionHandlerAdvice;
import com.rainbow.fw.web.context.WebApplicationContext;

/**
 * 
 */
@Controller
@RequestMapping("order")
@SessionAttributes({ "orderEntryForm", "cartForm" })
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private WebApplicationContext appContext;

	@ModelAttribute("orderEntryForm")
	public OrderEntryForm initForm(Model model) {
		return new OrderEntryForm();
	}

	@RequestMapping(value = "CheckoutNoLogin", method = RequestMethod.POST)
	@ExceptionHandlerAdvice(errorPath = "cart/Cart")
	public String checkoutNoLogin(@Valid @ModelAttribute CartForm cartForm, BindingResult result, Model model) {

		List<ProductDetail> productDetailList = cartForm.getProductDetailList();
		for (int i = 0; i < productDetailList.size(); i++) {
			ProductDetail detail = productDetailList.get(i);
			if (null == detail.getQuantity()) {
				result.rejectValue("productDetailList[" + i++ + "].quantity", "typeMismatch.int");
			}
		}

		if (result.hasErrors())
			return "cart/Cart";
		
		String cartId = cartService.getCartId();

		List<ProductDetail> deleteProductDetailList = new ArrayList<ProductDetail>();
		for (ProductDetail pd : productDetailList) {
			if (1 == pd.getStatus()) {
				cartService.removeFromCart(pd.getProductId(), pd.getQuantity(), cartId);
				deleteProductDetailList.add(pd);
			} else if (2 == pd.getStatus()) {
				deleteProductDetailList.add(pd);
			} else {
				cartService.updateCart(pd.getProductId(), pd.getQuantity(), cartId);
			}
		}

		if (0 < deleteProductDetailList.size()) {
			productDetailList.removeAll(deleteProductDetailList);
		}

		
		return "forward:order/Checkout";
	}

	@RequestMapping(value = "Checkout", method = RequestMethod.POST)
	// @ExceptionHandlerAdvice(errorPath = "order/MakeOrder")
	@ExceptionHandlerAdvice(errorPath = "cart/Cart")
	public String checkOut(@Valid @ModelAttribute CartForm cartForm, BindingResult result, Model model,
			@ModelAttribute OrderEntryForm orderEntryForm, SessionStatus status) {

		List<ProductDetail> productDetailList = cartForm.getProductDetailList();
		for (int i = 0; i < productDetailList.size(); i++) {
			ProductDetail detail = productDetailList.get(i);
			if (null == detail.getQuantity()) {
				result.rejectValue("productDetailList[" + i++ + "].quantity", "typeMismatch.int");
			}
		}

		if (result.hasErrors())
			return "cart/Cart";

		String cartId = cartService.getCartId();

		List<ProductDetail> deleteProductDetailList = new ArrayList<ProductDetail>();
		for (ProductDetail pd : productDetailList) {
			if (1 == pd.getStatus()) {
				cartService.removeFromCart(pd.getProductId(), pd.getQuantity(), cartId);
				deleteProductDetailList.add(pd);
			} else if (2 == pd.getStatus()) {
				deleteProductDetailList.add(pd);
			} else {
				cartService.updateCart(pd.getProductId(), pd.getQuantity(), cartId);
			}
		}

		if (0 < deleteProductDetailList.size()) {
			productDetailList.removeAll(deleteProductDetailList);
		}

		if (!appContext.isAuthenticated())
			return "order/Checkout";

		RainbowUserDetails userDetails = appContext.getUserDetails(RainbowUserDetails.class);

		orderEntryForm.setShipName(userDetails.getShipName());
		orderEntryForm.setPhone(userDetails.getPhone());
		orderEntryForm.setShipAddress(userDetails.getShipAddress());
		orderEntryForm.setShipDate(null);

		if (userDetails.hasMultiAddress()) {
			orderEntryForm.setOptionAddressList(userDetails.getAddressList());
			return "forward:/order/SelectAddress";
		} else
			// 仅有一个地址时，将第一个地址设为送货地址
			return "forward:/order/MakeOrder/0";

	}

	@RequestMapping(value = "MakeOrder/{selectedIdx}")
	public String makeOrderLogin(@PathVariable int selectedIdx, @ModelAttribute OrderEntryForm orderEntryForm,
			Model model) {

		if (orderEntryForm.hasMultiAddress())
			orderEntryForm.setSelectedAddress(selectedIdx);

		return "order/Checkout";
	}

	@RequestMapping(value = "SelectAddress")
	public String selectAddress(@ModelAttribute OrderEntryForm orderEntryForm, Model model) {

		return "order/SelectAddress";
	}

	// @RequestMapping(value = "SelectAddress")
	// public String selectAddress() {
	// return "order/SelectAddress";
	// }

	@RequestMapping(value = "OrderFinish", method = RequestMethod.POST)
	@ExceptionHandlerAdvice(errorPath = "order/MakeOrder")
	public String submit(@Valid @ModelAttribute OrderEntryForm orderEntryForm, BindingResult result, Model model,
			@ModelAttribute CartForm cartForm, SessionStatus status) {
		// public String submit(@ModelAttribute("orderEntryForm") @Valid
		// OrderEntryForm orderEntryForm, BindingResult result,
		// ModelMap model) {

		String cartId = cartService.getCartId();
		// 生成订单
		BrnOrderEntity orderEntity = EntityFactory.newEntity(BrnOrderEntity.class);
		orderEntity.fromObject(orderEntryForm);
		orderEntity.setCartId(cartId);
		orderEntity.newOrder();

		orderEntryForm.setCartId(cartId);
		orderEntryForm.setOrderId(orderEntity.getOrderId());

		orderService.newOrder(orderEntity.getOrderId(), cartId, cartForm.getProductDetailList());

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
		cartEntity.getEntityByPk();

		if (null == cartEntity.getUserId() && appContext.isAuthenticated()) {
			RainbowUserDetails userDetails = (RainbowUserDetails) appContext.getUserDetails(RainbowUserDetails.class);
			cartEntity.setUserId(userDetails.getUserId());
			cartEntity.update();
		}

		// status.setComplete();
		return "order/OrderFinish";

	}

	@RequestMapping(value = "ViewOrder/{cartId}/{orderId}")
	public String viewOrder(@PathVariable String cartId, @PathVariable long orderId, Model model) {

		if (null == cartId || orderId < 1)
			return "order/ViewOrder";

		BrnOrderEntity orderEntity = EntityFactory.newEntity(BrnOrderEntity.class);
		orderEntity.setOrderId(orderId);
		orderEntity.getEntityByPk();

		if (!cartId.equals(orderEntity.getCartId()))
			return "order/ViewOrder";

		BrnOrder brnOrder = new BrnOrder();

		orderEntity.toObject(brnOrder);

		// OrderHistory orderHistory = new OrderHistory();
		// orderHistory.setBrnOrder(brnOrder);

		// orderService.newOrder(orderId, orderEntity.getCartId(),
		// productDetailList);

		// cartService.addItem(itemId);
		List<ProductDetail> orderDetailList = orderEntity.getOrderedProductDetailList();
		// orderHistory.setProductDetailList(productDetailList);
		model.addAttribute("brnOrder", brnOrder);
		model.addAttribute("productDetailList", orderDetailList);
		return "order/ViewOrder";
	}
}
