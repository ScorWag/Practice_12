import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.object.Product;
import ru.netology.repository.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.removeById(5);

    }
}
