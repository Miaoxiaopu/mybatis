//package com.soft863.www.cache;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//import org.apache.ibatis.cache.Cache;
//
//public class CacheTest implements Cache{
//	
//	  private ReadWriteLock lock = new ReentrantReadWriteLock();
//	    private ConcurrentHashMap<Object,Object> cache = new ConcurrentHashMap<Object, Object>();
//	    private String id;
//
//	    public  CacheTest(){
//	        System.out.println("初始化-1！");
//	    }
//
//	  //必须有该构造函数
//	    public CacheTest(String id){
//	        System.out.println("初始化-2！");
//	        this.id = id;
//	    }
//
//	    // 获取缓存编号
//	    public String getId() {
//	        System.out.println("得到ID：" + id);
//	        return id;
//	    }
//
//	    //获取缓存对象的大小
//	    public int getSize() {
//	        System.out.println("获取缓存大小！");
//	        return 0;
//	    }
//	    // 保存key值缓存对象
//	    public void putObject(Object key, Object value) {
//	        System.out.println("往缓存中添加元素：key=" + key+",value=" + value);
//	        cache.put(key,value);
//	    }
//
//	    //通过KEY
//	    public Object getObject(Object key) {
//	        System.out.println("通过kEY获取值：" + key);
//	        System.out.println("OVER");
//	        System.out.println("=======================================================");
//	        System.out.println("值为：" + cache.get(key));
//	        System.out.println("=====================OVER==============================");
//	        return cache.get(key);
//	    }
//
//	    // 通过key删除缓存对象
//	    public Object removeObject(Object key) {
//	        System.out.println("移除缓存对象：" + key);
//	        return null;
//	    }
//
//	    // 清空缓存
//	    public void clear() {
//	        System.out.println("清除缓存！");
//	        cache.clear();
//	    }
//
//	    // 获取缓存的读写锁
//	    public ReadWriteLock getReadWriteLock() {
//	        System.out.println("获取锁对象！！！");
//	        return lock;
//	    }
//
//}
