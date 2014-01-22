package services

import org.springframework.stereotype.Service

/**
 * services.HelloService 
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2014. 1. 22. 오후 1:24
 */
@Service
class HelloService {

  def hello: String = "Spring Injection Test"

}
