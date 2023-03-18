package homework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {

    @Pointcut("@annotation(homework.annotation.TimeCheck)")
    public void pointCutForTimeCheck() {}

    @Around("pointCutForTimeCheck()")
    public Object runAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();
        var duration = end - begin;
        System.out.println("Время заезда: " + duration);

        return proceed;
    }
}
