import java.util.LinkedList;

@SuppressWarnings({ "serial"})
public class SalleDAttentePAPS<TC> extends LinkedList<TC> implements SalleDAttente<TC>{
	private int capacite; 
	private int nbClient;
	
	//constructeur
	public SalleDAttentePAPS (int capacite){
		super();
		this.capacite=capacite; 
		//assert this.capacite==capacite;
		assert capacite>0;
		nbClient=0;
		
	}//fin constructeur
	
	@Override
	public int getCapacite() {						// Nombre maximum de objets				
		// TODO Auto-generated method stub
		return this.capacite;
	}

	@Override
	public int getNbClients() {			// Nombre de objets dans la salle
		// TODO Auto-generated method stub
		return this.size();
	}

	@Override
	public boolean estVide() {					// Salle est vide ?
		// TODO Auto-generated method stub
		return this.isEmpty();
	}

	@Override
	public boolean estPleine() {				//Salle est pleine ?
		// TODO Auto-generated method stub
		return getNbClients()==capacite;
	}

	@Override
	public TC getProchain() {					// Prochain objet à servir	
		// TODO Auto-generated method stub		// Precondition : salle non vide
	  	TC prochain = null; 
	  	
	  	if (!estVide()) {
			if(this.getFirst() instanceof AvecPrio){
				int prio = ((AvecPrio)this.get(0)).getPrio();
				int indexFirstPrio = 0;
				for(int i = 0; i< getNbClients(); i++){
					if(((AvecPrio)this.get(i)).getPrio() > prio){
						prio = ((AvecPrio)this.get(i)).getPrio();
						indexFirstPrio = i;
					}
				}
				prochain = this.get(indexFirstPrio);
			}
			else{
				prochain = this.getFirst();
			}
		}
	  	return prochain;
	}

	@Override
	public void sortir() {						//Sortie de la salle du prochain objet à servir
		// TODO Auto-generated method stub		//precondition: salle non vide
		if (!estVide()) {
			if(this.getFirst() instanceof AvecPrio){
				int prio = ((AvecPrio)this.get(0)).getPrio();
				int indexFirstPrio = 0;
				for(int i = 0; i< getNbClients(); i++){
					if(((AvecPrio)this.get(i)).getPrio() > prio){
						prio = ((AvecPrio)this.get(i)).getPrio();
						indexFirstPrio = i;
					}
				}
				this.remove(indexFirstPrio);
			}
			else{
				this.removeFirst();
			}
			nbClient--;
		}
	}

	@Override
	public void entrer(TC o) {				// Entrée dans la salle du objet o
		// TODO Auto-generated method stub
		if(!estPleine()) {
			
			this.addLast (o);
			nbClient++;}
	}

	
}//fin programme