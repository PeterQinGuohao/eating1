

import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class Create {
    String uri = "mongodb+srv://guohaoqin1:qinguohao1998@cluster0.hecgfzr.mongodb.net/?retryWrites=true&w=majority";
    public void CreateOne(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");

            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("title", "Ski Bloopers")
                        .append("genres", Arrays.asList("Documentary", "Comedy")));

                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
    }
    private static Document generateNewObject(String date, Arrays summary, Arrays segments, int caloriesIdle, String lastUpdate){
        Document toadd = new Document()
                .append("_id", new ObjectId())
                .append("date", date)
                .append("summary", Arrays.asList("Documentary", "Comedy"))
                .append("summary", Arrays.asList("Documentary", "Comedy"))
                .append("caloriesIdle", caloriesIdle)
                .append("lastUpdate", lastUpdate);
        return toadd;
    }
}


