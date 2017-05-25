package obr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;


public class XMLWriter {

//convert person data to xml
	public void xmlPersonConverter(List<Persons> perInfo){
		XStream xstream = new XStream();
		xstream.alias("persons", List.class);
		xstream.alias("junior", Junior.class);
		xstream.alias("expert", Expert.class);
		xstream.alias("customer", Customer.class);
		PrintWriter write = null;
		System.out.println("<?xml version=\"1.0\"?>");
		try{
			write = new PrintWriter("data/persons.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		write.write(xstream.toXML(perInfo));
		write.close();
	}
	
//convert asset data to xml	
	public void xmlAssetConverter(List<Assets> assList){
		XStream xstream = new XStream();
		xstream.alias("assets", List.class);
		xstream.alias("stock", Stocks.class);
		xstream.alias("private investment", Private_Investments.class);
		xstream.alias("deposit account", Deposit_Account.class);
		PrintWriter write = null;
		System.out.println("<?xml version=\"1.0\"?>");
		try{
			write = new PrintWriter("data/assets.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		write.write(xstream.toXML(assList));
		write.close();
	}
}
