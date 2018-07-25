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

      Node<T,P> n=null;
      if(this.size>=1)
      {
        n=root;
      }


      Node<T,P> x = new Node<T,P>();
      x.value = value;
      x.priority = priority;
      if(size==0)
      {
        this.root = x;
  //      System.out.println("hiasdf");
      }




      while(n!=null)
      {
    //    System.out.println("hi");
        if((Double)n.priority<(Double)priority)//left side
        {
          n = n.left;
        }
        else if((Double)n.priority>(Double)priority)//right side
        {
          n = n.right;
        }
        else
        {
          n = n.repeat;
                System.out.println("hiasdf");
        }
      }//end of while

      n=x;
      this.size++;

      this.numerize(root);
      Node<T,P> test = check_avl_tree(root);
      while(test!=null)
      {
        rotate_fix(test);
        test = check_avl_tree(root);
      }

    }//end of enqueue

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
      private Node<T,P> left;
      private Node<T,P> right;
      private Node<T,P> repeat;
      private int number_diff;


      public T getval()
      {
        return this.value;
      }
      public P getpri()
      {
        return this.priority;
      }

    }//end of node

    //Class Name: check_avl
    //input: none
    //output: return the unbalanced node
    //Description: makes sure the tree is balanced
    public Node<T,P> check_avl_tree(Node<T,P> n)
    {
      if(n.number_diff!=1 && n.number_diff!=0 && n.number_diff!=-1 && n!=null )
      {
        return n;
      }
      else
      {
        if(n.left!=null && n.right!=null)
        {
          Node<T,P> x = check_avl_tree(n.left);
          Node<T,P> y = check_avl_tree(n.right);
          if(x!=null)
          {
            return x;
          }
          else if(y!=null)
          {
            return y;
          }
          else
          {
            return null;
          }
        }
        else if(n.right!=null)
        {
          return check_avl_tree(n.right);
        }
        else if(n.left!=null)
        {
          return check_avl_tree(n.left);
        }
        else
        {
          return null;
        }
      }
    }//end of check_avl_tree

    public void numerize(Node<T,P> n)
    {
      if(n==null)
      {
        return;
      }
      else
      {
        numerize_node(n);
        numerize(n.left);
        numerize(n.right);
        return;
      }
    }//end of numerize method


    public void numerize_node(Node<T,P> n)
    {
      int l = largest_path(n.left);
      int r = largest_path(n.right);
      n.number_diff = l-r;
    }//end of numerize method

    public int largest_path(Node<T,P> n)
    {
      if(n==null)
      {
        return 0;
      }
      else
      {
        int l = largest_path(n.left)+1;
        int r = largest_path(n.right)+1;
        if(l>r)
        {
          return l;
        }
        else if (l<r)
        {
          return r;
        }
        else
        {
          return l;
        }
      }
    }//end of largest_path method

    //Class Name  : rotate_fix
    //input       : unbalanced node
    //output      : none
    //Description : it does all 4 type rotations including double rotations.
    public void rotate_fix(Node<T,P> x  )
    {
      int a = largest_path(x.left);
      int b = largest_path(x.right);

      if((a-b)>0)//--left right rotation
      {
        int x = largest_path(x.left.left)+1;
        int y = largest_path(x.left.right)+1;
        int z = largest_path(x.right);
        if(((y<x)&&(y<z))||((y>x)&&(y>z)))//double left right rotation
        {
          
        }
        else//single left right rotation
        {
          Node<T,P> a1 = x.left;
          x.left = a1.right;
          a1.right = x;
          if(k2==root)
          {
            this.root = a1;
          }

        }
      }
      else//---right left rotation
      {
        int x = largest_path(x.left);
        int y = largest_path(x.right.left)+1;
        int z = largest_path(x.right.right)+1;
        if(((y<x)&&(y<z))||((y>x)&&(y>z)))//double right left rotation
        {

        }
        else//single right left rotation
        {
          Node<T,P> a2 = x.right;
          x.right = a2.left;
          a2.left = x;

          if(x==root)
          {
            this.root = a2;
          }

        }
      }

    }//end of rotate_fix method

    //==================================================================
    // do not modify anything below
    //==================================================================
    //merge two priority queues into one and return the merged priority queue
    public PriorityQueue  merge(PriorityQueue other)
    {
      return merge((AVLPQ)other);
    }

}
