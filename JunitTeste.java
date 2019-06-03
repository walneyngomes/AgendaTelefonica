package Teste;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.edu.unifacisa.bd.AgendaTelefonicaFachada;
import br.edu.unifacisa.bd.Contato;

public class JunitTeste {
	AgendaTelefonicaFachada fachada = null;
	Contato contato=null;

	@Before
	public void criarAgenda() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo_persistencia");

		this.fachada = new AgendaTelefonicaFachada(factory);
	}
	@Before
	public void criarContato() {

		this.contato = new Contato();
	}


	@Test
	public void testObterTodosOsContatos(){
		
		contato.setCpf("069.098.989-090");
		contato.setNome("Walney");
		fachada.cadastrarContatosNaLista(this.contato);
		assertEquals(fachada.obterListaTodosContatos().size(),0);
		
		
	}
}
