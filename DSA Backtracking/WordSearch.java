
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // Step 1: try to find the word starting from each cell
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
               if (dfs(board, word, visited, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        // Step 2: base case - if all characters are matched
        if (index == word.length()) return true;

        //step 3: Boundary check + already visited + wrong char
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col]
         != word.charAt(index)) {
            return false;
         }
        
         // Step 4: mark this cell as visited
        visited[row][col] = true;
        
        // Step 5: Explore 4 directions
        boolean found = dfs(board, word, visited, row + 1, col, index + 1) ||
                        dfs(board, word, visited, row - 1, col, index + 1) ||
                        dfs(board, word, visited, row, col - 1, index + 1);

        // Step 6: Backtrack = unmark the cell
        visited[row][col] = false;
        
        return found;
    }
}