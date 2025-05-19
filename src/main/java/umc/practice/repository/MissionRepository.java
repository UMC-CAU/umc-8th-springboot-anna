package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Mission;
import umc.practice.domain.Review;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
