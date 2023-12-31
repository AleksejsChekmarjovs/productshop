package de.telran.g10170123ebeshop.logging;

import de.telran.g10170123ebeshop.domain.entity.common.CommonProduct;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);
@Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.addProduct(..))")
    public void addProduct(){}

    @Before("addProduct()")
    public void beforeAddingProduct(JoinPoint joinPoint){
    Object[] params = joinPoint.getArgs();
    logger.info("Vizvan metod addProduct classa JpaProductService s parametrami {}.", params[0]);
    }

    @After("addProduct()")
    public void afterAddingProduct(JoinPoint joinPoint){
        Object[] params = joinPoint.getArgs();
        logger.info("Sohranennomu productu prisvoen ID {}.", ((CommonProduct) params[0]).getId());
    }
    @Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.getCount(..))")
    public void getCount(){}

    @AfterReturning("getCount()")
    public void afterProductCountReturning(){
logger.info("metod getCount uspeshno vernul znachenie");
    }


    @Pointcut("execution(* de.telran.g10170123ebeshop.service.jpa.JpaProductService.deleteById(..))")
    public void deleteById(){}

    @AfterThrowing("deleteById()")
    public void throwsExceptionIfIdIsIncorrect(JoinPoint joinPoint){
    Object[] params = joinPoint.getArgs();
    logger.error("Metod deleteById vibrosil iskljuchenije. Nekorrektnij ID - {}.", params[0]);
    }


    @Around("getCount()")
    public Object aroundGetProductCount(ProceedingJoinPoint joinPoint){
    logger.info("Otrabotal Around metoda getCount()");
    try {
        Object result = joinPoint.proceed();
        logger.info("Metod getCount otrabotal s rezuljtatom {}. ", result);
//        logger.info("podmenjaem rezultat i vozvrashaem 777");
        return result;
    } catch (Throwable e){
        throw new RuntimeException(e);
    }
    }
}
