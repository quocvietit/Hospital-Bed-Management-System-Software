package convert;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLConvert<T> {

	private T type;
	
	public XMLConvert(T type) {
		this.type = type;
	}
	
	@SuppressWarnings("all")
	public T XMLToObject(String xml) throws Exception{
		T patient = null;
		JAXBContext ctx = JAXBContext.newInstance(type.getClass());
		Unmarshaller ms = ctx.createUnmarshaller();
		patient = (T)ms.unmarshal(new StringReader(xml));
		return patient;
	}
	
	public String ObjectToXML(T obj) throws Exception{
		JAXBContext ctx = JAXBContext.newInstance(type.getClass());
		Marshaller ms = ctx.createMarshaller();
		StringWriter sw = new StringWriter();
		ms.marshal(obj, sw);
		return sw.toString();
	}
}
