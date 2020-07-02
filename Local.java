public class Local extends pilhaDinamica{
    
    private int coordenada_x;
    private int coordenada_y;
    pilhaDinamica p = new pilhaDinamica();
    
    public Local(int coordenada_x, int coordenada_y) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
    }

    public int getCoordenada_x() {
        return coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Local other = (Local) o;
        if (this.coordenada_x != other.coordenada_x) {
            return false;
        }
        if (this.coordenada_y != other.coordenada_y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 6;
        hash = 68 * hash + this.coordenada_x;
        hash = 68 * hash + this.coordenada_y;
        return hash;
    }


}