package com.colourful.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.colourful.domain.data.OptionAddress;
import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.data.RainbowUserDetails;
import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.entity.BrnOrderEntity;
import com.colourful.domain.exception.ExceptionId;
import com.colourful.domain.generated.record.BrnOrder;
import com.colourful.domain.generated.record.BrnUserDetail;
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

	@RequestMapping(value = "Checkout", method = RequestMethod.POST)
	@ExceptionHandlerAdvice(errorPath = "order/MakeOrder")
	public String checkOut(Principal principal, @ModelAttribute CartForm cartForm,
			@ModelAttribute OrderEntryForm orderEntryForm, Model model) {

		String cartId = cartService.getCartId();

		for (ProductDetail pd : cartForm.getProductDetailList()) {
			cartService.updateCart(pd.getProductId(), pd.getQuantity(), cartId);
		}

		if (!appContext.isAuthenticated())
			return "forward:/account/auth";

		RainbowUserDetails userDetails = appContext.getUserDetails(RainbowUserDetails.class);

		orderEntryForm.setShipName(userDetails.getRealName());
		orderEntryForm.setPhone(userDetails.getPhone());
		orderEntryForm.setShipAddress(userDetails.getShipAddress());

		if (userDetails.hasMultiAddress()) {
			orderEntryForm.setOptionAddressList(userDetails.createOptionAddressList());
			return "forward:/order/SelectAddress";
		} else
			return "forward:/order/MakeOrder";

	}

	@RequestMapping(value = "MakeOrder")
	public String makeOrder(@ModelAttribute OrderEntryForm orderEntryForm, Model model) {

		if (appContext.isAuthenticated()) {
			List<OptionAddress> optionAddressList = orderEntryForm.getOptionAddressList();

			int selectedAddressIdx = orderEntryForm.getSelectedAddressIdx();

			if (CollectionUtils.isEmpty(optionAddressList) || optionAddressList.size() < selectedAddressIdx
					|| selectedAddressIdx < 0) {
				ExceptionId.E1001.rejectSys("系统异常");
			}

			RainbowUserDetails userDetails = appContext.getUserDetails(RainbowUserDetails.class);

			BrnUserDetail brnUserDetail = userDetails.getAddressList().get(selectedAddressIdx);
			orderEntryForm.setAddress(brnUserDetail);

		}

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

		status.setComplete();
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
