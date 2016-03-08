package dbProsjekt;

public class Ovelse {
	private String navn;
	private String beskrivelse;
	
	private String maal;
	private String maallogg;
	
	private int belastning;
	private int repitisjoner;
	private int sett;
	
	private int lengde;
	
	public Ovelse(String navn, String beskrivelse){
		this.setNavn(navn);
		this.setBeskrivelse(beskrivelse);
	}

	
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public String getMaal() {
		return maal;
	}

	public void setMaal(String maal) {
		this.maal = maal;
	}

	public String getMaallogg() {
		return maallogg;
	}

	public void setMaallogg(String maallogg) {
		this.maallogg = maallogg;
	}



	public int getBelastning() {
		return belastning;
	}



	public void setBelastning(int belastning) {
		this.belastning = belastning;
	}



	public int getSett() {
		return sett;
	}



	public void setSett(int sett) {
		this.sett = sett;
	}



	public int getRepitisjoner() {
		return repitisjoner;
	}



	public void setRepitisjoner(int repitisjoner) {
		this.repitisjoner = repitisjoner;
	}



	public int getLengde() {
		return lengde;
	}



	public void setLengde(int lengde) {
		this.lengde = lengde;
	}
	
}
