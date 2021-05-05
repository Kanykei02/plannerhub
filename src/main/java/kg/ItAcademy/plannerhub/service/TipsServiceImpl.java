package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.Tips;
import kg.ItAcademy.plannerhub.repository.TipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipsServiceImpl implements TipsService {
    @Autowired
    private TipsRepository tipsRepository;

    @Override
    public Tips save(Tips tips) {
        return tipsRepository.save(tips);
    }

    @Override
    public List<Tips> getAllTips() {
        return tipsRepository.findAll();
    }

    @Override
    public Tips findById(Long id) {
        return tipsRepository.findById(id).orElse(null);
    }

    @Override
    public Tips deleteById(Long id) {
        Tips tips = findById(id);
        if (tips != null){
            tipsRepository.delete(tips);
            return tips;
        }
        return null;
    }

    @Override
    public List<Tips> deleteAllTips() {
        List<Tips> tips = getAllTips();
        if (tips != null) {
            tipsRepository.deleteAll(tips);
        }
        return null;
    }
}
