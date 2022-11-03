package com.github.renamrgb.mscartoes.application;

import com.github.renamrgb.mscartoes.application.representation.CartForClientResponse;
import com.github.renamrgb.mscartoes.application.representation.CartSaveRequest;
import com.github.renamrgb.mscartoes.domain.Cart;
import com.github.renamrgb.mscartoes.domain.ClientCart;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("carts")
@RequiredArgsConstructor
public class CartsController {

    private final CartService cartService;
    private final ClientCartService clientCartService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartSaveRequest request) {
        Cart cart = request.toModel();
        cartService.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping(params = "income")
    public ResponseEntity<List<Cart>> getCartsFindIncomePlus(@RequestParam("income") Long income) {
        List<Cart> cartList = cartService.getCartsByIncomeLesserEqual(income);
        return ResponseEntity.ok(cartList);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartForClientResponse>> getCartsByCpf(@RequestParam("cpf") String cpf) {
        List<ClientCart> cartsByCpf = clientCartService.findCartsByCpf(cpf);
        List<CartForClientResponse> resultList = cartsByCpf.stream()
                .map(CartForClientResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
