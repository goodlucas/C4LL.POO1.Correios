package Command;

public class Option {
	private String	name;
	private boolean	acceptsParameter;
	private	String	parameter;
	
	Option(String name, boolean acceptsParameter) {
		this.name = name;
		this.acceptsParameter = acceptsParameter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasParameter() {
		return (parameter != null);
	}
	
	public void setParameter(String value) {
		if (acceptsParameter)
			parameter = value;
	}
	
	public String getParameter() {
		return parameter;
	}
}
