package com.loski.collect.share.tender.util;

import java.util.Comparator;

import com.loski.collect.share.tender.entity.TenderData;

@SuppressWarnings("rawtypes")
public class ComparatorTender implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		TenderData data0=(TenderData)o1;
		TenderData data1=(TenderData)o2;
		return data0.getTenderPrice().compareTo(data1.getTenderPrice());
	}
}
