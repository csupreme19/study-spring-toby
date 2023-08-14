package csh.studytobyspring.advice;

import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Setter
public class TransactionAdvice implements MethodInterceptor {

    PlatformTransactionManager txManager;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        TransactionStatus txStatus = txManager.getTransaction(new DefaultTransactionDefinition());
        try {
            Object ret = invocation.proceed();
            txManager.commit(txStatus);
            return ret;
        } catch (RuntimeException e) {
            txManager.rollback(txStatus);
            throw e;
        }
    }
}
