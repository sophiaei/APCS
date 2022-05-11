// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu (ft. Sophia Eiden)
// APCS pd6
// HW96 -- BSTs is the Perfect Place for Shade
// 2022-05-10t
// time spent: 1.0  hrs

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
	_root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    if (_root == null) {
        _root = newNode;
        return;
    }
    insert(_root, newNode);
    /*** YOUR IMPLEMENTATION HERE ***/
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {

    if (stRoot.getValue() > newNode.getValue()) {
        if (stRoot.getLeft() == null) {
            stRoot.setLeft(newNode);
        } else {
            insert(stRoot.getLeft(), newNode);
        }
    } else {
        if (stRoot.getRight() == null) {
            stRoot.setRight(newNode);
        } else {
            insert(stRoot.getRight(), newNode);
        }
    }


    /*** YOUR IMPLEMENTATION HERE ***/
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
      System.out.print(currNode.getValue());

      if (currNode.getLeft() != null) {
        preOrderTrav(currNode.getLeft());
      }

      if (currNode.getRight() != null) {
        preOrderTrav(currNode.getRight());
      }
    /*** YOUR IMPLEMENTATION HERE ***/
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
      inOrderTrav(_root);
    /*** YOUR IMPLEMENTATION HERE ***/
  }
  public void inOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
      if (currNode.getLeft() != null)
          inOrderTrav(currNode.getLeft());
      System.out.print(currNode.getValue());
      if (currNode.getRight() != null)
          inOrderTrav(currNode.getRight());
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
      postOrderTrav(_root);
    /*** YOUR IMPLEMENTATION HERE ***/
  }
  public void postOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
      if (currNode.getLeft() != null)
          postOrderTrav(currNode.getLeft());
      if (currNode.getRight() != null)
          postOrderTrav(currNode.getRight());
      System.out.print(currNode.getValue());
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    public TreeNode search( int target )
    {
        return searchHelper(_root, target);
    	/*** YOUR IMPLEMENTATION HERE ***/
    }

    public TreeNode searchHelper(TreeNode stTree, int target)
    {
        if (stTree == null) {
            return null;
        }

        if (stTree.getValue() == target) {
            return stTree;
        }

        if (stTree.getValue() > target) {
            return searchHelper(stTree.getLeft(), target);
        }


        return searchHelper(stTree.getRight(), target);
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height() {
        return heightHelper(_root);
    }

    //helper
    public int heightHelper(TreeNode stTree) {
        if (stTree == null) return 0;
        return Math.max(heightHelper(stTree.getLeft()), heightHelper(stTree.getRight())) + 1;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves() {
        return numLeavesHelper(_root);
    }

    public int numLeavesHelper(TreeNode stTree) {

        if (stTree == null) return 0;

        if (stTree.getLeft() == null && stTree.getRight() == null) {
            return 1;
        }

        return numLeavesHelper(stTree.getLeft()) + numLeavesHelper(stTree.getRight());
    }



  //main method for testing
  public static void main( String[] args )
  {

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );

    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

      System.out.println(arbol.search(4).getValue());
      System.out.println(arbol.search(0));

      System.out.println(arbol.numLeaves());
      System.out.println(arbol.height());

  }

}//end class
