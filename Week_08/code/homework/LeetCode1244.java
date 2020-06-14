package homework;

import org.junit.Test;

/**
 * 1244. 力扣排行榜
 * https://leetcode-cn.com/problems/design-a-leaderboard/
 * 2020/06/13
 */
public class LeetCode1244 {
    @Test
    public void test1() {

    }

    class Leaderboard {
        private int[][] array;
        int tail = 0;

        public Leaderboard() {
            this.array = new int[12000][];
        }

        public void addScore(int playerId, int score) {
            int[] arr = new int[2];
            arr[0] = playerId;
            arr[1] = score;
            int pod = search(playerId);
            if (pod == -1)
                pod = tail;
            insert(arr, pod);
        }

        private void insert(int[] arr, int pod) {
            int i = pod;
            if (pod != tail) {
                arr[1] = array[pod][1] + arr[1];
            }
            if (tail != 0) {
                for (i = pod; i > 0 && arr[1] > array[i - 1][1]; i--) {
                    array[i] = array[i - 1];
                }
            }
            array[i] = arr;
            if (pod == tail) {
                tail++;
            }
        }

        private int search(int playerId) {
            for (int i = 0; i < tail; i++) {
                if (array[i][0] == playerId) return i;
            }
            return -1;
        }

        public int top(int K) {
            int tmp = Math.min(K, tail);
            int sum = 0;
            for (int i = 0; i < tmp; i++) {
                sum += array[i][1];
            }

            return sum;
        }

        public void reset(int playerId) {
            int ret = search(playerId);
            int[] ori = array[ret];
            ori[1] = 0;
            if (tail - ret + 1 >= 0) System.arraycopy(array, ret + 1, array, ret + 1 - 1, tail - ret + 1);
            array[tail - 1] = ori;
        }
    }
}
