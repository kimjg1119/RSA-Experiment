import java.util.Random;

interface ConstNum
{
	int PRIMELIMIT=1000;
}

class RSAfunc
{
	private long p,q,n,pn,e,d;
	private int r_1,r_2,r_3;
	private Random r;
	PrimeClass pc=new PrimeClass();
	
	public RSAfunc()
	{
		r=new Random();
		r_1=r.nextInt(100)+1;
		r_2=r.nextInt(100)+1;
		r_3=r.nextInt(100)+1;
		
		while(r_1==r_2)
			r_2=r.nextInt(100)+1;
		while(r_1==r_3 || r_2==r_3)
			r_3=r.nextInt(100)+1;
		
		p=pc.nextPrime(ConstNum.PRIMELIMIT-r_1);
		q=pc.nextPrime(ConstNum.PRIMELIMIT-r_2);
		
		n=p*q;
		pn=(p-1)*(q-1);
		
		e=pc.nextPrime(ConstNum.PRIMELIMIT-r_3);
	    for(long i=pn-1;i>0;i--)
	    {
	        if((e*i)%pn==1)
	        {
	            d=i;
	            break;
	        }
	    }		
	}
}

class PrimeClass
{
	private long prime[]=new long[ConstNum.PRIMELIMIT];
	public PrimeClass()
	{
	    int i,j,k=0,t;
	    for(i=2;;i++)
	    {
	        t=0;
	        for(j=0;j<k;j++)
	        {
	            if(i%prime[j]==0)
	            {
	                t=1;
	                break;
	            }
	        }
	        if(t==0)
	            prime[k++]=i;
	        if(k==ConstNum.PRIMELIMIT)
	            return;
	    }
	}
	public long nextPrime(int i)
	{
		return prime[i];
	}
}

class RSAproject
{
	public static void main(String[] args) 
	{
		
	}
}
