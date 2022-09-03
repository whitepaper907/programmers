//2019 KAKAO BLIND RECRUITMENT > 오픈채팅방
import java.util.*;

class Pair{
	public String info;
  public String id;
	public Pair(String info, String id) {
		this.info = info;
		this.id = id;
	}
}


class Solution {
    public String[] solution(String[] record) {
        
        String[] answer;
        
        HashMap<String, String> members = new HashMap<String, String>();
        ArrayList<Pair> messages = new ArrayList<Pair>();
        
        for(String str : record){
            StringTokenizer st = new StringTokenizer(str);
            String op = st.nextToken();
            String id = st.nextToken();
            String name;
            
            switch(op) {
                case "Enter":
                    name = st.nextToken();
                    if(members.containsKey(id))
                        members.replace(id, name);
                    else members.put(id, name);
                    messages.add(new Pair("Enter", id));
                    break;
                case "Leave":
                    messages.add(new Pair("Leave", id));
                    break;
                case "Change":
                    name = st.nextToken();
                    members.replace(id, name);
                    break;
            }
        }
        
        answer = new String[messages.size()];
        int idx=0;
        
        for(Pair message : messages){
            if(message.info=="Enter")
                answer[idx++]=members.get(message.id)+"님이 들어왔습니다.";
            else
                answer[idx++]=members.get(message.id)+"님이 나갔습니다.";
        }
        return answer;
    }
    
}
