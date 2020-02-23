package com.ds.graph;

/** Find the number of islands , islands are the connected components.
 *                                  { { 1, 1, 0, 0, 0 },
*                                   { 0, 1, 0, 0, 1 },
*                                   { 1, 0, 0, 1, 1 },
*                                   { 0, 0, 0, 0, 0 },
*                                   { 1, 0, 1, 0, 1 } };
 *
 *                                 ans = 5
 */
public class ConnectedComponentIsland {
    static int row, col;
    boolean checkBoundaries(int i, int j, int matrix[][], boolean visited[][]) {
        if(i>=0 && i<row && j>=0 && j<col && (matrix[i][j]==1 && !visited[i][j] ) ) {
            return true;
        }
        return false;
    }

    void DFSUtil(int i, int j, int matrix[][], boolean visited[][]) {

        int rowNav[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNav[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[i][j] = true;
        for(int dir=0; dir<8; dir++) {
            if(checkBoundaries(i+rowNav[dir], j+colNav[dir], matrix, visited)) {
                DFSUtil(i+rowNav[dir], j+colNav[dir], matrix, visited);
            }
        }
    }

    public int findConnectedComponent(int matrix[][]){
        boolean visited[][] = new boolean[row][col];
        int count = 0 ;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j]==1 && !visited[i][j]) {
                    DFSUtil(i, j, matrix, visited);
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        ConnectedComponentIsland island = new ConnectedComponentIsland();
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        row = 5;
        col = 5;
        int result = island.findConnectedComponent(M);
        System.out.println("The number of islands in the given matrix " + result);
    }
}
