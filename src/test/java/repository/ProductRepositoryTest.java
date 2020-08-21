package repository;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book = new Book(2, "Война и Мир", 200, "Толстой");
    private Book book1 = new Book(3, "Код Да Винчи", 250, "Дэн Браун");
    Smartphone smartphone = new Smartphone(4, "Nokia", 1000, "Microsoft");
    @BeforeEach
    public void setUp() {
        repository.save(book);
        repository.save(book1);
        repository.save(smartphone);
    }

    @Test
    void removeById() {
        repository.removeById(2);
        Product[]actual = repository.findAll();
        Product[]expected = new Product[]{book1,smartphone};
        assertArrayEquals(expected,actual);
    }

    @Test
    void removeByNullId(){
        assertThrows(NotFoundException.class,()->repository.removeById(6));

    }
}