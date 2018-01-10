package com.loski.collect.share.tender.util;

import java.util.List;

import com.loski.collect.share.tender.entity.TenderData;

public class AverageTender {

	public static double average (List<TenderData> list){
		double ave=0;        
        double sum=0;
        for(TenderData data : list){
        	sum+=data.getTenderPrice();
        }
         ave=sum/list.size();
         return ave;
   }
}
