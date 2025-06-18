
public class MatrixPaths {
    static int countPaths(int i, int j, int n, int m) {
        
        //Base case: reached bottom-right cell
        if (i == n - 1 && j == m - 1) return 1;

        //Boundary condition: out of bounds
        if (i >= n || j >= m) return 0;

        //try moving right and down
        int right = countPaths(i, j + 1, n, m);
        int down = countPaths(i + 1, j, n, m);

        return right + down;       
    }

    public static void main(String[] args) {
        int n = 7, m = 7; // 3*3 grid 
        int totalPaths = countPaths(0, 0, n, m);
        System.out.println("Total unique paths: " + totalPaths);
    }
}