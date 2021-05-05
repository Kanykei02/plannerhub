package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Tips;

import java.util.List;

public interface TipsService {
    Tips save(Tips tips);
    List<Tips> getAllTips();
    Tips findById(Long id);
    Tips deleteById(Long id);
    List<Tips> deleteAllTips();

}
