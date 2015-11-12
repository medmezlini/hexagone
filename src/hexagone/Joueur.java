package hexagone;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Joueur extends JPanel {

	// chaque joueur est caracterise par son score, son psoeudo, sa couleur

	private int score = 0;
	private int actif = 0;
	private int perdu = 0;
	private int num = 0; // le numero du joueur dans le jeu [0,1,2,3]
	private String psoeudo = "";
	private int couleurs[] = { 0x1df307, 0x2d1fea, 0xef8f82, 0x000000 };
	private int couleur = 0xeeee;

	JLabel nomLabel;
	JLabel scoreLabel;
	JLabel coleurLabel;

	public Joueur() {

		this.setPreferredSize(new Dimension(100, 112));
		coleurLabel = new javax.swing.JLabel();
		nomLabel = new javax.swing.JLabel();
		scoreLabel = new javax.swing.JLabel();

		javax.swing.GroupLayout thisLayout = new javax.swing.GroupLayout(this);
		this.setLayout(thisLayout);
		thisLayout
				.setHorizontalGroup(thisLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								thisLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												thisLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																coleurLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																scoreLabel,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																80,
																Short.MAX_VALUE)
														.addComponent(
																nomLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																80,
																Short.MAX_VALUE))
										.addContainerGap()));
		thisLayout
				.setVerticalGroup(thisLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								thisLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												nomLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												scoreLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												coleurLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(7, 7, 7)));

		// setPreferredSize(new Dimension(40, 40));
		nomLabel.setText("Nom: " + psoeudo);
		scoreLabel.setText("Score: " + score);
		// coleurLabel.setText("Couleur: ...");

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		
		this.score = score;
		this.updateScore();
		//this.scoreLabel.setText("Score: " + score);
		
	}

	// changer récupérer la valeur du champ psoeudo

	public String getPsoeudo() {
		return psoeudo;
	}

	
	
	public void setPsoeudo(String psoeudo) {
		this.psoeudo = psoeudo;
		this.nomLabel.setText("Nom: " + psoeudo);
	}

	// changer récupérer la valeur du champ num

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;

	}
	//le joueur perdu ou non 
	// changer récupérer la valeur du champ num

	public int getPerd() {
		return this.perdu;
	}

	public void setPerd(int perdu) {
		this.perdu = perdu;

	}
//le joueur actif 
	public int getActif() {
		return this.actif;
	}

	public void setActif(int actif) {
		this.actif = actif ;

	}
	
	// mise a joure le score  le score 
	public void updateScore(){
		
		int scor=0; 
		boolean jeuTermine = true; 
		
		boolean faireTerminerJeu=true; 
		
		
			for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {

				for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
					if (Plateau.hextab[i][j]!=null){
					if (Plateau.hextab[i][j].getNumJoueur()==this.num){
						scor ++; 
					
					}
					
					if(Plateau.hextab[i][j].getNumJoueur()!=this.num&&Plateau.hextab[i][j].getNumJoueur()!=0&&this.num!=0){
						faireTerminerJeu=false;
						
					}
					
					if(Plateau.hextab[i][j].getNumJoueur()==0)
					{
						jeuTermine=false;
								
					}
					} 
					
					
					
					//hexOrdi[i][j] = null;

				}
				
				
				
					
			}
			
			
			
			if (jeuTermine==true)Accueil.jeuTermine=true; 
	
				
				System.out.println("");//************************************");
		this.score=scor*5;
				this.scoreLabel.setText("Score: " + scor*5);
				
	}
	

	// changer récupérer la valeur du champ couleur

	public int getCouleur() {
		return couleurs[this.num-1];
	}

}
