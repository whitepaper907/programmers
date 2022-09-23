// [월간코드챌린지2] 괄호 회전하기
import java.util.*;

class Solution {
    Queue<Character> queue;
    
    public char pair(char ch){
        if(ch==')') return '(';
        else if(ch==']') return '[';
        else if(ch=='}') return '{';
        return ' ';
    }
        
    public boolean check(){
        Stack<Character> stack =  new Stack<>();
        int flag = 0; 
        int size = queue.size();
        for(int i=0;i<size;i++){
            char ch = queue.peek();
            if(flag==0){
                if(ch=='('||ch=='['||ch=='{') stack.push(ch);                
                else if((ch==')'||ch==']'||ch=='}')&&!stack.empty()){
                    if(stack.peek()==pair(ch)) stack.pop();
                    else flag = 1;
                }
                else flag=1;
            }
            queue.add(queue.poll());
        }
        if(stack.empty()&&flag==0) return true;
        else return false;
    }
    public int solution(String s) {
        int answer = 0;
        queue = new LinkedList<>();
        for(int i=0;i<s.length();i++)
            queue.add(s.charAt(i));
        
        for(int x=0;x<s.length();x++){
            if(check()) answer++;
            queue.add(queue.poll());
        }
        
        return answer;
    }
}
