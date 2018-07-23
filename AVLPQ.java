//implement PQ using AVL Tree (AVL)
public class AVLPQ<T, P extends Comparable<P>> implements PriorityQueue<T,P>
{

    //atributes
    Node<T,P> root;
    int size;
    //constructor
    public AVLPQ()
    {
      size =0;
      root = new Node<T,P>();
    }

    //add the given value using the provided priority
    public void enqueue(T value, P priority)
    {
      Node<T,P> x = new Node<T,P>();
      x.value = value;
      x.priority = priority;

      if(size==0)
      {
        root = x;
        size++;
      }
      else if(root.priority<=priority)//left side
      {

      }
      else if(root.priority>priority)//right side
      {

      }
      else
      {
        System.out.println("there is something wrong going on");
      }
      //your code here
    }

    //remove the value with the highest priority
    //(i.e. smallest priority value)
    public T dequeue()
    {
      //your code here
      return null;
    }

    //return the value of the element with highest priority
    //(i.e. smallest priority value)
    public T peek()
    {
      //your code here
      return null;
    }

    //return the priority of the element with highest priority
    //(i.e. smallest priority value)
    public P peekPriority()
    {
      //your code here
      return null;
    }

    //remove everything in the priority queue
    public void clear()
    {
      //your code here
    }

    protected AVLPQ merge(AVLPQ other)
    {
        //your code here
        return null;
    }


    //return the size of the given priority queue
    public int size()
    {
        //your code here
        return 0;
    }


    //---------------------------extra classes and methods
    private class Node<T, P>
    {
      private T value;
      private P priority;
      private Node<T,P> left, right;

      public Node()
      {
        left=new Node<T,P>();
        right=new Node<T,P>();
      }


      public T getval()
      {
        return this.value;
      }
      public P getpri()
      {
        return this.priority;
      }

    }//end of node







    //==================================================================
    // do not modify anything below
    //==================================================================
    //merge two priority queues into one and return the merged priority queue
    public PriorityQueue  merge(PriorityQueue other)
    {
      return merge((AVLPQ)other);
    }

}
