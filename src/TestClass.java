public class TestClass {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello Java");
        TreeNode rootnode = new TreeNode(3);
        TreeNode firstNode = new TreeNode(5);
        TreeNode secondNode = new TreeNode(1);
        rootnode.left = firstNode;
        rootnode.right = secondNode;
        TreeNode thirdnode = new TreeNode(6);
        TreeNode fourthnode = new TreeNode(2);
        firstNode.left = thirdnode;
        firstNode.right = fourthnode;

        TreeNode fifthNode = new TreeNode(0);
        TreeNode sixNode = new TreeNode(8);
        secondNode.left = fifthNode;
        secondNode.right = sixNode;

        TreeNode seventhNode = new TreeNode(7);
        TreeNode eightNode = new TreeNode(4);
        fourthnode.left = seventhNode;
        fourthnode.right = eightNode;

        int temp = lca(rootnode, 3, 3);
        System.out.println("Common parent is:"+temp);
    }

    public static String findString(TreeNode A, int B){
        System.out.println("Node value is:"+A.val);
        //System.out.println("B Value is:"+B);
        if (A.val == B){
            return "0";
        }
        String s = null;
        if (A.left != null){
            String tempString = findString(A.left, B);
            if (tempString != null){
                s = "1";
                s += tempString;
                return s;
            }
        }
        if (A.right != null){
            String tempString = findString(A.right, B);
            if (tempString != null){
                s = "2";
                s += tempString;
                return s;
            }
        }
        return null;

    }
    public static int lca(TreeNode A, int B, int C) {
        //TreeNode node = findLowest(A, B, C);

        if(A == null){
            return -1;
        }
        String first = null;
        //first =
         first =       findString(A, B);
         String second = findString(A, C);

        System.out.println("First string is:"+first);
        System.out.println("second string is:"+ second);

        TreeNode tempNode = A;
        int i = 0;
        int firstlength = first.length();
        int secondLength = second.length();
        while (i < firstlength && i < secondLength){

            String tempString = first.substring(i, i+1);
            if (tempString.equals(second.substring(i, i+1))){
                if (tempString.equals("2")){
                    tempNode = tempNode.right;
                }
                else if (tempString.equals("1")){
                    tempNode = tempNode.left;
                }
                else{
                    return tempNode.val;
                }
            }
            i++;
        }
        return tempNode.val;

    }
}

