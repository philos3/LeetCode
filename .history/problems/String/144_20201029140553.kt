
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
         var list: MutableList<Int> = mutableListOf()
        preorder(root, list)
        return list
    }

    fun preorder(root: TreeNode?, list: MutableList<Int>): List<Int>{
        if(root == null) return list
        list.add(root.`val`)
        preorder(root.left, list)
        preorder(root.right, list)
        return list
    }
}