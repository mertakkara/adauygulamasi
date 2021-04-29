package com.rationalstudio.ada.Models;

public class VagonlarItem{
	private String Ad;
	private int DoluKoltukAdet;
	private int Kapasite;

	public void setAd(String Ad){
		this.Ad = Ad;
	}

	public String getAd(){
		return Ad;
	}

	public void setDoluKoltukAdet(int DoluKoltukAdet){
		this.DoluKoltukAdet = DoluKoltukAdet;
	}

	public int getDoluKoltukAdet(){
		return DoluKoltukAdet;
	}

	public void setKapasite(int Kapasite){
		this.Kapasite = Kapasite;
	}

	public int getKapasite(){
		return Kapasite;
	}

	@Override
 	public String toString(){
		return 
			"VagonlarItem{" + 
			"Ad = '" + Ad + '\'' +
			",DoluKoltukAdet = '" + DoluKoltukAdet + '\'' +
			",Kapasite = '" + Kapasite + '\'' +
			"}";
		}
}
