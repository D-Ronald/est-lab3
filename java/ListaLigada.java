public class ListaLigada implements EstruturaDeDados{
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaLigada(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void ListaArray(){
        this.tamanho = 0;
    } 

    public void removeInicio (){
        if (inicio != null)
            inicio = inicio.getProximo();
    }

    public void removeFim (){
        if (inicio == null){
            return;
        }
        if (inicio.getProximo() == null){
            inicio = null;
        }
        removeFim(inicio);
    }

    public void removeFim (No n){
        No proximo = n.getProximo();
        if (proximo.getProximo() == null){
            n.setProximo(null);
            return;
        } else{
            removeFim(proximo);
        }
    }

    public void insereInicio (int valor){
        if(inicio == null){
            inicio = new No(valor);
            return;
        }
        No n = new No(valor);
        n.setProximo(inicio);
        inicio = n;

    }

    public void insereFim (int valor){
        if(inicio == null){
            inicio = new No(valor);
            return;
        }
        insere(inicio, valor);
    }

    public boolean procura (int valor){
        if (inicio == null){
            return false;
        } else {
            return procura(inicio, valor);
        }
    }

    public boolean procura (No n, int valor){
        if (n.getValor() == valor){
            return true;
        } else if (n.getProximo() == null){
            return false;
        } else {
            return procura(n.getProximo(), valor);
        }
    }
    public void insere (No n, int valor){
        if (n.getProximo() == null){
            No novo = new No(valor);
            n.setProximo(novo);
        } else {
            insere(n.getProximo(), valor);
        }
    }

    public void remover(int valor){
        if (inicio == null){
            return;
        }
        if (inicio.getValor() == valor){
            inicio = inicio.getProximo();
            return;
        }
        remover(inicio, valor);
    }

    public void remover(No n, int valor){
        No proximo = n.getProximo();
        if (proximo == null){
            return;
        }
        if (proximo.getValor() == valor){
            n.setProximo(proximo.getProximo());
        } else{
            remover(proximo, valor);
        }
    }

   /*  public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if (i == 50){
                break;
            }
        }
        System.out.println("fim");
    }*/

    @Override
    public boolean insert(int chave) {
        if(isEmpty()){
            inicio = new No(chave);
            fim = inicio;
            tamanho++;
            return true;
        }
        else{
            No pointer = new No(chave);
            fim.setProximo(pointer);
            fim = pointer;
            tamanho++;
            return true;
        }
    }

    @Override
    public boolean delete(int chave) {
        
        return false;
    }

    @Override
    public boolean search(int chave) {
       
        if(isEmpty()){
            return false;
            
        }
        else{
            No pointer = inicio;
            while(pointer != null){
                if(pointer.getValor() == chave){
                    return true;
                }
                pointer = pointer.getProximo();
            }
            return false;
        }

    }

    @Override
    public int minimum() {
        
        if(isEmpty()){
            return -1;
        }
        else{
            No pointer = inicio;
            int menor = pointer.getValor();
            while(pointer != null){
                if(pointer.getValor() < menor){
                    menor = pointer.getValor();
                }
                pointer = pointer.getProximo();
            }
            return menor;
        }


    }

    @Override
    public int maximum() {
        if(isEmpty()){
            return -1;
        }
        else{
            No pointer = inicio;
            int maior = pointer.getValor();
            while(pointer != null){
                if(pointer.getValor() > maior){
                    maior = pointer.getValor();
                }
                pointer = pointer.getProximo();
            }
            return maior;
        }
    }

    @Override
    public int sucessor(int chave) {
        if(isEmpty()){
            return -1;
        }
        else{
            if(search(chave)){
                 No pointer = inicio;
                 while(pointer != null){
                      if(pointer.getValor() == chave){
                           if(pointer.getProximo() != null){
                             return pointer.getProximo().getValor();
                           }
                           else{
                             return -1;
                           }
                      }
                      pointer = pointer.getProximo();
                 }
            }
            else{
                return -1;
            }
            return -1;
         }

    }

    @Override
    public int prodessor(int chave) {
        if(isEmpty()){
            return -1;
        }
        else{
            if(chave == inicio.getValor()){
                return -1;
            }
            if(search(chave)){
                No pointer = inicio;
                while(pointer != null){
                    if(pointer.getProximo().getValor() == chave){
                        if(pointer.getProximo() != null){
                            return pointer.getProximo().getValor();
                        }
                        else{
                            return -1;
                        }
                    }
                    pointer = pointer.getProximo();
                }
            }
            
            return -1;
        }
    }
    
    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isEmpty(){
        return inicio == null;
    }
    
    public static void main(String[] args) {
    ListaLigada lista = new ListaLigada();
    lista.insert(10);
    lista.insert(205);
    lista.insert(20);
    lista.insert(2);
    System.out.println("tamanho: "+lista.getTamanho());
    System.out.println( "Inicio: " +lista.getInicio().getValor());
    System.out.println( "Fim: " +lista.getFim().getValor());
    System.out.println("Máximo: "+lista.maximum());
    System.out.println("mínimo: "+lista.minimum());
    System.out.println("Sucessor: "+lista.sucessor(10));
    System.out.println("Prodessor: "+lista.prodessor(10));
    }

    
}
    