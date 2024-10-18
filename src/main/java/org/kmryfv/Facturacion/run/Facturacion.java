package org.kmryfv.Facturacion.run;

import org.openxava.util.*;

/**
 * Execute this class to start the application.
 *
 * With OpenXava Studio/Eclipse: Right mouse button > Run As > Java Application
 */

public class Facturacion {

	public static void main(String[] args) throws Exception {
		DBServer.start("Facturacion-db"); // To use your own database comment this line and configure src/main/webapp/META-INF/context.xml
		AppServer.run("Facturacion"); // Use AppServer.run("") to run in root context
	}

}
