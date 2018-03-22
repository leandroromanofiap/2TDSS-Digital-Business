package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.JogadorDAO;
import br.com.fiap.jpa.entity.Jogador;

public class JogadorDAOImpl extends GenericDAOImpl<Jogador, Integer> implements JogadorDAO {

	public JogadorDAOImpl(EntityManager em) {
		super(em);
	}

}
