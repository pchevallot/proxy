package com.lpsil.sar.proxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

// Nous devons implémenter l'interface Runnable
// dans la classe Application qui contiendra
// les traitements à exécuter dans un thread
public class Application implements Runnable {

	Socket client;

	public Application(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {

			// Un BufferedReader permet de lire par ligne
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			// un PrintWriter possède toutes les opérations print classiques.
			// En mode auto-flush, le tampon est vidé (flush) à l'appel de println
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);

			String line = "";
			System.out.println(line);
			
			while((line = in.readLine())!=null && line.length()!=0)
	           {
	             
	               System.out.println("rec : "+in.readLine());
	               
	           }

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}


}
