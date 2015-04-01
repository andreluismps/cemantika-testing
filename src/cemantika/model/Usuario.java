package cemantika.model;
 
import org.cemantika.metamodel.structure.ContextType;
import org.cemantika.metamodel.structure.ContextualElement;
import org.cemantika.metamodel.structure.ContextualEntity;
/**
 * This class implements a ContextualEntity with annotations 
 * A Contextual Entity is a class used to build context sensitive behaviors.
 */
@ContextualEntity
public class Usuario {
 
	@ContextualElement(type=ContextType.WHERE)
	private Localizacao localizacaoAtual;

	/**
	 * Returns the localizacaoAtual.
	 *
	 * @return the localizacaoAtual. 
	 */
	public Localizacao getLocalizacaoAtual() {
		return localizacaoAtual;
	}
	
	/**
	 * Get the localizacaoAtual.
	 *
	 * @param localizacaoAtual value. 
	 */		
	public void setLocalizacaoAtual(Localizacao localizacaoAtual) {
		this.localizacaoAtual = localizacaoAtual;
	}	
 
}