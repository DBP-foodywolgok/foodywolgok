package model;

public class FriendList {

	   private int custId;
	    private int friendId;
		public int getCustId() {
			return custId;
		}
		public void setCustId(int custId) {
			this.custId = custId;
		}
		public int getFriendId() {
			return friendId;
		}
		public void setFriendId(int friendId) {
			this.friendId = friendId;
		}
		public FriendList(int custId, int friendId) {
			super();
			this.custId = custId;
			this.friendId = friendId;
		}
		@Override
		public String toString() {
			return "FriendList [custId=" + custId + ", friendId=" + friendId + "]";
		}
	    
	    
}
