Spring 을 이용한 Dependency Injection 사용하기
=====================================

## Global 제작

app/Global 을 생성하여 다음과 같이 구현한다.

    object Global extends GlobalSettings {

      var ctx: ApplicationContext = _

      override def onStart(app: Application) {
        super.onStart(app)
        ctx = new AnnotationConfigApplicationContext(classOf[SpringConfiguration])
      }

      override def getControllerInstance[A](controllerClass: Class[A]): A =
        ctx.getBean(controllerClass)

    }

## Spring Configuration 파일

Spring Configuration 구현은 java 와 유사하다. 다만 annotation 구현에 주의를 해야 한다.

    @Configuration
    @ComponentScan(basePackages = Array("controllers", "services"))
    class SpringConfiguration {
    }

Scala Object 에 대해서는 기본적으로 bean 을 만들 수 없으므로, Scala Object 에
다음과 같이 instance 메소드를 제작한 후, Configuration 파일에서 @Bean으로 등록해야 한다.

    object SomeObject {
        def instance = SomeObject.this
    }

    // Configuration class에서
    @Bean def someObject() = SomeObject.instance

## Controller 를 Spring Bean으로 사용하려면

#### app/Application 을 @Component 로 정의하기

기본적으로 Application은 scala object 입니다만, @Component로 사용하기 위해서는 class 로 변경해야 합니다.
나머지는 똑 같이 적용하면 됩니다.

#### routes 에서 @Component로 등록된 Controller 사용
routes 에서 일반적인 play Controller 에 대해서는 controllers.Application.index 처럼 해당 object 를 직접 적용할 수 있지만,
spring의 bean 으로 만들어지는 Application 은 class 이므로 꼭 *@controller* 로 정의해야 합니다.
이렇게 하면 Global 의 getControllerInstance 메소드를 통해 해당 bean을 제공합니다.

    @org.springframework.stereotype.Controller
    class Application extends Controller {

        @Autowired var helloService: HelloService = _

        def index = Action {
            Ok(views.html.index(helloService.hello))
        }
    }
