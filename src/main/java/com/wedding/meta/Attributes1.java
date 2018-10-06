package com.wedding.meta;

public class Attributes1 {
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMasterCatalogId() {
		return masterCatalogId;
	}
	public void setMasterCatalogId(int masterCatalogId) {
		this.masterCatalogId = masterCatalogId;
	}
	public int getTenantId() {
		return tenantId;
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
	String name;
	int masterCatalogId;
	int tenantId;
	String defaultLocaleCode;
	String defaultCurrencyCode;
	

}
