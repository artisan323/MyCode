package javatuning.ch2.buffer;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheUtil {

	static CacheManager manager=null;
	static String configfile="javatuning/ch2/buffer/ehcache.xml";
	static{
		try {
			manager = CacheManager.create(EHCacheUtil.class.getClassLoader().getResourceAsStream(configfile));
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}
	
	public static void put(String cachename,Serializable key,Serializable value){
		manager.getCache(cachename).put(new Element(key, value));
	}
	
	public static Serializable get(String cachename,Serializable key){
		try {
			Element e=manager.getCache(cachename).get(key);
			if(e==null)return null;
			return e.getValue();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void clearCache(String cachename){
		try {
			manager.getCache(cachename).removeAll();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void remove(String cachename,Serializable key){
		manager.getCache(cachename).remove(key);
	}
}
