package cemantika.model;

import org.cemantika.metamodel.structure.AcquisitionAssociation;
import org.cemantika.metamodel.structure.AcquisitionType;
import org.cemantika.metamodel.structure.ContextSource;
import org.cemantika.metamodel.structure.UpdateType;
 
/**
 * This class implements a ContextualEntity with annotations 
 * A Contextual Entity is a class used to build context sensitive behaviors.
 */
@ContextSource(isExternal=true)
public class GeoLocationAdapter {
	@AcquisitionAssociation(element="Usuario.localizacaoAtual", type=AcquisitionType.SENSED, updateFrequency=UpdateType.OFTEN)
	private Object location;

	/**
	 * Returns the location.
	 *
	 * @return the location. 
	 */
	public Object getLocation() {
		return location;
	}
	
	/**
	 * Get the location.
	 *
	 * @param location value. 
	 */		
	public void setLocation(Object location) {
		this.location = location;
	}	
 
}