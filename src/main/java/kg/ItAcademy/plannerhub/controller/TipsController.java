package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.Tips;
import kg.ItAcademy.plannerhub.service.TipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tips")
public class TipsController {
    @Autowired
    private TipsService tipsService;

    @PostMapping
    public Tips createOrUpdate(@RequestBody Tips tips) {
        return tipsService.save(tips);
    }

    @GetMapping
    public List<Tips> getAllTips() {
        return tipsService.getAllTips();
    }

    @GetMapping("/{tipId}")
    public Tips getById(@PathVariable Long tipId) {
        return tipsService.findById(tipId);
    }

    @DeleteMapping("/{tipId}")
    public Tips deleteById(@PathVariable long tipId) {
        return tipsService.deleteById(tipId);
    }

    @DeleteMapping
    public List<Tips> deleteAllTips() {
        return tipsService.deleteAllTips();
    }
}
