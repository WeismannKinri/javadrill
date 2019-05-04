package kincolle;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.codecs.lucene80.Lucene80DocValuesFormat;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DocValuesType;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.IOException;
import java.nio.file.Paths;


public class Index {


    public static void main(String[] args) throws IOException {
        IndexTest();
    }
    /**
     * 创建索引
     */
    public static void  IndexTest() throws IOException {
        Document doc=new Document();


        FieldType num=new FieldType();
        num.setStored(true);//设置存储
        num.setIndexOptions(IndexOptions.DOCS);//设置索引类型
        num.setDocValuesType(DocValuesType.NUMERIC);//DocValue类型

        doc.add(new SortedDocValuesField("id",new BytesRef("01011")));


//        doc.add(new LongField("id", 1, Field.Store.YES));
        doc.add(new TextField("title", "如何学习lucene", Field.Store.YES));
        doc.add(new TextField("content", "掌握原理，熟悉API，多看文档", Field.Store.YES));
        Directory dir=FSDirectory.open(Paths.get("D:\\lucene"));

        Analyzer analyzer=new StandardAnalyzer();
        IndexWriterConfig config=new IndexWriterConfig(analyzer);
        config.setUseCompoundFile(false);
        IndexWriter index=new IndexWriter(dir, config);


        Lucene80DocValuesFormat lucene80DocValuesFormat= new Lucene80DocValuesFormat();

        index.addDocument(doc);
        index.close();
    }
}
