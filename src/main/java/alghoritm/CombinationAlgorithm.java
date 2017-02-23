package alghoritm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CombinationAlgorithm {
    //Between video and Cache
    static void printCombinationsOfPossibleDataAtCache(String leadPart, List<int[]> characters) {
        if (characters.isEmpty()) {
            // print your result string to your file
            System.out.println(leadPart);
        } else {
            List<int[]> remainingCharacters = characters.subList(1, characters.size());
            int[] currentLevel = characters.get(0);
            for (int index = 0; index < currentLevel.length; index++) {
                List<int[]> remainingCombinations;
                if (currentLevel.length == 1) {
                    remainingCombinations = remainingCharacters;
                } else {
                    int[] currentLevelMinusOne = new int[currentLevel.length - 1];
                    if (index > 0) {
                        System.arraycopy(currentLevel, 0, currentLevelMinusOne, 0, index);
                    }
                    if (index < currentLevelMinusOne.length) {
                        System.arraycopy(currentLevel, index + 1,
                                currentLevelMinusOne, index, currentLevelMinusOne.length - index);
                    }
                    remainingCombinations = new LinkedList<int[]>(remainingCharacters);
                    remainingCombinations.add(0, currentLevelMinusOne);
                }
                // recursively collect all other combinations
                printCombinationsOfPossibleDataAtCache(leadPart + currentLevel[index], remainingCombinations);
            }
        }
    }



    public static void main(String[] args) {
        List<int[]> list = Arrays.asList(
                new int[][]{
                        {2, 1},
                        {4, 3},
                        {1}});
        printCombinationsOfPossibleDataAtCache("combination ->", list);
    }
}
