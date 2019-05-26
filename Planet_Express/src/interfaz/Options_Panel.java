package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Options_Panel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public final static String START="start";
	public final static String UPLOAD="upload";
	public final static String SAVE="save";
//	public final static String ORDER="order";
	private JButton butStart;
	private JButton butUpload;
	private JButton butDistance;
//	private JButton butOrder;
	private Main interfaz;
	
	public final static String REPAINT="repaint";
	
	private JTextField accumulated;
	
	private JButton repaint;
	
	public void setAccumulated(String accumulated) {
		this.accumulated.setText(accumulated);
	}

	public Options_Panel(Main m){
		this.setBackground(Color.WHITE);
		interfaz=m;
		setBorder(new LineBorder(new Color(192, 192, 192), 5));
		setLayout(new BorderLayout());
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setForeground(Color.BLACK);
		buttonsPanel.setBackground(Color.CYAN);
		add(buttonsPanel,BorderLayout.NORTH);
		buttonsPanel.setLayout(new GridLayout(4, 1,0, 7));
//		butOrder=new JButton("Flight");
//		butOrder.setForeground(Color.GREEN);
//		buttonsPanel.add(butOrder);
//		butOrder.setFont(new Font("Kalinga", Font.PLAIN, 11));
//		butOrder.setBackground(Color.BLACK);
//		butOrder.addActionListener(this);
//		butOrder.setActionCommand(ORDER);
		butStart=new JButton("Start");
		butStart.setForeground(Color.GREEN);
		
		butStart.setFont(new Font("Kalinga", Font.PLAIN, 11));
		butStart.setBackground(Color.BLACK);
		buttonsPanel.add(butStart);
		
		butStart.addActionListener(this);
		butStart.setActionCommand(START);
		
		repaint = new JButton("Refresh");
		repaint.setForeground(Color.GREEN);
		repaint.setFont(new Font("Kalinga", Font.PLAIN, 11));
		repaint.setBackground(Color.BLACK);
		repaint.addActionListener(this);
		repaint.setActionCommand(REPAINT);
		butDistance=new JButton("Save");
		butDistance.setForeground(Color.GREEN);
		buttonsPanel.add(butDistance);
		butDistance.setFont(new Font("Kalinga", Font.PLAIN, 11));
		butDistance.setBackground(Color.BLACK);
		butDistance.addActionListener(this);
		butDistance.setActionCommand(SAVE);
		butUpload=new JButton("Load");
		butUpload.setForeground(Color.GREEN);
		buttonsPanel.add(butUpload);
		butUpload.setFont(new Font("Kalinga", Font.PLAIN, 11));
		butUpload.setBackground(Color.BLACK);
		butUpload.addActionListener(this);
		butUpload.setActionCommand(UPLOAD);
		buttonsPanel.setBackground(Color.WHITE);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.WHITE);
		buttonsPanel.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout());
		
		accumulated = new JTextField();
		accumulated.setText("0");
		accumulated.setBackground(new Color(255, 250, 205));
		accumulated.setHorizontalAlignment(SwingConstants.CENTER);
		accumulated.setEditable(false);
		
		JPanel panelText = new JPanel();
		
		panelText.setBackground(Color.CYAN);
		panelText.setLayout(new BorderLayout());
		JLabel label = new JLabel("Distance (km)");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.CYAN);
		panelText.add(label,BorderLayout.CENTER);
		panelText.add(accumulated,BorderLayout.SOUTH);
		panelText.setBackground(Color.WHITE);
		
		JPanel panelAux = new JPanel();
		panelAux.setForeground(Color.BLACK);
		panelAux.setLayout(new GridLayout(2,1));
		
		JLabel domi = new JLabel("© Planet_Express ©");
		domi.setBackground(Color.WHITE);
		domi.setForeground(Color.BLACK);
		domi.setVerticalAlignment(SwingConstants.BOTTOM);
		domi.setHorizontalAlignment(SwingConstants.CENTER);
		panelAux.add(domi,BorderLayout.NORTH);
		
		
		
		panelAux.setBackground(Color.WHITE);
		ImageIcon img = new ImageIcon("data/pictures/logo.png");
		JLabel lb = new JLabel(img);
		lb.setForeground(Color.GREEN);
		lb.setBackground(Color.WHITE);
		lb.setBounds(80, 80, 80, 80);
		panelAux.add(lb,BorderLayout.CENTER);
		
		panel.add(panelText,BorderLayout.NORTH);
		
		panel.add(panelAux,BorderLayout.CENTER);
		
		panel.add(repaint,BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String command = a.getActionCommand();
		if(command .equals(START)){
			try{
				String[] lista= {"Dijkstra", "BFS", "DFS", "Prim"};
				JComboBox<String> combo=new JComboBox<String>(lista);
				JOptionPane.showMessageDialog(this, combo, "select an option", JOptionPane.QUESTION_MESSAGE);
				String respuesta=(String) combo.getSelectedItem();
				//if(respuesta==""){
					if(respuesta.equals(lista[0])){
						interfaz.Dijkstra();
					}
					
					else if(respuesta.equals(lista[1])){
						interfaz.BFS();
					}
					
					else if(respuesta.equals(lista[2])){
						interfaz.DFS();;
					}
					else if(respuesta.equals(lista[3])){
						interfaz.Prim();
					}
					else{
						JOptionPane.showMessageDialog(this, "Only 1 or 2 can be written");
					}
				}
//				else{
//					JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
//				}
				//}
				catch(Exception ex){
//					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "Some failure");
				}
		}
		else if(command .equals(UPLOAD)){
			interfaz.upload();
			
		}else if(command .equals(SAVE)){
			interfaz.save();
			
		}
//			else if(command .equals(ORDER)){
//		 interfaz.showFrame();
//		}
		else if(command .equals(REPAINT)){
			interfaz.release();
		}
		
	}
}
