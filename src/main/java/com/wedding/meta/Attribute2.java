package com.wedding.meta;
import java.util.List;

public class Attribute2 {
	
	int tenantId;
	String defaultLocaleCode;
	String defaultCurrencyCode;
	List<Attributes1>catalogs;
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTenantId() {
		return tenantId;
	}
	public List<Attributes1> getCatalogs() {
		return catalogs;
	}
	public void setCatalogs(List<Attributes1> catalogs) {
		this.catalogs = catalogs;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public String getDefaultLocaleCode() {
		return defaultLocaleCode;
	}
	public void setDefaultLocaleCode(String defaultLocaleCode) {
		this.defaultLocaleCode = defaultLocaleCode;
	}
	public String getDefaultCurrencyCode() {
		return defaultCurrencyCode;
	}
	public void setDefaultCurrencyCode(String defaultCurrencyCode) {
		this.defaultCurrencyCode = defaultCurrencyCode;
	}

}
