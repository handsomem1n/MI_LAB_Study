
// Follow up : Could you solve it without converting the integer to a string?

class Solution {
    public boolean isPalindrome(int x) {
        // 음수면 볼 것도 없이 false or 끝자리가 0이면 그것도 무조건 false
        if (x < 0 || (x % 10==0 && x!=0)){
            return false;
        }

        // 한 자리 수는 볼 것도 없이 true
        if(x<10 && x >= 0){
            return true;
        }

        // 핵심 로직 - reverse string을 통한 비교 말고
        // ex) abcde
        // 절반까지만 확인
        int half = 0;
        int piece = 0;
        while(x > half){
            piece = x % 10;
            half = half * 10 + piece;
            x = x/10;
        }

        // edc랑 abc가 같은지 chk - 홀수, 짝수 개수를 모두 커버
        return (x == half) || (x == half/10);


    }
}
