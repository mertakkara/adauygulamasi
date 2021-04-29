package com.rationalstudio.ada.Models;

import org.json.JSONObject;

public class Response  {
	private Tren Tren;
	private int RezervasyonYapilacakKisiSayisi;
	private boolean KisilerFarkliVagonlaraYerlestirilebilir;

	public void setTren(Tren Tren){
		this.Tren = Tren;
	}

	public Tren getTren(){
		return Tren;
	}

	public void setRezervasyonYapilacakKisiSayisi(int RezervasyonYapilacakKisiSayisi){
		this.RezervasyonYapilacakKisiSayisi = RezervasyonYapilacakKisiSayisi;
	}

	public int getRezervasyonYapilacakKisiSayisi(){
		return RezervasyonYapilacakKisiSayisi;
	}

	public void setKisilerFarkliVagonlaraYerlestirilebilir(boolean KisilerFarkliVagonlaraYerlestirilebilir){
		this.KisilerFarkliVagonlaraYerlestirilebilir = KisilerFarkliVagonlaraYerlestirilebilir;
	}

	public boolean isKisilerFarkliVagonlaraYerlestirilebilir(){
		return KisilerFarkliVagonlaraYerlestirilebilir;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"Tren = '" + Tren + '\'' +
			",RezervasyonYapilacakKisiSayisi = '" + RezervasyonYapilacakKisiSayisi + '\'' +
			",KisilerFarkliVagonlaraYerlestirilebilir = '" + KisilerFarkliVagonlaraYerlestirilebilir + '\'' +
			"}";
		}
}
