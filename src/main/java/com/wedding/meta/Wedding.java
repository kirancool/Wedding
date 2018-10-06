package com.wedding.meta;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stockdata")
public class Wedding {
	String company;
	String stock_symbol;
	String date;
	float stock_price_open;
	float stock_price_high;
	public String getCompany() {
		return company;
	}
	public void setCompnay(String company) {
		this.company = company;
	}
	public String getStock_symbol() {
		return stock_symbol;
	}
	public void setStock_symbol(String stock_symbol) {
		this.stock_symbol = stock_symbol;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getStock_price_open() {
		return stock_price_open;
	}
	public void setStock_price_open(float stock_price_open) {
		this.stock_price_open = stock_price_open;
	}
	public float getStock_price_high() {
		return stock_price_high;
	}
	public void setStock_price_high(float stock_price_high) {
		this.stock_price_high = stock_price_high;
	}
	public float getStock_price_low() {
		return stock_price_low;
	}
	public void setStock_price_low(float stock_price_low) {
		this.stock_price_low = stock_price_low;
	}
	public float getStock_price_close() {
		return stock_price_close;
	}
	public void setStock_price_close(float stock_price_close) {
		this.stock_price_close = stock_price_close;
	}
	public int getStock_volume() {
		return stock_volume;
	}
	public void setStock_volume(int stock_volume) {
		this.stock_volume = stock_volume;
	}
	public float getStock_price_adj_close() {
		return stock_price_adj_close;
	}
	public void setStock_price_adj_close(float stock_price_adj_close) {
		this.stock_price_adj_close = stock_price_adj_close;
	}
	float stock_price_low;
	float stock_price_close;
	int stock_volume;
	float stock_price_adj_close;

}


