
public class ArticlePrio extends Article implements AvecPrio{
	private int prio;
	
	public ArticlePrio(String des, int q, double prix) {
		super(des, q, prix);
	}
	
	@SuppressWarnings("static-access")
	public int getPrio(){
		if (super.getQuantite()>=this.STOCK_MINIMAL) {
			prio=0;
			}//fin if
		else /*this.quantite<this.stock_minimal*/ {
			prio=(this.STOCK_MINIMAL-super.getQuantite());
			}
		return prio;
	}
}
