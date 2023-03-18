package lecture.aop.service;

import lecture.aop.MyBenchmark;
import org.springframework.stereotype.Service;

@Service
public class OtherUserHandler {

    @MyBenchmark
    public void delete() {
        System.out.println("Other delete");
    }
}
