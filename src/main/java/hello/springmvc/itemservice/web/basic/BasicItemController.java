package hello.springmvc.itemservice.web.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.springmvc.itemservice.domain.item.Item;
import hello.springmvc.itemservice.dto.ItemParamDto;
import hello.springmvc.itemservice.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

	private final ItemRepository itemRepository;

	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);

		return "basic/items";
	}

	@GetMapping("/{itemId}")
	public String item(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);

		return "basic/item";
	}

	@GetMapping("/add")
	public String addForm() {
		return "basic/addForm";
	}

	//@PostMapping("/add")
	public String addItemV1(@RequestParam String itemName, @RequestParam int price, @RequestParam Integer quantity, Model model) {

		Item item = new Item();
		item.setItemName(itemName);
		item.setPrice(price);
		item.setQuantity(quantity);

		itemRepository.save(item);
		model.addAttribute("item", item);

		return "basic/item";
	}

	//@PostMapping("/add")
	public String addItemV2(@ModelAttribute("item") Item item, Model model) {

		itemRepository.save(item);
		// model.addAttribute("item", item); // 생략 가능

		return "basic/item";
	}

//	@PostMapping("/add")
	public String addItemV3(@ModelAttribute Item item, Model model) {

		itemRepository.save(item);

		return "basic/item";
	}

	@PostMapping("/add")
	public String addItemV4(Item item) {

		itemRepository.save(item);

		return "basic/item";
	}

	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);

		return "basic/editForm";
	}

	@PostMapping("/{itemId}/edit")
	public String editItemV4(@PathVariable Long itemId, @ModelAttribute ItemParamDto paramDto) {
		itemRepository.update(itemId, paramDto);
		return "redirect:/basic/items/{itemId}";
	}



	/**
	 * 테스트용 데이터 추가 */
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("testA", 10000, 10));
		itemRepository.save(new Item("testB", 20000, 20));
	}
}
