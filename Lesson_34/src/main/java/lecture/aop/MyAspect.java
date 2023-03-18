package lecture.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("@annotation(lecture.aop.MyBenchmark)")
    public void pointCutForBenchmark() {}

    @Around("pointCutForBenchmark()")
    public void runAdvice(ProceedingJoinPoint joinPoint) {

        long begin = System.currentTimeMillis();
        System.out.println("Время запуска: " + begin);

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("Время окончания: " + end);
        var duration = end - begin;
        System.out.println("Время выполнения метода: " + duration);
    }

}
