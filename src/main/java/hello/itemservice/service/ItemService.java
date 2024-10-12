package hello.itemservice.service;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepo;

    public ItemService(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Item findById(Long itemId) {
        return itemRepo.findById(itemId).orElseThrow(() ->
                new IllegalArgumentException("선택한 item은 존재하지 않습니다.")
        );
    }
}
