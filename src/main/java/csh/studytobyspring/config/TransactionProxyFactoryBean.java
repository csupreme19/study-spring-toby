package csh.studytobyspring.config;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import java.lang.reflect.Proxy;

@Setter
public class TransactionProxyFactoryBean implements FactoryBean<Object> {

    Object target;

    PlatformTransactionManager transactionManager;

    public Object getObject() {
        TransactionHandler txHandler = new TransactionHandler();
        txHandler.setTarget(target);
        txHandler.setTransactionManager(transactionManager);
        return Proxy.newProxyInstance(getClass().getClassLoader()
                , new Class[]{serviceInterface}, txHandler);
    }

    String pattern;
    Class<?> serviceInterface;

    public Class<?> getObjectType() {
        return serviceInterface;
    }

    public boolean isSingleton() {
        return false;
    }

}
