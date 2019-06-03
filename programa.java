package Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unifacisa.bd.AgendaTelefonicaFachada;
import br.edu.unifacisa.bd.Contato;
import br.edu.unifacisa.bd.OperadoraENUM;
import br.edu.unifacisa.bd.Telefone;

public class programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo_persistencia");

		AgendaTelefonicaFachada agenda = new AgendaTelefonicaFachada(factory);

		EntityManager manager = factory.createEntityManager();
		Contato contato = new Contato();
		Telefone telefone = new Telefone();

		OperadoraENUM emun = null;
		telefone.setTipoOperadora(emun.VIVO);

		manager.getTransaction().begin();
		manager.persist(contato);
		manager.persist(telefone);

		manager.getTransaction().commit();
		agenda.obterListaTodosContatos() ;

	}

}
