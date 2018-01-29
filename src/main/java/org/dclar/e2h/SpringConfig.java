package org.dclar.e2h;


import org.dclar.e2h.aop.ExecutorAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan({"org.dclar.e2h.processor.*", "org.dclar.e2h.core.*"})
public class SpringConfig {


    @Bean
    public ExecutorAspect executorAspect() {
        return new ExecutorAspect();
    }


//    /**
//     * 执行excel解析过程的Processor的实例
//     *
//     * @return Processor的实例
//     */
//    @Bean
//    public Processor processor() {
//        return new ProcessorImpl();
//    }
//
//
//    /**
//     * 前处理executor
//     *
//     * @return PreExecutorImpl
//     */
//    @Bean
//    public PreExecutor preExecutor() {
//        return new PreExecutorImpl();
//    }
//
//
//    /**
//     * 核心处理executor
//     *
//     * @return
//     */
//    @Bean
//    public Executor executor() {
//        return new DefaultExecutorImpl();
//    }
//
//
//    /**
//     * 输出writer
//     *
//     * @return
//     */
//    @Bean
//    public Writer writer() {
//        return new ConsoleWriterImpl();
//    }


}
