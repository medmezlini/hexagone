package hexagone;

import java.awt.*;
import java.util.Random;

import javax.swing.*;


public class Plateau extends JPanel {

	private int iteration = 0; // pour avoir qu'elle notre etat (initalisation
								// du plteau, initialisation du jeu, jeu )

	public static Hexagone[][] hextab = new Hexagone[900][900];//
	//public static Hexagone[][] hexOrdi = new Hexagone[900][900];//tableau de case de lor
	public Graphics2D pl2d;

	private static final long serialVersionUID = 1L;
	private final int largeur = 800;
	private final int haut = 550;
	private int size = 15;

	private Font font = new Font("Arial", Font.BOLD, 18);
	FontMetrics metrics;

	public Plateau() {
		setPreferredSize(new Dimension(largeur, haut));
		
		// a refaire 

		if (Accueil.iteration == 0) {
			for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {

				for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {

					hextab[i][j] = null;
					//hexOrdi[i][j] = null;

				}
			}
		}

	}

	public int getHexLength() {
		return hextab.length;
	}

	public void paintComponent(Graphics g) {
		this.pl2d = (Graphics2D) g;
		Point origin = new Point(largeur / 2, haut / 2);

		pl2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_MITER));

		metrics = g.getFontMetrics();

		
		// a refaire 
		if (Accueil.iteration == 1){// pour eliminer la grille du plateau
									// principale
			
			//Accueil.longJeu * 2 - 1  
			GridHexagone(pl2d, origin, Accueil.longJeu * 2 - 1, this.size, 8);
			initialiserPointDdepart();
			Accueil.iteration++;
			
			}
	}

	private void GridHexagone(Graphics g, Point origin, int size, int radius,int padding) {
		double angle30 = Math.toRadians(30);
		int milieu = size / 2;
		//padding espace entre les exagones 
		double y = Math.sin(angle30) * (radius + padding);
		double x = Math.cos(angle30) * (radius + padding);

		for (int row = 0; row < size; row++) {
			int cols = size - java.lang.Math.abs(row - milieu);

			for (int col = 0; col < cols; col++) {

				dessinerHexagone(g, //
						(int) (origin.x + x * (col * 2 + 1 - cols)), //
						(int) (origin.y + y * (row - milieu) * 3), //
						radius, col, row);
			}
		}
	}

	private void dessinerHexagone(Graphics g, int x, int y, int r, int col,	int row) {
		Graphics2D pl2d = (Graphics2D) g;

		Hexagone hexagon = new Hexagone(x, y, r);
		//
		

		if (Accueil.iteration == 1) {
			Accueil.nbHexagone++;

			// hextab[row][col].x=x;
			// hextab[row][col].y=y;
			hextab[row][col] = hexagon;
			hextab[row][col].setCouleur(0xeaf111);
			// hextab[row][col].setNumJoueur(-1);
		} else
			hexagon.draw(pl2d, x, y, 0, 0xeaf111, true);
			hexagon.draw(pl2d, x, y, 5, 0xf111ee, false);

	}

	// initialisation des point de depart 
	
	
	public void initialiserPointDdepart(){

		
		///0x1df307, 0x2d1fea, 0xef8f82,
		if(Accueil.nbJoueur==1){
			hextab[0][0].setCouleur(0x1df307);
			hextab[0][0].setNumJoueur(1);

			hextab[Accueil.longJeu * 2 - 2][0].setCouleur(0x1df307);
			hextab[Accueil.longJeu * 2 - 2][0].setNumJoueur(1);
			
			this.caseOrdiIter1();
			this.caseOrdiIter1();
		}
		else if(Accueil.nbJoueur==2){
			hextab[0][0].setCouleur(0x1df307);
			hextab[0][0].setNumJoueur(1);
			hextab[Accueil.longJeu * 2 - 2][0].setCouleur(0x1df307);
			hextab[Accueil.longJeu * 2 - 2][0].setNumJoueur(1);
			
			
			hextab[Accueil.longJeu-1][0].setCouleur(0x2d1fea);
			hextab[Accueil.longJeu-1][0].setNumJoueur(2);
			hextab[Accueil.longJeu-1][Accueil.longJeu * 2 - 2].setCouleur(0x2d1fea);
			hextab[Accueil.longJeu-1][Accueil.longJeu * 2 - 2].setNumJoueur(2);
			
			
			
		}
		else {
			hextab[0][0].setCouleur(0x1df307);
			hextab[0][0].setNumJoueur(1);
			hextab[Accueil.longJeu * 2 - 2][0].setCouleur(0x1df307);
			hextab[Accueil.longJeu * 2 - 2][0].setNumJoueur(1);
			
			
			hextab[Accueil.longJeu-1][0].setCouleur(0x2d1fea);
			hextab[Accueil.longJeu-1][0].setNumJoueur(2);
			hextab[Accueil.longJeu-1][Accueil.longJeu * 2 - 2].setCouleur(0x2d1fea);
			hextab[Accueil.longJeu-1][Accueil.longJeu * 2 - 2].setNumJoueur(2);
			
			
			hextab[0][Accueil.longJeu-1].setCouleur(0xef8f82);
			hextab[0][Accueil.longJeu-1].setNumJoueur(3);
			hextab[Accueil.longJeu * 2 - 2][Accueil.longJeu-1].setCouleur(0xef8f82);
			hextab[Accueil.longJeu * 2 - 2][Accueil.longJeu-1].setNumJoueur(3);
			
			this.caseOrdiIter1();
			this.caseOrdiIter1();
		
			
			
		}
		
		
	}
	
	
	
	public double getSizeHex() {
		return (double) this.size;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	// fonctionnel
	// cette fonction rendre (row, col) de la matrice qui contient le point le
	// plus proche du click souris
	
	public Point dinstanceMinimale(int x, int y) {

		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {

			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (hextab[i][j] != null) {
					if (Math.sqrt((x - hextab[i][j].getPointCentre().getX())
							* (x - hextab[i][j].getPointCentre().getX())
							+ (y - hextab[i][j].getPointCentre().getY())
							* (y - hextab[i][j].getPointCentre().getY())) <= getSizeHex()) {

						Hexagone hexagon = new Hexagone(x, y, 15);
						return new Point(i, j);
					}
				}

			}
		}

		return new Point(-1, -1);
	}

	// pour vérifier le deplacement est possible ou non
	public boolean exist(int i, int j) {
		return true;
	}

	// pour verifier la possibilete de clonage ou pas
	public boolean clonage(Point prevPoint, Point newPoint) {

		
		if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() ) 	return true;
		if (newPoint.getX() == prevPoint.getX()	&& newPoint.getY() == prevPoint.getY() - 1)		return true;
		if (newPoint.getX() == prevPoint.getX()	&& newPoint.getY() == prevPoint.getY() + 1) 	return true;
		if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY())		return true;
		
		
		
		if(newPoint.getX()>Accueil.longJeu){//dans le cas où  le joueur clique sur une case de la partie basse 
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() -1)	return true;
			
		}
		else if(newPoint.getX()<Accueil.longJeu-2){//la partie haute 
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			
		}
		else if(newPoint.getX()==Accueil.longJeu-2){//oki
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;}
		
		else if(newPoint.getX()==Accueil.longJeu-1){//oki

			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
		}
		else if(newPoint.getX()==Accueil.longJeu){//

			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY()- 1)	return true;
		}

		return false;
	}

	// pour faire le saut
	public boolean saut(Point prevPoint, Point newPoint) {
		
		
		//point commun entre partie basse et haute 
		if (newPoint.getX() == prevPoint.getX()		&& newPoint.getY() == prevPoint.getY() - 2)	return true;
		if (newPoint.getX() == prevPoint.getX()		&& newPoint.getY() == prevPoint.getY() + 2)	return true;
		if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY()	  )	return true;
		if (newPoint.getX() == prevPoint.getX() + 2	&& newPoint.getY() == prevPoint.getY()	  )	return true;
		
		
		
		
		
		
		
		if(newPoint.getX()>Accueil.longJeu){//dans le cas où  le joueur clique sur une case de la partie basse
			

			if (newPoint.getX() == prevPoint.getX() + 2	&& newPoint.getY() == prevPoint.getY() - 2)	return true;//oki
			
			if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() + 2)	return true;//oki
			
			if (newPoint.getX() == prevPoint.getX() + 2	&& newPoint.getY() == prevPoint.getY() - 1)	return true;
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() - 2)	return true;
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 2)	return true;			
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;
			if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 2)	return true;
				
			}
		
		else if (newPoint.getX()<Accueil.longJeu-2){
			

			if (newPoint.getX() == prevPoint.getX() + 2	&& newPoint.getY() == prevPoint.getY() + 2)	return true;
			if (newPoint.getX() == prevPoint.getX() + 2	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;			
			if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 2)	return true;
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 2)	return true;
			if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
			if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() - 1)	return true;
			if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() - 2)	return true;
			
			
			
			}
			else if (newPoint.getX()==Accueil.longJeu-2){//oki
				
				if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 2)	return true;//oki			
				if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;//oki	
				
				if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 2)	return true;//oki
				if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;//oki
				
				if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() -1 )	return true;//oki
				if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() +1)	return true;//oki
				
				if (newPoint.getX() == prevPoint.getX() +2	&& newPoint.getY() == prevPoint.getY() + 1)	return true;//oki
				if (newPoint.getX() == prevPoint.getX() +2	&& newPoint.getY() == prevPoint.getY() + 2)	return true;//oki
				
			}		
			else if (newPoint.getX()==Accueil.longJeu-1){//oki 			

				if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 2)	return true;			
				if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;				
				if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 2)	return true;
				if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;
				if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() +1 )	return true;//oki
				if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() +2)	return true;//oki
				if (newPoint.getX() == prevPoint.getX() +2	&& newPoint.getY() == prevPoint.getY() + 1)	return true;//oki
				if (newPoint.getX() == prevPoint.getX() +2	&& newPoint.getY() == prevPoint.getY() + 2)	return true;//oki
				
				
			
			}		
			else if (newPoint.getX()==Accueil.longJeu){
				

				if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() + 2)	return true;//oki			
				if (newPoint.getX() == prevPoint.getX() - 1	&& newPoint.getY() == prevPoint.getY() - 1)	return true;//oki
				
				if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() + 1)	return true;
				if (newPoint.getX() == prevPoint.getX() + 1	&& newPoint.getY() == prevPoint.getY() - 2)	return true;//oki
				
				if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() +1 )	return true;//oki
				if (newPoint.getX() == prevPoint.getX() - 2	&& newPoint.getY() == prevPoint.getY() +2)	return true;//oki
				
				if (newPoint.getX() == prevPoint.getX() +2	&& newPoint.getY() == prevPoint.getY() -1)	return true;//oki
				if (newPoint.getX() == prevPoint.getX() +2	&& newPoint.getY() == prevPoint.getY() + 1)	return true;//oki
				
			}

		return false;
	}

	// detruire point de l'adversaire

	public void mangePointVoisin(Point newPoint,Joueur j) {
		int score =0; 
		
		
		
	if( (int)newPoint.getX() >=0 &&  (int) newPoint.getY() - 1>=0 )
		if (hextab [(int)newPoint.getX()  ][(int) newPoint.getY() - 1]!=null) 
			if (hextab [(int)newPoint.getX()  ][(int) newPoint.getY() - 1].getNumJoueur()!=0 )
				if (hextab [(int)newPoint.getX()  ][(int) newPoint.getY() - 1].getNumJoueur()!=j.getNum()){	
					hextab [(int)newPoint.getX()  ][(int) newPoint.getY() - 1].setCouleur(j.getCouleur());
					hextab [(int)newPoint.getX()  ][(int) newPoint.getY() - 1].setNumJoueur(j.getNum());
					score =score +5;
				}
	if( (int)newPoint.getX() >=0 &&  (int) newPoint.getY() + 1>=0 )
		if (hextab [(int)newPoint.getX()  ][(int) newPoint.getY() + 1]!=null) 
			if (hextab [(int)newPoint.getX()  ][(int) newPoint.getY() + 1].getNumJoueur()!=0 )
				if (hextab [(int)newPoint.getX()  ][(int) newPoint.getY() + 1].getNumJoueur()!=j.getNum()){	
					hextab [(int)newPoint.getX()  ][(int) newPoint.getY() + 1].setCouleur(j.getCouleur());
					hextab [(int)newPoint.getX()  ][(int) newPoint.getY() + 1].setNumJoueur(j.getNum());
					score =score +5;
				}
	if((int)newPoint.getX() + 1  >=0 &&  (int) newPoint.getY()>=0 )
		if (hextab [(int)newPoint.getX() + 1  ][(int) newPoint.getY()]!=null) 
			if (hextab [(int)newPoint.getX() + 1  ][(int) newPoint.getY()].getNumJoueur()!=0 )
				if (hextab [(int)newPoint.getX() + 1  ][(int) newPoint.getY()].getNumJoueur()!=j.getNum()) {
					hextab [(int)newPoint.getX() + 1  ][(int) newPoint.getY()].setCouleur(j.getCouleur());
					hextab [(int)newPoint.getX() + 1  ][(int) newPoint.getY()].setNumJoueur(j.getNum());
					score =score +5;
				}
	
	
	if((int)newPoint.getX() - 1  >=0 &&  (int) newPoint.getY()>=0 )
		if (hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY()]!=null) 
			if (hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY()].getNumJoueur()!=0 )
				if (hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY()].getNumJoueur()!=j.getNum()) {
					hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY()].setCouleur(j.getCouleur());
					hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY()].setNumJoueur(j.getNum());
					score =score +5;
				}
	
	
	
		
				
		
		
		
		

		
		if(newPoint.getX()>Accueil.longJeu){//dans le cas où  le joueur clique sur une case de la partie basse 
		
			
			
		if((int)newPoint.getX()  - 1 >=0 && (int) newPoint.getY() + 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX()  - 1 ][(int) newPoint.getY() + 1]!=null) 
				if (hextab [(int)newPoint.getX()  - 1 ][(int) newPoint.getY() + 1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY() + 1].getNumJoueur()!=j.getNum())
					{	hextab [(int)newPoint.getX()  - 1 ][(int) newPoint.getY() + 1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX()  - 1 ][(int) newPoint.getY() + 1].setNumJoueur(j.getNum());
						score =score +5;
					}
	
						
		if((int)newPoint.getX() + 1  >=0 &&  (int) newPoint.getY() - 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1]!=null) 
				if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].getNumJoueur()!=j.getNum()) {
						hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].setNumJoueur(j.getNum());
						score =score +5;
					}
		
		
		
		
			
			
			
		}
		else if(newPoint.getX()<Accueil.longJeu-2){//la partie haute 
		
			
			
			
		if((int)newPoint.getX() - 1 >=0 && (int) newPoint.getY() - 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX()  - 1 ][(int) newPoint.getY() - 1]!=null) 
				if (hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY() - 1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY() - 1].getNumJoueur()!=j.getNum())
					{	hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY() - 1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX() - 1  ][(int) newPoint.getY() - 1].setNumJoueur(j.getNum());
						score =score +5;
					}
	
						
		if((int)newPoint.getX() + 1  >=0 &&  (int) newPoint.getY() + 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() +  1]!=null) 
				if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY()+   1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() +  1].getNumJoueur()!=j.getNum()) {
						hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() +  1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() + 1].setNumJoueur(j.getNum());
						score =score +5;
					}
		
		
		
		
		}
		else if(newPoint.getX()==Accueil.longJeu-2){//oki _2

		
	if((int)newPoint.getX() - 1	 >=0 && (int) newPoint.getY() - 1>=0 )//verif..........
		if (hextab [(int)newPoint.getX() - 1	  ][(int) newPoint.getY() - 1]!=null) 
			if (hextab [(int)newPoint.getX()  - 1	 ][(int) newPoint.getY() - 1].getNumJoueur()!=0 )
				if (hextab [(int)newPoint.getX()  - 1	 ][(int) newPoint.getY() - 1].getNumJoueur()!=j.getNum())
				{	hextab [(int)newPoint.getX()  - 1	 ][(int) newPoint.getY() - 1].setCouleur(j.getCouleur());
					hextab [(int)newPoint.getX()  - 1	 ][(int) newPoint.getY() - 1].setNumJoueur(j.getNum());
					score =score +5;
				}

					
	if((int)newPoint.getX() + 1  >=0 &&  (int) newPoint.getY() + 1>=0 )//verif..........
		if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() + 1]!=null) 
			if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() + 1].getNumJoueur()!=0 )
				if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() + 1].getNumJoueur()!=j.getNum()) {
					hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() + 1].setCouleur(j.getCouleur());
					hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() + 1].setNumJoueur(j.getNum());
					score =score +5;
				}
	
	
	
	
		}
		
		
		
		else if(newPoint.getX()==Accueil.longJeu-1){//Milieuu  oki 

		
			
			
		if((int)newPoint.getX()  - 1 >=0 && (int) newPoint.getY() - 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX()  -1  ][(int) newPoint.getY() - 1]!=null) 
				if (hextab [(int)newPoint.getX()  -1  ][(int) newPoint.getY() - 1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX() -1 ][(int) newPoint.getY() - 1].getNumJoueur()!=j.getNum())
					{	hextab [(int)newPoint.getX() -1   ][(int) newPoint.getY() - 1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX() -1 ][(int) newPoint.getY() - 1].setNumJoueur(j.getNum());
						score =score +5;
					}
	
						
		if((int)newPoint.getX()  + 1  >=0 &&  (int) newPoint.getY() - 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1]!=null) 
				if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].getNumJoueur()!=j.getNum()) {
						hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX() + 1 ][(int) newPoint.getY() - 1].setNumJoueur(j.getNum());
						score =score +5;
					}
		
				
		}
		else if(newPoint.getX()==Accueil.longJeu){//apres milieu oki 

		
			
			
		if((int)newPoint.getX() + 1>=0 && (int) newPoint.getY() - 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX()  + 1  ][(int) newPoint.getY() - 1]!=null) 
				if (hextab [(int)newPoint.getX()  + 1  ][(int) newPoint.getY() - 1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX()  + 1  ][(int) newPoint.getY() - 1].getNumJoueur()!=j.getNum())
					{	hextab [(int)newPoint.getX()  + 1  ][(int) newPoint.getY() - 1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX() + 1  ][(int) newPoint.getY() - 1].setNumJoueur(j.getNum());
						score =score +5;
					}
	
						
		if((int)newPoint.getX() - 1  >=0 &&  (int) newPoint.getY() + 1>=0 )//verif..........
			if (hextab [(int)newPoint.getX() - 1 ][(int) newPoint.getY() + 1]!=null) 
				if (hextab [(int)newPoint.getX() - 1 ][(int) newPoint.getY() + 1].getNumJoueur()!=0 )
					if (hextab [(int)newPoint.getX() - 1 ][(int) newPoint.getY() + 1].getNumJoueur()!=j.getNum()) 
					{	hextab [(int)newPoint.getX() - 1 ][(int) newPoint.getY() + 1].setCouleur(j.getCouleur());
						hextab [(int)newPoint.getX() - 1 ][(int) newPoint.getY() + 1].setNumJoueur(j.getNum());
						score =score +5;
					}
		
		
		
		
		
		}

						
		
		j.setScore(j.getScore()+score);
	}

	// choix de l'ordianteur

	public Point caseOrdiIter1() {
		boolean trouve = false;
		int x = 0, y = 0;
		Random rand = new Random();
		while (trouve == false) {
			x = rand.nextInt(Accueil.longJeu * 2 - 1);
			y = rand.nextInt(Accueil.longJeu * 2 - 1);
			if (hextab[x][y] != null) {
				if (hextab[x][y].getNumJoueur() == 0) { // si la case est
														// contient comme num
														// joueur -1 donc elle
														// est vide
					hextab[x][y].setNumJoueur(4);
					hextab[x][y].setCouleur(0x000000);
					trouve = true;
				}
			}
		}

		return new Point(x, y);
	}
	
	public boolean deplaceOrdi(Joueur joueur){ 
		//lorsque l'ordianteur il cherche tous d'abord un point des ses points dans le tableau des hexagone 
		//si son point alors 
		//	 si il est possible de cloner alors 
		//		il clone 
		//		il appel la fontion de mager par le point par son nom
		//	si non si il est possible de sauter 
		//		il saute
		//		il mange 
		//		
		//		
		//		
		//		
		
		
		int x = 0, y = 0;
		Random rand = new Random();
		Point[] possiblePoint = {new Point(2,2), 	new Point(2,1), 	new Point(2,0), 	new Point(2,-1), 	new Point(2,-2),  
							new Point(1,2), 	new Point(1,1), 	new Point(1,0), 	new Point(1,-1), 	new Point(1,-2),   
							new Point(0,2), 	new Point(0,1), 						new Point(0,-1),	new Point(0,-2),
							new Point(-1,2),	new Point(-1,1),	new Point(-1,0),	new Point(-1,-1), 	new Point(1,-2),
							new Point(-2,2), 	new Point(-2,1), 	new Point(-2,0),	new Point(-2,-1),	new Point(-2,-2),
				}; 
		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (hextab[i][j] != null) {
					if (hextab[i][j].getNumJoueur()==joueur.getNum()){
						
						for (int p =0; p <=23; p++){
							Point prevPoint=new Point(i,j);
							Point newPoint=new Point((int)possiblePoint[p].getX()+i,(int)possiblePoint[p].getY()+j );
							if((int)newPoint.getX()>=0&&(int)newPoint.getY()>=0)
							if(hextab[(int)newPoint.getX()][(int)newPoint.getY()]!=null)
								if(hextab[(int)newPoint.getX()][(int)newPoint.getY()].getNumJoueur()==0){
								
									if(clonage(prevPoint,newPoint )){
										hextab[(int)newPoint.getX()][(int)newPoint.getY()].setNumJoueur(joueur.getNum());
										hextab[(int)newPoint.getX()][(int)newPoint.getY()].setCouleur(joueur.getCouleur());
									
										this.mangePointVoisin(newPoint, joueur);
								
										
										return true; 
									}else if(saut(prevPoint,newPoint) == true){

										hextab[(int)newPoint.getX()][(int)newPoint.getY()].setNumJoueur(joueur.getNum());
										hextab[(int)newPoint.getX()][(int)newPoint.getY()].setCouleur(joueur.getCouleur());
										this.mangePointVoisin(newPoint, joueur);

										return true; 
										
									}
								}
							}
					}
				}
			}
		}

			return false ; 
				
		
		
		
		
}
	

	public void mangeTous(Joueur joueur){ 
		 
		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (hextab[i][j] != null) {
					if (hextab[i][j].getNumJoueur()==0){
						
						
										hextab[i][j].setNumJoueur(joueur.getNum());
										hextab[i][j].setCouleur(joueur.getCouleur());
									
									
							
					}
				}
			}
		}

		
		
		
		
}
	
	public boolean testDeplace(Joueur j1){ 
		
		int x = 0, y = 0;
		Random rand = new Random();
		Point[] possiblePoint = {new Point(2,2), 	new Point(2,1), 	new Point(2,0), 	new Point(2,-1), 	new Point(2,-2),  
							new Point(1,2), 	new Point(1,1), 	new Point(1,0), 	new Point(1,-1), 	new Point(1,-2),   
							new Point(0,2), 	new Point(0,1), 						new Point(0,-1),	new Point(0,-2),
							new Point(-1,2),	new Point(-1,1),	new Point(-1,0),	new Point(-1,-1), 	new Point(1,-2),
							new Point(-2,2), 	new Point(-2,1), 	new Point(-2,0),	new Point(-2,-1),	new Point(-2,-2),
				}; 
		for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
				if (hextab[i][j] != null) {
					if (hextab[i][j].getNumJoueur()==j1.getNum()){
						
						for (int p =0; p <=23; p++){
							Point prevPoint=new Point(i,j);
							Point newPoint=new Point((int)possiblePoint[p].getX()+i,(int)possiblePoint[p].getY()+j );
							if((int)newPoint.getX()>=0&&(int)newPoint.getY()>=0)
							if(hextab[(int)newPoint.getX()][(int)newPoint.getY()]!=null)
								if(hextab[(int)newPoint.getX()][(int)newPoint.getY()].getNumJoueur()==0){
								
									if(clonage(prevPoint,newPoint )){
										
										return true; 
									}else if(saut(prevPoint,newPoint) == true){
										return true; 
										
									}
								}
							}
					}
				}
			}
		}

			return false ; 
				
		
		
		
		
}

}
