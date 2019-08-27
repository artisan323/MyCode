package ObjectPool;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

public class ObjectPoolDemo {
    static PooledObjectFactory<Object> factory = new PoolableObjectFactoryDome();
    static ObjectPool pool = new GenericObjectPool(factory);

    private static AtomicInteger endcount = new AtomicInteger(0);
    public static class PoolThread extends Thread{
        public void run(){
            Object obj = null;
            try{
                for (int i = 0; i < 100; i++){
                    System.out.println("==" + i + "==");
                    obj = pool.borrowObject();
                    System.out.println(obj + "is get");
                    pool.returnObject(obj);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //以原子性操作自增一
                endcount.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        new PoolThread().start();
        new PoolThread().start();
        new PoolThread().start();

        while (true){
            if (endcount.get() == 3){//等待三个线程全部结束
                pool.close();
                break;
            }
        }

    }
}
