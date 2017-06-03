package com.orientation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.base.Objects;
import com.orientation.model.param.WheatProductionParameter;

/**
 * 附件的实体类
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Entity
@Table(name = "wheatProduction")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class WheatProduction extends WheatProductionParameter {

	// 各个字段的含义请查阅文档的数据库结构部分
	private static final long serialVersionUID = 7296680169194828397L;
	@Id
	@GeneratedValue
	@Column(name = "id")

	   private Integer id;
	   @Column(name = "region", length = 100)
	     private String region;
	   @Column(name = "year", length = 100)
	     private Integer year;
	   @Column(name = "production", length = 100)
	     private Integer production;
	   @Column(name = "areaSown", length = 100)
	     private Integer areaSown;
	   @Column(name = "lifeCycle", length = 100)
	     private Integer lifeCycle;
	
	public WheatProduction() {

	}


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




	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final WheatProduction other = (WheatProduction) obj;
		return Objects.equal(this.id, other.id) && Objects.equal(this.region, other.region) && Objects.equal(this.year, other.year) && Objects.equal(this.production, other.production)
				&& Objects.equal(this.areaSown, other.areaSown)&& Objects.equal(this.lifeCycle, other.lifeCycle);
	}

	public int hashCode() {
		return Objects.hashCode(this.id, this.region, this.year, this.production, this.areaSown, this.lifeCycle);
	}

}
