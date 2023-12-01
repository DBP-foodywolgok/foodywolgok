package model;

public class Customer_Category {

	
	  private int categoryId;
	    private int customerId;
		@Override
		public String toString() {
			return "Customer_Category [categoryId=" + categoryId + ", customerId=" + customerId + "]";
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public Customer_Category(int categoryId, int customerId) {
			super();
			this.categoryId = categoryId;
			this.customerId = customerId;
		}
	    
}
