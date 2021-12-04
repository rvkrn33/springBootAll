package com.order.kamlesh;

import java.util.List;

public class Product {
	private int id ;
    private String name ;
	private int oldPrice ;
    private int newPrice ;
    private int discount ;
    private int ratingsCount ;
    private int ratingsValue ;
    private String description;
    private int availibilityCount;
    private int cartCount;
    private String color;
    private String size;// [private int Sprivate int ,private int Mprivate int ,private int Lprivate int , private int XLprivate int ],
    private int weight; //150,
    private int categoryId;// 100
    
    private List<Images> images;
    
    Product(){
    	
    }
    
	public Product(int id, String name, int oldPrice, int newPrice, int discount, int ratingsCount, int ratingsValue,
			String description, int availibilityCount, int cartCount, String color, String size, int weight,
			int categoryId, List<Images> images) {
		super();
		this.id = id;
		this.name = name;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.discount = discount;
		this.ratingsCount = ratingsCount;
		this.ratingsValue = ratingsValue;
		this.description = description;
		this.availibilityCount = availibilityCount;
		this.cartCount = cartCount;
		this.color = color;
		this.size = size;
		this.weight = weight;
		this.categoryId = categoryId;
		this.setImages(images);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
	}

	public int getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public int getRatingsValue() {
		return ratingsValue;
	}

	public void setRatingsValue(int ratingsValue) {
		this.ratingsValue = ratingsValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailibilityCount() {
		return availibilityCount;
	}

	public void setAvailibilityCount(int availibilityCount) {
		this.availibilityCount = availibilityCount;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}
}
