import com.sun.jdi.connect.spi.TransportService;

void main() {

    LinkedList lista = new LinkedList(4, 2, 5,1);
    System.out.println(lista);
    LinkedList.Node max = lista.delMax();
    System.out.println(max);
    System.out.println(lista);

}
