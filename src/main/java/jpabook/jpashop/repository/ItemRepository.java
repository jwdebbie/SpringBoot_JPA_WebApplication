package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    public final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            //item은 JPA에 저장하기 전까지 ID 값이 없음
            // 당연히 null일거고 em.persist로 신규로 등록하는 것
            em.persist(item);
        } else {
            // item 값이 있는 경우는 DB에 이미 있는 값 가져오는 것 (=업데이트 하는 셈)
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
