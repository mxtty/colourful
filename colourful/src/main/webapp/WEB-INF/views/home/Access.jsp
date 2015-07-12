<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=S4xGgT69F7qE62chXbcAiQk9"></script>
<p id ="navId" class ="accessNav">
<!--==============================content================================-->

        <div class="col-5">
        	<h3 class="h3-line">本店位置</h3>
              <div class="map img-border"  style="height:400px;width:860px;border:#ccc solid 1px;font-size:12px" id="map"></div>
            <div style="width:860px;">
            	<dl class="adr">
                    <dt class="clr-3 it-bold">地址：</dt>
                    <dd>830000 新疆乌鲁木齐市大寨沟12号</dd>
                    <dd><span>电话:</span><strong class="clr-2">0991-3812345</strong></dd>
                    <dd><span>手机:</span><strong class="clr-2">13886586621</strong></dd>
                    <dd><span>Email:</span><a href="#" class="link">mail@valencia.com</a></dd>
                </dl>
                <dl class="adr last">
                    <dt class="clr-3 it-bold">交通：</dt>
                    <dd>2路公共汽车大寨沟站下车，左转50米，大寨沟商业一条街18号</dd>
                </dl>
            </div>
        </div>

    <script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
      createMap();//创建地图
      setMapEvent();//设置地图事件
      addMapControl();//向地图添加控件
      addMapOverlay();//向地图添加覆盖物
    }
    function createMap(){ 
     var map = new BMap.Map("map"); 
     var point = new BMap.Point(87.579300,43.84587);
     map.centerAndZoom(point,19);
  	
    var marker = new BMap.Marker(point);  // 创建标注
	 
		var sContent ="<b>五彩爽口饺子:</b>温州街132号<br><b>电话：</b>13201258528";
		var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
		map.openInfoWindow(infoWindow,point); //开启信息窗口

	  	 map.addOverlay(marker);               // 将标注添加到地图中
		 marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
		
    }
    function setMapEvent(){
      map.enableScrollWheelZoom();
      map.enableKeyboard();
      map.enableDragging();
      map.enableDoubleClickZoom()
    }
    function addClickHandler(target,window){
      target.addEventListener("click",function(){
        target.openInfoWindow(window);
      });
    }
    function addMapOverlay(){
    }
    //向地图添加控件
    function addMapControl(){
      var scaleControl = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
      scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
      map.addControl(scaleControl);
      var navControl = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
      map.addControl(navControl);
      var overviewControl = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});
      map.addControl(overviewControl);
    }
    var map;
      initMap();
  </script>