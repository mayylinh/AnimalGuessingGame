package TreePackage;
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T>
{
    BinaryNode<T> currentNode;
    public DecisionTree(T data)
    {
        this(data, null, null);
    }

    public DecisionTree(T data, DecisionTree<T> left, DecisionTree<T> right)
    {
        setTree(data, left, right);
    }

    @Override
    public T getCurrentData()
    {
        if (currentNode!= null)
        {
            return currentNode.getData();
        }
        return null;
    }

    @Override
    public void setCurrentData(T newData)
    {
        // TODO
        currentNode.setData(newData);
    }

    @Override
    public void setResponses(T responseForNo, T responseForYes)
    {
        // TODO
        BinaryNode no = new BinaryNode();
        BinaryNode yes = new BinaryNode();
        
        no.setData(responseForNo);
        yes.setData(responseForYes);
        currentNode.setLeftChild(no);
        currentNode.setRightChild(yes);
    }

    @Override
    public boolean isAnswer()
    {
        // TODO
        if (currentNode.isLeaf())
            return true;
        return false;
    }

    @Override
    public void advanceToNo()
    {
        // TODO
        if (currentNode.hasLeftChild())
            currentNode = currentNode.getLeftChild();
        else 
            currentNode = null;
    }

    @Override
    public void advanceToYes()
    {
        // TODO
        if (currentNode.hasRightChild())
            currentNode = currentNode.getRightChild();
        else
            currentNode = null;
    }

    @Override
    public void resetCurrentNode()
    {
        currentNode = root;
    }

    @Override
    public void setTree(T rootData)
    {
        super.setTree(rootData);
        currentNode = root;
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        super.setTree(rootData, leftTree, rightTree);
        currentNode = root;
    }
}
