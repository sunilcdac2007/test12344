package com.interview.array;

/**
 * Created by tushar_v_roy on 3/10/16.
 */
public class SelfCrossing {

    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) {
            return false;
        }
        int v1 = -x[0];
        int v2 = -x[1];

        int i = 2;
        while (i < x.length) {
            if (i % 2 == 0) {
                if (i % 4 == 0) {
                    v1 -= x[i];
                } else {
                    v1 += x[i];
                }
            } else {
                if ((i + 1) % 4 == 0) {
                    v2 += x[i];
                } else {
                    v2 -= x[i];
                }
            }
            if (i % 2 != 0) {
                if ((v1 >= 0 && v2 <= 0) || (v1 <= 0 && v2 >= 0)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    boolean isSelfCrossing1(int[] x) {
        for (int i = 3; i < x.length; i ++) {
            if (x[i] >= x[i - 2] && (x[i - 1]) <= x[i - 3]) {
                return true;
            }
            if (i >= 4) {
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                    return true;
                }
            }
            if (i >= 5) {
                if (x[i - 2] >= x[i - 4] && x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {
        SelfCrossing sc = new SelfCrossing();
        int input[] = {3, 3, 4, 2, 2};
        System.out.print(sc.isSelfCrossing(input));
        System.out.println(sc.isSelfCrossing1(input));
    }
}
