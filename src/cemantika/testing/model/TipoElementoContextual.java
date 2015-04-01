package cemantika.testing.model;

public enum TipoElementoContextual {
	LIGHT_SENSOR("LightSensor");
	private final String fonteContexto;
	
	private TipoElementoContextual(String fonte) {
		fonteContexto = fonte;
	}
	
	public String getFonteContexto(){
		return fonteContexto;
	}
}
