package kata4;

public class HistogramBuilder<E> {
    
    private E[] items;

    public HistogramBuilder(E[] items) {
        this.items = items;
    }
    //<A>----- <A> metodo generico  (tipo que es generico  y devuelve una string)
    public <A> Histogram <A>build(AttributeExtractor<E, A> extractor){
        Histogram<A> histogram = new Histogram<>();
        for (E item : items) {
            A attribute = extractor.extract(item);
            histogram.put(attribute, histogram.get(attribute) + 1);
        }
        return histogram;
    }   

}
