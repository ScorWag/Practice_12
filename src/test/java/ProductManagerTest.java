import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.object.Product;
import ru.netology.repository.ProductRepository;

import static org.mockito.Mockito.doReturn;

public class ProductManagerTest {

    private ProductRepository repositoryMock = Mockito.mock(ProductRepository.class);
    private ProductManager managerWithMock = new ProductManager(repositoryMock);
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product bookFirst = new Book(1, "The WhiteSpirit", 1500, "Antony Hopkins");
    Product bookSecond = new Book(2, "Lord of The Rings", 1700, "Tolkien");
    Product bookThird = new Book(3, "The Clean Coder: A Code of Conduct for Professional Programmers", 2700, "Robert Martin");
    Product smartphoneFirst = new Smartphone(4, "The Galaxy A50", 12000, "Samsung");
    Product smartphoneSecond = new Smartphone(5, "The iPhone13Pro", 129990, "Apple");
    Product smartphoneThird = new Smartphone(6, "The Galaxy S21 FE", 50000, "Samsung");

    @Test
    void shouldSearchByMock() {
        Product[] returned = {bookFirst, bookSecond, bookThird, smartphoneFirst, smartphoneSecond, smartphoneThird};
        doReturn(returned).when(repositoryMock).findAll();

        Product[] actual = managerWithMock.searchBy("Galaxy");
        Product[] expected = {smartphoneFirst, smartphoneThird};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchTwoElementsOfSix() {
        manager.addProduct(bookFirst);
        manager.addProduct(bookSecond);
        manager.addProduct(bookThird);
        manager.addProduct(smartphoneFirst);
        manager.addProduct(smartphoneSecond);
        manager.addProduct(smartphoneThird);

        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = {smartphoneFirst, smartphoneThird};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchOneElementsOfOne() {
        manager.addProduct(bookThird);

        Product[] actual = manager.searchBy("Clean");
        Product[] expected = {bookThird};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchTwoElementsOfTwo() {
        manager.addProduct(bookSecond);
        manager.addProduct(bookThird);

        Product[] actual = manager.searchBy("of");
        Product[] expected = {bookSecond, bookThird};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchOneElementsOfSix() {
        manager.addProduct(bookFirst);
        manager.addProduct(bookSecond);
        manager.addProduct(bookThird);
        manager.addProduct(smartphoneFirst);
        manager.addProduct(smartphoneSecond);
        manager.addProduct(smartphoneThird);

        Product[] actual = manager.searchBy("13Pro");
        Product[] expected = {smartphoneSecond};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchAllElementsOfSix() {
        manager.addProduct(bookFirst);
        manager.addProduct(bookSecond);
        manager.addProduct(bookThird);
        manager.addProduct(smartphoneFirst);
        manager.addProduct(smartphoneSecond);
        manager.addProduct(smartphoneThird);

        Product[] actual = manager.searchBy("The");
        Product[] expected = {bookFirst, bookSecond, bookThird, smartphoneFirst, smartphoneSecond, smartphoneThird};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSearchDifferentTypeOfProduct() {
        manager.addProduct(bookFirst);
        manager.addProduct(bookSecond);
        manager.addProduct(bookThird);
        manager.addProduct(smartphoneFirst);
        manager.addProduct(smartphoneSecond);
        manager.addProduct(smartphoneThird);

        Product[] actual = manager.searchBy("A");
        Product[] expected = {bookFirst, bookThird, smartphoneFirst, smartphoneSecond};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldReturnArrayWithZeroLengthOnFailureSearchWithElements() {
        manager.addProduct(bookFirst);
        manager.addProduct(bookSecond);
        manager.addProduct(bookThird);
        manager.addProduct(smartphoneFirst);
        manager.addProduct(smartphoneSecond);
        manager.addProduct(smartphoneThird);

        Product[] result = manager.searchBy("Qwe");
        int actual = result.length;
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void shouldReturnArrayWithZeroLengthWithoutElements() {

        Product[] result = manager.searchBy("The");
        int actual = result.length;
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }


}
