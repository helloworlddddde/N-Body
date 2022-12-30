package NeuralNet;

import Math.Data.Matrix;
import Math.Operation.ActivationInterface;
import Math.Operation.CombinationInterface;
import Math.Operation.Linalg;

    public class Layer {
    private int inputDim;
    private int wRow;
    private int wCol;
    private Matrix weights;
    private Matrix dW;
    private Matrix biases;
    private Matrix dB;
    private ActivationInterface activate;
    private CombinationInterface combine;
    private String aType;
    private String cType;

    public Layer(int inputData, int wRow, int wCol, ActivationInterface activate, CombinationInterface combine){
        this.inputDim = inputData;
        this.wRow = wRow;
        this.wCol = wCol;
        this.activate = activate;
        this.combine = combine;
        this.weights = Linalg.randMat(inputDim, wCol, "Xavier");
        this.biases = Linalg.randMat(1, wCol, "Xavier");
    }

    public Layer(int inputData, int wCol, ActivationInterface activate, CombinationInterface combine, String aType, String cType){
        this.inputDim = inputData;
        this.wCol = wCol;
        this.activate = activate;
        this.combine = combine;
        this.weights = Linalg.randMat(wRow, wCol, "Xavier");
        this.biases = Linalg.randMat(1, wCol, "Xavier");
        this.aType = aType;
        this.cType = cType;
    }



    public Matrix feed(Matrix input) throws Exception {
        Matrix output = activate.Activate(input);
        output = combine.Combine(output, weights, biases);
        return output;
    }

        public int getInputDim() {
            return inputDim;
        }

        public void setInputDim(int inputDim) {
            this.inputDim = inputDim;
        }

        public int getwRow() {
            return wRow;
        }

        public void setwRow(int wRow) {
            this.wRow = wRow;
        }

        public int getwCol() {
            return wCol;
        }

        public void setwCol(int wCol) {
            this.wCol = wCol;
        }

        public Matrix getWeights() {
            return weights;
        }

        public void setWeights(Matrix weights) {
            this.weights = weights;
        }

        public Matrix getdW() {
            return dW;
        }

        public void setdW(Matrix dW) {
            this.dW = dW;
        }

        public Matrix getBiases() {
            return biases;
        }

        public void setBiases(Matrix biases) {
            this.biases = biases;
        }

        public Matrix getdB() {
            return dB;
        }

        public void setdB(Matrix dB) {
            this.dB = dB;
        }

        public ActivationInterface getActivate() {
            return activate;
        }

        public void setActivate(ActivationInterface activate) {
            this.activate = activate;
        }

        public CombinationInterface getCombine() {
            return combine;
        }

        public void setCombine(CombinationInterface combine) {
            this.combine = combine;
        }

        public String getaType() {
            return aType;
        }

        public void setaType(String aType) {
            this.aType = aType;
        }

        public String getcType() {
            return cType;
        }

        public void setcType(String cType) {
            this.cType = cType;
        }

        @Override
        public String toString(){
            return
                    "Input Dimension = 1 x " + inputDim + "\n"
                    + "Weight Dimension = " + wRow + " x " + wCol + "\n"
                    + "Bias Dimension = " + biases.getDimRow() + " x " + biases.getDimCol() + "\n"
                    + "Activation Function = " + aType + "\n"
                    + "Combination Function = " + cType + "\n";
        }
    }
