import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
        int n = q.size();
        int count = 0;
        
        for (int i = n-1; i>-1; i--) {
            if ( q.get(i) != i+1 ) {
                if (q.get(i-1) == i+1 && i-1 >= 0) {
                    count++;
                    
                    //swap
                    int temp = q.get(i);
                    q.set(i, q.get(i-1));
                    q.set(i-1, temp);
                    
                    
                }else if (q.get(i-2) == i+1 && i-2 >= 0) {
                    count +=2;           

                    //swap
                    int temp = q.get(i);
                    q.set(i, q.get(i-2));
                    q.set(i-2, q.get(i-1));
                    q.set(i-1, temp);
                    
                }else  {    //q.get(i) - i - 1 > 2
                    System.out.println("Too chaotic");
                    return;
                }       
            }           
        }
        System.out.println(count);
        return; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
