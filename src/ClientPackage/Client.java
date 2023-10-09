package ClientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	public static <BufferReader> void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub // demande de connexion : socket 
		int serverPort = 1234;
		// la premiere étape :
		System.out.println("je suis un client pas encore connecté");
		Socket s = new Socket("localhost",serverPort);
		System.out.println("je suis un client connecté");
		
		System.out.println("Génération de l'objet InputStream et OutputStream de la socket");
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		System.out.println("lire un nombre = ");

		try (Scanner scanner = new Scanner(System.in)) {
			int nb = scanner.nextInt();
			System.out.println("envoyer le nombre '"+nb+"' au serveur");

			os.write(nb);
			System.out.println("Attendre la réponse du serveur:");

			int rep = is.read();
			System.out.println("la valeur de "+nb+"*5 = "+rep);
			int op1 = 0, op2 = 0;
			String operation ; //+,_,*/
			//scanner pour lire op1,op2,operation 
			InputStream is1 = s.getInputStream();
			OutputStream os1 = s.getOutputStream();
			PrintWriter pw= new PrintWriter(os1,true);
			pw.println(op1); //op1=500800
			pw.println(op2); 
			pw.println(operation);
			InputStreamReader isr = new InputStreamReader(is);
					BufferReader br= new BufferReader(isr);
					s.o.p(op1+ " "+ operation +" " +op2+"=" + ((Object) br).ReadLine());
			
		// la derniere etape : fermer socket // deconnexion 
		}catch(IOException e) {}
		s.close();
	}
}
