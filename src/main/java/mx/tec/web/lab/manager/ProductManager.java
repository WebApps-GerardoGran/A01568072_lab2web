/**
 * 
 */
package mx.tec.web.lab.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.entity.Sku;
import mx.tec.web.lab.repository.ProductRepository;

/**
 * Class to manage and handle products
 * @author Gerardo Granados Aldaz
 */
@Service
public class ProductManager {
	@Resource
	ProductRepository productRepository;
	
	/**
	 * Retrieve all the products
	 * @param no parameters 
	 * @return List of products
	 */
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	/**
	 * Retrieve a specific product based on a given product id
	 * @param id Product id
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public Optional<Product> getProduct(final long id) {
		return  productRepository.findById(id);
	}

	/**
	 * Add a new product and the respective child skus, linking each sku to the product as a parent
	 * @param newProduct
	 * @return savedProduct
	 */
	public Product addProduct(final Product newProduct) {
		for(final Sku newSku : newProduct.getChildSkus()) {
			newSku.setParentProduct(newProduct);
		}
		return productRepository.save(newProduct);
	}

	/**
	 * Modify an existing product based on an id and the skus
	 * @param id Product id
	 * @param modifiedProduct
	 * @return void
	 */
	public void updateProduct(final long id, final Product modifiedProduct) {
		if (modifiedProduct.getId() == id) {
			for (final Sku modifiedSku : modifiedProduct.getChildSkus()) {
				modifiedSku.setParentProduct(modifiedProduct);
			}			
			
			productRepository.save(modifiedProduct);
		}
	}

	
	/**
	 * Deletes an existing product
	 * @param existingProduct
	 * @return void
	 */
	public void deleteProduct(final Product existingProduct) {
		productRepository.delete(existingProduct);
	}

	
	/**
	 * Retrieves any product based on a given pattern that appears in it
	 * @param pattern Pattern to search
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public List<mx.tec.web.lab.entity.Product> getProducts(final String pattern) {
		
		return productRepository.findByNameLike(pattern);
	}

}