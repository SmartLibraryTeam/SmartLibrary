package business;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import gui.LoginGUI;

import DAO.UtenteRegistratoDAO;
import DAO.DisciplinaDAO;

import com.itextpdf.text.Paragraph;

import java.util.ArrayList;
import java.util.Date;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import modelli.IscrizioneDisciplina;

public class CreaPDF 
{
	
	public File newPDF(ArrayList<IscrizioneDisciplina> iscrizioni, int idUtente, String modalitàpagamento)
	{
		LoginGUI logingui = new LoginGUI();
		
		
		
		String path =logingui.DirectoryProgramma+"/documents/distinte/Distinta-" + idUtente + ".pdf";
		
		File filepdf = new File(path);
		
		try {
            
			//COMANDI PER GENERARE E MODIFICARE IL FILE PDF
			OutputStream fileout = new FileOutputStream(filepdf);
            Document document = new Document();
            PdfWriter.getInstance(document, fileout);
            
            
            //APRO IL DOCUMENTO
            document.open();
            
            //AGGIUNGO RIGHE AL DOCUMENTO
            
            
            //Aggiungo intestazione
            document.add(new Paragraph("                                                     ******** DPM SPORTS ********"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            //Aggiungo nome utente
            
            
            //Ricavo nome e cognome utente
            int TOTALE = 0;
            UtenteRegistratoDAO ricavanome = new UtenteRegistratoDAO();
            String NOME = ricavanome.getNomeUtente(idUtente).get(0)[0];
            String COGNONOME = ricavanome.getNomeUtente(idUtente).get(0)[1];
            
            document.add(new Paragraph("UTENTE: " + NOME + " " + COGNONOME));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            //Aggiungo discipline appena scelte
            for(int i = 0; i< iscrizioni.size(); i++)
            {
            	
            	
            	String NOMEDISCIPLINA = iscrizioni.get(i).getnomeDisciplina();
            	String LIVELLO = iscrizioni.get(i).getLivello();
            	String GIORNO = iscrizioni.get(i).getGiorno();
            	String ORA = iscrizioni.get(i).getOra();
            
            	
                DisciplinaDAO idDisc = new DisciplinaDAO ();
            	
            	int IDDISCIPLINA = Integer.parseInt(idDisc.getIdDisciplinafromNameandLivello(NOMEDISCIPLINA, LIVELLO).get(0)[0]);
            	
                DisciplinaDAO letturacosto = new  DisciplinaDAO();
            	
            	int COSTO = Integer.parseInt(letturacosto.getDatiDisciplinaFromId(IDDISCIPLINA).get(0)[5]);
            	
            	 document.add(new Paragraph("DISCIPLINA: " + NOMEDISCIPLINA + " " + LIVELLO + " " + GIORNO + " " + ORA + "     " + "COSTO: €" + COSTO));
            	
            	 
            	TOTALE = TOTALE + COSTO;
            }
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("MODALITA' DI PAGAMENTO: " +modalitàpagamento+ "                                                          " + "TOTALE: €" + TOTALE));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            //Aggiungo data e ora
            document.add(new Paragraph(new Date().toString()));
            
            //Chiudo il documento
            document.close();
            fileout.close();

        } 
		catch (Exception e) 
		{ 
            e.printStackTrace();
        }
		
		//RITORNO IL DOCUMENTO
		return filepdf;
		
		
	}

}
