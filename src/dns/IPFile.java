package dns;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class IPFile {
	
	public static String readTxt(String path) {
		File file = new File(path);
		String result = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while((s = br.readLine())!=null){
				result = result + s;
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void writeTxt(String ip,String path) {
		File file = new File(path);
		try {
			Writer bw=new FileWriter(file,false);
			if(file.exists()) {
				//Runtime.getRuntime().exec("sudo chmod 766 -R " + path);
			}else {
				file.createNewFile();
				//Runtime.getRuntime().exec("sudo chmod 766 -R " + path);
			}
			bw.write(ip);	
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
