public class TestPrioMinimal
{
		public static void main(String[] args)
		{
			LivrePrio bouquin = new LivrePrio("C stock 0", 0, 23.3, 123, "isbn") ;
			SalleDAttente<AvecPrio> salle =  new SalleDAttenteAvecPrio<AvecPrio>(20, 5) ;
			salle.entrer (new LivrePrio("A stock 5", 5, 23.3, 123, "isbn")) ;
			salle.entrer (new LivrePrio("B stock 5", 5, 23.3, 123, "isbn")) ;
			salle.entrer (bouquin) ;
			salle.entrer (new LivrePrio("D stock 7", 7, 23.3, 123, "isbn")) ;
			System.out.println ("Ajout A, B, C, D : nb. éléments = " + salle.getNbClients()) ;
			System.out.println (salle.getProchain().toString()) ;
			salle.sortir() ;
			System.out.println ("Sortir : il reste " + salle.getNbClients()) ;
			System.out.println (salle.getProchain().toString()) ;
			salle.sortir() ;
			System.out.println ("Sortir : il reste " + salle.getNbClients()) ;
			System.out.println (salle.getProchain().toString()) ;
			salle.sortir() ;
			System.out.println ("Sortir : il reste " + salle.getNbClients()) ;
			System.out.println (salle.getProchain().toString()) ;
			salle.sortir() ;
			salle.entrer(bouquin) ;
			salle.entrer (new LivrePrio("E stock 7", 5, 23.3, 123, "isbn")) ;
			salle.entrer (new LivrePrio("E stock 7", 5, 23.3, 123, "isbn")) ;
		}
	}
