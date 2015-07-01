package web.models;

public class Reponse {
	
	// ----------------- propriétés 6. // statut de l'opération
private int status;
// la réponse JSON
private Object data;

private Object data1;
// ---------------constructeurs
public Reponse() {
}
public Reponse(int status, Object data, Object data1) {
this.status = status;
this.data = data;
this.data1= data1;
}
// méthodes
public void incrStatusBy(int increment) {
status += increment;
}

// ---getters et setters : DOIT IMPERATIVEMENT ETRE CREE POUR ENVOYER LES DONNEES AUTOMATIQUEMENT par springboot

public long getStatus() {
    return status;
}
public Object getData() {
    return data;
}

public Object getData1() {
    return data1;
}

}
