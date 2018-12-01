public class Livre extends Article implements SpecifLivre
{
   protected int nbPages ;
   protected String numISBN ;
   public final int STOCK_MINIMAL = Article.STOCK_MINIMAL + (int)(Math.ceil(Article.STOCK_MINIMAL * 0.5));
//   protected int quantite;
   
   public int getNombrePages() { return nbPages ; }
   public String getNumeroISBN() { return numISBN ; }
   
   public Livre (String des, int q, double prix, int nbp, String isbn)
   {
   	   super (des, q, prix) ;
   	   nbPages = nbp ;
   	   numISBN = isbn ;
   	  // quantite=q;
   }
   
   public String toString()
   {
   	  return
	  	getDesignation()
		+ ", ISBN : " + getNumeroISBN()
	    + " (" + getNombrePages() + " pages)";
   }
}