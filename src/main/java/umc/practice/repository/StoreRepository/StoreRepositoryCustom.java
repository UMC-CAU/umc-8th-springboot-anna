package umc.practice.repository.StoreRepository;
import umc.practice.domain.Store;
import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
