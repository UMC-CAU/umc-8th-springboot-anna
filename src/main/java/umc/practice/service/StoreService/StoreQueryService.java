package umc.practice.service.StoreService;

import org.springframework.data.domain.Page;
import umc.practice.domain.Review;
import umc.practice.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    // 9th 실습
    Page<Review> getReviewList(Long StoreId, Integer page);

}
