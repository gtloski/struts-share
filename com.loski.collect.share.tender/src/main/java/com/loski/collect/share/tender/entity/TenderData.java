package com.loski.collect.share.tender.entity;

public class TenderData implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4798083982432299761L;

	private String enterpriseName;
	
	private Double tenderPrice;

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public Double  getTenderPrice() {
		return tenderPrice;
	}

	public void setTenderPrice(Double tenderPrice) {
		this.tenderPrice = tenderPrice;
	}
}
