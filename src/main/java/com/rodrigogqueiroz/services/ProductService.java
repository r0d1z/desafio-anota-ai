package com.rodrigogqueiroz.services;

import org.bson.types.ObjectId;

import com.rodrigogqueiroz.domain.Category.Category;
import com.rodrigogqueiroz.domain.Category.exceptions.CategoryNotFoundException;
import com.rodrigogqueiroz.domain.product.Product;
import com.rodrigogqueiroz.domain.product.ProductDTO;
import com.rodrigogqueiroz.domain.product.exceptions.ProductNotFoundException;
import com.rodrigogqueiroz.repositories.ProductRepository;
import com.rodrigogqueiroz.services.aws.AwsSnsService;
import com.rodrigogqueiroz.services.aws.MessageDTO;

import java.util.List;
import java.util.Objects;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProductService {   
    
    @Inject
    private CategoryService categoryService;  
    @Inject
    private ProductRepository repository;
    @Inject
    private AwsSnsService snsService;

    public Product insert(ProductDTO productData) {

        Category category = categoryService.retrieveById(productData.categoryId());

        if(Objects.isNull(category)) {
            throw new CategoryNotFoundException();
        }

        Product product = new Product(productData);
        repository.persist(product);
        this.snsService.publishMessage(new MessageDTO(product.getOwnerId()));
        
        return product;
    }
    
    public Product update(ObjectId id, ProductDTO productData) {
        Product product = this.repository.findById(id);
        Category category = this.categoryService.retrieveById(productData.categoryId());

        if (Objects.isNull(product)) {
            throw new ProductNotFoundException();
        }

        if (!productData.title().isEmpty())
            product.setTitle(productData.title());

        if (Objects.nonNull(category))
            product.setCategory(category);

        if (Objects.nonNull(productData.price()))
            product.setPrice(productData.price());

        if (Objects.nonNull(productData.description()) && !productData.description().isEmpty()) 
            product.setDescription(productData.description());

        this.repository.update(product);
        this.snsService.publishMessage(new MessageDTO(product.getOwnerId()));

        return product;
    }

    public List<Product> retrieveAll() {
        return this.repository.findAll().list();
    }

    public Response delete(@PathParam("id") ObjectId id) {
        Product product = this.repository.findById(id);
        
        if (Objects.isNull(product)) {
            throw new ProductNotFoundException();
        }

        this.repository.deleteById(id);
        return Response.noContent().build();
    }
}


