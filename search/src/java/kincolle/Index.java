package kincolle;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;


public class Index {


    public static void main(String[] args) throws IOException {
        IndexTest();
    }

    /**
     * 创建索引
     */
    public static void IndexTest() throws IOException {
        Document doc = new Document();
//        doc.add(new LongField("id", 1, Field.Store.YES));
        doc.add(new TextField("title", "如何学习lucene", Field.Store.YES));
        doc.add(new TextField("content", "掌握原理，熟悉API，多看文档", Field.Store.YES));
        Directory dir = FSDirectory.open(Paths.get("D:\\lucene"));

        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter index = new IndexWriter(dir, config);
        index.addDocument(doc);
        index.close();
    }
}
