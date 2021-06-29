package com.cb;

import com.cb.beans.WishMessageGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class Ntspbms714BootProj1DependencyInjectionApplication {

    @Bean("ltd")
    public LocalDateTime ltd(){
        LocalDateTime ltd=LocalDateTime.now();
        return ltd;
    }

    @Bean("ltd1")
    public LocalDateTime ltd1(){
        LocalDateTime ltd=LocalDateTime.now();
        return ltd;
    }

    public static void main(String[] args) {
      ApplicationContext ctx= SpringApplication.run(Ntspbms714BootProj1DependencyInjectionApplication.class, args);
        Ntspbms714BootProj1DependencyInjectionApplication bean=ctx.getBean("ntspbms714BootProj1DependencyInjectionApplication",Ntspbms714BootProj1DependencyInjectionApplication.class);
        System.out.println(bean.getClass()+ " " +bean.hashCode());
        System.out.println("========================================");
        LocalDateTime ltd=ctx.getBean("ltd",LocalDateTime.class);
        System.out.println(ltd.getClass()+" "+ltd.hashCode());
        System.out.println("All Bean ids "+ Arrays.toString(ctx.getBeanDefinitionNames()));
        System.out.println("Bean Count "+ctx.getBeanDefinitionCount());
        System.out.println(ctx.getClass());
        WishMessageGenerator wmg=ctx.getBean("wmg",WishMessageGenerator.class);
        String result=wmg.generateWishMessage("Dhruv");
        System.out.println(result);

        ((ConfigurableApplicationContext)ctx).close();

    }

}
