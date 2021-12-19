package hello.serviceitem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateParamDto {
    private String itemName;
    private Integer price = 0;
    private Integer quantity = 0;

    public UpdateParamDto() {
    }

    public UpdateParamDto(String itemName, Integer price, Integer quantity) {
    }
}
