package umc.practice.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Review;
import org.springframework.data.domain.Page;
import umc.practice.domain.Store;



// 8th mission
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findByMemberId(Long memberId, Pageable pageable);
}
