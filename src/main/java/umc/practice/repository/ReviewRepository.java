package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Review;

// 8th mission
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
