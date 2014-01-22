package controllers

import play.api.mvc._
import org.springframework.beans.factory.annotation.Autowired
import services.HelloService

/**
 * Component 로 사용하려면 Application 을 object 가 아닌 class 로 정의해야 한다.
 */
@org.springframework.stereotype.Controller
class Application extends Controller {

  @Autowired val helloService: HelloService = null

  def index = Action {
        Ok(views.html.index(helloService.hello))
    }
}