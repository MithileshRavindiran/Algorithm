package com.algorithm.Codility_Lesson5;

import java.util.Arrays;

/**
 * Created by mravindran on 17/04/20.
 */
public class GenomicRange {

    public static void main(String args[])  {
        int[] A = {2,5,0};
        int[] B = {4,5,6};
        genomicRange("CAGCCTA", A, B);
        solution("CAGCCTA", A, B);
    }

    enum CharMap {
        A('A', 1),
        C('C', 2),
        G('G', 3),
        T('T', 4);



        Character character;
        int map;

        public Character getCharacter() {
            return character;
        }

        public int getMap() {
            return map;
        }

        CharMap(Character character, int map) {
            this.character = character;
            this.map =  map;
        }

        public static CharMap getCharacterFromCharacter(Character character) {
            for (CharMap charMap :values())  {
                if (charMap.getCharacter() == character) {
                    return charMap;
                }
            }
            return null;
        }
    }

    private static void genomicRange(String value, int[] A, int[] B) {
        int length = A.length;
        int[] result =  new int[length];
        for (int i =0 ; i< length; i++) {
            int startPosition = A[i];
            int endPosition = B[i];
            String subString = value.substring(startPosition, endPosition+1);
            char tempArray[] = subString.toCharArray();
            Arrays.sort(tempArray);
            result[i] = CharMap.getCharacterFromCharacter(tempArray[0]).getMap();
        }
    }


    public static int[] solution(String S, int[] P, int[] Q) {
        //used jagged array to hold the prefix sums of each A, C and G genoms
        //we don't need to get prefix sums of T, you will see why.
        int[][] genoms = new int[3][S.length()+1];
        //if the char is found in the index i, then we set it to be 1 else they are 0
        // 3 short values are needed for this reason
        short a, c, g;
        for (int i=0; i<S.length(); i++) {
            a = 0; c = 0; g = 0;
            if ('A' == (S.charAt(i))) {
                a=1;
            }
            if ('C' == (S.charAt(i))) {
                c=1;
            }
            if ('G' == (S.charAt(i))) {
                g=1;
            }
            //here we calculate prefix sums. To learn what's prefix sums look at here https://codility.com/media/train/3-PrefixSums.pdf
            genoms[0][i+1] = genoms[0][i] + a;
            genoms[1][i+1] = genoms[1][i] + c;
            genoms[2][i+1] = genoms[2][i] + g;
        }

        int[] result = new int[P.length];
        //here we go through the provided P[] and Q[] arrays as intervals
        for (int i=0; i<P.length; i++) {
            int fromIndex = P[i]+1;
            int toIndex = Q[i]+1;
            //if the substring contains a, then genoms[0][toIndex] - genoms[0][fromIndex-1] > 0
            if (genoms[0][toIndex] - genoms[0][fromIndex-1] > 0) {
                result[i] = 1;
            } else if (genoms[1][toIndex] - genoms[1][fromIndex-1] > 0) {
                result[i] = 2;
            } else if (genoms[2][toIndex] - genoms[2][fromIndex-1] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        System.out.println(Arrays.toString(result));
        return result;
    }


}
