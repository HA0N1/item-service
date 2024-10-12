package hello.itemservice.dto;

import hello.itemservice.domain.Item;

public class ItemResponseDto {
    private Long id;
    private String name;
    private Integer price;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
