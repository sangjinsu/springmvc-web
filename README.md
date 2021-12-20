# 스프링 MVC - 웹 페이지 만들기

###  thymeleaf 리터럴 대체

```html
    <div class="row">
        <div class="col">
            <button class="btn btn-primary float-end"
                    onclick="location.href='addForm.html'"
                    th:onclick="|locattion.href='@{/basic/items/add}'|"
                    type="button">상품 등록
            </button>
        </div>
    </div>
```

- 타임리플에서 문자와 표현식 등은 분리되어 있기 때문에 더해서 사용해야 한다.

  `th:onclick="'locattion.href=' + '\'' + @{/basic/items/add} + '\''"`

- 다음과 같이 리터럴 대체 문법을 사요하면 더하기 없이 편리하게 사용할 수 있다.

  `th:onclick="|locattion.href='@{/basic/items/add}'|"`



### 반복 출력

```html
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>상품명</th>
                <th>가격</th>
                <th>수량</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="item : ${items}">
                <td><a
                        href="item.html"
                        th:href="@{/basic/items/{itemId}(itemId=${item.id})}"
                        th:text="${item.id}">회원 아이디</a></td>
                <td><a href="item.html"
                       th:href="@{/basic/items/{itemId}(itemId=${item.id})}"
                       th:text="${item.itemName}">상품명</a></td>
                <td th:text="${item.price}">10000</td>
                <td th:text="${item.quantity}">10</td>
            </tr>
            </tbody>
        </table>
```



### 속성 변경 - th:action

- th:action
- action에 값이 없으면 현재 URL에 데이터를 전송한다 



### @ModelAttribute - Model  추가 

- @ModelAttribute로 지정한 객체를 자동으로 넣어준다  

```java
    @PostMapping("/add")
    public String addItemV2(
            @ModelAttribute("item") Item item,
            Model model
    ) {
        itemRepository.save(item);

        // model.addAttribute("item", item);
        return "basic/item";
    }
```



### addItem 상품 등록 처리 단계

```java
//    @PostMapping("/add")
//    public String addItemV1(
//            @RequestParam String itemName,
//            @RequestParam Integer price,
//            @RequestParam Integer quantity,
//            Model model
//    ) {
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setPrice(price);
//        item.setQuantity(quantity);
//
//        itemRepository.save(item);
//
//        model.addAttribute("item", item);
//        return "basic/item";
//    }

//    @PostMapping("/add")
//    public String addItemV2(
//            @ModelAttribute("item") Item item,
//            Model model
//    ) {
//        itemRepository.save(item);
//
//        // model.addAttribute("item", item);
//        return "basic/item";
//    }

//    @PostMapping("/add")
//    public String addItemV3(
//            @ModelAttribute("item") Item item
//    ) {
//        itemRepository.save(item);
//        return "basic/item";
//    }

    @PostMapping("/add")
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }
```

