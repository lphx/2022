//package com.example.jedis;
//
///**
// * @ClassName: JedisSentinelTest
// * @Author: lph
// * @Description:
// * @Date: 2022/2/23 1:51
// */
//public class JedisSentinelTest {
//    public static void main(String[] args) {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(20);
//        config.setMaxIdle(10);
//        config.setMinIdle(5);
//
//        String masterName = "mymaster";
//        Set<String> sentinels = new HashSet<String>();
//        sentinels.add(new HostAndPort("192.168.0.60",26379).toString());
//        sentinels.add(new HostAndPort("192.168.0.60",26380).toString());
//        sentinels.add(new HostAndPort("192.168.0.60",26381).toString());
//        //JedisSentinelPool其实本质跟JedisPool类似，都是与redis主节点建立的连接池
//        //JedisSentinelPool并不是说与sentinel建立的连接池，而是通过sentinel发现redis主节点并与其建立连接
//        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, config, 3000, null);
//        Jedis jedis = null;
//        try {
//            jedis = jedisSentinelPool.getResource();
//            System.out.println(jedis.set("sentinel", "zhuge"));
//            System.out.println(jedis.get("sentinel"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //注意这里不是关闭连接，在JedisPool模式下，Jedis会被归还给资源池。
//            if (jedis != null)
//                jedis.close();
//        }
//    }
//}
