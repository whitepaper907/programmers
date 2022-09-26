//두 큐 합 같게 만들기
import java.util.*;

class Solution {
    public long sum(int[] array){
        long ret = 0;
        for(int a : array)
            ret += a;
        return ret;
    
    }
    
    public ArrayList<Integer> toArrayList(int[] array){
        ArrayList<Integer> ret = new ArrayList<>();
        for(int a : array)
            ret.add(a);
        return ret;
    }
    
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int length = queue1.length;
        long sum1 = sum(queue1);
        long sum2 = sum(queue2);
        long divSum =  sum1+sum2;
        if(divSum%2!=0) return -1;
        else{
            divSum /= 2;
            if(sum1-divSum != divSum-sum2) return -1; 
        }
        
        ArrayList<Integer> q1 = toArrayList(queue1);
        ArrayList<Integer> q2 = toArrayList(queue2);
        int q1_idx=0,q2_idx=0;
        long gap = sum2-sum1;
        int count =0;
        while(count < length*4){
            count++;
            if(gap<0){
                q2.add(q1.get(q1_idx));
                gap += (q1.get(q1_idx++)*2);
                answer++;
            }
            else if(gap>0){
                q1.add(q2.get(q2_idx));
                gap -= (q2.get(q2_idx++)*2);
                answer++;
            }
            else return answer;
        }
        return -1;
    }
}
