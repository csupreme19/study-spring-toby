package csh.studytobyspring;

import csh.studytobyspring.service.MyConcreteService;
import csh.studytobyspring.service.MyService;
import csh.studytobyspring.service.MyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProxyTest {

    @Test
    @DisplayName("JDK 동적 프록시 생성")
    void jdkDynamicProxyTest() {
        MyService target = new MyServiceImpl();
        MyService proxy = (MyService) Proxy.newProxyInstance(MyService.class.getClassLoader(), new Class[]{MyService.class}
                , (proxy1, method, args) -> method.invoke(target, args));

        proxy.call();

        log.info("target={}", target.getClass());
        log.info("proxy={}", proxy.getClass());
        assertThat(Proxy.isProxyClass(proxy.getClass())).isTrue();
    }

    @Test
    @DisplayName("CGLIB 프록시 생성")
    void cglibProxyTest() {
        MyConcreteService target = new MyConcreteService();
        MyConcreteService proxy = (MyConcreteService) Enhancer.create(MyConcreteService.class
                , (MethodInterceptor) (obj, method, args, proxy1) -> method.invoke(target, args));

        proxy.call();

        log.info("target={}", target.getClass());
        log.info("proxy={}", proxy.getClass());
        assertThat(proxy.getClass().getName().contains("$$EnhancerByCGLIB$$")).isTrue();
    }

}
