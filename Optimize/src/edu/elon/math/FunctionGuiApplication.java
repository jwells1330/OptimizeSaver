package edu.elon.math;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import sun.swing.UIAction;


public class FunctionGuiApplication implements Observer{

	private static JFrame frame;
	
	private static JPanel panel;
	private static JLabel label;
	private static JTextField textField;
	private static JButton button;
	
	private static Function func;
	Observable observable;
	private static FunctionGuiApplication functionGui;

	
	public static void main(String[] args){
		functionGui = new FunctionGuiApplication(func);

		ArrayList<String> optimizerList = functionGui.getEnvs();

		
		JFrame dellFrame = functionGui.makeFrame(func = new Dell());
		dellFrame.setSize(400, 200);
		JFrame samsFrame = functionGui.makeFrame(func = new SamsClub());
		samsFrame.setSize(400, 200);
		samsFrame.setLocation(0, 220);
		JFrame minFrame = functionGui.makeFrame(func = new MinimumAbsoluteSum());
		minFrame.setSize(400, 400);
		minFrame.setLocation(400,0);
		
		functionGui.makePanel1(optimizerList, dellFrame);
		functionGui.makePanel1(optimizerList, samsFrame);
		functionGui.makePanel1(optimizerList, minFrame);
		
		functionGui.makePanel2(dellFrame, func = new Dell());
		functionGui.makePanel2(samsFrame, func = new SamsClub());
		functionGui.makePanel2(minFrame, func = new MinimumAbsoluteSum());
		
		
		functionGui.makePanel3(dellFrame, func = new Dell());
		functionGui.makePanel3(samsFrame, func = new SamsClub());
		functionGui.makePanel3(minFrame, func = new MinimumAbsoluteSum());
		
		functionGui.makePanel4(dellFrame, func = new Dell());
		functionGui.makePanel4(samsFrame, func = new SamsClub());
		functionGui.makePanel4(minFrame, func = new MinimumAbsoluteSum());
		
		
		functionGui.displayGui(dellFrame);
		functionGui.displayGui(samsFrame);
		functionGui.displayGui(minFrame);
	}

	public FunctionGuiApplication(Observable observable){
		this.observable = observable;
		observable.addObserver(functionGui);
	}
	
	@Override
	public void update(Observable obs, Object arg){
		System.out.println("Test1");
		if(obs instanceof Function){
			func = (Function)obs;
			System.out.println(func.getOutput());
		}
	}
	public ArrayList<String> getEnvs(){
		ArrayList<String> optimizerList = new ArrayList<String>();
		String optimizers = System.getenv("optimizers");
		while(optimizers.contains(":")){
			optimizerList.add(optimizers.substring(0, optimizers.indexOf(":")));
			optimizers = optimizers.substring(optimizers.indexOf(":")+1);
		}
		return optimizerList;
	}
	
	private JFrame makeFrame(Function func) {
		frame = new JFrame(func.getTitle());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		return frame;
	}
	
	private void makePanel1(ArrayList<String> optimizerList, JFrame frame) {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		label = new JLabel("Technique");
		panel.add(label, BorderLayout.LINE_START);
		
		JComboBox techniquesSelecter = new JComboBox(optimizerList.toArray());
		panel.add(techniquesSelecter);
		
		frame.add(panel);
	}
	private void makePanel2(JFrame frame, Function func){
		ArrayList<String> names = func.getInputNames();
		ArrayList<Double> values = func.getInputValues();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		for(int i = 0; i<names.size(); i++){
			panel = new JPanel();
			panel.setLayout(new BorderLayout());
			label = new JLabel(names.get(i));
			panel.add(label, BorderLayout.LINE_START);
			textField = new JTextField();
			textField.setText("" + values.get(i));
			panel.add(textField);
			panel2.add(panel);
		}
		panel2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		JScrollPane scroller = new JScrollPane(panel2);
		frame.add(scroller);
	}
	
	private void makePanel3(JFrame frame, Function func){
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		label = new JLabel("Result");
		panel.add(label, BorderLayout.LINE_START);
		textField = new JTextField();
		panel.add(textField);
		panel3.add(panel, BorderLayout.CENTER);
		
		frame.add(panel3);
	}
	
	private void makePanel4(JFrame frame, Function func){
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		button = new JButton("Solve");
		button.addActionListener(new UIAction(null) {
			@Override
			public void actionPerformed(ActionEvent e) {
				func.evaluate();
			}
		});
		panel.add(button);
		button = new JButton("Optimize");
		panel.add(button);
		
		panel4.add(panel, BorderLayout.CENTER);
		
		frame.add(panel4);
	}

	
	private void displayGui(JFrame frame){
		frame.setVisible(true);
	}
}
