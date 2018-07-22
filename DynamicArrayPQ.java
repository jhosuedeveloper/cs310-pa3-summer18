//implementing Priority Queue using a Dynamic Array that doubles the capacity everytime the array is full
import java.util.ArrayList;
public class DynamicArrayPQ<T, P extends Comparable<P>> implements PriorityQueue<T,P>
{


    //attributes
    private ArrayList<Node<T,P>> array;


    //constructor
    public DynamicArrayPQ()
    {
      array = new ArrayList<Node<T,P>>();
    }

    //add the given value using the provided priority
    public void enqueue(T value, P priority)
    {
      Node<T,P> x = new Node<T,P>();
      array.add(x);
    }

    //remove the value with the highest priority
    //(i.e. smallest priority value)
    public T dequeue()
    {
      Node<T,P> smallest_p_val = new Node<T,P>();
      smallest_p_val = array.get(this.array.size()-1);
      int index=array.size();

      for(int i =0;i<array.size();i++)
      {
        if((Double)array.get(array.size()-1-i).priority<(Double)smallest_p_val.priority)
        {
          index = array.size()-1-i;
          smallest_p_val = array.get(index);
        }
      }
      array.set(index, smallest_p_val);
      array.remove(array.get(array.size()));

      return null;
    }//end of dequeue function

    //return the value of the element with highest priority
    //(i.e. smallest priority value)
    public T peek()
    {

      int index=array.size()-1;
      P smallest_p_val = array.get(array.size()-1).priority;


        for(int i =0;i<array.size();i++)
        {
              if((Double)array.get(array.size()-1-i).priority<(Double)smallest_p_val)
              {
                          index = array.size()-1-i;
                          smallest_p_val = array.get(index).priority;
              }
        }

        return this.array.get(index).value;
    }//end of peek method

    //return the priority of the element with highest priority
    //(i.e. smallest priority value)
    public P peekPriority()
    {
      P smallest_p_val = array.get(array.size()-1).priority;
      int index=array.size()-1;

        for(int i =0;i<array.size();i++)
        {
              if((Double)array.get(array.size()-1-i).priority<(Double)smallest_p_val)
              {
                          smallest_p_val = array.get(index).priority;
                          index = array.size()-1-i;
              }
        }

        return smallest_p_val;
    }//end of peekPriority

    //remove everything in the priority queue
    public void clear()
    {
      array.clear();
    }

    //merge two priority queues into one and return the merged priority queue
    public DynamicArrayPQ  merge(DynamicArrayPQ other)
    {
      T x;
      P y;



       for(int i =0;i<other.array.size();i++)
       {
        x = ((Node<T,P>)other.getarr().get(i)).getval();
        y = ((Node<T,P>)other.array.get(i)).getpri();
        this.enqueue(x, y);
       }

      return this;
    }

    //return the size of the given priority queue
    public int size()
    {
        return array.size();
    }



    public class Node<T, P>
    {
      private T value;
      private P priority;

      public T getval()
      {
        return this.value;
      }
      public P getpri()
      {
        return this.priority;
      }

    }

    public ArrayList<Node<T,P>> getarr()
    {
      return this.array;
    }


    //==================================================================
    // do not modify anything below
    //==================================================================
    //merge two priority queues into one and return the merged priority queue
    public PriorityQueue  merge(PriorityQueue other)
    {
      return merge((DynamicArrayPQ)other);
    }






}//end of DynamicArrayPQ Class
