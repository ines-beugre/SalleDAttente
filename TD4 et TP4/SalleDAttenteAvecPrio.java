public class SalleDAttenteAvecPrio<TC> implements SalleDAttente<TC> {

	//declaration de variables
	private int prio; 
	private int maxprio; 
	private int capacite; 
	private int nbClient;
	private SalleDAttentePAPS<TC> [] tabSalleDAttente;
	
	//constructeur
@SuppressWarnings("unchecked")
	public SalleDAttenteAvecPrio (int cap, int maxprio){
		assert cap>0;
		this.capacite=cap;
		assert nbClient==0; //salle d'attente vide
		prio=0;
		this.maxprio=maxprio;
		tabSalleDAttente=new SalleDAttentePAPS[maxprio]; //tableau de type salle d'attente avec des priorit� max
		
		for (int i=0; i<maxprio; i++) {
			tabSalleDAttente[i]=new SalleDAttentePAPS<TC>(getCapacite());//salle d'attente dont la capacite est determin�e par passage en param�tre
		}//fin for
		
	}//fin constructeur
	
	public int getPrio(){
		return prio;
	}
	
	public int getMaxPrio(){
		return maxprio;
	}
	@Override
	public int getCapacite() {
		return this.capacite;
	}
	
	@Override
	public int getNbClients() {
		return this.nbClient;
	}
	
	@Override
	public boolean estVide() {
		int i=0;
		boolean estVide = true;
		while (i<maxprio){
			if(!tabSalleDAttente[i].estVide()){
				estVide = false;
				break;
			}
			i++;
		}
		return estVide;
	}

	@Override
	public boolean estPleine() {
		int i=0; //0<=i<=maxprio
		while(i<maxprio && tabSalleDAttente[i].estPleine()) {
			i++;
			return true;
		}
		return false;
	}

	@Override
	public TC getProchain() {						// Prochain objet � servir			
													// Precondition : salle non vide
		TC prochain=null;
		if (!estVide()) {
			int k=getMaxPrio()-1;
			while(k>=0 && (tabSalleDAttente[k].estVide()))
				k--;
			if (!(tabSalleDAttente[k].estVide())) {
				prochain=tabSalleDAttente[k].getProchain();
				}
		}

		return prochain;		
	}

	@Override
	public void sortir() {								// Sortie de la salle du prochain objet � servir
														//precondition: salle non vide
		if (!estVide()) {
			int k=getMaxPrio()-1;
			while(k>=0 && (tabSalleDAttente[k].estVide()))
				k--;
			if (!(tabSalleDAttente[k].estVide())) {
				tabSalleDAttente[k].sortir();
				nbClient--;
			}
		}
	}

	@Override
	public void entrer(TC o) {						// Entr�e dans la salle de l'objet o
		if(o instanceof AvecPrio){/*o est un element avec une priorit�*/
			int prio;
			
			if(((AvecPrio) o).getPrio() > (getMaxPrio()-1)){
				prio=getMaxPrio()-1;
			}
			else prio=((AvecPrio) o).getPrio();
			
			if (!(tabSalleDAttente[prio].estPleine())) {
				tabSalleDAttente[prio].entrer(o);
				nbClient++;
			}	
		}
		else{/*o n'est pas un element avec une priorit�*/
			int i=0;
			while (i<maxprio && (tabSalleDAttente[i].estPleine()))
				i++;
			if (!(tabSalleDAttente[i].estPleine())) {
				tabSalleDAttente[i].entrer(o);
				nbClient++;
			}
		}
	}
	
	public void reorganiser(){
		for (int prio=0; prio<this.getMaxPrio(); prio++) { 			//on parcours les diff�rentes salle d'attente du tableau de salle d'attente
			if(!tabSalleDAttente[prio].estPleine()){
				for(int j = 0; j < tabSalleDAttente[prio].size(); j++){ 	//on parcours les element de type AvecPrio qui sont pr�sents dans chaque salle d'attente
					TC tc = tabSalleDAttente[prio].get(j); 					//on recup�re l'element � la position j dans la salle d'attente i
					AvecPrio elementPrio = ((AvecPrio)tc);						//cast de TC en AvecPrio
					
					if(elementPrio.getPrio() != prio ) {       
						tabSalleDAttente[elementPrio.getPrio()].entrer(tc);		//on recup�re la priorit� de l'element et on l'ajoute dans le tableau correspondant � sa priorit�. add(tc) car le tableau contient des objets g�n�rique de type TC
						tabSalleDAttente[prio].remove(j); 					//l'element est enlev� de la salle 
																			//par mesure de precaution 

					}
				}
			}														//prio correspond � la priorit� actuelle lors du parcours du tableau	
		}
	}

}//fin programme
