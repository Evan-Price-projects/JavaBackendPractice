public class Pair<K,V>{

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
        
        @Override
        public boolean equals(Object o)
        {
        	  if (o instanceof Pair) {
        	       Pair<?, ?> pair = (Pair<?, ?>) o;
        	      
        	       if(key == null && pair.key == null)
        	    	   return value.equals(pair.value);
        	       if(value == null && pair.value == null)
        	       		return key.equals(pair.key) ;
        	       if(key != null && value != null)
        	    	   return key.equals(pair.key) && value.equals(pair.value);
        	    }
        	  return false;
        }
        
    }
    