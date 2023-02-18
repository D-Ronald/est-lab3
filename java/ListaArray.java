public class ListaArray implements EstruturaDeDados{
    private No inicio;
   
    @Override
    public boolean insert(int chave) {
        if (inicio == null){
            inicio = new No(chave);
        }
        
        return false;
    }

    @Override
    public boolean delete(int chave) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean search(int chave) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int minimum() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int maximum() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int sucessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int prodessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static void main(String[] args) {
        ListaArray r = new ListaArray();
    }
}
