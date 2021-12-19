package hello.serviceitem.domain;


import hello.serviceitem.dto.UpdateParamDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("ItemA", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        Item itemA = new Item("ItemA", 10000, 10);
        Item itemB = new Item("ItemB", 10000, 10);
        itemRepository.save(itemA);
        itemRepository.save(itemB);

        List<Item> result = itemRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(itemA, itemB);
    }

    @Test
    void update() {
        Item itemA = new Item("ItemA", 10000, 10);

        Item savedItem = itemRepository.save(itemA);
        Long itemId = savedItem.getId();

        UpdateParamDto updateParamDto = new UpdateParamDto("ItemB", 20000, 30);
        itemRepository.update(itemId, updateParamDto);

        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updateParamDto.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParamDto.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParamDto.getQuantity());

    }
}