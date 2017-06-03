package com.orientation.model.param;

import core.support.ExtJSBaseParameter;

/**
 * 附件的参数类
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public class WheatProductionParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = -1946385245181503185L;
	   private Integer id;
	     private String region;
	     private Integer year;
	     private Integer production;
	     private Integer areaSown;
	     private Integer lifeCycle;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
		public Integer getProduction() {
			return production;
		}
		public void setProduction(Integer production) {
			this.production = production;
		}
		public Integer getAreaSown() {
			return areaSown;
		}
		public void setAreaSown(Integer areaSown) {
			this.areaSown = areaSown;
		}
		public Integer getLifeCycle() {
			return lifeCycle;
		}
		public void setLifeCycle(Integer lifeCycle) {
			this.lifeCycle = lifeCycle;
		}
	
	


}
