
public class LivrePrio extends Livre implements AvecPrio {
	
	public LivrePrio(String des, int q, double prix, int nbp, String isbn) {
		super(des, q, prix, nbp, isbn);
		
	}
	
	public int getPrio(){
		   return super.getQuantite()>=super.STOCK_MINIMAL? 0 : super.STOCK_MINIMAL - super.getQuantite();
	   }

}
