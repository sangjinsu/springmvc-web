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

