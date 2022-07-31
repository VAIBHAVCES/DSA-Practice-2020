public class main {

    public class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String arrgs[]) {

    }

    static int ans = 0;

    public static int maxPathSum2(Node node) {

        if (node == null) {
            return 0;
        }
        int lc = maxPathSum2(node.left);
        int rc = maxPathSum2(node.right);
        if(node.left!=null && node.right!=null)
            ans=Math.max(lc+rc+node.data,ans);
        return Math.max(lc,rc)+node.data;
    }

}