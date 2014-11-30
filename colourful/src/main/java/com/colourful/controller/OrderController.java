package com.colourful.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.colourful.domain.entity.OrderEntity;
import com.colourful.domain.querydata.CartItem;
import com.colourful.domain.record.CodeDefineImpl;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.OrderService;
import com.colourful.io.OrderForm;
import com.rainbow.fw.core.exception.handler.ExceptionHandlerAdvice;
import com.rainbow.fw.web.codelist.bean.CodeDefine;

@Controller
@RequestMapping("/order")
@SessionAttributes({ "orderForm", "cart" })
public class OrderController {
	Logger logger = LogManager.getLogger(OrderController.class.getName());
	@Autowired
	private transient OrderService orderService;

	@Autowired
	private CartService cartService;

	private boolean shippingAddressRequired;
	private boolean confirmed;
	private List<OrderEntity> orderList;

	@ModelAttribute("orderForm")
	public OrderForm initForm(Model model) {
		return new OrderForm();
	}

	public boolean isShippingAddressRequired() {
		return shippingAddressRequired;
	}

	public void setShippingAddressRequired(boolean shippingAddressRequired) {
		this.shippingAddressRequired = shippingAddressRequired;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public List<OrderEntity> getOrderList() {
		return orderList;
	}

	// public Resolution listOrders() {
	// HttpSession session = context.getRequest().getSession();
	// AccountActionBean accountBean = (AccountActionBean) session
	// .getAttribute("/actions/Account.action");
	// orderList = orderService.getOrdersByUsername(accountBean.getAccount()
	// .getUsername());
	// return new ForwardResolution(LIST_ORDERS);
	// }

	@RequestMapping(value = "newOrder")
	public String newOrderForm(@ModelAttribute OrderForm orderForm, Model model) {

		OrderEntity orderEntity = orderService.createEntity();
		BeanUtils.copyProperties(orderForm, orderEntity);
		// orderEntity.initOrder(EntityFactory.newCartEntity(userId, itemId,
		// productId));

		BeanUtils.copyProperties(orderEntity, orderForm);
		model.addAttribute("orderForm", orderForm);

		List<CartItem> cartList = orderForm.getCartList();
		for (CartItem c : cartList) {
			System.out.println("Item Id:" + c.getItemId() + " Product Id:"+c.getProductId()+" Quantity:" + c.getQuantity());
		}
		// test for options from DB
		List<CodeDefine> codeDefineTest = new ArrayList<CodeDefine>();
		CodeDefine cd1 = new CodeDefineImpl();
		CodeDefine cd2 = new CodeDefineImpl();
		cd1.setCodeKey("Master");
		cd1.setCodeValue("MASTER");

		cd2.setCodeKey("Visa");
		cd2.setCodeValue("VISA");

		codeDefineTest.add(cd1);
		codeDefineTest.add(cd2);

		model.addAttribute("codeDefineTest", codeDefineTest);
		return "order/NewOrderForm";
	}

	@RequestMapping(value = "viewCart")
	public String viewCart(Model model) {
		// model.addAttribute("cart", cartService.getCartEntity());
		return "cart/Cart";
	}

	// @ExceptionHandlerAdvice(errorPath="order/NewOrderForm");
	@RequestMapping(value = "confirm", method = RequestMethod.POST)
	@ExceptionHandlerAdvice(errorPath = "order/NewOrderForm")
	public String newOrderConfirm(@Valid OrderForm orderForm, BindingResult result) {
		System.out.println("In NewOrderConfirm");
		System.out.println(orderForm.getBillToFirstName());
		if (result.hasErrors()) {
			return "order/NewOrderForm";
		} else {
			return "order/ConfirmOrder";
		}
	}

	@RequestMapping(value = "insert")
	public String insertOrder(@ModelAttribute OrderForm orderForm, SessionStatus ss, Model model) {

		OrderEntity orderEntity = orderService.createEntity();
		BeanUtils.copyProperties(orderForm, orderEntity);

		// orderEntity.initOrder(cartService.getCartEntity());
		ss.setComplete();
		orderEntity.insertOrder();
		// orderService.insertOrder(order);
		model.addAttribute("lineItems", orderEntity.getLineItems());
		cartService.clearCart();
		return "order/ViewOrder";

	}

}
