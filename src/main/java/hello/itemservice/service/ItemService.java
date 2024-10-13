package hello.itemservice.service;

import hello.itemservice.domain.Item;
import hello.itemservice.dto.ItemRequestDto;
import hello.itemservice.dto.ItemResponseDto;
import hello.itemservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ItemResponseDto save(ItemRequestDto requestDto) {
        Item item = new Item();
        item.setName(requestDto.getName());
        item.setPrice(requestDto.getPrice());
        Item savedItem = itemRepo.save(item);
        return new ItemResponseDto(savedItem);
    }

    public List<ItemResponseDto> findAll() {
        List<Item> items = itemRepo.findAll();
        return items.stream()
                .map(ItemResponseDto::new)
                .collect(Collectors.toList());
    }

    public ItemResponseDto update(Long itemId, ItemRequestDto requestDto) {
        Item item = findById(itemId);
        if (item != null) {
            if (requestDto.getName() != null) {
                item.setName(requestDto.getName());
            }
            if (requestDto.getPrice() != null) {
                item.setPrice(requestDto.getPrice());
            }
            Item updatedItem = itemRepo.save(item);
            return new ItemResponseDto(updatedItem);
        } else {
            throw new IllegalArgumentException("유효하지 않은 아이템 정보입니다.");
        }
    }
}
