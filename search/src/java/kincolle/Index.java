package kincolle;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;


public class Index {


    public static void main(String[] args) throws IOException {
        String a = null;
        IndexTest();
        System.out.println(Integer.BYTES);
    }

    /**
     * 创建索引
     */
    public static void IndexTest() throws IOException {
        Document doc = new Document();
//        doc.add(new LongField("id", 1, Field.Store.YES));
        doc.add(new TextField("title", "如何学习lucene", Field.Store.YES));
        Document doc2 = new Document();
        doc2.add(new TextField("content", "掌握原理，熟悉API，多看文档", Field.Store.YES));
        Document doc3 = new Document();
        doc3.add(new IntPoint("int", 1));

        int[] min = new int[]{1};
        int[] max = new int[]{2};
        doc.add(new IntRange("IntRange", min,max));
        doc.add(new IntRangeDocValuesField("IntRangeDocValuesField", min,max));
        doc.add(new SortedNumericDocValuesField("SortedNumericDocValuesField", 1));

        Directory dir = FSDirectory.open(Paths.get("D:\\lucene"));

        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter index = new IndexWriter(dir, config);
        index.addDocument(doc);

        index.close();
    }
}
