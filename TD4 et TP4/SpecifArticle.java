public interface SpecifArticle
{
	// Désignation de l'article
	public String getDesignation() ;

	// Quantité en stock
	public int getQuantite() ;

	// Prix H.T.
	public double getPrixHT();

	// Taux de TVA pour cet article
	public double getTauxTVA() ;

	// Prix TTC = prix HT * Taux de TVA (1.196)
	public double getPrixTTC();

	// Augmenter le stock de la quantité q
	public void ajouter(int q);

	// Réduire le stock de la quantité q
	public void retirer(int q);
}
