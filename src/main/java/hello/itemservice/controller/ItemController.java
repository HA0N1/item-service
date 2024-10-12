package hello.itemservice.controller;

import hello.itemservice.domain.Item;
import hello.itemservice.dto.ItemResponseDto;
import hello.itemservice.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<ItemResponseDto> findById(@PathVariable Long itemId) {
        Item item = itemService.findById(itemId);
        ItemResponseDto responseDto = new ItemResponseDto(item);
        return ResponseEntity.ok(responseDto);
    }
}
