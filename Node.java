public  class Node {
	int value;                      
	int distance;                   
	String path;                
	public int Key;
	public Node right;            
	public Node left;             

    public Node(int var){
        right = null;
        left = null;
    	Key = var;
    }
 
	public Node(int value, int distance, String path) {
		this.value = value;
		this.distance = distance;
		this.path = path;
	}
 
	public String toString() {
		return "length of  " + this.value + " from source is " + this.distance + " and passed path is " + this.path;
	}
    public Node getRight(){
        return right;
    }

    public Node getLeft(){
        return left;
    }

    public int getKey(){
        return Key;
    }
    public void setRight(Node n)
    {
        right = n;
    }

    public void setLeft(Node n){
        left = n;
    }
    public int setKey(int W){
        return Key;
    }
}