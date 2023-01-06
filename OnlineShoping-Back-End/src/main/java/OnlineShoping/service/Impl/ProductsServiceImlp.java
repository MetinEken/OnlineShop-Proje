package OnlineShoping.service.Impl;



import OnlineShoping.repository.CategoryRepository;
import OnlineShoping.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductsServiceImlp {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public void saveproducts(SaveProductsRequest saveProductsRequest){



    }


}
