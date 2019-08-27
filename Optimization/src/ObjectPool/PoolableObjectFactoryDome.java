package ObjectPool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolableObjectFactoryDome<T> implements PooledObjectFactory<Object> {
    private static AtomicInteger counter = new AtomicInteger(0);


    @Override
    public PooledObject<Object> makeObject() throws Exception {
        Object obj = String.valueOf(counter.getAndIncrement());
        System.out.println("create Object " + obj);
        PooledObject<Object> pooledObject = new DefaultPooledObject<>(obj);
        return  pooledObject;
    }


    @Override
    public void destroyObject(PooledObject<Object> pooledObject) throws Exception {
        System.out.println("Destroy Object " + pooledObject);
    }

    @Override
    public boolean validateObject(PooledObject<Object> pooledObject) {
        return false;
    }

    @Override
    public void activateObject(PooledObject<Object> pooledObject) throws Exception {
        System.out.println("Before borrow " + pooledObject);
    }

    @Override
    public void passivateObject(PooledObject<Object> pooledObject) throws Exception {
        System.out.println("return " + pooledObject);
    }


}
