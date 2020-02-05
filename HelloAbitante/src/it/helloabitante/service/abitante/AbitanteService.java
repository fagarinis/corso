package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) ;
	
	public List<Abitante> elencaTutti() throws Exception;
	public Abitante caricaSingolo(Long id) throws Exception;
	public int aggiorna(Abitante abitanteDaAggiornare) throws Exception;
	public int inserisciNuovo(Abitante abitanteDaInserire) throws Exception;
	public int cancella(Abitante abitanteDaCancellare) throws Exception;
}
