import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


@SuppressWarnings("serial")
public class Tip_Calculator extends JFrame {
	public Tip_Calculator() {
		setSize(500, 400);
		setTitle("Tip Calculator");
		setVisible(true);
	}
	public class MyClass_JSlider extends JFrame {
		public void MyClass_JSLider() {
			setSize(500, 200);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tip_Calculator demo = new Tip_Calculator();
		JLabel title = new JLabel("The Tip Calculator", JLabel.CENTER);
		Font title1 = new Font("Courier", Font.BOLD, 40);
		title.setFont(title1);
		
		//update styling


		JLabel bill_Amount = new JLabel("Bill Amount:");
		JTextField txt_Bill = new JTextField(10);
		bill_Amount.setLabelFor(bill_Amount);


		JLabel lbltipPercent = new JLabel("Tip Percent:");
		JTextField txtip_Percent = new JTextField(10);
		lbltipPercent.setLabelFor(lbltipPercent);
		/*tipPercent.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				}

				);*/
		      /*tipPercent.addKeyListener(
		 			new KeyAdapter() {
		 				public void keyPressed(KeyEvent e) {
		 					if(e.getKeyCode() == KeyEvent.VK_ENTER)
		  							button.doClick()}});*/
		 		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 15);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						JSlider slider = (JSlider) e.getSource();
						txtip_Percent.setText(
								String.valueOf(slider.getValue()));
						txtip_Percent.getSize(slider.getSize());
					}
						
				}
		         );

		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		
		JLabel people = new JLabel("Number of people");
		JTextField num_of_ppl = new JTextField(10);
		people.setLabelFor(people);
		
		
		
		JLabel lblbillTtl = new JLabel("Bill Total");
		JTextField txtbill_ttl = new JTextField(10);
		lblbillTtl.setLabelFor(lblbillTtl);
		
		JLabel billper = new JLabel("Bill Per Person");
		JTextField billperson = new JTextField(10);
		billper.setLabelFor(billper);
		
		JLabel tip_person = new JLabel("Tip Per Person");
		JTextField tip_person2 = new JTextField(10);
		tip_person.setLabelFor(tip_person);

		JButton button = new JButton("Calculate");	
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						double billTotal;
						double bill_per_person;
						double tip_per_person;
						double less_tip;
						//billTotal = bill amount * (1+tip_percent/100)
						billTotal = Double.parseDouble(txt_Bill.getText())*(1 + Double.parseDouble(txtip_Percent.getText() )/100.0);
						txtbill_ttl.setText(String.format("%2.2f", billTotal));
						bill_per_person = Double.parseDouble(txtbill_ttl.getText()) /(Integer.parseInt(num_of_ppl.getText()));
						billperson.setText(String.format("%2.2f", bill_per_person));
						less_tip = billTotal - Double.parseDouble(txt_Bill.getText());
						//For testing purposes System.out.println(less_tip);
						tip_per_person = Math.round(less_tip )/ Integer.parseInt(num_of_ppl.getText());
						tip_person2.setText(String.format("%2.2f", tip_per_person));

					};
				});
		


		JPanel titlePanel = new JPanel(new FlowLayout() );
		titlePanel.add(title);
		
		JPanel panel = new JPanel(new GridLayout(7, 3, 5, 5));
		panel.add(bill_Amount);
		panel.add(txt_Bill);
		panel.add(lbltipPercent);
		panel.add(txtip_Percent);
		//Version 1
		//panel.add(slider);
		//panel.add(button);
		panel.add(people);
		panel.add(num_of_ppl);
		//Version 2
		panel.add(slider);
		panel.add(button);
		panel.add(lblbillTtl);
		panel.add(txtbill_ttl);
		panel.add(tip_person);
		panel.add(tip_person2);
		panel.add(billper);
		panel.add(billperson);
		

		JPanel mainPanel = new JPanel(new BorderLayout() );
		mainPanel.add(title, BorderLayout.NORTH);
		mainPanel.add(panel, BorderLayout.CENTER);
		demo.getContentPane().add(mainPanel);
		demo.setVisible(true);

	}

}

