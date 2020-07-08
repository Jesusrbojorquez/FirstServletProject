package roma.academy.model;

import java.sql.Date;

public class Storico {
	private int id;
	private int idImpiegato;
	private int idRuolo;
	private int matricola;
	private Date dataInizio;
	private Date dataFine;
	/**
	 * 
	 */
	public Storico() {
		super();
	}
	/**
	 * @param id
	 * @param idImpiegato
	 * @param idRuolo
	 * @param matricola
	 * @param dataInizio
	 * @param dataFine
	 */
	public Storico(int id, int idImpiegato, int idRuolo, int matricola, Date dataInizio, Date dataFine) {
		super();
		this.id = id;
		this.idImpiegato = idImpiegato;
		this.idRuolo = idRuolo;
		this.matricola = matricola;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
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
	 * @return the idImpiegato
	 */
	public int getIdImpiegato() {
		return idImpiegato;
	}
	/**
	 * @param idImpiegato the idImpiegato to set
	 */
	public void setIdImpiegato(int idImpiegato) {
		this.idImpiegato = idImpiegato;
	}
	/**
	 * @return the idRuolo
	 */
	public int getIdRuolo() {
		return idRuolo;
	}
	/**
	 * @param idRuolo the idRuolo to set
	 */
	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}
	/**
	 * @return the matricola
	 */
	public int getMatricola() {
		return matricola;
	}
	/**
	 * @param matricola the matricola to set
	 */
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	/**
	 * @return the dataInizio
	 */
	public Date getDataInizio() {
		return dataInizio;
	}
	/**
	 * @param dataInizio the dataInizio to set
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	/**
	 * @return the dataFine
	 */
	public Date getDataFine() {
		return dataFine;
	}
	/**
	 * @param dataFine the dataFine to set
	 */
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	
	
	@Override
	public String toString() {
		return "Storico [id=" + id + ", idImpiegato=" + idImpiegato + ", idRuolo=" + idRuolo + ", matricola="
				+ matricola + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + "]";
	}
	
}
