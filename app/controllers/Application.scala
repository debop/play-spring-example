package controllers

import play.api._
import play.api.mvc._
import org.springframework.beans.factory.annotation.Autowired
import services.HelloService

/**
 * Component 로 사용하려면 Application 을 object 가 아닌 class 로 정의해야 한다.
 */
@org.springframework.stereotype.Controller
class Application extends Controller {

    @Autowired var helloService: HelloService = _

    def index = Action {
        Ok(views.html.index(helloService.hello))
    }
}