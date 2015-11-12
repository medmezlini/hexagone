package hexagone;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class AlgoJeu extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int largeur = 800;
	private final int haut = 700;
	private int size = 15;

	private Font font = new Font("Arial", Font.BOLD, 18);
	FontMetrics metrics;

	public AlgoJeu() {

		// chaque joueur capable de deplacer un point de deux pas au maximum.
		// lorsque il presse sur entrer alor le point ser fixe dans sa place.
		// impossible de placer un point dans une case pleine/bloquée
		// impossible de sortir de la grille
		// à chaque point gangé le joueur gangne son score sera additionné avec
		// 5.
		// il pert sa partie lorsque il ne trouve pas un emplacement pour
		// deplacé ses point

		setPreferredSize(new Dimension(largeur, haut));
		// this.setLocation(50,50);

	}

	public void refresh() {
		removeAll();
		revalidate();

		// revalidate();
		// repaint();

	}

	public void paintComponent(Graphics g) {
		Graphics2D pl2d = (Graphics2D) g;
		Point origin = new Point(largeur / 2, haut / 2);

		pl2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_MITER));

		metrics = g.getFontMetrics();

		GridHexagone(pl2d, origin, Accueil.longJeu * 2 - 1, 15, 8);
	}

	private void GridHexagone(Graphics g, Point origin, int size, int radius,
			int padding) {

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (Plateau.hextab[row][col] != null) {
					if (Plateau.hextab[row][col].getStatut() == 0)
						dessinerHexagone(g,
								Plateau.hextab[row][col].getCouleur(),
								(int) Plateau.hextab[row][col].getPointCentre()
										.getX(), //
								(int) Plateau.hextab[row][col].getPointCentre()
										.getY(), //
								radius);
					// Plateau.hextab[row][col].setStatut(0);
				}
			}
		}
	}

	private void dessinerHexagone(Graphics g, int couleur, int x, int y, int r) {
		Graphics2D pl2d = (Graphics2D) g;

		Hexagone hexagon = new Hexagone(x, y, r);
		hexagon.draw(pl2d, x, y, 0, couleur, true); // ce couleur va être
													// changer c'est le couleur
													// du fond
		hexagon.draw(pl2d, x, y, 5, 0xf111ee, false);

	}

}
