package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Region;

// 8th mission
public interface RegionRepository extends JpaRepository<Region, Long> {
}
