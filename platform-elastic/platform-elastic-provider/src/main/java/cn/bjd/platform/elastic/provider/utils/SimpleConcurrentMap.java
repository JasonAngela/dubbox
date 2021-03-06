package cn.bjd.platform.elastic.provider.utils;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * SimpleConcurrentMap
 * @param <K>
 * @param <V>
 */
public class SimpleConcurrentMap<K, V> implements Map<K, V> {
	/**
	 * lock
	 */
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	/**
	 * r
	 */
	private final Lock r = lock.readLock();
	/**
	 * w
	 */
	private final Lock w = lock.writeLock();
	/**
	 * map
	 */
	private Map<K, V> map;

	/**
	 * SimpleConcurrentMap
	 * @param map
	 */
	public SimpleConcurrentMap(Map<K, V> map) {
	     this.map = map;  
	     if (map == null) {throw new NullPointerException();}
	}   
	@Override
	public int size() {
		 r.lock();  
	        try {  
	            return map.size();  
	        } finally {  
	            r.unlock();  
	        }  
	}

	@Override
	public boolean isEmpty() {
		 r.lock();  
	        try {  
	            return map.isEmpty();  
	        } finally {  
	            r.unlock();  
	        }  
	}

	@Override
	public boolean containsKey(Object key) {
		 r.lock();  
	     try {  
	        return map.containsKey(key);  
	     } finally {  
	        r.unlock();  
	     }  
	}

	@Override
	public boolean containsValue(Object value) {
		 r.lock();  
	     try {  
	       return map.containsValue(value);  
	     } finally {  
	       r.unlock();  
	     }
	}

	@Override
	public V get(Object key) {
		 r.lock();  
	        try {  
	            return map.get(key);  
	        } finally {  
	            r.unlock();  
	        }  
	}

	@Override
	public V put(K key, V value) {
		w.lock();  
        try {  
            return map.put(key, value);  
        } finally {  
            w.unlock();  
        }  
	}

	@Override
	public V remove(Object key) {
		 w.lock();  
	        try {  
	            return map.remove(key);  
	        } finally {  
	            w.unlock();  
	        }  
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		w.lock();  
        try {  
            map.putAll(m);  
        } finally {  
            w.unlock();  
        }  
		
	}

	@Override
	public void clear() {	
	  w.lock();  
	  try {  
	      map.clear();  
	  } finally {  
	      w.unlock();  
	  }  	
	}

	@Override
	public Set<K> keySet() {
		  r.lock();  
	        try {  
	            return new HashSet<K>(map.keySet());
	        } finally {  
	            r.unlock();  
	        } 
	}

	@Override
	public Collection<V> values() {
		 r.lock();  
	        try {  
	            return new ArrayList<V>(map.values());
	        } finally {  
	            r.unlock();  
	        }  
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

}
