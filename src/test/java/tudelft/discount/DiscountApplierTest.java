package tudelft.discount;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountApplierTest {

    static DiscountApplier da;
    static List<Product> productList = new ArrayList<Product>();

    @BeforeEach
    public void init() {

        // mock creation
        ProductDao mockedDao = mock(tudelft.discount.ProductDao.class);
        // mock setup
        when(mockedDao.all()).thenReturn(productList);

        // discount applier instantiation
        da = new DiscountApplier(mockedDao);

    }

    @AfterEach
    public  void end() {
        productList.clear();
    }

    @Test
    public void testHome() {
        double[] values = new double[] { 0, 1, 2, 3, 4, 5, 25, 34_523 };
        addProducts(values, "HOME");

        da.setNewPrices();

        int i = 0;
        for (Product p : productList) {
            Assertions.assertEquals(values[i] * 0.9, p.getPrice());
            i++;
        }
    }

    @Test
    public void testBusiness() {
        double[] values = new double[] { 0, 1, 2, 3, 4, 5, 25, 34_523 };
        addProducts(values, "BUSINESS");

        da.setNewPrices();

        int i = 0;
        for (Product p : productList) {
            Assertions.assertEquals(values[i] * 1.1, p.getPrice());
            i++;
        }
    }

    void addProducts(double[] prices, String category) {
        for (int i = 0; i < prices.length; i++) {
            productList.add(new Product("anyName", prices[i], category));
        }
    }

}
