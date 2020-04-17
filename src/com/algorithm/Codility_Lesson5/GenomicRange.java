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


}
