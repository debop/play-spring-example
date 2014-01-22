import configurations.SpringConfiguration
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.ApplicationContext
import play.api.{Application, GlobalSettings}

/**
 * .Global 
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2014. 1. 22. 오후 1:19
 */
object Global extends GlobalSettings {

    var ctx: ApplicationContext = _

    override def onStart(app: Application) {
        super.onStart(app)
        ctx = new AnnotationConfigApplicationContext(classOf[SpringConfiguration])
    }

    override def getControllerInstance[A](controllerClass: Class[A]): A =
        ctx.getBean(controllerClass)

}
