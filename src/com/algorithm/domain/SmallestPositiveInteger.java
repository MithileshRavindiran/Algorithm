package com.algorithm.domain;

    import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

    import java.math.BigDecimal;
    import java.math.MathContext;
    import java.math.RoundingMode;
    import java.util.*;
    import java.util.stream.Collectors;

    import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by mravindran on 05/04/20.
 */
public class SmallestPositiveInteger {

    public static void main(String args[]) {
        int[] A = {1,3,4,5,7,12,41,41,41,5,41,10,41};
        solution(A, 5);

        int[] array  = {-1, 1,2,5,-2,5,-1};
        biggestContinuousSum(array);
//        String[]  stringArray = solution(2,4);
//        System.out.println(Arrays.toString(stringArray));
        /*MathContext m = new MathContext(4);
        BigDecimal start = new BigDecimal("92.73");
        BigDecimal endBalance = new BigDecimal("118.63");
        BigDecimal mutation = new BigDecimal("25.9");
        BigDecimal value = endBalance.subtract(start);
        System.out.println(value);
        System.out.println(mutation);

        System.out.println(mutation.stripTrailingZeros().equals(value.stripTrailingZeros()));*/
        /*int[] A1 = {-1, -2, -3};
        int result  = solution(A1);
        System.out.println(result);
        String abc =  "Hello  World";
        System.out.println(reverseString(abc));*/

        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));

    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    private static void biggestContinuousSum(int[] array) {
        int arrayLength =  array.length;
        int maxSum = 0;
        int sum = 0;
        for (int i=0; i<arrayLength; i++) {
            if (array[i]>0) {
                sum += array[i];
                if (sum > maxSum)
                    maxSum=sum;
            }else {
                sum = 0;
            }
        }
        System.out.println(maxSum);
    }

    private static String reverseString(String abc) {
        StringBuilder sb = new StringBuilder(abc);
        return sb.reverse().toString();
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> values = new TreeSet<>();
        int maxValue = 0;
        for (int a : A) {
            if (a >= maxValue) {
                maxValue = a;
            }
            values.add(a);
        }

        for  (int i =1 ; i < maxValue; i++) {
            if  (!values.contains(i))
                return i;
        }


        return maxValue+1;
    }

    public static  int solution(int[] A, int Y) {
        // write your code in Java
        Map<Integer, Integer> nails= new TreeMap<>();

        for  (int a :  A) {
           int count = (nails.get(a) == null) ? 1 : nails.get(a)+1;
            nails.put(a , count);
        }

        int sumOfPossiblities =  nails.values().stream().mapToInt(Integer::valueOf).sum();
        for (int nailKey : nails.keySet()) {
            sumOfPossiblities -= nails.get(nailKey);
            if (sumOfPossiblities >= Y) {
                nails.replace(nailKey, nails.get(nailKey)+Y);
            }

        }
        int max = 0;
        for (int value :  nails.values()) {
            if (value > max)
                max = value;
        }
        System.out.println(max);
        return max;

    }

    public static String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        int possibilitiesNeeded = K;
        ArrayList<String> result = new ArrayList<String>();
       for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                    if (result.size() == K)
                    return result.toArray(new String[K]);

                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }


}
