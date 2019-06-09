package control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240; // 10ko

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	System.out.println("hihi");
    	/** !! IL FAUT CHANGER LE CHEMIN SUIVANT LA LOCALISATION DE VOTRE WORKSPACE !! */ 
    	
        File fichier = new File( "C:\\Program Files\\eclipse\\eclipse-workspace\\worskpace_advancedJava\\Projet S8\\fichiersPDF\\extrait.pdf" );
        /* Vérifie que le fichier existe bien */
        if ( !fichier.exists() ) {
            /*
             * Si non, alors on envoie une erreur 404, qui signifie que la
             * ressource demandée n'existe pas
             */
        	System.out.println("haha2");
            response.sendError( HttpServletResponse.SC_NOT_FOUND );
            return;
        }

        /* Récupère le type du fichier */
        String type = getServletContext().getMimeType( fichier.getName() );

        /*
         * Si le type de fichier est inconnu, alors on initialise un type par
         * défaut
         */
        if ( type == null ) {
            type = "application/octet-stream";
        }

        /* Initialise la réponse HTTP */
        response.reset();
        response.setBufferSize( TAILLE_TAMPON );
        response.setContentType( type );
        response.setHeader( "Content-Length", String.valueOf( fichier.length() ) );
        response.setHeader( "Content-Disposition", "attachment; filename=\"" + fichier.getName() + "\"" );

        /* Prépare les flux */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux */
            entree = new BufferedInputStream( new FileInputStream( fichier ), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( response.getOutputStream(), TAILLE_TAMPON );

            /* Lit le fichier et écrit son contenu dans la réponse HTTP */
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            sortie.close();
            entree.close();
        }
    }
}