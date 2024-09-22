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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
        Map<Character, Integer> mapLetter = new HashMap<>();
        List<Integer> freq = new ArrayList<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            Integer val = mapLetter.get(c);
            
            if (val != null) 
                mapLetter.put(c, ++val);
            else 
                mapLetter.put(c, 1);   
        }
        for(Integer v : mapLetter.values())
            freq.add(v);
    
        Collections.sort(freq);

        if (mapLetter.size() == 1) return "YES";
        
        int first = freq.get(0);
        int second = freq.get(1);
        int secondLast = freq.get(mapLetter.size()-2);
        int last = freq.get(mapLetter.size()-1);
        
        if (first == last) return "YES";
        if (first == 1 && second == last) return "YES";
        if (first == second && second == secondLast && secondLast == (last - 1)) return "YES";
    
        return "NO";   
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
