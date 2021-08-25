package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class that handles Products
 * @author Gerardo Granados Aldaz
 */
@Entity
public class Product implements Serializable {
	
	/**
	 * Generated Id
	 */
	private static final long serialVersionUID = 1940424686731950240L;
	
	@Id
	@GeneratedValue
	/**
	 * parameter id
	 */
	private long id;
	/**
	 * parameter name
	 */
	private String name;
	/**
	 * parameter description
	 */
	private String description;
	@OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL)
	/**
	 * parameter childSKus
	 */
	private List<Sku> childSkus;
	
	/**
	 * Product constructor with no arguments
	 */
	public Product() {
	}

	/**
	 * Product constructor overloaded with 4 parameters 
	 * @param id
	 * @param name
	 * @param description
	 * @param childSkus
	 */
	public Product(long id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the childSkus
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}
	
	/**
	 * @param childSkus the childSkus to set
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}

	/**
	 * toString method for Products
	 * @return Product as a string with all its information from the four properties
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", childSkus=" + childSkus
				+ "]";
	}

	@Override
	/**
	 * hashCode method for Products
	 * @return result
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	/**
	 * equals method for Products
	 * @param obj
	 * @return true
	 * @return false
	 */
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return id == other.id;
    }
	
}
