// backtrack 할 것 : 쿠키 분배
class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k]; // 각 아이가 받은 쿠키 총합
        return backtrack(cookies, 0, children, k, Integer.MAX_VALUE);
    }

    private int backtrack(int[] cookies, int index, int[] children, int k, int minUnfairness) {
        
        // 모든 쿠키를 분배한 경우
        if (index == cookies.length) {
            int maxCookies = 0;
            for (int total : children) {
                maxCookies = Math.max(maxCookies, total);
            }
            return Math.min(minUnfairness, maxCookies);
        }

        // 현재 쿠키 가방을 각 아이에게 분배
        for (int i = 0; i < k; i++) {
            children[i] += cookies[index]; // i번째 아이에게 쿠키 추가
            minUnfairness = backtrack(cookies, index + 1, children, k, minUnfairness);
            children[i] -= cookies[index]; // 분배 취소 (backtracking)

            // 가지치기: 한 아이가 아무것도 받지 않은 상태라면 이후 탐색 skip
            if (children[i] == 0) break;
        }

        return minUnfairness;
    }
}
