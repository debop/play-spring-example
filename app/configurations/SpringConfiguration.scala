package configurations

import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import kr.debop4s.core.spring.Springs

/**
 * configurations.SpringConfiguration 
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2014. 1. 22. 오후 1:21
 */
@Configuration
@ComponentScan(basePackages = Array("controllers", "services"))
class SpringConfiguration {

}
