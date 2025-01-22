// idea: 레벨 별로 맨오른쪽 노드만 부모노드에서부터 뽑으면 됨.
// 레벨별로 체크 BFS
// dfs - 0번 레벨부터 말단max레벨까지 오른쪽에서 부터 훑으면 됨

// dfs
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }

        // 처음 방문하는 레벨이라면 결과 리스트에 추가
        if (level == result.size()) {
            result.add(node.val);
        }

        // 오른쪽부터 탐색
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}