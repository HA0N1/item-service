package hello.itemservice.controller;

import hello.itemservice.domain.Item;
import hello.itemservice.dto.ItemRequestDto;
import hello.itemservice.dto.ItemResponseDto;
import hello.itemservice.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // item 단건 조회
    @GetMapping("/item/{itemId}")
    public ItemResponseDto findById(@PathVariable Long itemId) {
        Item item = itemService.findById(itemId);
        ItemResponseDto responseDto = new ItemResponseDto(item);
        return responseDto;
    }

    // item 저장
    @PostMapping("/item")
    public ItemResponseDto addItem(@RequestBody ItemRequestDto requestDto) {
        return itemService.save(requestDto);
    }

    //item 다건 조회
    @GetMapping("/items")
    public List<ItemResponseDto> findAll() {
        return itemService.findAll();
    }
}
