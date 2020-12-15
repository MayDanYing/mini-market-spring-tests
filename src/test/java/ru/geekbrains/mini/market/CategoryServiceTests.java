package ru.geekbrains.mini.market;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.mini.market.entites.Category;
import ru.geekbrains.mini.market.repositories.CategoryRepository;
import ru.geekbrains.mini.market.service.CategoryService;
import java.util.Optional;

@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;


    @Test
    public void findOneCategoryTest() {
        Category cosmetics = new Category();
        cosmetics.setTitle("Cosmetics");
        cosmetics.setId(3L);

        Mockito.doReturn(Optional.of(cosmetics))
                .when(categoryRepository)
                .findById(3L);

        Assertions.assertNotNull(cosmetics);
        Assertions.assertEquals(3L, cosmetics.getId());
        Assertions.assertEquals("Cosmetics", cosmetics.getTitle());
    }

}
