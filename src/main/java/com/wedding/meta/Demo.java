package com.wedding.meta;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="demo")
public class Demo {
	String isDevTenant;
	public String getIsDevTenant() {
		return isDevTenant;
	}
	public void setIsDevTenant(String isDevTenant) {
		this.isDevTenant = isDevTenant;
	}



List<Attribute> sites;
  public List<Attribute> getSites() {
	return sites;
}
public void setSites(List<Attribute> sites) {
	this.sites = sites;
}


List<Attribute2> masterCatalogs;

public List<Attribute2> getMasterCatalogs() {
	return masterCatalogs;
}
public String getDomain() {
	return domain;
}
public void setDomain(String domain) {
	this.domain = domain;
}
public int getOmsMerchantId() {
	return omsMerchantId;
}
public void setOmsMerchantId(int omsMerchantId) {
	this.omsMerchantId = omsMerchantId;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void setMasterCatalogs(List<Attribute2> masterCatalogs) {
	this.masterCatalogs = masterCatalogs;
}

String domain;
int omsMerchantId;
String name;
}
