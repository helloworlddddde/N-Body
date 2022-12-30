package Math.Data;

public class Matrix {
    private int dimRow;
    private int dimCol;
    private double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
        double[][] tempData = data;
        this.dimRow = tempData.length;
        this.dimCol = tempData[0].length;

    }
    public Matrix(double[] data){
        double[][] tempData = new double[1][data.length];
        tempData[0] = data;
        this.data = tempData;
        this.dimRow = 1;
        this.dimCol = data.length;
    }
    public Matrix(){
        assert true;
    }
    @Override
    public String toString(){
        String output = "";
        for(int r = 0; r < dimRow; r++){
            output += "[ ";
            for(int c = 0; c < dimCol; c++){
                output += getData()[r][c] + " ";
            }
            output += "] \n";



        }
        return output;
    }
    public int getDimRow(){
        return this.dimRow;
    }

    public int getDimCol() {
        return dimCol;
    }

    public double[][] getData() {
        return data;
    }

    public void setDimRow(int dimRow) {
        this.dimRow = dimRow;
    }

    public void setDimCol(int dimCol) {
        this.dimCol = dimCol;
    }

    public void setData(double[][] data) {
        this.data = data;
        this.dimRow = data.length;
        this.dimCol = data[0].length;
    }

    public Matrix getRow(int r) throws Exception{
        if(r >= dimRow){
            throw new Exception("The row doesn't exist");
        }
        double[][] tempData = new double[][]{data[r]};
        return new Matrix(tempData);
    }

    public Matrix getCol(int c) throws Exception{
        if(c >= dimCol){
            throw new Exception("This column doesn't exist");
        }
        double[][] tempData = new double[dimRow][1];
        for(int r = 0; r < dimRow; r++){
            tempData[r][0] = data[r][c];
        }
        return new Matrix(tempData);
    }

    public int getSize(){
        return dimRow * dimCol;
    }



}