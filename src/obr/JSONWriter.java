package obr;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONWriter {
	//converts person data into json file
	public void JSONConverterP(List<Persons> perInfo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter jsonPrintWriter = null;
		try {
			jsonPrintWriter = new PrintWriter("data/Persons.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String jSon=gson.toJson(perInfo);
		jsonPrintWriter.print(jSon);
		jsonPrintWriter.close();
	}
	//converts asset data to json
	public void JSONconverterA(List<Assets> assInfo){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter jsonPrintWriter = null;
		try {
			jsonPrintWriter = new PrintWriter("data/Assets.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		jsonPrintWriter.print(gson.toJson(assInfo));
		jsonPrintWriter.close();
	} 
}
