// 구명보트
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int sum=0;
        int left_idx = 0;
        int right_idx = people.length-1;
        while(left_idx<=right_idx){
            while(right_idx>left_idx){
                if(sum+people[right_idx]>limit) break;
                sum+=people[right_idx--];
            }
            while(right_idx>=left_idx){
                if(sum+people[left_idx]>limit) break;
                sum+=people[left_idx++];
            }
            answer++; sum=0;
        }
        return answer;
    }
}
