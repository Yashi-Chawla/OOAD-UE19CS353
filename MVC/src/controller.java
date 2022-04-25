import java.io.*;
import java.util.*;
import java.lang.Math;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Application
{
    Application controller;
    ApplicationView view;
    LinearRegression model;
    Application()
    {
        this.view = new ApplicationView();
        this.view.addTrainListener(new TrainListener());
        this.view.addPredictListener(new PredictListener());
        this.view.setTitle("Yashi Chawla PES1UG19CS592");
    }

    public static void main(String[] args)
    {

        Application controller = new Application();
        controller.startApplication();
    }

    public void startApplication(){
        this.view.setVisible(true);
    }

    public LinearRegression createLinearRegressionModel(String dataPath)
    {
        LinearRegression model = new LinearRegression();
        try
        {
            model.loadDataFromCSV(dataPath);
            model.train();
            System.out.println("Training finished!");
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return model;
    }

    public double predict(LinearRegression model, String values)
    {
        String[] valuesSplit = values.split(",");
        ArrayList<Double> x = new ArrayList<Double>();
        for (int i = 0; i < valuesSplit.length; i++)
            x.add(Double.parseDouble(valuesSplit[i]));
        double prediction = model.predict(x);
        return prediction;
    }

    class TrainListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String dataPath = view.getDataPath();
            if (dataPath != null){
                model = createLinearRegressionModel(dataPath);
                view.displayErrorMessage("Training finished!");
            }
        }
    }

    class PredictListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String values = view.getInputValues();
            if (values != null){
                double prediction = predict(model, values);
                prediction = Math.round(prediction * 1000.0) / 1000.0;
                view.displayErrorMessage("Prediction: " + prediction);
            }
        }
    }
}