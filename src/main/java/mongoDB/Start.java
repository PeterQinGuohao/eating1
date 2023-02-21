package mongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Start {
    static String uri = "mongodb+srv://guohaoqin1:qinguohao1998@cluster0.hecgfzr.mongodb.net/?retryWrites=true&w=majority";
    static String databaseName = "storyline";
    static String collectionName = "fit";
    public static MongoCollection<Document> collection;

    public static boolean setup() {
        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            collection = database.getCollection(collectionName);

        } catch (Exception e) {
            System.out.println("Can not setup.");
            return false;
        }
        return true;
    }

    public void insertDoc(Document doc) {
        collection.insertOne(doc);
    }

    public void insertManyDoc(List<Document> docs) {
        collection.insertMany(docs);
    }

    public Document getDay(String day) {
        Document myDay = collection.find(eq("date", day)).first();
        if (myDay == null) {
            throw new IndexOutOfBoundsException("Can not find the date.");
        }
        return  myDay;
    }

    public static void main( String[] args ) {
        setup();
        Document myDay = collection.find(eq("date", "20130209")).first();
        System.out.println(myDay.toJson());
    }
}
