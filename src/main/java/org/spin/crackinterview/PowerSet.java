package org.spin.crackinterview;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {
    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        var set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);

//        var r = ps.getSubsets(set, 0);
//        for (ArrayList<Integer> a : r) {
//            System.out.println(Arrays.toString(a.toArray()));
//        }
        var r2 = ps.getSubset2(set);
        for (ArrayList<Integer> a : r2) {
            System.out.println(Arrays.toString(a.toArray()));
        }
    }

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
//        System.out.println(set.size() + ", " + index);
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) {
//            System.out.println("init");
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
//            System.out.println("allsubsets.size()=" + allsubsets.size());
            int item = set.get(index);
//            System.out.println("item=" + item);
            var moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
//            for (ArrayList<Integer> a : allsubsets) {
//                System.out.print(Arrays.toString(a.toArray())+",");
//            }
//            System.out.println();
        }
        return allsubsets;
    }

    ArrayList<ArrayList<Integer>> getSubset2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size();
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            System.out.println();
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        System.out.println("x="+x);
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                System.out.println("k="+k+", index="+index+", "+set.get(index));
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}
