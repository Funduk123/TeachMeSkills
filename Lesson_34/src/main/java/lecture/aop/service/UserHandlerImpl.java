package lecture.aop.service;

import lecture.aop.MyBenchmark;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements UserHandler {

    private final ApplicationContext context;
    private UserHandler self;

    @PostConstruct
    public void init() {
        self = context.getBean(UserHandler.class);
    }

    @Override
    @MyBenchmark
    public void saveUser() {
        System.out.println("Save user");
        self.deleteUser();
    }

    @Override
    @MyBenchmark
    public void deleteUser() {
        System.out.println("Delete user");
    }
}
