package hello.springmvc.itemservice.domain.item;

import hello.springmvc.itemservice.dto.ItemParamDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class Item {

	private Long id;
	private String itemName;
	private Integer price;
	private Integer quantity;

	public Item(String itemName, Integer price, Integer quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public void updateFrom(ItemParamDto itemParamDto) {
		this.itemName = itemParamDto.getItemName();
		this.price = itemParamDto.getPrice();
		this.quantity = itemParamDto.getQuantity();
	}
}
