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
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
        int maxHeight;
        Stack<Integer> cylinder1 = new Stack<>();
        Stack<Integer> cylinder2 = new Stack<>();
        Stack<Integer> cylinder3 = new Stack<>();
        
        cylinder1 = list(h1);
        cylinder2 = list(h2);
        cylinder3 = list(h3);
        
        int sum1 = sum(h1);
        int sum2 = sum(h2);
        int sum3 = sum(h3);
        
        if (sum1 == sum2 && sum2 == sum3)      
            return sum1;
        
        //Removing and discarding its topmost cylinder        
        while(true) {
            maxHeight = Math.min(sum1, Math.min(sum2, sum3));
            while (sum1 > maxHeight) {
                int t = cylinder1.pop();
                sum1 -= t;
            }
            while (sum2 > maxHeight) {
                int t = cylinder2.pop();
                sum2 -= t;
            }
            while (sum3 > maxHeight) {
                int t = cylinder3.pop();
                sum3 -= t;
            }
            if (sum1 == sum2 && sum2 == sum3)
                break;
        }        
        return maxHeight;
    }
    
    public static Stack<Integer> list(List<Integer> h) {
        Stack<Integer> s = new Stack<>();
        int n= h.size();
        for (int i=n-1; i>-1; i--) {
            s.push(h.get(i));
        }
        return s;
    }
    
    public static int sum(List<Integer> l) {
        int total=0;
        int n=l.size()-1;
        for (int i=n; i>-1; i--)
            total += l.get(i);
        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
