class Solution {
    public int solution(int n, int k) {
        String NtoK = "";
        int quo =n;
        int rem =0;
        int answer = 0;
        while(quo!=0)
        {
             quo =n/k;
             rem = n%k;
             n = quo;
             NtoK += Integer.toString(rem);
        }
        StringBuilder sb = new StringBuilder(NtoK).reverse();
        NtoK = sb.toString();
        String [] strings = NtoK.split("0");
        for(int i =0; i< strings.length;i++)
        {
            if(strings[i].isEmpty())continue;

           if(IsPrime(Double.parseDouble(strings[i]))==true)
            {
               if(NtoK.equals(strings[i])){answer++;}
               else
                   {
                       if(NtoK.contains("0"+strings[i]+"0"))answer++;
                        else if (NtoK.contains("0"+strings[i])) {answer++;}
                        else if (NtoK.contains(strings[i]+"0")) {answer++;}
                   }
            }
        }

        return answer;
    }
     static boolean IsPrime(double n)
    {
        if(n<=1)return false;
        for(double i = 2; i<=Math.sqrt(n) ; i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    }
