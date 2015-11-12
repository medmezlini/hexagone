package hexagone;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EtatJeu extends JPanel {

	JLabel etatLabel;
	JLabel etatJeuLabel;
	JLabel gangnatLabel;

	public EtatJeu() {

		this.setPreferredSize(new Dimension(100, 112));
		gangnatLabel = new javax.swing.JLabel();
		etatLabel = new javax.swing.JLabel();
		etatJeuLabel = new javax.swing.JLabel();

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
																gangnatLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																etatJeuLabel,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																80,
																Short.MAX_VALUE)
														.addComponent(
																etatLabel,
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
												etatLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												etatJeuLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												gangnatLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(7, 7, 7)));

		// setPreferredSize(new Dimension(40, 40));
		etatLabel.setText("  etat de Jeu: ");
		etatJeuLabel.setText("  En cours  ");

	}

	public int  changeEtatJeu() {
		int nb0=0; 
		int nb1=0; 
		int nb2=0; 
		int nb3=0; 
		int nb4=0; 
		boolean termine=false; 
		
		if (Accueil.iteration >= 2) {
			for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
				for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
					if (Plateau.hextab[i][j] != null) {
						if(Plateau.hextab[i][j].getNumJoueur()==0) nb0++; 
						if(Plateau.hextab[i][j].getNumJoueur()==1) nb1++; 
						if(Plateau.hextab[i][j].getNumJoueur()==2) nb2++; 
						if(Plateau.hextab[i][j].getNumJoueur()==3) nb3++;
						if(Plateau.hextab[i][j].getNumJoueur()==4) nb4++;  
						
					}
				}
			}
		}

		if(nb0==0)etatJeuLabel.setText("  Terminé  ");
		else{
			gangnatLabel.setText("");
			etatJeuLabel.setText("  En cours  ");}
		if(nb1!=0&&nb2==0&&nb3==0&&nb4==0){etatJeuLabel.setText("  Terminé  "); termine=true;
		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (Plateau.hextab[i][j] != null) {
					Plateau.hextab[i][j].setNumJoueur(1);
					Plateau.hextab[i][j].setCouleur(0x1df307);
					
				}
			}
		}
		return 1; 
		}
		if(nb1==0&&nb2!=0&&nb3==0&&nb4==0){etatJeuLabel.setText("  Terminé  "); termine=true;
		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (Plateau.hextab[i][j] != null) {
					Plateau.hextab[i][j].setNumJoueur(2);
					Plateau.hextab[i][j].setCouleur(0x2d1fea);
					
				}
			}
		}
		return 2; 
		}
		if(nb1==0&&nb2==0&&nb3!=0&&nb4==0){etatJeuLabel.setText("  Terminé  "); termine=true;
		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (Plateau.hextab[i][j] != null) {
					Plateau.hextab[i][j].setNumJoueur(3);
					Plateau.hextab[i][j].setCouleur(0xef8f82);
					
				}
			}
		}

		return 3; 
		}
		if(nb1==0&&nb2==0&&nb3==0&&nb4!=0){etatJeuLabel.setText("  Terminé  "); 
		termine=true;
		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (Plateau.hextab[i][j] != null) {
					Plateau.hextab[i][j].setNumJoueur(4);
					Plateau.hextab[i][j].setCouleur(0x000000);
					
				}
			}
		}
		return 4; 
		}
		
		return -1; 
	
	}

}
