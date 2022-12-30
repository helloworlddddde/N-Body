package Math.Operation;

import Math.Data.Matrix;

import java.util.Random;

public class Linalg {

    public static Matrix matAdd(Matrix A, Matrix B) throws Exception {
        if (A.getDimRow() != B.getDimRow() || A.getDimCol() != B.getDimCol()) {
            throw new Exception("Cannot add matrices of different dimensions");
        }
        double[][] tempData = new double[A.getDimRow()][A.getDimCol()];
        for (int r = 0; r < A.getDimRow(); r++) {
            for (int c = 0; c < A.getDimCol(); c++) {
                tempData[r][c] = A.getData()[r][c] + B.getData()[r][c];
            }
        }
        return new Matrix(tempData);
    }

    public static Matrix matSub(Matrix A, Matrix B) throws Exception {
        if (A.getDimRow() != B.getDimRow() || A.getDimCol() != B.getDimCol()) {
            throw new Exception("Cannot add matrices of different dimensions");
        }
        for (int r = 0; r < A.getDimRow(); r++) {
            for (int c = 0; c < A.getDimCol(); c++) {
                A.getData()[r][c] = A.getData()[r][c] - B.getData()[r][c];
            }
        }
        return new Matrix(A.getData());
    }

    public static Matrix sMul(double scalar, Matrix A) {
        for (int r = 0; r < A.getDimRow(); r++) {
            for (int c = 0; c < A.getDimCol(); c++) {
                A.getData()[r][c] = scalar * A.getData()[r][c];
            }
        }
        return new Matrix(A.getData());
    }

    public static Matrix sAdd(double scalar, Matrix A){
        for (int r = 0; r < A.getDimRow(); r++) {
            for (int c = 0; c < A.getDimCol(); c++) {
                A.getData()[r][c] = scalar + A.getData()[r][c];
            }
        }
        return new Matrix(A.getData());

    }

    public static Matrix matMul(Matrix A, Matrix B) throws Exception {
        if (A.getDimCol() != B.getDimRow()) {
            throw new Exception("Invalid Dimensions for Matrix Multiplication");
        }
        double[][] tempData = new double[A.getDimRow()][B.getDimCol()];
        for (int r = 0; r < A.getDimRow(); r++) {
            for (int c = 0; c < B.getDimCol(); c++) {
                tempData[r][c] = eMul(A.getRow(r), transpose(B.getCol(c)));
            }
        }
        return new Matrix(tempData);
    }

    public static double eMul(Matrix A, Matrix B) throws Exception {
        if (A.getDimRow() != B.getDimRow() || A.getDimCol() != B.getDimCol()) {
            throw new Exception("Invalid Dimensions for Element-wise Multiplication");
        }
        double sum = 0;
        for (int r = 0; r < A.getDimRow(); r++) {
            for (int c = 0; c < B.getDimCol(); c++) {
                sum += A.getData()[r][c] * B.getData()[r][c];
            }
        }
        return sum;
    }

    public static Matrix transpose(Matrix A) {
        double[][] tempData = new double[A.getDimCol()][A.getDimRow()];
        for (int r = 0; r < A.getDimRow(); r++) {
            for (int c = 0; c < A.getDimCol(); c++) {
                tempData[c][r] = A.getData()[r][c];
            }
        }
        return new Matrix(tempData);
    }

    public static Matrix randMat(int dimRow, int dimCol, String type) {
        double[][] tempData = new double[dimRow][dimCol];
        switch (type) {
            case "Xavier":
                for (int r = 0; r < dimRow; r++) {
                    for (int c = 0; c < dimCol; c++) {
                        tempData[r][c] = 2 * (Math.random() - 0.5) * (1 / Math.sqrt(dimRow * dimCol));
                    }
                }

            case "Zero":
                assert true;

            case "Gaussian":
                Random rand = new Random();
                for (int r = 0; r < dimRow; r++) {
                    for (int c = 0; c < dimCol; c++) {
                        tempData[r][c] = rand.nextGaussian();
                    }
                }

        }
        return new Matrix(tempData);
    }

    public static double mag(Matrix A) throws Exception {
        return Math.sqrt(eMul(A, A));
    }

    public static Matrix normalize(Matrix A) throws Exception {
        if (mag(A) == 0) {
            return A;
        }
        return sMul(1 / mag(A), A);
    }

    public static Matrix lComb(Matrix A, Matrix B, Matrix C) throws Exception {
        return matAdd(matMul(A, B), C);
    }

    public static Matrix identityMat(int n){
        double[][] tempData = new double[n][n];
        for(int i = 0; i < n; i++){
            tempData[i][i] = 1;
        }
        return new Matrix(tempData);
    }

    public static Matrix Identity(Matrix A, Matrix B, Matrix C){
        return A;
    }











}
