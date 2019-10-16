package kincolle;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


/**
 * @Description: lucene 搜索基本流程示例
 * @author nb
 * @date 2018年5月11日
 *
 */

public class SearchBaseFlow {

    public static void main(String[] args)
            throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException {
        // 使用的分词器
        Analyzer analyzer = new StandardAnalyzer();
        // 索引存储目录
        Directory directory = FSDirectory.open(Paths.get("f:/test/indextest"));
        // 索引读取器
        IndexReader indexReader = DirectoryReader.open(directory);
//        IndexReader indexReader = DirectoryReader.openIfChanged(directory);
//        DirectoryReader indexReader = DirectoryReader.open(directory);
        // 索引搜索器
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        // 要搜索的字段
        String filedName = "name";


//        Term aaa = new Term("");
//        TermQuery a= new TermQuery(aaa);



        // 查询生成器（解析输入生成Query查询对象）
        QueryParser parser = new QueryParser(filedName, analyzer);

        // 通过parse解析输入（分词），生成query对象
//        Query query = a;
        Query query = parser.parse("Thinkpad");
        // 搜索，得到TopN的结果（结果中有命中总数，topN的scoreDocs（评分文档（文档id，评分）））



        Query query2=new TermQuery(new Term("searchField"));
        BooleanQuery.Builder  builder=new BooleanQuery.Builder();
        //  1．MUST和MUST：取得连个查询子句的交集。
        //  2．MUST和MUST_NOT：表示查询结果中不能包含MUST_NOT所对应得查询子句的检索结果。
        // 3．SHOULD与MUST_NOT：连用时，功能同MUST和MUST_NOT。
        // 4．SHOULD与MUST连用时，结果为MUST子句的检索结果,但是SHOULD可影响排序。
        // 5．SHOULD与SHOULD：表示“或”关系，最终检索结果为所有检索子句的并集。
        // 6．MUST_NOT和MUST_NOT：无意义，检索无结果。
        builder.add(query, BooleanClause.Occur.MUST);
        builder.add(query2, BooleanClause.Occur.MUST);
        BooleanQuery  booleanQuery=builder.build();



        TopDocs topDocs = indexSearcher.search(booleanQuery, 10); // 前10条

        // 获得总命中数
        System.out.println(topDocs.totalHits);
        // 遍历topN结果的scoreDocs,取出文档id对应的文档信息
        for (ScoreDoc sdoc : topDocs.scoreDocs) {
            // 根据文档id取存储的文档
            Document hitDoc = indexSearcher.doc(sdoc.doc);
            // 取文档的字段
            System.out.println(hitDoc.get(filedName));
        }

        // 使用完毕，关闭、释放资源
        indexReader.close();
        directory.close();
    }
}