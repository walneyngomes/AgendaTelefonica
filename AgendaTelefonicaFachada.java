package br.edu.unifacisa.bd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public class AgendaTelefonicaFachada {
	private static final boolean FAVORITAR = true;

	EntityManager manager;

	@Autowired
	public AgendaTelefonicaFachada(EntityManagerFactory factory) {
		try {
			if (manager == null) {
				this.manager = criarManager(factory);
			}
		} catch (Exception e) {
			/*
			 * This is a generic Exception handler which means it can handle all
			 * the exceptions. This will execute if the exception is not handled
			 * by previous catch blocks.
			 */
			System.err.println("Conexão negada. Verifique se o nome da máquina e a porta estão corretos e se o postmaster está aceitando conexões TCP/IP");
		}
	}
 
	private EntityManager criarManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	public void cadastrarContatosNaLista(Contato contato) {
		pessist(contato);

	}

	private void pessist(Object object) {
		manager.getTransaction().begin();
		manager.persist(object);
		manager.getTransaction().commit();
	}

	public void cadastrarContatosComTelefone(Contato contato, Telefone telefone, String operadora) {

		manager.getTransaction().begin();
		telefone.setTipoOperadora(obterOperadora(operadora));
		contato.getTelefones().add(telefone);
		this.cadastrarContatosNaLista(contato);
		pessist(telefone);

	}
	public void cadastrarContatoNoGrupo(Contato contato, Grupo grupo){
		contato.getGrupos().add(grupo);
		grupo.getContatos().add(contato);
		pessist(contato);
		pessist(grupo);
	}
	

	private OperadoraENUM obterOperadora(String tipo) {
		OperadoraENUM operadora = null;
		if ("oi".equals(tipo)) {
			operadora = operadora.OI;
		} else if ("claro".equals(tipo)) {
			operadora = operadora.CLARO;
		} else if ("vivo".equals(tipo)) {
			operadora = operadora.VIVO;
		}

		return operadora;

	}

	public void favoritarContato(Contato contato) {
		contato.setFavorito(FAVORITAR);
	}

	

	public List<Contato> obterListaTodosContatos() {
		System.out.println("OBTENDO A LISTA DE TODOS OS CONTATOS");
		System.err.println("carregando");
		String hql = "from br.edu.unifacisa.bd.Contato";
		Query query = manager.createQuery(hql);
		System.out.println("FEITO");

		return query.getResultList();

	}

	public void close() {
		getManager().close();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
