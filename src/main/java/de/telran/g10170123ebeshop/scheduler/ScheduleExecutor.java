package de.telran.g10170123ebeshop.scheduler;

import de.telran.g10170123ebeshop.domain.entity.jpa.Task;
import de.telran.g10170123ebeshop.service.jpa.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableScheduling
@EnableAsync
public class ScheduleExecutor {

@Autowired
    private TaskService service;

    private static Logger logger = LoggerFactory.getLogger(ScheduleExecutor.class);

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//
//        Task task = new Task("Fixed delay task");
//        logger.info(task.getDescription());
//
//
//
//        service.save(task);
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//
//        Task task = new Task("Fixed delay task");
//        logger.info(task.getDescription());
//
//
//
//        service.save(task);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//
//        Task task = new Task("Fixed delay task 7 sec");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//
//        Task task = new Task("Fixed RATE task 3 sec");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//
//        Task task = new Task("Fixed RATE task 3 sec");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

//    @Scheduled(fixedRate = 5000)
//    @Async
//    public void fixedRateAsyncTask() {
//
//        Task task = new Task("Fixed RATE async task 7 sec");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

//    @Scheduled(fixedDelay = 5000, initialDelay = 20000)
//
//    public void initialDelayTask() {
//
//        Task task = new Task("initial delay task");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


    //fixedDelay = 7200000 => PT02H
//    @Scheduled(fixedDelayString = "PT03S")
//
//    public void anotherDelayFormatTask() {
//
//        Task task = new Task("another delay format task");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

//    @Scheduled(fixedDelayString = "${interval}")
//
//    public void delayInPropertiesTask() {
//
//        Task task = new Task("Delay in properties task");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    //55 * * * * * * -> every minute in 55 sec
    // 0 15 9-17 * * MON-FRI -> v 15 minut kazdogo chasa s 9 do 17 v budnie dni
//    @Scheduled(cron = "${cron-interval}")
//
//    public void cronExpressionTask() {
//
//        Task task = new Task("Cron expression task");
//        logger.info(task.getDescription());
//        service.save(task);
//
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


    public static void executeTask(Task task){
        TaskScheduler scheduler = new DefaultManagedTaskScheduler();

        //zapuskaet zadachu posle opredelonnogo sobitija po raspisaniju
//        scheduler.schedule(() -> logger.info(task.getDescription()), new CronTrigger("0,10,20,30,50 * * * * *"));


//zapuskaet zadachu posle opredeljonnogo sobitija razovo
    logger.info("metod execute task called");
        Instant instant = Instant.now().plusSeconds(20);
        scheduler.schedule(() -> logger.info(task.getDescription()), instant);
    }

}
