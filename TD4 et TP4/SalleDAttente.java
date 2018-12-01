public interface SalleDAttente<TC>
{
	public int getCapacite() ;				// Capacité de la salle
	public int getNbClients() ;	// Nombre de objets dans la salle
	public boolean estVide() ;			// Salle est vide ?
	public boolean estPleine() ;		// Salle est pleine ?
    public TC getProchain() ;			// Prochain objet à servir
    									// Precondition : salle non vide
    public void sortir() ;				// Sortie de la salle du prochain objet à servir
    									//precondition: salle non vide
    public void entrer(TC o) ;		// Entrée dans la salle du objet o
	
}
