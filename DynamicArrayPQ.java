//implementing Priority Queue using a Dynamic Array that doubles the capacity everytime the array is full
import java.util.ArrayList;
public class DynamicArrayPQ<T, P extends Comparable<P>> implements PriorityQueue<T,P>
{


    //attributes
    ArrayList<Node<T,P>> array = new ArrayList<Node<T,P>>();


    //constructor
    public DynamicArrayPQ()
    {
      array.clear();
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
      for(int i =0;i<other.array.size();i++)
      {
        this.enqueue(other.array.get(i).value, other.array.get(i).priority );
      }

      return this;
    }

    //return the size of the given priority queue
    public int size()
    {
        return array.size();
    }



    private class Node<T, P>
    {
      T value;
      P priority;
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
