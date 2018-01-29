package cn.bjd.platform.elastic.provider.utils;

import java.util.*;

/**
 *
 */
public final class CacheTimerHandler {
    private CacheTimerHandler(){}
    /**
     *
     */
    private static final long SECOND_TIME = 1000;//默认过期时间 20秒
    /***
     *
     */
    private static final int DEFUALT_VALIDITY_TIME = 2000000000;//默认过期时间 20秒
    /**
     *
     */
    private static final Timer TIMER;
    /**
     *
     */
    private static final SimpleConcurrentMap<String, CacheEntity> MAP;
      
    static{  
        TIMER = new Timer();
        MAP = new SimpleConcurrentMap<String, CacheEntity>(new HashMap<String, CacheEntity>(1<<18));
    }  
              
    /** 
     * 增加缓存对象 
     * @param key 
     * @param ce 
     */  
    public static void addCache(String key, CacheEntity ce){
        addCache(key, ce, DEFUALT_VALIDITY_TIME);  
    }  
      
    /** 
     * 增加缓存对象 
     * @param key 
     * @param ce 
     * @param validityTime 有效时间 
     */  
    public static synchronized void addCache(String key, CacheEntity ce, int validityTime){
        MAP.put(key, ce);
        //添加过期定时  
        TIMER.schedule(new TimeoutTimerTask(key), validityTime * SECOND_TIME);
    }  
      
    /** 
     * 获取缓存对象 
     * @param key 
     * @return 1
     */  
    public static synchronized CacheEntity getCache(String key){
        return MAP.get(key);
    }  
      
    /** 
     * 检查是否含有制定key的缓冲 
     * @param key 
     * @return 1
     */  
    public static synchronized boolean isConcurrent(String key){
        return MAP.containsKey(key);
    }  
      
    /** 
     * 删除缓存 
     * @param key 
     */  
    public static synchronized void removeCache(String key){
        MAP.remove(key);
    }  
      
    /** 
     * 获取缓存大小 
     * @return 1
     */  
    public static int getCacheSize(){  
        return MAP.size();
    }  
      
    /** 
     * 清除全部缓存 
     */  
    public static synchronized void clearCache(){  
        if(null != TIMER){
            TIMER.cancel();
        }  
        MAP.clear();
        System.out.println("clear cache");
    }  
      
    /** 
     * @projName：WZServer 
     * @className：TimeoutTimerTask 
     * @description：清除超时缓存定时服务类 
     * @creater：Administrator  
     * @creatTime：2013年7月22日 上午9:34:39  
     * @alter：Administrator 
     * @alterTime：2013年7月22日 上午9:34:39   
     * @remark： 
     * @version  
     */  
    static class TimeoutTimerTask extends TimerTask {
        /**
         *
         */
        private String ceKey ;

        /**
         *
         * @param key
         */
         TimeoutTimerTask(String key){
            this.ceKey = key;  
        }  
  
        @Override
        public void run() {  
            CacheTimerHandler.removeCache(ceKey);  
            System.out.println("remove : "+ceKey);
        }  
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
    	List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("HH", "JJJJJJ");
    	mapList.add(map);
    	
    	CacheEntity ne = new CacheEntity("mapListMap", mapList);
    	addCache("mapListMap", ne);
    	 ne = getCache("mapListMap");
    	 mapList = (List<Map<String, Object>>) ne.getCacheContext();
    	for(Map<String, Object> mam :mapList){
    		System.out.println(mam.get("HH"));
    	}
    	System.out.println(ne);
	}
}
