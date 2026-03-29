class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // create the bounds for our binary search
        // we treat the matrix as a 1D array
        int low = 0, high = (matrix.length * matrix[0].length) - 1;

        while(low <= high){
            // we set what the middle will be in the matrix
            // since a 1D matrix we find the middle index
            int middle = low + (high - low) / 2;
            // given the middle index, we find the position in the matrix and its value
            // to create this middle index to matrix coordinates we compute the row as middle / number of rows and the column as middle % number of columns
            int middleValue = matrix[middle / matrix[0].length][middle % matrix[0].length];
            if(middleValue == target) return true;
            else if(target > middleValue) low = middle + 1;
            else high = middle - 1;
        }

        return false;
    }
}

