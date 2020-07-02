public class Node {
    
    private long ID;
    private Node prox;

    public Node(long ID){

       this.ID = ID;
       this.prox = null;
   }
    public long getID() {

        return ID;
    }
    public void setID(long ID) {

        this.ID = ID;
    }
    public Node getProximo() {

        return prox;
    }
    public void setProximo(Node next) {

        this.prox = next;
    }   
}