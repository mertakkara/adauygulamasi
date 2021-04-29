package com.rationalstudio.ada.Models;

import java.util.List;

public class Tren{
	private String Ad;
	private List<VagonlarItem> Vagonlar;

	public void setAd(String Ad){
		this.Ad = Ad;
	}

	public String getAd(){
		return Ad;
	}

	public void setVagonlar(List<VagonlarItem> Vagonlar){
		this.Vagonlar = Vagonlar;
	}

	public List<VagonlarItem> getVagonlar(){
		return Vagonlar;
	}

	@Override
 	public String toString(){
		return 
			"Tren{" + 
			"Ad = '" + Ad + '\'' +
			",Vagonlar = '" + Vagonlar + '\'' +
			"}";
		}
}