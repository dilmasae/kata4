package kata4;


//estamos creando para usar el mecanismo closure
public interface AttributeExtractor <Entity, Attribute>{
    
    public Attribute extract(Entity entity);
    
    
    
}
