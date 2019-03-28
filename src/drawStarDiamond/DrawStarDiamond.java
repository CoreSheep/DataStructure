package drawStarDiamond;

/**
 * draw star diamond
 * input: numLines
 * output: print star pattern
 */
public class DrawStarDiamond {
    public static void main(String[] args){
        int n = 9;
        drawStarDiamond(n);

    }

    /**
     * method for draw star diamond
     * @param rows -- how many rows should I print?
     */
    public static void drawStarDiamond(int rows){

        //check for illegal parameter
        if(rows<=0 || rows>30){
            System.out.println("Input row must be ranged from 1 to 30.");
            throw new IllegalArgumentException(); }
        // special operation when row is 1 or 2
        if(rows == 1)
            System.out.print("*");
        else if(rows == 2)
            System.out.print("**");
        // when row is ranged from 3 to 30
        else {
                //print 1st row to the medium of the rows
                for(int row = 1; row <= rows; row++){
                    int numBlank = 0, numStar = 0;
                     if(row <= rows >> 1) {
                         //print blank
                        while (numBlank++ < ((rows-1)/2 - (2*row -1)/2))
                            System.out.print(" ");
                         //print star
                        while (numStar++ < (row << 1) - 1)
                            System.out.print("*");
                     }
                     //print the rest rows of the patter
                     else {
                         //print blank
                         while (numBlank++ < (row - rows/2 - 1))
                             System.out.print(" ");
                         //print star
                         while (numStar++ < (2 * (rows - row + 1) - 1 ))
                            System.out.print("*");

                }
                    System.out.println();  // add new line for every row
                }

            }
        }

}
