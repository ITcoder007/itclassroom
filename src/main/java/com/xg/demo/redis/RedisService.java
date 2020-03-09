package com.xg.demo.redis;

import java.util.List;
import java.util.Map;

/**
 * redis服务接口
* @ClassName: RedisService
* @Description: redis 操作
* @author Lockie
* @date 2018年3月20日
*
 */
public interface RedisService {

	/**
	 * 插入字符串到缓存
	* @Title: set
	* @Description: set 值
	* @param @param key
	* @param @param value
	* @return boolean    返回类型
	* @throws
	 */
	boolean set(String key, String value);
	
	/**
	 * 插入字符串并设置缓存
	* @Title: set
	* @Description: 在redis中set，并设置过期时间
	* @param @param key
	* @param @param value
	* @param @param expire 过期时间（秒）
	* @return boolean    返回类型
	* @throws
	 */
	boolean set(String key, String value, Long expire);

	/**
	 * 获取缓存字符串
	* @Title: get
	* @Description: 通过key获取值
	* @param @param key
	* @return String    返回类型
	* @throws
	 */
	String get(String key);
	
	/**
	 * 设置过期时间
	* @Title: expire
	* @Description: 给对应的key设置过期时间
	* @param @param key
	* @param @param expire 单位：秒
	* @param @return    参数
	* @return boolean    返回类型
	* @throws
	 */
	boolean expire(String key, long expire);

	/**
	 * 缓存插入列表
	* @Title: setList
	* @Description: set 一个list集合
	* @param @param key
	* @param @param list
	* @return boolean    返回类型
	* @throws
	 */
	<T> boolean setList(String key, List<T> list);

	/**
	 * 缓存获取列表
	* @Title: getList
	* @Description: 通过key获取一个list集合
	* @param @param key
	* @param @param clz
	* @return List<T>    返回类型
	* @throws
	 */
	<T> List<T> getList(String key, Class<T> clz);

	/**
	 * 将一个值插入到列表头部。 如果 key不存在，一个空列表会被创建并执行 LPUSH操作。 当 key 存在但不是列表类型时，返回一个错误
	* @Title: lpush
	* @Description: 将一个值插入到列表头部。 如果 key不存在，一个空列表会被创建并执行 LPUSH操作。 当 key 存在但不是列表类型时，返回一个错误。
	* @param @param key
	* @param @param obj 插入的值
	* @return long    返回类型
	* @throws
	 */
	long lpush(String key, Object obj);

	/**
	 * 将一个值插入到列表尾部。 如果 key不存在，一个空列表会被创建并执行 RPUSH操作。 当 key 存在但不是列表类型时，返回一个错误。
	* @Title: rpush
	* @Description: 将一个值插入到列表尾部。 如果 key不存在，一个空列表会被创建并执行 RPUSH操作。 当 key 存在但不是列表类型时，返回一个错误。
	* @param @param key
	* @param @param obj
	* @param @return    参数
	* @return long    返回类型
	* @throws
	 */
	long rpush(String key, Object obj);

	/**
	 * 设置到哈希表 key中,如果 key不存在，一个空哈希表被创建并执行 HMSET操作。
	* @Title: hmset
	* @Description: 设置到哈希表 key中,如果 key不存在，一个空哈希表被创建并执行 HMSET操作。
	* @param @param key
	* @param @param obj    参数
	* @return void    返回类型
	* @throws
	 */
	void hmset(String key, Object obj);

	/**
	 * 用于返回哈希表中指定key的值
	* @Title: hget
	* @Description: 用于返回哈希表中指定key的值
	* @param @param key
	* @param @param clz
	* @param @return    参数
	* @return T    返回类型
	* @throws
	 */
	<T> T hget(String key, Class<T> clz);

	/**
	 * 删除key
	* @Title: del
	* @Description: 删除key
	* @param @param key    参数
	* @return void    返回类型
	* @throws
	 */
	void del(String key);
	
	/**
	 * 模糊匹配查询所有key("product_price:*")对应的值
	* @Title: hmGetAll
	* @Description: 模糊匹配查询所有key("product_price:*")对应的值
	* @param @param key
	* @param @param clz
	* @param @return    参数
	* @return List<T>    返回类型
	* @throws
	 */
	<T> List<T>  hmGetAll(String key, Class<T> clz);

	/**
	 * 移除并返回列表 key 的头元素。
	* @Title: lpop
	* @Description: 移除并返回列表 key 的头元素。
	* @param @param key
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	String lpop(String key);
	
	/**
	 * set-过期时间
	* @Title: setKeyValueWithExpire  
	* @Description: set-过期时间  
	* @param @param key
	* @param @param value
	* @param @param expireTime 过期时长-秒
	* @return boolean    返回类型  
	* @throws
	 */
	boolean setKeyValueWithExpire(final String key, String value, Long expireTime);

	/**
	 *  redis原子操作
	 * @param key
	 * @param value
	 * @return
	 */
	boolean setNX(String key, String value);
	
	/**
	 * 在redis中set，并设置过期时间
	* @Title: set
	* @Description: 在redis中set，并设置过期时间
	* @param @param key
	* @param @param value
	* @param @param expire 过期时间（秒）
	* @return boolean    返回类型
	* @throws
	 */
	boolean setex(String key, String value, long expire);

	/**
	 * 向一张hash表中放入数据,如果不存在将创建
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	void hset(String key, String hashKey, Object value);

	/**
	 * hashSet
	 * @param key
	 * @param value
	 */
	void hmset(String key, Map<String, Object> value);

	/**
	 *	HashSet 并设置时间
	 * @param key	键
	 * @param value	对应多个键值
	 * @param time	时间(秒)
	 */
	void hmset(String key, Map<String, Object> value, long time);

	/**
	 * 同key和hashKey获取值
	 * @param key
	 * @param hashKey
	 * @param c
	 * @return
	 */
	<T> T hget(String key, String hashKey, Class<T> c);

	/**
	 * 获取hashKey对应的所有键值
	 * @param key
	 * @return
	 */
	Map<String,Object> hmget(String key);

	/**
	 * 删除hash表中的值
	 * @param key	键 不能为null
	 * @param objects	项 可以是多个 不能为null
	 */
	void hdel(String key, Object... objects);

	/**
	 * hash递增 如果不存在,就会创建一个 并把新增后的值返回
	 * @param key	键
	 * @param item	项
	 * @param by	要增加几(大于0)
	 * @return
	 */
	Long hincr(String key, String item, Long by);

	/**
	 * hash递减
	 * @param key	键
	 * @param item	项
	 * @param by	要减少几(小于0)
	 * @return
	 */
	Long hdecr(String key, String item, Long by);

	/**
	 * 判断hash表中是否有该项的值
	 * @param key	键 不能为null
	 * @param item	项 不能为null
	 * @return
	 */
	boolean hHasKey(String key, String item);


	String getTwo();

}
