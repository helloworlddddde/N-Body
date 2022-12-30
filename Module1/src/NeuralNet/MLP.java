package NeuralNet;

import Math.Data.Matrix;
import Math.Operation.ErrorInterface;
import Math.Operation.Linalg;

import java.util.ArrayList;
import java.util.Objects;

public class MLP {
    private ArrayList<Layer> layers;
    private ErrorInterface error;

    public MLP(ErrorInterface error){
        this.layers = new ArrayList<Layer>();
        this.error = error;
    }

    public Matrix feedForward(Matrix input) throws Exception {
        Matrix output = input;
        for(int i = 0; i < layers.size(); i++){
            output = layers.get(i).feed(output);
        }
        return output;
    }

    public double computeError(Matrix actual, Matrix expected) throws Exception {
        return error.Error(actual, expected);
    }

    public void addLayer(Layer layer){
        this.layers.add(layer);
    }

    public void backProp(Matrix input, Matrix expected, double h, double lR) throws Exception {

        for(int i = 0; i < layers.size(); i++){
            Layer L = layers.get(i);
            Matrix dW = new Matrix(new double[L.getWeights().getDimRow()][L.getWeights().getDimCol()]);
            Matrix W = L.getWeights();
            for(int r = 0; r < L.getWeights().getDimRow(); r++){
                for(int c = 0; c < L.getWeights().getDimCol(); c++){
                    W.getData()[r][c] += h;
                    double f2 = computeError(feedForward(input), expected);
                    W.getData()[r][c] -= 2*h;
                    double f1 = computeError(feedForward(input), expected);
                    dW.getData()[r][c] = (f2 - f1)/(2*h);
                    W.getData()[r][c] += h;
                }
            }

            L.setdW(dW);
            Matrix dB = new Matrix(new double[L.getBiases().getDimRow()][L.getBiases().getDimCol()]);
            Matrix B = L.getBiases();
            for(int r = 0; r < L.getBiases().getDimRow(); r++){
                for(int c = 0; c < L.getBiases().getDimCol(); c++){
                    B.getData()[r][c] += h;
                    double f2 = computeError(feedForward(input), expected);
                    B.getData()[r][c] -= 2*h;
                    double f1 = computeError(feedForward(input), expected);
                    dB.getData()[r][c] = (f2 - f1)/(2*h);
                    B.getData()[r][c] += h;
                }
            }
            L.setdB(dB);



        }
        updateWeight(lR);
    }

    private void updateWeight(double lR) throws Exception {
        for(int i = 0; i < layers.size(); i++){
            Layer L = layers.get(i);
            L.setWeights(Linalg.sMul(lR, Linalg.matSub(L.getWeights(), L.getdW())));
            L.setBiases(Linalg.sMul(lR, Linalg.matSub(L.getBiases(), L.getdB())));
        }
    }


}
