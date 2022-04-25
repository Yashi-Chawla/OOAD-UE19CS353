import Jama.*;
import java.io.*;
import java.util.*;
import java.lang.Math;

class LinearRegression
{
    String dataPath;
    Matrix X;
    Matrix Y;
    Matrix theta;

    public void loadDataFromCSV(String dataPath) throws Exception
    {
        File file = new File(dataPath);
        Scanner scanner = new Scanner(file);
        
        ArrayList<ArrayList<Double>> x = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> y = new ArrayList<Double>();
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] lineSplit = line.split(",");
            ArrayList<Double> row = new ArrayList<Double>();
            for (int i = 0; i < lineSplit.length - 1; i++)
            {
                row.add(Double.parseDouble(lineSplit[i]));
            }
            x.add(row);
            y.add(Double.parseDouble(lineSplit[lineSplit.length - 1]));
        }

        System.out.println("Loaded " + x.size() + " rows of data.");
        System.out.println("Loaded " + x.get(0).size() + " columns of data.");
        System.out.println("Loaded " + y.size() + " true values.");
        getMatrices(x, y);
    }

    public void getMatrices(ArrayList x, ArrayList y)
    {
        int rows = x.size();
        int cols = ((ArrayList)x.get(0)).size();
        double[][] x_matrix = new double[rows][cols];
        double[][] y_matrix = new double[rows][1];
        for (int i = 0; i < rows; i++)
        {
            y_matrix[i][0] = (double)y.get(i);
            for (int j = 0; j < cols; j++)
                x_matrix[i][j] = (double)((ArrayList)x.get(i)).get(j);
        }
        this.X = new Matrix(x_matrix);
        this.Y = new Matrix(y_matrix);
    }

    public void train()
    {
        this.theta = this.X.solve(this.Y);
    }

    public double predict(ArrayList x)
    {
        double[][] x_matrix = new double[1][x.size()];
        for (int i = 0; i < x.size(); i++)
            x_matrix[0][i] = (double)x.get(i);
        Matrix X = new Matrix(x_matrix);
        Matrix Y = X.times(this.theta);
        double prediction = Y.get(0, 0);
        return prediction;
    }

    public void displayTheta()
    {
        System.out.println("Theta: ");
        for (int i = 0; i < this.theta.getRowDimension(); i++)
            System.out.print(this.theta.get(i, 0) + " ");
        System.out.println();
    }

    public double calculateLoss()
    {
        Matrix loss = this.Y.minus(this.X.times(this.theta));
        return loss.norm2();
    }
}

// class TestLinearRegression
// {
//     public static void main(String[] args) throws Exception
//     {
//         LinearRegression model = new LinearRegression();
//         model.loadDataFromCSV("data/BostonHousing.csv");
//         model.train();
//         model.displayTheta();
//         System.out.println("MSE: " + model.calculateLoss());

//         double []x = {0.63796, 0, 8.14, 0, 0.538, 6.096, 84.5, 4.4619, 4,307, 21, 380.02, 10.26};
//         ArrayList <Double> X = new ArrayList<Double>();
//         for (int i = 0; i < x.length; i++)
//             X.add(x[i]);
//         System.out.println("Prediction: " + model.predict(X));
//     }
// }