class Node
{
    int element;
    int index;
    int h;  //for height
    Node leftChild;
    Node rightChild;

    //default constructor to create null node
    public Node()
    {
        leftChild = null;
        rightChild = null;
        element = 0;
        h = 0;
    }
    // parameterized constructor
    public Node(int element,int index)
    {
        leftChild = null;
        rightChild = null;
        this.index = index;
        this.element = element;
        h = 0;
    }
}

// create class ConstructAVLTree for constructing AVL Tree
class ConstructAVLTree
{
    private Node rootNode;

    //Constructor to set null value to the rootNode
    public ConstructAVLTree()
    {
        rootNode = null;
    }

    //create removeAll() method to make AVL Tree empty
    public void removeAll()
    {
        rootNode = null;
    }

    // create checkEmpty() method to check whether the AVL Tree is empty or not
    public boolean checkEmpty()
    {
        if(rootNode == null)
            return true;
        else
            return false;
    }

    // create insertElement() to insert element to to the AVL Tree
    public void insertElement(int element,int index)
    {
        rootNode = insertElement(element, rootNode,index);
    }

    //create getHeight() method to get the height of the AVL Tree
    private int getHeight(Node node )
    {
        return node == null ? -1 : node.h;
    }

    //create maxNode() method to get the maximum height from left and right node
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)
    {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }


    //create insertElement() method to insert data in the AVL Tree recursively
    private Node insertElement(int element, Node node,int index)
    {
        //check whether the node is null or not
        if (node == null)
            node = new Node(element,index);
            //insert a node in case when the given element is lesser than the element of the root node
        else if (element < node.element)
        {
            node.leftChild = insertElement( element, node.leftChild,index );
            if( getHeight( node.leftChild ) - getHeight( node.rightChild ) == 2 )
                if( element < node.leftChild.element )
                    node = rotateWithLeftChild( node );
                else
                    node = doubleWithLeftChild( node );
        }
        else if( element > node.element )
        {
            node.rightChild = insertElement( element, node.rightChild ,index);
            if( getHeight( node.rightChild ) - getHeight( node.leftChild ) == 2 )
                if( element > node.rightChild.element)
                    node = rotateWithRightChild( node );
                else
                    node = doubleWithRightChild( node );
        }
        else{
            node.index = index;
        }
        node.h = getMaxHeight( getHeight( node.leftChild ), getHeight( node.rightChild ) ) + 1;

        return node;

    }

    // creating rotateWithLeftChild() method to perform rotation of binary tree node with left child
    private Node rotateWithLeftChild(Node node2)
    {
        Node node1 = node2.leftChild;
        node2.leftChild = node1.rightChild;
        node1.rightChild = node2;
        node2.h = getMaxHeight( getHeight( node2.leftChild ), getHeight( node2.rightChild ) ) + 1;
        node1.h = getMaxHeight( getHeight( node1.leftChild ), node2.h ) + 1;
        return node1;
    }

    // creating rotateWithRightChild() method to perform rotation of binary tree node with right child
    private Node rotateWithRightChild(Node node1)
    {
        Node node2 = node1.rightChild;
        node1.rightChild = node2.leftChild;
        node2.leftChild = node1;
        node1.h = getMaxHeight( getHeight( node1.leftChild ), getHeight( node1.rightChild ) ) + 1;
        node2.h = getMaxHeight( getHeight( node2.rightChild ), node1.h ) + 1;
        return node2;
    }

    //create doubleWithLeftChild() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child
    private Node doubleWithLeftChild(Node node3)
    {
        node3.leftChild = rotateWithRightChild( node3.leftChild );
        return rotateWithLeftChild( node3 );
    }

    //create doubleWithRightChild() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child
    private Node doubleWithRightChild(Node node1)
    {
        node1.rightChild = rotateWithLeftChild( node1.rightChild );
        return rotateWithRightChild( node1 );
    }

    //create getTotalNumberOfNodes() method to get total number of nodes in the AVL Tree
    public int getTotalNumberOfNodes()
    {
        return getTotalNumberOfNodes(rootNode);
    }
    private int getTotalNumberOfNodes(Node head)
    {
        if (head == null)
            return 0;
        else
        {
            int length = 1;
            length = length + getTotalNumberOfNodes(head.leftChild);
            length = length + getTotalNumberOfNodes(head.rightChild);
            return length;
        }
    }

    //create searchElement() method to find an element in the AVL Tree
  public String searchElement(int element,int index) {
        return searchElement(rootNode, element,index);
    }

    private String searchElement(Node head, int element,int index) {
        String check = "not";
        while ((head != null)) {
            int headElement = head.element;
            if (element < headElement)
                head = head.leftChild;
            else if (element > headElement)
                head = head.rightChild;
            else {
                if(head.index!=index)
                    check = String.valueOf(head.index);
                break;
            }
            check = searchElement(head, element,index);
        }
        return check;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
         int size = nums.length;
        ConstructAVLTree avlTree = new ConstructAVLTree();
        for (int i = 0; i < size; i++) {
            avlTree.insertElement(nums[i],i);
        }
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i <size ; i++) {
            int key =target-nums[i];
            String res = avlTree.searchElement(key,i);
            if(!res.equals("not")){
                sol.add(i);
                sol.add(Integer.valueOf(res));
                break;
            }
        }
      int[] arr = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++)
            arr[i] = sol.get(i);
        return arr;
    }
}