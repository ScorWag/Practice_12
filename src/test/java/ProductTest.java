import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.object.Product;
import ru.netology.repository.ProductRepository;

public class ProductTest {

    Product bookFirst = new Book(1, "The WhiteSpirit", 1500, "Antony Hopkins");
    Product bookSecond = new Book(2, "Lord of The Rings", 1700, "Tolkien");
    Product smartphoneFirst = new Smartphone(4, "The Galaxy A50", 12000, "Samsung");
    Product smartphoneSecond = new Smartphone(5, "The iPhone13Pro", 129990, "Apple");

    @Test
    void shouldProductReturnTrue() {
        Product product = new Product(1, "The WhiteSpirit", 1500);

        boolean actual = product.matches("White");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldProductReturnFalse() {
        Product product = new Product(1, "The WhiteSpirit", 1500);

        boolean actual = product.matches("Ter");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldBookReturnTrueWithNameMatchesOnly() {
        boolean actual = bookFirst.matches("The");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldBookReturnTrueWithAuthorMatchesOnly() {
        boolean actual = bookFirst.matches("Antony");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldBookReturnFalseOneElement() {
        boolean actual = bookFirst.matches("Hot");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldBookReturnTrueWithNameAndAuthorMatchesTwoElements() {
        boolean[] actual = {bookFirst.matches("Antony"), bookSecond.matches("Lord")};
        boolean[] expected = {true, true};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBookReturnTrueAndFalseMatchesTwoElements() {
        boolean[] actual = {bookFirst.matches("White"), bookSecond.matches("Sock")};
        boolean[] expected = {true, false};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBookReturnFalseMatchesWithTwoElements() {
        boolean[] actual = {bookFirst.matches("Sex"), bookSecond.matches("Sock")};
        boolean[] expected = {false, false};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSmartphoneReturnTrueWithNameMatchesOnly() {
        boolean actual = smartphoneFirst.matches("The");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSmartphoneReturnTrueWithProducerMatchesOnly() {
        boolean actual = smartphoneFirst.matches("Sam");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSmartphoneReturnFalseOneElement() {
        boolean actual = smartphoneSecond.matches("Samsung");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSmartphoneReturnTrueWithNameAndProducerMatchesTwoElements() {
        boolean[] actual = {smartphoneFirst.matches("Galaxy"), smartphoneSecond.matches("Apple")};
        boolean[] expected = {true, true};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSmartphoneReturnTrueAndFalseMatchesTwoElements() {
        boolean[] actual = {smartphoneFirst.matches("Galaxy"), smartphoneSecond.matches("Sock")};
        boolean[] expected = {true, false};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSmartphoneReturnFalseMatchesWithTwoElements() {
        boolean[] actual = {smartphoneFirst.matches("Sex"), smartphoneSecond.matches("Sock")};
        boolean[] expected = {false, false};

        Assertions.assertArrayEquals(expected, actual);
    }
}