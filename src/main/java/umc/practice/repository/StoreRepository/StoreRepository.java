package umc.practice.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
