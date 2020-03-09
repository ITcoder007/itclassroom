//package com.xg.demo.redis;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.jiatui.common.util.JsonUtil;
//
//
///**
// * redis服务实现类
// * @author  liukang
// * @date  2018-12-14
// */
//@Service
//@Transactional(rollbackFor = Exception.class)
//public class RedisServiceImpl implements RedisService {
//
//	@Autowired
//	private RedisTemplate<String, ?> redisTemplate;
//
//	@Override
//	public boolean set(final String key, final String value) {
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			@Override
//			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				connection.set(serializer.serialize(key), serializer.serialize(value));
//				return true;
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public boolean set(String key, String value, Long expire) {
//
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			@Override
//			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				connection.set(serializer.serialize(key), serializer.serialize(value));
//				if (expire > 0) {
//					redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//				}
//				return true;
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public String get(final String key) {
//		String result = redisTemplate.execute(new RedisCallback<String>() {
//			@Override
//			public String doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				byte[] value = connection.get(serializer.serialize(key));
//				return serializer.deserialize(value);
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public void del(final String key) {
//		redisTemplate.execute(new RedisCallback<Long>() {
//			@Override
//			public Long doInRedis(RedisConnection conn) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				return conn.del(serializer.serialize(key));
//			}
//		});
//	}
//
//	@Override
//	public boolean expire(final String key, long expire) {
//		return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//	}
//
//	@Override
//	public <T> boolean setList(String key, List<T> list) {
//		String value = JsonUtil.getJsonString(list);
//		return set(key, value);
//	}
//
//	@Override
//	public <T> List<T> getList(String key, Class<T> clz) {
//		String json = get(key);
//		if (json != null) {
//			List<T> list = JsonUtil.readJson2Array(json, clz);
//			return list;
//		}
//		return null;
//	}
//
//	@Override
//	public long lpush(final String key, Object obj) {
//		final String value = JsonUtil.getJsonString(obj);
//		long result = redisTemplate.execute(new RedisCallback<Long>() {
//			@Override
//			public Long doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
//				return count;
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public long rpush(final String key, Object obj) {
//		final String value = JsonUtil.getJsonString(obj);
//		long result = redisTemplate.execute(new RedisCallback<Long>() {
//			@Override
//			public Long doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
//				return count;
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public void hmset(String key, Object obj) {
//		Map<byte[], byte[]> data = JsonUtil.readJsonByteMap(JsonUtil.getJsonString(obj));
//		redisTemplate.execute(new RedisCallback<String>() {
//			@Override
//			public String doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				connection.hMSet(serializer.serialize(key), data);
//				return "";
//			}
//		});
//	}
//
//	@Override
//	public <T> T hget(String key, Class<T> clz) {
//		return redisTemplate.execute(new RedisCallback<T>() {
//
//			@Override
//			public T doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//
//				Map<String, Object> result;
//
//				Map<byte[], byte[]> data = connection.hGetAll(serializer.serialize(key));
//				result = new HashMap<>(16);
//				for (Map.Entry<byte[], byte[]> entry : data.entrySet()) {
//					result.put(serializer.deserialize(entry.getKey()), serializer.deserialize(entry.getValue()));
//				}
//
//				return JsonUtil.json2Obj(JsonUtil.getJsonString(result), clz);
//			}
//		});
//	}
//
//	@Override
//	public <T> List<T> hmGetAll(String key, Class<T> clz) {
//		List<Map<String, Object>> dataList = new ArrayList<>();
//		return redisTemplate.execute(new RedisCallback<List<T>>() {
//			@Override
//			public List<T> doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//
//				Set<String> keysSet = redisTemplate.keys(key);
//				Map<byte[], byte[]> data;
//				Map<String, Object> result;
//				for (String newKey : keysSet) {
//					data = connection.hGetAll(serializer.serialize(newKey));
//					result = new HashMap<>(16);
//					for (Map.Entry<byte[], byte[]> entry : data.entrySet()) {
//						result.put(serializer.deserialize(entry.getKey()), serializer.deserialize(entry.getValue()));
//					}
//					dataList.add(result);
//				}
//				return JsonUtil.readJson2Array(JsonUtil.getJsonString(dataList), clz);
//			}
//		});
//	}
//
//	@Override
//	public String lpop(final String key) {
//		String result = redisTemplate.execute(new RedisCallback<String>() {
//			@Override
//			public String doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				byte[] res = connection.lPop(serializer.serialize(key));
//				return serializer.deserialize(res);
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public boolean setKeyValueWithExpire(String key, String value, Long expireTime) {
//
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			@Override
//			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				connection.set(serializer.serialize(key), serializer.serialize(value));
//				if (expireTime != null) {
//					redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//				}
//				return true;
//			}
//		});
//		return result;
//	}
//
//
//	@Override
//	public boolean setNX(final String key, final String value) {
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			@Override
//			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				connection.setNX(serializer.serialize(key), serializer.serialize(value));
//				return true;
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public boolean setex(String key, String value, long expire) {
//
//		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//			@Override
//			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//				connection.setEx(serializer.serialize(key), expire, serializer.serialize(value));
//				return true;
//			}
//		});
//		return result;
//	}
//
//	@Override
//	public void hset(String key, String hashKey, Object value) {
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		hashOperations.put(key, hashKey, JsonUtil.getJsonString(value));
//	}
//
//	@Override
//	public void hmset(String key, Map<String, Object> value) {
//
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		if (Objects.isNull(value)){
//			return;
//		}
//		Map<String, String> stringValue = new HashMap<>(16);
//		for (Map.Entry<String, Object> entry : value.entrySet()) {
//			stringValue.put(entry.getKey(), JsonUtil.getJsonString(entry.getValue()));
//		}
//		hashOperations.putAll(key, stringValue);
//	}
//
//	@Override
//	public void hmset(String key, Map<String, Object> value, long time) {
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		Map<String, String> stringValue = new HashMap<>(16);
//		for (Map.Entry<String, Object> entry : value.entrySet()) {
//			stringValue.put(entry.getKey(), JsonUtil.getJsonString(entry.getValue()));
//		}
//		hashOperations.putAll(key, stringValue);
//		if (time >0){
//			expire(key, time);
//		}
//	}
//
//	@Override
//	public <T> T hget(String key, String hashKey, Class<T> c) {
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		String value = hashOperations.get(key, hashKey);
//		if(Objects.isNull(value)){
//			return null;
//		}
//		return JsonUtil.toBean(value, c);
//	}
//
//	@Override
//	public Map<String, Object> hmget(String key) {
//		HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
//		Map<String,Object> result = null;
//		try {
//			result = hashOperations.entries(key);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@Override
//	public void hdel(String key, Object... objects) {
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		hashOperations.delete(key, objects);
//	}
//
//	@Override
//	public Long hincr(String key, String item, Long by) {
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		return hashOperations.increment(key, item, by);
//	}
//
//	@Override
//	public Long hdecr(String key, String item, Long by) {
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		return hashOperations.increment(key, item, -by);
//	}
//
//	@Override
//	public boolean hHasKey(String key, String item) {
//		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
//		return hashOperations.hasKey(key, item);
//	}
//
//	@Override
//	public String getTwo() {
//
//		ValueOperations<String, String> stringValueOperations = (ValueOperations<String, String>) this.redisTemplate.opsForValue();
//		stringValueOperations.set("test123", "test123");
//		String o = stringValueOperations.get("test123");
//
//		return o;
//	}
//}
