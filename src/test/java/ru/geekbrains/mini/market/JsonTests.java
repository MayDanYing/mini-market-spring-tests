package ru.geekbrains.mini.market;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import ru.geekbrains.mini.market.entites.Product;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class JsonTests {

    @Autowired
    private JacksonTester<Product> jackson;

    @Test
    public void jsonSerializationTest() throws Exception {
        Product milk = new Product();
        milk.setId(1L);
        milk.setTitle("Milk");

        assertThat(jackson.write(milk))
                .hasJsonPathNumberValue("$.id")
                .extractingJsonPathStringValue("$.title").isEqualTo("Milk");
    }

    @Test
    public void jsonDeserializationTest() throws Exception {
        String content = "{\"id\": 1,\"title\":\"Milk\"}";
        Product milk = new Product();
        milk.setId(1L);
        milk.setTitle("Milk");

        assertThat(jackson.parse(content)).isEqualTo(milk);
        assertThat(jackson.parseObject(content).getTitle()).isEqualTo("Milk");
    }
}
