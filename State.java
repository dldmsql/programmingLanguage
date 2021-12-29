import java.util.*;
// State as stack 

// <id, val> 
class Pair {
   Identifier id;
   Value val;
   
   Pair (Identifier id, Value v) {
     this.id = id;
     this.val = v;
   }
}

class State extends Stack<Pair> {
    public State( ) { }
    
    public State(Identifier id, Value val) {
        push(id, val);
    }

    // (1) Push function Implementation
    public State push(Identifier id, Value val) { // 변수의 새로운 엔트리를 push하고 변한 상태 리턴
    	// Push Implementation
        super.push(new Pair(id, val));
        return this;
    }

    // (2) Pop function Implementation (Optional)
    public Pair pop() { // 스택 탑에 있는 엔트리를 제거하고 이를 리턴
    	// Pop Implementation (Optional)
        if (!this.empty()) {
            Pair p = this.peek();
            super.pop();
            return p;
        }
            return null;
    }
    
    // (3) Lookup function Implementation
    public int lookup (Identifier v) { // 스택 탑에서부터 해당 변수를 찾아 엔트리 위치 리턴
       // Lookup Implementation
        int i = -1;
        for(int j = 0; j < this.size(); j++){
            Pair p = this.get(j);
            if(p.id.equals(v)) i = j;

        }
        return i;
    }

    // (4) Set Function Implementation
    public State set(Identifier id, Value val) { // 스택 탑에서부터 상태에서 변수 값 설정
    	// Set Implementation
        for(Pair p : this){
            if (p.id.equals(id)) p.val = val;
        }
        return this;
    }
    
    // (5) Get Function Implementation
    public Value get (Identifier id) { // 스택 탑에서부터 상태에서 변수 값 리턴
    	// Get Implementation // lookup()을 통해 찾은 index에 위치한 value 가져오기
        int index = this.lookup(id);
        if(index < 0 ) return null; // lookup에서 id를 찾지 못하면 i=-1
        else return this.get(index).val;
    }
}