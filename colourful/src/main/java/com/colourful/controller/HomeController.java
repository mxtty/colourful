package com.colourful.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.colourful.domain.data.CategoryDetail;
import com.colourful.domain.data.HomeContents;
import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.data.Products;
import com.colourful.domain.entity.BrnCategoryEntity;
import com.colourful.domain.entity.BrnImageEntity;
import com.colourful.domain.entity.BrnNewsEntity;
import com.colourful.domain.entity.BrnProductEntity;
import com.colourful.domain.generated.record.BrnImage;
import com.colourful.domain.generated.record.BrnNews;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.form.MenuForm;
import com.rainbow.fw.core.exception.handler.ExceptionHandlerAdvice;

@Controller
@RequestMapping("/home")
@SessionAttributes({ "menuForm" })
public class HomeController {

	@Autowired
	private MessageSource messageSource;

	private static Logger log = Logger.getLogger(HomeController.class);

	@Autowired
	private CartService cartService;

	@ModelAttribute("menuForm")
	public MenuForm initForm(Model model) {
		return new MenuForm();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(Model model) {

		BrnNewsEntity brnNewsEntity = EntityFactory.newEntity(BrnNewsEntity.class);
		List<BrnNews> newsList = brnNewsEntity.readHomeNews();

		HomeContents homeContents = new HomeContents();
		homeContents.setSliderFile("200_slider-1.jpg");
		homeContents.setHomeSubImgFile("200_page1-img1.jpg");

		homeContents.setNewsletter(newsList.get(0));

		newsList.remove(0);

		homeContents.addNews(newsList);

		BrnProductEntity productEntity = EntityFactory.newEntity(BrnProductEntity.class);
       // productEntity.
		
		ProductDetail p1 = new ProductDetail();
		p1.setProductId(20001);
		p1.setImgFileMain("thumbs_200_page1-img2.jpg");
		p1.setProductName("三鲜水饺");

		ProductDetail p2 = new ProductDetail();
		p2.setProductId(20002);
		p2.setImgFileMain("thumbs_200_page1-img3.jpg");
		p2.setProductName("猪肉水饺");

		homeContents.addProduct(p1);
		homeContents.addProduct(p2);

		model.addAttribute("homeContents", homeContents);

		return "home/Home";

	}

	@RequestMapping(value = "Gallery", method = RequestMethod.GET)
	public String gallery(Model model) {

		BrnImageEntity brnImageEntity = EntityFactory.newEntity(BrnImageEntity.class);
		brnImageEntity.setId(100);
		List<BrnImage> imageList = brnImageEntity.getRecords();

		model.addAttribute("imageList", imageList);
		return "home/Gallery";

	}

	@RequestMapping(value = "Access", method = RequestMethod.GET)
	public String access(Model model) {

		return "home/Access";

	}

	@RequestMapping(value = "Philosophy", method = RequestMethod.GET)
	public String philosophy(Model model) {

		return "home/Philosophy";

	}

	@RequestMapping(value = "Menu", method = RequestMethod.GET)
	public String menu(@ModelAttribute MenuForm menuForm, Model model) {
		BrnCategoryEntity allCategoryEntity = EntityFactory.newEntity(BrnCategoryEntity.class);
		List<CategoryDetail> categoryList = allCategoryEntity.getAllCategories();

		List<Products> productList = new ArrayList<Products>();
		for (CategoryDetail category : categoryList) {
			BrnCategoryEntity categoryEntity = EntityFactory.newBrnCategoryEntity(category.getCategoryId());
			productList.add(categoryEntity.getProducts());
		}
		menuForm.setProductsList(productList);

		return "home/Menu";

	}

	@RequestMapping(value = "addMultiProducts")
	@ExceptionHandlerAdvice(errorPath = "home/Menu")
	public String addMultiProducts(@Valid @ModelAttribute MenuForm menuForm, BindingResult result, Model model,
			SessionStatus sessionStatus) {
		List<Long> selectedProductIdList = menuForm.getSelectedProductIdList();

		String cartId = cartService.getCartId();

		for (Long productId : selectedProductIdList) {
			cartService.updateCart(productId, BigDecimal.ONE, cartId);
		}
		sessionStatus.setComplete();
		return "forward:/cart/Cart";

	}

	@RequestMapping(value = "Error403", method = RequestMethod.POST)
	public String error403(Model model) {

		return "common/Error403";

	}
}