package commandes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe représentant le gestionnaire de commande. Le gestionnaire a pour but de journaliser les commandes qui ont
 * été déclarées par l'utilisateur ainsi que leurs effets sur les perspectives, et de défaire des commandes ou de
 * les refaire si l'utilisateur le souhaite.
 */
public final class GestionnaireDeCommande {

    private ArrayList<Commande> listeCommandes = new ArrayList<>();
    private String pathFichierXML = "fichier.xml";

    private static final GestionnaireDeCommande INSTANCE = new GestionnaireDeCommande();
    private GestionnaireDeCommande(){}
    public static GestionnaireDeCommande getInstance(){
        return INSTANCE;
    }



    public void AjoutCommande(Commande commande) {
        enregistrerCommandesDansXML(commande);
    }

    public Commande getLastCommande() {
        Commande retour=null;

        this.listeCommandes = chargerCommandesDepuisXML();
        int nbreElementTotal = listeCommandes.size();

        if (listeCommandes.size() >= 2){
            retour = listeCommandes.get(nbreElementTotal - 1);
        }
        else{
            retour = listeCommandes.get(nbreElementTotal - 1);
        }

        return retour;
    }

    private void enregistrerCommandesDansXML(Commande nouvelleCommande) {
        try {
            //Créé un document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;

            // Vérifier si le fichier XML existe déjà
            File fichierXML = new File(pathFichierXML);

            if (fichierXML.exists()) {
                document = builder.parse(fichierXML);
            } else {
                document = creerFichierXML();
            }

            // Ajouter la nouvelle commande au document
            Element racine = document.getDocumentElement();
            Element type = document.createElement(nouvelleCommande.getClass().getSimpleName());
            racine.appendChild(type);


            // Sauve l'élément dans le fichier approprier
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            // Spécifie ou le fichier va être sauver
            File file = new File(pathFichierXML);
            StreamResult result = new StreamResult(file);

            // Sauve les changements sur le document
            transformer.transform(source, result);

        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ArrayList<Commande> chargerCommandesDepuisXML() {
        ArrayList<Commande> commandes = new ArrayList<>();

        try {
            File fichierXML = new File(pathFichierXML);
            if (fichierXML.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(fichierXML);

                Node racine = document.getDocumentElement();
                NodeList listeCommandes = racine.getChildNodes();

                for (int i = 0; i < listeCommandes.getLength(); i++) {

                    Node node = listeCommandes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        Element element = (Element) node;
                        String typeCommande = element.getTagName();

                        // Ajoutez ici d'autres attributs si nécessaire

                        // Instancier la commande en fonction du type
                        Commande commande = null;
                        switch (typeCommande) {
                            case "CommandeChargerImage":
                                commande = new CommandeChargerImage();
                                break;
                            case "CommandeChargerPerspectives":
                                commande = new CommandeSauvegarder();
                                break;
                            case "CommandeTranslation":
                                commande = new CommandeTranslation();
                                break;
                            case "CommandeAgrandir":
                                commande = new CommandeAgrandir();
                                break;
                            case "CommandeReduire":
                                commande = new CommandeReduire();
                                break;
                        }
                        if (commande != null) {
                            commandes.add(commande);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commandes;
    }

    private Document creerFichierXML() throws ParserConfigurationException {

        //Créé un document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        try {
            // Créer l'élément racine
            Element racine = document.createElement("commandes");
            document.appendChild(racine);

            // Sauve l'élément dans le fichier approprier
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            // Spécifie ou le fichier va être sauver
            File file = new File(pathFichierXML);
            StreamResult result = new StreamResult(file);

            // Sauve les changements sur le document
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return document;
    }
}
