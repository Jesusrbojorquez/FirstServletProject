package roma.academy.model;

public class Ruolo {
	private int id;
	private String descrizione;
	private int stipendio;
	
	/**
	 * Constructor
	 */
	public Ruolo() {
		super();
	}

	/**
	 * @param id
	 * @param descrizione
	 * @param stipendio
	 */
	public Ruolo(int id, String descrizione, int stipendio) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.stipendio = stipendio;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the stipendio
	 */
	public int getStipendio() {
		return stipendio;
	}

	/**
	 * @param stipendio the stipendio to set
	 */
	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", descrizione=" + descrizione + ", stipendio=" + stipendio + "]";
	}
	
}
