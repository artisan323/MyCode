package TestRedis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Jedis jedis = new Jedis("47.103.15.96", 6379);
        String pong = jedis.ping();
        System.out.println(pong);
        //System.out.println(jedis.set("k1", "v1"));
        //System.out.println(jedis.get("k5"));
    }
}
