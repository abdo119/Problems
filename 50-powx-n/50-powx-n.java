class Solution {
    public double myPow(double x, int n) {
      if(n==Integer.MIN_VALUE)
        {
            x=x*x;
            n=Integer.MIN_VALUE+1;
        }
        
        if(n==0)
        {
            return 1;
        }
        
        
        if(n<0)
        {
            x=1/x;
            n=-n;
        }
        
        
        double xn1 = myPow(x,n/2);
       
        if(n%2!=0)
        {
           
           return xn1*xn1*x; 
        }
        else
        {
            return xn1*xn1;
        }
        
        
        
    }
}