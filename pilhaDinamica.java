public class pilhaDinamica {
    Node topo;

    public pilhaDinamica(){
        topo = null;
    }
    public void inserirNode(long ID){
        Node n = new Node(ID);
        n.setProximo(topo);
        topo = n;
    }
    public long removerNode(){
        if(topo == null) throw new NullPointerException("Pilha vazia");
        else {
            long idTopo = topo.getID();
            topo = topo.getProximo();

            return idTopo;
        }       
    }
    public Node buscar(long Id){
        if(topo.getID() == Id) return topo;
        Node base = topo;
        
        while(base != null){
            if(base.getID() == Id) return base;
            base = base.getProximo();
        } 

        return null;
    }
    public long tamanhoPilha(){
        long tam = 0;
        Node base = topo;
        while(base != null){
            tam++;
            base = base.getProximo();
        }

        return tam;
    }
    public boolean estaVazia(){
        if(topo == null) return true;

        return false;
    }
}