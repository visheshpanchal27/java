package THREADS;

class SumThreadB implements Runnable
{
    int i,sum =0;
    public void run()
    {
        for(i=1;i<=5;i++)
        {
            sum +=i;
            try
            {
                if (i%2 ==0)
                Thread.sleep(25);
            }
            catch (InterruptedException e)
            {
                ;
            }
            System.out.println("sum of number from 1 up to " + i+"="+sum);
        }
    }
}
class Factorial implements Runnable
{
    int i,n,fact=1;
    public void run()
    {
        for(i=1;i<=5;i++)
        {
            fact *=i;
            try
            {
                if (i%3 ==0)
                Thread.sleep(25);
            }
            catch (InterruptedException e)
            {
                ;
            }
            System.out.println("Factorial of "+i+"="+fact);
        }
    }
}
class Threadsleep {
    public static void main(String[] args)
    {
        Thread ct=Thread.currentThread();
        System.out.println("the main thread is "+ct.getName());
        SumThreadB st=new SumThreadB();
        Factorial ft=new Factorial();
        Thread sumt=new Thread(st, "sum Thread");
        Thread factt=new Thread(ft, "factorial thread");
        System.out.println("the main thread priority is :"+ct.getPriority());
        System.out.println("the sum thread priority is :"+sumt.getPriority());
        System.out.println("the factorial thread priority is :"+factt.getPriority());
        sumt.start();
        factt.start();
    }
    
}
