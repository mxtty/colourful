package com.colourful.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.domain.data.HomeContents;
import com.colourful.domain.data.News;
import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.BrnImageEntity;
import com.colourful.domain.generated.record.BrnImage;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.form.MenuForm;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private MessageSource messageSource;

	private static Logger log = Logger.getLogger(HomeController.class);

	@ModelAttribute("selectedMenuForm")
	public MenuForm initForm(Model model) {
		return new MenuForm();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(ModelMap model) {

		HomeContents homeContents = new HomeContents();
		homeContents.setSliderFile("200_slider-1.jpg");
		homeContents.setHomeSubImgFile("200_page1-img1.jpg");

		News newsletter = new News();
		newsletter.setTitle("我们的目标是健康饮食");
		newsletter.setContents("五彩爽口饺子成立于2005年，各类饺子凉菜等美味佳肴，欢迎品尝");
		homeContents.setNewsletter(newsletter);

		News n1 = new News();
		n1.setAuthor("店长");
		n1.setTitle("10月大优惠");
		n1.setContents("凡在本店消费超过50元，均赠送价值20元优惠券一张，欢迎选购。");

		News n2 = new News();
		n2.setAuthor("收银员");
		n2.setTitle("支付宝支付开始啦");
		n2.setContents("本店现已开通支付宝支付，在线下单支付，方便快捷。");

		homeContents.addNews(n1);
		homeContents.addNews(n2);

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
	public String gallery(ModelMap model) {

		BrnImageEntity brnImageEntity = EntityFactory.newEntity(BrnImageEntity.class);
		brnImageEntity.setId(100);
		List<BrnImage> imageList = brnImageEntity.getRecords();

		model.addAttribute("imageList", imageList);
		return "home/Gallery";

	}

	@RequestMapping(value = "Access", method = RequestMethod.GET)
	public String access(ModelMap model) {

		return "home/Access";

	}

	@RequestMapping(value = "Philosophy", method = RequestMethod.GET)
	public String philosophy(ModelMap model) {

		return "home/Philosophy";

	}

	@RequestMapping(value = "Menu", method = RequestMethod.GET)
	public String menu(ModelMap model) {

		return "home/Menu";

	}

}