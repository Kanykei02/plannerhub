package kg.ItAcademy.plannerhub.scheduler;


import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.service.TipsService;
import kg.ItAcademy.plannerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class Scheduler {
    @Autowired
    private TipsService tipsService;

    @Autowired
    private UserService userService;

    @Scheduled(cron = "*/25 * * * * *")
    public void sayHello() {
        List<User> allUsers = userService.getAllUsers();
        Random rnd = new Random();
        int max = tipsService.getAllTips().size(); // Размер списка типсов
        for (User u : allUsers) { // Проходимся по всем юзерам
            try { // пытаемся
                int lim = rnd.nextInt((max - 1) + max); // рандомим число
                u.setTipOfTheDay(tipsService.findById((long) lim).getText()); // передаем в энтити юзерам
                userService.save(u); // сохраняем энтити в таблицу
            } catch (NullPointerException ignored) { // ловим исключения, если есть
            }
        }
    }
}
