package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P036_ValidSudoku {
	 public static boolean isValidSudoku(char[][] board) {
		 boolean status=true;
		 int row=board.length;
		 int col=board[0].length;
		 //check 3*3
		 for(int i=0;i<row;i=i+3) {
			 char[] r1=board[i];
			 char[] r2=board[i+1];
			 char[] r3=board[i+2];
			 for(int j=0;j<col;j=j+3) {
				 List<Character> list = new ArrayList<>(List.of(r1[j],r1[j+1],r1[j+2],r2[j],r2[j+1],r2[j+2],r3[j],r3[j+1],r3[j+2]));
				 List<Character> l= list.stream().filter(k->k!='.').collect(Collectors.toList());
				 Set<Character> s= new HashSet<Character>(l);
				 if(l.size() != s.size()) {
					 status =false;
					 return false;
				 }
			 }
		 }
		 
		//check col
		 for(int i=0;i<9;i++) {
			 int j=0;
			 List<Character> list = new ArrayList<>(List.of(board[i][j],board[i][j+1],board[i][j+2],board[i][j+3],board[i][j+4],board[i][j+5],board[i][j+6],board[i][j+7],board[i][j+8]));
			 List<Character> l= list.stream().filter(k->k!='.').collect(Collectors.toList());
			 Set<Character> s= new HashSet<Character>(l);
			 if(l.size() != s.size()) {
				 status =false;
				 return false;
			 }
		 }
		 //check row
		 for(int j=0;j<9;j++) {
			 int i=0;
			 List<Character> list = new ArrayList<>(List.of(board[i][j],board[i+1][j],board[i+2][j],board[i+3][j],board[i+4][j],board[i+5][j],board[i+6][j],board[i+7][j],board[i+8][j]));
			 List<Character> l= list.stream().filter(k->k!='.').collect(Collectors.toList());
			 Set<Character> s= new HashSet<Character>(l);
			 if(l.size() != s.size()) {
				 status =false;
				 return false;
			 }
		 }		 
		 
	     return status;   
	    }

	public static void main(String[] args) {
		char [][]board = new char[][]
				{{'5','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'.','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}};
				
			System.out.println(isValidSudoku(board));
			
			char[][] board1= new char[][]
			{{'8','3','.','.','7','.','.','.','.'}
			,{'6','.','.','1','9','5','.','.','.'}
			,{'.','9','8','.','.','.','.','6','.'}
			,{'8','.','.','.','6','.','.','.','3'}
			,{'4','.','.','8','.','3','.','.','1'}
			,{'7','.','.','.','2','.','.','.','6'}
			,{'.','6','.','.','.','.','2','8','.'}
			,{'.','.','.','4','1','9','.','.','5'}
			,{'.','.','.','.','8','.','.','7','9'}};
			System.out.println(isValidSudoku(board1));
			
			char [][]board2 = new char[][]
			{{'.','.','4','.','.','.','6','3','.'}
			,{'.','.','.','.','.','.','.','.','.'}
			,{'5','.','.','.','.','.','.','9','.'}
			,{'.','.','.','5','6','.','.','.','.'}
			,{'4','.','3','.','.','.','.','.','1'}
			,{'.','.','.','7','.','.','.','.','.'}
			,{'.','.','.','5','.','.','.','.','.'}
			,{'.','.','.','.','.','.','.','.','.'}
			,{'.','.','.','.','.','.','.','.','.'}};
			System.out.println(isValidSudoku(board2));

			
			char [][]board3 = new char[][]
					{{'7','.','.','.','4','.','.','.','.'}
					,{'.','.','.','8','6','5','.','.','.'}
					,{'.','1','.','2','.','.','.','.','.'}
					,{'.','.','.','.','.','9','.','.','.'}
					,{'.','.','.','.','5','.','5','.','.'}
					,{'.','.','.','.','.','.','.','.','.'}
					,{'.','.','.','.','.','.','2','.','.'}
					,{'.','.','.','.','.','.','.','.','.'}
					,{'.','.','.','.','.','.','.','.','.'}};
					System.out.println(isValidSudoku(board3));
			
	}

}
