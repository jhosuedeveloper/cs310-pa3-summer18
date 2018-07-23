//implementing Priority Queue using a Dynamic Array that doubles the capacity everytime the array is full
import java.util.ArrayList;
import java.util.Collections;
@SuppressWarnings("unchecked")
public class DynamicArrayPQ<T, P extends Comparable<P>> implements PriorityQueue<T,P>
{


    //attributes
    private ArrayList<Node<T,P>> array;
    private ArrayList<P> asdf;

    //constructor
    public DynamicArrayPQ()
    {
      array = new ArrayList<Node<T,P>>();
      asdf= new ArrayList<>();
    }

    //add the given value using the provided priority
    public void enqueue(T value, P priority)
    {
      Node<T,P> x = new Node<T,P>();
      x.value=value;
      x.priority=priority;


      asdf.add(priority);
      Collections.sort(asdf);

      for(int i =0;i<asdf.size()-1;i++)
      {
        if(asdf.get(i)==asdf.get(i+1))
        {
          System.out.println(i + "  " + asdf.get(i));
          System.out.println(i+1 + "  " + asdf.get(i+1));
        }
      }




      array.add(x);
    }

    //remove the value with the highest priority
    //(i.e. smallest priority value)
    public T dequeue()
    {
      Node<T,P> last_node = new Node<T,P>();
      last_node.value = array.get(this.array.size()-1).value;
      last_node.priority = array.get(this.array.size()-1).priority;

      int index=this.array.size()-1;
      P pri = this.array.get(this.array.size()-1).priority;
      T retrn_val;

      for(int i =0;i<array.size();i++)
      {
        //System.out.println(pri);
        //System.out.println(index);
        if( (Double)array.get(array.size()-1-i).priority<= (Double)pri)
        //if( Double.compare((Double)array.get(array.size()-1-i).priority  ,  (Double)pri)<0)
        {
          index = array.size()-1-i;
          pri = array.get(index).priority;
        }
      }
      retrn_val = array.get(index).value;
      array.set(index, last_node);
      array.remove(array.get(array.size()-1));
      return retrn_val;
    }//end of dequeue function

    //return the value of the element with highest priority
    //(i.e. smallest priority value)
    public T peek()
    {

      int index=array.size()-1;
      P smallest_p_val = array.get(array.size()-1).priority;


        for(int i =0;i<array.size();i++)
        {
              if((Double)array.get(array.size()-1-i).priority<=(Double)smallest_p_val)
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
              if((Double)array.get(array.size()-1-i).priority<=(Double)smallest_p_val)
              {
                          index = array.size()-1-i;
                          smallest_p_val = array.get(index).priority;
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



    private class Node<T, P>
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


    public static void main(String [] args)
{
  //your test code here
  DynamicArrayPQ<String, Double> x1 = new DynamicArrayPQ();
  DynamicArrayPQ<String, Double> x2 = new DynamicArrayPQ();

  System.out.println("----------------x1\n");
  x1.enqueue("Reston", 2.0);
  x1.enqueue("Herndon", 2.0);
  x1.enqueue("Ashburn", 4.0);
  x1.enqueue("Leesburg", 6.0);
  x1.enqueue("Fairfax", 8.0);

  System.out.println("----------------x2\n ");
  x2.enqueue("a", 1.0);
  x2.enqueue("b", 3.0);
  x2.enqueue("c", 5.0);
  x2.enqueue("d", 7.0);
  x2.enqueue("e", 9.0);

/*
  while(x1.size()!=0)
  {
    System.out.println(x1.peek());
    x1.dequeue();
  }
*/


  while(x1.size()!=0)
  {
    System.out.println(x1.peekPriority());
    x1.dequeue();
  }

/*
  System.out.println("----------------");
  x1.dequeue();
  for(int i=0;i<x1.array.size();i++)
  {
    System.out.println((x1.array.get(i)).value);
  }

  System.out.println("----------------getting the peak");
  System.out.println(x1.peek());
  System.out.println("----------------mergin");
  x1.merge(x2);
  while(x1.size()!=0)
  {
    System.out.println(x1.peek());
    x1.dequeue();
  }
  System.out.println("----------------clearing");
  x1.clear();
  for(int i=0;i<x1.array.size();i++)
  {
    System.out.println((x1.array.get(i)).value);
    System.out.println("nothing here");
  }
*/

} // end of test main



    //==================================================================
    // do not modify anything below
    //==================================================================
    //merge two priority queues into one and return the merged priority queue
    public PriorityQueue  merge(PriorityQueue other)
    {
      return merge((DynamicArrayPQ)other);
    }






}//end of DynamicArrayPQ Class
