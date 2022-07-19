import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class Main {
    static int index = 0;
    static Stack<Integer> minNumberOfElements = new Stack<>();

    public static void main(String[] args) throws Exception {

        /**
         * |-------------------------------------------------------------------------
         * Problem #1:
         * 
         * Today you decided to go to the gym. You currently have energy equal to E
         * units. There are N exercises in
         * the gym. Each of these exercises drains Ai amount of energy from your body.
         * 
         * You feel tired if your energy reaches 0 or below. Calculate the minimum
         * number of exercises you have
         * to perform such that you become tired. Every unique exercise can only be
         * performed at most 2 times as others also have to use the machines.
         * 
         * If performing all the exercises does not make you feel tired, return -1.
         * |-------------------------------------------------------------------------
         */

        // Case#: 1

        // Input:
        // 6
        // 2
        // 1
        // 2
        // Output:
        // 4

        // Case#: 2

        // Input:
        // 10
        // 2
        // 1
        // 2
        // Output:
        // -1

        // Case#: 3

        // Input:
        // 2
        // 3
        // 1
        // 5
        // 2
        // Output:
        // 1

        System.out.println(calGymExercises(6, 2, new int[] { 1, 2 }));
        System.out.println(calGymExercises(10, 2, new int[] { 1, 2 }));
        System.out.println(calGymExercises(2, 3, new int[] { 1, 5, 2 }));

        /**
         * |----------------------------------------------------------------------------
         * Problem #2:
         * 
         * There is a battle between heroes and villains going on. You have M heroes,
         * all of them have the same
         * health H. There are N villains, health of the i-th villain is Vi.
         * 
         * When a hero, with health H battles a villain with health Vi, one of the three
         * scenarios can happen:
         * 
         * if H > Vi: The villain is defeated, and the health of the hero is decreased
         * by Vi
         * if H < Vi: The villain wins, his health is not affected, and the hero is no
         * longer able to fight.
         * if H = Vi: Both are considered defeated, and neither can fight.
         * The heroes start fighting villains one by one in the same order, first
         * villain 1 then villain 2 and so on. It
         * might be possible that before defeating all the villains, all the heroes are
         * defeated. Therefore, to ensure
         * the victory of the heroes, you want to remove some villains from the front.
         * 
         * Your task is to find the minimum number of villains you need to remove from
         * the front such that the
         * |----------------------------------------------------------------------------
         */

        // Case#: 1

        // Input:
        // 4
        // 4
        // 3
        // 3
        // 1
        // 3
        // 3
        // Output:
        // 0

        // Case#: 2

        // Input:
        // 5
        // 3
        // 3
        // 1
        // 2
        // 3
        // 1
        // 1
        // Output:
        // 0

        // Case#: 3

        // Input:
        // 5
        // 1
        // 4
        // 1
        // 2
        // 3
        // 1
        // 3
        // Output:
        // 3

        System.out.println(heroesVsVillains(4, 4, 3, new int[] { 3, 1, 3, 3 }));
        System.out.println(heroesVsVillains(5, 3, 3, new int[] { 1, 2, 3, 1, 1 }));
        System.out.println(heroesVsVillains(5, 1, 4, new int[] { 1, 2, 3, 1, 3 }));
        System.out.println(heroesVsVillains(5, 4, 20, new int[] { 5, 6, 4, 2, 3 }));

        /**
         * |------------------------------------------------------------------------
         * Problem #3:
         * 
         * You need to build a road in a rugged terrain. You know the sea level of
         * each segment of the rugged
         * terrain, i.e., the i-th segment is Li meters from sea level.
         * 
         * 
         * You need to transform the terrain into a strictly downward sloping terrain
         * for the road, i.e., for each i-th
         * segment where 2 <= i <= N, resultant Li-1 > Li. To do so, you employ a
         * powerful digging team to help you
         * dig and reduce the sea level of the segments. On day D, the team can reduce
         * the sea level for each
         * segment that you scheduled that day by 2D-1 meters each.
         * 
         * You are allowed to assign the team to dig on multiple segments and/or dig on
         * the same segments for
         * multiple days.
         * 
         * Your task is to find the minimum number of days needed to transform the
         * terrain as per your requirements.
         * |--------------------------------------------------
         */

        // Case#: 1

        // Input:
        // 2
        // 3
        // 3
        // Output:
        // 1

        // Case#: 2

        // Input:
        // 2
        // 5
        // -3
        // Output:
        // 0

        // Case#: 3

        // Input:
        // 4
        // -1
        // 1
        // 1
        // 1
        // Output:
        // 3

        System.out.println(roadInRuggedTerrain(2, new int[] { 3, 3 }));
        System.out.println(roadInRuggedTerrain(2, new int[] { 5, -3 }));
        System.out.println(roadInRuggedTerrain(4, new int[] { -1, 1, 1, 1 }));

        /**
         * |---------------------------------------------------------------------------
         * Problem #4:
         *
         * You are given an array of size N. You need to change this array into a
         * mountain. By mountain we mean,
         * the either ends of the array should have equal elements. Then as we move
         * towards the middle from
         * both ends, the next element is just one more than the previous one. So, it
         * would have a peak in the
         * middle and decreases if you go towards either end, just like a mountain.
         * 
         * Examples of mountains are [1, 2, 3, 2, 1] or [6, 7, 8, 8, 7, 6]. But the
         * array [1, 2, 4, 2, 1] is not a mountain
         * because from 2 to 4 the difference is 2. The array [1, 2, 3, 1] is also not a
         * mountain because the
         * elements 2 and 3 are not equal from both ends.
         * 
         * You need to find the minimum number of elements that should be changed to
         * make the array a mountain. You can make the elements negative or zero as
         * well.
         * |------------------------------------------------------------------------------
         */

        // Case#: 1

        // Input:
        // 5
        // 1
        // 2
        // 3
        // 4
        // 5
        // Output:
        // 2

        // Case#: 2

        // Input:
        // 9
        // 1
        // 1
        // 1
        // 2
        // 3
        // 2
        // 1
        // 1
        // 1
        // Output:
        // 4

        // Case#: 3

        // Input:
        // 6
        // 3
        // 3
        // 4
        // 4
        // 5
        // 5
        // Output:
        // 3

        System.out.println(ArrayToMountain(5, new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(ArrayToMountain(9, new int[] { 1, 1, 1, 2, 3, 2, 1, 1, 1
        }));
        System.out.println(ArrayToMountain(6, new int[] { 3, 3, 4, 4, 5, 5 }));

        /**
         * |-----------------------------------------------------------------------------
         * Problem #5:
         * 
         * You have an interesting string S of length N. It is interesting because you
         * can rearrange the characters of
         * this string in any order. You want to cut this string into some contiguous
         * pieces such that after cutting,
         * all the pieces are equal to one another.
         * 
         * You can't rearrange the characters in the cut pieces or join the pieces
         * together. You want to make the
         * number of pieces as large as possible. What is the maximum number of pieces
         * you can get?
         * 
         * Note: You can observe that you may not want to cut the string at all,
         * therefore the number of pieces is 1. Hence, the answer always exists.
         * |------------------------------------------------------------------------------
         */

        // Case#: 1

        // Input:
        // zzzzz
        // Output:
        // 5

        // Case#: 2

        // Input:
        // ababcc
        // Output:
        // 2

        // Case#: 3

        // Input:
        // abccdcabacda
        // Output:
        // 2

        System.out.println(intrestingString("zzzzz"));
        System.out.println(intrestingString("ababcc"));
        System.out.println(intrestingString("abccdcabacda"));

    }

    static int intrestingString(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        var occurred = 1;
        for (var ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else
                map.put(ch, occurred);

        }
        var minOccurence = Integer.MAX_VALUE;
        for (var element : map.entrySet()) {
            if (minOccurence > element.getValue())
                minOccurence = element.getValue();
        }
        return minOccurence;
    }

    static int ArrayToMountain(int noOfElements, int[] elements) {
        if (isMountain(noOfElements, elements) == false) {
            var size = minNumberOfElements.size();
            minNumberOfElements.clear(); // without this executing multiple test-cases together will disrupt stack size
            return size;
        }
        return 0;
    }
    // [3, 3, 4, 4, 5, 6]

    static boolean isMountain(int noOfElements, int[] elements) {
        final int DIFF = 1;
        boolean isMountain = true;
        int evenOrOdd = noOfElements % 2 == 0 ? (noOfElements / 2) + 1 : noOfElements / 2;

        for (int i = 0; i < noOfElements / 2; i++)
            if ((elements[i] >= elements[i + 1] && elements[i + 1] - elements[i] != DIFF)
                    || (elements[i] >= elements[i + 1] && elements[i + 1] - elements[i] == DIFF)) {
                isMountain = false;
                minNumberOfElements.push(elements[i + 1]);
            }

        for (int i = evenOrOdd; i < noOfElements - 1; i++)
            if ((elements[i] <= elements[i + 1] && elements[i] - elements[i + 1] != DIFF)
                    || (elements[i] <= elements[i + 1] && elements[i] - elements[i + 1] == DIFF)) {
                isMountain = false;
                minNumberOfElements.push(elements[i + 1]);
            }

        return isMountain = isMountain == false ? isMountain : !isMountain;

    }

    static int roadInRuggedTerrain(int elements, int[] seaLevels) {
        if (isStrictlyDecreasing(seaLevels) == false)
            return seaLevels.length - index;
        return 0;
    }

    static int heroesVsVillains(int noOfVillains, int noOfHeroes, int heroesHealth, int[] villainHealths) {
        var villainsDefeated = 0;
        var updatedVillainsHealth = 0;
        var totalHeroesHealth = noOfHeroes * heroesHealth;

        for (int i = 0; i < villainHealths.length; i++) {
            updatedVillainsHealth += villainHealths[i];
            villainsDefeated++;

            if (i == villainHealths.length - 1 && totalHeroesHealth == updatedVillainsHealth)
                return 0;

            if (totalHeroesHealth < updatedVillainsHealth || totalHeroesHealth == 0)
                return villainsDefeated;

        }

        return 0;

    }

    static int calGymExercises(int energy, int noOfExcercises, int[] energiesRequired) {
        var totalEnergy = 0;
        final int REPS = 2;
        int totalExercisesPerformed = 0;

        var sortedEnergiesRequired = sort(energiesRequired);

        for (int i = 0; i < sortedEnergiesRequired.length; i++) {
            if (energy < sortedEnergiesRequired[i])
                return -1;
            if (energy == sortedEnergiesRequired[i])
                return ++totalExercisesPerformed;
        }

        for (int i = 0; i < sortedEnergiesRequired.length; i++)
            for (int j = 0; j < REPS; j++) {
                totalEnergy += sortedEnergiesRequired[i];
                totalExercisesPerformed++;

                if (totalEnergy == energy)
                    return totalExercisesPerformed;
            }

        return -1;
    }

    // Improve Sorting algorithm
    static int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    static boolean isStrictlyDecreasing(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    index = j;
                    return false;
                }
            }
        }
        return true;
    }
}
