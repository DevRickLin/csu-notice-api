package cn.magicalsheep.csunoticeapi.task;

import cn.magicalsheep.csunoticeapi.Factory;
import cn.magicalsheep.csunoticeapi.service.StoreService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateTask {

    private final Logger logger = LoggerFactory.getLogger(UpdateTask.class);
    private final StoreService storeService;

    @Scheduled(cron = "0 */10 * * * ?")
    public void update() {
        try {
            storeService.update(Factory.getConfiguration().getUpdate_num_per_pages());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
