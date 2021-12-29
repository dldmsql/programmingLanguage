// TypeEnv.java
// Type environment for S
import java.util.*;

// <id, type> 
class Entry {
   Identifier id;
   Type type;
   
   Entry (Identifier id, Type t) {
     this.id = id;
     this.type = t;
   }
}

class TypeEnv extends Stack<Entry> {
    public TypeEnv() { }
    
    public TypeEnv(Identifier id, Type t) {
        push(id, t);
    }
    
    public TypeEnv push(Identifier id, Type t) {
        super.push(new Entry(id, t));
	return this;
    }
    
    
    // (1) Contains Function Implementation
    public boolean contains (Identifier v) { // 식별자가 타입 환경에 포함되어 있는지 여부를 리턴
       // Contains Implementation
        for(Entry e : this){
            if(e.id.equals(v)) return true;
        }
        return false;
    }

    // (2) Get Function Implementation
    public Type get (Identifier v) { // 타입 환경의 탑에서부터 해당 식별자를 찾아 타입 리턴
        // Get Implementation
        for(Entry e2 : this){
            if (e2.id.equals(v)) return e2.type;
        }
        return null;
    }
}