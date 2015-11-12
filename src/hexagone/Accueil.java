/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagone;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import bd.DB;





public class Accueil extends javax.swing.JFrame {
	public Joueur [] JOUEUR = new Joueur[4]; 
	public static Plateau p;
	public static int jaune = 0xeaf111; // on utilise cette variabele lors de l'appel de saut d'une case 
	public static JPanel jeu;
	public static AlgoJeu j;
	public static int iteration = 0;
	

	public static int iterationInitialisation=0; 
	public static int iterationPrecedente = 0; // utiliser dans le cas de 4 joueur 
	public static int nbHexagone = 0;
	public static int nbClick = 0;// pour memoriser le nombre de click du joueur
	public static Point ptClick = new Point(-1, -1);// la premiere point cliqué
													// par le joueur

	public static int longJeu = 5;
	public static int nbJoueur = 1;
	public static boolean jeuTermine =false;
	public int x = 0, y = 0;
	
	boolean reprendreJeuSauvgarde=false; 

	Joueur j1 = new Joueur();
	Joueur j2 = new Joueur();
	Joueur j3 = new Joueur();
	Joueur j4 = new Joueur();
	
	
	/**
	 * Creates new form NewJFrame
	 */
	public Accueil() {
		initComponents();
		this.setTitle("Hexagone");
		this.setResizable(false);
		this.setLocation(new Point(200,100));
		this.setSize(new Dimension(500,370));
	}

	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		
		
		barMenu = new javax.swing.JMenuBar();
	    jeuMenu = new javax.swing.JMenu();
	    reprendre = new javax.swing.JMenu();
	    reprendreDernierePartie=  new javax.swing.JMenu();
	    sauvegarder = new javax.swing.JMenu();
	    quitter = new javax.swing.JMenu();
	    score = new javax.swing.JMenu();
	        
	        
	    scoreMenu1= new javax.swing.JMenu();
		scoreMenuItem1= new javax.swing.JMenuItem();   
		scoreMenu2= new javax.swing.JMenu();
		scoreMenuItem2= new javax.swing.JMenuItem();
		scoreMenu3= new javax.swing.JMenu();
		scoreMenuItem3= new javax.swing.JMenuItem();   
		scoreMenu4= new javax.swing.JMenu();
		scoreMenuItem4= new javax.swing.JMenuItem();  
		scoreMenu5= new javax.swing.JMenu();
		scoreMenuItem5= new javax.swing.JMenuItem();

		logoLabel = new javax.swing.JLabel();
		jouer = new javax.swing.JButton();
		lesJoueurs = new javax.swing.JPanel();
		psJoueur1Label = new javax.swing.JLabel();
		psJoueur3Label = new javax.swing.JLabel();
		psJoueur2Label = new javax.swing.JLabel();
		joueur1 = new javax.swing.JTextField();
		joueur2 = new javax.swing.JTextField();
		joueur3 = new javax.swing.JTextField();
		ParametreJeu = new javax.swing.JPanel();
		nbJoeurLabel = new javax.swing.JLabel();
		longJeuLabel = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		nbjoueur = new javax.swing.JList();
		longjeu = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"Logowithname.png")));

		jouer.setText("Saisir");
		jouer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jouerActionPerformed(evt);
			}
		});

		psJoueur1Label.setText("Psoeudo joueur1");

		psJoueur3Label.setText("Psoeudo joueur3");

		psJoueur2Label.setText("Psoeudo joueur2");

		joueur1.setText("");

		joueur2.setText("");

		joueur3.setText("");
		

		javax.swing.GroupLayout lesJoueursLayout = new javax.swing.GroupLayout(
				lesJoueurs);
		lesJoueurs.setLayout(lesJoueursLayout);
		lesJoueurs.setVisible(false);
		lesJoueursLayout
				.setHorizontalGroup(lesJoueursLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								lesJoueursLayout
										.createSequentialGroup()
										.addGap(19, 19, 19)
										.addGroup(
												lesJoueursLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																psJoueur3Label,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																psJoueur1Label,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																84,
																Short.MAX_VALUE)
														.addComponent(
																psJoueur2Label,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												40, Short.MAX_VALUE)
										.addGroup(
												lesJoueursLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																joueur2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																140,
																Short.MAX_VALUE)
														.addComponent(
																joueur3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																140,
																Short.MAX_VALUE)
														.addComponent(
																joueur1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																140,
																Short.MAX_VALUE))
										.addGap(30, 30, 30)));
		lesJoueursLayout
				.setVerticalGroup(lesJoueursLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								lesJoueursLayout
										.createSequentialGroup()
										.addGroup(
												lesJoueursLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																psJoueur1Label,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																27,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																joueur1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												lesJoueursLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																psJoueur2Label,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																27,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																joueur2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												lesJoueursLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																psJoueur3Label,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																27,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																joueur3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(14, Short.MAX_VALUE)));

		nbJoeurLabel.setText("Nombre de joueur");

		longJeuLabel.setText("longueur de jeu");

		nbjoueur.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Humain vs Ord", "Humain vs Humain",
					"3 Humains + Ord" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane2.setViewportView(nbjoueur);

		javax.swing.GroupLayout ParametreJeuLayout = new javax.swing.GroupLayout(
				ParametreJeu);
		ParametreJeu.setLayout(ParametreJeuLayout);
		ParametreJeuLayout
				.setHorizontalGroup(ParametreJeuLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								ParametreJeuLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												ParametreJeuLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																longJeuLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																nbJoeurLabel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																106,
																Short.MAX_VALUE))
										.addGap(28, 28, 28)
										.addGroup(
												ParametreJeuLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																longjeu,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																140,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																140,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(31, Short.MAX_VALUE)));
		ParametreJeuLayout
				.setVerticalGroup(ParametreJeuLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								ParametreJeuLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												ParametreJeuLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																nbJoeurLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												ParametreJeuLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																longJeuLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																27,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																longjeu,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(42, 42, 42)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(logoLabel)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						ParametreJeu,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						lesJoueurs,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addComponent(
																		jouer,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		87,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(25, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(17, 17, 17)
								.addComponent(logoLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(ParametreJeu,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		lesJoueurs,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap(
																		44,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jouer,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		33,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(87, 87,
																		87)))));
		
		
		
		
		
		//menu barr***********************************
		
		
		
		
		

	      
	        jeuMenu.setText("Jeu");

	        reprendre.setText("reprendre");
	        reprendre.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                reprendreMouseClicked(evt);
	            }
	        });
	        
	        
	        jeuMenu.add(reprendreDernierePartie);
	        
	        
	        
	        
	        reprendreDernierePartie.setText("reprendre Derniere Partie");
	        reprendreDernierePartie.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	try {
						reprendreDernierePartieMouseClicked(evt);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	        
	        
	        jeuMenu.add(reprendre);

	        sauvegarder.setText("Sauvegader Score");
	        sauvegarder.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                try {
						sauvegarderMouseClicked(evt);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	        jeuMenu.add(sauvegarder);

	        quitter.setText("Quitter");
	        quitter.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                quitterMouseClicked(evt);
	            }
	        });
	        jeuMenu.add(quitter);

	        barMenu.add(jeuMenu);

	        score.setText("Meilleur Score");
	        score.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                try {
						scoreMouseClicked(evt);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });


	        

	        barMenu.add(score);

	        

	      
		
		
		

		pack();
	}// </editor-fold>

	
	
	
	// les evennement 
                                        

    private void reprendreMouseClicked(java.awt.event.MouseEvent evt) {                                       
     	iteration =1; 
    	
     	
		if (p.countComponents() > 0)
			p.remove(0);

		jeu.remove(p);
		validate();
		repaint();

		p.add(j);
		jeu.add(p);
		
		revalidate(); 

    }                                      

    

    private void reprendreDernierePartieMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {    
    	
    	reprendreJeuSauvgarde=true; 
    	
    	if (iteration >1){ 
    	
    	DB db = new DB();
    	ResultSet resultatJoueurs = db.getJoueurs();
    	ResultSet resultatHexagones = db.getHexagons();
    	ResultSet resultatPartie = db.getPartie();
    	
    	
    	while (resultatPartie.next()) {
    		
    		
    		
    		// extraire les joueurs 
    		 
    		longJeu=resultatPartie.getInt(3);
    		nbJoueur=resultatPartie.getInt(4);
    		this.nbClick=resultatPartie.getInt(5);
    		iteration=resultatPartie.getInt(8);
    		nbHexagone=resultatPartie.getInt(9); 
    		
    		
    		
    		//remplissage des joueurs 
    		
    		
    		
    		
    		int ietration =1;
    		while(resultatJoueurs.next()){
    			if(nbJoueur==1){
    				
    				if(iteration==1){
    					
    					
    					j1.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j1.setBackground(new java.awt.Color(255, 255, 255));
    					j1.setNum(resultatJoueurs.getInt(2));
    					j1.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));			
    				
    					j1.setScore(resultatJoueurs.getInt(4));
    					j1.setPsoeudo(resultatJoueurs.getString(3));
    					
    				}
    				else 
    				{

    					j1.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j1.setBackground(new java.awt.Color(255, 255, 255));
    					j1.setNum(resultatJoueurs.getInt(2));
    					j1.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));	
    					
    					j2.setScore(resultatJoueurs.getInt(4));
    					j2.setPsoeudo(resultatJoueurs.getString(3));
    				}
    				
    			}
				if(nbJoueur==2){
					if(iteration==1){
						

    					j1.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j1.setBackground(new java.awt.Color(255, 255, 255));
    					j1.setNum(resultatJoueurs.getInt(2));
    					j1.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));	
						
						j1.setScore(resultatJoueurs.getInt(4));
    					j1.setPsoeudo(resultatJoueurs.getString(3));
    				}
    				else {

    					j2.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j2.setBackground(new java.awt.Color(255, 255, 255));
    					j2.setNum(resultatJoueurs.getInt(2));
    					j2.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));	
    					
    					j2.setScore(resultatJoueurs.getInt(4));
    					j2.setPsoeudo(resultatJoueurs.getString(3));
    				}
    				
    				
    			}
				if(nbJoueur==3){

					if(iteration==1){
						

    					j1.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j1.setBackground(new java.awt.Color(255, 255, 255));
    					j1.setNum(resultatJoueurs.getInt(2));
    					j1.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));	
						
						j1.setScore(resultatJoueurs.getInt(4));
    					j1.setPsoeudo(resultatJoueurs.getString(3));
    					
    				}

					if(iteration==2){
						

    					j2.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j2.setBackground(new java.awt.Color(255, 255, 255));
    					j2.setNum(resultatJoueurs.getInt(2));
    					j2.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));	
						j2.setScore(resultatJoueurs.getInt(4));
    					j2.setPsoeudo(resultatJoueurs.getString(3));
    				}

					if(iteration==3){

    					j3.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j3.setBackground(new java.awt.Color(255, 255, 255));
    					j3.setNum(resultatJoueurs.getInt(2));
    					j3.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));	
						
						j3.setScore(resultatJoueurs.getInt(4));
    					j3.setPsoeudo(resultatJoueurs.getString(3));
    					j3.setVisible(true);
    				}

					if(iteration==4){
						

    					j4.setBorder(new javax.swing.border.LineBorder(
    							new java.awt.Color(255, 0, 255), 1, true));
    					j4.setBackground(new java.awt.Color(255, 255, 255));
    					j4.setNum(resultatJoueurs.getInt(2));
    					j4.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
    							.getResource("iconVert.png")));	
						
						j4.setScore(resultatJoueurs.getInt(4));
    					j4.setPsoeudo(resultatJoueurs.getString(3));
    					j4.setVisible(true);
    				
    				}
    				
    				
    			}
				
				ietration++;
    			
    			
    		}
    		

    		// extraire les hexagone et remplire les le tableau hexTab
    		while(resultatHexagones.next()){
    			    			
    		}
    		
    	}
    	
  		}

    }  
    private void sauvegarderMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {                                         
        // TODO add your handling code here:
    	DB db = new DB();
    	int idPartie =db.getIdPartie();
    	
    	
    	if(nbJoueur ==1){
    		db.insert_Joueur(JOUEUR[0].getNum(), JOUEUR[0].getPsoeudo(), JOUEUR[0].getScore(),JOUEUR[0].getPerd(), JOUEUR[0].getActif(), idPartie);
    		db.insert_Joueur(JOUEUR[3].getNum(), JOUEUR[3].getPsoeudo(), JOUEUR[3].getScore(),JOUEUR[3].getPerd(), JOUEUR[3].getActif(), idPartie);
    		
    	}
    	else if (nbJoueur ==2) {
    		
    		db.insert_Joueur(JOUEUR[0].getNum(), JOUEUR[0].getPsoeudo(), JOUEUR[0].getScore(),JOUEUR[1].getPerd(), JOUEUR[0].getActif(), idPartie);
    		db.insert_Joueur(JOUEUR[1].getNum(), JOUEUR[1].getPsoeudo(), JOUEUR[1].getScore(),JOUEUR[1].getPerd(), JOUEUR[1].getActif(), idPartie);
    		
    		
    	}
    		
    	else 
    	{
    		for(int i =0 ; i <4 ; i++ ){
        	
    			db.insert_Joueur(JOUEUR[i].getNum(), JOUEUR[i].getPsoeudo(), JOUEUR[i].getScore(),JOUEUR[i].getPerd(), JOUEUR[i].getActif(), idPartie);
    			
    		}
    	}
    
    	db.insert_Partie( this.longJeu,  this.nbJoueur  ,  this.nbClick  ,  (int)this.ptClick.getX()  ,  (int)this.ptClick.getY()   ,  this.iteration  ,  this.nbHexagone);
    	
    	// trouver dernier partie puis enregistrer les hexagone
    	
    	
    	for (int i = 0; i < Accueil.longJeu * 2 - 1; i++) {
			for (int j = 0; j < Accueil.longJeu * 2 - 1; j++) {
			
				if (Plateau.hextab[i][j]!=null){
					db.insert_Hexagone( Plateau.hextab[i][j].getPointCentre().x, Plateau.hextab[i][j].getPointCentre().y,Plateau.hextab[i][j].getCouleur() ,Plateau.hextab[i][j].getNumJoueur()
							,Plateau.hextab[i][j].getRadius() , j , i , Plateau.hextab[i][j].getRotation(),6,idPartie );
    
				}
			}
			}
        	
    		
    	
    }                                        

    private void quitterMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
    	System.exit(0); 
    	
    }                                    

    private void scoreMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {                                   
        
    	
    	ResultSet resultats = null;
    	 DB db = new DB();
    	 resultats= db.getScore(); 
    	 
    	 int i =1; 
         while (resultats.next()) {
        	 String nomRes = resultats.getString(3);
             int scoreRes = resultats.getInt(4); 
        	 if(i==1){
        		 
        		 
        		    scoreMenuItem1.setText(""+scoreRes);
        		    scoreMenu1.setText(nomRes);
        		    scoreMenu1.add(scoreMenuItem1);
         	        score.add(scoreMenu1);
        		 
        	 }
        	 if(i==2){

        		 
     		    scoreMenuItem2.setText(""+scoreRes);
     		    scoreMenu2.setText(nomRes);
     		    scoreMenu2.add(scoreMenuItem1);
      	        score.add(scoreMenu2);
        	 }
        	 if(i==3){

        		 
     		    scoreMenuItem3.setText(""+scoreRes);
     		    scoreMenu3.setText(nomRes);
     		    scoreMenu3.add(scoreMenuItem3);
      	        score.add(scoreMenu3);
        	 }
        	 if(i==4){

        		 
     		    scoreMenuItem4.setText(""+scoreRes);
     		    scoreMenu4.setText(nomRes);
     		    scoreMenu4.add(scoreMenuItem4);
      	        score.add(scoreMenu4);
        	 }
        	 if(i==5){

        		 
     		    scoreMenuItem5.setText(""+scoreRes);
     		    scoreMenu5.setText(nomRes);
     		    scoreMenu5.add(scoreMenuItem5);
      	        score.add(scoreMenu5);
        	 }
        	 
        	 
        	 
        	
         
            
         i++; 
         }
    	
    }  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// changer le curseur du jeu
	public void pmouseEntered(MouseEvent evt) {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("cursor.png"); // le cursor peut etre
														// personnaliser % au
														// joueur actif
		Cursor a = toolkit.createCustomCursor(image, new Point(this.getX(),
				this.getY()), "");
		this.setCursor(a);
	}

	
	
	
	
	
	// fonctionne qui organise le role du joueur

	public void quiJoue1(MouseEvent evt, Joueur j1, Joueur j2) {
		

		if (Accueil.nbHexagone != 0) {
			
//			
			if(iteration>1){
				nbClick++;
				if(nbClick>2)nbClick=1; 
				if (nbClick == 1) {
					ptClick.setLocation(
							(int) p.dinstanceMinimale(evt.getPoint().x,
									evt.getPoint().y).getX(),
							(int) p.dinstanceMinimale(evt.getPoint().x,
									evt.getPoint().y).getY());
					
					if((int) p.dinstanceMinimale(evt.getPoint().x,evt.getPoint().y).getX()>=0&&(int) p.dinstanceMinimale(evt.getPoint().x,evt.getPoint().y).getY()>=0)
					if (p.hextab[(int) p.dinstanceMinimale(evt.getPoint().x,evt.getPoint().y).getX()]
								[(int) p.dinstanceMinimale(evt.getPoint().x,evt.getPoint().y).getY()].getNumJoueur() != j1.getNum()) 
					{
						nbClick--;//le test de la premiere click
						

					}

				}
				if (nbClick == 2) {
					Point newPoint = new Point(p.dinstanceMinimale(
							evt.getPoint().x, evt.getPoint().y));
					if ((int) newPoint.getX()>=0 && (int) newPoint.getY()>=0)
					if (p.hextab[(int) newPoint.getX()][(int) newPoint.getY()]
							.getNumJoueur() == 0) {
//
						if (p.saut(ptClick, newPoint) == true) {

							p.hextab[(int) newPoint.getX()][(int) newPoint
									.getY()].setNumJoueur(j1.getNum());
							p.hextab[(int) newPoint.getX()][(int) newPoint
															.getY()].setCouleur(j1.getCouleur());;

							p.hextab[(int) ptClick.getX()][(int) ptClick.getY()]
									.setNumJoueur(0);
							p.hextab[(int) ptClick.getX()][(int) ptClick.getY()]
									.setCouleur(jaune);
							
							
							//j1.setScore(j1.getScore()+5);
							iteration++;
							iterationPrecedente=1; 

							p.mangePointVoisin(newPoint,j1);
							
							//nbHexagone--;
							
							
							
//							if (nbHexagone != 0) {

								if (nbHexagone != 0&&p.deplaceOrdi(j2)) {
									
//								Point pointOrd = p.caseOrdiIter1();
//
//								p.hextab[pointOrd.x][pointOrd.y].setCouleur(j2.getCouleur());
//								j2.setScore(j2.getScore() + 5);
								
								nbHexagone--;
							}

								j1.setScore(j1.getScore());
								j2.setScore(j2.getScore());

						}
						if (p.clonage(ptClick, newPoint) == true) {
							p.hextab[(int) newPoint.getX()][(int) newPoint
									.getY()].setNumJoueur(j1.getNum());
							p.hextab[(int) newPoint.getX()][(int) newPoint
															.getY()].setCouleur(j1.getCouleur());
													
							//j1.setScore(j1.getScore()+5);
							p.mangePointVoisin(newPoint,j1);
							
							iteration++;
							
							iterationPrecedente=1;  
							nbHexagone--;

							//if (nbHexagone != 0) {
							if (nbHexagone != 0&&p.deplaceOrdi(j2)) {
								
					
								nbHexagone--;
							}

							j1.setScore(j1.getScore());
							j2.setScore(j2.getScore());
						}
					}
				}

				

			}
		} else {// le cas ou tous les case sont pleine le jeu est terminer

			JPanel fin = new JPanel();
			fin.setBackground(new Color(200, 200, 0));
			// fin.add();

			this.setContentPane(jeu);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		
	}

	
	
	//humain vs Humain 
	
	public void quiJoue2(MouseEvent evt, Joueur j1, Joueur j2) {
		if(p.testDeplace(j1)==false){iteration++;
		if(this.nbJoueur==2)p.mangeTous(j2);
		
		}
		
		if(j1.getPerd()==0){

		if (Accueil.nbHexagone != 0) {
			if(iteration>1){
				nbClick++;
				if(nbClick>2)nbClick=1; 
				if (nbClick == 1) {
					ptClick.setLocation(
							(int) p.dinstanceMinimale(evt.getPoint().x,
									evt.getPoint().y).getX(),
							(int) p.dinstanceMinimale(evt.getPoint().x,
									evt.getPoint().y).getY());
					
					if (p.hextab[(int) p.dinstanceMinimale(evt.getPoint().x,
							evt.getPoint().y).getX()][(int) p
							.dinstanceMinimale(evt.getPoint().x,
									evt.getPoint().y).getY()].getNumJoueur() != j1
							.getNum()) {
						nbClick--;//le test de la premiere click
							

					}

				}
				if (nbClick == 2) {
					Point newPoint = new Point(p.dinstanceMinimale(
							evt.getPoint().x, evt.getPoint().y));
					if ((int) newPoint.getX()>=0 && (int) newPoint.getY()>=0)
					if (p.hextab[(int) newPoint.getX()][(int) newPoint.getY()]
							.getNumJoueur() == 0) {
//
						if (p.saut(ptClick, newPoint) == true) {

							p.hextab[(int) newPoint.getX()][(int) newPoint
									.getY()].setNumJoueur(j1.getNum());
							p.hextab[(int) newPoint.getX()][(int) newPoint
															.getY()].setCouleur(j1.getCouleur());;

							p.hextab[(int) ptClick.getX()][(int) ptClick.getY()]
									.setNumJoueur(0);
							p.hextab[(int) ptClick.getX()][(int) ptClick.getY()]
									.setCouleur(jaune);
							p.mangePointVoisin(newPoint,j1);
											
								

								j1.setScore(j1.getScore());
								j2.setScore(j2.getScore());

								iteration++;
								iterationPrecedente++; 

						}
						if (p.clonage(ptClick, newPoint) == true) {
							p.hextab[(int) newPoint.getX()][(int) newPoint
									.getY()].setNumJoueur(j1.getNum());
							p.hextab[(int) newPoint.getX()][(int) newPoint
															.getY()].setCouleur(j1.getCouleur());
							
							p.mangePointVoisin(newPoint,j1);

							iteration++;
							iterationPrecedente++; 
							
							nbHexagone--;
							j1.setScore(j1.getScore());
							j2.setScore(j2.getScore());
						}
					}
				}
				if(j1.getScore()==0){iteration++;
				
							iterationPrecedente++;
					
					j1.setPerd(1);
						}
				

			}
		} else {// le cas ou tous les case sont pleine le jeu est terminer

			JPanel fin = new JPanel();
			fin.setBackground(new Color(200, 200, 0));
			// fin.add();

			this.setContentPane(jeu);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		}
	}
	
	
	

	// position de la souris dans le plan
	public void positionMouse(MouseEvent e) {

		// longJeu--;
		
		if (p.countComponents() > 0)
			p.remove(0);

		jeu.remove(p);
		validate();
		repaint();

		p.add(j);
		jeu.add(p);

		
	}

	private void jouerActionPerformed(java.awt.event.ActionEvent evt) {
		if (longjeu.getText().length() > 0) {
			int passe = 0; // passe c'est fait pour passer vers le jeu
			if(Integer.parseInt(longjeu.getText()) < 8){
			if (Integer.parseInt(longjeu.getText()) < 3)
				longJeu = 3;
			else
				longJeu = Integer.parseInt(longjeu.getText());
			//
			if (nbjoueur.getSelectedIndex() == 1)
				nbJoueur = 2;
			if (nbjoueur.getSelectedIndex() == 2)
				nbJoueur = 3;
			

			jeu = new JPanel();
			jeu.setPreferredSize(new Dimension(900, 700));

			jouer.setText("jouer");

			nbjoueur.disable();
			longjeu.disable();

			psJoueur2Label.setVisible(false);
			joueur2.setVisible(false);
			psJoueur3Label.setVisible(false);
			joueur3.setVisible(false);

			lesJoueurs.setVisible(true);

			
			 j1.setActif(1);//pou lui rendre le joueur actif numero 1
			EtatJeu etat =new EtatJeu(); 
			etat.setBackground(new Color(230,200,150));
			JOUEUR[0]=j1;			
			JOUEUR[1]=j2; 			
			JOUEUR[2]=j3; 			
			JOUEUR[3]=j4; 

			// setvisible false dans la grille

			// Plateau p = new Plateau();
			p = new Plateau();
			// p.getComponents();
				
			j = new AlgoJeu();
			
			
			
			j1.setScore(10); 			
			j2.setScore(10);
			j3.setScore(10); 			
			j4.setScore(10);
			
			// // pour changer le curseur
			j.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					// lorsque l'utilisateur reprendre la derniere jeu sauvegareder
					
					if (reprendreJeuSauvgarde==true){
						
					}
					
					
				if (iteration ==2){	
					j1.setScore(10); 			
					j2.setScore(10);
					j3.setScore(10); 			
					j4.setScore(10);}
					
					JOUEUR[0]=j1; 			
					JOUEUR[1]=j2; 			
					JOUEUR[2]=j3; 			
					JOUEUR[3]=j4;
					
						if (nbJoueur == 1){
						iterationInitialisation=3; 
						quiJoue1(evt, j1, j2);
						
						
						
						}
						
					else if (nbJoueur == 2){
						
						iterationInitialisation=3; 
						
						if(j1.getPerd()==1)quiJoue2(evt, j2, j1);
						else if (j2.getPerd()==1)quiJoue2(evt, j1, j2);
						else {
							if(iteration %2==0)
								quiJoue2(evt, j1, j2);
							else	quiJoue2(evt, j2, j1);
							}
						}

					else{ 
						iterationInitialisation=12; 
						if(iteration%3==1){
							
							quiJoue1(evt, j1, j4);
							j2.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
							
//							j2.setActif(1);
//							j1.setActif(0);
							j1.setBorder(new javax.swing.border.LineBorder(
									new java.awt.Color(255, 0, 255), 1, true));
						
						}
						else if (iteration%3==2){
//							j3.setActif(1);
//							j2.setActif(0);
							
							quiJoue2(evt, j2, j1);
							j3.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));						
							j2.setBorder(new javax.swing.border.LineBorder(
									new java.awt.Color(255, 0, 255), 1, true));
							
							}
						else {
							
							quiJoue2(evt, j3, j2);
							j1.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 							
//							j1.setActif(1);
//							j3.setActif(0);
							j3.setBorder(new javax.swing.border.LineBorder(
									new java.awt.Color(255, 0, 255), 1, true));
							
						
						}
						

						//quiJoue1(evt, j3, j4);
						
					}
					positionMouse(evt);

					//pour terminer le jeu 
					int joueurGagne =etat.changeEtatJeu();
					j1.setScore(j1.getScore());
					j2.setScore(j2.getScore());
					j3.setScore(j3.getScore());
					j4.setScore(j4.getScore());

					//afficher le gagnat du jeu
					
					
					//afficher le gagnat du jeu
					
					if (joueurGagne==0) {
						int posMax=0; 
						for(int i =1 ; i <4 ; i++){
							if(JOUEUR[i].getScore()>JOUEUR[posMax].getScore())
								posMax=i; 
							}
						etat.gangnatLabel.setText(JOUEUR[posMax].getPsoeudo() + ": gagne");
					}
					if (joueurGagne==1) etat.gangnatLabel.setText(j1.getPsoeudo() + ": gagne");
					if (joueurGagne==2) etat.gangnatLabel.setText(j2.getPsoeudo() + ": gagne");
					if (joueurGagne==3) etat.gangnatLabel.setText(j3.getPsoeudo() + ": gagne");
					if (joueurGagne==4) etat.gangnatLabel.setText(j4.getPsoeudo() + ": gagne");
						
				}
			});

			// pour changer le curseur
			p.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					positionMouse(evt);
					
				}
			});
			//
			// j.refresh();

			p.add(j);

			
			// j.refresh();

			p.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(
					255, 153, 0), 1, true));

			if (nbJoueur == 1) {
				if (joueur1.getText().length() > 0) {

					j1.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j1.setBackground(new java.awt.Color(255, 255, 255));
					j1.setNum(1);
					j1.setPsoeudo(joueur1.getText());

					j1.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconVert.png")));

					j2.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j2.setBackground(new java.awt.Color(255, 255, 255));
					j2.setNum(4);
					
					j2.setPsoeudo("Ordinateur");

					j2.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconNoir.png")));

					jeu.add(logoLabel);
					jeu.add(j1);
					jeu.add(j2);

					setJMenuBar(barMenu);
					jeu.add(etat);
					jeu.add(p);

					this.setContentPane(jeu);

					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.pack();
					this.setLocationRelativeTo(null);
					this.setVisible(true);
					iteration++;

				}

			}

			if (nbJoueur == 2) {
				
				psJoueur2Label.setVisible(true);
				joueur2.setVisible(true);

				if (joueur2.getText().length() > 0
						&& joueur1.getText().length() > 0) {
					
					passe = 1;
					j1.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j1.setBackground(new java.awt.Color(255, 255, 255));
					j1.setNum(1);
					j1.setPsoeudo(joueur1.getText());
					j1.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconVert.png")));

					j2.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j2.setBackground(new java.awt.Color(255, 255, 255));
					j2.setNum(2);
					j2.setPsoeudo(joueur2.getText());
					j2.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconBleu.png")));
					
					jeu.add(logoLabel);
					jeu.add(j1);
					jeu.add(j2);

					setJMenuBar(barMenu);
					jeu.add(etat);
					jeu.add(p);

					this.setContentPane(jeu);

					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.pack();
					this.setLocationRelativeTo(null);
					this.setVisible(true);
					iteration++;

				}

			}

			if (nbJoueur == 3) {

				psJoueur2Label.setVisible(true);
				joueur2.setVisible(true);
				psJoueur3Label.setVisible(true);
				joueur3.setVisible(true);

				if (joueur1.getText().length() > 0
						&& joueur2.getText().length() > 0
						&& joueur3.getText().length() > 0) {

					j1.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j1.setBackground(new java.awt.Color(255, 255, 255));
					j1.setNum(1);
					j1.setPsoeudo(joueur1.getText());
					j1.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconVert.png")));

					j2.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j2.setBackground(new java.awt.Color(255, 255, 255));
					j2.setNum(2);
					j2.setPsoeudo(joueur2.getText());
					j2.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconBleu.png")));

					j3.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j3.setBackground(new java.awt.Color(255, 255, 255));
					j3.setNum(3);
					j3.setPsoeudo(joueur3.getText());
					j3.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconRouge.png")));

					j4.setBorder(new javax.swing.border.LineBorder(
							new java.awt.Color(255, 0, 255), 1, true));
					j4.setBackground(new java.awt.Color(255, 255, 255));
					j4.setNum(4);
					j4.setPsoeudo("Ordianteur");
					j4.coleurLabel.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("iconNoir.png")));

					jeu.add(logoLabel);
					jeu.add(j1);
					jeu.add(j2);
					jeu.add(j3);
					jeu.add(j4);
					
					
					setJMenuBar(barMenu);
					jeu.add(etat);
					jeu.add(p);

					this.setContentPane(jeu);

					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.pack();
					this.setLocationRelativeTo(null);
					this.setVisible(true);
					iteration++;

				}

			}

		}else {
			longjeu.setText("saisir entier <=8 ");
			longjeu.setBackground(new Color(255,0,0));
		}
			}

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Accueil().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jouer;
	private javax.swing.JLabel nbJoeurLabel;
	private javax.swing.JLabel longJeuLabel;
	private javax.swing.JLabel logoLabel;

	private javax.swing.JLabel psJoueur1Label;
	private javax.swing.JLabel psJoueur2Label;
	private javax.swing.JLabel psJoueur3Label;

	private javax.swing.JList nbjoueur;
	private javax.swing.JPanel ParametreJeu;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField longjeu;
	private javax.swing.JTextField joueur1;
	private javax.swing.JTextField joueur2;
	private javax.swing.JTextField joueur3;
	private javax.swing.JPanel lesJoueurs;
	private javax.swing.JMenuBar barMenu;

	private javax.swing.JMenu scoreMenu1;
	private javax.swing.JMenuItem scoreMenuItem1;   
	private javax.swing.JMenu scoreMenu2;
	private javax.swing.JMenuItem scoreMenuItem2;
	private javax.swing.JMenu scoreMenu3;
	private javax.swing.JMenuItem scoreMenuItem3;   
	private javax.swing.JMenu scoreMenu4;
	private javax.swing.JMenuItem scoreMenuItem4;  
	private javax.swing.JMenu scoreMenu5;
	private javax.swing.JMenuItem scoreMenuItem5;
	    
	private javax.swing.JMenu jeuMenu;
	    private javax.swing.JMenu quitter;
	    private javax.swing.JMenu reprendre;
	    private javax.swing.JMenu reprendreDernierePartie;
	    private javax.swing.JMenu sauvegarder;
	    private javax.swing.JMenu score;
	// End of variables declaration
}
