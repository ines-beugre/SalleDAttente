import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SalleDAttenteAvecPrioTest {
		
		//variable de type salle d'attente avec prio
		SalleDAttente<AvecPrio> salle;
		
		SalleDAttentePAPS<AvecPrio> salle1;
		
		SalleDAttenteAvecPrio<Article> file ;
		
		SalleDAttentePAPS<Article> file1;
		
	@Before
	
	public void setUp() throws Exception {
		//question 7
		salle = new SalleDAttenteAvecPrio<AvecPrio>(5,3);
		
		//question 9
		salle1=new SalleDAttentePAPS<AvecPrio>(5);
		
		//question 10
		 file = new SalleDAttenteAvecPrio<Article>(2, 2) ;
		 
		 file1 = new SalleDAttentePAPS<Article>(4);
	
	}
		
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrioMinimal() {
		
		LivrePrio bouquin = new LivrePrio("C stock 0", 0, 23.3, 123, "isbn") ;
		
	
		//entrée des livres
		salle.entrer (new LivrePrio("A stock 5", 5, 23.3, 123, "isbn")) ;
		salle.entrer (new LivrePrio("B stock 5", 5, 23.3, 123, "isbn")) ;
		salle.entrer (bouquin) ;
		salle.entrer (new LivrePrio("D stock 7", 7, 23.3, 123, "isbn")) ;
		
		//verification après l'entrée des 4 clients
		assertEquals("La salle doit avoir 4 clients", 4, salle.getNbClients());
		
		//sortie des articles
		salle.sortir(); // le client est celui qui sort car il a une priorité égale à 8
		
		//verification du nombre de clients après la sortie
		assertEquals("La salle doit avoir 3 clients", 3, salle.getNbClients());
		
		//prochain client à sortir
		salle.getProchain();
		
		//vérification du prochain client à sortir
		assertEquals("Le prochain client à sortir est A", "A stock 5", ((Article)salle.getProchain()).getDesignation());
		
		//test sur la salle1
		//entrée des livres dans la salle1
		
		salle1.entrer (new LivrePrio("A stock 5", 5, 23.3, 123, "isbn")) ;
		salle1.entrer (new LivrePrio("B stock 5", 5, 23.3, 123, "isbn")) ;
		salle1.entrer (bouquin) ;
		salle1.entrer (new LivrePrio("D stock 7", 7, 23.3, 123, "isbn")) ;
		
		//verification après l'entrée des 4 clients
		assertEquals("La salle doit avoir 4 clients", 4, salle1.getNbClients()); // la salle1 contient effectivement 4 clients
		
		//prochain client à sortir 
		salle1.getProchain();
		
		//test avec le type SalleDAttentePAPS<AvecPrio>(5); ce test ne fonctionne pas car il gère aussi la priorité comme dans le cas SalleDAttente<AvecPrio> salle;
		assertEquals("Le prochain client à sortir est A", "A stock 5", ((Article)salle1.getProchain()).getDesignation()); // le prochain élément à sortir est le C, car il a la priorité la plus grande

	}

	@Test
	public void testPrioInteractif() {
		
		//creation de 3 articles
		Article wax= new Article ("E stock 3", 4, 30  ); 
		Article addis=new Article ("F stock 2", 3, 20);
		Article binta= new Article ("G stock 2", 2, 10);
		
		//ajout des 3 articles dans la file
		file.entrer(wax);
		file.entrer(addis);
		file.entrer(binta);
		
		//verification de l'ajout des 3 éléments dans la file
		assertTrue("3 elements dans la file", file.getNbClients()==3);
		
		//le prochain élément à sortir dans la file
		file.getProchain();
		assertEquals("Le prochain client à sortir est la G", "G stock 2", ((Article)file.getProchain()).getDesignation()); //test ok 

		//ajout des 3 articles dans la file1
		file1.entrer(wax);
		file1.entrer(addis);
		file1.entrer(binta);
		
		//verification de l'ajout des 3 éléments dans la file1
		assertTrue("3 elements dans la file1", file1.getNbClients()==3);
		
		//le prochain élément à sortir dans la file1
		file1.getProchain();
		//assertEquals("Le prochain client à sortir est la G", "G stock 2", ((Article)file1.getProchain()).getDesignation()); //test ok car dans de cas, puisque les priorités ne sont pas gérées, c'est le premier entré qui sort, soit le E
		assertEquals("Le prochain client à sortir est la E", "E stock 3", ((Article)file1.getProchain()).getDesignation()); //test ok 

	}
}//fin programme
