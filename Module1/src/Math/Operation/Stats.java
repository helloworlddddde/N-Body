package Math.Operation;

import Math.Data.Matrix;

public class Stats {

    public static Matrix Sigmoid(Matrix A){
        double[][] tempData = new double[A.getDimRow()][A.getDimCol()];
        for(int r = 0; r < A.getDimRow(); r++){
            for(int c = 0; c < A.getDimCol(); c++){
                tempData[r][c] = 1/(1+Math.exp(-A.getData()[r][c]));
            }
        }
        return new Matrix(tempData);
    }

    public static Matrix Tanh(Matrix A){
        double[][] tempData = new double[A.getDimRow()][A.getDimCol()];
        for(int r = 0; r < A.getDimRow(); r++){
            for(int c = 0; c < A.getDimCol(); c++){
                tempData[r][c] = (Math.exp(2*A.getData()[r][c])-1)/(Math.exp(2*A.getData()[r][c])+1);
            }
        }
        return new Matrix(tempData);
    }

    public static Matrix Softplus(Matrix A){
        double[][] tempData = new double[A.getDimRow()][A.getDimCol()];
        for(int r = 0; r < A.getDimRow(); r++){
            for(int c = 0; c < A.getDimCol(); c++){
                tempData[r][c] = Math.log(1+Math.exp(A.getData()[r][c]));
            }
        }
        return new Matrix(tempData);
    }

    public static Matrix Softmax(Matrix A){
        double[][] tempData = new double[A.getDimRow()][A.getDimCol()];
        double sum = 0;
        for(int r = 0; r < A.getDimRow(); r++){
            for(int c = 0; c < A.getDimCol(); c++){
                sum += Math.exp(A.getData()[r][c]);
            }
        }
        for(int r = 0; r < A.getDimRow(); r++){
            for(int c = 0; c < A.getDimCol(); c++){
                tempData[r][c] = Math.exp(A.getData()[r][c]) / sum;
            }
        }
        return new Matrix(tempData);
    }

    public static double crossEntropy(Matrix Actual, Matrix Expected){
        double sum = 0;
        for(int r = 0; r < Actual.getDimRow(); r++){
            for(int c = 0; c < Actual.getDimCol(); c++){
                sum += Expected.getData()[r][c]*Math.log(Actual.getData()[r][c]);
            }
        }
        return -1*sum;
    }

    public static Matrix Identity(Matrix A){
        return A;
    }


}
