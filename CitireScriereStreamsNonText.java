import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CitireScriereStreamsNonText {
	//change path according to the project
 public static final String caleImag1 = "C:\\Users\\Dora\\workspace\\Serializare\\src\\imagine.jpg"; 
 public static final String caleFisBin = "C:\\Users\\Dora\\workspace\\Serializare\\src\\imagineCript.jpg";
 public static final String caleImagDecript = "C:\\Users\\Dora\\workspace\\Serializare\\src\\imagineDecript.jpg";
 
	public static void main(String[] args) {
	Scanner intrare = new Scanner(System.in);
	System.out.println("Integer number for encrypting/decrypting the image: ");
	int cod = Integer.parseInt(intrare.nextLine());
	try{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		PrintStream ps = null;
		
		if(cod > 0){
			fis = new FileInputStream(caleImag1);
			fos = new FileOutputStream(caleFisBin);
			ps = new PrintStream(fos);
		}else {
			fis = new FileInputStream(caleFisBin);
			fos = new FileOutputStream(caleImagDecript);
			ps = new PrintStream(fos);
		}
		boolean terminat = false;
		int contor = -1;
		while (!terminat){
			//citim un fis
			int next = fis.read();
			//afiseaza octetii din fisier si marimea fisierului
			System.out.println((byte)next + " " + "\n");
			contor+=1;
			if (next == -1){
				terminat = true;
			}else{
				//cripteaza/decripteaza cu nr introdus
				ps.write((byte)next + cod);
			}
		}
		System.out.println("No of bytes: " + contor + "\n");
		
		ps.close();
		ps = null;
		fos.close();
		fos = null;
		fis.close();
		fis = null;
		
	}catch (IOException e){
		e.printStackTrace();
	}
	System.out.println("Done!");
	intrare.close();
	}

}
