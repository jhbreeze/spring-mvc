package hello.springmvc.itemservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import hello.springmvc.itemservice.domain.item.Item;
import hello.springmvc.itemservice.dto.ItemParamDto;

@Repository
public class ItemRepository {

	private static final Map<Long, Item> store = new ConcurrentHashMap<>() {}; // static
	private static final AtomicLong sequence = new AtomicLong(0L); // static

	public Item save(Item item) {
		item.setId(sequence.incrementAndGet());
		store.put(item.getId(), item);
		return item;
	}

	public Item findById(Long id) {
		return store.get(id);
	}

	public List<Item> findAll() {
		return new ArrayList<>(store.values());
	}

	public void update(Long itemId, ItemParamDto updateParam) {
		Item findItem = findById(itemId);
		findItem.updateFrom(updateParam);
	}

	public void clearStore() {
		store.clear();
	}

}