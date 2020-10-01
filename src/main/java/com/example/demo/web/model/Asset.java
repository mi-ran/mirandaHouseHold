package com.example.demo.web.model;

public class Asset {
	int assetId;
	String assetName;
	int account;
	
	public void setAssetId(int assetId) {this.assetId = assetId;}
	public void setAssetName(String assetName) {this.assetName = assetName;}
	public void setAccount(int account) {this.account = account;}
	
	public int getAssetId() {return assetId;}
	public String getAssetName() {return assetName;}
	public int getAccount() {return account;}
}
