public class Node{
	public Node left;
	public Node right;
	public int data;
 	public Node(int data){
     this.data=data;
     this.left=null;
     this.right=null;
    }
	public void insert(int value){
	if(value<=data){
      if(left==null){
         left=new Node(value);
       }else{
        left.insert(value);
       }
    }else{
       if(right==null){
   		right= new Node(value);
       }else{
       right.insert(value);
       }
   }
  }
  public boolean contains(int value){
  	if(value==data){
  	  return true;
  	}else if(value<data){
  	if(left==null){
  	return false;
  	}else{
  		return left.contains(value);
  	}
  	} else{
  		if(right==null){
  			return false;
  		} else{
  			return right.contains(value);
  		}
  	}

  }
  public void printTree(){
  if(left!=null){
  left.printTree();
  }
  if(right!=null){
  	right.printTree();
  }
  System.out.println(data);
  }
}