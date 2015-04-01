package cemantika.model;
 
/**
 * This class implements a ContextualEntity with annotations 
 * A Contextual Entity is a class used to build context sensitive behaviors.
 */

public class GeoLocationAdapter {
 
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