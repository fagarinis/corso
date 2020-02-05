package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	public List<Abitante> elencaTutti() throws Exception {
		return abitanteDAO.list();
	}

	public Abitante caricaSingolo(Long id) throws Exception {
		return abitanteDAO.get(id);
	}

	public int aggiorna(Abitante abitanteDaAggiornare) throws Exception {
		return abitanteDAO.update(abitanteDaAggiornare);
	}

	public int inserisciNuovo(Abitante abitanteDaInserire) throws Exception {
		return abitanteDAO.insert(abitanteDaInserire);
	}

	public int cancella(Abitante abitanteDaCancellare) throws Exception {
		return abitanteDAO.delete(abitanteDaCancellare);
	}
	
	

}
