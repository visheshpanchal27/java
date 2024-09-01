package THREADS;

class sumthread implements Runnable 
{
    int i, sum=0;
    public void run()
    {
        for(i=1;i<=5;i++)
        {
        sum+=i;
        System.out.println("sum of number from 1 up to " + i+"="+sum);
        }
    }
}
class factthread implements Runnable 
{
    int i,n,fact=1;
    public void run()
    {
        for (i=1;i<=5;i++)
        {
            fact*= i;
            System.out.println("factorial of "+i+"="+fact);
        }
    }
}
class threadPriority {
    public static void main(String[] args) 
    {
        sumthread st=new sumthread();
        factthread ft=new factthread();
        Thread sumt=new Thread(st,"sum thread");
        Thread factt=new Thread(ft,"fact thread");
        sumt.setPriority(Thread.NORM_PRIORITY-2);
        factt.setPriority(Thread.NORM_PRIORITY+2);
        System.out.println("the thread created is : " + sumt.getName());
        System.out.println("the thread created is : " + factt.getName());
        System.out.println("the priority vlaue of "+sumt.getName()+"is ="+sumt.getPriority());
        System.out.println("the priority value of "+factt.getName()+"is ="+factt.getPriority());
        sumt.start();
        factt.start();
    }    
}
