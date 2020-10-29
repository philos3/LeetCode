import kotlin.collections.ArrayList
import java.util.*
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

    fun preorderTraversal2(root: TreeNode?): List<Int> {
        var list: MutableList<Int> = mutableListOf()
        val stack :Deque<TreeNode?> = LinkList()
        if (root == null) return res else stack.push(root) //添加根节点
        //遍历分支
        while(!stack.isEmpty()){
            val p = stack.pop() // 将根节点弹出，如果为标记null，则是将空节点弹出即可；如果不为null，下面再将根节点添加到栈中
            if (p != null){//存在则对节点进行分解
                //前序为根左右，利用push的话添加顺序应该为右左根
                if (p.right != null) stack.push(p.right)   // 添加右节点
                if (p.left != null) stack.push(p.left)     // 添加左节点
                stack.push(p)     // 添加根节点
                stack.push(null)            // 根节点访问过，但还没有处理，需要做一下标记null
            } else{
                //由于上面添加了一次null，所以判断前面的pop弹出null，下一个才是分解出来的根节点，所以还需要pop一次，并判断不为空的才是合理的
                res.add(stack.pop()!!.`val`)
            }
        }
    
       return list
   }
}