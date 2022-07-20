package com.octa.gestorpedidos.services;

import com.octa.gestorpedidos.exceptions.RestException;
import com.octa.gestorpedidos.models.Item;
import com.octa.gestorpedidos.repository.ItemRepository;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ApiResponse<List<Item>> findAll() {
        return new ApiResponse<>(itemRepository.findAll());
    }

    public ApiResponse<Item> findById(Long id) {
        return new ApiResponse<>(itemRepository.findById(id).orElse(null));
    }

    public ApiResponse<Item> save(Item item) {
        return new ApiResponse<>(itemRepository.save(item));
    }

    public ApiResponse<Item> update(Item item) {
        if (item.getId() == null) {
            throw new RestException("Item id does not exist");
        }
        return new ApiResponse<>(itemRepository.save(item));
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
