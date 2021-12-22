import java.util.Scanner;

public class DaiConnect4 {
	
	static final int RED =1, BLUE=2;
	static int NUM_COLUMNS; 
	static int NUM_IN_ROW; 
	static int firstplayer;
	static int p1=0,p2=0,ties=0;
	static long cnt=0;

	public static void main(String[] args) {
		//prompt user input
		System.out.println("Input 3 to run a 3x3 game or input 4 to run a 4x4 game: ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		if(choice == 3) {
			NUM_COLUMNS = 3; NUM_IN_ROW = 3;
			for (int i=0; i<3; i++) {
				int[ ][ ] list = new int[NUM_COLUMNS][NUM_COLUMNS];
				firstplayer = RED;
				p1=0;p2=0;cnt=0;ties=0;
			    switch(i) {
			    case 0: list[2][0]=RED; break; //  COLUMN 1
			    case 1: list[2][1]=RED; break; //  COLUMN 2
			    case 2: list[2][2]=RED; break; //  COLUMN 3
			    
			    }
			    Play(list , BLUE);
				System.out.println ("NetWins for column " + (i+1) + ": " + (p1-p2));
				System.out.println ("Number of recursion calls: " + cnt);
				System.out.println("Red wins: "+p1 +" Blue Wins: "+p2);
				System.out.println("******************\n");
			}
		}
		if(choice == 4) {
			NUM_COLUMNS = 4; NUM_IN_ROW = 4;
			for (int i=0; i<4; i++) {
				int[ ][ ] list = new int[NUM_COLUMNS][NUM_COLUMNS];
				firstplayer = RED;
				p1=0;p2=0;cnt=0;ties=0;
			    switch(i) {
			    case 0: list[3][0]=RED; break; //  COLUMN 1
			    case 1: list[3][1]=RED; break; //  COLUMN 2
			    case 2: list[3][2]=RED; break; //  COLUMN 3
			    case 3: list[3][3]=RED; break; //  COLUMN 4
			    }
			    Play(list , BLUE);
				System.out.println ("NetWins for column " + (i+1) + ": " + (p1-p2));
				System.out.println ("Number of recursion calls: " + cnt);
				System.out.println("Red wins: "+p1 +" Blue Wins: "+p2);
				System.out.println("******************\n");
			}
		}
	}
	
	public static int Play(int[][] inlist, int clr) {
		cnt++;
		int res=checkBoard(inlist,clr);
		// 0 - board full, 1- RED wins  2 = BLUE wins   3-keep playing
		if (res < 3) { 
			if (res == 0) {ties++;return 0;
			} else {
				if (res == firstplayer) {p1++; return 1;} else {p2++; return -1;}
			}
		}	
		res = 0;

		//   update the board for this move
		for (int row = 0; row<NUM_COLUMNS;row++  ){
			for (int col = 0; col<NUM_COLUMNS;col++  ){
				// Only move when the vacant grid is the lowest one or above a taken grid (gravity)
				if (row == NUM_COLUMNS - 1) {
					if(inlist[row][col] == 0) {
						int[][] clonelist = new int[NUM_COLUMNS][NUM_COLUMNS];
						for (int x = 0;x <NUM_COLUMNS;x++  ){
							for (int y = 0; y<NUM_COLUMNS;y++  ){
								clonelist[x][y] = inlist[x][y] ;
							}
						}
						 
						clonelist[row][col] = clr;
						Play(clonelist, 3- clr);
					}
				}
				else if(row != NUM_COLUMNS - 1) {
					if(inlist[row][col] == 0 && (inlist[row+1][col] == RED || inlist[row+1][col] == BLUE)) {
						int[][] clonelist = new int[NUM_COLUMNS][NUM_COLUMNS];
						for (int x = 0;x <NUM_COLUMNS;x++  ){
							for (int y = 0; y<NUM_COLUMNS;y++  ){
								clonelist[x][y] = inlist[x][y] ;
							}
						}
						 
						clonelist[row][col] = clr;
						Play(clonelist, 3- clr);
					}
				}
			}
		}
		//  recursively call Play
		return res;
	}
	
	
	public static boolean isFull(int[][] inlist){
		boolean empty = true;
		for (int i = 0 ; i<NUM_COLUMNS ; i++ ) {
			for (int i2 = 0 ; i2<NUM_COLUMNS ; i2++ ) {
				if (inlist[i][i2] ==0   ) { empty = false; break;} 
			}
		}
		return empty;
	}
	public static int checkBoard(int[][] inlist ,int clr){
		int chkclr = 3-clr;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			int colcnt = 0;
			for (int j=0; j<NUM_COLUMNS; j++) {
				if (inlist[i][j] == chkclr) {
					colcnt++;
					if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
				}  else {
					colcnt =0;
				}
			}
		}
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			int colcnt = 0;
			for (int j=0; j<NUM_COLUMNS; j++) {
				if (inlist[j][i] == chkclr) {
					colcnt++;
					if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
				}  else {
					colcnt =0;
				}
			}
		}
		int colcnt = 0;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			if (inlist[i][i] == chkclr) {
				colcnt++;
				if (colcnt == NUM_IN_ROW)  {return chkclr;}	 
			}  else {
				colcnt =0;
			}
		}
		colcnt = 0;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			if (inlist[NUM_COLUMNS-1-i][i] == chkclr) {
				colcnt++;
				if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
			}  else {
				colcnt =0;
			}
		}
		if (isFull(inlist)) {  return 0; 
		} else {
			return 3;
		}


	}

}
