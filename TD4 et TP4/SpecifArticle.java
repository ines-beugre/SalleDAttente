public interface SpecifArticle
{
	// D�signation de l'article
	public String getDesignation() ;

	// Quantit� en stock
	public int getQuantite() ;

	// Prix H.T.
	public double getPrixHT();

	// Taux de TVA pour cet article
	public double getTauxTVA() ;

	// Prix TTC = prix HT * Taux de TVA (1.196)
	public double getPrixTTC();

	// Augmenter le stock de la quantit� q
	public void ajouter(int q);

	// R�duire le stock de la quantit� q
	public void retirer(int q);
}
