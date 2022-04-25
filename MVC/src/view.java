import javax.swing.*;
import java.awt.event.ActionListener;

class ApplicationView extends JFrame
{
	private JLabel labelPath = new JLabel("Dataset Path", SwingConstants.CENTER);
	private JTextField dataPath = new JTextField(30);
	private JButton trainButton = new JButton("Train");
	private JLabel labelInput = new JLabel("Input Values");
	private JTextField inputField = new JTextField(35);
	private JButton predictButton = new JButton("Predict");

	ApplicationView()
	{
		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 220);
  		this.setLocationRelativeTo(null);

		panel.add(labelPath);
		panel.add(dataPath);
		panel.add(labelInput);
		panel.add(inputField);
		panel.add(trainButton);
		panel.add(predictButton);
		this.add(panel);
	}
	
	public String getDataPath(){
		String path = dataPath.getText();
		if (path.equals(""))
			JOptionPane.showMessageDialog(null, "Please enter path to dataset!");
		else
			return path;
		return null;
	}

	public String getInputValues(){
		String inputValues = inputField.getText();
		if (inputValues.equals(""))
			JOptionPane.showMessageDialog(null, "Please enter values to predict!");
		else
			return inputValues;
		return null;
	}

	public void addTrainListener(ActionListener listenerForTrainButton)
	{
		trainButton.addActionListener(listenerForTrainButton);
	}

	public void addPredictListener(ActionListener listenerForPredictButton){
		predictButton.addActionListener(listenerForPredictButton);
	}

	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}