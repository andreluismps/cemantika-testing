package cemantika.model;
 
import org.cemantika.metamodel.structure.ContextType;
import org.cemantika.metamodel.structure.ContextualElement;
import org.cemantika.metamodel.structure.ContextualEntity;
/**
 * This class implements a ContextualEntity with annotations 
 * A Contextual Entity is a class used to build context sensitive behaviors.
 */
@ContextualEntity
public class Perigo {
 
	@ContextualElement(type=ContextType.WHERE)
	private Localizacao localizacao;

	/**
	 * Returns the localizacao.
	 *
	 * @return the localizacao. 
	 */
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	
	/**
	 * Get the localizacao.
	 *
	 * @param localizacao value. 
	 */		
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}	
 
}