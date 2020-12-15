package ru.geekbrains.mini.market;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.mini.market.entites.Product;
import ru.geekbrains.mini.market.repositories.ProductRepository;
import ru.geekbrains.mini.market.service.ProductService;

import java.util.Optional;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void findOneProductTest() {
        Product chocolate = new Product();
        chocolate.setTitle("Chocolate");
        chocolate.setPrice(100);
        chocolate.setId(10L);

        Mockito.doReturn(Optional.of(chocolate))
                .when(productRepository)
                .findById(10L);

        Assertions.assertNotNull(chocolate);
        Assertions.assertEquals("Chocolate", chocolate.getTitle());
    }


}
