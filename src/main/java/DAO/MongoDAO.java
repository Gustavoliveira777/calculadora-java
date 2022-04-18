package DAO;

import Model.Calculo;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoDAO {
    private MongoClient client = MongoClients.create("mongodb://localhost:27017");
    private MongoDatabase database = client.getDatabase("historico");
    private MongoCollection<Document> calculos = database.getCollection("calculos");

    public void adicionar(Calculo calc) {
        Document calculo = new Document("numeros", calc.getNumeros()).append("operacao", calc.getOperacao()).append("resultado", calc.getResultado());
        ObjectId id = calculos.insertOne(calculo).getInsertedId().asObjectId().getValue();
    }

    public List<Calculo> buscarTudo() {
        FindIterable<Document> calculos1 = calculos.find();
        List<Calculo> calcs = new ArrayList<>();
        for (Document doc : calculos1) {
            Calculo calc = new Calculo();
            calc = new Gson().fromJson(doc.toJson(), Calculo.class);
            calcs.add(calc);
        }
        return calcs;
    }

    public Calculo buscarUltimo(int mode){
        FindIterable<Document> ultimo = calculos.find().sort(new Document("_id",-1)).limit(1);
        Calculo calc = new Gson().fromJson(ultimo.first().toJson(),Calculo.class);
            if(mode == 1){
                System.out.println("=================\nULTIMO CALCULO: \nNumeros: "+calc.getNumeros().toString()+"\nOperacao: "+calc.getOperacao()+"\nResultado: "+calc.getResultado()+"\n========================");
            }

        return calc;
    }

//    public
}
