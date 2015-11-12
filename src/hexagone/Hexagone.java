package hexagone;

import java.awt.*;

public class Hexagone extends Polygon {

	private static final long serialVersionUID = 1L;

	public static final int sides = 6;

	private Point[] points = new Point[sides];
	private Point centre = new Point(0, 0);
	private int radius;
	private int rotation = 90;

	///
	private int row = 0;//
	private int col = 0;//
	private int couleur = 0;//
	private int numJoueur = 0;//

	
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}

	public int getNumJoueur() {
		return this.numJoueur;
	}

	public void setCouleur(int Couleur) {
		this.couleur = Couleur;
	}

	public int getCouleur() {
		return this.couleur;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRow() {
		return this.row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getCol() {
		return this.col;
	}

	public Point getPointCentre() {
		return this.centre;
	}
	

	private int statut = 0; // si statut ==1 alors la case est pleine sinon la
							// case est vide

	public Hexagone(Point centre, int radius) {
		npoints = sides;
		xpoints = new int[sides];
		ypoints = new int[sides];

		this.centre = centre;
		this.radius = radius;

		genererPoints();
	}

	public Hexagone(int x, int y, int radius) {
		this(new Point(x, y), radius);
	}

	public int getRadius() {
		return radius;
	}

	public int getStatut() {
		return this.statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public void setRadius(int radius) {
		this.radius = radius;

		genererPoints();
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;

		genererPoints();
	}

	public void setCentre(Point centre) {
		this.centre = centre;

		genererPoints();
	}

	public void setCentre(int x, int y) {
		setCentre(new Point(x, y));
	}

	private double getAngle(double fraction) {
		return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
	}

	private Point getPoint(double angle) {
		int x = (int) (centre.x + Math.cos(angle) * radius);
		int y = (int) (centre.y + Math.sin(angle) * radius);

		return new Point(x, y);
	}

	protected void genererPoints() {
		for (int p = 0; p < sides; p++) {
			double angle = getAngle((double) p / sides);
			Point point = getPoint(angle);
			xpoints[p] = point.x;
			ypoints[p] = point.y;
			points[p] = point;
		}
	}

	public void draw(Graphics2D g, int x, int y, int lineThickness,	int colorValue, boolean filled) {
		// Store before changing.
		Stroke tmpS = g.getStroke();
		Color tmpC = g.getColor();

		g.setColor(new Color(colorValue));
		g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER));

		if (filled) {
			g.fillPolygon(xpoints, ypoints, npoints);
		} else {
			g.drawPolygon(xpoints, ypoints, npoints);
		}

		// Set values to previous when done.
		g.setColor(tmpC);
		g.setStroke(tmpS);
	}
}
