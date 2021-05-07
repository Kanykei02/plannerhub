package kg.ItAcademy.plannerhub.repository;

import kg.ItAcademy.plannerhub.entity.Planner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannerRepository extends JpaRepository<Planner, Long> {
}
