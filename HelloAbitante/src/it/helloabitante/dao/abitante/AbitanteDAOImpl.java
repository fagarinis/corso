package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		List<Abitante> resultList = new ArrayList<>();
		for (Abitante abitante : DB_Mock.LISTA_ABITANTI) {
			resultList.add(abitante);
		}
		return resultList;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		if (id == null || id < 1) {
			return null;
		}

		for (Abitante abitante : DB_Mock.LISTA_ABITANTI) {
			if (abitante.getIdAbitante() == id) {
				return abitante;
			}
		}
		return null;
	}

	@Override
	public int update(Abitante input) throws Exception {
		if (input == null || input.getIdAbitante() == null || input.getIdAbitante() < 1) {
			return 0;
		}

		for (int i = 0; i < DB_Mock.LISTA_ABITANTI.size(); i++) {
			if (DB_Mock.LISTA_ABITANTI.get(i).getIdAbitante() == input.getIdAbitante()) {
				DB_Mock.LISTA_ABITANTI.set(i, input);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		if (input == null) {
			return 0;
		}
		input.setIdAbitante(DB_Mock.nextIdAvailable++);
		DB_Mock.LISTA_ABITANTI.add(input);
		return 1;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		if (input == null || input.getIdAbitante() == null || input.getIdAbitante() < 1) {
			return 0;
		}

		for (int i = 0; i < DB_Mock.LISTA_ABITANTI.size(); i++) {
			if (DB_Mock.LISTA_ABITANTI.get(i).getIdAbitante() == input.getIdAbitante()) {
				DB_Mock.LISTA_ABITANTI.remove(i);
				return 1;
			}
		}
		return 0;
	}

}
