package com.taotao.common.service;

import redis.clients.jedis.ShardedJedis;

public interface Function<T> {

	public T callback(ShardedJedis e);

}
