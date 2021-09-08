package com.vencedorpiorfilme.repositories;

import java.util.ArrayList;
import java.util.List;


import com.vencedorpiorfilme.entidades.IntervaloPremios;
import com.vencedorpiorfilme.entidades.Max;
import com.vencedorpiorfilme.entidades.Min;
import com.vencedorpiorfilme.entidades.VencedorPiorFilme;

public class VencedorPiorFilmeCN {
	
	
	public IntervaloPremios findInterval(VencedorPiorFilmeRepository repo) {
		List<VencedorPiorFilme> lista = repo.findByOrderByProducersAscYearAsc();
		List<Min> intervalosList = new ArrayList<Min>();
		String producerAtual = "";
		Integer anoAtual = 0;
		Integer proximoAno = 0;
		Integer interval = 0;
		Integer intervalMin = 0;
		Integer intervalMax = 0;
		
        for(VencedorPiorFilme item : lista){
            if(item.getProducers().equals(producerAtual)) {
            	proximoAno = item.getYear();
            	interval = proximoAno - anoAtual;
            	
            	Min min = new Min();
            	min.setProducer(producerAtual);
            	min.setInterval(interval);
            	min.setPreviousWin(anoAtual);
            	min.setFollowingWin(proximoAno);
            	
            	intervalosList.add(min);
            	
            	anoAtual = proximoAno;
            	
            	if(intervalMin == 0 || intervalMin > interval) {
            		intervalMin = interval;
            	}
            	
            	if(intervalMax == 0 || intervalMax < interval) {
            		intervalMax = interval;
            	}
            }else {
            	producerAtual = item.getProducers();
            	anoAtual = item.getYear();
            }
        }
		
		return getInterval(intervalosList, intervalMin, intervalMax);
	}
	
	private static IntervaloPremios getInterval(List<Min> intervalosList, Integer intervalMin, Integer intervalMax) {
		List<Min> listaMin = new ArrayList<Min>();
		List<Max> listaMax = new ArrayList<Max>();
		IntervaloPremios intervalo = new IntervaloPremios();
		
		for(Min item : intervalosList) {
			if(item.getInterval() == intervalMin) {
				listaMin.add(item);
			}
			
			if(item.getInterval() == intervalMax) {
				Max max = new Max();
				max.setFollowingWin(item.getFollowingWin());
				max.setInterval(intervalMax);
				max.setPreviousWin(item.getPreviousWin());
				max.setProducer(item.getProducer());
				listaMax.add(max);
			}
		}
		
		intervalo.setMin(listaMin);
		intervalo.setMax(listaMax);
		
		return intervalo;
	}
	
}
