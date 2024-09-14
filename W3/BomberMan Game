import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    /*
     * Since detonations take place only at odd times, if n (the number of seconds) is even,
     * the grid is composed only of O (gridAtEvenTimes).
     * At n == 1, no detonations take place, so the grid is the starting grid (initialGrid).
     * At n == 3, the first detonation happens (gridAfterFirstDetonation).
     * After this second, we note that there is a recurrent pattern that repeat itself every 4 seconds: 
     * - at n == 5, 9, 13, ... (i.e. when n % 4 == 1), the grid is equal to gridAfterSecondDetonation
     * - at n == 7, 11, 15, ... (i.e when n % 4 == 3), the grid is equal to gridAfterThirdDetonation
     */
    public static List<String> detoBomb(List<String> previousGrid, List<String> nextGrid) {
        
        int row = previousGrid.size();
        int col = previousGrid.get(0).length();
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                char currentCell = previousGrid.get(i).charAt(j);
                //System.out.println("i=" + i + " cc=" + currentCell);
                if (currentCell == 'O') {
                    String str1 = nextGrid.get(i).substring(0, j)+"."+nextGrid.get(i).substring(j+1);
                    //System.out.println("str1=" + str1);
                    nextGrid.set(i, str1);
                    //System.out.println("nextGrid=" + nextGrid);
                    if (i-1 >= 0) {
                        String str2 = nextGrid.get(i-1).substring(0, j)+"."
                                    +nextGrid.get(i-1).substring(j+1);
                        nextGrid.set(i-1, str2);
                    }
                    if (i+1 <= row-1){
                        String str2 = nextGrid.get(i+1).substring(0, j)+"."
                                    +nextGrid.get(i+1).substring(j+1);
                        nextGrid.set(i+1, str2);
                    }
                    if (j-1 >= 0) {
                        String str2 = nextGrid.get(i).substring(0, j-1)+"."
                                    +nextGrid.get(i).substring(j);
                        nextGrid.set(i, str2);
                    }
                    if (j+1 <= col-1 ) {
                         String str2 = nextGrid.get(i).substring(0, j+1)+"."
                                    +nextGrid.get(i).substring(j+2);
                        nextGrid.set(i, str2); 
                    } 
                    // if (j+2 == col-1 ) {
                    //      String str2 = nextGrid.get(i).substring(0, j+1)+".";
                    //     nextGrid.set(i, str2); 
                    // }   
                    
                }
                
            }
        }  
        //System.out.println("nextGrid1=" + nextGrid); 
        return nextGrid;
        
    }

    public static List<String> bomberMan(int n, List<String> grid) {
    // Write your code here
        List<String> firstDeto = new ArrayList<>();
        List<String> secondDeto = new ArrayList<>();
        List<String> thirdDeto = new ArrayList<>();
        List<String> fillAllBombs = new ArrayList<>();     //even times
        
        int r = grid.size();
        int c = grid.get(0).length();
        String bombs = "";
        for (int i=0; i<c; i++) {
            bombs += "O";
        }
        for (int i=0; i<r; i++) {
            firstDeto.add(bombs);
            secondDeto.add(bombs);
            thirdDeto.add(bombs);
            fillAllBombs.add(bombs);
        }
        // System.out.println("1st=" + firstDeto);
        // System.out.println("2nd=" + secondDeto);
        // System.out.println("3rd=" + thirdDeto);
        // System.out.println("all=" + fillAllBombs);
        
        firstDeto = detoBomb(grid, firstDeto);
        //System.out.println("1st-1=" + firstDeto);
        
        if (n == 1)
            return grid;
        else if (n % 2 == 0)
            return fillAllBombs;
        else if (n == 3)
            return firstDeto;    
            
        secondDeto = detoBomb(firstDeto, secondDeto);
        thirdDeto = detoBomb(secondDeto, thirdDeto);
        if (n % 4 == 3) 
            return thirdDeto;
        else if (n % 4 == 1) 
            return secondDeto;
            
        return null;
    }    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputWriter(System.out));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
                
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
