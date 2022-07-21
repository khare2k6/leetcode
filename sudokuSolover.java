//Difficulty:Hard
//Problem no:37. Sudoku Solver
class Solution {
    public int max_row=0;
    public int max_col=0;
    public void solveSudoku(char[][] board) {
        max_row = board.length;
        max_col = board[0].length;
        findNumber(0,0,board);
    }
    
    
    public boolean findNumber(int row,int col,char[][] board){
        // System.out.println("findNumber->row="+row+",col="+col);
        if(row == 9 && col == 9){
            return true;
        }
        
        if(col == 9){
            row++;
            col = 0;
        }
        if(row>= 9)
            return true;
        
        if(board[row][col]=='.'){
            for(int i=1;i<=9;i++){
                char c = Character.forDigit(i, 10);
                if(isValidNo(row,col,c,board)){
                    board[row][col] = c;
                    boolean ret = findNumber(row,col+1,board);
                    if(ret) return true;
                }
                // System.out.println("Reverting for "+row+","+col);
                board[row][col] = '.';
            }
            
        }else{
            boolean ret = findNumber(row,col+1,board);
            if(ret) return true;
        }
        return false;
    }
    
    
    public boolean isValidNo(int row, int col,char val, char[][] board){
        return (isRowValid(row,val,board) && isColValid(col,val,board) && isSquareValid(row,col,val,board));
    }
    public boolean isRowValid(int row,char val, char[][] board){
         // System.out.println("isRowValid");
        for(int i=0;i<max_row;i++){
            if(val == board[row][i]){
                // System.out.println("isRowValid->found "+val+" in row:"+row);
                return false;
            }
        }
        return true;
    }
    
    public boolean isColValid(int col,char val, char[][] board){
         // System.out.println("isColValid");
        for(int i=0;i<max_col;i++){
            if(val == board[i][col]){
                // System.out.println("isColValid->found "+val+" in col:"+col);
                return false;
            }
        }
        return true;
    }
    
    public boolean isSquareValid(int row,int col,char val,char[][] board){
         // System.out.println("isSquareValid");
        int box_row = row/3;
        int box_col = col/3;
        
        int row_start = box_row*3;
        int row_end = row_start+3;
        
        int col_start = box_col*3;
        int col_end = col_start+3;
        
        for(int i=row_start;i<row_end;i++){
            for(int j=col_start;j<col_end;j++){
                if(board[i][j] == val){
                    // System.out.println("isSquareValid->found "+val+" in "+box_row+"_"+box_col);
                    return false;
                }
            }
        }
        return true;
    }
}
