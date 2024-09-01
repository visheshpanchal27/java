package THREADS;

class SumThreada implements Runnable
{
    int i,sum=0;
    public void run()
    {
        for(i=0;i<=5;i++)
        {
            sum += i;
            System.out.println("sum of number from 1 up to "+i +"="+sum);
        }
    }
}
class FactThreada implements Runnable
{
    int i,n,fact=1;
    public void run()
    {
        for(i=0;i<=5;i++)
        {
            fact *= i;
            System.out.println("factorial of "+i+"="+fact);
        }
    }
}
public class ThreadJoin {
    public static void main(String[] args)
    {
        SumThreada st=new SumThreada();
        FactThreada ft=new FactThreada();
        Thread sumt =new Thread(st, "sum thread");
        Thread factt =new Thread(ft, "fact thread");
        sumt.setPriority(Thread.NORM_PRIORITY - 2);
        factt.setPriority(Thread.NORM_PRIORITY + 2);
        System.out.println("the priority value of " + sumt.getName() + " is " + sumt.getPriority());
        System.out.println("the value of "+ factt.getName()+ "is = " + factt.getPriority());
        sumt.start();
        System.out.println("thr thread created is :"+sumt.getName());
        try
        {
            sumt.join();
        }
        catch (InterruptedException e)
        {
        ;
        }
        factt.start();
        System.out.println("the thread cerated is : " + factt.getName());
    }
}
