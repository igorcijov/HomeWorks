package homework14;

public class SumMatrixV2 {
    public Integer execute(String[][] matrix, int size) throws MyArraySizeException, MyArrayDataException {
        validateSize(matrix, size);

        int sum = 0;
        int value;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                try {
                    value = Integer.parseInt(matrix[row][column]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(row, column);
                }
                sum += value;
            }
        }
        return sum;
    }
    public void validateSize(String[][] matrix, int size) throws MyArraySizeException{
        if(matrix.length != size){
            throw new MyArraySizeException(matrix.length,size);
        }
        for (String[] strings : matrix) {
            if (strings.length != size) {
                throw new MyArraySizeException(strings.length, size);
            }
        }
    }
}
