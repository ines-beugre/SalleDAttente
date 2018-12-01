public interface SalleDAttente<TC>
{
	public int getCapacite() ;				// Capacit� de la salle
	public int getNbClients() ;	// Nombre de objets dans la salle
	public boolean estVide() ;			// Salle est vide ?
	public boolean estPleine() ;		// Salle est pleine ?
    public TC getProchain() ;			// Prochain objet � servir
    									// Precondition : salle non vide
    public void sortir() ;				// Sortie de la salle du prochain objet � servir
    									//precondition: salle non vide
    public void entrer(TC o) ;		// Entr�e dans la salle du objet o
	
}
