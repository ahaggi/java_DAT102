package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class Tre extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel noder[];
	
	
	public Tre() {
		setLayout(null);
		
	}
	private KjedetBSTre<Integer> bs = null;

	@Override
	public void paintComponent(Graphics g) {
		if (bs!=null) {
			g.drawString("aa", 40, 50);
			g.drawOval(25, 25, 40, 40);


		}
	}
	
	public void tegnTre() {
		BinaerTreNode<Integer> node=bs.getRot();
		JLabel rot_lbl=new JLabel(node.getVenstre().getElement()+"");
		rot_lbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		rot_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		rot_lbl.setOpaque(false);
		
		rot_lbl.setBounds(700, 10, 20, 20);
		add(rot_lbl);
		
		tegnTreRek(rot_lbl, node);
	}
	
	public void tegnTreRek(JLabel lbl, BinaerTreNode<Integer> node) {
		
		if (node.getVenstre()!=null) {
			JLabel v_lbl=new JLabel(node.getVenstre().getElement()+"");
			v_lbl.setBorder(new LineBorder(new Color(0, 0, 0)));
			v_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			v_lbl.setOpaque(false);
			int y=lbl.getY()+60;
			int x=(int) (lbl.getX()-(    Math.pow(2, (6 - (y / (60) + 1))) *10     ));
			v_lbl.setBounds(x, y, 20, 20);
			add(v_lbl);
			
			tegnTreRek(v_lbl, node.getVenstre());
			
		}
		if (node.getHoyre()!=null) {
			JLabel r_lbl=new JLabel(node.getHoyre().getElement()+"");
			r_lbl.setBorder(new LineBorder(new Color(0, 0, 0)));
			r_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			r_lbl.setOpaque(false);
			int y=lbl.getY()+60;
			int x = (int) (lbl.getX() + (    Math.pow(2, (6 - (y / (60) + 1))) *10     ));
			r_lbl.setBounds(x, y, 20, 20);
			add(r_lbl);
			
			tegnTreRek(r_lbl, node.getHoyre());
			
		}
		
	}


	

	public  KjedetBSTre<Integer> getBs() {
		return bs;
	}

	public  void setBs(KjedetBSTre<Integer> bs) {
		this.bs = bs;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JFrame jFrame = new JFrame();
					Tre jTree=new Tre();
					jFrame.getContentPane().add(jTree);
					jFrame.setSize(500, 500);
					jFrame.setVisible(true);
					
					final int ANTALL_NODER = 16;
					Random tilfeldig = new Random();

					KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();
					jTree.setBs(bs);
					Integer resultat = null;

					for (int i = 0; i < ANTALL_NODER; i++) {
						Integer element = new Integer(tilfeldig.nextInt(30));
						bs.leggTil(element);
					}
					jTree.tegnTre();
//					jTree.repaint();
					
					
					;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
