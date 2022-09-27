//삼각 달팽이
class Solution {
    public int[] solution(int n) {
        int size = 0;
        for(int i=n;i>0;i--) size+=i;
        int[] answer = new int[size];
        
        int num=0;
        int idx=0;
        int flag=0;
        for(int i=n;i>0;i--){
            if(flag%3==0){
               for(int j=0;j<i;j++){
                   idx+=j+(flag/3*2);
                   answer[idx]=++num;
               } 
            }
            else if(flag%3==1){
                for(int j=0;j<i;j++)
                   answer[++idx]=++num; 
            }
            else{
                for(int j=0;j<i;j++){
                   idx=idx-n+j+(flag/3); 
                   answer[idx]=++num;
               } 
            }
            flag++;
        }
        return answer;
    }
}
