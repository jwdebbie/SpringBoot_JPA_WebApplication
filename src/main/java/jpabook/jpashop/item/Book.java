package jpabook.jpashop.item;

import jakarta.persistence.Entity;
import jpabook.jpashop.domain.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
